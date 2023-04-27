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
import edu.toronto.cs.se.mmint.kotlin.structs.MkTree;
import edu.toronto.cs.se.mmint.kotlin.structs.Object;
import edu.toronto.cs.se.mmint.kotlin.structs.Tree;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class KotlinUtils {

  private static Tree<Object> eObjectToKTree(EObject modelObj) throws MMINTException {
    var kObjAttrs = new HashMap<String, String>();
    var kObjRefs = new HashMap<String, LList<Tree<Object>>>();
    var kObjCont = new HashMap<String, LList<Tree<Object>>>();
    var kObj = new MkObj(MIDRegistry.getModelElementUri(modelObj), modelObj.eClass().getName(), kObjAttrs, kObjRefs);
    var kTree = new MkTree<>(kObj, kObjCont);
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

    return kTree;
  }

  private static void eRefsToKRefs(EObject modelObj, Tree<Object> kTree, Map<EObject, Tree<Object>> eObjToKTree)
                                  throws MMINTException {
    var kObjRefs = ((MkTree<Object>) kTree).getNode().getRefs();
    var kObjCont = ((MkTree<Object>) kTree).getContains();
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
      var referenceKTrees = new ArrayList<Tree<Object>>();
      for (var referenceModelObj : referenceModelObjs) {
        var referenceKTree = eObjToKTree.computeIfAbsent(referenceModelObj,
          k -> new MkTree<>( // reference to external element
                 new MkObj(MIDRegistry.getModelElementUri(k), k.eClass().getName(), Map.of(), Map.of()), Map.of()));
        referenceKTrees.add(referenceKTree);
      }
      var kObjMap = (reference.isContainment()) ? kObjCont : kObjRefs;
      kObjMap.put(referenceName, LlistKt.toLList(referenceKTrees));
    }
  }

  public static Tree<Object> modelToKTree(Model model) throws MMINTException {
    var eObjToKTree = new HashMap<EObject, Tree<Object>>();
    var rootModelObj = model.getEMFInstanceRoot();
    var rootKTree = eObjectToKTree(rootModelObj);
    eObjToKTree.put(rootModelObj, rootKTree);
    for (var iter = rootModelObj.eAllContents(); iter.hasNext(); ) {
      var modelObj = iter.next();
      eObjToKTree.put(modelObj, eObjectToKTree(modelObj));
    }
    for (var entry : Set.copyOf(eObjToKTree.entrySet())) {
      eRefsToKRefs(entry.getKey(), entry.getValue(), eObjToKTree);
    }

    return rootKTree;
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

  private static EObject kTreeToEObject(Tree<? extends Object> kTree, EPackage modelPackage) {
    var modelFactory = modelPackage.getEFactoryInstance();
    var kObj = ((MkTree<? extends Object>) kTree).getNode();
    var modelObj = modelFactory.create((EClass) modelPackage.getEClassifier(kObj.getKind()));
    for (var kAttrEntry : kObj.getAttrs().entrySet()) {
      var attribute = (EAttribute) modelObj.eClass().getEStructuralFeature(kAttrEntry.getKey());
      var attributeValue = FileUtils.convertStringToEType(attribute, kAttrEntry.getValue());
      modelObj.eSet(attribute, attributeValue);
    }

    return modelObj;
  }

  private static EObject kTreesToEObjects(Tree<? extends Object> kTree, EPackage modelPackage,
                                          Map<Tree<? extends Object>, EObject> kTreeToEObj) throws MMINTException {
    var modelObj = kTreeToEObject(kTree, modelPackage);
    kTreeToEObj.put(kTree, modelObj);
    for (var kContEntry : ((MkTree<? extends Object>) kTree).getContains().entrySet()) {
      var containment = modelObj.eClass().getEStructuralFeature(kContEntry.getKey());
      for (var containedkObj : LlistKt.toList(kContEntry.getValue())) {
        var containedModelObj = kTreesToEObjects(containedkObj, modelPackage, kTreeToEObj);
        FileUtils.setModelObjectFeature(modelObj, containment, containedModelObj);
      }
    }

    return modelObj;
  }

  private static void kRefsToERefs(Tree<? extends Object> kTree, EObject modelObj,
                                   Map<Tree<? extends Object>, EObject> kTreeToEObj) throws Exception {
    for (var kRefEntry : ((MkTree<? extends Object>) kTree).getNode().getRefs().entrySet()) {
      var reference = modelObj.eClass().getEStructuralFeature(kRefEntry.getKey());
      for (var referenceKTree : LlistKt.toList(kRefEntry.getValue())) {
        var referenceModelObj = kTreeToEObj.get(referenceKTree);
        if (referenceModelObj == null) { // reference to external element
          var referenceUri = ((MkTree<? extends Object>) referenceKTree).getNode().getUri();
          try {
            if (referenceUri.startsWith("http")) {
              var metamodel = EPackage.Registry.INSTANCE.getEPackage(MIDRegistry.getModelUri(referenceUri));
              referenceModelObj = FileUtils.readModelObject(referenceUri, metamodel.eResource());
            }
            else {
              referenceModelObj = FileUtils.readModelObject(referenceUri, null);
            }
            kTreeToEObj.put(referenceKTree, referenceModelObj);
          }
          catch (Exception e) {
            MMINTException.print(IStatus.INFO, "Reference with uri " + referenceUri + " not found, skipping it", e);
          }
        }
        FileUtils.setModelObjectFeature(modelObj, reference, referenceModelObj);
      }
    }
  }

  public static EObject kTreeToModel(Tree<? extends Object> kTree, EPackage modelPackage) throws Exception {
    var kTreeToEObj = new HashMap<Tree<? extends Object>, EObject>();
    var rootModelObj = kTreesToEObjects(kTree, modelPackage, kTreeToEObj);
    for (var entry : Set.copyOf(kTreeToEObj.entrySet())) {
      kRefsToERefs(entry.getKey(), entry.getValue(), kTreeToEObj);
    }

    return rootModelObj;
  }
}
