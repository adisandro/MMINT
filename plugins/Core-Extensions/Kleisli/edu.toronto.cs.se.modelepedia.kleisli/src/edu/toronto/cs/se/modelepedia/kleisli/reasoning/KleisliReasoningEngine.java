/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.FileUtils;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraint;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.modelepedia.ocl.reasoning.OCLReasoningEngine;

public class KleisliReasoningEngine implements IReasoningEngine {

	public static final String KLEISLI_MODELTYPE_URI_SUFFIX = "_Kleisli";
	public static final String LANGUAGE_ID = "KLEISLI";
	public static final String ROW_SEPARATOR = "\n";
	public static final String UNION_KEYWORD = "union";
	public static final String UNION_ASSIGNMENT = ":=";
	public static final String ORIGIN_KEYWORD = "origin";
	public static final String OCL_SELF = "self";
	public static final String QUERY_NULL = "NULL";
	public static final String QUERY_MAP_VARIABLE = "_";
	public static final String QUERY_MAP_VARIABLE_SEPARATOR1 = ".";
	public static final String QUERY_MAP_VARIABLE_SEPARATOR2 = "->get(";
	public static final String QUERY_MAP_VARIABLE_SEPARATOR3 = ")";

	public void evaluateEClassQuery(String kQuery, OCLReasoningEngine oclReasoner, EObject kRootModelObj, EClass kModelElemTypeClass, EFactory kModelTypeFactory, Map<String, Map<EObject, EObject>> queryUnion) {

		for (String kQueryRow : kQuery.split(ROW_SEPARATOR)) {
			String[] kQueryAssignment = kQueryRow.split(UNION_ASSIGNMENT);
			String oclQuery = kQueryAssignment[1].trim();
			String unionName = kQueryAssignment[0].substring(kQueryAssignment[0].indexOf(UNION_KEYWORD)+UNION_KEYWORD.length(), kQueryAssignment[0].length()).trim();
			Map<EObject, EObject> queryRow = new LinkedHashMap<EObject, EObject>();
			queryUnion.put(unionName, queryRow);
			Object queryObjs = oclReasoner.evaluateQuery(kRootModelObj, oclQuery);
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

	public void evaluateEReferenceQuery(String kQuery, OCLReasoningEngine oclReasoner, EMFInfo kModelElemTypeEInfo, Map<String, Map<EObject, EObject>> queryUnion, Map<String, Map<String, Map<EObject, EObject>>> queryMap) {

		//TODO MMINT[KLEISLI] what happens when the source or target of the derived ereference is not derived (it's not in queryMap)
		//TODO MMINT[KLEISLI] what happens when ereference is not derived but the target is? (source can't be)
		String[] kQueryRows = kQuery.split(ROW_SEPARATOR);
		int i = 0;
		for (Map<EObject, EObject> queryRow : queryUnion.values()) {
			String oclQuery = kQueryRows[i].replace(ORIGIN_KEYWORD, OCL_SELF);
			String mapIndex = null, unionIndex = null;
			if (oclQuery.equals(QUERY_NULL)) {
				continue;
			}
			if (oclQuery.startsWith(QUERY_MAP_VARIABLE)) {
				int s1 = oclQuery.indexOf(QUERY_MAP_VARIABLE_SEPARATOR1);
				int s2 = oclQuery.indexOf(QUERY_MAP_VARIABLE_SEPARATOR2, s1 + QUERY_MAP_VARIABLE_SEPARATOR1.length());
				int s3 = oclQuery.lastIndexOf(QUERY_MAP_VARIABLE_SEPARATOR3);
				mapIndex = oclQuery.substring(0, s1);
				unionIndex = oclQuery.substring(s1 + QUERY_MAP_VARIABLE_SEPARATOR1.length(), s2);
				oclQuery = oclQuery.substring(s2 + QUERY_MAP_VARIABLE_SEPARATOR2.length(), s3);
			}
			for (Entry<EObject, EObject> queryRowEntry : queryRow.entrySet()) {
				EObject modelObj = queryRowEntry.getKey(), kModelObj = queryRowEntry.getValue();
				EObject modelObjReferrer = (EObject) oclReasoner.evaluateQuery(modelObj, oclQuery);
				if (mapIndex != null && unionIndex != null) {
					modelObjReferrer = queryMap.get(mapIndex).get(unionIndex).get(modelObjReferrer);
				}
				if (modelObjReferrer == null || !MIDConstraintChecker.instanceofEMFClass(modelObjReferrer, kModelElemTypeEInfo.getClassName())) {
					continue;
				}
				try {
					FileUtils.setModelObjFeature(modelObjReferrer, kModelElemTypeEInfo.getFeatureName(), kModelObj);
				}
				catch (MMINTException e) {
					MMINTException.print(IStatus.WARNING, "Error setting model object feature, skipping it", e);
				}
			}
			i++;
		}
	}

	public void evaluateEAttributeQuery(String kQuery, OCLReasoningEngine oclReasoner, EObject kRootModelObj, EMFInfo kModelElemTypeEInfo) {

		//TODO MMINT[KLEISLI] queries for derived attributes should be as complex as the ones for eclasses and ereferences
		TreeIterator<EObject> kModelObjIter = kRootModelObj.eAllContents();
		while (kModelObjIter.hasNext()) {
			EObject kModelObj = kModelObjIter.next();
			if (!MIDConstraintChecker.instanceofEMFClass(kModelObj, kModelElemTypeEInfo.getClassName())) {
				continue;
			}
			Object kModelObjAttr = oclReasoner.evaluateQuery(kModelObj, kQuery);
			try {
				FileUtils.setModelObjFeature(kModelObj, kModelElemTypeEInfo.getFeatureName(), kModelObjAttr);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Error setting model object feature, skipping it", e);
			}
		}
	}

	@Override
	public boolean checkModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel) {

		return true;
	}

	@Override
	public boolean checkOperatorInputConstraint(@NonNull Map<String, Model> inputsByName, @NonNull OperatorConstraint constraint) {

		return true;
	}

	@Override
	public boolean checkModelConstraintConsistency(@NonNull Model modelType, String constraint) {

		return true;
	}

	@Override
	public @Nullable Model refineModelByConstraint(@NonNull Model model) {

		return null;
	}

}
