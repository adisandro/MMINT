/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.productline.design.PLServices;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class PLStateMachineServices extends PLServices {

  // use different method names to allow full disabling of StateMachine layer
  public String getPLStateMachineElementLabel(EObject self) {
    var pc = ((PLElement) self).getPresenceConditionLabel();
    var label = switch (self) {
      case Class c when c.instanceOf(StateMachinePackage.eINSTANCE.getState()) -> {
        var name = c.getAttribute(StateMachinePackage.eINSTANCE.getAbstractState_Name());
        if (name == null) {
          name = "";
        }
        yield (pc.isBlank()) ? name : pc + "\n" + name;
      }
      case Class c when c.instanceOf(StateMachinePackage.eINSTANCE.getTransition()) ||
                        c.instanceOf(StateMachinePackage.eINSTANCE.getStateAction()) -> {
        var trigger = c.getAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Trigger());
        if (trigger == null) {
          trigger = "";
        }
        var action = c.getAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Action());
        if (action == null) {
          action = "";
        }
        var text = (action.isBlank()) ? trigger.strip() : (trigger + "/" + action).strip();
        yield (pc.isBlank()) ? text : pc + "\n" + text;
      }
      case Class c -> "";
      default -> getPLElementLabel(self);
    };

    return label;
  }
}
