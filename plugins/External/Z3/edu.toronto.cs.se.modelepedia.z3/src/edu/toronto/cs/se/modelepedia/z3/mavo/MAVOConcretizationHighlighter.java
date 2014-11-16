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
package edu.toronto.cs.se.modelepedia.z3.mavo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.MayDecisionLogic;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOConcretizationHighlighter {

	private static final int HIGHLIGHT_COLOR = 0x1ACA1A;
	private static final int FONT_HIGHLIGHT_COLOR = 0x005600;
	private static final int GREYOUT_COLOR = 0xF4F4F4;
	private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
	private static final String EXAMPLE_MODEL_SUFFIX = "_example";

	private Set<String> separateExampleElements(Map<String, String> z3ModelElems, Map<String, View> diagramViews) {

		Set<String> notInExampleFormulaVars = new HashSet<String>(diagramViews.keySet());
		for (String formulaVar : z3ModelElems.values()) {
			notInExampleFormulaVars.remove(formulaVar);
		}

		return notInExampleFormulaVars;
	}

	public void highlightCounterExample(Diagram modelDiagram, Map<String, String> z3ModelElems) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(modelDiagram.getUri(), true);
		Map<String, View> diagramViews = GMFDiagramUtils.getDiagramFormulaVariables(exampleDiagram);

		// grey out model objects that are not in the example
		Set<String> notInExampleFormulaVars = separateExampleElements(z3ModelElems, diagramViews);
		for (String notInExampleFormulaVar : notInExampleFormulaVars) {
			View diagramView = diagramViews.get(notInExampleFormulaVar);
			GMFDiagramUtils.colorDiagramElement(diagramView, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
		}

		// write diagram to file
		String exampleDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		MultiModelUtils.createModelFile(exampleDiagram, exampleDiagramUri, true);
		GMFDiagramUtils.openGMFDiagram(exampleDiagramUri, modelDiagram.getId(), true);
	}

	public void highlightAlternative(Diagram modelDiagram, MAVOAlternative mayAlternative) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(modelDiagram.getUri(), true);
		Map<String, View> diagramViews = GMFDiagramUtils.getDiagramFormulaVariables(exampleDiagram);

		// grey out may model objects in other alternatives for the same decision, highlight may model objects in the alternative
		MayDecision mayDecision = (MayDecision) mayAlternative.eContainer();
		if (mayDecision.getLogic() == MayDecisionLogic.XOR) {
			for (MAVOAlternative otherMayAlternative : mayDecision.getAlternatives()) {
				if (otherMayAlternative == mayAlternative) {
					continue;
				}
				for (MAVOElement otherMayModelObj : otherMayAlternative.getMavoElements()) {
					View diagramView = diagramViews.get(otherMayModelObj.getFormulaVariable());
					GMFDiagramUtils.colorDiagramElement(diagramView, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
				}
			}
		}
		for (MAVOElement mayModelObj : mayAlternative.getMavoElements()) {
			View diagramView = diagramViews.get(mayModelObj.getFormulaVariable());
			GMFDiagramUtils.colorDiagramElement(diagramView, HIGHLIGHT_COLOR, FONT_HIGHLIGHT_COLOR);
		}

		// write diagram to file
		String exampleDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		MultiModelUtils.createModelFile(exampleDiagram, exampleDiagramUri, true);
		GMFDiagramUtils.openGMFDiagram(exampleDiagramUri, modelDiagram.getId(), true);
	}

}
