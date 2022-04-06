/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOGMFDiagramUtils;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3Reasoner;

public class MAVORefiner {

	private static final @NonNull String REFINED_MODEL_SUFFIX = "_refined";
	private static final @NonNull String MODELRELTYPE_URI = "http://se.cs.toronto.edu/mmint/MAVORefinementRel";
	private static final @NonNull String MODELREL_NAME = "refinement";
	private static final @NonNull String REFINED_LINK_NAME = "refined";
	private static final @NonNull String DELETED_LINK_NAME = "deleted";

	private Z3Reasoner reasoner;

	public MAVORefiner(@NonNull Z3Reasoner reasoner) {

		this.reasoner = reasoner;
	}

	private @NonNull Map<String, MAVOElement> getModelObjectsToRefine(@NonNull MAVORoot rootModelObj, @NonNull MAVORoot refinedRootModelObj, @NonNull String refinedModelUri, @NonNull Map<MAVOElement, MAVOElement> refinementMap) {

		Map<String, MAVOElement> modelObjsToRefine = new HashMap<>();
		var refinedResource = refinedRootModelObj.eResource();
		var iter = rootModelObj.eAllContents();
		while (iter.hasNext()) {
			var modelObj = iter.next();
			// skip non-may elements
			if (!(modelObj instanceof MAVOElement) || !((MAVOElement) modelObj).isMay()) {
				continue;
			}
			String modelObjUri = MIDRegistry.getModelElementUri(modelObj);
			var refinedModelObjUri = refinedModelUri + modelObjUri.substring(modelObjUri.lastIndexOf(MMINTConstants.ECORE_MODEL_URI_SEPARATOR));
			MAVOElement refinedModelObj;
			try {
				refinedModelObj = (MAVOElement) FileUtils.readModelObject(refinedModelObjUri, refinedResource);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Can't get model object " + refinedModelObjUri + ", skipping it", e);
				continue;
			}
			modelObjsToRefine.put(refinedModelObj.getFormulaVariable(), refinedModelObj);
			refinementMap.put(refinedModelObj, (MAVOElement) modelObj);
		}

		return modelObjsToRefine;
	}

	/**
	 * Takes a map of model elements and their new MAVOTruthValues and changes the model accordingly.
	 */
	private void refineModel(@NonNull Map<String, MAVOElement> modelObjsToRefine, @NonNull Map<String, MAVOTruthValue> refinedTruthValues, @NonNull Map<MAVOElement, MAVOElement> refinementMap) {

		//TODO MMINT[MU-MMINT] Generalize for Var
		for (Entry<String, MAVOTruthValue> entry : refinedTruthValues.entrySet()) {
			var refinedModelObj = modelObjsToRefine.get(entry.getKey());
			switch (entry.getValue()) {
				case TRUE:
					refinedModelObj.setMay(false);
					//TODO MMINT[MU-MMINT] Need to detect when a decision is made automatically, e.g. choice of an element has cascading effects to the alternatives
					var iter = refinedModelObj.getCollections().iterator();
					while (iter.hasNext()) {
						var mavoCollection = iter.next();
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

	private void refineMayDecision(MAVORoot refinedRootModelObj, MAVOCollection mayAlternative) {

		var mayDecision = (MayDecision) mayAlternative.eContainer();
		var mayDecisionFormulaVar = mayDecision.getFormulaVariable();
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

		var modelEndpointRef = refinementRel.getModelEndpointRefs().get(0);
		var refinedModelEndpointRef = refinementRel.getModelEndpointRefs().get(1);
		// TODO MMINT[MODELREL] It should really be simple to get this with inheritance (MAVORefinementRel has 0 mappings, but the supertype has them)
		var refinementMappingType = refinementRel.getMetatype().getMappingRefs().get(0).getObject();
		for (Entry<MAVOElement, MAVOElement> refinementEntry : refinementMap.entrySet()) {
			var refinedModelObj = refinementEntry.getKey();
			var modelObj = refinementEntry.getValue();
			if (modelObj == null) {
				modelObj = refinedModelObj;
				refinedModelObj = null;
			}
			var isBinary = false;
			String linkName = MAVORefiner.DELETED_LINK_NAME;
			EList<ModelElementReference> modelElemRefs = new BasicEList<>();
			try {
				modelElemRefs.add(modelEndpointRef.createModelElementInstanceAndReference(modelObj, null));
				if (refinedModelObj != null) {
					isBinary = true;
					linkName = MAVORefiner.REFINED_LINK_NAME;
					modelElemRefs.add(refinedModelEndpointRef.createModelElementInstanceAndReference(refinedModelObj, null));
				}
				var refinementMappingRef = refinementMappingType.createInstanceAndReferenceAndEndpointsAndReferences(isBinary, modelElemRefs);
				refinementMappingRef.getObject().setName(linkName);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Can't create refinement link", e);
			}
		}
	}

	private void refineDiagram(org.eclipse.gmf.runtime.notation.Diagram refinedDiagram, @NonNull MAVORoot refinedRootModelObj, Map<MAVOElement, MAVOElement> refinementMap) {

		Map<String, View> refinedDiagramViews = MAVOGMFDiagramUtils.getDiagramViews(refinedDiagram);
		// remove views that are no longer in the diagram
		for (Entry<MAVOElement, MAVOElement> refinementEntry : refinementMap.entrySet()) {
			if (refinementEntry.getValue() != null) { // need only removal refinements
				continue;
			}
			var formulaVar = refinementEntry.getKey().getFormulaVariable();
			var diagramViewToRemove = refinedDiagramViews.get(formulaVar);
			EcoreUtil.delete(diagramViewToRemove, true);
		}
		// assign views to refined model objects
		var iter = refinedRootModelObj.eAllContents();
		while (iter.hasNext()) {
			var refinedModelObj = iter.next();
			//TODO MMINT[MAVO] What if the diagram has some non-mavo elements?
			if (!(refinedModelObj instanceof MAVOElement)) {
				continue;
			}
			var formulaVar = ((MAVOElement) refinedModelObj).getFormulaVariable();
			var diagramView = refinedDiagramViews.get(formulaVar);
			if (diagramView == null) { // can happen when some diagram views are in their default position
				continue;
			}
			diagramView.setElement(refinedModelObj);
		}
		refinedDiagram.setElement(refinedRootModelObj);
	}

	public @NonNull Model refine(@NonNull Model model, @Nullable Diagram modelDiagram, @Nullable MAVOCollection mayAlternative, @NonNull String smtEncoding, @Nullable Z3MAVOModelParser z3ModelParser) throws Exception {

		// create mid artifacts
		String refinedModelPath = FileUtils.getUniquePath(FileUtils.addFileNameSuffixInPath(model.getUri(), MAVORefiner.REFINED_MODEL_SUFFIX), true, false);
		FileUtils.copyTextFileAndReplaceText(model.getUri(), refinedModelPath, "", "", true);
		var instanceMID = model.getMIDContainer();
		var refinedModel = model.getMetatype().createInstance(null, refinedModelPath, instanceMID);
		ModelRel modelRelType = MIDTypeRegistry.getType(MAVORefiner.MODELRELTYPE_URI);
		if (modelRelType == null) {
			MMINTException.print(IStatus.WARNING, "Can't find " + MAVORefiner.MODELRELTYPE_URI + " type, fallback to root ModelRel type", null);
			modelRelType = MIDTypeHierarchy.getRootModelRelType();
		}
		var refinementRel = modelRelType.createBinaryInstanceAndEndpoints(
			null,
			MAVORefiner.MODELREL_NAME,
			model,
			refinedModel,
			instanceMID);

		// refine
		var rootModelObj = (MAVORoot) FileUtils.readModelFile(model.getUri(), null, true);
		var refinedRootModelObj = (MAVORoot) FileUtils.readModelFile(refinedModelPath, null, true);
		Map<MAVOElement, MAVOElement> refinementMap = new HashMap<>();
		Map<String, MAVOElement> modelObjsToRefine = this.getModelObjectsToRefine(rootModelObj, refinedRootModelObj, refinedModelPath, refinementMap);
		Map<String, MAVOTruthValue> refinedTruthValues = this.reasoner.mayBackbone(smtEncoding, z3ModelParser, new HashSet<>(modelObjsToRefine.values()));
		this.refineModel(modelObjsToRefine, refinedTruthValues, refinementMap);
		if (mayAlternative != null) {
			this.refineMayDecision(refinedRootModelObj, mayAlternative);
		}
		this.populateRefinementRel(refinementRel, refinementMap);

		// write refinement to file
		FileUtils.writeModelFile(refinedRootModelObj, refinedModelPath, null, true);
		if (modelDiagram != null) {
			var refinedDiagram = (org.eclipse.gmf.runtime.notation.Diagram) FileUtils.readModelFile(modelDiagram.getUri(), null, true);
			this.refineDiagram(refinedDiagram, refinedRootModelObj, refinementMap);
			String refinedModelDiagramUri = FileUtils.replaceFileExtensionInPath(refinedModelPath, modelDiagram.getFileExtensions().get(0));
			FileUtils.writeModelFile(refinedDiagram, refinedModelDiagramUri, null, true);
			FileUtils.openEclipseEditor(refinedModelDiagramUri, modelDiagram.getId(), true);
		}
		refinedModel.createInstanceEditor(false);

		return refinedModel;
	}

}
