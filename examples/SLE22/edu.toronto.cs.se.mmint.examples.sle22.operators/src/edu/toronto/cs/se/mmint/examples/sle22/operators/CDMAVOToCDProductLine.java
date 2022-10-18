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

import java.util.Map;
import java.util.Set;

import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.mmint.productline.operators.ToProductLine;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

public class CDMAVOToCDProductLine extends ToProductLine {

  protected static class CDMAVOToCDPLOut extends Out {
    public CDMAVOToCDPLOut(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      super(outputMIDsByName, workingPath, in);
      this.productLine.setReasonerName("LogicNG");
      this.productLine.setMetamodel(edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName);
    this.out = new CDMAVOToCDPLOut(outputMIDsByName, getWorkingPath(), this.in);
  }

  @Override
  protected void toProductLine() {
    super.toProductLine();
    var classTypeSwitch = Map.of(
      ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram(), ClassDiagramPackage.eINSTANCE.getClassDiagram(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClass_(),       ClassDiagramPackage.eINSTANCE.getClass_(),
      ClassDiagram_MAVOPackage.eINSTANCE.getAttribute(),    ClassDiagramPackage.eINSTANCE.getAttribute(),
      ClassDiagram_MAVOPackage.eINSTANCE.getOperation(),    ClassDiagramPackage.eINSTANCE.getOperation(),
      ClassDiagram_MAVOPackage.eINSTANCE.getAssociation(),  ClassDiagramPackage.eINSTANCE.getAssociation());
    var attrTypeSwitch = Map.of(
      ClassDiagram_MAVOPackage.eINSTANCE.getNamedElement_Name(),
      ClassDiagramPackage.eINSTANCE.getNamedElement_Name(),
      ClassDiagram_MAVOPackage.eINSTANCE.getTypedElement_Public(),
      ClassDiagramPackage.eINSTANCE.getTypedElement_Public());
    var attrTypeDelete = Set.of(
      MAVOPackage.eINSTANCE.getLogicElement_FormulaVariable(),
      MAVOPackage.eINSTANCE.getMAVOElement_May(),
      MAVOPackage.eINSTANCE.getMAVOElement_Set(),
      MAVOPackage.eINSTANCE.getMAVOElement_Var(),
      MAVOPackage.eINSTANCE.getMAVORoot_Inc());
    var refTypeSwitch = Map.of(
      ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram_Classes(),
      ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram_Associations(),
      ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClass_OwnedAttributes(),
      ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClass_OwnedOperations(),
      ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations(),
      ClassDiagram_MAVOPackage.eINSTANCE.getTypedElement_Type(),
      ClassDiagramPackage.eINSTANCE.getTypedElement_Type(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClass_AssociationsAsSource(),
      ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource(),
      ClassDiagram_MAVOPackage.eINSTANCE.getClass_AssociationsAsTarget(),
      ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget(),
      ClassDiagramPackage.eINSTANCE.getClass_Superclass(),
      ClassDiagramPackage.eINSTANCE.getClass_Superclass());
    // pass 1: adjust class and attribute types from CDMAVO to CD
    for (var classIter = this.out.productLine.getClasses().iterator(); classIter.hasNext();) {
      var plClass = classIter.next();
      if (plClass.getType() == ClassDiagram_MAVOPackage.eINSTANCE.getSuperclassReference()) {
        // turn MAVOReferences from CLass back to Reference
        var plReference = ProductLineFactory.eINSTANCE.createReference();
        plReference.setPresenceCondition("true");
        plReference.setType(ClassDiagramPackage.eINSTANCE.getClass_Superclass());
        for (var tgtReference : plClass.getReferencesAsTarget()) {
          this.out.productLine.getReferences().remove(tgtReference);
          if (tgtReference.getType() == ClassDiagram_MAVOPackage.eINSTANCE.getClass_Superclass()) {
            plReference.setSource(tgtReference.getSource());
          }
          else {
            plReference.setTarget(tgtReference.getSource());
          }
          tgtReference.setSource(null);
        }
        this.out.productLine.getReferences().add(plReference);
        classIter.remove();
      }
      else {
        plClass.setType(classTypeSwitch.get(plClass.getType()));
        for (var attrIter = plClass.getAttributes().iterator(); attrIter.hasNext();) {
          var plAttribute = attrIter.next();
          // set the presence condition
          if (plAttribute.getType() == MAVOPackage.eINSTANCE.getLogicElement_FormulaVariable()) {
            plClass.setPresenceCondition(plAttribute.getValue());
          }
          if (attrTypeDelete.contains(plAttribute.getType())) {
            attrIter.remove();
          }
          else {
            plAttribute.setType(attrTypeSwitch.get(plAttribute.getType()));
          }
        }
      }
    }
    // pass 2: adjust reference types from CDMAVO to CD
    for (var plReference : this.out.productLine.getReferences()) {
      plReference.setType(refTypeSwitch.get(plReference.getType()));
    }
  }
}
