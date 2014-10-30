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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;

public class MAVOConcretizationHighlighter {

	private static final int GREYOUT_COLOR = 0xF4F4F4;
	private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
	private static final String DIAGRAM_ID = "edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorID";
	private static final String EXAMPLE_SUFFIX = "_example";

	private Z3MAVOModelParser z3ModelParser;
	private String newDiagramURI;
	private Map<String, View> diagramElements;

	public MAVOConcretizationHighlighter(Z3MAVOModelParser z3ModelParser) {

		this.z3ModelParser = z3ModelParser;
		diagramElements = new HashMap<String, View>();
	}

	public void highlightCounterExample(Model model, Z3Model resultModel) throws Exception {

		//Load diagram
		Diagram d = copyAndLoadDiagram(model);

		//Get view elements from diagram
		@SuppressWarnings("unchecked")
		Map<String, View> modelNodes = collectFormulaIDs((EList<View>) d.getChildren());
		@SuppressWarnings("unchecked")
		Map<String, View> modelEdges = collectFormulaIDs((EList<View>) d.getEdges());
		diagramElements.putAll(modelNodes);
		diagramElements.putAll(modelEdges);

		//get FormulaIDs of elements to be grayed out and highlighted
		ArrayList<Set<String>> separatedDiagram = separateExampleElements(resultModel);
		Set<String> notInExample = separatedDiagram.get(1);

		//grey out anything that's not in the example
		for (String FID : notInExample){
			View element = diagramElements.get(FID);
			GMFDiagramUtils.colorDiagramElement(element, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
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
	private ArrayList<Set<String>> separateExampleElements(Z3Model resultModel){

		Map<String, String> resultModelElems = z3ModelParser.getZ3MAVOModelElements(resultModel);
		Set<String> remainingElements = new HashSet<String>(diagramElements.keySet());
		Set<String> exampleElements = new HashSet<String>();
		//remove FormulaIDs of elements in example
		for (String FID: resultModelElems.values()) {
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
