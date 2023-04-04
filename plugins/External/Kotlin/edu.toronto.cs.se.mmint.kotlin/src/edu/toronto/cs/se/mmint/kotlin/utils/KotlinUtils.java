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

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
      if (attributeValue == null) {
        continue;
      }
      kObjAttrs.put(attributeName, attributeValue.toString());
    }

    return kObj;
  }

  private static void eRefsToKRefs(EObject modelObj, MkObj kObj, Map<EObject, MkObj> eObjToKObj) throws MMINTException {
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
        if (referenceValues.isEmpty()) {
          continue;
        }
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
      eRefsToKRefs(entry.getKey(), entry.getValue(), eObjToKObj);
    }

    return rootKObj;
  }

  private static String eObjectToKFile(EObject modelObj, int i) throws MMINTException {
    var kStr = "  val obj" + i + "Refs = mutableMapOf<String, LList<Object>>()\n";
    kStr += "  val obj" + i + "Cont = mutableMapOf<String, LList<Object>>()\n";
    kStr += "  val obj" + i + " = MkObj(MkObjData(uri=\"" + MIDRegistry.getModelElementUri(modelObj) + "\", kind=\"" +
              modelObj.eClass().getName() + "\", attrs=mapOf(";
    for (var attribute : modelObj.eClass().getEAllAttributes()) {
      if (!attribute.isChangeable() || attribute.isDerived()) {
        continue;
      }
      var attributeName = attribute.getName();
      var attributeValue = FileUtils.getModelObjectFeature(modelObj, attributeName);
      if (attributeValue == null) {
        continue;
      }
      kStr += "\"" + attributeName + "\" to \"" + attributeValue.toString() + "\", ";
    }
    kStr += "), refs=obj" + i + "Refs), contains=obj" + i + "Cont)\n";

    return kStr;
  }

  private static String eRefsToKFile(EObject modelObj, String kObjVar, Map<EObject, String> eObjToKVar)
                                    throws MMINTException {
    var kStr = "";
    for (var reference : modelObj.eClass().getEAllReferences()) {
      if (!reference.isChangeable() || reference.isDerived()) {
        continue;
      }
      var referenceName = reference.getName();
      var referenceValue = FileUtils.getModelObjectFeature(modelObj, referenceName);
      if (referenceValue == null || referenceValue instanceof EObjectWithInverseResolvingEList<?>) {
        continue;
      }
      String referencedKVars;
      if (referenceValue instanceof EList<?> referenceValues) {
        if (referenceValues.isEmpty()) {
          continue;
        }
        referencedKVars = referenceValues.stream().map(v -> eObjToKVar.get(v)).collect(Collectors.joining(", "));
      }
      else {
        referencedKVars = eObjToKVar.get(referenceValue);
      }
      kStr += "  " + kObjVar;
      kStr += (reference.isContainment()) ? "Cont" : "Refs";
      kStr += "[\"" + referenceName + "\"] = LList.of(" + referencedKVars + ")\n";
    }

    return kStr;
  }

  public static void modelToKFile(Model model, String filePath, boolean isWorkspaceRelative) throws Exception {
    if (isWorkspaceRelative) {
      filePath = FileUtils.prependWorkspacePath(filePath);
    }
    try (var writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"))) {
      writer.write("package edu.toronto.cs.se.mmint.kotlin.operators.examples\n" +
                   "import edu.toronto.cs.se.mmint.kotlin.structs.*\n\n" +
                   "fun create" + model.getName() + "() : Object {\n");
      var i = 0;
      var eObjToKVar = new HashMap<EObject, String>();
      var rootModelObj = model.getEMFInstanceRoot();
      writer.write(eObjectToKFile(rootModelObj, i));
      eObjToKVar.put(rootModelObj, "obj" + i++);
      for (var iter = rootModelObj.eAllContents(); iter.hasNext(); ) {
        var modelObj = iter.next();
        writer.write(eObjectToKFile(modelObj, i));
        eObjToKVar.put(modelObj, "obj" + i++);
      }
      for (var entry : eObjToKVar.entrySet()) {
        writer.write(eRefsToKFile(entry.getKey(), entry.getValue(), eObjToKVar));
      }
      writer.write("  return obj0\n}\n");
    }
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

  private static void kRefsToERefs(MkObj kObj, EObject modelObj, Map<MkObj, EObject> kObjToEObj) throws MMINTException {
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
      kRefsToERefs(entry.getKey(), entry.getValue(), kObjToEObj);
    }

    return rootModelObj;
  }
}
