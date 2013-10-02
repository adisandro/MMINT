/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;

public class MAVOSMTUtils {

	private static final String NAME_FEATURE = "name";

	public static void createFormulaIdsFromNames(MAVOModel mavoModel) {

		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(mavoModel, true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			if (!(modelObj instanceof MAVOElement)) {
				continue;
			}
			MAVOElement mavoModelObj = (MAVOElement) modelObj;
			if (mavoModelObj.getFormulaId() != null && !mavoModelObj.getFormulaId().equals("")) {
				continue;
			}
			EStructuralFeature nameFeature = mavoModelObj.eClass().getEStructuralFeature(NAME_FEATURE);
			if (nameFeature != null) {
				mavoModelObj.setFormulaId(((String) mavoModelObj.eGet(nameFeature)).replaceAll(" ", ""));
			}
		}
	}

	public static List<String> getUnmergeableModelObjects(MAVOModel mavoModel, MAVOElement mavoModelObj) {

		List<String> unmergeableModelObjs = new ArrayList<String>();
		EObject modelObjContainer = mavoModelObj.eContainer();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(mavoModel, true);
		while (iterator.hasNext()) {
			EObject otherModelObj = iterator.next();
			if (
				!(otherModelObj instanceof MAVOElement) || // skip non-MAVO element
				!(mavoModelObj.eClass().getName().equals(otherModelObj.eClass().getName())) || // skip different type
				mavoModelObj.getFormulaId().equals(((MAVOElement) otherModelObj).getFormulaId()) // skip current element
			) {
				continue;
			}
			EObject otherModelObjContainer = otherModelObj.eContainer();
			boolean isMergeable = (modelObjContainer == otherModelObjContainer) || ( // ok same container
				modelObjContainer instanceof MAVOElement && // ok different container: MAVO element
				modelObjContainer.eClass().getName().equals(otherModelObjContainer.eClass().getName()) && // ok different container: same type
				(((MAVOElement) modelObjContainer).isVar() || ((MAVOElement) otherModelObjContainer).isVar()) // ok different container: one is V
			);
			if (isMergeable && (mavoModelObj.isVar() || ((MAVOElement) otherModelObj).isVar())) {
				continue;
			}
			unmergeableModelObjs.add(((MAVOElement) otherModelObj).getFormulaId());
		}

		return unmergeableModelObjs;
	}

}
