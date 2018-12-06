/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.library;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;

public class MAVOGMFDiagramUtils extends GMFUtils {

	private static void getDiagramFormulaVariable(@NonNull View diagramView, @NonNull Map<String, View> diagramViews) {

		EObject modelObj = diagramView.getElement();
		if (modelObj instanceof MAVOElement) {
			diagramViews.put(((MAVOElement) modelObj).getFormulaVariable(), diagramView);
		}
	}

	private static void getDiagramFormulaVariables(@NonNull EList<View> diagramViewList, @NonNull Map<String, View> diagramViews) {

		for (View diagramView : diagramViewList) {
			for (Object compartment : diagramView.getChildren()) {
				if (compartment instanceof BasicCompartment) {
					for (Object diagramSubview : ((BasicCompartment) compartment).getChildren()) {
						getDiagramFormulaVariable((View) diagramSubview, diagramViews);
					}
				}
			}
			getDiagramFormulaVariable(diagramView, diagramViews);
		}
	}

	public static @NonNull Map<String, View> getDiagramViews(@NonNull Diagram diagram) {

		Map<String, View> diagramViews = new HashMap<>();
		getDiagramFormulaVariables((EList<View>) diagram.getChildren(), diagramViews);
		getDiagramFormulaVariables((EList<View>) diagram.getEdges(), diagramViews);

		return diagramViews;
	}

}
