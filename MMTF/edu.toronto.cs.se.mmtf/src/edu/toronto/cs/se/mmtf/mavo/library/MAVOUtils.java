/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.library;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;

public class MAVOUtils {

	public static final String UML_MAVOMODEL_STEREOTYPE = "MAVOModel";
	private static final String UML_MAVOMODEL_STEREOTYPE_PROPERTY_INC = "inc";
	private static final String UML_MAVOELEMENT_STEREOTYPE = "MAVOElement";
	private static final String UML_MAVOELEMENT_STEREOTYPE_PROPERTY_MAY = "may";
	private static final String UML_MAVOELEMENT_STEREOTYPE_PROPERTY_SET = "set";
	private static final String UML_MAVOELEMENT_STEREOTYPE_PROPERTY_VAR = "var";
	private static final String UML_MAVOELEMENT_STEREOTYPE_PROPERTY_FORMULAID = "formulaId";

	public static String getMAVOElementLabel(MAVOElement element, boolean withParenthesis) {

		String label = "";
		boolean mavo = element.isMay() | element.isSet() | element.isVar();
		if (mavo) {
			label =
				(withParenthesis ? "(" : "") +
				(element.isMay() ? "M" : "") +
				(element.isSet() ? "S" : "") +
				(element.isVar() ? "V" : "") +
				(withParenthesis ? ")" : "");
		}

		return label;
	}

	public static void setMAVOElementLabel(MAVOElement element, String newLabel) {

		boolean isMay = false, isSet = false, isVar = false;
		for (char c : newLabel.replace(" ", "").toUpperCase().toCharArray()) {
			switch (c) {
				case 'M':
					if (isMay) {
						return;
					}
					isMay = true;
					break;
				case 'S':
					if (isSet) {
						return;
					}
					isSet = true;
					break;
				case 'V':
					if (isVar) {
						return;
					}
					isVar = true;
					break;
				default:
					return;
			}
		}
		element.setMay(isMay);
		element.setSet(isSet);
		element.setVar(isVar);
	}

	private static void annotateMAVOModel(MAVOModel rootModelObj, Model model) {

		model.setInc(rootModelObj.isInc());
	}

	private static void annotateMAVOModel(org.eclipse.uml2.uml.Model rootUmlModelObj, Model model) {

		Stereotype stereotype = rootUmlModelObj.getAppliedStereotype(UML_MAVOMODEL_STEREOTYPE);
		if (stereotype != null) {
			model.setInc((boolean) rootUmlModelObj.getValue(stereotype, UML_MAVOMODEL_STEREOTYPE_PROPERTY_INC));
		}
	}

	public static void annotateMAVOModel(EObject rootModelObj, Model model) {

		// UML
		if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			annotateMAVOModel((org.eclipse.uml2.uml.Model) rootModelObj, model);
		}
		// Ecore
		else if (rootModelObj instanceof MAVOModel) {
			annotateMAVOModel((MAVOModel) rootModelObj, model);
		}
	}

	private static void annotateMAVOModelElement(MAVOElement modelObj, ModelElement modelElem) {

		modelElem.setMay(modelObj.isMay());
		modelElem.setSet(modelObj.isSet());
		modelElem.setVar(modelObj.isVar());
		modelElem.setFormulaId(modelObj.getFormulaId());
	}

	private static void annotateMAVOModelElement(Element umlModelObj, ModelElement modelElem) {

		Stereotype stereotype = umlModelObj.getAppliedStereotype(UML_MAVOELEMENT_STEREOTYPE);
		if (stereotype != null) {
			modelElem.setMay((boolean) umlModelObj.getValue(stereotype, UML_MAVOELEMENT_STEREOTYPE_PROPERTY_MAY));
			modelElem.setSet((boolean) umlModelObj.getValue(stereotype, UML_MAVOELEMENT_STEREOTYPE_PROPERTY_SET));
			modelElem.setVar((boolean) umlModelObj.getValue(stereotype, UML_MAVOELEMENT_STEREOTYPE_PROPERTY_VAR));
			modelElem.setFormulaId((String) umlModelObj.getValue(stereotype, UML_MAVOELEMENT_STEREOTYPE_PROPERTY_FORMULAID));
		}
	}

	public static void annotateMAVOModelElement(EObject modelObj, ModelElement modelElem) {

		// UML
		if (modelObj instanceof Element) {
			annotateMAVOModelElement((Element) modelObj, modelElem);
		}
		//Ecore
		else if (modelObj instanceof MAVOElement) {
			annotateMAVOModelElement((MAVOElement) modelObj, modelElem);
		}
	}

	public static void annotateMAVOModelElementReference(EObject modelObj, ModelElementReference modelElemRef) {

		annotateMAVOModelElement(modelObj, modelElemRef.getObject());
	}

}
