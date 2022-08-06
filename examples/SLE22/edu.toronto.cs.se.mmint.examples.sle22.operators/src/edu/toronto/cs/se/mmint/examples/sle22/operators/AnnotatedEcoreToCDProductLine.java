/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.sle22.operators;

import java.util.HashMap;
import java.util.Map;

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
    public AnnotatedEcoreToCDPLOut(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      super(outputMIDsByName, workingPath, in);
      this.productLine.setReasonerName("LogicNG");
      this.productLine.setMetamodel(edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName);
    this.out = new AnnotatedEcoreToCDPLOut(outputMIDsByName, getWorkingPath(), this.in);
  }

  private void addPresenceCondition(EModelElement eModelObj, PLElement plElem) {
    var presenceCondition = "true";
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
      createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes(), plEPackage, plEClass)
        .setPresenceCondition(plEClass.getPresenceCondition());
      createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eClassifier.getName(), plEClass)
        .setPresenceCondition(plEClass.getPresenceCondition());
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      for (var eAttribute : eClass.getEAttributes()) {
        var plEAttribute = createPLClass(eAttribute, ClassDiagramPackage.eINSTANCE.getAttribute(), plClasses);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes(), plEClass, plEAttribute)
          .setPresenceCondition(plEAttribute.getPresenceCondition());
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eAttribute.getName(), plEAttribute)
          .setPresenceCondition(plEAttribute.getPresenceCondition());
      }
      for (var eReference : eClass.getEReferences()) {
        var plEReference = createPLClass(eReference, ClassDiagramPackage.eINSTANCE.getAssociation(), plClasses);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations(), plEPackage, plEReference)
          .setPresenceCondition(plEReference.getPresenceCondition());
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource(), plEClass, plEReference)
          .setPresenceCondition(plEReference.getPresenceCondition());
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eReference.getName(), plEReference)
          .setPresenceCondition(plEReference.getPresenceCondition());
      }
      for (var eOperation : eClass.getEOperations()) {
        var plEOperation = createPLClass(eOperation, ClassDiagramPackage.eINSTANCE.getOperation(), plClasses);
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations(), plEClass, plEOperation)
          .setPresenceCondition(plEOperation.getPresenceCondition());
        createPLAttribute(ClassDiagramPackage.eINSTANCE.getNamedElement_Name(), eOperation.getName(), plEOperation)
          .setPresenceCondition(plEOperation.getPresenceCondition());
      }
    }

    for (var eClassifier : ePackage.getEClassifiers()) {
      if (!(eClassifier instanceof EClass eClass)) {
        continue;
      }
      for (var eSuperclass : eClass.getESuperTypes()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eClass));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eSuperclass));
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_Superclass(), plSrc, plTgt)
          .setPresenceCondition(plTgt.getPresenceCondition());
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
          .setPresenceCondition(plTgt.getPresenceCondition());
      }
      for (var eReference : eClass.getEReferences()) {
        var plSrc = plClasses.get(MIDRegistry.getModelElementUri(eReference.getEType()));
        var plTgt = plClasses.get(MIDRegistry.getModelElementUri(eReference));
        createPLReference(ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget(), plSrc, plTgt)
          .setPresenceCondition(plTgt.getPresenceCondition());
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
          .setPresenceCondition(plTgt.getPresenceCondition());
      }
    }
  }
}
