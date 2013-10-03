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

	/*TODO MMTF: make it more integrated with the environment
	 * e.g. overwrite the model if at least one formulaId is set
	 * e.g. a separate operator
	 * e.g. run all times a mavo operator is invoked
	 */
	public static void createIdsFromNames(MAVOModel mavoModel) {

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

	private static List<String> getVIds(MAVOModel mavoModel, MAVOElement mavoModelObj, boolean whichIds) {

		List<String> ids = new ArrayList<String>();
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
			boolean isMergeable = (mavoModelObj.isVar() || ((MAVOElement) otherModelObj).isVar()) && ( // ok one is V
				(modelObjContainer == otherModelObjContainer) || ( // ok same container
					modelObjContainer instanceof MAVOElement && // ok different container: MAVO element
					modelObjContainer.eClass().getName().equals(otherModelObjContainer.eClass().getName()) && // ok different container: same type
					(((MAVOElement) modelObjContainer).isVar() || ((MAVOElement) otherModelObjContainer).isVar()) // ok different container: one is V
				)
			);
			if (whichIds != isMergeable) {
				continue;
			}
			ids.add(((MAVOElement) otherModelObj).getFormulaId());
		}

		return ids;
	}

	public static List<String> getMergeableIds(MAVOModel mavoModel, MAVOElement mavoModelObj) {

		return getVIds(mavoModel, mavoModelObj, true);
	}

	public static List<String> getUnmergeableIds(MAVOModel mavoModel, MAVOElement mavoModelObj) {

		return getVIds(mavoModel, mavoModelObj, false);
	}

}
