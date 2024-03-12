/*******************************************************************************
 * Copyright (c) 2022, 2024 Alessio Di Sandro.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.operators.ToProductLine;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;

public class AnnotatedEcoreToCDProductLine extends ToProductLine {

  protected static class AnnotatedEcoreToCDPLOut extends Out {
    public AnnotatedEcoreToCDPLOut(Map<String, MID> outputMIDsByName, String workingPath, In in)
                                  throws MMINTException {
      super(outputMIDsByName, workingPath, in);
      this.productLine.setMetamodel(edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE);
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.reasonerName = "LogicNG";
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName);
    this.out = new AnnotatedEcoreToCDPLOut(outputMIDsByName, getWorkingPath(), this.in);
  }

  private void addPresenceCondition(EModelElement eModelObj, PLElement plElem) {
    var presenceCondition = this.in.reasoner.getTrueLiteral();
    var eAnnotation = eModelObj.getEAnnotation("presence");
    if (eAnnotation != null) {
      var eDetail = eAnnotation.getDetails().get("condition");
      if (eDetail != null) {
        presenceCondition = eDetail;
      }
    }
    //TODO handle multiple presence conditions
    plElem.setPresenceCondition(presenceCondition);
  }

  @Override
  protected Class createPLClass(EObject modelObj, EClass plType, Map<String, Class> plClasses) {
    var plClass = super.createPLClass(modelObj, plType, plClasses);
    addPresenceCondition((EModelElement) modelObj, plClass);

    return plClass;
  }

  @Override
  protected void toProductLine() {
    var ePackage = (EPackage) this.in.productModel.getEMFInstanceRoot();
    var plClasses = new HashMap<String, Class>();
    var plEPackage = createPLClass(ePackage, ClassDiagramPackage.eINSTANCE.getClassDiagram(), plClasses);

    for (var eClassifier : ePackage.getEClassifiers()) {
      var plEClass = createPLClass(eClassifier, ClassDiagramPackage.eINSTANCE.getClass_(), plClasses);
      var plEClassPC = plEClass.getPresenceCondition();
      var classIsTrue = plEClass.isAlwaysPresent();
      createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes(), plEPackage, plEClass)
        .setPresenceCondition(plEClassPC);
      createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eClassifier.getName(), plEClass)
        .setPresenceCondition(plEClassPC);
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      for (var eAttribute : eClass.getEAttributes()) {
        var plEAttribute = createPLClass(eAttribute, ClassDiagramPackage.eINSTANCE.getAttribute(), plClasses);
        var plEAttributePC = plEAttribute.getPresenceCondition();
        if (!classIsTrue) {
          plEAttributePC = (plEAttribute.isAlwaysPresent()) ?
            plEClassPC :
            this.in.reasoner.simplify(this.in.reasoner.and(plEAttributePC, plEClassPC));
          plEAttribute.setPresenceCondition(plEAttributePC);
        }
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes(), plEClass, plEAttribute)
          .setPresenceCondition(plEAttributePC);
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eAttribute.getName(), plEAttribute)
          .setPresenceCondition(plEAttributePC);
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getTypedElement_Public(), "true", plEAttribute)
          .setPresenceCondition(plEAttributePC);
      }
      for (var eOperation : eClass.getEOperations()) {
        var plEOperation = createPLClass(eOperation, ClassDiagramPackage.eINSTANCE.getOperation(), plClasses);
        var plEOperationPC = plEOperation.getPresenceCondition();
        if (!classIsTrue) {
          plEOperationPC = (plEOperation.isAlwaysPresent()) ?
            plEClassPC :
            this.in.reasoner.simplify(this.in.reasoner.and(plEOperationPC, plEClassPC));
          plEOperation.setPresenceCondition(plEOperationPC);
        }
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations(), plEClass, plEOperation)
          .setPresenceCondition(plEOperationPC);
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eOperation.getName(), plEOperation)
          .setPresenceCondition(plEOperationPC);
      }
    }

    for (var eClassifier : ePackage.getEClassifiers()) {
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      var plEClass = plClasses.get(MIDRegistry.getModelElementUri(eClass));
      var plEClassPC = plEClass.getPresenceCondition();
      var classIsTrue = plEClass.isAlwaysPresent();
      for (var eSuperclass : eClass.getESuperTypes()) {
        var plESuperclass = plClasses.get(MIDRegistry.getModelElementUri(eSuperclass));
        var plESuperclassPC = plESuperclass.getPresenceCondition();
        if (!classIsTrue) {
          plESuperclassPC = (plESuperclass.isAlwaysPresent()) ?
            plEClassPC :
            this.in.reasoner.simplify(this.in.reasoner.and(plESuperclassPC, plEClassPC));
        }
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_Superclass(), plEClass, plESuperclass)
          .setPresenceCondition(plESuperclassPC);
      }
      for (var eAttribute : eClass.getEAttributes()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eAttribute));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eAttribute.getEType()));
        if (plTgt == null) {
          // type is primitive
          plTgt = createPLClass(eAttribute.getEType(), ClassDiagramPackage.eINSTANCE.getDataType(), plClasses);
          createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Datatypes(), plEPackage, plTgt);
          createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eAttribute.getEType().getName(), plTgt);
        }
        createPLReference(ClassDiagramPackage.eINSTANCE.getTypedElement_Type(), plSrc, plTgt)
          .setPresenceCondition(plSrc.getPresenceCondition());
      }
      for (var eOperation : eClass.getEOperations()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eOperation));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eOperation.getEType()));
        if (plTgt == null) {
          // type is primitive
          plTgt = createPLClass(eOperation.getEType(), ClassDiagramPackage.eINSTANCE.getDataType(), plClasses);
          createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Datatypes(), plEPackage, plTgt);
          createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eOperation.getEType().getName(), plTgt);
        }
        createPLReference(ClassDiagramPackage.eINSTANCE.getTypedElement_Type(), plSrc, plTgt)
          .setPresenceCondition(plSrc.getPresenceCondition());
      }
      for (var eReference : eClass.getEReferences()) {
        var plEReference = createPLClass(eReference, ClassDiagramPackage.eINSTANCE.getAssociation(), plClasses);
        var plEClassTgt = plClasses.get(MIDRegistry.getModelElementUri(eReference.getEType()));
        var plEClassTgtPC = plEClassTgt.getPresenceCondition();
        var plEReferencePC = plEReference.getPresenceCondition();
        var tgtIsTrue = plEClassTgt.isAlwaysPresent();
        var assocIsTrue = plEReference.isAlwaysPresent();
        if (classIsTrue) {
          // tgtIsTrue => plEReferencePC stays as-is
          if (!tgtIsTrue) {
            plEReferencePC = (assocIsTrue) ?
              plEClassTgtPC :
              this.in.reasoner.simplify(this.in.reasoner.and(plEReferencePC, plEClassTgtPC));
          }
        }
        else { // !classIsTrue
          if (tgtIsTrue) {
            plEReferencePC = (assocIsTrue) ?
              plEClassPC :
              this.in.reasoner.simplify(this.in.reasoner.and(plEReferencePC, plEClassPC));
          }
          else { // !tgtIsTrue
            plEReferencePC = (assocIsTrue) ?
              this.in.reasoner.simplify(this.in.reasoner.and(plEClassPC, plEClassTgtPC)) :
              this.in.reasoner.simplify(this.in.reasoner.and(plEReferencePC, this.in.reasoner.and(plEClassPC, plEClassTgtPC)));
          }
        }
        plEReference.setPresenceCondition(plEReferencePC);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations(), plEPackage, plEReference)
          .setPresenceCondition(plEReferencePC);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource(), plEClass, plEReference)
          .setPresenceCondition(plEReferencePC);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget(), plEClassTgt, plEReference)
          .setPresenceCondition(plEReferencePC);
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eReference.getName(), plEReference)
          .setPresenceCondition(plEReferencePC);
      }
    }
  }
}
