/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.kotlin.utils;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.kotlin.structs.LList;
import edu.toronto.cs.se.mmint.kotlin.structs.LlistKt;
import edu.toronto.cs.se.mmint.kotlin.structs.MkObj;
import edu.toronto.cs.se.mmint.kotlin.structs.MkObjData;
import edu.toronto.cs.se.mmint.kotlin.structs.Object;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class KotlinUtils {

  private static MkObj eObjectToKObject(EObject modelObj) throws MMINTException {
    var kObjAttrs = new HashMap<String, String>();
    var kObjRefs = new HashMap<String, LList<Object>>();
    var kObjCont = new HashMap<String, LList<Object>>();
    var kObjData = new MkObjData(MIDRegistry.getModelElementUri(modelObj), modelObj.eClass().getName(), kObjAttrs,
                                 kObjRefs);
    var kObj = new MkObj(kObjData, kObjCont);
    for (var attribute : modelObj.eClass().getEAllAttributes()) {
      if (!attribute.isChangeable() || attribute.isDerived()) {
        continue;
      }
      var attributeName = attribute.getName();
      var attributeValue = FileUtils.getModelObjectFeature(modelObj, attributeName);
      var attributeValueStr = (attributeValue == null) ? null : attributeValue.toString();
      kObjAttrs.put(attributeName, attributeValueStr);
    }

    return kObj;
  }

  private static void addKReferences(EObject modelObj, MkObj kObj, Map<EObject, MkObj> eObjToKObj)
                                    throws MMINTException {
    var kObjRefs = ((MkObjData) kObj.getData()).getRefs();
    var kObjCont = kObj.getContains();
    for (var reference : modelObj.eClass().getEAllReferences()) {
      if (!reference.isChangeable() || reference.isDerived()) {
        continue;
      }
      var referenceName = reference.getName();
      var referenceValue = FileUtils.getModelObjectFeature(modelObj, referenceName);
      if (referenceValue == null || referenceValue instanceof EObjectWithInverseResolvingEList<?>) {
        continue;
      }
      LList<Object> referencedKObjs;
      if (referenceValue instanceof EList<?> referenceValues) {
        referencedKObjs = LList.Companion.<Object>of(
          referenceValues.stream().map(v -> eObjToKObj.get(v)).toArray(Object[]::new));
      }
      else {
        referencedKObjs = LList.Companion.<Object>of(eObjToKObj.get(referenceValue));
      }
      if (reference.isContainment()) {
        kObjCont.put(referenceName, referencedKObjs);
      }
      else {
        kObjRefs.put(referenceName, referencedKObjs);
      }
    }
  }

  public static MkObj modelToKModel(Model model) throws MMINTException {
    var eObjToKObj = new HashMap<EObject, MkObj>();
    var rootModelObj = model.getEMFInstanceRoot();
    var rootKObj = eObjectToKObject(rootModelObj);
    eObjToKObj.put(rootModelObj, rootKObj);
    for (var iter = rootModelObj.eAllContents(); iter.hasNext(); ) {
      var modelObj = iter.next();
      eObjToKObj.put(modelObj, eObjectToKObject(modelObj));
    }
    for (var entry : eObjToKObj.entrySet()) {
      addKReferences(entry.getKey(), entry.getValue(), eObjToKObj);
    }

    return rootKObj;
  }

  private static EObject kObjectToEObject(MkObj kObj, EPackage modelPackage) {
    var modelFactory = modelPackage.getEFactoryInstance();
    var kObjData = (MkObjData) kObj.getData();
    var modelObj = modelFactory.create((EClass) modelPackage.getEClassifier(kObjData.getKind()));
    for (var kAttrEntry : kObjData.getAttrs().entrySet()) {
      var eAttr = (EAttribute) modelObj.eClass().getEStructuralFeature(kAttrEntry.getKey());
      var value = FileUtils.convertStringToEType(eAttr, kAttrEntry.getValue());
      modelObj.eSet(eAttr, value);
    }

    return modelObj;
  }

  private static EObject kObjectsToEObjects(MkObj kObj, EPackage modelPackage, Map<MkObj, EObject> kObjToEObj)
                                           throws MMINTException {
    var modelObj = kObjectToEObject(kObj, modelPackage);
    kObjToEObj.put(kObj, modelObj);
    for (var kContEntry : kObj.getContains().entrySet()) {
      var eCont = modelObj.eClass().getEStructuralFeature(kContEntry.getKey());
      for (var kObjContained : LlistKt.toList(kContEntry.getValue())) {
        var modelObjContained = kObjectsToEObjects((MkObj) kObjContained, modelPackage, kObjToEObj);
        FileUtils.setModelObjectFeature(modelObj, eCont, modelObjContained);
      }
    }

    return modelObj;
  }

  private static void addEReferences(MkObj kObj, EObject modelObj, Map<MkObj, EObject> kObjToEObj)
                                    throws MMINTException {
    for (var kRefEntry : ((MkObjData) kObj.getData()).getRefs().entrySet()) {
      var eRef = modelObj.eClass().getEStructuralFeature(kRefEntry.getKey());
      for (var kObjRef : LlistKt.toList(kRefEntry.getValue())) {
        FileUtils.setModelObjectFeature(modelObj, eRef, kObjToEObj.get(kObjRef));
      }
    }
  }

  public static EObject kModelToModel(MkObj kModel, EPackage modelPackage) throws MMINTException {
    var kObjToEObj = new HashMap<MkObj, EObject>();
    var rootModelObj = kObjectsToEObjects(kModel, modelPackage, kObjToEObj);
    for (var entry : kObjToEObj.entrySet()) {
      addEReferences(entry.getKey(), entry.getValue(), kObjToEObj);
    }

    return rootModelObj;
  }
}
