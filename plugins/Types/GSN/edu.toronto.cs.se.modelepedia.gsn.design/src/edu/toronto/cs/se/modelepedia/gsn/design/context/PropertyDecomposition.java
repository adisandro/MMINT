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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.DecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IDecompositionTrait;
import edu.toronto.cs.se.modelepedia.gsn.util.PropertyBuilder;

public class PropertyDecomposition extends GoalDecomposition {
  public static final int SHORT_PROPERTY = 15;

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(goal);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PropertyDecompositionCommand(sDomain, goal));
  }

  private class PropertyDecompositionCommand extends GoalDecompositionCommand {

    public PropertyDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain, decomposed, new PropertyBuilder((SafetyCase) decomposed.eContainer()));
    }

    private String shortenProperty(String property) {
      var shortProperty = (property.length() < PropertyDecomposition.SHORT_PROPERTY) ?
        property :
        property.substring(0, PropertyDecomposition.SHORT_PROPERTY) +  "..";
      return "'" + shortProperty + "'";
    }

    private Model getRelatedModel() throws MMINTException {
      var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(this.decomposed);
      var gsnDecomposedUri = MIDRegistry.getModelElementUri(this.decomposed);
      var modelRels = MIDRegistry.getConnectedModelRels(gsnModel, gsnModel.getMIDContainer());
      for (var modelRel : modelRels) {
        if (modelRel.getModelEndpoints().size() != 2) { // exclude non-binary
          continue;
        }
        // find decomposed, get the other side, check that it's the root of its own model
        for (var mapping : modelRel.getMappings()) {
          var endpoints = mapping.getModelElemEndpoints();
          if (endpoints.size() != 2) { // exclude non-binary
            continue;
          }
          ModelElement relatedModelElem;
          var uri0 = MIDRegistry.getModelObjectUri(endpoints.get(0).getTarget());
          var uri1 = MIDRegistry.getModelObjectUri(endpoints.get(1).getTarget());
          if (uri0.equals(gsnDecomposedUri)) {
            relatedModelElem = endpoints.get(1).getTarget();
          }
          else if (uri1.equals(gsnDecomposedUri)) {
            relatedModelElem = endpoints.get(0).getTarget();
          }
          else {
            continue;
          }
          var relatedModelObj = relatedModelElem.getEMFInstanceObject();
          var relatedModel = (Model) relatedModelElem.eContainer();
          var relatedModelObjRoot = relatedModel.getEMFInstanceRoot();
          if (relatedModelObj == relatedModelObjRoot) {
            return relatedModel;
          }
        }
      }
      throw new MMINTException("Not found");
    }

    private Model getRelatedModel2() throws MMINTException {
      return null;
    }

    @Override
    protected DecompositionStrategy decompose() throws Exception {
      /**TODO
       * P: Refactor constraint code to use this code?
       * P: Add decomposition check
       * P: Solve reasoner name problem
       * L: Find where is lean's mathlab library (readlink -f $(type -P lean)) and add it to config file
       * L: Extract dir recursively from jar
       * L: Is it GSNLeanReasoner or LTSLeanReasoner?
       */
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var reasoner = MIDDialogs.selectReasoner(IDecompositionTrait.class, "GSN property decomposition");
      var reasonerName = reasoner.getName();
      var property = MIDDialogs.getBigStringInput(title, "Insert the " + reasonerName + " property to be decomposed",
                                                  null);
      var shortProperty = shortenProperty(property);
      var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, "Insert the number of sub-properties",
                                                                     null));
      // create decomposition template
      var id = this.decomposed.getId();
      var desc = this.decomposed.getDescription();
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
        var subProperty = MIDDialogs.getBigStringInput(title, "Insert the sub-property #" + (i+1), null);
        var subShortProperty = shortenProperty(subProperty);
        var subGoal = builder.createPropertyGoal(subGoalId + i, subGoalDesc1 + subShortProperty + subGoalDesc2,
                                                 reasonerName, subProperty);
        builder.addSupporter(propStrategy, subGoal);
      }
      builder.addSupporter(this.decomposed, formalStrategy);

      return propStrategy;
    }
  }
}
