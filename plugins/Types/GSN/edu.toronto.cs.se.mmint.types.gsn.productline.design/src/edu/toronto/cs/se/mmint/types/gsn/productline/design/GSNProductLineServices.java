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
package edu.toronto.cs.se.mmint.types.gsn.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLineUtils;
import edu.toronto.cs.se.mmint.productline.design.ProductLineServices;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNProductLineServices extends ProductLineServices {

  // use different method names to allow full disabling of GSN layer
  public String getGSNPLElementLabel(EObject self) {
    var pc = ProductLineUtils.getPresenceConditionLabel((PLElement) self, true);
    var label = switch (self) {
      case Class c when GSNPackage.eINSTANCE.getArgumentElement().isSuperTypeOf(c.getType()) -> {
        var id = mergePLAttributeLabels(c, GSNPackage.eINSTANCE.getArgumentElement_Id());
        var desc = mergePLAttributeLabels(c, GSNPackage.eINSTANCE.getArgumentElement_Description());
        var text = (id + " " + desc).strip();
        yield (pc.isBlank()) ? text : pc + "\n" + text;
      }
      case Class c -> "";
      default -> getPLElementLabel(self);
    };

    return label;
  }
}
