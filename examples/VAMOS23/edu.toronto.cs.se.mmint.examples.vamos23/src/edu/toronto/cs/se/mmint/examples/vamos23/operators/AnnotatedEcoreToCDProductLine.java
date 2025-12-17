/*******************************************************************************
 * Copyright (c) 2022, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.vamos23.operators;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.operators.bridge.ToProductLine;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;

public class AnnotatedEcoreToCDProductLine extends ToProductLine {
  public final static OperatorParameter IN0 = ToProductLine.IN0.specialize(EcorePackage.eNS_URI);

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    inputProperties.setProperty(ToProductLine.PROP_REASONERNAME, "LogicNG");
    super.init(inputProperties, inputsByName);
    this.out0.setMetamodel(edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE);
  }

  protected Class createPLClass(EModelElement modelObj, EClass plType, Map<String, Class> plClasses) {
    var plClass = this.builder.createClass(plType);
    this.out0.getClasses().add(plClass);
    var presenceCondition = this.reasoner.getTrueLiteral();
    var eAnnotation = modelObj.getEAnnotation("presence");
    if (eAnnotation != null) {
      var eDetail = eAnnotation.getDetails().get("condition");
      if (eDetail != null) {
        presenceCondition = eDetail;
      }
    }
    //TODO handle multiple presence conditions
    plClass.setPresenceCondition(presenceCondition);
    plClasses.put(MIDRegistry.getModelElementUri(modelObj), plClass);

    return plClass;
  }

  @Override
  protected void toProductLine(Map<String, Model> inputsByName) throws Exception {
    var plClasses = new HashMap<String, Class>();
    var plEPackage = createPLClass((EModelElement) this.in0, ClassDiagramPackage.eINSTANCE.getClassDiagram(), plClasses);
    for (var eClassifier : ((EPackage) this.in0).getEClassifiers()) {
      var plEClass = createPLClass(eClassifier, ClassDiagramPackage.eINSTANCE.getClass_(), plClasses);
      var plEClassPC = plEClass.getPresenceCondition();
      var classIsTrue = plEClass.isInAllProducts();
      plEClass.addReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes(), plEPackage, plEClassPC);
      plEClass.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eClassifier.getName());
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      for (var eAttribute : eClass.getEAttributes()) {
        var plEAttribute = createPLClass(eAttribute, ClassDiagramPackage.eINSTANCE.getAttribute(), plClasses);
        var plEAttributePC = plEAttribute.getPresenceCondition();
        if (!classIsTrue) {
          plEAttributePC = (plEAttribute.isInAllProducts()) ?
            plEClassPC :
            this.reasoner.simplify(this.reasoner.and(plEAttributePC, plEClassPC));
          plEAttribute.setPresenceCondition(plEAttributePC);
        }
        plEAttribute.addReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes(), plEClass, plEAttributePC);
        plEAttribute.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eAttribute.getName())
          .setPresenceCondition(plEAttributePC);
        plEAttribute.addAttribute(ClassDiagramPackage.eINSTANCE.getTypedElement_Public(), "true")
          .setPresenceCondition(plEAttributePC);
      }
      for (var eOperation : eClass.getEOperations()) {
        var plEOperation = createPLClass(eOperation, ClassDiagramPackage.eINSTANCE.getOperation(), plClasses);
        var plEOperationPC = plEOperation.getPresenceCondition();
        if (!classIsTrue) {
          plEOperationPC = (plEOperation.isInAllProducts()) ?
            plEClassPC :
            this.reasoner.simplify(this.reasoner.and(plEOperationPC, plEClassPC));
          plEOperation.setPresenceCondition(plEOperationPC);
        }
        plEOperation.addReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations(), plEClass, plEOperationPC);
        plEOperation.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eOperation.getName())
          .setPresenceCondition(plEOperationPC);
      }
    }

    for (var eClassifier : ((EPackage) this.in0).getEClassifiers()) {
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      var plEClass = plClasses.get(MIDRegistry.getModelElementUri(eClass));
      var plEClassPC = plEClass.getPresenceCondition();
      var classIsTrue = plEClass.isInAllProducts();
      for (var eSuperclass : eClass.getESuperTypes()) {
        var plESuperclass = plClasses.get(MIDRegistry.getModelElementUri(eSuperclass));
        var plESuperclassPC = plESuperclass.getPresenceCondition();
        if (!classIsTrue) {
          plESuperclassPC = (plESuperclass.isInAllProducts()) ?
            plEClassPC :
            this.reasoner.simplify(this.reasoner.and(plESuperclassPC, plEClassPC));
        }
        plESuperclass.addReference(ClassDiagramPackage.eINSTANCE.getClass_Superclass(), plEClass, plESuperclassPC);
      }
      for (var eAttribute : eClass.getEAttributes()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eAttribute));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eAttribute.getEType()));
        if (plTgt == null) {
          // type is primitive
          plTgt = createPLClass(eAttribute.getEType(), ClassDiagramPackage.eINSTANCE.getDataType(), plClasses);
          plTgt.addReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Datatypes(), plEPackage);
          plTgt.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eAttribute.getEType().getName());
        }
        plTgt.addReference(ClassDiagramPackage.eINSTANCE.getTypedElement_Type(), plSrc, plSrc.getPresenceCondition());
      }
      for (var eOperation : eClass.getEOperations()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eOperation));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eOperation.getEType()));
        if (plTgt == null) {
          // type is primitive
          plTgt = createPLClass(eOperation.getEType(), ClassDiagramPackage.eINSTANCE.getDataType(), plClasses);
          plTgt.addReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Datatypes(), plEPackage);
          plTgt.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eOperation.getEType().getName());
        }
        plTgt.addReference(ClassDiagramPackage.eINSTANCE.getTypedElement_Type(), plSrc, plSrc.getPresenceCondition());
      }
      for (var eReference : eClass.getEReferences()) {
        var plEReference = createPLClass(eReference, ClassDiagramPackage.eINSTANCE.getAssociation(), plClasses);
        var plEClassTgt = plClasses.get(MIDRegistry.getModelElementUri(eReference.getEType()));
        var plEClassTgtPC = plEClassTgt.getPresenceCondition();
        var plEReferencePC = plEReference.getPresenceCondition();
        var tgtIsTrue = plEClassTgt.isInAllProducts();
        var assocIsTrue = plEReference.isInAllProducts();
        if (classIsTrue) {
          // tgtIsTrue => plEReferencePC stays as-is
          if (!tgtIsTrue) {
            plEReferencePC = (assocIsTrue) ?
              plEClassTgtPC :
              this.reasoner.simplify(this.reasoner.and(plEReferencePC, plEClassTgtPC));
          }
        }
        else { // !classIsTrue
          if (tgtIsTrue) {
            plEReferencePC = (assocIsTrue) ?
              plEClassPC :
              this.reasoner.simplify(this.reasoner.and(plEReferencePC, plEClassPC));
          }
          else { // !tgtIsTrue
            plEReferencePC = (assocIsTrue) ?
              this.reasoner.simplify(this.reasoner.and(plEClassPC, plEClassTgtPC)) :
              this.reasoner.simplify(this.reasoner.and(plEReferencePC, plEClassPC, plEClassTgtPC));
          }
        }
        plEReference.setPresenceCondition(plEReferencePC);
        plEReference.addReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations(), plEPackage,
                                  plEReferencePC);
        plEReference.addReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource(), plEClass,
                                  plEReferencePC);
        plEReference.addReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget(), plEClassTgt,
                                  plEReferencePC);
        plEReference.addAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eReference.getName())
          .setPresenceCondition(plEReferencePC);
      }
    }
  }
}
