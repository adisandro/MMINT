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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.LabelProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.design.Activator;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.modelepedia.gsn.util.PropertyBuilder;

public class PropertyDecomposition extends GoalDecomposition {

  @Override
  protected GoalDecompositionCommand createCommand(TransactionalEditingDomain domain, Goal goal) {
    return new PropertyDecompositionCommand(domain, goal);
  }

  private class PropertyDecompositionCommand extends GoalDecompositionCommand {

    public PropertyDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain, decomposed, new PropertyBuilder((SafetyCase) decomposed.eContainer()));
    }

    private Map<EClass, List<EObject>> categorizeModelObjects(Model model,
                                                              Map<String, List<PropertyTemplate>> templates) {
      var validClasses = templates.values().stream()
        .flatMap(l -> l.stream())
        .flatMap(t -> t.variables.stream())
        .flatMap(v -> v.validTypes.keySet().stream())
        .collect(Collectors.toSet());
      if (validClasses.isEmpty()) {
        return new HashMap<>();
      }
      var modelObjs = new HashMap<EClass, List<EObject>>();
      for (var iter = model.getEMFInstanceRoot().eAllContents(); iter.hasNext();) {
        var modelObj = iter.next();
        var modelObjClass = modelObj.eClass();
        if (validClasses.contains(modelObjClass)) {
          modelObjs.computeIfAbsent(modelObjClass, k -> new ArrayList<>()).add(modelObj);
        }
        for (var modelObjSuperclass : modelObjClass.getEAllSuperTypes()) {
          if (validClasses.contains(modelObjSuperclass)) {
            modelObjs.computeIfAbsent(modelObjSuperclass, k -> new ArrayList<>()).add(modelObj);
          }
        }
      }

      return modelObjs;
    }

    private Optional<Model> getRelatedModel() throws MMINTException {
      // find the goals in connected rels
      var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(this.decomposed);
      var modelRels = MIDRegistry.getConnectedModelRels(gsnModel, gsnModel.getMIDContainer());
      var decomposedUri = MIDRegistry.getModelElementUri(this.decomposed);
      //TODO MMINT[GSN]: Ask if there are multiple matches instead of getting the first
      for (var modelRel : modelRels) {
        if (modelRel.getModelEndpoints().size() != 2) { // exclude non-binary
          continue;
        }
        for (var mapping : modelRel.getMappings()) {
          var endpoints = mapping.getModelElemEndpoints();
          if (endpoints.size() != 2) { // exclude non-binary
            continue;
          }
          ModelElement relatedModelElem;
          var uri0 = MIDRegistry.getModelObjectUri(endpoints.get(0).getTarget());
          var uri1 = MIDRegistry.getModelObjectUri(endpoints.get(1).getTarget());
          if (decomposedUri.equals(uri0)) {
            return Optional.of((Model) endpoints.get(1).getTarget().eContainer());
          }
          else if (decomposedUri.equals(uri1)) {
            return Optional.of((Model) endpoints.get(0).getTarget().eContainer());
          }
        }
      }

      return Optional.empty();
    }

    private String getRelatedFile() {
      return "";
    }

    private PropertyTemplate selectTemplate(String title, String message, Map<String, List<PropertyTemplate>> templates)
                                           throws MIDDialogCancellation {
      if (templates.isEmpty()) {
        return PropertyTemplate.CUSTOM;
      }
      var labelProvider = LabelProvider.createTextProvider(t -> {
        return (t instanceof PropertyTemplate) ? ((PropertyTemplate) t).description : (String) t;
      });
      var contentProvider = new TemplatePropertyContentProvider(templates);
      var dialog = new MIDTreeSelectionDialog(labelProvider, contentProvider, templates);
      dialog.setValidator(selection -> (Arrays.stream(selection).anyMatch(s -> s instanceof String)) ?
                                         new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Property not selected") :
                                         new Status(IStatus.OK, Activator.PLUGIN_ID, ""));

      return (PropertyTemplate) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
    }

    @Override
    protected DecompositionStrategy decompose() throws Exception {
      /**TODO
       * AddModifyConstraintListener: Refactor constraint code to use this code?
       * LeanReasoner: Find where is lean's mathlab library (readlink -f $(type -P lean)) and add it to config file
       * LeanReasoner: Extract dir recursively from jar
       * IGSNLeanEncoder: Switch to records
       * GSNLeanReasoner: Review name
       * (GSN)LeanReasoner: Store encoding and results in a prop_validation_GX_timestamp dir, without deleting them at the end
       *
       * precedes.globally (coe pay)   (coe restart)
       * precedes.globally (coe pay)   (coe serve)
       * precedes.globally (coe serve) (coe restart)
       *
       * LEAN FILE AS INPUT:
       * 1) A file model can't be used in a model rel to the gsn model, so getRelatedModel will throw an exception
       * 2) So, if it does, ask the user to select a file with source code and skip all the template parts (ask for custom properties always)
       * 2bis) Create the context node, attached to the PropertyDecompositionImpl -> either a lean file path, or a model path
       * 3) PropertyDecompositionImpl reads the context node and possibly generates the encoding (updating the context node to be a lean file path) -> run in a command
       * 4) Then it's validation time: LeanReasoner should have apis that split generateEncoding from checkProperty
       * 4bis) The justification and solution (add encoder api to fetch the name) nodes should be filled by the validation step -> run in a command
       */
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var customMsg = "Insert an optional description for the custom property";
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition");
      var reasonerName = reasoner.getName();
      var relatedModel = getRelatedModel();
      var templates = Map.<String, List<PropertyTemplate>>of();
      var modelObjs = Map.<EClass, List<EObject>>of();
      String relatedFile = null;
      if (relatedModel.isEmpty()) { // no related model: ask to manually provide an encoding
        relatedFile = getRelatedFile();
      }
      else {
        try {
          templates = reasoner.getTemplateProperties(relatedModel.get());
          modelObjs = categorizeModelObjects(relatedModel.get(), templates);
        }
        catch (MMINTException e) { // no model encoder: ask to manually provide an encoding
          relatedFile = getRelatedFile();
        }
      }
      var template = selectTemplate(title, "Select the property to be decomposed", templates);
      var boundTemplate = template.bindVariables(title, modelObjs);
      var property = boundTemplate.property;
      var description = "'" + boundTemplate.description + "'";
      if (property.isBlank()) {
        property = MIDDialogs.getBigStringInput(title, "Insert the " + reasonerName + " property to be decomposed",
                                                null);
        try {
          description = "'" + MIDDialogs.getStringInput(title, customMsg, null) + "'";
        }
        catch (MIDDialogCancellation e) {}
      }
      var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, "Insert the number of sub-properties",
                                                                     null));
      // create decomposition template
      var id = this.decomposed.getId();
      var formalStrategyId = "SF-" + id;
      var formalStrategyDesc = "Argument by " + reasonerName + " formalization";
      var modelGoalId = id + "-M";
      var modelGoalDesc = "The related model correctly models all aspects of the system related to property " +
                          description;
      var propGoalId = id + "-P";
      var propGoalDesc = id + " asserts the property " + description;
      var formalGoalId = id + "-F";
      var formalGoalDesc = "The property " + description + " holds for the related model";
      var propStrategyId = "SP-" + id;
      var propStrategyDesc = "Decomposition over property " + description;
      var justId = "J-" + id;
      var justDesc = "Decomposition validity proven in " + reasonerName;
      var subGoalId = id + "-";
      var subGoalDesc1 = "The property ";
      var subGoalDesc2 = " holds for the related model";
      var formalStrategy = builder.createBasicStrategy(formalStrategyId, formalStrategyDesc);
      var modelGoal = builder.createBasicGoal(modelGoalId, modelGoalDesc);
      builder.addSupporter(formalStrategy, modelGoal);
      var propGoal = builder.createBasicGoal(propGoalId, propGoalDesc);
      builder.addSupporter(formalStrategy, propGoal);
      var formalGoal = builder.createBasicGoal(formalGoalId, formalGoalDesc);
      builder.addSupporter(formalStrategy, formalGoal);
      var propStrategy = builder.createPropertyStrategy(propStrategyId, propStrategyDesc, reasonerName, property);
      builder.addSupporter(formalGoal, propStrategy);
      builder.createJustification(propStrategy, justId, justDesc);
      for (var i = 0; i < numProperties; i++) {
        var subTemplate = selectTemplate(title, "Select the sub-property #" + (i+1), templates);
        var subBoundTemplate = subTemplate.bindVariables(title, modelObjs);
        var subProperty = subBoundTemplate.property;
        var subDescription = "'" + subBoundTemplate.description + "'";
        if (subProperty.isBlank()) {
          subProperty = MIDDialogs.getBigStringInput(title, "Insert the sub-property #" + (i+1), null);
          try {
            subDescription = "'" + MIDDialogs.getStringInput(title, customMsg, null) + "'";
          }
          catch (MIDDialogCancellation e) {}
        }
        subDescription = subGoalDesc1 + subDescription + subGoalDesc2;
        var subGoal = builder.createPropertyGoal(subGoalId + i, subDescription, reasonerName, subProperty);
        builder.addSupporter(propStrategy, subGoal);
      }
      builder.addSupporter(this.decomposed, formalStrategy);

      return propStrategy;
    }
  }
}
