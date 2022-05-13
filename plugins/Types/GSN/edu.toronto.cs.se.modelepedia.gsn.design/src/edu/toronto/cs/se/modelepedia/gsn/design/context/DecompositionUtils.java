/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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

import java.util.Optional;

import org.eclipse.core.runtime.IStatus;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

public class DecompositionUtils {

  public static Strategy moveOneStrategyUp(Goal goal) throws MMINTException {
    if (goal.getSupports().size() > 1) {
      throw new MMINTException("Goal '" + goal.getId() + "' should not support more than one GSN element");
    }
    var supported = goal.getSupports().get(0).getSource();
    if (!(supported instanceof Strategy parentStrategy)) {
      throw new MMINTException("Goal '" + goal.getId() + "' should support a strategy");
    }

    return parentStrategy;
  }

  public static Goal moveOneDecompositionUp(Goal goal) throws MMINTException {
    var strategy = moveOneStrategyUp(goal);
    if (strategy.getSupports().size() > 1) {
      throw new MMINTException("Strategy '" + strategy.getId() + "' should not support more than one GSN element");
    }
    var supported = strategy.getSupports().get(0).getSource();
    if (!(supported instanceof Goal parentGoal)) {
      throw new MMINTException("Strategy '" + strategy.getId() + "' should support a goal");
    }

    return parentGoal;
  }

  public static Optional<Model> getRelatedModel(Goal decomposed) throws MMINTException {
    // detect if this is a decomposition chain
    var relatedGoal = decomposed;
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
}
