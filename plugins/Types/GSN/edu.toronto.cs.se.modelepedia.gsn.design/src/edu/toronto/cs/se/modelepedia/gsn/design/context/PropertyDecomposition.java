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
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
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

    private HashMap<EClass, List<EObject>> categorizeModelObjects(Model model) {
      var modelObjs = new HashMap<EClass, List<EObject>>();
      for (var iter = model.getEMFInstanceRoot().eAllContents(); iter.hasNext();) {
        var modelObj = iter.next();
        var modelObjClass = modelObj.eClass();
        modelObjs.computeIfAbsent(modelObjClass, k -> new ArrayList<>()).add(modelObj);
        for (var modelObjSuperclass : modelObjClass.getEAllSuperTypes()) {
          modelObjs.computeIfAbsent(modelObjSuperclass, k -> new ArrayList<>()).add(modelObj);
        }
      }

      return modelObjs;
    }

    private Model getRelatedModel() throws MMINTException {
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
            return (Model) endpoints.get(1).getTarget().eContainer();
          }
          else if (decomposedUri.equals(uri1)) {
            return (Model) endpoints.get(0).getTarget().eContainer();
          }
        }
      }
      throw new MMINTException("No related model found");
    }

    private PropertyTemplate selectTemplate(String title, String message, List<PropertyTemplate> templates)
                                           throws MIDDialogCancellation {
      if (templates.isEmpty()) {
        return PropertyTemplate.CUSTOM;
      }
      var templates2 = new ArrayList<>(templates);
      templates2.add(PropertyTemplate.CUSTOM);
      var contentProvider = new ArrayContentProvider();
      var labelProvider = LabelProvider.createTextProvider(t -> ((PropertyTemplate) t).description);

      return MIDDialogs.openListDialog(title, message, templates2, contentProvider, labelProvider);
    }

    @Override
    protected DecompositionStrategy decompose() throws Exception {
      /**TODO
       * AddModifyConstraintListener: Refactor constraint code to use this code?
       * LeanReasoner: Find where is lean's mathlab library (readlink -f $(type -P lean)) and add it to config file
       * LeanReasoner: Extract dir recursively from jar
       * IGSNLeanEncoder: Switch to records
       * IGSNLeanEncoder: Property vars should have an ereference for bounding to a string
       * PropertyDecompositionStrategyImpl: Related model in validate could come from here
       * GSNLeanReasoner: Review name
       * precedes.globally (coe pay) (coe restart)
       * absent.before (coe restart) (coe pay)
       * exist.globally (coe pay)
       */
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition");
      var reasonerName = reasoner.getName();
      var relatedModel = getRelatedModel();
      var modelObjs = categorizeModelObjects(relatedModel);
      var templates = reasoner.getTemplateProperties(relatedModel);
      var template = selectTemplate(title, "Select the property to be decomposed", templates);
      var boundTemplate = template.bindVariables(title, modelObjs);
      var property = boundTemplate.property;
      if (property.isBlank()) {
        property = MIDDialogs.getBigStringInput(title, "Insert the " + reasonerName + " property to be decomposed",
                                                null);
      }
      var description = "'" + boundTemplate.description + "'";
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
        if (subProperty.isBlank()) {
          subProperty = MIDDialogs.getBigStringInput(title, "Insert the sub-property #" + (i+1), null);
        }
        var subDescription = "'" + subBoundTemplate.description + "'";
        var subGoal = builder.createPropertyGoal(subGoalId + i, subGoalDesc1 + subDescription + subGoalDesc2,
                                                 reasonerName, subProperty);
        builder.addSupporter(propStrategy, subGoal);
      }
      builder.addSupporter(this.decomposed, formalStrategy);

      return propStrategy;
    }
  }
}
