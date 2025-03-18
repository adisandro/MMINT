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
import org.eclipse.jdt.annotation.Nullable;

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
  public final static @Nullable String OLD_FEATURES_CONSTRAINT_DEFAULT = null;
  public final static String NEW_FEATURES_CONSTRAINT_KEY = "newFeaturesConstraint";
  public final static String NEW_FEATURE_KEY = "newFeature";
  public final static @Nullable String NEW_FEATURE_DEFAULT = null;
  public final static String PHI_DELTA_KEY = "phiDelta";
  public final static String PHI_KEEP_KEY = "phiKeep";
  public final static String PHI_NEW_KEY = "phiNew";
  private final static GSNPackage GSN = GSNPackage.eINSTANCE;
  public static Map<ImpactType, Optional<String>> REUSE = Map.of();
  public static Map<ImpactType, Optional<String>> RECHECK = Map.of();
  public static Map<ImpactType, Optional<String>> REVISE = Map.of();
  private static IPLFeaturesTrait PL_REASONER = null;
  private IPLFeaturesTrait plReasoner;

  public static Properties initData(PLGSNArgumentElement plModelObj) throws MMINTException {
    // load new properties
    ChangeStep.resetData();
    var props = ChangeStep.initData(plModelObj);
    // read into vars
    var phiOpt = Optional.ofNullable(MIDOperatorIOUtils.getOptionalStringProperty(
      props, PLGSNChangeStep.OLD_FEATURES_CONSTRAINT_KEY, PLGSNChangeStep.OLD_FEATURES_CONSTRAINT_DEFAULT));
    ChangeStep.data.put(PLGSNChangeStep.OLD_FEATURES_CONSTRAINT_KEY, phiOpt);
    var phiPrime = MIDOperatorIOUtils.getStringProperty(props, PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
    ChangeStep.data.put(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY, phiPrime);
    var fOpt = Optional.ofNullable(MIDOperatorIOUtils.getOptionalStringProperty(
      props, PLGSNChangeStep.NEW_FEATURE_KEY, PLGSNChangeStep.NEW_FEATURE_DEFAULT));
    ChangeStep.data.put(PLGSNChangeStep.NEW_FEATURE_KEY, fOpt);
    var phiDelta = MIDOperatorIOUtils.getStringProperty(props, PLGSNChangeStep.PHI_DELTA_KEY);
    ChangeStep.data.put(PLGSNChangeStep.PHI_DELTA_KEY, phiDelta);
    var plReasoner = plModelObj.getProductLine().getReasoner();
    PLGSNChangeStep.PL_REASONER = plReasoner;
    PLGSNChangeStep.REUSE   = Map.of(ImpactType.REUSE,   Optional.of(plReasoner.getTrueLiteral()),
                                     ImpactType.RECHECK, Optional.empty(),
                                     ImpactType.REVISE,  Optional.empty());
    PLGSNChangeStep.RECHECK = Map.of(ImpactType.REUSE,   Optional.empty(),
                                     ImpactType.RECHECK, Optional.of(plReasoner.getTrueLiteral()),
                                     ImpactType.REVISE,  Optional.empty());
    PLGSNChangeStep.REVISE  = Map.of(ImpactType.REUSE,   Optional.empty(),
                                     ImpactType.RECHECK, Optional.empty(),
                                     ImpactType.REVISE,  Optional.of(plReasoner.getTrueLiteral()));
    String phiKeep, phiNew;
    if (fOpt.isPresent()) {
      // new feature added and feature model change
      // the presence of newFeature implies the presence of oldFeaturesConstraint
      var f = fOpt.get();
      var phi = phiOpt.get();
      phiKeep = plReasoner.simplify(plReasoner.and(phi, phiPrime, plReasoner.not(f)));
      phiNew = plReasoner.simplify(plReasoner.and(plReasoner.or(plReasoner.not(phi), f), phiPrime));
    }
    else {
      if (phiOpt.isPresent()) {
        // feature model change
        var phi = phiOpt.get();
        phiKeep = plReasoner.simplify(plReasoner.and(phi, phiPrime));
        phiNew = plReasoner.simplify(plReasoner.and(plReasoner.not(phi), phiPrime));
      }
      else {
        phiKeep = phiPrime;
        phiNew = null;
      }
    }
    ChangeStep.data.put(PLGSNChangeStep.PHI_KEEP_KEY, phiKeep);
    ChangeStep.data.put(PLGSNChangeStep.PHI_NEW_KEY, Optional.ofNullable(phiNew));

    return props;
  }

  public PLGSNChangeStep(PLGSNArgumentElement impacted, LinkedHashSet<EObject> forwardTrace) {
    super(impacted, forwardTrace);
    this.plReasoner = PLGSNChangeStep.PL_REASONER;
  }

  public PLGSNChangeStep(PLGSNArgumentElement impacted) {
    super(impacted);
    this.plReasoner = PLGSNChangeStep.PL_REASONER;
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
      var prevElem = this.forwardTrace.stream()
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
    Map<ImpactType, Optional<String>> prevImpact = null;
    var prevElem = this.forwardTrace.stream()
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
    if (this.backwardTrace.get(0).isEmpty()) {
      // leaf impact
      switch(this.impacted.getType()) {
        case EClass e when e.getEAllSuperTypes().stream().anyMatch(s -> s.getName().equals("Contextual")) -> {
          impactTypes = PLGSNChangeStep.REUSE;
        }
        default -> {
          //TODO add checkSAT api!
          var phiDelta = (String) ChangeStep.data.get(PLGSNChangeStep.PHI_DELTA_KEY);
          var check = this.plReasoner.checkConsistency(phiDelta, Set.of(this.impacted.getPresenceCondition()));
          if (check) {
            impactTypes = Map.of(ImpactType.REUSE,   Optional.of(this.plReasoner.not(phiDelta)),
                                 ImpactType.RECHECK, Optional.of(phiDelta),
                                 ImpactType.REVISE,  Optional.empty());
          }
          else {
            impactTypes = PLGSNChangeStep.REUSE;
          }
        }
      }
    }
    else {
      // bottom up impact
      impactTypes = min(
        this.backwardTrace.get(0).stream().map(s -> s.getImpacted().getImpact()).collect(Collectors.toList()));
    }
    if (prevImpact != null) {
      // top down impact
      impactTypes = min(List.of(prevImpact, impactTypes));
    }

    this.impacted.setImpact(addPhiNew(impactTypes));
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
    this.backwardTrace.add(nextSteps);
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

  public static Map<ImpactType, Optional<String>> addPhiNew(Map<ImpactType, Optional<String>> impactTypes) {
    var phiNewOpt = (Optional<String>) ChangeStep.data.get(PLGSNChangeStep.PHI_NEW_KEY);
    if (phiNewOpt.isEmpty()) {
      return impactTypes;
    }
    // add phiNew to existing impacts
    var phiNew = phiNewOpt.get();
    var reuse = impactTypes.get(ImpactType.REUSE)
                           .map(r -> PLGSNChangeStep.PL_REASONER.simplify(
                             PLGSNChangeStep.PL_REASONER.and(r, PLGSNChangeStep.PL_REASONER.not(phiNew))))
                           .orElse(PLGSNChangeStep.PL_REASONER.not(phiNew));
    var recheck = impactTypes.get(ImpactType.RECHECK)
                             .map(r -> PLGSNChangeStep.PL_REASONER.simplify(
                               PLGSNChangeStep.PL_REASONER.and(r, PLGSNChangeStep.PL_REASONER.not(phiNew))));
    var revise = impactTypes.get(ImpactType.REVISE)
                            .map(r -> PLGSNChangeStep.PL_REASONER.simplify(PLGSNChangeStep.PL_REASONER.and(r, phiNew)))
                            .orElse(phiNew);

    return Map.of(ImpactType.REUSE,   Optional.of(reuse),
                         ImpactType.RECHECK, recheck,
                         ImpactType.REVISE,  Optional.of(revise));
  }

  public static Map<ImpactType, Optional<String>> min(List<Map<ImpactType, Optional<String>>> impacts) {
    String pcReuse = null, pcRevise = null;
    for (var i = 0; i < impacts.size(); i++) {
      var dependencyImpact = impacts.get(i);
      var pc1 = dependencyImpact.get(ImpactType.REUSE).orElse(PLGSNChangeStep.PL_REASONER.getFalseLiteral());
      var pc3 = dependencyImpact.get(ImpactType.REVISE).orElse(PLGSNChangeStep.PL_REASONER.getFalseLiteral());
      pcReuse = (i == 0) ? pc1 : PLGSNChangeStep.PL_REASONER.and(pcReuse, pc1);
      pcRevise = (i == 0) ? pc3 : PLGSNChangeStep.PL_REASONER.or(pcRevise, pc3);
    }
    pcReuse = PLGSNChangeStep.PL_REASONER.simplify(pcReuse);
    pcRevise = PLGSNChangeStep.PL_REASONER.simplify(pcRevise);
    var pcRecheck = PLGSNChangeStep.PL_REASONER.simplify(
      PLGSNChangeStep.PL_REASONER.not(PLGSNChangeStep.PL_REASONER.or(pcReuse, pcRevise)));
    var max = Map.of(ImpactType.REUSE,   PLGSNChangeStep.PL_REASONER.checkConsistency(pcReuse, Set.of()) ?
                                           Optional.of(pcReuse) : Optional.<String>empty(),
                     ImpactType.RECHECK, PLGSNChangeStep.PL_REASONER.checkConsistency(pcRecheck, Set.of()) ?
                                           Optional.of(pcRecheck) : Optional.<String>empty(),
                     ImpactType.REVISE,  PLGSNChangeStep.PL_REASONER.checkConsistency(pcRevise, Set.of()) ?
                                           Optional.of(pcRevise) : Optional.<String>empty());

    return max;
  }

  public static void setAllImpacts(PLGSNTemplate plTemplate, Map<ImpactType, Optional<String>> impactTypes) {
    for (var plElem : plTemplate.getReference(PLGSNChangeStep.GSN.getTemplate_Elements())) {
      if (!plElem.getReference(PLGSNChangeStep.GSN.getArgumentElement_Status()).isEmpty()) {
        continue;
      }
      ((PLGSNArgumentElement) plElem).setImpact(impactTypes);
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
