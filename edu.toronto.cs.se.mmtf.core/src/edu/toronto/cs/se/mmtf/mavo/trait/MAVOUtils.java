/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.trait;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;

public class MAVOUtils {

	public static String getMAVOLabel(MAVOElement element, String text) {

		String label = (text == null) ? "" : text;
		boolean mavo = element.isMay() | element.isSet() | element.isVar();
		if (mavo) {
			label =
				"(" +
				((element.isMay()) ? "M" : "") +
				((element.isSet()) ? "S" : "") +
				((element.isVar()) ? "V" : "") +
				") " +
				label;
		}

		return label;
	}

	public static void annotateMAVOModel(EObject rootEObject, Model model) {

		if (!(rootEObject instanceof MAVOModel)) {
			return;
		}

		model.setInc(((MAVOModel) rootEObject).isInc());
	}

	public static void annotateMAVOModelElement(EObject modelObj, ModelElement modelElem) {

		if (!(modelObj instanceof MAVOElement)) {
			return;
		}

		MAVOElement mavoObj = (MAVOElement) modelObj;
		modelElem.setMay(mavoObj.isMay());
		modelElem.setSet(mavoObj.isSet());
		modelElem.setVar(mavoObj.isVar());
	}

	public static void annotateMAVOModelElementReference(EObject modelObj, ModelElementReference modelElemRef) {

		if (!(modelObj instanceof MAVOElement)) {
			return;
		}

		annotateMAVOModelElement(modelObj, modelElemRef.getObject());
	}

}
