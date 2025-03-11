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
import java.util.LinkedHashSet;
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

public class GSNChangeStep extends ChangeStep<ArgumentElement> {

  public GSNChangeStep(ArgumentElement impacted, LinkedHashSet<EObject> trace) {
    super(impacted, trace);
  }

  public GSNChangeStep(ArgumentElement impacted) {
    super(impacted);
  }

  private ImpactType getPreviousImpact() {
    return this.trace.stream()
      .filter(t -> t instanceof ArgumentElement)
      .map(t -> ((ArgumentElement) t).getStatus().getType())
      .findFirst()
      .orElse(ChangeStep.defaultImpact);
  }

  private void setImpact(ImpactType impactType) {
    var currImpact = this.impacted.getStatus();
    if (currImpact == null) {
      currImpact = GSNFactory.eINSTANCE.createImpactAnnotation();
      this.impacted.setStatus(currImpact);
    }
    currImpact.setType(impactType);
  }

  @Override
  public void baselineImpact() {
    var prevImpact = getPreviousImpact();
    switch (this.impacted) {
      case Goal _       -> setImpact(prevImpact);
      case Strategy _   -> setImpact(prevImpact);
      case Contextual _ -> setImpact(ImpactType.REUSE);
      default           -> setImpact(prevImpact);
    }
  }

  private List<GSNChangeStep> nextSupporters() {
    var nextSteps = new ArrayList<GSNChangeStep>();
    for (var supportedBy : ((Supportable) this.impacted).getSupportedBy()) {
      var nextTrace = new LinkedHashSet<EObject>();
      nextTrace.add(supportedBy);
      nextTrace.add(this.impacted);
      nextTrace.addAll(this.trace);
      var nextStep = new GSNChangeStep(supportedBy.getTarget(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  private List<GSNChangeStep> nextContexts() {
    var nextSteps = new ArrayList<GSNChangeStep>();
    for (var inContextOf : ((Contextualizable) this.impacted).getInContextOf()) {
      var nextTrace = new LinkedHashSet<EObject>();
      nextTrace.add(inContextOf);
      nextTrace.add(this.impacted);
      nextTrace.addAll(this.trace);
      var nextStep = new GSNChangeStep(inContextOf.getContext(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  @Override
  public List<GSNChangeStep> nextSteps() {
    var nextSteps = new ArrayList<GSNChangeStep>();
    switch (this.impacted) {
      case Goal _ -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case Strategy _ -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case Contextual _ -> {}
      default -> {}
    };

    return nextSteps;
  }

  @Override
  public void impact() throws Exception {
    var currImpact = this.impacted.getStatus();
    var prevImpact = getPreviousImpact();
    // stop condition: already impacted with equal or more priority (REVISE > RECHECK > REUSE)
    if (currImpact != null && currImpact.getType().compareTo(prevImpact) >= 0) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var template = this.impacted.getTemplate();
    List<GSNChangeStep> nextSteps;
    if (template == null) {
      baselineImpact();
      nextSteps = nextSteps();
    }
    else {
      nextSteps = template.impact(this);
    }
    for (var nextStep : nextSteps) {
      nextStep.impact();
    }
  }

  @Override
  public void repair() throws Exception {
    // stop condition: already in trace
    if (this.trace.contains(this.impacted)) {
      //TODO review with templates whether to check the template too
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var template = this.impacted.getTemplate();
    var nextSteps = (template == null) ? nextSteps() : template.repair(this);
    for (var nextStep : nextSteps) {
      nextStep.repair();
    }
  }
}
