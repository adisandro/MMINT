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
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;

public class GSNImpactStep extends ImpactStep<ArgumentElement> {

  public GSNImpactStep(ArgumentElement impacted, List<EObject> trace) {
    super(impacted, trace);
  }

  public GSNImpactStep(ArgumentElement impacted) {
    super(impacted);
  }

  private List<GSNImpactStep> nextSupporters() {
    var nextSteps = new ArrayList<GSNImpactStep>();
    for (var supportedBy : ((Supportable) this.impacted).getSupportedBy()) {
      var nextTrace = new ArrayList<EObject>();
      nextTrace.add(supportedBy);
      nextTrace.add(this.impacted);
      nextTrace.addAll(this.trace);
      var nextStep = new GSNImpactStep(supportedBy.getTarget(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  private List<GSNImpactStep> nextContexts() {
    var nextSteps = new ArrayList<GSNImpactStep>();
    for (var inContextOf : ((Contextualizable) this.impacted).getInContextOf()) {
      var nextTrace = new ArrayList<EObject>();
      nextTrace.add(inContextOf);
      nextTrace.add(this.impacted);
      nextTrace.addAll(this.trace);
      var nextStep = new GSNImpactStep(inContextOf.getContext(), nextTrace);
      nextSteps.add(nextStep);
    }

    return nextSteps;
  }

  private ImpactType getPreviousImpact(Object change) {
    return this.trace.stream()
      .filter(t -> t instanceof ArgumentElement)
      .map(t -> ((ArgumentElement) t).getStatus().getType())
      .findFirst()
      .orElseGet(() -> {
        return switch (change) {
          case String type -> {
            try {
              yield ImpactType.valueOf(type);
            }
            catch (IllegalArgumentException e) {
              yield ImpactType.RECHECK;
            }
          }
          default -> ImpactType.RECHECK;
        };
      });
  }

  private void addImpact(@Nullable ImpactAnnotation currImpact, ImpactType type) {
    if (currImpact == null) {
      currImpact = GSNFactory.eINSTANCE.createImpactAnnotation();
      this.impacted.setStatus(currImpact);
    }
    currImpact.setType(type);
  }

  @Override
  public List<GSNImpactStep> nextSteps(Object change) {
    var currImpact = this.impacted.getStatus();
    var prevImpact = getPreviousImpact(change);
    // impact rules
    var nextSteps = new ArrayList<GSNImpactStep>();
    switch (this.impacted) {
      case Goal goal -> {
        addImpact(currImpact, prevImpact);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case Strategy strategy -> {
        addImpact(currImpact, prevImpact);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case Contextual context -> {
        addImpact(currImpact, ImpactType.REUSE);
      }
      default -> {
        addImpact(currImpact, prevImpact);
      }
    };

    return nextSteps;
  }

  @Override
  public void impact(Object change) throws Exception {
    var currImpact = this.impacted.getStatus();
    var prevImpact = getPreviousImpact(change);
    // stop condition: already impacted with equal or more priority (REVISE > RECHECK > REUSE)
    if (currImpact != null && currImpact.getType().compareTo(prevImpact) >= 0) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getTemplates();
    var nextSteps = (templates.isEmpty()) ? nextSteps(change) : templates.get(0).impact(this, change);
    for (var nextStep : nextSteps) {
      nextStep.impact(change);
    }
  }
}
