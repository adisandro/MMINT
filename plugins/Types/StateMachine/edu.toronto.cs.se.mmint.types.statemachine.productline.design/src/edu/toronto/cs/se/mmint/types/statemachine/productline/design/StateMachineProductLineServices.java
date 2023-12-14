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
package edu.toronto.cs.se.mmint.types.statemachine.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLineUtils;
import edu.toronto.cs.se.mmint.productline.design.ProductLineServices;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class StateMachineProductLineServices extends ProductLineServices {

  protected String getStateMachineElementLabel(EObject self) {
    return switch (self) {
      case Class c when StateMachinePackage.eINSTANCE.getState() == c.getType() -> {
        var name = "";
        for (var a : c.getAttributes()) {
          if (a.getType() == StateMachinePackage.eINSTANCE.getAbstractState_Name()) {
            name += a.getValue();
            break;
          }
        }
        yield name;
      }
      case Class c when StateMachinePackage.eINSTANCE.getTransition() == c.getType() -> {
        String action = "", trigger = "";
        for (var a : c.getAttributes()) {
          if (a.getType() == StateMachinePackage.eINSTANCE.getFiringElement_Action()) {
            action += a.getValue();
          }
          if (a.getType() == StateMachinePackage.eINSTANCE.getFiringElement_Trigger()) {
            trigger += "[" + a.getValue() + ProductLineUtils.getPresenceConditionLabel(a, true) + "]";
          }
        }
        yield (action + " " + trigger).strip();
      }
      case Class c when StateMachinePackage.eINSTANCE.getStateAction() == c.getType() -> {
        String action = "", trigger = "";
        for (var a : c.getAttributes()) {
          if (a.getType() == StateMachinePackage.eINSTANCE.getFiringElement_Action()) {
            action += a.getValue();
          }
          if (a.getType() == StateMachinePackage.eINSTANCE.getFiringElement_Trigger()) {
            trigger += a.getValue();
          }
        }
        yield (trigger + "/" + action).strip();
      }
      case Class c -> "";
      default -> getElementLabel(self);
    };
  }

  // use different method names to allow full disabling of StateMachine layer
  public String getStateMachinePLElementLabel(EObject self) {
    return
      (getStateMachineElementLabel(self) + " " + ProductLineUtils.getPresenceConditionLabel((PLElement) self, true))
        .strip();
  }
}
