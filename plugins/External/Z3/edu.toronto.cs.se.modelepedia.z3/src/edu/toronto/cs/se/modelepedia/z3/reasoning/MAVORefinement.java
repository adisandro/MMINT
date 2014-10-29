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
 */
package edu.toronto.cs.se.modelepedia.z3.reasoning;


import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.impl.MAVOModelImpl;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.impl.DiagramImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;

public class MAVORefinement {

	private static final String DIAGRAM_ID = "edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorID";
	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";

	private String smtProperty;
	private String smtEncoding;
	private String newDiagramURI;
	private Model model;
	private String newModelURI;

	public MAVORefinement(Model model) {
		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry
				.<Operator> getType(ECOREMAVOTOSMTLIB_OPERATOR_URI);
		EList<Model> actualParameters = new BasicEList<Model>();
		actualParameters.add(model);
		try {
			ecore2smt.execute(actualParameters);
		} catch (Exception e) {
			MMINTException.print(MMINTException.Type.ERROR,
					"Can't generate SMTLIB encoding, evaluating to false", e);
		}
		ecore2smt.cleanup();

		Z3MAVOModelParser z3ModelParser = ecore2smt.getZ3MAVOModelParser();
		this.smtEncoding = z3ModelParser.getSMTLIBEncoding();;
		this.model = model;
	}

	public void refine() throws Exception {
		smtProperty = model.getConstraint().getImplementation();
		MAVOTruthValue resultMAVO = Z3ReasoningEngine.checkMAVOConstraint(
				smtEncoding, smtProperty);

		if (resultMAVO != MAVOTruthValue.MAYBE) {
			return;
		}
		
		MAVOModelImpl graph = copyAndLoadModel(model);
		HashMap<String, MAVOElement> allElements = getAllElements(graph);

		HashMap<String, MAVOTruthValue> refinedElements = runZ3SMTSolver(allElements);
		refineModel(allElements, refinedElements);

		// Write diagram to file
		MultiModelUtils.createModelFile(graph, newModelURI, true);
		String diagramKind = MultiModelTypeRegistry.getType(model.getMetatypeUri()).getName();
		String diagramTypeURI = null;
		for (Editor editor: model.getEditors()){
			if (editor instanceof DiagramImpl){
				diagramTypeURI = editor.getMetatypeUri();
				break;
			}
		}
		String diagramPluginId = MultiModelTypeRegistry.getTypeBundle(diagramTypeURI).getSymbolicName();
		GMFDiagramUtils.createGMFDiagram(newModelURI, newDiagramURI, diagramKind, diagramPluginId, true);
		GMFDiagramUtils.openGMFDiagram(newDiagramURI,DIAGRAM_ID, true);
	}

	private HashMap<String, MAVOElement> getAllElements(MAVOModelImpl graph) {
		TreeIterator<EObject> iter = graph.eAllContents();
		HashMap<String, MAVOElement> allElements = new HashMap<String, MAVOElement>();
		while (iter.hasNext()){
			EObject element = iter.next();
			if (element instanceof MAVOElement){
				allElements.put(((MAVOElement) element).getFormulaVariable(), (MAVOElement) element);
			}
		}
		return allElements;
	}

	/**
	 * Takes a map of model elements and their new MAVOTruthValues and changes the model accordingly.
	 * @param graph
	 * @param refinedModel
	 */
	private void refineModel(HashMap<String, MAVOElement> originalModel, HashMap<String, MAVOTruthValue> refinement) {
		for (String formulaID: refinement.keySet()){
			MAVOTruthValue truthValue = refinement.get(formulaID);
			if (truthValue == MAVOTruthValue.TRUE){
				originalModel.get(formulaID).setMay(false);
			} else if (truthValue == MAVOTruthValue.MAYBE){
				originalModel.get(formulaID).setMay(true);
			} else if (truthValue == MAVOTruthValue.FALSE){
				MAVOElement element = originalModel.get(formulaID);
				EcoreUtil.delete(element);
			}
		}
	}

	/**
	 * Makes a copy of the model file and returns the copied model.
	 * @param model
	 * @return a copy of the model
	 * @throws MMINTException
	 */
	private MAVOModelImpl copyAndLoadModel(Model model)
			throws MMINTException {

		String diagramURI = MultiModelUtils.replaceFileExtensionInUri(
				model.getUri(), "graphdiag_mavo");

		String modelURI = MultiModelUtils.replaceFileExtensionInUri(
				model.getUri(), "graph_mavo");

		String suffix = "_refined";

		newModelURI = MultiModelUtils.addFileNameSuffixInUri(modelURI, suffix);
		newDiagramURI = MultiModelUtils.addFileNameSuffixInUri(diagramURI,
				suffix);

		try {
			MultiModelUtils.copyTextFileAndReplaceText(modelURI, newModelURI, "", "", true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		MAVOModelImpl graph;
		try {
			graph = (MAVOModelImpl) MultiModelUtils.getModelFile(newModelURI, true);
		} catch (Exception e) {
			throw new MMINTException("There is no model!", e);
		}
		return graph;
	}

	/**
	 * Calculates the refinement. 
	 * @param graph
	 * @return
	 */
	private HashMap<String, MAVOTruthValue> runZ3SMTSolver(HashMap<String, MAVOElement> originalModel) {
		//For each element, checks its MAVOTruthValue in the model with the new property.
		HashMap<String, MAVOTruthValue> refinedModel = new HashMap<String, MAVOTruthValue>();
		String encodingWithProperty = smtEncoding
				+ Z3Utils.assertion(smtProperty);
		for (String formulaID: originalModel.keySet()) {
			MAVOElement element = originalModel.get(formulaID);
			String elementFormula = null;
			if (element.eClass().getEAnnotation("gmf.node") != null){
				elementFormula = Z3Utils.predicate(
					Z3Utils.SMTLIB_NODE_FUNCTION, formulaID);
			}
			else if (element.eClass().getEAnnotation("gmf.link") != null){
				elementFormula = Z3Utils.predicate(
						Z3Utils.SMTLIB_EDGE_FUNCTION, formulaID);
			}
			else {
				continue;
			}
			MAVOTruthValue newTruthValue = Z3ReasoningEngine
					.checkMAVOConstraint(encodingWithProperty, elementFormula);
			refinedModel.put(formulaID, newTruthValue);
		}
		return refinedModel;
	}

}
