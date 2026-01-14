/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.Reference;
import edu.toronto.cs.se.mmint.productline.design.PLServices;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;

public class PLFTAServices extends PLServices {

  // use different method names to allow full disabling of FTA layer
  public String getPLFTAElementLabel(EObject self) {
    var pc = ((PLElement) self).getPresenceConditionLabel();
    var label = switch (self) {
      case Class c when c.instanceOf(FTAPackage.eINSTANCE.getEvent()) -> {
        var name = c.getAttribute(FTAPackage.eINSTANCE.getEvent_Name());
        if (name == null) {
          name = "";
        }
        var prob = c.getAttribute(FTAPackage.eINSTANCE.getEvent_Probability());
        if (prob == null) {
          prob = "";
        }
        var text = (name + "\n" + prob).strip();
        yield (pc.isBlank()) ? text : pc + "\n" + text;
      }
      case Class c when c.instanceOf(FTAPackage.eINSTANCE.getGate()) -> {
        var logic = c.getAttribute(FTAPackage.eINSTANCE.getGate_Logic());
        yield (c.getPresenceCondition().equals(c.getEContainer().getPresenceCondition())) ? logic : pc + "\n" + logic;
      }
      case Reference r -> pc;
      default -> getPLElementLabel(self);
    };

    return label;
  }
}
