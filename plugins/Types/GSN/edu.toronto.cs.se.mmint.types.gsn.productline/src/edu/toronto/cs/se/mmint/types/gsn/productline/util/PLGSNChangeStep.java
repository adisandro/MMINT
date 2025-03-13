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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

public class PLGSNChangeStep extends ChangeStep<PLGSNArgumentElement> {
  public final static String PHI_DELTA_KEY = "phiDelta";
  public final static String OLD_FEATURES_CONSTRAINT_KEY = "oldFeaturesConstraint";
  public final static String NEW_FEATURE_KEY = "newFeature";
  private final static GSNPackage GSN;
  private static String phiDelta;
  private static Optional<String> oldFeaturesConstraint;
  private static Optional<String> newFeature;
  private static IPLFeaturesTrait plReasoner;
  private static String phiPrime;
  private static String phiOld;
  private static String phiNew;
  static {
    GSN = GSNPackage.eINSTANCE;
    resetProperties();
  }

  public static void resetProperties() {
    ChangeStep.resetProperties();
    PLGSNChangeStep.phiDelta = "";
    PLGSNChangeStep.oldFeaturesConstraint = Optional.empty();
    PLGSNChangeStep.newFeature = Optional.empty();
    PLGSNChangeStep.plReasoner = null;
    PLGSNChangeStep.phiPrime = "";
    PLGSNChangeStep.phiOld = "";
    PLGSNChangeStep.phiNew = "";
  }

  public static Properties initProperties(PLGSNArgumentElement plModelObj) throws MMINTException {
    // load new properties
    PLGSNChangeStep.resetProperties();
    ChangeStep.initProperties(plModelObj);
    // read into vars
    PLGSNChangeStep.phiDelta = MIDOperatorIOUtils.getStringProperty(ChangeStep.properties,
                                                                    PLGSNChangeStep.PHI_DELTA_KEY);
    PLGSNChangeStep.oldFeaturesConstraint = Optional.ofNullable(
      MIDOperatorIOUtils.getOptionalStringProperty(ChangeStep.properties, PLGSNChangeStep.OLD_FEATURES_CONSTRAINT_KEY,
                                                   null));
    PLGSNChangeStep.newFeature = Optional.ofNullable(
      MIDOperatorIOUtils.getOptionalStringProperty(ChangeStep.properties, PLGSNChangeStep.NEW_FEATURE_KEY, null));
    var productLine = plModelObj.getProductLine();
    PLGSNChangeStep.plReasoner = productLine.getReasoner();
    PLGSNChangeStep.phiPrime = productLine.getFeaturesConstraint();
    PLGSNChangeStep.newFeature.ifPresentOrElse(
      f -> { // the presence of newFeature implies the presence of oldFeaturesConstraint
        var phi = PLGSNChangeStep.oldFeaturesConstraint.get();
        PLGSNChangeStep.phiOld = PLGSNChangeStep.plReasoner.simplify(
          PLGSNChangeStep.plReasoner.and(phi, PLGSNChangeStep.phiPrime, PLGSNChangeStep.plReasoner.not(f)));
        PLGSNChangeStep.phiNew = PLGSNChangeStep.plReasoner.simplify(
          PLGSNChangeStep.plReasoner.and(PLGSNChangeStep.plReasoner.not(phi), PLGSNChangeStep.phiPrime, f));;
      },
      () -> {
        PLGSNChangeStep.oldFeaturesConstraint.ifPresentOrElse(
          phi -> {
            PLGSNChangeStep.phiOld = PLGSNChangeStep.plReasoner.simplify(
              PLGSNChangeStep.plReasoner.and(phi, PLGSNChangeStep.phiPrime));
            PLGSNChangeStep.phiNew = PLGSNChangeStep.plReasoner.simplify(
              PLGSNChangeStep.plReasoner.and(PLGSNChangeStep.plReasoner.not(phi), PLGSNChangeStep.phiPrime));
          },
          ()  -> {
            PLGSNChangeStep.phiOld = PLGSNChangeStep.phiPrime;
            PLGSNChangeStep.phiNew = PLGSNChangeStep.plReasoner.getFalseLiteral();
          });
      });

    return ChangeStep.properties;
  }

  public PLGSNChangeStep(PLGSNArgumentElement impacted, LinkedHashSet<EObject> trace) {
    super(impacted, trace);
  }

  public PLGSNChangeStep(PLGSNArgumentElement impacted) {
    super(impacted);
  }

  public List<PLGSNChangeStep> nextSupporters() {
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    for (var plSupportedBy : this.impacted.getReference(PLGSNChangeStep.GSN.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(PLGSNChangeStep.GSN.getSupportedBy_Target())) {
        var nextTrace = new LinkedHashSet<EObject>();
        nextTrace.add(plSupportedBy);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNChangeStep((PLGSNArgumentElement) plSupporter, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  public List<PLGSNChangeStep> nextContexts() {
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    for (var plInContextOf : this.impacted.getReference(PLGSNChangeStep.GSN.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(PLGSNChangeStep.GSN.getInContextOf_Context())) {
        var nextTrace = new LinkedHashSet<EObject>();
        nextTrace.add(plInContextOf);
        nextTrace.add(this.impacted);
        nextTrace.addAll(this.trace);
        var nextStep = new PLGSNChangeStep((PLGSNArgumentElement) plContext, nextTrace);
        nextSteps.add(nextStep);
      }
    }

    return nextSteps;
  }

  @Override
  public List<PLGSNChangeStep> nextSteps() {
    // next steps proper
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    switch (this.impacted.getType()) {
      case EClass e when e.getName().equals("Goal") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Goal")) -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getName().equals("Strategy") ||
                         e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Strategy")) -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {}
      default -> {}
    }
    // check for top down impact and propagate if present when not leaf
    if (!nextSteps.isEmpty()) {
      var prevElem = getTrace().stream()
        .filter(t -> t instanceof PLGSNArgumentElement)
        .map(PLGSNArgumentElement.class::cast)
        .findFirst();
      prevElem.ifPresent(e -> {
        if (e.getImpact().values().stream().anyMatch(pc -> pc.isPresent())) {
          this.impacted.setImpact(e.getImpact());
        }
      });
    }

    return nextSteps;
  }

  @Override
  public void baselineImpact(List<? extends ChangeStep<PLGSNArgumentElement>> dependencySteps) {
    Map<ImpactType, Optional<String>> prevImpact = null;
    var prevElem = getTrace().stream()
      .filter(t -> t instanceof PLGSNArgumentElement)
      .map(PLGSNArgumentElement.class::cast)
      .findFirst();
    if (prevElem.isPresent()) {
      var prevImpact2 = prevElem.get().getImpact();
      if (prevImpact2.values().stream().anyMatch(pc -> pc.isPresent())) {
        prevImpact = prevImpact2;
      }
    }
    Map<ImpactType, Optional<String>> impact;
    if (dependencySteps.isEmpty()) { // leaf
      switch(this.impacted.getType()) {
        case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
          impact = Map.of(
            ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.getTrueLiteral()),
            ImpactType.RECHECK, Optional.empty(),
            ImpactType.REVISE,  Optional.empty());
        }
        default -> {
          //TODO add checkSAT api!
          var check = PLGSNChangeStep.plReasoner.checkConsistency(PLGSNChangeStep.phiDelta,
                                                                  Set.of(this.impacted.getPresenceCondition()));
          if (check) {
            impact = Map.of(
              ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.simplify(
                                    PLGSNChangeStep.plReasoner.not(PLGSNChangeStep.phiDelta))),
              ImpactType.RECHECK, Optional.of(PLGSNChangeStep.phiDelta),
              ImpactType.REVISE,  Optional.empty());
          }
          else {
            impact = Map.of(
              ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.getTrueLiteral()),
              ImpactType.RECHECK, Optional.empty(),
              ImpactType.REVISE,  Optional.empty());
          }
        }
      }
    }
    else { // bottom up impact
      dependencySteps.stream().map(s -> s.getImpacted().getImpact());
      impact = null;
    }
    if (prevImpact != null) { // top down impact

    }
    this.impacted.setImpact(impact);
  }

  @Override
  public void impact() throws Exception {
    // stop conditions: impacted or its template already in trace
    if (this.trace.contains(this.impacted)) {
      return;
    }
    var templates = this.impacted.getReference(PLGSNChangeStep.GSN.getArgumentElement_Template());
    if (!templates.isEmpty() && this.trace.contains(templates.get(0))) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).nextImpactSteps(this);
    for (var nextStep : nextSteps) {
      nextStep.impact();
    }
    if (templates.isEmpty()) {
      baselineImpact(nextSteps);
    }
    else {
      ((PLGSNTemplate) templates.get(0)).impact(this, ECollections.asEList(nextSteps));
    }
  }

  @Override
  public void repair() throws Exception {
    // stop condition: already in trace
    if (this.trace.contains(this.impacted)) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getReference(PLGSNChangeStep.GSN.getArgumentElement_Template());
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).repair(this);
    for (var nextStep : nextSteps) {
      nextStep.repair();
    }
  }

  public static void setAllImpacts(PLGSNTemplate plTemplate, ImpactType type) {
    for (var plElem : plTemplate.getReference(PLGSNChangeStep.GSN.getTemplate_Elements())) {
      if (!plElem.getReference(PLGSNChangeStep.GSN.getArgumentElement_Status()).isEmpty()) {
        continue;
      }
      ((PLGSNArgumentElement) plElem).setImpact(type, PLGSNChangeStep.plReasoner.getTrueLiteral());
    }
  }

  public static void deleteBranch(Class plElem) {
    var productLine = plElem.getProductLine();
    for (var plInContextOf : plElem.getReference(PLGSNChangeStep.GSN.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(PLGSNChangeStep.GSN.getInContextOf_Context())) {
        plContext.delete();
      }
      productLine.getClasses().remove(plInContextOf);
    }
    for (var plSupportedBy : plElem.getReference(PLGSNChangeStep.GSN.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(PLGSNChangeStep.GSN.getSupportedBy_Target())) {
        deleteBranch(plSupporter);
      }
      productLine.getClasses().remove(plSupportedBy);
    }
    plElem.delete();
  }
}
