/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.statemachine.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLUtils;
import edu.toronto.cs.se.mmint.productline.design.PLServices;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class StateMachinePLServices extends PLServices {

  // use different method names to allow full disabling of StateMachine layer
  public String getStateMachinePLElementLabel(EObject self) {
    var pc = PLUtils.getPresenceConditionLabel((PLElement) self, true);
    var label = switch (self) {
      case Class c when StateMachinePackage.eINSTANCE.getState() == c.getType() -> {
        var name = mergePLAttributeLabels(c, StateMachinePackage.eINSTANCE.getAbstractState_Name());
        yield (pc.isBlank()) ? name : pc + "\n" + name;
      }
      case Class c when StateMachinePackage.eINSTANCE.getTransition() == c.getType() -> {
        var trigger = mergePLAttributeLabels(c, StateMachinePackage.eINSTANCE.getFiringElement_Trigger());
        var action = mergePLAttributeLabels(c, StateMachinePackage.eINSTANCE.getFiringElement_Action());
        var text = (action.isBlank()) ? trigger.strip() : (trigger + "/" + action).strip();
        yield (pc.isBlank()) ? text : pc + "\n" + text;
      }
      case Class c when StateMachinePackage.eINSTANCE.getStateAction() == c.getType() -> {
        var trigger = mergePLAttributeLabels(c, StateMachinePackage.eINSTANCE.getFiringElement_Trigger());
        var action = mergePLAttributeLabels(c, StateMachinePackage.eINSTANCE.getFiringElement_Action());
        var text = (action.isBlank()) ? trigger.strip() : (trigger + "/" + action).strip();
        yield (pc.isBlank()) ? text : pc + "\n" + text;
      }
      case Class c -> "";
      default -> getPLElementLabel(self);
    };

    return label;
  }
}
