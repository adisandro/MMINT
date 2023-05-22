/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.BasicGoal;
import edu.toronto.cs.se.modelepedia.gsn.BasicStrategy;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class GSNBuilder {
  protected SafetyCase safetyCase;
  protected GSNFactory factory;
  protected List<ArgumentElement> gsnElements;

  public GSNBuilder(SafetyCase safetyCase) {
    this.safetyCase = safetyCase;
    this.factory = GSNFactory.eINSTANCE;
    this.gsnElements = new ArrayList<>();
  }

  public void addSupporter(Supportable supportable, Supporter supporter) {
    var support = this.factory.createSupportedBy();
    support.setSource(supportable);
    support.setTarget(supporter);
  }

  public void addInContextOf(DecomposableCoreElement contextualized, ContextualElement context) {
    var inContext = this.factory.createInContextOf();
    inContext.setContextOf(contextualized);
    inContext.setContext(context);
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

  public void addContext(ContextualElement context, String id, String description) {
    addArgumentElement(context, id, description);
    this.gsnElements.add(context);
  }

  public Justification createJustification(String id, String description) {
    var justification = this.factory.createJustification();
    addContext(justification, id, description);

    return justification;
  }

  public Context createContext(String id, String description) {
    var context = this.factory.createContext();
    addContext(context, id, description);

    return context;
  }

  public void commitChanges() {
    for (var gsnElement : this.gsnElements) {
      if (gsnElement instanceof Goal goal) {
        this.safetyCase.getGoals().add(goal);
      }
      else if (gsnElement instanceof Strategy strategy) {
        this.safetyCase.getStrategies().add(strategy);
      }
      else if (gsnElement instanceof Solution solution) {
        this.safetyCase.getSolutions().add(solution);
      }
      else if (gsnElement instanceof Context context) {
        this.safetyCase.getContexts().add(context);
      }
      else if (gsnElement instanceof Justification justification) {
        this.safetyCase.getJustifications().add(justification);
      }
      else if (gsnElement instanceof Assumption assumption) {
        this.safetyCase.getAssumptions().add(assumption);
      }
    }
  }
}
