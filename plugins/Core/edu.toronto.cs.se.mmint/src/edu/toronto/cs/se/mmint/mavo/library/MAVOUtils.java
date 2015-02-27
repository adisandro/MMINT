/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;

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
	private static final String NAME_FEATURE = "name";

	public static String getMAVOElementLabel(MAVOElement mavoModelObj, boolean withParenthesis) {

		String label = "";
		boolean mavo = mavoModelObj.isMay() || mavoModelObj.isSet() || mavoModelObj.isVar();

		if (mavo) {
			String collectionsLabel = mavoModelObj.getCollections().stream()
				.map(MAVOCollection::getFormulaVariable)
				.collect(Collectors.joining(", "));
			label =
				(withParenthesis ? "(" : "") +
				(mavoModelObj.isMay() ? "M" : "") +
				(mavoModelObj.isSet() ? "S" : "") +
				(mavoModelObj.isVar() ? "V" : "") +
				(withParenthesis ? ")" : "") +
				(collectionsLabel.equals("") ? "" : " [" + collectionsLabel + "]");
		}

		return label;
	}

	public static void setMAVOElementLabel(MAVOElement mavoElement, String newLabel) {
		
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
		mavoElement.setMay(isMay);
		mavoElement.setSet(isSet);
		mavoElement.setVar(isVar);
	}

	public static boolean isMAVOModel(EObject rootModelObj) {

		// Ecore
		if (rootModelObj instanceof MAVOModel) {
			return true;
		}
		// UML
		if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			return ((org.eclipse.uml2.uml.Model) rootModelObj).getAppliedProfile(UML_MAVO_PROFILE) != null;
		}

		return false;
	}

	public static boolean isMAVOElement(EObject modelObj) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			return true;
		}
		// UML
		if (modelObj instanceof NamedElement) {
			NamedElement umlModelObj = (NamedElement) modelObj;
			Stereotype stereotype = umlModelObj.getApplicableStereotype(UML_MAY_STEREOTYPE);
			if (stereotype != null) {
				return true;
			}
		}

		return false;
	}

	public static boolean isMAVOModel(Model model) {

		try {
			return isMAVOModel(model.getEMFInstanceRoot());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't get model root object, skipping MAVO evaluation", e);
			return false;
		}
	}

	public static boolean isMAVOElement(ModelElement modelElem) {

		try {
			return isMAVOElement(modelElem.getEMFInstanceObject());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't get model object, skipping MAVO evaluation", e);
			return false;
		}
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

		// Ecore
		if (rootModelObj instanceof MAVOModel) {
			initializeMAVOModel((MAVOModel) rootModelObj, model);
		}
		// UML
		else if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			initializeMAVOModel((org.eclipse.uml2.uml.Model) rootModelObj, model);
		}
	}

	private static void initializeMAVOModelElement(MAVOElement modelObj, ModelElement modelElem) {

		modelElem.setMay(modelObj.isMay());
		modelElem.setSet(modelObj.isSet());
		modelElem.setVar(modelObj.isVar());
		modelElem.setFormulaVariable(modelObj.getFormulaVariable());
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
		modelElem.setFormulaVariable(umlModelObj.getName().toLowerCase());
	}

	public static void initializeMAVOModelElement(EObject modelObj, ModelElement modelElem) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			initializeMAVOModelElement((MAVOElement) modelObj, modelElem);
		}
		// UML
		else if (modelObj instanceof NamedElement) {
			initializeMAVOModelElement((NamedElement) modelObj, modelElem);
		}
	}

	public static void initializeMAVOModelElementReference(EObject modelObj, ModelElementReference modelElemRef) {

		initializeMAVOModelElement(modelObj, modelElemRef.getObject());
	}

	public static void setInc(EObject rootModelObj, boolean inc) {

		// Ecore
		if (rootModelObj instanceof MAVOModel) {
			((MAVOModel) rootModelObj).setInc(inc);
		}
		// UML
		else if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
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
	}

	public static void setMay(EObject modelObj, boolean may) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setMay(may);
		}
		// UML
		else if (modelObj instanceof NamedElement) {
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
	}

	public static void setSet(EObject modelObj, boolean set) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setSet(set);
		}
		// UML
		else if (modelObj instanceof NamedElement) {
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
	}

	public static void setVar(EObject modelObj, boolean var) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			((MAVOElement) modelObj).setVar(var);
		}
		// UML
		else if (modelObj instanceof NamedElement) {
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
	}

	public static void copyMAVOElement(MAVOElement oldElement, MAVOElement newElement) {

		newElement.setMay(oldElement.isMay());
		newElement.setSet(oldElement.isSet());
		newElement.setVar(oldElement.isVar());
		newElement.setFormulaVariable(oldElement.getFormulaVariable());
	}

	public static boolean createFormulaVars(Model mavoModel) throws Exception {

		boolean modified = false, isMayOnly = true;
		MAVOModel rootMavoModel = (MAVOModel) mavoModel.getEMFInstanceRoot();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(rootMavoModel, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (!(modelObj instanceof MAVOElement)) {
				continue;
			}
			MAVOElement mavoModelObj = (MAVOElement) modelObj;
			if (isMayOnly && (mavoModelObj.isSet() || mavoModelObj.isVar())) { // detect if model has only may annotations
				isMayOnly = false;
			}
			if (mavoModelObj.getFormulaVariable() != null && !mavoModelObj.getFormulaVariable().equals("")) {
				continue;
			}
			EStructuralFeature nameFeature = mavoModelObj.eClass().getEStructuralFeature(NAME_FEATURE);
			if (nameFeature != null) {
				mavoModelObj.setFormulaVariable(((String) mavoModelObj.eGet(nameFeature)).replace(" ", ""));
				modified = true;
			}
		}

		// overwrite
		if (modified) {
			MultiModelUtils.createModelFile(rootMavoModel, mavoModel.getUri(), true);
		}

		return isMayOnly;
	}

	private static List<String> getVFormulaVars(MAVOModel mavoModel, MAVOElement mavoModelObj, boolean whichFormulaVars) {

		List<String> formulaVars = new ArrayList<String>();
		EObject modelObjContainer = mavoModelObj.eContainer();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(mavoModel, true);
		while (iterator.hasNext()) {
			EObject otherModelObj = iterator.next();
			if (
				!(otherModelObj instanceof MAVOElement) || // skip non-MAVO element
				!(mavoModelObj.eClass().getName().equals(otherModelObj.eClass().getName())) || // skip different type
				mavoModelObj.getFormulaVariable().equals(((MAVOElement) otherModelObj).getFormulaVariable()) // skip current element
			) {
				continue;
			}
			EObject otherModelObjContainer = otherModelObj.eContainer();
			boolean isMergeable = (mavoModelObj.isVar() || ((MAVOElement) otherModelObj).isVar()) && ( // ok one is V
				(modelObjContainer == otherModelObjContainer) || ( // ok same container (also recursion closure when containers are root)
					modelObjContainer instanceof MAVOElement && // ok different container: MAVO element
					modelObjContainer.eClass().getName().equals(otherModelObjContainer.eClass().getName()) && // ok different container: same type
					getMergeableFormulaVars(mavoModel, (MAVOElement) modelObjContainer).contains(((MAVOElement) otherModelObjContainer).getFormulaVariable()) // ok different container: mergeable
				)
			);
			if (whichFormulaVars != isMergeable) {
				continue;
			}
			formulaVars.add(((MAVOElement) otherModelObj).getFormulaVariable());
		}

		return formulaVars;
	}

	public static List<String> getMergeableFormulaVars(MAVOModel mavoModel, MAVOElement mavoModelObj) {

		return getVFormulaVars(mavoModel, mavoModelObj, true);
	}

	public static List<String> getUnmergeableFormulaVars(MAVOModel mavoModel, MAVOElement mavoModelObj) {

		return getVFormulaVars(mavoModel, mavoModelObj, false);
	}

	private static @NonNull Map<String, MAVOElement> getMAVOModelObjects(@NonNull MAVOModel mavoModel, @NonNull Predicate<? super EObject> filterLambda) {

		Iterable<EObject> iterable = () -> mavoModel.eAllContents();
		Map<String, MAVOElement> mavoModelObjs = StreamSupport.stream(iterable.spliterator(), false)
			.filter(filterLambda)
			.map(modelObj -> (MAVOElement) modelObj)
			.collect(Collectors.toMap(
				MAVOElement::getFormulaVariable,
				mavoModelObj -> mavoModelObj)
			);

		return mavoModelObjs;
	}

	public static @NonNull Map<String, MAVOElement> getAllMAVOModelObjects(@NonNull MAVOModel mavoModel) {

		Predicate<? super EObject> filterLambda = modelObj -> modelObj instanceof MAVOElement;

		return getMAVOModelObjects(mavoModel, filterLambda);
	}

	public static @NonNull Map<String, MAVOElement> getAnnotatedMAVOModelObjects(@NonNull MAVOModel mavoModel) {

		Predicate<? super EObject> filterLambda = modelObj ->
			modelObj instanceof MAVOElement && (
				((MAVOElement) modelObj).isMay() ||
				((MAVOElement) modelObj).isSet() ||
				((MAVOElement) modelObj).isVar()
			);

		return getMAVOModelObjects(mavoModel, filterLambda);
	}

	public static @NonNull Map<String, MAVOElement> getMAVOModelObjects(@NonNull Model model) throws MMINTException {

		EObject rootModelObj = model.getEMFInstanceRoot();
		if (!(rootModelObj instanceof MAVOModel)) {
			throw new MMINTException("Not a MAVO model");
		}

		return getAnnotatedMAVOModelObjects((MAVOModel) rootModelObj);
	}

}
