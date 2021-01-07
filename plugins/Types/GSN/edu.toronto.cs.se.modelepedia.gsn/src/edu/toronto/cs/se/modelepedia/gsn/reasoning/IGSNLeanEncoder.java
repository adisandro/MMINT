/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.mid.Model;

/**
 * The specification of a Lean encoder that handles GSN property decomposition quirks.
 *
 * @author Alessio Di Sandro
 */
public interface IGSNLeanEncoder {

  static class PropertyTemplate {
    public String property;
    public String description;
    public Map<String, String> variables;
    public PropertyTemplate() {}
  }

  default List<PropertyTemplate> getTemplateProperties() {
    return List.of();
  }

  /**
   * Encodes a Lean property that is decomposed into sub-properties.
   *
   * @param model
   *          The model on which the property is applied.
   * @param property
   *          The Lean property being decomposed.
   * @param subProperties
   *          The Lean sub-properties.
   * @return The Lean encoding representing the property decomposition.
   */
  String encodePropertyDecomposition(Model model, String property, List<String> subProperties);
}
