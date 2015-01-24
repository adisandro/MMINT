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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.MayDecisionLogic;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOConcretizationHighlighter {

	private static final int HIGHLIGHT_COLOR = 0x1ACA1A;
	private static final int FONT_HIGHLIGHT_COLOR = 0x005600;
	private static final int GREYOUT_COLOR = 0xF4F4F4;
	private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
	private static final int[] DIFFERENT_COLORS = {
		0xFF0000,
		0x00FF00,
		0x0000FF,
		0xFFFF00,
		0xFF00FF,
		0x00FFFF
	};
	private static final int[] FONT_DIFFERENT_COLORS = {
		0xD00000,
		0x00D000,
		0x0000D0,
		0xD0D000,
		0xD000D0,
		0x00D0D0
	};
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
		Map<String, View> diagramViews = GMFDiagramUtils.getDiagramViews(exampleDiagram);

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

	public void highlightMAVODecision(Diagram modelDiagram, MAVODecision mavoDecision) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(modelDiagram.getUri(), true);
		Map<String, View> diagramViews = GMFDiagramUtils.getDiagramViews(exampleDiagram);

		// highlight collections within the decision with different colors
		List<MAVOCollection> mavoCollections = new ArrayList<MAVOCollection>();
		if (mavoDecision instanceof MayDecision) {
			mavoCollections.addAll(((MayDecision) mavoDecision).getAlternatives());
		}
		else if (mavoDecision instanceof VarDecision) {
			mavoCollections.add(((VarDecision) mavoDecision).getDomain());
		}
		for (int i = 0; i < mavoCollections.size(); i++) {
			MAVOCollection mavoCollection = mavoCollections.get(i);
			for (MAVOElement mavoModelObj : mavoCollection.getMavoElements()) {
				View diagramView = diagramViews.get(mavoModelObj.getFormulaVariable());
				GMFDiagramUtils.colorDiagramElement(diagramView, DIFFERENT_COLORS[i], FONT_DIFFERENT_COLORS[i]);
			}
		}

		// write diagram to file
		String exampleDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		MultiModelUtils.createModelFile(exampleDiagram, exampleDiagramUri, true);
		GMFDiagramUtils.openGMFDiagram(exampleDiagramUri, modelDiagram.getId(), true);
	}

	public void highlightMAVOCollection(Diagram modelDiagram, MAVOCollection mavoCollection) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) MultiModelUtils.getModelFile(modelDiagram.getUri(), true);
		Map<String, View> diagramViews = GMFDiagramUtils.getDiagramViews(exampleDiagram);

		// (May) grey out may model objects in other alternatives for the same decision, highlight may model objects in the alternative
		// (Var) highlight var model objects in the domain
		MAVODecision mavoDecision = (MAVODecision) mavoCollection.eContainer();
		if (mavoDecision instanceof MayDecision && ((MayDecision) mavoDecision).getLogic() == MayDecisionLogic.XOR) {
			for (MAVOCollection otherMayAlternative : ((MayDecision) mavoDecision).getAlternatives()) {
				if (otherMayAlternative == mavoCollection) {
					continue;
				}
				for (MAVOElement otherMayModelObj : otherMayAlternative.getMavoElements()) {
					View diagramView = diagramViews.get(otherMayModelObj.getFormulaVariable());
					GMFDiagramUtils.colorDiagramElement(diagramView, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
				}
			}
		}
		for (MAVOElement mavoModelObj : mavoCollection.getMavoElements()) {
			View diagramView = diagramViews.get(mavoModelObj.getFormulaVariable());
			GMFDiagramUtils.colorDiagramElement(diagramView, HIGHLIGHT_COLOR, FONT_HIGHLIGHT_COLOR);
		}

		// write diagram to file
		String exampleDiagramUri = MultiModelUtils.addFileNameSuffixInUri(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		MultiModelUtils.createModelFile(exampleDiagram, exampleDiagramUri, true);
		GMFDiagramUtils.openGMFDiagram(exampleDiagramUri, modelDiagram.getId(), true);
	}

}
