/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli.reasoning;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.domain.values.SetValue;

import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.modelepedia.ocl.reasoning.OCLReasoningEngine;

public class KleisliReasoningEngine implements IReasoningEngine {

	public static final String LANGUAGE_ID = "KLEISLI";
	public static final String UNION_SEPARATOR = "\n";
	public static final String QUERY_NULL = "NULL";
	public static final String MAP_VARIABLE = "$";
	public static final String MAP_VARIABLE_START = "[";
	public static final String MAP_VARIABLE_END = "]";

	public void evaluateEClassQuery(OCLReasoningEngine oclReasoner, EObject kRootModelObj, String kQuery, EClass kModelElemTypeClass, EFactory kModelTypeFactory, List<Map<EObject, EObject>> queryUnionList) {

		for (String oclQuery : kQuery.split(UNION_SEPARATOR)) {
			Map<EObject, EObject> queryRowMap = new HashMap<EObject, EObject>();
			queryUnionList.add(queryRowMap);
			Object queryObjs = oclReasoner.evaluateQuery(kRootModelObj, oclQuery);
			if (queryObjs instanceof SetValue) {
				queryObjs = ((SetValue) queryObjs).getElements();
			}
			if (!(queryObjs instanceof Collection<?>)) {
				continue;
			}
			for (Object queryObj : (Collection<?>) queryObjs) {
				EObject modelObj = (EObject) queryObj;
				EObject kModelObj = kModelTypeFactory.create(kModelElemTypeClass);
				for (EStructuralFeature feature : modelObj.eClass().getEAllStructuralFeatures()) { // copy shared non-containment features
					EStructuralFeature kFeature = kModelObj.eClass().getEStructuralFeature(feature.getName());
					if ((feature instanceof EReference && ((EReference) feature).isContainment()) || kFeature == null) {
						continue;
					}
					kModelObj.eSet(kFeature, modelObj.eGet(feature));
				}
				queryRowMap.put(modelObj, kModelObj);
				//TODO MMINT[KLEISLI] will the different semantics creating/replacing be needed?
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void evaluateEReferenceQuery(OCLReasoningEngine oclReasoner, EMFInfo kModelElemTypeEInfo, String kQuery, List<Map<EObject, EObject>> queryUnionList, Map<String, List<Map<EObject, EObject>>> queryMap) {

		String[] oclQueries = (kQuery == null) ? new String[queryUnionList.size()] : kQuery.split(UNION_SEPARATOR);
		for (int i = 0; i < queryUnionList.size(); i++) {
			String oclQuery = oclQueries[i], mapIndex = null;
			int listIndex = 0;
			if (kQuery == null) {
				oclQuery = "oclContainer()";
			}
			if (oclQuery.equals(QUERY_NULL)) {
				continue;
			}
			if (oclQuery.startsWith(MAP_VARIABLE)) {
				int s = oclQuery.indexOf(MAP_VARIABLE_START), e1 = oclQuery.indexOf(MAP_VARIABLE_END), e2 = oclQuery.indexOf(MAP_VARIABLE_END, e1+1);
				mapIndex = oclQuery.substring(1, s);
				listIndex = Integer.valueOf(oclQuery.substring(s+1, e1));
				oclQuery = oclQuery.substring(e1+2, e2);
			}
			for (Entry<EObject, EObject> x : queryUnionList.get(i).entrySet()) {
				EObject modelObjReferrer = (EObject) oclReasoner.evaluateQuery(x.getKey(), oclQuery);
				if (mapIndex != null) {
					modelObjReferrer = queryMap.get(mapIndex).get(listIndex).get(modelObjReferrer);
				}
				EStructuralFeature feature = modelObjReferrer.eClass().getEStructuralFeature(kModelElemTypeEInfo.getFeatureName());
				if (modelObjReferrer == null || feature == null || !MultiModelConstraintChecker.instanceofEMFClass(modelObjReferrer, kModelElemTypeEInfo.getClassName())) {
					continue;
				}
				if (feature.isMany()) {
					((EList<EObject>) modelObjReferrer.eGet(feature)).add(x.getValue());
				}
				else {
					modelObjReferrer.eSet(feature, x.getValue());
				}
			}
		}
	}

	@Override
	public MAVOTruthValue checkConstraint(Model model, ExtendibleElementConstraint constraint, MidLevel constraintLevel) {

		return MAVOTruthValue.TRUE;
	}

	@Override
	public boolean checkConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

}
