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
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
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

    private PropertyTemplate selectTemplate(String title, String message, List<PropertyTemplate> templates)
                                           throws MIDDialogCancellation {
      if (templates.isEmpty()) {
        return PropertyTemplate.CUSTOM;
      }
      var templates2 = new ArrayList<>(templates);
      templates2.add(PropertyTemplate.CUSTOM);
      var dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
      dialog.setAddCancelButton(true);
      dialog.setTitle(title);
      dialog.setMessage(message);
      dialog.setContentProvider(new ArrayContentProvider());
      dialog.setLabelProvider(LabelProvider.createTextProvider(t -> ((PropertyTemplate) t).description));
      dialog.setInput(templates2);
      if (dialog.open() == Window.CANCEL) {
        throw new MIDDialogCancellation();
      }

      return (PropertyTemplate) dialog.getResult()[0];
    }

    private String selectProperty(String title, String selectMessage, String insertMessage,
                                  List<PropertyTemplate> templates) throws MIDDialogCancellation {
      var template = selectTemplate(title, selectMessage, templates);
      var boundProperty = template.bindPropertyVariables(title);

      return boundProperty.orElse(MIDDialogs.getBigStringInput(title, insertMessage, null));
    }

    @Override
    protected DecompositionStrategy decompose() throws Exception {
      /**TODO
       * P: Refactor constraint code to use this code?
       * L: Find where is lean's mathlab library (readlink -f $(type -P lean)) and add it to config file
       * L: Extract dir recursively from jar
       * E: Switch to records
       */
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition");
      var reasonerName = reasoner.getName();
      Model relatedModel = null; // TODO find related model here + review Lean GSN reasoner name + fix orElse
      var templates = reasoner.getTemplateProperties(relatedModel);
      var property = selectProperty(title, "Select the property to be decomposed",
                                    "Insert the " + reasonerName + " property to be decomposed", templates);
      var shortProperty = builder.shortenProperty(property);
      var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, "Insert the number of sub-properties",
                                                                     null));
      // create decomposition template
      var id = this.decomposed.getId();
      var formalStrategyId = "SF-" + id;
      var formalStrategyDesc = "Argument by " + reasonerName + " formalization";
      var modelGoalId = id + "-M";
      var modelGoalDesc = "The related model correctly models all aspects of the system related to property " +
                          shortProperty;
      var propGoalId = id + "-P";
      var propGoalDesc = id + " asserts the property " + shortProperty;
      var formalGoalId = id + "-F";
      var formalGoalDesc = "The property " + shortProperty + " holds for the related model";
      var propStrategyId = "SP-" + id;
      var propStrategyDesc = "Decomposition over property " + shortProperty;
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
        var subProperty = selectProperty(title, "Select the sub-property #" + (i+1),
                                         "Insert the sub-property #" + (i+1), templates);
        var subShortProperty = builder.shortenProperty(subProperty);
        var subGoal = builder.createPropertyGoal(subGoalId + i, subGoalDesc1 + subShortProperty + subGoalDesc2,
                                                 reasonerName, subProperty);
        builder.addSupporter(propStrategy, subGoal);
      }
      builder.addSupporter(this.decomposed, formalStrategy);

      return propStrategy;
    }
  }
}
