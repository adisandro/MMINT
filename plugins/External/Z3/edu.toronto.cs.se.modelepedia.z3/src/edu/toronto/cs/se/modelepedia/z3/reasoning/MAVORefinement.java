/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.z3.reasoning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class MAVORefinement {

	private static final String REFINEMENT_SUFFIX = "_refined";
	private static final @NonNull String REFINEMENT_MODELRELTYPE_URI = "http://se.cs.toronto.edu/mmint/MAVORefinementRel";

	private Z3ReasoningEngine reasoner;

	public MAVORefinement(@NonNull Z3ReasoningEngine reasoner) {

		this.reasoner = reasoner;
	}

	private @NonNull Map<String, MAVOElement> getModelObjects(@NonNull MAVOModel rootModelObj) {

		TreeIterator<EObject> iter = rootModelObj.eAllContents();
		Map<String, MAVOElement> modelObjs = new HashMap<String, MAVOElement>();
		while (iter.hasNext()){
			EObject element = iter.next();
			if (element instanceof MAVOElement){
				modelObjs.put(((MAVOElement) element).getFormulaVariable(), (MAVOElement) element);
			}
		}

		return modelObjs;
	}

	/**
	 * Calculates the refinement. 
	 * @param graph
	 * @return
	 */
	private @NonNull Map<String, MAVOTruthValue> runZ3SMTSolver(@NonNull Map<String, MAVOElement> modelObjs, @NonNull String smtEncoding) {

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		Map<String, MAVOTruthValue> refinedObjs = new HashMap<String, MAVOTruthValue>();
		// for each element, assert it and check
		for (Entry<String, MAVOElement> entry : modelObjs.entrySet()) {
			String formulaVar = entry.getKey();
			MAVOElement modelObj = entry.getValue();
			String smtConstraint = null;
			if (modelObj.eClass().getEAnnotation("gmf.node") != null) {
				smtConstraint = Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, formulaVar);
			}
			else if (modelObj.eClass().getEAnnotation("gmf.link") != null) {
				smtConstraint = Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, formulaVar);
			}
			else {
				continue;
			}
			MAVOTruthValue refinedTruthValue = reasoner.checkMAVOConstraintEncodingLoaded(z3IncSolver, smtConstraint);
			refinedObjs.put(formulaVar, refinedTruthValue);
		}

		return refinedObjs;
	}

	/**
	 * Takes a map of model elements and their new MAVOTruthValues and changes the model accordingly.
	 * @param graph
	 * @param refinedModel
	 */
	private void refineModel(@NonNull Map<String, MAVOElement> modelObjs, @NonNull Map<String, MAVOTruthValue> refinedObjs) {

		for (Entry<String, MAVOTruthValue> entry : refinedObjs.entrySet()) {
			MAVOElement modelObj = modelObjs.get(entry.getKey());
			switch (entry.getValue()) {
				case TRUE:
					modelObj.setMay(false);
					modelObj.getAlternatives().clear();
					break;
				case MAYBE:
					modelObj.setMay(true);
					break;
				case FALSE:
				default:
					EcoreUtil.delete(modelObj);
			}
		}
	}

	public void refine(@NonNull Model model, @Nullable Diagram modelDiagram, @NonNull String smtEncoding) throws Exception {

		//TODO: populate model rel, check exceptions thrown
		// refine
		smtEncoding += Z3Utils.assertion(model.getConstraint().getImplementation());
		MAVOModel rootModelObj = (MAVOModel) MultiModelUtils.getModelFile(model.getUri(), true);
		Map<String, MAVOElement> modelObjs = getModelObjects(rootModelObj);
		Map<String, MAVOTruthValue> refinedObjs = runZ3SMTSolver(modelObjs, smtEncoding);
		refineModel(modelObjs, refinedObjs);

		// write refinement to file
		String refinedModelUri = MultiModelUtils.addFileNameSuffixInUri(model.getUri(), REFINEMENT_SUFFIX);
		MultiModelUtils.createModelFile(rootModelObj, refinedModelUri, true);
		if (modelDiagram != null) {
			String refinedModelDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), REFINEMENT_SUFFIX);
			String diagramKind = model.getMetatype().getName();
			String diagramPluginId = MultiModelTypeRegistry.getTypeBundle(modelDiagram.getMetatypeUri()).getSymbolicName();
			GMFDiagramUtils.createGMFDiagram(refinedModelUri, refinedModelDiagramUri, diagramKind, diagramPluginId, true);
			GMFDiagramUtils.openGMFDiagram(refinedModelDiagramUri, modelDiagram.getId(), true);
		}

		// create mid artifacts
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
		Model refinedModel = model.getMetatype().createMAVOInstanceAndEditor(refinedModelUri, ModelOrigin.CREATED, instanceMID);
		ModelRel modelRelType = MultiModelTypeRegistry.getType(REFINEMENT_MODELRELTYPE_URI);
		if (modelRelType == null) {
			MMINTException.print(Type.WARNING, "Can't find MAVORefinementRel type, fallback to ModelRel type", null);
			modelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		}
		EList<Model> modelEndpoints = new BasicEList<Model>();
		modelEndpoints.add(model);
		modelEndpoints.add(refinedModel);
		modelRelType.createInstanceAndEndpointsAndReferences(null, ModelOrigin.CREATED, modelEndpoints);
	}

}
