/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.ocl.reasoning.OCLReasoner;

public class KleisliReasoner implements IReasoner {

	public static final String KLEISLI_MODELTYPE_URI_SUFFIX = "_Kleisli";
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

  @Override
  public String getName() {
    return "Kleisli";
  }

	public void evaluateEClassQuery(String kQuery, OCLReasoner oclReasoner, EObject kRootModelObj, EClass kModelElemTypeClass, EFactory kModelTypeFactory, Map<String, Map<EObject, EObject>> queryUnion) {

		for (String kQueryRow : kQuery.split(KleisliReasoner.ROW_SEPARATOR)) {
			var kQueryAssignment = kQueryRow.split(KleisliReasoner.UNION_ASSIGNMENT);
			var oclQuery = kQueryAssignment[1].trim();
			var unionName = kQueryAssignment[0].substring(kQueryAssignment[0].indexOf(KleisliReasoner.UNION_KEYWORD)+KleisliReasoner.UNION_KEYWORD.length(), kQueryAssignment[0].length()).trim();
			Map<EObject, EObject> queryRow = new LinkedHashMap<>();
			queryUnion.put(unionName, queryRow);
			Object queryObjs = oclReasoner.evaluateQuery(oclQuery, kRootModelObj);
			if (!(queryObjs instanceof Collection<?>)) {
				continue;
			}
			for (Object queryObj : (Collection<?>) queryObjs) {
				var modelObj = (EObject) queryObj;
				var kModelObj = kModelTypeFactory.create(kModelElemTypeClass);
				for (EStructuralFeature feature : modelObj.eClass().getEAllStructuralFeatures()) { // copy shared non-containment features
					var kFeature = kModelObj.eClass().getEStructuralFeature(feature.getName());
					if ((feature instanceof EReference && ((EReference) feature).isContainment()) || kFeature == null) {
						continue;
					}
					kModelObj.eSet(kFeature, modelObj.eGet(feature));
				}
				queryRow.put(modelObj, kModelObj);
			}
		}
	}

	public void evaluateEReferenceQuery(String kQuery, OCLReasoner oclReasoner, EMFInfo kModelElemTypeEInfo, Map<String, Map<EObject, EObject>> queryUnion, Map<String, Map<String, Map<EObject, EObject>>> queryMap) {

		//TODO MMINT[KLEISLI] what happens when the source or target of the derived ereference is not derived (it's not in queryMap)
		//TODO MMINT[KLEISLI] what happens when ereference is not derived but the target is? (source can't be)
		var kQueryRows = kQuery.split(KleisliReasoner.ROW_SEPARATOR);
		var i = 0;
		for (Map<EObject, EObject> queryRow : queryUnion.values()) {
			var oclQuery = kQueryRows[i].replace(KleisliReasoner.ORIGIN_KEYWORD, KleisliReasoner.OCL_SELF);
			String mapIndex = null, unionIndex = null;
			if (oclQuery.equals(KleisliReasoner.QUERY_NULL)) {
				continue;
			}
			if (oclQuery.startsWith(KleisliReasoner.QUERY_MAP_VARIABLE)) {
				var s1 = oclQuery.indexOf(KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR1);
				var s2 = oclQuery.indexOf(KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR2, s1 + KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR1.length());
				var s3 = oclQuery.lastIndexOf(KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR3);
				mapIndex = oclQuery.substring(0, s1);
				unionIndex = oclQuery.substring(s1 + KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR1.length(), s2);
				oclQuery = oclQuery.substring(s2 + KleisliReasoner.QUERY_MAP_VARIABLE_SEPARATOR2.length(), s3);
			}
			for (Entry<EObject, EObject> queryRowEntry : queryRow.entrySet()) {
				EObject modelObj = queryRowEntry.getKey(), kModelObj = queryRowEntry.getValue();
				var modelObjReferrer = (EObject) oclReasoner.evaluateQuery(oclQuery, modelObj);
				if (mapIndex != null && unionIndex != null) {
					modelObjReferrer = queryMap.get(mapIndex).get(unionIndex).get(modelObjReferrer);
				}
				if (modelObjReferrer == null || !MIDConstraintChecker.instanceofEMFClass(modelObjReferrer, kModelElemTypeEInfo.getClassName())) {
					continue;
				}
				try {
					FileUtils.setModelObjectFeature(modelObjReferrer, kModelElemTypeEInfo.getFeatureName(), kModelObj);
				}
				catch (MMINTException e) {
					MMINTException.print(IStatus.WARNING, "Error setting model object feature, skipping it", e);
				}
			}
			i++;
		}
	}

	public void evaluateEAttributeQuery(String kQuery, OCLReasoner oclReasoner, EObject kRootModelObj, EMFInfo kModelElemTypeEInfo) {

		//TODO MMINT[KLEISLI] queries for derived attributes should be as complex as the ones for eclasses and ereferences
		var kModelObjIter = kRootModelObj.eAllContents();
		while (kModelObjIter.hasNext()) {
			var kModelObj = kModelObjIter.next();
			if (!MIDConstraintChecker.instanceofEMFClass(kModelObj, kModelElemTypeEInfo.getClassName())) {
				continue;
			}
			Object kModelObjAttr = oclReasoner.evaluateQuery(kQuery, kModelObj);
			try {
				FileUtils.setModelObjectFeature(kModelObj, kModelElemTypeEInfo.getFeatureName(), kModelObjAttr);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Error setting model object feature, skipping it", e);
			}
		}
	}
}
