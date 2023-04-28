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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
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
      var referenceModelObjs = (referenceValue instanceof EList<?>) ?
        (EList<EObject>) referenceValue :
        ECollections.asEList((EObject) referenceValue);
      if (referenceModelObjs.isEmpty()) {
        continue;
      }
      var referenceKObjs = new ArrayList<Object>();
      for (var referenceModelObj : referenceModelObjs) {
        var referenceKObj = eObjToKObj.computeIfAbsent(referenceModelObj,
          k -> new MkObj( // reference to external element
            new MkObjData(MIDRegistry.getModelElementUri(k), k.eClass().getName(), Map.of(), Map.of()), Map.of()));
        referenceKObjs.add(referenceKObj);
      }
      var kObjMap = (reference.isContainment()) ? kObjCont : kObjRefs;
      kObjMap.put(referenceName, LList.Companion.<Object>of(referenceKObjs.toArray(new Object[0])));
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
    for (var entry : Set.copyOf(eObjToKObj.entrySet())) {
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

  private static String eRefsToKFile(EObject modelObj, String kObjVar, Map<EObject, String> eObjToKVar, int i)
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
      var referenceModelObjs = (referenceValue instanceof EList<?>) ?
        (EList<EObject>) referenceValue :
        ECollections.asEList((EObject) referenceValue);
      if (referenceModelObjs.isEmpty()) {
        continue;
      }
      var referenceKVars = new ArrayList<String>();
      for (var referenceModelObj : referenceModelObjs) {
        var kExtVar = "ext" + i;
        var referenceKVar = eObjToKVar.computeIfAbsent(referenceModelObj, k -> kExtVar);
        if (referenceKVar.equals(kExtVar)) { // reference to external element
          kStr += "  val ext" + i + " = MkObj(MkObjData(uri=\"" + MIDRegistry.getModelElementUri(referenceModelObj) +
                  "\", kind=\"" + referenceModelObj.eClass().getName() +
                  "\", attrs=mapOf(), refs=mapOf()), contains=mapOf())\n";
          i++;
        }
        referenceKVars.add(referenceKVar);
      }
      kStr += "  " + kObjVar;
      kStr += (reference.isContainment()) ? "Cont" : "Refs";
      kStr += "[\"" + referenceName + "\"] = LList.of(" + String.join(", ", referenceKVars) + ")\n";
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
      var j = 0;
      for (var entry : Set.copyOf(eObjToKVar.entrySet())) {
        var count = eObjToKVar.size();
        writer.write(eRefsToKFile(entry.getKey(), entry.getValue(), eObjToKVar, j));
        j += (eObjToKVar.size() - count);
      }
      writer.write("  return obj0\n}\n");
    }
  }

  private static EObject kObjectToEObject(MkObj kObj, EPackage modelPackage) {
    var modelFactory = modelPackage.getEFactoryInstance();
    var kObjData = (MkObjData) kObj.getData();
    var modelObj = modelFactory.create((EClass) modelPackage.getEClassifier(kObjData.getKind()));
    for (var kAttrEntry : kObjData.getAttrs().entrySet()) {
      var attribute = (EAttribute) modelObj.eClass().getEStructuralFeature(kAttrEntry.getKey());
      var attributeValue = FileUtils.convertStringToEType(attribute, kAttrEntry.getValue());
      modelObj.eSet(attribute, attributeValue);
    }

    return modelObj;
  }

  private static EObject kObjectsToEObjects(MkObj kObj, EPackage modelPackage, Map<MkObj, EObject> kObjToEObj)
                                           throws MMINTException {
    var modelObj = kObjectToEObject(kObj, modelPackage);
    kObjToEObj.put(kObj, modelObj);
    for (var kContEntry : kObj.getContains().entrySet()) {
      var containment = modelObj.eClass().getEStructuralFeature(kContEntry.getKey());
      for (var containedkObj : LlistKt.toList(kContEntry.getValue())) {
        var containedModelObj = kObjectsToEObjects((MkObj) containedkObj, modelPackage, kObjToEObj);
        FileUtils.setModelObjectFeature(modelObj, containment, containedModelObj);
      }
    }

    return modelObj;
  }

  private static void kRefsToERefs(MkObj kObj, EObject modelObj, Map<MkObj, EObject> kObjToEObj) throws Exception {
    for (var kRefEntry : ((MkObjData) kObj.getData()).getRefs().entrySet()) {
      var reference = modelObj.eClass().getEStructuralFeature(kRefEntry.getKey());
      for (var referenceKObj : LlistKt.toList(kRefEntry.getValue())) {
        var referenceModelObj = kObjToEObj.get(referenceKObj);
        if (referenceModelObj == null) { // reference to external element
          var referenceUri = ((MkObjData) ((MkObj) referenceKObj).getData()).getUri();
          try {
            if (referenceUri.startsWith("http")) {
              var metamodel = EPackage.Registry.INSTANCE.getEPackage(MIDRegistry.getModelUri(referenceUri));
              referenceModelObj = FileUtils.readModelObject(referenceUri, metamodel.eResource());
            }
            else {
              referenceModelObj = FileUtils.readModelObject(referenceUri, null);
            }
            kObjToEObj.put((MkObj) referenceKObj, referenceModelObj);
          }
          catch (Exception e) {
            MMINTException.print(IStatus.INFO, "Reference with uri " + referenceUri + " not found, skipping it", e);
          }
        }
        FileUtils.setModelObjectFeature(modelObj, reference, referenceModelObj);
      }
    }
  }

  public static EObject kModelToModel(MkObj kModel, EPackage modelPackage) throws Exception {
    var kObjToEObj = new HashMap<MkObj, EObject>();
    var rootModelObj = kObjectsToEObjects(kModel, modelPackage, kObjToEObj);
    for (var entry : Set.copyOf(kObjToEObj.entrySet())) {
      kRefsToERefs(entry.getKey(), entry.getValue(), kObjToEObj);
    }

    return rootModelObj;
  }
}
