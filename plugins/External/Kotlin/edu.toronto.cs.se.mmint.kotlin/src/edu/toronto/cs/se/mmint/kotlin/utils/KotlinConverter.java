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
import java.util.List;
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

public class KotlinConverter {

  protected Tree<Object> eObjectToKTree(EObject modelObj) throws MMINTException {
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

  protected void eRefsToKRefs(EObject modelObj, Tree<Object> kTree, Map<EObject, Tree<Object>> eObjToKTree)
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

  public Tree<Object> modelToKTree(Model model) throws MMINTException {
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

  protected String eObjectToKFile(EObject modelObj, int i) throws MMINTException {
    var kStr = "  val obj" + i + "Refs = mutableMapOf<String, LList<Tree<Object>>>()\n";
    kStr += "  val obj" + i + "Cont = mutableMapOf<String, LList<Tree<Object>>>()\n";
    kStr += "  val obj" + i + " = MkTree(MkObj(uri=\"" + MIDRegistry.getModelElementUri(modelObj) + "\", kind=\"" +
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
      kStr += "\"" + attributeName + "\" to \"" + attributeValue.toString().replace("$", "\\$") + "\", ";
    }
    kStr += "), refs=obj" + i + "Refs), contains=obj" + i + "Cont)\n";

    return kStr;
  }

  protected String eRefsToKFile(EObject modelObj, String kObjVar, Map<EObject, String> eObjToKVar, int i)
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
          kStr += "  val ext" + i + " = MkTree(MkObj(uri=\"" + MIDRegistry.getModelElementUri(referenceModelObj) +
                  "\", kind=\"" + referenceModelObj.eClass().getName() +
                  "\", attrs=mapOf(), refs=mutableMapOf()), contains=mapOf())\n";
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

  public void modelToKFile(Model model, String filePath, boolean isWorkspaceRelative) throws Exception {
    if (isWorkspaceRelative) {
      filePath = FileUtils.prependWorkspacePath(filePath);
    }
    try (var writer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"))) {
      writer.write("package edu.toronto.cs.se.mmint.kotlin.operators.examples\n" +
                   "import edu.toronto.cs.se.mmint.kotlin.structs.*\n\n" +
                   "fun create" + model.getName() + "() : Tree<Object> {\n");
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

  public record KEObject (Object kObj, EObject modelObj) {}

  protected EObject kObjToEObject(Object kObj, EPackage modelPackage) {
    var modelFactory = modelPackage.getEFactoryInstance();
    var modelObj = modelFactory.create((EClass) modelPackage.getEClassifier(kObj.getKind()));
    for (var kAttrEntry : kObj.getAttrs().entrySet()) {
      var attribute = (EAttribute) modelObj.eClass().getEStructuralFeature(kAttrEntry.getKey());
      var attributeValue = FileUtils.convertStringToEType(attribute, kAttrEntry.getValue());
      modelObj.eSet(attribute, attributeValue);
    }

    return modelObj;
  }

  protected EObject kTreeToEObjects(MkTree<? extends Object> kTree, EPackage modelPackage,
                                    Map<String, KEObject> kUrisToKEObj) throws MMINTException {
    var kObj = kTree.getNode();
    var modelObj = kObjToEObject(kObj, modelPackage);
    kUrisToKEObj.put(kObj.getUri(), new KEObject(kObj, modelObj));
    for (var kContEntry : kTree.getContains().entrySet()) {
      var containment = modelObj.eClass().getEStructuralFeature(kContEntry.getKey());
      for (var containedkObj : LlistKt.toList(kContEntry.getValue())) {
        var containedModelObj = kTreeToEObjects((MkTree<? extends Object>) containedkObj, modelPackage, kUrisToKEObj);
        FileUtils.setModelObjectFeature(modelObj, containment, containedModelObj);
      }
    }

    return modelObj;
  }

  protected void kRefsToERefs(KEObject keObj, Map<String, KEObject> kUriToKEObj) throws Exception {
    for (var kRefEntry : keObj.kObj().getRefs().entrySet()) {
      var reference = keObj.modelObj().eClass().getEStructuralFeature(kRefEntry.getKey());
      for (var referenceKTree : LlistKt.toList(kRefEntry.getValue())) {
        var referenceUri = ((MkTree<? extends Object>) referenceKTree).getNode().getUri();
        var referenceKEObj = kUriToKEObj.get(referenceUri);
        if (referenceKEObj == null) { // reference to external element
          try {
            if (referenceUri.startsWith("http")) {
              var metamodel = EPackage.Registry.INSTANCE.getEPackage(MIDRegistry.getModelUri(referenceUri));
              referenceKEObj = new KEObject(null, FileUtils.readModelObject(referenceUri, metamodel.eResource()));
            }
            else {
              referenceKEObj = new KEObject(null, FileUtils.readModelObject(referenceUri, null));
            }
            kUriToKEObj.put(referenceUri, referenceKEObj);
          }
          catch (Exception e) {
            MMINTException.print(IStatus.INFO, "Reference with uri " + referenceUri + " not found, skipping it", e);
          }
        }
        FileUtils.setModelObjectFeature(keObj.modelObj(), reference, referenceKEObj.modelObj());
      }
    }
  }

  public EObject kTreeToModel(Tree<? extends Object> kTree, EPackage modelPackage) throws Exception {
    // can't use kTrees as keys because they can have circular refs and hashcode will go into an infinite loop
    var kUriToKEObj = new HashMap<String, KEObject>();
    var rootModelObj = kTreeToEObjects((MkTree<? extends Object>) kTree, modelPackage, kUriToKEObj);
    for (var keObj : List.copyOf(kUriToKEObj.values())) {
      kRefsToERefs(keObj, kUriToKEObj);
    }

    return rootModelObj;
  }
}
