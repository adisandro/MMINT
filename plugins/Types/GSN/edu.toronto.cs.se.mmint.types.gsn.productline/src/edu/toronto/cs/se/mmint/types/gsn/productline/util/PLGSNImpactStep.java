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
package edu.toronto.cs.se.mmint.types.gsn.productline.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ImpactStep;

public class PLGSNImpactStep extends ImpactStep<Class> {
  GSNPackage gsn;

  public PLGSNImpactStep(Class impacted, List<EObject> trace) {
    super(impacted, trace);
    this.gsn = this.gsn;
  }

  public PLGSNImpactStep(Class impacted) {
    super(impacted);
    this.gsn = this.gsn;
  }

  private List<PLGSNImpactStep> nextSupporters() {
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    for (var plSupportedBy : this.impacted.getReference(this.gsn.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(this.gsn.getSupportedBy_Target())) {
        var nextTrace = new ArrayList<EObject>();
        nextTrace.add(plSupportedBy);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNImpactStep(plSupporter, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  private List<PLGSNImpactStep> nextContexts() {
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    for (var plInContextOf : this.impacted.getReference(this.gsn.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(this.gsn.getInContextOf_Context())) {
        var nextTrace = new ArrayList<EObject>();
        nextTrace.add(plInContextOf);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNImpactStep(plContext, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  private List<Class> getPreviousImpacts(Object change) {
    return this.trace.stream()
      .filter(o -> o instanceof PLGSNArgumentElement)//TODO wrong, check for presence of status instead
      .map(o -> ((PLGSNArgumentElement) o).getStreamOfReference(this.gsn.getArgumentElement_Status())
                                          .collect(Collectors.toList()))
      .findFirst()
      .orElseGet(() -> {
        var c = PLFactory.eINSTANCE.createClass();
        c.setType(this.gsn.getImpactAnnotation());
        c.addAttribute(this.gsn.getImpactAnnotation_Type(), ImpactType.RECHECK.toString()); //TODO: derive from change
        return List.of(c);
      });
  }

  @Override
  public List<PLGSNImpactStep> nextSteps(Object change) {
    var currImpacts = this.impacted.getReference(this.gsn.getArgumentElement_Status());
    var prevImpacts = getPreviousImpacts(change);
    // impact rules
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    switch (this.impacted.getType()) {
      case EClass e when e.getName().equals("Goal") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Goal")) -> {
        currImpacts.forEach(i -> i.setAttribute(this.gsn.getImpactAnnotation_Type(), null));
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getName().equals("Strategy") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Strategy")) -> {
        currImpacts.forEach(i -> i.setAttribute(this.gsn.getImpactAnnotation_Type(), null));
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
        currImpacts.forEach(i -> i.setAttribute(this.gsn.getImpactAnnotation_Type(), null));
      }
      default -> {
        currImpacts.forEach(i -> i.setAttribute(this.gsn.getImpactAnnotation_Type(), null));
      }
    }

    return nextSteps;
  }

  @Override
  public void impact(Object change) throws Exception {
    var currImpacts = this.impacted.getReference(this.gsn.getArgumentElement_Status());
    var prevImpacts = getPreviousImpacts(change);
    // stop condition: already impacted with equal or more priority
    if (!currImpacts.isEmpty()) {
      var stop = true;
      for (var currImpact : currImpacts) {
        //TODO MMINT[PL-GSN] Use presence conditions to decide which previous impact should be compared with
        var prevImpact = prevImpacts.get(0).getAttribute(this.gsn.getImpactAnnotation_Type()).get(0);
        var currentType = currImpact.getAttribute(this.gsn.getImpactAnnotation_Type()).get(0);
        if (ImpactType.valueOf(currentType).compareTo(ImpactType.valueOf(prevImpact)) < 0) {
          stop = false;
          break;
        }
      }
      if (stop) {
        return;
      }
    }
    if (currImpacts.isEmpty()) {
      var clazz = PLFactory.eINSTANCE.createClass();
      clazz.setType(this.gsn.getImpactAnnotation());
      this.impacted.addReference(this.gsn.getArgumentElement_Status(), clazz);
      currImpacts = ECollections.asEList(clazz);
    }
    // separate syntactic vs semantic (template) behavior
    for (var currImpact : currImpacts) {
      var templates = this.impacted.getReference(this.gsn.getArgumentElement_Templates());
      var nextSteps = (templates.isEmpty()) ? nextSteps(change) : ((PLGSNTemplate) templates.get(0)).impact(this, change);
      for (var nextStep : nextSteps) {
        nextStep.impact(change);
      }
    }
  }
}
