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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTModel;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTIncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIBListener;

public class MAVOConcretizationHighlighter {

	private static final int GREYOUT_COLOR = 0xF4F4F4;
	private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
	private static final String DIAGRAM_ID = "edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorID";
	private static final String EXAMPLE_SUFFIX = "_example";
	
	private MAVOTruthValue resultMAVO;
	private String smtEncoding;
	private Map<Integer, String> smtEncodingEdges;
	private Map<Integer, String> smtEncodingNodes;
	private String newDiagramURI;
	private String smtProperty;
	private Map<String, View> diagramElements;

	public MAVOConcretizationHighlighter(EcoreMAVOToSMTLIBListener smtListener) {
		
		resultMAVO = MAVOTruthValue.ERROR;
		smtEncoding = smtListener.getSMTLIBEncoding();
		
		smtEncodingEdges = smtListener.getSMTLIBEncodingEdges();
		smtEncodingNodes = smtListener.getSMTLIBEncodingNodes();
		
		diagramElements = new HashMap<String, View>();

	}

	public void highlightExample(Model model) throws Exception {

		smtProperty = model.getConstraint().getImplementation();
		resultMAVO = Z3SMTReasoningEngine.checkMAVOProperty(smtEncoding, smtProperty);
		
		if (resultMAVO != MAVOTruthValue.MAYBE){
			return;
		}
		
		//Load diagram
		Diagram d = copyAndLoadDiagram(model);

		//Get view elements from diagram
		@SuppressWarnings("unchecked")
		Map<String, View> modelNodes = collectFormulaIDs((EList<View>) d.getChildren());
		@SuppressWarnings("unchecked")
		Map<String, View> modelEdges = collectFormulaIDs((EList<View>) d.getEdges());
		diagramElements.putAll(modelNodes);
		diagramElements.putAll(modelEdges);

		Z3SMTModel resultModel = runZ3SMTSolver();
		
		//get FormulaIDs of elements to be grayed out and highlighted
		ArrayList<Set<String>> separatedDiagram = separateExampleElements(resultModel);
		Set<String> notInExample = separatedDiagram.get(1);
		
		//grey out anything that's not in the example
		for (String FID : notInExample){
			View element = diagramElements.get(FID);
			MAVOUtils.colorElement(element, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
		}
		
		//Write diagram to file
		MultiModelUtils.createModelFile(d, newDiagramURI, true);
		GMFDiagramUtils.openGMFDiagram(newDiagramURI, DIAGRAM_ID, true);

	}
	
	/**
	 * Separate the diagram elements into the set of elements that appear in the 
	 * resultModel concretization, and the remaining set.
	 * @param resultModel - a concretization of the model
	 * @return An array of size 2 in which the first element is the set of diagram FormulaIDs included in the diagram, 
	 * and the second element is the set containing all of the remaining diagram FormulaIDs.
	 */
	private ArrayList<Set<String>> separateExampleElements(Z3SMTModel resultModel){
		Map<String, Integer> resultModelEdges = resultModel.getZ3ModelEdges(smtEncodingEdges);
		Map<String, Integer> resultModelNodes = resultModel.getZ3ModelNodes(smtEncodingNodes);
		
		Set<String> remainingElements = new HashSet<String>(diagramElements.keySet());
		Set<String> exampleElements = new HashSet<String>();
		//remove FormulaIDs of elements in example
		for (Integer intID: resultModelEdges.values()){
			String FID = smtEncodingEdges.get(intID);
			exampleElements.add(FID);
			remainingElements.remove(FID);
		} 
		for (Integer intID: resultModelNodes.values()){
			String FID = smtEncodingNodes.get(intID);
			exampleElements.add(FID);
			remainingElements.remove(FID);
		}
		ArrayList<Set<String>> separated = new ArrayList<Set<String>>();
		separated.add(exampleElements);
		separated.add(remainingElements);
		return separated;
	}

	/**
	 * Create a copy of the original diagram and return the copy
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	private Diagram copyAndLoadDiagram(Model model) throws MMINTException{

		String diagramURI = MultiModelUtils.replaceFileExtensionInUri(
			model.getUri(),
			"graphdiag_mavo"
		);

		newDiagramURI = MultiModelUtils.addFileNameSuffixInUri(diagramURI, EXAMPLE_SUFFIX);

		try {
			MultiModelUtils.copyTextFileAndReplaceText(diagramURI, newDiagramURI, "", "", true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		Diagram d;
		try{
			d = (Diagram) MultiModelUtils.getModelFile(newDiagramURI, true);
		} catch (Exception e) {
			throw new MMINTException("There is no diagram!", e);
		}
		return d;
	}
	
	private Z3SMTModel runZ3SMTSolver(){
		Z3SMTIncrementalSolver z3Solver = new Z3SMTIncrementalSolver();
		z3Solver.firstCheckSatAndGetModel(smtEncoding);
		Z3SMTModel resultModel = z3Solver.checkSatAndGetModel(Z3SMTUtils.assertion(smtProperty), Z3IncrementalBehavior.POP);
		return resultModel;
	}
	
	/**
	 * Map diagram view elements to the formula IDs of the model elements they represent.
	 * @param elementList - List of View elements from the diagram.
	 * @return a Map whose keys are formula IDs, and the values are the view elements representing those elements of the model.
	 */
	private Map<String, View> collectFormulaIDs(EList<View> elementList){
		Map<String, View> modelElements = new HashMap<String, View>();
		for (View element: elementList){
			MAVOElement modelElement = (MAVOElement) element.getElement();
			modelElements.put(modelElement.getFormulaVariable(), element);
		}
		return modelElements;
	}
	
}
