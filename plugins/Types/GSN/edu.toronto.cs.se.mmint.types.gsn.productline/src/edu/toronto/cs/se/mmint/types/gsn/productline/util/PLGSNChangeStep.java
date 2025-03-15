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
import java.util.stream.Collectors;

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
  public final static String OLD_FEATURES_CONSTRAINT_KEY = "oldFeaturesConstraint";
  public final static String NEW_FEATURE_KEY = "newFeature";
  public final static String PHI_DELTA_KEY = "phiDelta";
  public final static String NEW_FEATURES_CONSTRAINT_KEY = "newFeaturesConstraint";
  private final static GSNPackage GSN;
  private static Optional<String> oldFeaturesConstraint;
  private static Optional<String> newFeature;
  private static String phiDelta;
  private static String phiPrime;
  private static IPLFeaturesTrait plReasoner;
  private static String phiOld;
  private static String phiNew;
  static {
    GSN = GSNPackage.eINSTANCE;
    resetProperties();
  }

  public static void resetProperties() {
    ChangeStep.resetProperties();
    PLGSNChangeStep.oldFeaturesConstraint = Optional.empty();
    PLGSNChangeStep.newFeature = Optional.empty();
    PLGSNChangeStep.phiDelta = "";
    PLGSNChangeStep.phiPrime = "";
    PLGSNChangeStep.plReasoner = null;
    PLGSNChangeStep.phiOld = "";
    PLGSNChangeStep.phiNew = "";
  }

  public static Properties initProperties(PLGSNArgumentElement plModelObj) throws MMINTException {
    // load new properties
    PLGSNChangeStep.resetProperties();
    ChangeStep.initProperties(plModelObj);
    // read into vars
    PLGSNChangeStep.oldFeaturesConstraint = Optional.ofNullable(
      MIDOperatorIOUtils.getOptionalStringProperty(ChangeStep.properties, PLGSNChangeStep.OLD_FEATURES_CONSTRAINT_KEY,
                                                   null));
    PLGSNChangeStep.newFeature = Optional.ofNullable(
      MIDOperatorIOUtils.getOptionalStringProperty(ChangeStep.properties, PLGSNChangeStep.NEW_FEATURE_KEY, null));
    PLGSNChangeStep.phiDelta = MIDOperatorIOUtils.getStringProperty(ChangeStep.properties,
                                                                    PLGSNChangeStep.PHI_DELTA_KEY);
    PLGSNChangeStep.phiPrime = MIDOperatorIOUtils.getStringProperty(ChangeStep.properties,
                                                                    PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
    PLGSNChangeStep.plReasoner = plModelObj.getProductLine().getReasoner();
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

  public PLGSNChangeStep(PLGSNArgumentElement impacted, LinkedHashSet<EObject> forwardTrace) {
    super(impacted, forwardTrace);
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
        nextTrace.addAll(this.forwardTrace);
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
        nextTrace.addAll(this.forwardTrace);
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
      var prevElem = getForwardTrace().stream()
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
  public void baselineImpact() {
    var backwardTrace = getBackwardTrace();
    Map<ImpactType, Optional<String>> prevImpact = null;
    var prevElem = getForwardTrace().stream()
      .filter(t -> t instanceof PLGSNArgumentElement)
      .map(PLGSNArgumentElement.class::cast)
      .findFirst();
    if (prevElem.isPresent()) {
      var prevImpact2 = prevElem.get().getImpact();
      if (prevImpact2.values().stream().anyMatch(pc -> pc.isPresent())) {
        prevImpact = prevImpact2;
      }
    }
    Map<ImpactType, Optional<String>> impactTypes;
    if (backwardTrace.get(0).isEmpty()) { // leaf
      switch(this.impacted.getType()) {
        case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
          impactTypes = Map.of(
            ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.getTrueLiteral()),
            ImpactType.RECHECK, Optional.empty(),
            ImpactType.REVISE,  Optional.empty());
        }
        default -> {
          //TODO add checkSAT api!
          var check = PLGSNChangeStep.plReasoner.checkConsistency(PLGSNChangeStep.phiDelta,
                                                                  Set.of(this.impacted.getPresenceCondition()));
          if (check) {
            impactTypes = Map.of(
              ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.not(PLGSNChangeStep.phiDelta)),
              ImpactType.RECHECK, Optional.of(PLGSNChangeStep.phiDelta),
              ImpactType.REVISE,  Optional.empty());
          }
          else {
            impactTypes = Map.of(
              ImpactType.REUSE,   Optional.of(PLGSNChangeStep.plReasoner.getTrueLiteral()),
              ImpactType.RECHECK, Optional.empty(),
              ImpactType.REVISE,  Optional.empty());
          }
        }
      }
    }
    else { // bottom up impact
      impactTypes = max(
        backwardTrace.get(0).stream().map(s -> s.getImpacted().getImpact()).collect((Collectors.toList())));
    }
    if (prevImpact != null) { // top down impact
      impactTypes = max(List.of(prevImpact, impactTypes));
    }
    this.impacted.setImpact(impactTypes);
  }

  @Override
  public void impact() throws Exception {
    // stop conditions: impacted or its template already in trace
    if (this.forwardTrace.contains(this.impacted)) {
      return;
    }
    var templates = this.impacted.getReference(PLGSNChangeStep.GSN.getArgumentElement_Template());
    if (!templates.isEmpty() && this.forwardTrace.contains(templates.get(0))) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).nextImpactSteps(this);
    getBackwardTrace().add(nextSteps);
    for (var nextStep : nextSteps) {
      nextStep.impact();
    }
    if (templates.isEmpty()) {
      baselineImpact();
    }
    else {
      ((PLGSNTemplate) templates.get(0)).impact(this);
    }
  }

  @Override
  public void repair() throws Exception {
    // stop condition: already in trace
    if (this.forwardTrace.contains(this.impacted)) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var templates = this.impacted.getReference(PLGSNChangeStep.GSN.getArgumentElement_Template());
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).repair(this);
    for (var nextStep : nextSteps) {
      nextStep.repair();
    }
  }

  public static Map<ImpactType, Optional<String>> max(List<Map<ImpactType, Optional<String>>> impacts) {
    String pcReuse = null, pcRevise = null;
    for (var i = 0; i < impacts.size(); i++) {
      var dependencyImpact = impacts.get(i);
      var pc1 = dependencyImpact.get(ImpactType.REUSE).orElse(PLGSNChangeStep.plReasoner.getFalseLiteral());
      var pc3 = dependencyImpact.get(ImpactType.REVISE).orElse(PLGSNChangeStep.plReasoner.getFalseLiteral());
      pcReuse = (i == 0) ? pc1 : PLGSNChangeStep.plReasoner.and(pcReuse, pc1);
      pcRevise = (i == 0) ? pc3 : PLGSNChangeStep.plReasoner.or(pcRevise, pc3);
    }
    pcReuse = PLGSNChangeStep.plReasoner.simplify(pcReuse);
    pcRevise = PLGSNChangeStep.plReasoner.simplify(pcRevise);
    var pcRecheck = PLGSNChangeStep.plReasoner.simplify(
      PLGSNChangeStep.plReasoner.not(PLGSNChangeStep.plReasoner.or(pcReuse, pcRevise)));
    var max = Map.of(
      ImpactType.REUSE,   PLGSNChangeStep.plReasoner.checkConsistency(pcReuse, Set.of()) ?
                            Optional.of(pcReuse) : Optional.<String>empty(),
      ImpactType.RECHECK, PLGSNChangeStep.plReasoner.checkConsistency(pcRecheck, Set.of()) ?
                            Optional.of(pcRecheck) : Optional.<String>empty(),
      ImpactType.REVISE,  PLGSNChangeStep.plReasoner.checkConsistency(pcRevise, Set.of()) ?
                            Optional.of(pcRevise) : Optional.<String>empty());

    return max;
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
