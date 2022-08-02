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
import edu.toronto.cs.se.mmint.productline.operators.ToProductLine;

public class CDMAVOToProductLine extends ToProductLine {

  protected static class CDMAVOToPLOut extends Out {
    public CDMAVOToPLOut(Map<String, MID> outputMIDsByName, String workingPath, In in) throws MMINTException {
      super(outputMIDsByName, workingPath, in);
      this.productLine.setReasonerName("LogicNG");
      this.productLine.setMetamodel(edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName);
    this.out = new CDMAVOToPLOut(outputMIDsByName, getWorkingPath(), this.in);
  }

  @Override
  protected void toProductLine() {
    super.toProductLine();
    var classTypeSwitch = Map.of(
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClassDiagram(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClass_(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getAttribute(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getAttribute(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getOperation(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getOperation(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getAssociation(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getAssociation());
    var attrTypeSwitch = Map.of(
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getNamedElement_Name(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getNamedElement_Name(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getTypedElement_Public(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getTypedElement_Public());
    var attrTypeDelete = Set.of(
      MAVOPackage.eINSTANCE.getLogicElement_FormulaVariable(),
      MAVOPackage.eINSTANCE.getMAVOElement_May(),
      MAVOPackage.eINSTANCE.getMAVOElement_Set(),
      MAVOPackage.eINSTANCE.getMAVOElement_Var());
    var refTypeSwitch = Map.of(
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram_Classes(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClassDiagram_Classes(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClassDiagram_Associations(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClassDiagram_Associations(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_OwnedAttributes(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClass_OwnedAttributes(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_OwnedOperations(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClass_OwnedOperations(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getTypedElement_Type(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getTypedElement_Type(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_AssociationsAsSource(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsSource(),
      edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_AssociationsAsTarget(),
      edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage.eINSTANCE.getClass_AssociationsAsTarget());
    for (var plClass : this.out.productLine.getClasses()) {
      plClass.setType(classTypeSwitch.get(plClass.getType()));
      for (var iter = plClass.getAttributes().iterator(); iter.hasNext();) {
        var plAttribute = iter.next();
        if (plAttribute.getType() == MAVOPackage.eINSTANCE.getLogicElement_FormulaVariable()) {
          plClass.setPresenceCondition(plAttribute.getValue());
        }
        if (attrTypeDelete.contains(plAttribute.getType())) {
          iter.remove();
        }
        else {
          plAttribute.setType(attrTypeSwitch.get(plAttribute.getType()));
        }
      }
    }
    for (var plReference : this.out.productLine.getReferences()) {
      plReference.setType(refTypeSwitch.get(plReference.getType()));
    }
  }
}
