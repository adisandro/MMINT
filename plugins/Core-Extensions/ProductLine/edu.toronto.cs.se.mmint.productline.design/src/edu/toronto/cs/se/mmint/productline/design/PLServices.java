/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.PLUtils;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * The services class used by VSM.
 */
public class PLServices {

  protected String mergePLAttributeLabels(Class plClass, EAttribute attrType) {
    var label = "";
    var attributes = plClass.getAttributes().stream()
      .filter(a -> a.getType() == attrType)
      .collect(Collectors.toList());
    if (attributes.size() > 1) {
      label = attributes.stream()
        .map(t -> PLUtils.getPresenceConditionLabel(t, true) + " " + t.getValue())
        .collect(Collectors.joining("\n"));
    }
    else if (attributes.size() > 0) {
      label = attributes.get(0).getValue();
    }

    return label;
  }

  public String getPLElementLabel(EObject self) {
    var pc = PLUtils.getPresenceConditionLabel((PLElement) self, true);
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
