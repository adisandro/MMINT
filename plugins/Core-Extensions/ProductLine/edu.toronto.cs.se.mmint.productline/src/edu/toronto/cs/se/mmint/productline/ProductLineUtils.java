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
package edu.toronto.cs.se.mmint.productline;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;

public class ProductLineUtils {

  public static @Nullable String getPresenceCondition(PLElement plElem, @Nullable String pcField) {
    if (pcField == null) {
      try {
        pcField = plElem.getProductLine().getReasoner().getTrueLiteral();
      }
      catch (MMINTException e) {
        // fallback to default pc field
      }
    }
    return pcField;
  }

  public static boolean isAlwaysPresent(PLElement plElem, @Nullable String pcField) {
    try {
      if (pcField == null || pcField.strip().equals(plElem.getProductLine().getReasoner().getTrueLiteral())) {
        return true;
      }
      return false;
    }
    catch (MMINTException e) {
      return false;
    }
  }

  public static String getPresenceConditionLabel(PLElement plElem, boolean withParenthesis) {
    if (plElem.isAlwaysPresent()) {
      return "";
    }
    var pc = plElem.getPresenceCondition();
    if (withParenthesis) {
      return "(" + pc + ")";
    }
    return pc;
  }

  public static @Nullable Class getEContainer(Class plClass) {
    return plClass.getReferencesAsTarget().stream()
      .filter(r -> r.getType().isContainment())
      .map(r -> (Class) r.eContainer())
      .findFirst()
      .orElse(null);
  }
}
