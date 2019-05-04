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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class MAVOUtils {

	public static final @NonNull String UML_MAVO_PROFILE = "MAVOProfile";
	private static final @NonNull String UML_INC_STEREOTYPE = UML_MAVO_PROFILE + "::" + "inc";
	private static final @NonNull String UML_MAY_STEREOTYPE = UML_MAVO_PROFILE + "::" + "may";
	private static final @NonNull String UML_SET_STEREOTYPE = UML_MAVO_PROFILE + "::" + "set";
	private static final @NonNull String UML_VAR_STEREOTYPE = UML_MAVO_PROFILE + "::" + "var";
	public static final @NonNull Map<String, String> MAVO_UML_STEREOTYPE_EQUIVALENCE;
	static {
		MAVO_UML_STEREOTYPE_EQUIVALENCE = new HashMap<>();
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVORoot", "inc");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "may");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "set");
		MAVO_UML_STEREOTYPE_EQUIVALENCE.put("MAVOElement", "var");
	}
	private static final String NAME_FEATURE = "name";

	public static String getMAVORootLabel(MAVORoot rootMavoModelObj, boolean withParenthesis) {

		String label = "";

		if (rootMavoModelObj.isInc()) {
			label =
				(withParenthesis ? "(" : "") +
				(rootMavoModelObj.isInc() ? "Inc" : "") +
				(withParenthesis ? ")" : "");
		}

		return label;
	}

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

	public static void setMAVORootLabel(MAVORoot rootMavoModelObj, String newLabel) {

		// I-Inc are the only allowable combinations (plus empty string)
		if (newLabel.trim().equals("I") || newLabel.trim().equals("Inc")) {
			rootMavoModelObj.setInc(true);
		}
		else if (newLabel.trim().equals("")) {
			rootMavoModelObj.setInc(false);
		}
	}

	public static void setMAVOElementLabel(MAVOElement mavoModelObj, String newLabel) {

		// M-S-V are the only allowable chars (plus empty string), and they can't appear more than once
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
		mavoModelObj.setMay(isMay);
		mavoModelObj.setSet(isSet);
		mavoModelObj.setVar(isVar);
	}

	public static boolean isMAVOModel(EObject rootModelObj) {

		// Ecore
		if (rootModelObj instanceof MAVORoot) {
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
	  return isMAVOModel(model.getEMFInstanceRoot());
	}

	public static boolean isMAVOElement(ModelElement modelElem) {

		try {
			return isMAVOElement(modelElem.getEMFInstanceObject(null));
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't get model object, skipping MAVO evaluation", e);
			return false;
		}
	}

	private static void initializeMAVOModel(MAVORoot rootModelObj, MAVOModel mavoModel) {

		mavoModel.setInc(rootModelObj.isInc());
	}

	private static void initializeMAVOModel(org.eclipse.uml2.uml.Model rootUmlModelObj, MAVOModel mavoModel) {

		Stereotype stereotype = rootUmlModelObj.getAppliedStereotype(UML_INC_STEREOTYPE);
		if (stereotype != null) {
			mavoModel.setInc(true);
		}
	}

	public static void initializeMAVOModel(EObject rootModelObj, MAVOModel model) {

		// Ecore
		if (rootModelObj instanceof MAVORoot) {
			initializeMAVOModel((MAVORoot) rootModelObj, model);
		}
		// UML
		else if (rootModelObj instanceof org.eclipse.uml2.uml.Model) {
			initializeMAVOModel((org.eclipse.uml2.uml.Model) rootModelObj, model);
		}
	}

	private static void initializeMAVOModelElement(MAVOElement modelObj, MAVOModelElement mavoModelElem) {

		mavoModelElem.setMay(modelObj.isMay());
		mavoModelElem.setSet(modelObj.isSet());
		mavoModelElem.setVar(modelObj.isVar());
		mavoModelElem.setFormulaVariable(modelObj.getFormulaVariable());
	}

	private static void initializeMAVOModelElement(NamedElement umlModelObj, MAVOModelElement mavoModelElem) {

		Stereotype stereotype = umlModelObj.getAppliedStereotype(UML_MAY_STEREOTYPE);
		if (stereotype != null) {
			mavoModelElem.setMay(true);
		}
		stereotype = umlModelObj.getAppliedStereotype(UML_SET_STEREOTYPE);
		if (stereotype != null) {
			mavoModelElem.setSet(true);
		}
		stereotype = umlModelObj.getAppliedStereotype(UML_VAR_STEREOTYPE);
		if (stereotype != null) {
			mavoModelElem.setVar(true);
		}
		mavoModelElem.setFormulaVariable(umlModelObj.getName().toLowerCase());
	}

	public static void initializeMAVOModelElement(EObject modelObj, MAVOModelElement mavoModelElem) {

		// Ecore
		if (modelObj instanceof MAVOElement) {
			initializeMAVOModelElement((MAVOElement) modelObj, mavoModelElem);
		}
		// UML
		else if (modelObj instanceof NamedElement) {
			initializeMAVOModelElement((NamedElement) modelObj, mavoModelElem);
		}
	}

	public static void initializeMAVOModelElementReference(EObject modelObj, MAVOModelElementReference mavoModelElemRef) {

		initializeMAVOModelElement(modelObj, mavoModelElemRef.getObject());
	}

	public static void setInc(EObject rootModelObj, boolean inc) {

		// Ecore
		if (rootModelObj instanceof MAVORoot) {
			((MAVORoot) rootModelObj).setInc(inc);
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

	public static void copyMAVOElement(MAVOElement oldMAVOElement, MAVOElement newMAVOElement) {

		newMAVOElement.setMay(oldMAVOElement.isMay());
		newMAVOElement.setSet(oldMAVOElement.isSet());
		newMAVOElement.setVar(oldMAVOElement.isVar());
		newMAVOElement.setFormulaVariable(oldMAVOElement.getFormulaVariable());
	}

	public static Map<String, MAVOElement> createFormulaVars(Model mavoModel) throws Exception {

		Map<String, MAVOElement> mavoModelObjs = new HashMap<>();
		boolean modified = false;
		MAVORoot mavoRootModelObj = (MAVORoot) mavoModel.getEMFInstanceRoot();
		TreeIterator<EObject> iterator = mavoRootModelObj.eAllContents();
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (!(modelObj instanceof MAVOElement)) {
				continue;
			}
			MAVOElement mavoModelObj = (MAVOElement) modelObj;
			if (mavoModelObj.getFormulaVariable() == null || mavoModelObj.getFormulaVariable().equals("")) {
				EStructuralFeature nameFeature = mavoModelObj.eClass().getEStructuralFeature(NAME_FEATURE);
				if (nameFeature != null) {
					mavoModelObj.setFormulaVariable(((String) mavoModelObj.eGet(nameFeature)).replace(" ", ""));
					modified = true;
				}
			}
			mavoModelObjs.put(mavoModelObj.getFormulaVariable(), mavoModelObj);
		}
		// overwrite
		if (modified) {
			FileUtils.writeModelFile(mavoRootModelObj, mavoModel.getUri(), true);
		}

		return mavoModelObjs;
	}

	public static boolean isMayOnly(Map<String, MAVOElement> mavoModelObjs) {

		return !mavoModelObjs.values().stream().anyMatch(mavoModelObj -> mavoModelObj.isSet() || mavoModelObj.isVar());
	}

	private static @NonNull Set<String> getVFormulaVars(@NonNull MAVORoot mavoModel, @NonNull MAVOElement mavoModelObj, boolean whichFormulaVars) {

		Set<String> formulaVars = new HashSet<>();
		EObject modelObjContainer = mavoModelObj.eContainer();
		TreeIterator<EObject> iterator = mavoModel.eAllContents();
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

	public static @NonNull Set<String> getMergeableFormulaVars(@NonNull MAVORoot mavoModel, @NonNull MAVOElement mavoModelObj) {

		return getVFormulaVars(mavoModel, mavoModelObj, true);
	}

	public static @NonNull Set<String> getUnmergeableFormulaVars(@NonNull MAVORoot mavoModel, @NonNull MAVOElement mavoModelObj) {

		return getVFormulaVars(mavoModel, mavoModelObj, false);
	}

	private static @NonNull Map<String, MAVOElement> getMAVOModelObjects(@NonNull MAVORoot mavoModel, @NonNull Predicate<? super EObject> filterLambda) {

		Iterable<EObject> iterable = () -> mavoModel.eAllContents();
		Map<String, MAVOElement> mavoModelObjs = StreamSupport.stream(iterable.spliterator(), false)
			.filter(filterLambda)
			.map(modelObj -> (MAVOElement) modelObj)
			.collect(Collectors.toMap(
				MAVOElement::getFormulaVariable,
				mavoModelObj -> mavoModelObj));

		return mavoModelObjs;
	}

	public static @NonNull Map<String, MAVOElement> getAllMAVOModelObjects(@NonNull MAVORoot mavoModel) {

		Predicate<? super EObject> filterLambda = modelObj -> modelObj instanceof MAVOElement;

		return getMAVOModelObjects(mavoModel, filterLambda);
	}

	public static @NonNull Map<String, MAVOElement> getAllMAVOModelObjects(@NonNull Model model) throws MMINTException {

		EObject rootModelObj = model.getEMFInstanceRoot();
		if (!(rootModelObj instanceof MAVORoot)) {
			throw new MMINTException("Not a MAVO model");
		}

		return getAllMAVOModelObjects((MAVORoot) rootModelObj);
	}

	public static @NonNull Map<String, MAVOElement> getAnnotatedMAVOModelObjects(@NonNull MAVORoot mavoModel) {

		Predicate<? super EObject> filterLambda = modelObj ->
			modelObj instanceof MAVOElement && (
				((MAVOElement) modelObj).isMay() ||
				((MAVOElement) modelObj).isSet() ||
				((MAVOElement) modelObj).isVar()
			);

		return getMAVOModelObjects(mavoModel, filterLambda);
	}

	public static @NonNull Map<String, MAVOElement> getAnnotatedMAVOModelObjects(@NonNull Model model) throws MMINTException {

		EObject rootModelObj = model.getEMFInstanceRoot();
		if (!(rootModelObj instanceof MAVORoot)) {
			throw new MMINTException("Not a MAVO model");
		}

		return getAnnotatedMAVOModelObjects((MAVORoot) rootModelObj);
	}

}
