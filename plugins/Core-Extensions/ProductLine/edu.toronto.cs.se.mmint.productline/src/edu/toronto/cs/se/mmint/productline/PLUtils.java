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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;

public class PLUtils {

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

  public static Stream<Class> getStreamOfReference(Class plClass, EReference referenceType) {
    return plClass.getReferences().stream()
      .filter(r -> r.getType() == referenceType)
      .map(r -> r.getTarget());
  }

  public static List<Class> getReference(Class plClass, EReference referenceType) {
    return getStreamOfReference(plClass, referenceType)
      .collect(Collectors.toList());
  }

  public static Stream<Class> getStreamOfReferenceAsTarget(Class plClass, EReference referenceType) {
    return plClass.getReferencesAsTarget().stream()
      .filter(r -> r.getType() == referenceType)
      .map(r -> r.getTarget());
  }

  public static List<Class> getReferenceAsTarget(Class plClass, EReference referenceType) {
    return getStreamOfReferenceAsTarget(plClass, referenceType)
      .collect(Collectors.toList());
  }

  public static Stream<String> getStreamOfAttribute(Class plClass, EAttribute attributeType) {
    return plClass.getAttributes().stream()
      .filter(a -> a.getType() == attributeType)
      .map(a -> a.getValue());
  }

  public static List<String> getAttribute(Class plClass, EAttribute attributeType) {
    return getStreamOfAttribute(plClass, attributeType)
      .collect(Collectors.toList());
  }
}
