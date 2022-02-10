/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Property;

/**
 * The specification of a Lean encoder that handles GSN property decomposition quirks.
 *
 * @author Alessio Di Sandro
 */
public interface IGSNLeanEncoder {

  static class PropertyVariable {
    public record VariableEncoding(String formal, String informal) {}
    public interface VariableEncoder {
      public VariableEncoding encode(List<EObject> modelObjs);
    }
    public String name;
    public Set<EClass> validTypes;
    public VariableEncoder encoder;
    public PropertyVariable(String name, Set<EClass> validTypes, VariableEncoder encoder) {
      this.name = Objects.requireNonNull(name);
      this.validTypes = Objects.requireNonNull(validTypes);
      this.encoder = encoder;
    }
  }
  static class PropertyTemplate {
    public String formal;
    public String informal;
    public @Nullable String category;
    public List<PropertyVariable> variables;
    public static PropertyTemplate CUSTOM = new PropertyTemplate("", "Custom property", null, List.of());

    public PropertyTemplate(String formal, String informal, @Nullable String category,
                            List<PropertyVariable> variables) {
      this.formal  = formal;
      this.informal = Objects.requireNonNull(informal);
      this.category = category;
      this.variables = Objects.requireNonNull(variables);
    }

    public Property bindVariables(String title, Map<EClass, List<EObject>> modelObjs) throws Exception {
      var property = GSNFactory.eINSTANCE.createProperty();
      if (this.variables.isEmpty()) {
        property.setFormal(this.formal);
        property.setInformal(this.informal);
        return property;
      }

      var message = ":\nSelect one or more model elements corresponding to variable ";
      var labelProvider = new AdapterFactoryLabelProvider(GMFUtils.getAdapterFactory());
      var boundFormal = this.formal;
      var boundInformal = this.informal;
      for (var variable : this.variables) {
        var validModelObjs = new LinkedHashSet<EObject>();
        variable.validTypes.forEach(t -> validModelObjs.addAll(modelObjs.getOrDefault(t, List.of())));
        var boundModelObjs = MIDDialogs.<EObject>openListMultipleDialog(title, boundInformal + message + variable.name,
                                                                        validModelObjs.toArray(new EObject[0]),
                                                                        labelProvider);
//        var model = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(modelObjs.values().iterator().next().get(0));
//        var instanceMID = model.getMIDContainer();
//        var querySpec = SiriusEvaluateQuery.selectQuery(instanceMID);
//        var queryResults = querySpec.reasoner().evaluateQuery(querySpec.filePath(), querySpec.name(), instanceMID,
//                                                              List.<EObject>of());
//        var boundModelObjs = queryResults.stream()
//          .filter(o -> validModelObjs.contains(o))
//          .map(o -> (EObject) o)
//          .collect(Collectors.toList());
//        if (boundModelObjs.isEmpty()) {
//          throw new MMINTException("The query '" + querySpec.name() + "' returned zero valid model objects");
//        }
        var encoded = variable.encoder.encode(boundModelObjs);
        boundFormal = boundFormal.replace(variable.name, encoded.formal());
        boundInformal = boundInformal.replace(variable.name, encoded.informal());
      }
      property.setFormal(boundFormal);
      property.setInformal(boundInformal);

      return property;
    }
  }

  default List<PropertyTemplate> getPropertyTemplates() {
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
