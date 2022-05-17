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

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.context.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
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

    public record BindingResult(Property property, List<String> queries) {}
    public BindingResult bindVariables(String title, Map<EClass, List<EObject>> modelObjs,
                                       Map<String, List<Object>> queryCache) throws Exception {
      var property = GSNFactory.eINSTANCE.createProperty();
      var result = new BindingResult(property, new ArrayList<String>());
      if (this.variables.isEmpty()) {
        property.setFormal(this.formal);
        property.setInformal(this.informal);
        return result;
      }

      var message = ":\nSelect one or more model elements corresponding to variable ";
      var labelProvider = new AdapterFactoryLabelProvider(GMFUtils.getAdapterFactory()) {
        @Override
        public String getText(Object object) {
          if (object instanceof String queryLabel) {
            // special case to run a query
            return queryLabel;
          }
          return super.getText(object);
        }
      };
      var boundFormal = this.formal;
      var boundInformal = this.informal;
      for (var variable : this.variables) {
        var validModelObjs = new LinkedHashSet<EObject>();
        variable.validTypes.forEach(t -> validModelObjs.addAll(modelObjs.getOrDefault(t, List.of())));
        if (validModelObjs.isEmpty()) {
          throw new MMINTException("There are no valid model objects to bind variable " + variable.name);
        }
        var input = Stream.concat(Stream.of(" Run query to select elements"), validModelObjs.stream()).toArray();
        var selectedObjs = MIDDialogs.openListMultipleDialog(title, boundInformal + message + variable.name, input,
                                                             labelProvider);
        List<EObject> boundModelObjs;
        String queryInformal = null;
        if (selectedObjs.get(0) instanceof String) { // model element selection with query
          var model = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(modelObjs.values().iterator().next().get(0));
          var instanceMID = model.getMIDContainer();
          var querySpec = SiriusEvaluateQuery.selectQuery(instanceMID);
          var queryId = querySpec.filePath() + "#" + querySpec.query();
          selectedObjs = queryCache.get(queryId);
          if (selectedObjs == null) { // run query and cache result
            selectedObjs = querySpec.evaluateQuery(instanceMID, List.of());
            queryCache.put(queryId, selectedObjs);
          }
          boundModelObjs = selectedObjs.stream()
            .filter(o -> validModelObjs.contains(o))
            .map(o -> (EObject) o)
            .collect(Collectors.toList());
          if (boundModelObjs.isEmpty()) {
            throw new MMINTException("The query '" + querySpec.query() + "' returned zero valid model objects");
          }
          //TODO MMINT[GSN] Figure out why displayQueryResults does not work
          //SiriusEvaluateQuery.displayQueryResults(instanceMID, selectedObjs);
          result.queries().add(queryId);
          queryInformal = "[elements from query \"" + querySpec.query() + "\"]";
        }
        else { // direct model element selection
          boundModelObjs = selectedObjs.stream()
            .map(o -> (EObject) o)
            .collect(Collectors.toList());
        }
        var encoded = variable.encoder.encode(boundModelObjs);
        boundFormal = boundFormal.replace(variable.name, encoded.formal());
        boundInformal = boundInformal.replace(variable.name,
                                              (queryInformal == null) ? encoded.informal() : queryInformal);
      }
      property.setFormal(boundFormal);
      property.setInformal(boundInformal);

      return result;
    }
  }

  default List<PropertyTemplate> getPropertyTemplates(Model model) {
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
