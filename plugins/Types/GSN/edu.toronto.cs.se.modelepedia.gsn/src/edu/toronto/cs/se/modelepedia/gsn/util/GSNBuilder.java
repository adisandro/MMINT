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
package edu.toronto.cs.se.modelepedia.gsn.util;

import java.util.ArrayList;
import java.util.List;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class GSNBuilder {
  protected SafetyCase gsnRootModelObj;
  protected GSNFactory factory;
  protected List<ArgumentElement> gsnElements;

  public GSNBuilder(SafetyCase gsnRootModelObj) {
    this.gsnRootModelObj = gsnRootModelObj;
    this.factory = GSNFactory.eINSTANCE;
    this.gsnElements = new ArrayList<>();
  }

  public void addSupporter(Supportable supportable, Supporter supporter) {
    var support = this.factory.createSupportedBy();
    support.setSource(supportable);
    support.setTarget(supporter);
  }

  public void addArgumentElement(ArgumentElement argument, String id, String description) {
    argument.setId(id);
    argument.setDescription(description);
  }

  public void addGoal(Goal goal, String id, String description) {
    addArgumentElement(goal, id, description);
    this.gsnElements.add(goal);
  }

  public void addStrategy(Strategy strategy, String id, String description) {
    addArgumentElement(strategy, id, description);
    this.gsnElements.add(strategy);
  }

  public BasicGoal createBasicGoal(String id, String description) {
    var goal = this.factory.createBasicGoal();
    addGoal(goal, id, description);

    return goal;
  }

  public BasicStrategy createBasicStrategy(String id, String description) {
    var strategy = this.factory.createBasicStrategy();
    addStrategy(strategy, id, description);

    return strategy;
  }

  public void addContext(DecomposableCoreElement decomposable, ContextualElement contextual) {
    var context = this.factory.createInContextOf();
    context.setContextOf(decomposable);
    context.setContext(contextual);
  }

  public Justification createJustification(Strategy strategy, String id, String description) {
    var justification = this.factory.createJustification();
    addArgumentElement(justification, id, description);
    addContext(strategy, justification);
    this.gsnElements.add(justification);

    return justification;
  }

  public void commitChanges() {
    for (var gsnElement : this.gsnElements) {
      if (gsnElement instanceof Strategy) {
        this.gsnRootModelObj.getStrategies().add((Strategy) gsnElement);
      }
      else if (gsnElement instanceof Justification) {
        this.gsnRootModelObj.getJustifications().add((Justification) gsnElement);
      }
      else if (gsnElement instanceof Goal) {
        this.gsnRootModelObj.getGoals().add((Goal) gsnElement);
      }
    }
  }
}
