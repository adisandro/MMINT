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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOConcretizationHighlighter {

	private static final int GREYOUT_COLOR = 0xF4F4F4;
	private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
	private static final String EXAMPLE_SUFFIX = "_example";

	/**
	 * Map diagram view elements to the formula IDs of the model elements they represent.
	 * @param diagramViewList - List of View elements from the diagram.
	 * @return a Map whose keys are formula IDs, and the values are the view elements representing those elements of the model.
	 */
	private Map<String, View> collectFormulaVars(EList<View> diagramViewList) {

		Map<String, View> diagramViews = new HashMap<String, View>();
		for (View diagramView : diagramViewList) {
			EObject modelObj = diagramView.getElement();
			if (!(modelObj instanceof MAVOElement)) {
				continue;
			}
			diagramViews.put(((MAVOElement) modelObj).getFormulaVariable(), diagramView);
		}

		return diagramViews;
	}

	private Set<String> separateExampleElements(Map<String, String> z3ModelElems, Map<String, View> diagramViews) {

		Set<String> notInExampleFormulaVars = new HashSet<String>(diagramViews.keySet());
		for (String formulaVar : z3ModelElems.values()) {
			notInExampleFormulaVars.remove(formulaVar);
		}

		return notInExampleFormulaVars;
	}

	@SuppressWarnings("unchecked")
	public void highlightCounterExample(Diagram modelDiagram, Map<String, String> z3ModelElems) throws Exception {

		// copy diagram
		String exampleDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), EXAMPLE_SUFFIX);
		MultiModelUtils.copyTextFileAndReplaceText(modelDiagram.getUri(), exampleDiagramUri, "", "", true);
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(exampleDiagramUri, true);
		// get view elements from diagram
		Map<String, View> diagramViews = new HashMap<String, View>();
		diagramViews.putAll(collectFormulaVars((EList<View>) exampleDiagram.getChildren()));
		diagramViews.putAll(collectFormulaVars((EList<View>) exampleDiagram.getEdges()));
		// grey out anything that's not in the example
		Set<String> notInExampleFormulaVars = separateExampleElements(z3ModelElems, diagramViews);
		for (String notInExampleFormulaVar : notInExampleFormulaVars) {
			View diagramView = diagramViews.get(notInExampleFormulaVar);
			GMFDiagramUtils.colorDiagramElement(diagramView, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
		}
		// write diagram to file
		MultiModelUtils.createModelFile(exampleDiagram, exampleDiagramUri, true);
		GMFDiagramUtils.openGMFDiagram(exampleDiagramUri, modelDiagram.getId(), true);
	}

}
