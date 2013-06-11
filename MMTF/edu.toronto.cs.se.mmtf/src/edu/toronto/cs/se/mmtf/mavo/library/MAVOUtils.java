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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;

public class MAVOUtils {

	public static final String UML_MAVO_PROFILE = "MAVOProfile";
	private static final String UML_INC_STEREOTYPE = UML_MAVO_PROFILE + "::" + "inc";
	private static final String UML_MAY_STEREOTYPE = UML_MAVO_PROFILE + "::" + "may";
	private static final String UML_SET_STEREOTYPE = UML_MAVO_PROFILE + "::" + "set";
	private static final String UML_VAR_STEREOTYPE = UML_MAVO_PROFILE + "::" + "var";
	public static final Map<String, String> MAVO_UML_STEREOTYPE_EQUIVALENCE;
	static {
		MAVO_UML_STEREOTYPE_EQUIVALENCE = new HashMap<String, String>();
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOModel", "inc");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "may");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "set");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "var");
	}

	public static String getMAVOElementLabel(MAVOElement NamedElement, boolean withParenthesis) {

		String label = "";
		boolean mavo = NamedElement.isMay() | NamedElement.isSet() | NamedElement.isVar();
		if (mavo) {
			label =
				(withParenthesis ? "(" : "") +
				(NamedElement.isMay() ? "M" : "") +
				(NamedElement.isSet() ? "S" : "") +
				(NamedElement.isVar() ? "V" : "") +
				(withParenthesis ? ")" : "");
		}

		return label;
	}

	public static void setMAVOElementLabel(MAVOElement NamedElement, String newLabel) {

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
		NamedElement.setMay(isMay);
		NamedElement.setSet(isSet);
		NamedElement.setVar(isVar);
	}

	private static void initializeMAVOModel(MAVOModel rootModelObj, Model model) {

		model.setInc(rootModelObj.isInc());
	}

	private static void initializeMAVOModel(org.eclipse.uml2.uml.Model rootUmlModelObj, Model model) {

		Stereotype stereotype = rootUmlModelObj.getAppliedStereotype(UML_INC_STEREOTYPE);
		if (stereotype != null) {
			model.setInc(true);
		}
	}

	public static void initializeMAVOModel(EObject rootModelObj, Model model) {

		// UML
		if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			initializeMAVOModel((org.eclipse.uml2.uml.Model) rootModelObj, model);
		}
		// Ecore
		else if (rootModelObj instanceof MAVOModel) {
			initializeMAVOModel((MAVOModel) rootModelObj, model);
		}
	}

	private static void initializeMAVOModelElement(MAVOElement modelObj, ModelElement modelElem) {

		modelElem.setMay(modelObj.isMay());
		modelElem.setSet(modelObj.isSet());
		modelElem.setVar(modelObj.isVar());
		modelElem.setFormulaId(modelObj.getFormulaId());
	}

	private static void initializeMAVOModelElement(NamedElement umlModelObj, ModelElement modelElem) {

		Stereotype stereotype = umlModelObj.getAppliedStereotype(UML_MAY_STEREOTYPE);
		if (stereotype != null) {
			modelElem.setMay(true);
		}
		stereotype = umlModelObj.getAppliedStereotype(UML_SET_STEREOTYPE);
		if (stereotype != null) {
			modelElem.setSet(true);
		}
		stereotype = umlModelObj.getAppliedStereotype(UML_VAR_STEREOTYPE);
		if (stereotype != null) {
			modelElem.setVar(true);
		}
		modelElem.setFormulaId(umlModelObj.getName().toLowerCase());
	}

	public static void initializeMAVOModelElement(EObject modelObj, ModelElement modelElem) {

		// UML
		if (modelObj instanceof NamedElement) {
			initializeMAVOModelElement((NamedElement) modelObj, modelElem);
		}
		//Ecore
		else if (modelObj instanceof MAVOElement) {
			initializeMAVOModelElement((MAVOElement) modelObj, modelElem);
		}
	}

	public static void initializeMAVOModelElementReference(EObject modelObj, ModelElementReference modelElemRef) {

		initializeMAVOModelElement(modelObj, modelElemRef.getObject());
	}

	public static void setInc(EObject rootModelObj, boolean inc) {

		//UML
		if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			org.eclipse.uml2.uml.Model umlRootModelObj = (org.eclipse.uml2.uml.Model) rootModelObj;
			Stereotype stereotype = umlRootModelObj.getApplicableStereotype(UML_INC_STEREOTYPE);
			if (stereotype != null) {
				if (inc && !umlRootModelObj.isStereotypeApplied(stereotype)) {
					umlRootModelObj.applyStereotype(stereotype);
				}
				else if (!inc && umlRootModelObj.isStereotypeApplied(stereotype)) {
					umlRootModelObj.unapplyStereotype(stereotype);
				}
			}
		}
		//Ecore
		else if (rootModelObj instanceof MAVOModel) {
			((MAVOModel) rootModelObj).setInc(inc);
		}
	}

	public static void setMay(EObject modelObj, boolean may) {

		//UML
		if (modelObj instanceof NamedElement) {
			NamedElement umlModelObj = (NamedElement) modelObj;
			Stereotype stereotype = umlModelObj.getApplicableStereotype(UML_MAY_STEREOTYPE);
			if (stereotype != null) {
				if (may && !umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.applyStereotype(stereotype);
				}
				else if (!may && umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.unapplyStereotype(stereotype);
				}
			}
		}
		//Ecore
		else if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setMay(may);
		}
	}

	public static void setSet(EObject modelObj, boolean set) {

		//UML
		if (modelObj instanceof NamedElement) {
			NamedElement umlModelObj = (NamedElement) modelObj;
			Stereotype stereotype = umlModelObj.getApplicableStereotype(UML_SET_STEREOTYPE);
			if (stereotype != null) {
				if (set && !umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.applyStereotype(stereotype);
				}
				else if (!set && umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.unapplyStereotype(stereotype);
				}
			}
		}
		//Ecore
		else if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setSet(set);
		}
	}

	public static void setVar(EObject modelObj, boolean var) {

		//UML
		if (modelObj instanceof NamedElement) {
			NamedElement umlModelObj = (NamedElement) modelObj;
			Stereotype stereotype = umlModelObj.getApplicableStereotype(UML_VAR_STEREOTYPE);
			if (stereotype != null) {
				if (var && !umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.applyStereotype(stereotype);
				}
				else if (!var && umlModelObj.isStereotypeApplied(stereotype)) {
					umlModelObj.unapplyStereotype(stereotype);
				}
			}
		}
		//Ecore
		else if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setVar(var);
		}
	}

	public static void copyMAVOElement(MAVOElement oldElement, MAVOElement newElement) {

		newElement.setMay(oldElement.isMay());
		newElement.setSet(oldElement.isSet());
		newElement.setVar(oldElement.isVar());
		newElement.setFormulaId(oldElement.getFormulaId());
	}

}
