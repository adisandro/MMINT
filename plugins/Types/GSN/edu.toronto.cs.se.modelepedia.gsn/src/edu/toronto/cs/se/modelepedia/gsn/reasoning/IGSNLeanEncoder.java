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
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.viewers.ArrayContentProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

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
      this.property = property;
      this.description = description;
    }
  }
  static class PropertyVariable {
    public String name;
    public Set<EClass> validTypes;
    public PropertyVariable(String name, Set<EClass> validTypes) {
      this.name = name;
      this.validTypes = validTypes;
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

    public BoundProperty bindVariables(String title, HashMap<EClass, List<EObject>> modelObjs)
                                       throws MIDDialogCancellation {
      if (this.variables.isEmpty()) {
        return new BoundProperty(this.property, this.description);
      }

      var message = this.description + ":\nSelect the model element corresponding to variable ";
      var contentProvider = new ArrayContentProvider();
      var labelProvider = new AdapterFactoryLabelProvider(GMFUtils.getAdapterFactory());
      var boundProperty = this.property;
      var boundDescription = this.description;
      for (var variable : this.variables) {
        var validModelObjs = new ArrayList<EObject>();
        variable.validTypes.forEach(t -> validModelObjs.addAll(modelObjs.getOrDefault(t, List.of())));
        var modelObj = MIDDialogs.<EObject>openListDialog(title, message + variable.name, validModelObjs,
                                                          contentProvider, labelProvider);
        String boundVariable;
        try {
          boundVariable = (String) FileUtils.getModelObjectFeature(modelObj, "label");
        }
        catch (MMINTException e) {
          boundVariable = modelObj.toString();
        }
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
  String encodePropertyDecomposition(Model model, String property, List<String> subProperties);
}
