/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.MayDecisionLogic;
import edu.toronto.cs.se.mavo.SetDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOGMFDiagramUtils;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

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

	private Set<String> separateExampleElements(@NonNull Map<String, Set<String>> z3ModelObjs, @NonNull Map<String, View> diagramViews) {

		Set<String> notInExampleFormulaVars = new HashSet<String>(diagramViews.keySet());
		z3ModelObjs.values().forEach(formulaVars -> notInExampleFormulaVars.removeAll(formulaVars));

		return notInExampleFormulaVars;
	}

	public void highlightMAVOCounterExample(@NonNull Diagram modelDiagram, @NonNull Map<String, Set<String>> z3ModelObjs) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) FileUtils.readModelFile(modelDiagram.getUri(), null, true);
		Map<String, View> diagramViews = MAVOGMFDiagramUtils.getDiagramViews(exampleDiagram);

		// grey out model objects that are not in the example
		Set<String> notInExampleFormulaVars = separateExampleElements(z3ModelObjs, diagramViews);
		for (String notInExampleFormulaVar : notInExampleFormulaVars) {
			highlightMAVOElement(diagramViews, notInExampleFormulaVar, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
		}

		// write diagram to file
		String exampleDiagramUri = FileUtils.addFileNameSuffixInPath(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		FileUtils.writeModelFile(exampleDiagram, exampleDiagramUri, true);
		FileUtils.openEclipseEditor(exampleDiagramUri, modelDiagram.getId(), true);
	}

	private void highlightMAVODecision(@NonNull Map<String, View> diagramViews, @NonNull MAVODecision mavoDecision) {

		// highlight collections within the decision with different colors
		List<MAVOCollection> mavoCollections = new ArrayList<MAVOCollection>();
		if (mavoDecision instanceof MayDecision) {
			mavoCollections.addAll(((MayDecision) mavoDecision).getAlternatives());
		}
		else if (mavoDecision instanceof VarDecision) {
			mavoCollections.add(((VarDecision) mavoDecision).getDomain());
		}
		else if (mavoDecision instanceof SetDecision) {
			mavoCollections.add(((SetDecision) mavoDecision).getEntity());
		}
		for (int i = 0; i < mavoCollections.size(); i++) {
			MAVOCollection mavoCollection = mavoCollections.get(i);
			for (MAVOElement mavoModelObj : mavoCollection.getMavoElements()) {
				highlightMAVOElement(diagramViews, mavoModelObj, DIFFERENT_COLORS[i], FONT_DIFFERENT_COLORS[i]);
			}
		}
	}

	private void highlightMAVOCollection(@NonNull Map<String, View> diagramViews, @NonNull MAVOCollection mavoCollection) {

		// (May) grey out may model objects in other alternatives for the same decision, highlight may model objects in the alternative
		// (Var) highlight var model objects in the domain
		MAVODecision mavoDecision = (MAVODecision) mavoCollection.eContainer();
		if (mavoDecision instanceof MayDecision && ((MayDecision) mavoDecision).getLogic() == MayDecisionLogic.XOR) {
			for (MAVOCollection otherMayAlternative : ((MayDecision) mavoDecision).getAlternatives()) {
				if (otherMayAlternative == mavoCollection) {
					continue;
				}
				for (MAVOElement otherMayModelObj : otherMayAlternative.getMavoElements()) {
					highlightMAVOElement(diagramViews, otherMayModelObj, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
				}
			}
		}
		for (MAVOElement mavoModelObj : mavoCollection.getMavoElements()) {
			highlightMAVOElement(diagramViews, mavoModelObj, HIGHLIGHT_COLOR, FONT_HIGHLIGHT_COLOR);
		}
	}

	private void highlightMAVOElement(@NonNull Map<String, View> diagramViews, @NonNull MAVOElement mavoModelObj, int color, int fontColor) {

		// highlight model object and contained children
		highlightMAVOElement(diagramViews, mavoModelObj.getFormulaVariable(), color, fontColor);
		mavoModelObj.eContents().stream()
			.filter(containedModelObj -> containedModelObj instanceof MAVOElement)
			.forEach(mavoContainedModelObj -> highlightMAVOElement(diagramViews, (MAVOElement) mavoContainedModelObj, color, fontColor));
	}

	private void highlightMAVOElement(@NonNull Map<String, View> diagramViews, @NonNull String mavoModelObjFormulaVar, int color, int fontColor) {

		// highlight model object
		try {
			View diagramView = diagramViews.get(mavoModelObjFormulaVar);
			if (diagramView == null) {
				throw new MMINTException("Can't find " + mavoModelObjFormulaVar + " in diagram");
			}
			GMFUtils.colorDiagramElement(diagramView, color, fontColor);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't color diagram element, skipping it", e);
		}
	}

	public void highlight(@NonNull Diagram modelDiagram, @NonNull LogicElement mavoElemToHighlight) throws Exception {

		// get view elements from diagram
		org.eclipse.gmf.runtime.notation.Diagram exampleDiagram = (org.eclipse.gmf.runtime.notation.Diagram) FileUtils.readModelFile(modelDiagram.getUri(), null, true);
		Map<String, View> diagramViews = MAVOGMFDiagramUtils.getDiagramViews(exampleDiagram);

		// highlight
		if (mavoElemToHighlight instanceof MAVODecision) {
			highlightMAVODecision(diagramViews, (MAVODecision) mavoElemToHighlight);
		}
		else if (mavoElemToHighlight instanceof MAVOCollection) {
			highlightMAVOCollection(diagramViews, (MAVOCollection) mavoElemToHighlight);
		}
		else if (mavoElemToHighlight instanceof MAVOElement) {
			highlightMAVOElement(diagramViews, (MAVOElement) mavoElemToHighlight, HIGHLIGHT_COLOR, FONT_HIGHLIGHT_COLOR);
		}

		// write diagram to file
		String exampleDiagramUri = FileUtils.addFileNameSuffixInPath(modelDiagram.getUri(), EXAMPLE_MODEL_SUFFIX);
		FileUtils.writeModelFile(exampleDiagram, exampleDiagramUri, true);
		FileUtils.openEclipseEditor(exampleDiagramUri, modelDiagram.getId(), true);
	}

}
