/*******************************************************************************
 * Copyright (c) 2020, 2025 Alessio Di Sandro.
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

import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.Template;

public class GSNBuilder {
  public final static String PATTERN1 = "{";
  public final static String PATTERN2 = "}";

  protected SafetyCase safetyCase;
  protected GSNFactory factory;

  public GSNBuilder(SafetyCase safetyCase) {
    this.safetyCase = safetyCase;
    this.factory = GSNFactory.eINSTANCE;
  }

  public static Optional<String> findPattern(String text) {
    var i = text.indexOf(GSNBuilder.PATTERN1);
    if (i == -1) {
      return Optional.empty();
    }
    var j = text.indexOf(GSNBuilder.PATTERN2, i);
    if (j == -1) {
      return Optional.empty();
    }

    return Optional.of(text.substring(i+GSNBuilder.PATTERN1.length(), j));
  }

  public static String askForPath(String title, String message) throws MIDDialogCancellation {
    var dialog = new MIDTreeSelectionDialog(new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider(),
                                            ResourcesPlugin.getWorkspace().getRoot());
    var resource = (IResource) MIDDialogs.openTreeDialog(dialog, title, message);

    return resource.getFullPath().toString();
  }

  public void addSupporter(Supportable supportable, Supporter supporter) {
    var support = this.factory.createSupportedBy();
    support.setSource(supportable);
    support.setTarget(supporter);
  }

  public void addInContextOf(Contextualizable contextualizable, Contextual context) {
    var inContext = this.factory.createInContextOf();
    inContext.setContextOf(contextualizable);
    inContext.setContext(context);
  }

  public void addArgumentElement(ArgumentElement argument, String id, String description) {
    argument.setId(id);
    argument.setDescription(description);
  }

  public void addGoal(Goal goal, String id, String description) {
    addArgumentElement(goal, id, description);
    this.safetyCase.getGoals().add(goal);
  }

  public void addStrategy(Strategy strategy, String id, String description) {
    addArgumentElement(strategy, id, description);
    this.safetyCase.getStrategies().add(strategy);
  }

  public Goal createGoal(String id, String description) {
    var goal = this.factory.createGoal();
    addGoal(goal, id, description);

    return goal;
  }

  public Strategy createStrategy(String id, String description) {
    var strategy = this.factory.createStrategy();
    addStrategy(strategy, id, description);

    return strategy;
  }

  public void addJustification(Justification justification, String id, String description) {
    addArgumentElement(justification, id, description);
    this.safetyCase.getJustifications().add(justification);
  }

  public void addContext(Context context, String id, String description) {
    addArgumentElement(context, id, description);
    this.safetyCase.getContexts().add(context);
  }

  public Justification createJustification(String id, String description) {
    var justification = this.factory.createJustification();
    addJustification(justification, id, description);

    return justification;
  }

  public Context createContext(String id, String description) {
    var context = this.factory.createContext();
    addContext(context, id, description);

    return context;
  }

  public void addExistingElement(ArgumentElement gsnElement) {
    switch (gsnElement) {
      case Goal goal -> this.safetyCase.getGoals().add(goal);
      case Strategy strategy -> this.safetyCase.getStrategies().add(strategy);
      case Solution solution -> this.safetyCase.getSolutions().add(solution);
      case Context context -> this.safetyCase.getContexts().add(context);
      case Justification justification -> this.safetyCase.getJustifications().add(justification);
      case Assumption assumption -> this.safetyCase.getAssumptions().add(assumption);
      default -> {}
    }
  }

  public void addExistingElements(List<? extends ArgumentElement> gsnElements) {
    for (var gsnElement : List.copyOf(gsnElements)) {
      addExistingElement(gsnElement);
    }
  }

  public void addExistingTemplate(Template template) {
    this.safetyCase.getTemplates().add(template);
  }
}
