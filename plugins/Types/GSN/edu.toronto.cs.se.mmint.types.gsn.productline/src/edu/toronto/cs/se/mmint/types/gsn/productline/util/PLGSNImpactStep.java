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
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ImpactStep;

public class PLGSNImpactStep extends ImpactStep<PLGSNArgumentElement> {
  private GSNPackage gsn;

  public PLGSNImpactStep(PLGSNArgumentElement impacted, List<EObject> trace) {
    super(impacted, trace);
    this.gsn = GSNPackage.eINSTANCE;
  }

  public PLGSNImpactStep(PLGSNArgumentElement impacted) {
    super(impacted);
    this.gsn = GSNPackage.eINSTANCE;
  }

  public List<PLGSNImpactStep> nextSupporters() {
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    for (var plSupportedBy : this.impacted.getReference(this.gsn.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(this.gsn.getSupportedBy_Target())) {
        var nextTrace = new ArrayList<EObject>();
        nextTrace.add(plSupportedBy);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNImpactStep((PLGSNArgumentElement) plSupporter, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  public List<PLGSNImpactStep> nextContexts() {
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    for (var plInContextOf : this.impacted.getReference(this.gsn.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(this.gsn.getInContextOf_Context())) {
        var nextTrace = new ArrayList<EObject>();
        nextTrace.add(plInContextOf);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNImpactStep((PLGSNArgumentElement) plContext, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  private Map<ImpactType, Optional<Class>> getImpacts(List<Class> impacts) {
    var impactMap = new HashMap<ImpactType, Optional<Class>>();
    for (var impact : impacts) {
      var type = impact.getAttribute(this.gsn.getImpactAnnotation_Type()).get(0);
      impactMap.put(ImpactType.valueOf(type), Optional.of(impact));
    }
    for (var type : ImpactType.VALUES) {
      impactMap.computeIfAbsent(type, _ -> Optional.empty());
    }

    return impactMap;
  }

  public Map<ImpactType, Optional<Class>> getCurrentImpacts() {
    return getImpacts(this.impacted.getReference(this.gsn.getArgumentElement_Status()));
  }

  public Map<ImpactType, Optional<Class>> getPreviousImpacts() {
    return this.trace.stream()
      .filter(t -> t instanceof PLGSNArgumentElement)
      .map(t -> ((PLGSNArgumentElement) t).getReference(this.gsn.getArgumentElement_Status()))
      .filter(r -> !r.isEmpty())
      .map(r -> getImpacts(r))
      .findFirst()
      .orElseGet(() -> {
        var impactType = switch (ImpactStep.data.get(ImpactStep.CHANGE_KEY)) {
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
        var c = PLFactory.eINSTANCE.createClass();
        c.setPresenceCondition(this.impacted.getPresenceCondition());
        c.setType(this.gsn.getImpactAnnotation());
        c.addAttribute(this.gsn.getImpactAnnotation_Type(), impactType.toString());
        return getImpacts(List.of(c));
      });
  }

  public void addImpact(Map<ImpactType, Optional<Class>> currImpacts, ImpactType type) {
    currImpacts.get(type).ifPresentOrElse(
      c -> c.setPresenceCondition(this.impacted.getPresenceCondition()),
      () -> {
        var c = PLFactory.eINSTANCE.createClass();
        c.setPresenceCondition(this.impacted.getPresenceCondition());
        c.setType(this.gsn.getImpactAnnotation());
        this.impacted.getProductLine().getClasses().add(c);
        c.addAttribute(this.gsn.getImpactAnnotation_Type(), type.toString());
        this.impacted.addReference(this.gsn.getArgumentElement_Status(), c);
      });
  }

  public void removeImpact(Map<ImpactType, Optional<Class>> currImpacts, ImpactType type) {
    currImpacts.get(type).ifPresent(Class::delete);
  }

  public void setImpact(Map<ImpactType, Optional<Class>> currImpacts, Map<ImpactType, Optional<Class>> newImpacts) {
    for (var newImpact : newImpacts.entrySet()) {
      newImpact.getValue().ifPresentOrElse(
        _ -> addImpact(currImpacts, newImpact.getKey()),
        () -> removeImpact(currImpacts, newImpact.getKey()));
    }
  }

  @Override
  public List<PLGSNImpactStep> nextSteps() {
    var currImpacts = getCurrentImpacts();
    var prevImpacts = getPreviousImpacts();
    // impact rules
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    switch (this.impacted.getType()) {
      case EClass e when e.getName().equals("Goal") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Goal")) -> {
        setImpact(currImpacts, prevImpacts);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getName().equals("Strategy") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Strategy")) -> {
        setImpact(currImpacts, prevImpacts);
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
        setImpact(currImpacts, Map.of(ImpactType.REUSE, Optional.of(this.impacted),
                                      ImpactType.RECHECK, Optional.empty(),
                                      ImpactType.REVISE, Optional.empty()));
      }
      default -> {
        setImpact(currImpacts, prevImpacts);
      }
    }

    return nextSteps;
  }

  @Override
  public void impact() throws Exception {
    var currImpacts = getCurrentImpacts();
    var prevImpacts = getPreviousImpacts();
    // stop condition: already impacted with equal or more priority (REVISE > RECHECK > REUSE)
    if (currImpacts.get(ImpactType.REVISE).isPresent() ||
        currImpacts.get(ImpactType.RECHECK).isPresent() && !prevImpacts.get(ImpactType.REVISE).isPresent() ||
        currImpacts.get(ImpactType.REUSE).isPresent() && !prevImpacts.get(ImpactType.RECHECK).isPresent()) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getReference(this.gsn.getArgumentElement_Template());
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).impact(this);
    for (var nextStep : nextSteps) {
      nextStep.impact();
    }
  }
}
