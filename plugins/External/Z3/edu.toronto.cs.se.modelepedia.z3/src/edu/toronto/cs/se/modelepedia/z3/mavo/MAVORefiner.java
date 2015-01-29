/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 *    Alessio Di Sandro - Generalization to all metamodels.
 */
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Bool;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3ReasoningEngine;

public class MAVORefiner {

	private static final @NonNull String REFINED_MODEL_SUFFIX = "_refined";
	private static final @NonNull String MODELRELTYPE_URI = "http://se.cs.toronto.edu/mmint/MAVORefinementRel";
	private static final @NonNull String MODELREL_NAME = "refinement";
	private static final @NonNull String REFINED_LINK_NAME = "refined";
	private static final @NonNull String DELETED_LINK_NAME = "deleted";

	private Z3ReasoningEngine reasoner;

	public MAVORefiner(@NonNull Z3ReasoningEngine reasoner) {

		this.reasoner = reasoner;
	}

	private @NonNull Map<String, MAVOElement> getModelObjectsToRefine(@NonNull MAVOModel rootModelObj, @NonNull MAVOModel refinedRootModelObj, @NonNull String refinedModelUri, @NonNull Map<MAVOElement, MAVOElement> refinementMap) {

		Map<String, MAVOElement> modelObjsToRefine = new HashMap<String, MAVOElement>();
		Resource refinedResource = refinedRootModelObj.eResource();
		TreeIterator<EObject> iter = rootModelObj.eAllContents();
		while (iter.hasNext()) {
			EObject modelObj = iter.next();
			// skip non-may elements
			if (!(modelObj instanceof MAVOElement) || !((MAVOElement) modelObj).isMay()) {
				continue;
			}
			String modelObjUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, MIDLevel.INSTANCES)[1];
			String refinedModelObjUri = refinedModelUri + modelObjUri.substring(modelObjUri.lastIndexOf(MMINT.ECORE_MODEL_URI_SEPARATOR));
			MAVOElement refinedModelObj;
			try {
				refinedModelObj = (MAVOElement) MultiModelTypeIntrospection.getPointer(refinedResource, refinedModelObjUri);
			}
			catch (Exception e) {
				MMINTException.print(Type.WARNING, "Can't get model object " + refinedModelObjUri + ", skipping it", e);
				continue;
			}
			modelObjsToRefine.put(refinedModelObj.getFormulaVariable(), refinedModelObj);
			refinementMap.put(refinedModelObj, (MAVOElement) modelObj);
		}

		return modelObjsToRefine;
	}

	/**
	 * Calculates the refinement. 
	 * @param graph
	 * @return
	 * @throws MMINTException 
	 */
	private @NonNull Map<String, MAVOTruthValue> runZ3SMTSolver(@NonNull Map<String, MAVOElement> modelObjsToRefine, @NonNull String smtEncoding) throws MMINTException {

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		Z3Model z3Model = z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		if (z3Model.getZ3Bool() != Z3Bool.SAT) {
			throw new MMINTException("Refinement is UNSAT");
		}
		Map<String, MAVOTruthValue> refinedTruthValues = new HashMap<String, MAVOTruthValue>();
		// for each element, assert it and check
		for (Entry<String, MAVOElement> entry : modelObjsToRefine.entrySet()) {
			String formulaVar = entry.getKey();
			MAVOElement modelObj = entry.getValue();
			String smtConstraint;
			try {
				smtConstraint = reasoner.getSMTLIBMAVOModelObjectEncoding(modelObj);
			}
			catch (MMINTException e) {
				MMINTException.print(Type.WARNING, "Can't generate SMTLIB encoding for the current mavo model object, skipping it", e);
				continue;
			}
			MAVOTruthValue refinedTruthValue = reasoner.checkMAVOConstraintEncodingLoaded(z3IncSolver, smtConstraint);
			refinedTruthValues.put(formulaVar, refinedTruthValue);
		}

		return refinedTruthValues;
	}

	/**
	 * Takes a map of model elements and their new MAVOTruthValues and changes the model accordingly.
	 * @param graph
	 * @param refinedModel
	 */
	private void refineModel(@NonNull Map<String, MAVOElement> modelObjsToRefine, @NonNull Map<String, MAVOTruthValue> refinedTruthValues, @NonNull Map<MAVOElement, MAVOElement> refinementMap) {

		//TODO MMINT[MU-MMINT] Generalize for Var
		for (Entry<String, MAVOTruthValue> entry : refinedTruthValues.entrySet()) {
			MAVOElement refinedModelObj = modelObjsToRefine.get(entry.getKey());
			switch (entry.getValue()) {
				case TRUE:
					refinedModelObj.setMay(false);
					//TODO MMINT[MU-MMINT] Need to detect when a decision is made automatically, e.g. choice of an element has cascading effects to the alternatives
					Iterator<MAVOCollection> iter = refinedModelObj.getCollections().iterator();
					while (iter.hasNext()) {
						MAVOCollection mavoCollection = iter.next();
						if (mavoCollection.eContainer() instanceof MayDecision) {
							iter.remove();
						}
					}
					break;
				case FALSE:
					EcoreUtil.delete(refinedModelObj, true);
					refinementMap.put(refinementMap.remove(refinedModelObj), null);
					break;
				case MAYBE:
				default:
					// no refinement
					refinementMap.remove(refinedModelObj);
			}
		}
	}

	private void refineMayDecision(MAVOModel refinedRootModelObj, MAVOCollection mayAlternative) {

		MayDecision mayDecision = (MayDecision) mayAlternative.eContainer();
		String mayDecisionFormulaVar = mayDecision.getFormulaVariable();
		for (MAVODecision mayDecisionToDelete : refinedRootModelObj.getDecisions()) {
			if (!(mayDecisionToDelete instanceof MayDecision)) {
				continue;
			}
			if (mayDecisionFormulaVar.equals(mayDecisionToDelete.getFormulaVariable())) {
				EcoreUtil.delete(mayDecisionToDelete, true);
				break;
			}
		}
	}

	private void populateRefinementRel(@NonNull ModelRel refinementRel, @NonNull Map<MAVOElement, MAVOElement> refinementMap) {

		ModelEndpointReference modelEndpointRef = refinementRel.getModelEndpointRefs().get(0);
		ModelEndpointReference refinedModelEndpointRef = refinementRel.getModelEndpointRefs().get(1);
		Link refinementLinkType = refinementRel.getMetatype().getLinks().get(0);
		for (Entry<MAVOElement, MAVOElement> refinementEntry : refinementMap.entrySet()) {
			MAVOElement refinedModelObj = refinementEntry.getKey();
			MAVOElement modelObj = refinementEntry.getValue();
			if (modelObj == null) {
				modelObj = refinedModelObj;
				refinedModelObj = null;
			}
			boolean isBinary = false;
			String linkName = DELETED_LINK_NAME;
			EList<ModelElementReference> modelElemRefs = new BasicEList<ModelElementReference>();
			try {
				modelElemRefs.add(ModelElementImpl.createMAVOInstanceAndReference(modelObj, null, modelEndpointRef));
				if (refinedModelObj != null) {
					isBinary = true;
					linkName = REFINED_LINK_NAME;
					modelElemRefs.add(ModelElementImpl.createMAVOInstanceAndReference(refinedModelObj, null, refinedModelEndpointRef));
				}
				LinkReference refinementLinkRef = refinementLinkType.createInstanceAndReferenceAndEndpointsAndReferences(isBinary, modelElemRefs);
				refinementLinkRef.getObject().setName(linkName);
			}
			catch (MMINTException e) {
				MMINTException.print(Type.WARNING, "Can't create refinement link", e);
			}
		}
	}

	private void refineDiagram(org.eclipse.gmf.runtime.notation.Diagram refinedDiagram, @NonNull MAVOModel refinedRootModelObj, Map<MAVOElement, MAVOElement> refinementMap) {

		Map<String, View> refinedDiagramViews = GMFDiagramUtils.getDiagramViews(refinedDiagram);
		// remove views that are no longer in the diagram
		for (Entry<MAVOElement, MAVOElement> refinementEntry : refinementMap.entrySet()) {
			if (refinementEntry.getValue() != null) { // need only removal refinements
				continue;
			}
			String formulaVar = refinementEntry.getKey().getFormulaVariable();
			View diagramViewToRemove = refinedDiagramViews.get(formulaVar);
			EcoreUtil.delete(diagramViewToRemove, true);
		}
		// assign views to refined model objects
		TreeIterator<EObject> iter = refinedRootModelObj.eAllContents();
		while (iter.hasNext()) {
			EObject refinedModelObj = iter.next();
			//TODO MMINT[MAVO] What if the diagram has some non-mavo elements?
			if (!(refinedModelObj instanceof MAVOElement)) {
				continue;
			}
			String formulaVar = ((MAVOElement) refinedModelObj).getFormulaVariable();
			View diagramView = refinedDiagramViews.get(formulaVar);
			if (diagramView == null) { // can happen when some diagram views are in their default position
				continue;
			}
			diagramView.setElement(refinedModelObj);
		}
		refinedDiagram.setElement(refinedRootModelObj);
	}

	public @NonNull Model refine(@NonNull Model model, @Nullable Diagram modelDiagram, @Nullable MAVOCollection mayAlternative, @NonNull String smtEncoding) throws Exception {

		// create mid artifacts
		String refinedModelUri = MultiModelUtils.getUniqueUri(MultiModelUtils.addFileNameSuffixInUri(model.getUri(), REFINED_MODEL_SUFFIX), true, false);
		MultiModelUtils.copyTextFileAndReplaceText(model.getUri(), refinedModelUri, "", "", true);
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
		Model refinedModel = model.getMetatype().createMAVOInstance(refinedModelUri, ModelOrigin.CREATED, instanceMID);
		ModelRel modelRelType = MultiModelTypeRegistry.getType(MODELRELTYPE_URI);
		if (modelRelType == null) {
			MMINTException.print(Type.WARNING, "Can't find " + MODELRELTYPE_URI + " type, fallback to root ModelRel type", null);
			modelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		}
		EList<Model> modelEndpoints = new BasicEList<Model>();
		modelEndpoints.add(model);
		modelEndpoints.add(refinedModel);
		ModelRel refinementRel = modelRelType.createInstanceAndEndpointsAndReferences(null, ModelOrigin.CREATED, modelEndpoints);
		refinementRel.setName(MODELREL_NAME);

		// refine
		MAVOModel rootModelObj = (MAVOModel) MultiModelUtils.getModelFile(model.getUri(), true);
		MAVOModel refinedRootModelObj = (MAVOModel) MultiModelUtils.getModelFile(refinedModelUri, true);
		Map<MAVOElement, MAVOElement> refinementMap = new HashMap<MAVOElement, MAVOElement>();
		Map<String, MAVOElement> modelObjsToRefine = getModelObjectsToRefine(rootModelObj, refinedRootModelObj, refinedModelUri, refinementMap);
		Map<String, MAVOTruthValue> refinedTruthValues = runZ3SMTSolver(modelObjsToRefine, smtEncoding);
		refineModel(modelObjsToRefine, refinedTruthValues, refinementMap);
		if (mayAlternative != null) {
			refineMayDecision(refinedRootModelObj, mayAlternative);
		}
		populateRefinementRel(refinementRel, refinementMap);

		// write refinement to file
		MultiModelUtils.createModelFile(refinedRootModelObj, refinedModelUri, true);
		if (modelDiagram != null) {
			org.eclipse.gmf.runtime.notation.Diagram refinedDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(modelDiagram.getUri(), true);
			refineDiagram(refinedDiagram, refinedRootModelObj, refinementMap);
			String refinedModelDiagramUri = MultiModelUtils.replaceFileExtensionInUri(refinedModelUri, modelDiagram.getFileExtensions().get(0));
			MultiModelUtils.createModelFile(refinedDiagram, refinedModelDiagramUri, true);
			GMFDiagramUtils.openGMFDiagram(refinedModelDiagramUri, modelDiagram.getId(), true);
		}
		refinedModel.createInstanceEditor();

		return refinedModel;
	}

}
