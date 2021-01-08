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
import java.util.Objects;
import java.util.Optional;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

/**
 * The specification of a Lean encoder that handles GSN property decomposition quirks.
 *
 * @author Alessio Di Sandro
 */
public interface IGSNLeanEncoder {

  static class PropertyTemplate {
    public String property;
    public String description;
    public List<String> variables;
    public static PropertyTemplate CUSTOM = new PropertyTemplate(null, "Custom property", List.of());

    public PropertyTemplate(@Nullable String property, String description, List<String> variables) {
      this.property  = property;
      this.description = Objects.requireNonNull(description);
      this.variables = Objects.requireNonNull(variables);
    }

    public Optional<String> bindPropertyVariables(String title) throws MIDDialogCancellation {
      if (this.property == null) {
        return Optional.empty();
      }
      var boundProperty = this.property;
      for (var variable : this.variables) {
        var bound = MIDDialogs.getStringInput(
          title, "Insert the name of the model element corresponding to variable '" + variable + "'", null);
        boundProperty = boundProperty.replace(variable, bound);
      }

      return Optional.of(boundProperty);
    }
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
