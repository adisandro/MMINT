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
package edu.toronto.cs.se.mmint.types.gsn.productline.design;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLineUtils;
import edu.toronto.cs.se.mmint.productline.design.ProductLineServices;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

/**
 * The services class used by VSM.
 */
public class GSNProductLineServices extends ProductLineServices {

  protected String getGSNElementLabel(EObject self) {
    return switch (self) {
      case Class c when GSNPackage.eINSTANCE.getArgumentElement().isSuperTypeOf(c.getType()) -> {
        String id = "", desc = "";
        for (var a : c.getAttributes()) {
          if (a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Id()) {
            id += a.getValue();
          }
          if (a.getType() == GSNPackage.eINSTANCE.getArgumentElement_Description()) {
            desc += a.getValue();
          }
        }
        yield id + " " + desc;
      }
      case Class c -> "";
      default -> getElementLabel(self);
    };
  }

  // use different method names to allow full disabling of GSN layer
  public String getGSNPLElementLabel(EObject self) {
    return getGSNElementLabel(self) + " " + ProductLineUtils.getPresenceConditionLabel((PLElement) self, true);
  }
}
