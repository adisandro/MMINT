/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * The services class used by VSM.
 */
public class PLServices {

  public String getPLElementLabel(EObject self) {
    var pc = ((PLElement) self).getPresenceConditionLabel();
    var label = switch (self) {
      case Class c -> {
        var l = c.getType().getName();
        yield (pc.isBlank()) ? l : pc + "\n" + l;
      }
      case Attribute a -> {
        var l = a.getType().getName() + ": " + a.getValue();
        yield (pc.isBlank()) ? l : pc + " " + l;
      }
      case Reference r -> {
        var l = r.getType().getName();
        yield (pc.isBlank()) ? l : pc + "\n" + l;
      }
      default -> "";
    };

    return label;
  }
}
