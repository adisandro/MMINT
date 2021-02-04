/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ArrayContentProvider;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

/**
 * The specification of a Lean encoder that handles GSN property decomposition quirks.
 *
 * @author Alessio Di Sandro
 */
public interface IGSNLeanEncoder {

  static class BoundProperty {
    public String property;
    public String description;
    public BoundProperty(String property, String description) {
      this.property = Objects.requireNonNull(property);
      this.description = Objects.requireNonNull(description);
    }
  }
  static class PropertyVariable {
    public String name;
    public Map<EClass, EStructuralFeature> validTypes;
    public PropertyVariable(String name, Map<EClass, EStructuralFeature> validTypes) {
      this.name = Objects.requireNonNull(name);
      this.validTypes = Objects.requireNonNull(validTypes);
    }
  }
  static class PropertyTemplate {
    public String property;
    public String description;
    public String category;
    public List<PropertyVariable> variables;
    public static PropertyTemplate CUSTOM = new PropertyTemplate("", "Custom property", null, List.of());

    public PropertyTemplate(String property, String description, @Nullable String category,
                            List<PropertyVariable> variables) {
      this.property  = property;
      this.description = Objects.requireNonNull(description);
      this.category = category;
      this.variables = Objects.requireNonNull(variables);
    }

    public BoundProperty bindVariables(String title, Map<EClass, List<EObject>> modelObjs)
                                      throws MIDDialogCancellation {
      if (this.variables.isEmpty()) {
        return new BoundProperty(this.property, this.description);
      }

      var message = ":\nSelect the model element corresponding to variable ";
      var contentProvider = new ArrayContentProvider();
      var labelProvider = new AdapterFactoryLabelProvider(GMFUtils.getAdapterFactory());
      var boundProperty = this.property;
      var boundDescription = this.description;
      for (var variable : this.variables) {
        var validModelObjs = new ArrayList<EObject>();
        variable.validTypes.keySet().forEach(t -> validModelObjs.addAll(modelObjs.getOrDefault(t, List.of())));
        var modelObj = MIDDialogs.<EObject>openListDialog(title, boundDescription + message + variable.name,
                                                          validModelObjs, contentProvider, labelProvider);
        String boundVariable;
        var modelObjClass = modelObj.eClass();
        var feature = Stream.concat(Stream.of(modelObjClass), modelObjClass.getEAllSuperTypes().stream())
          .filter(c -> variable.validTypes.containsKey(c))
          .map(c -> variable.validTypes.get(c))
          .findFirst();
        boundVariable = feature.map(f -> (String) modelObj.eGet(f)).orElse(modelObj.toString()).replaceAll("\\s", "_");
        boundProperty = boundProperty.replace(variable.name, boundVariable);
        boundDescription = boundDescription.replace(variable.name, boundVariable);
      }

      return new BoundProperty(boundProperty, boundDescription);
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
  default String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    return property + "\n" + String.join("\n", subProperties);
  }
}
