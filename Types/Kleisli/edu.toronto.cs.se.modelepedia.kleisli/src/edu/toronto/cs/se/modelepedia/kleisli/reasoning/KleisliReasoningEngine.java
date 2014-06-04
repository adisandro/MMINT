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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.domain.values.SetValue;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.modelepedia.ocl.reasoning.OCLReasoningEngine;

public class KleisliReasoningEngine implements IReasoningEngine {

	public static final String LANGUAGE_ID = "KLEISLI";
	public static final String UNION_SEPARATOR = "\n";
	public static final String QUERY_NULL = "NULL";
	public static final String MAP_VARIABLE = "$";
	public static final String MAP_VARIABLE_START = "[";
	public static final String MAP_VARIABLE_END = "]";

	public void evaluateEClassQuery(String kQuery, OCLReasoningEngine oclReasoner, EObject kRootModelObj, EClass kModelElemTypeClass, EFactory kModelTypeFactory, List<Map<EObject, EObject>> queryUnion) {

		//TODO MMINT[KLEISLI] will the different semantics creating/replacing be needed?
		for (String oclQuery : kQuery.split(UNION_SEPARATOR)) {
			Map<EObject, EObject> queryRow = new HashMap<EObject, EObject>();
			queryUnion.add(queryRow);
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
				queryRow.put(modelObj, kModelObj);
			}
		}
	}

	public void evaluateEReferenceQuery(String kQuery, OCLReasoningEngine oclReasoner, EMFInfo kModelElemTypeEInfo, List<Map<EObject, EObject>> queryUnion, Map<String, List<Map<EObject, EObject>>> queryMap) {

		//TODO MMINT[KLEISLI] what happens when the source or target of the derived ereference is not derived, it's not in queryMap
		//TODO MMINT[KLEISLI] what happens when ereference is not derived but the target is? (source can't be)
		String[] oclQueries = (kQuery == null) ? new String[queryUnion.size()] : kQuery.split(UNION_SEPARATOR);
		for (int i = 0; i < queryUnion.size(); i++) {
			String oclQuery = oclQueries[i];
			String mapIndex = null;
			int unionIndex = -1;
			if (kQuery == null) {
				oclQuery = "oclContainer()";
			}
			if (oclQuery.equals(QUERY_NULL)) {
				continue;
			}
			if (oclQuery.startsWith(MAP_VARIABLE)) {
				int s = oclQuery.indexOf(MAP_VARIABLE_START), e1 = oclQuery.indexOf(MAP_VARIABLE_END), e2 = oclQuery.indexOf(MAP_VARIABLE_END, e1+1);
				mapIndex = oclQuery.substring(1, s);
				unionIndex = Integer.valueOf(oclQuery.substring(s+1, e1));
				oclQuery = oclQuery.substring(e1+2, e2);
			}
			for (Entry<EObject, EObject> queryRowEntry : queryUnion.get(i).entrySet()) {
				EObject modelObj = queryRowEntry.getKey(), kModelObj = queryRowEntry.getValue();
				EObject modelObjReferrer = (EObject) oclReasoner.evaluateQuery(modelObj, oclQuery);
				if (mapIndex != null && unionIndex > -1) {
					modelObjReferrer = queryMap.get(mapIndex).get(unionIndex).get(modelObjReferrer);
				}
				if (modelObjReferrer == null || !MultiModelConstraintChecker.instanceofEMFClass(modelObjReferrer, kModelElemTypeEInfo.getClassName())) {
					continue;
				}
				try {
					MultiModelUtils.setModelObjFeature(modelObjReferrer, kModelElemTypeEInfo.getFeatureName(), kModelObj);
				}
				catch (MMINTException e) {
					MMINTException.print(Type.WARNING, "Error setting model object feature, skipping it", e);
				}
			}
		}
	}

	public void evaluateEAttributeQuery(String kQuery, OCLReasoningEngine oclReasoner, EObject kRootModelObj, EMFInfo kModelElemTypeEInfo) {

		//TODO MMINT[KLEISLI] queries for derived attributes should be as complex as the ones for eclasses and ereferences
		TreeIterator<EObject> kModelObjIter = kRootModelObj.eAllContents();
		while (kModelObjIter.hasNext()) {
			EObject kModelObj = kModelObjIter.next();
			if (!MultiModelConstraintChecker.instanceofEMFClass(kModelObj, kModelElemTypeEInfo.getClassName())) {
				continue;
			}
			Object kModelObjAttr = oclReasoner.evaluateQuery(kModelObj, kQuery);
			try {
				MultiModelUtils.setModelObjFeature(kModelObj, kModelElemTypeEInfo.getFeatureName(), kModelObjAttr);
			}
			catch (MMINTException e) {
				MMINTException.print(Type.WARNING, "Error setting model object feature, skipping it", e);
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
