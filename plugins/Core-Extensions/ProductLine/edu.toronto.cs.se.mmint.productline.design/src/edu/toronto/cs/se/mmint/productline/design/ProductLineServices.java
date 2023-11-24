/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.productline.ProductLineUtils;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * The services class used by VSM.
 */
public class ProductLineServices {

  protected String getElementLabel(EObject self) {
    return switch (self) {
      case Class c     -> c.getType().getName();
      case Attribute a -> a.getType().getName() + ": " + a.getValue();
      case Reference r -> r.getType().getName();
      default          -> "";
    };
  }

  public String getPLElementLabel(EObject self) {
    return getElementLabel(self) + " " + ProductLineUtils.getPresenceConditionLabel((PLElement) self, true);
  }
}
