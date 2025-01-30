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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ImpactStep;

public class PLGSNImpactStep extends ImpactStep<Class> {
  GSNPackage gsn;

  public PLGSNImpactStep(Class impacted, List<EObject> trace) {
    super(impacted, trace);
    this.gsn = GSNPackage.eINSTANCE;
  }

  public PLGSNImpactStep(Class impacted) {
    super(impacted);
    this.gsn = GSNPackage.eINSTANCE;
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

  private Map<ImpactType, Optional<Class>> getImpacts(List<Class> impactRefs) {
    var impacts = new HashMap<ImpactType, Optional<Class>>();
    for (var impact : impactRefs) {
      var type = impact.getAttribute(this.gsn.getImpactAnnotation_Type()).get(0);
      impacts.put(ImpactType.valueOf(type), Optional.of(impact));
    }
    for (var type : ImpactType.VALUES) {
      impacts.computeIfAbsent(type, _ -> Optional.empty());
    }

    return impacts;
  }

  private Map<ImpactType, Optional<Class>> getCurrentImpacts() {
    return getImpacts(this.impacted.getReference(this.gsn.getArgumentElement_Status()));
  }

  private Map<ImpactType, Optional<Class>> getPreviousImpacts(Object change) {
    Map<ImpactType, Optional<Class>> prevImpacts = null;
    for (var traceElem : this.trace) {
      if (!(traceElem instanceof Class traceClass)) {
        continue;
      }
      var impactRefs = traceClass.getReference(this.gsn.getArgumentElement_Status());
      if (!impactRefs.isEmpty()) {
        prevImpacts = getImpacts(impactRefs);
        break;
      }
    }
    if (prevImpacts == null) {
      var c = PLFactory.eINSTANCE.createClass();
      c.setType(this.gsn.getImpactAnnotation());
      c.addAttribute(this.gsn.getImpactAnnotation_Type(), ImpactType.RECHECK.toString()); //TODO: derive from change
      prevImpacts = Map.of(ImpactType.REUSE, Optional.empty(),
                           ImpactType.RECHECK, Optional.of(c),
                           ImpactType.REVISE, Optional.empty());
    }

    return prevImpacts;
  }

  private void enableImpact(Map<ImpactType, Optional<Class>> currImpacts, ImpactType type) {
    currImpacts.get(type).ifPresentOrElse(
      c -> c.setPresenceCondition(this.impacted.getPresenceCondition()),
      () -> {
        var c = PLFactory.eINSTANCE.createClass();
        c.setPresenceCondition(this.impacted.getPresenceCondition());
        c.setType(this.gsn.getImpactAnnotation());
        c.addAttribute(this.gsn.getImpactAnnotation_Type(), type.toString());
        this.impacted.addReference(this.gsn.getArgumentElement_Status(), c);
      });
  }

  private void disableImpact(Map<ImpactType, Optional<Class>> currImpacts, ImpactType type) {
    currImpacts.get(type).ifPresent(c -> this.impacted.getReferences().removeIf(r -> r.getTarget() == c));
  }

  private void copyImpact(Map<ImpactType, Optional<Class>> prevImpacts, Map<ImpactType, Optional<Class>> currImpacts) {
    for (var prevImpact : prevImpacts.entrySet()) {
      prevImpact.getValue().ifPresentOrElse(
        _ -> enableImpact(currImpacts, prevImpact.getKey()),
        () -> disableImpact(currImpacts, prevImpact.getKey()));
    }
  }

  @Override
  public List<PLGSNImpactStep> nextSteps(Object change) {
    var currImpacts = getCurrentImpacts();
    var prevImpacts = getPreviousImpacts(change);
    // impact rules
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    switch (this.impacted.getType()) {
      case EClass e when e.getName().equals("Goal") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Goal")) -> {
        copyImpact(prevImpacts, currImpacts);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getName().equals("Strategy") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Strategy")) -> {
        copyImpact(prevImpacts, currImpacts);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
        enableImpact(currImpacts, ImpactType.REUSE);
        disableImpact(currImpacts, ImpactType.RECHECK);
        disableImpact(currImpacts, ImpactType.REVISE);
      }
      default -> {
        copyImpact(prevImpacts, currImpacts);
      }
    }

    return nextSteps;
  }

  @Override
  public void impact(Object change) throws Exception {
    var currImpacts = getCurrentImpacts();
    var prevImpacts = getPreviousImpacts(change);
    // stop condition: already impacted with equal or more priority (REVISE > RECHECK > REUSE)
    if (currImpacts.get(ImpactType.REVISE).isPresent() ||
        currImpacts.get(ImpactType.RECHECK).isPresent() && !prevImpacts.get(ImpactType.REVISE).isPresent() ||
        currImpacts.get(ImpactType.REUSE).isPresent() && !prevImpacts.get(ImpactType.RECHECK).isPresent()) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getReference(this.gsn.getArgumentElement_Templates());
    var nextSteps = (templates.isEmpty()) ? nextSteps(change) : ((PLGSNTemplate) templates.get(0)).impact(this, change);
    for (var nextStep : nextSteps) {
      nextStep.impact(change);
    }
  }
}
