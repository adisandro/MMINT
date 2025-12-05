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
package edu.toronto.cs.se.mmint.types.gsn.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.design.PLServices;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNServices extends PLServices {

  // use different method names to allow full disabling of GSN layer
  public String getPLGSNElementLabel(EObject self) {
    var pc = ((PLElement) self).getPresenceConditionLabel(true);
    var label = switch (self) {
      case PLGSNArgumentElement e -> {
        var id = e.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id());
        if (id == null) {
          id = "";
        }
        var desc = e.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Description());
        if (desc == null) {
          desc = "";
        }
        var text = (id + "\n" + desc).strip();
        yield (pc.isBlank()) ? text : pc + " " + text;
      }
      case Class c when c.instanceOf(GSNPackage.eINSTANCE.getImpactAnnotation()) -> {
        yield (c.getPresenceCondition().equals(c.getEContainer().getPresenceCondition())) ? "" : pc;
      }
      case Class c -> pc;
      default -> getPLElementLabel(self);
    };

    return label;
  }
}
