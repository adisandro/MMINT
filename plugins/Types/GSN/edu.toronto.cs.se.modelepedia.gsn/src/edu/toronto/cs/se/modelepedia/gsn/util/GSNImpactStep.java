/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;

public class GSNImpactStep extends ImpactStep<ArgumentElement> {

  public GSNImpactStep(ArgumentElement impacted) {
    super(impacted);
  }

  public GSNImpactStep(ArgumentElement impacted, List<EObject> trace) {
    super(impacted, trace);
  }

  private List<GSNImpactStep> nextSupporters(Supportable supportable, List<EObject> trace, Object change) {
    var nextSteps = new ArrayList<GSNImpactStep>();
    for (var supportedBy : supportable.getSupportedBy()) {
      var nextTrace = new ArrayList<EObject>();
      nextTrace.add(supportedBy);
      nextTrace.add(supportable);
      nextTrace.addAll(trace);
      var nextStep = new GSNImpactStep(supportedBy.getTarget(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  private List<GSNImpactStep> nextContexts(Contextualizable contextualizable, List<EObject> trace, Object change) {
    var nextSteps = new ArrayList<GSNImpactStep>();
    for (var inContextOf : contextualizable.getInContextOf()) {
      var nextTrace = new ArrayList<EObject>();
      nextTrace.add(inContextOf);
      nextTrace.add(contextualizable);
      nextTrace.addAll(trace);
      var nextStep = new GSNImpactStep(inContextOf.getContext(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  private ImpactType getPreviousImpact(Object change) {
    return this.trace.stream()
      .filter(o -> o instanceof ArgumentElement)
      .map(o -> ((ArgumentElement) o).getStatus().getType())
      .findFirst()
      .orElse(ImpactType.RECHECK); //TODO: derive from change
  }

  @Override
  public List<GSNImpactStep> nextSteps(Object change) {
    var currImpact = this.impacted.getStatus();
    var prevImpact = getPreviousImpact(change);
    // impact rules
    var nextSteps = new ArrayList<GSNImpactStep>();
    switch (this.impacted) {
      case Goal goal -> {
        currImpact.setType(prevImpact);
        nextSteps.addAll(nextSupporters(goal, this.trace, change));
        nextSteps.addAll(nextContexts(goal, this.trace, change));
      }
      case Strategy strategy -> {
        currImpact.setType(prevImpact);
        nextSteps.addAll(nextSupporters(strategy, this.trace, change));
        nextSteps.addAll(nextContexts(strategy, this.trace, change));
      }
      case Contextual context -> {
        currImpact.setType(ImpactType.REUSE);
      }
      default -> {
        currImpact.setType(prevImpact);
      }
    };

    return nextSteps;
  }

  @Override
  public void impact(Object change) throws Exception {
    var currImpact = this.impacted.getStatus();
    var prevImpact = getPreviousImpact(change);
    // stop condition: already impacted with equal or more priority
    if (currImpact != null && currImpact.getType().compareTo(prevImpact) >= 0) {
      return;
    }
    if (currImpact == null) {
      currImpact = GSNFactory.eINSTANCE.createImpactAnnotation();
      this.impacted.setStatus(currImpact);
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getTemplates();
    var nextSteps = (templates.isEmpty()) ? nextSteps(change) : templates.get(0).impact(this, change);
    for (var nextStep : nextSteps) {
      nextStep.impact(change);
    }
  }
}
