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
import java.util.Comparator;
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

  public GSNChangeStep(ArgumentElement impacted, LinkedHashSet<EObject> forwardTrace) {
    super(impacted, forwardTrace);
  }

  public GSNChangeStep(ArgumentElement impacted) {
    super(impacted);
  }

  private void setImpact(ImpactType impactType) {
    var impact = this.impacted.getStatus();
    if (impact == null) {
      impact = GSNFactory.eINSTANCE.createImpactAnnotation();
      this.impacted.setStatus(impact);
    }
    impact.setType(impactType);
  }

  private List<GSNChangeStep> nextSupporters() {
    var nextSteps = new ArrayList<GSNChangeStep>();
    for (var supportedBy : ((Supportable) this.impacted).getSupportedBy()) {
      var nextTrace = new LinkedHashSet<EObject>();
      nextTrace.add(supportedBy);
      nextTrace.add(this.impacted);
      nextTrace.addAll(this.forwardTrace);
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
      nextTrace.addAll(this.forwardTrace);
      var nextStep = new GSNChangeStep(inContextOf.getContext(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  @Override
  public List<GSNChangeStep> nextSteps() {
    // next steps proper
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
    // when not leaf, check for top down impact and propagate if present
    if (!nextSteps.isEmpty()) {
      var prevElem = this.forwardTrace.stream()
        .filter(ArgumentElement.class::isInstance)
        .map(ArgumentElement.class::cast)
        .findFirst();
      prevElem.ifPresent(e -> {
        if (e.getStatus() != null) {
          setImpact(e.getStatus().getType());
        }
      });
    }

    return nextSteps;
  }

  @Override
  public void baselineImpact() {
    ImpactType topImpactType = null;
    var topElem = this.forwardTrace.stream()
      .filter(ArgumentElement.class::isInstance)
      .map(ArgumentElement.class::cast)
      .findFirst();
    if (topElem.isPresent()) {
      var topImpact = topElem.get().getStatus();
      if (topImpact != null) {
        topImpactType = topImpact.getType();
      }
    }
    ImpactType impactType;
    if (this.backwardTrace.get(0).isEmpty()) { // leaf
      impactType = switch(this.impacted) {
        case Contextual _ -> ImpactType.REUSE;
        default           -> ImpactType.RECHECK;
      };
    }
    else { // bottom up impact
      impactType = this.backwardTrace.get(0).stream()
        .map(s -> s.getImpacted().getStatus().getType())
        .max(Comparator.comparing(ImpactType::getValue))
        .get();
    }
    if (topImpactType != null && topImpactType.getValue() > impactType.getValue()) { // top down impact
      impactType = topImpactType;
    }
    setImpact(impactType);
  }

  @Override
  public void impact() throws Exception {
    // stop conditions: impacted or its template already in trace
    if (this.forwardTrace.contains(this.impacted)) {
      return;
    }
    var template = this.impacted.getTemplate();
    if (template != null && this.forwardTrace.contains(template)) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var nextSteps = (template == null) ? nextSteps() : template.nextImpactSteps(this);
    this.backwardTrace.add(nextSteps);
    for (var nextStep : nextSteps) {
      nextStep.impact();
    }
    if (template == null) {
      baselineImpact();
    }
    else {
      template.impact(this);
    }
  }

  @Override
  public void baselineRepair() {
    // do nothing: the only meaningful repair is with templates
  }

  @Override
  public void repair() throws Exception {
    // stop conditions: impacted or its template already in trace
    if (this.forwardTrace.contains(this.impacted)) {
      return;
    }
    var template = this.impacted.getTemplate();
    if (template != null && this.forwardTrace.contains(template)) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var nextSteps = (template == null) ? nextSteps() : template.nextRepairSteps(this);
    this.backwardTrace.add(nextSteps);
    for (var nextStep : nextSteps) {
      nextStep.repair();
    }
    if (template == null) {
      baselineRepair();
    }
    else {
      template.repair(this);
    }
  }
}
