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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.FileExtensionsDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.FilesOnlyDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Property;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
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
        .flatMap(v -> v.validTypes.stream())
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

    private Goal moveOneDecompositionUp(Goal goal) throws MMINTException {
      if (goal.getSupports().size() > 1) {
        throw new MMINTException("Goal '" + goal.getId() + "' should not support more than one GSN element");
      }
      var supported = goal.getSupports().get(0).getSource();
      if (!(supported instanceof Strategy strategy)) {
        throw new MMINTException("Goal '" + goal.getId() + "' should support a strategy");
      }
      if (strategy.getSupports().size() > 1) {
        throw new MMINTException("Strategy '" + strategy.getId() + "' should not support more than one GSN element");
      }
      supported = strategy.getSupports().get(0).getSource();
      if (!(supported instanceof Goal parentGoal)) {
        throw new MMINTException("Strategy '" + strategy.getId() + "' should support a goal");
      }

      return parentGoal;
    }

    private Optional<Model> getRelatedModel() throws MMINTException {
      // detect if this is a decomposition chain
      var relatedGoal = this.decomposed;
      if (relatedGoal instanceof PropertyGoal) {
        try {
          while (relatedGoal instanceof PropertyGoal) {
            relatedGoal = moveOneDecompositionUp(relatedGoal);
          }
          relatedGoal = moveOneDecompositionUp(relatedGoal); // formal argument level
        }
        catch (MMINTException e) {
          MMINTException.print(IStatus.WARNING, "Bad structure for assisted decomposition", e);
          return Optional.empty();
        }
      }
      // find the goals in connected rels
      var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(relatedGoal);
      var modelRels = MIDRegistry.getConnectedModelRels(gsnModel, gsnModel.getMIDContainer());
      var decomposedUri = MIDRegistry.getModelElementUri(relatedGoal);
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

    private String getEncodingFile(String title, String message) throws MIDDialogCancellation {
      var dialog = new MIDTreeSelectionDialog(new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider(),
                                              ResourcesPlugin.getWorkspace().getRoot());
      dialog.addFilter(new FileExtensionsDialogFilter(Set.of("lean")));
      dialog.setValidator(new FilesOnlyDialogSelectionValidator("Lean file selected", "Please select a Lean file"));
      var encodingFile = (IFile) MIDDialogs.openTreeDialog(dialog, title, message);

      return encodingFile.getFullPath().toString();
    }

    private PropertyTemplate selectTemplate(String title, String message, Map<String, List<PropertyTemplate>> templates)
                                           throws MIDDialogCancellation {
      if (templates.isEmpty()) {
        return PropertyTemplate.CUSTOM;
      }
      var labelProvider = LabelProvider.createTextProvider(t -> {
        return (t instanceof PropertyTemplate) ? ((PropertyTemplate) t).informal : (String) t;
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
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var customMsg = "Insert a description for the custom property";
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition", null);
      var reasonerName = reasoner.getName();
      var relatedModelOpt = getRelatedModel();
      var templates = Map.<String, List<PropertyTemplate>>of();
      var modelObjs = Map.<EClass, List<EObject>>of();
      var queryCache = new HashMap<String, List<Object>>();
      var queryContexts = new HashMap<String, Context>();
      String relatedModelPath;
      Property property;
      List<String> propQueries = List.of();
      var encodingMsg = ", please manually select a " + reasonerName + " file";
      if (relatedModelOpt.isEmpty()) { // no related model: ask to manually provide an encoding
        relatedModelPath = getEncodingFile(title, "No related model found" + encodingMsg);
      }
      else {
        var relatedModel = relatedModelOpt.get();
        try {
          templates = reasoner.getPropertyTemplates(relatedModel);
          modelObjs = categorizeModelObjects(relatedModel, templates);
          relatedModelPath = relatedModel.getUri();
        }
        catch (MMINTException e) { // no model encoder: ask to manually provide an encoding
          relatedModelPath = getEncodingFile(title, "Related model does not have a " + reasonerName + " encoder" +
                                             encodingMsg);
        }
      }
      if (this.decomposed instanceof PropertyGoal propDecomposed) { // decomposition chain, parent property exists
        property = propDecomposed.getProperty();
      }
      else {
        var template = selectTemplate(title, "Select the property to be decomposed", templates);
        if (template == PropertyTemplate.CUSTOM) {
          property = builder.createProperty(title, "Insert the " + reasonerName + " property to be decomposed",
                                            customMsg);
        }
        else {
          var info = template.bindVariables(title, modelObjs, queryCache);
          property = info.property();
          propQueries = info.queries();
        }
      }
      var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, "Insert the number of sub-properties",
                                                                     null).strip());
      // create decomposition template
      var id = this.decomposed.getId();
      var informal = "'" + property.getInformal() + "'";
      Strategy chainedStrategy = null;
      Goal chainedGoal = null;
      String propStrategyId;
      var propStrategyDesc = "Decomposition over property ";
      var numGoals = 1;
      var numCtx = 0;
      if (this.decomposed instanceof PropertyGoal) { // decomposition chain, do not create formal argument level
        propStrategyId = "S1." + id;
        propStrategyDesc += informal;
      }
      else {
        var formalStrategyId = "S1." + id;
        var formalStrategyDesc = "Argument by " + reasonerName + " formalization";
        var propContextId = "Ctx1." + id;
        var propContextDesc = "Property " + informal;
        var modelGoalId = id + ".1";
        var modelGoalDesc = "The related model correctly models all aspects of the system for the property in " +
                            propContextId;
        var propGoalId = id + ".2";
        var propGoalDesc = id + " asserts the property in " + propContextId;
        var formalGoalId = id + ".3";
        var formalGoalDesc = "The property in " + propContextId + " holds";
        chainedStrategy = builder.createBasicStrategy(formalStrategyId, formalStrategyDesc);
        var propContext = builder.createContext(propContextId, propContextDesc);
        builder.addInContextOf(chainedStrategy, propContext);
        var modelGoal = builder.createBasicGoal(modelGoalId, modelGoalDesc);
        builder.addSupporter(chainedStrategy, modelGoal);
        var propGoal = builder.createBasicGoal(propGoalId, propGoalDesc);
        builder.addSupporter(chainedStrategy, propGoal);
        chainedGoal = builder.createBasicGoal(formalGoalId, formalGoalDesc);
        builder.addSupporter(chainedStrategy, chainedGoal);
        propStrategyId = "S2." + id;
        propStrategyDesc += "in " + propContextId;
        numGoals = 4;
        numCtx = 1;
      }
      var modelContextId = "Ctx2." + id;
      var subGoalId = id + ".";
      var propStrategy = builder.createPropertyStrategy(propStrategyId, propStrategyDesc, reasonerName, property);
      if (chainedGoal == null) {
        chainedStrategy = propStrategy;
      }
      else {
        builder.addSupporter(chainedGoal, propStrategy);
      }
      var modelContext = builder.createContext(modelContextId, relatedModelPath);
      builder.addInContextOf(propStrategy, modelContext);
      numCtx++;
      for (var propQuery : propQueries) {
        var queryContext = builder.createContext("Ctx" + ++numCtx + "." + id, propQuery);
        builder.addInContextOf(propStrategy, queryContext);
        queryContexts.put(propQuery, queryContext);
      }
      for (var i = 0; i < numProperties; i++) {
        var subTemplate = selectTemplate(title, "Select the sub-property #" + (i+1), templates);
        Property subProperty;
        List<String> subPropQueries = List.of();
        if (subTemplate == PropertyTemplate.CUSTOM) {
          subProperty = builder.createProperty(title, "Insert the sub-property #" + (i+1), customMsg);
        }
        else {
          var subInfo = subTemplate.bindVariables(title, modelObjs, queryCache);
          subProperty = subInfo.property();
          subPropQueries = subInfo.queries();
        }
        var subGoalDesc = "The property '" + subProperty.getInformal() + "' holds";
        var subGoal = builder.createPropertyGoal(subGoalId + (i+numGoals), subGoalDesc, reasonerName, subProperty);
        builder.addSupporter(propStrategy, subGoal);
        for (var subPropQuery : subPropQueries) {
          Context subQueryContext;
          if (queryContexts.containsKey(subPropQuery)) {
            subQueryContext = queryContexts.get(subPropQuery);
          }
          else {
            subQueryContext = builder.createContext("Ctx" + ++numCtx + "." + id, subPropQuery);
            queryContexts.put(subPropQuery, subQueryContext);
          }
          builder.addInContextOf(subGoal, subQueryContext);
        }
      }
      builder.addSupporter(this.decomposed, chainedStrategy);

      return propStrategy;
    }
  }
}
