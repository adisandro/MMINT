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
import java.util.function.Function;

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

  public Map<ImpactType, Optional<String>> reuse() {
    var pc = this.plReasoner.getTrueLiteral();
    return Map.of(ImpactType.REUSE,   Optional.of(this.plReasoner.getTrueLiteral()),
                  ImpactType.RECHECK, Optional.empty(),
                  ImpactType.REVISE,  Optional.empty());
  }

  public Map<ImpactType, Optional<String>> recheck() {
    return Map.of(ImpactType.REUSE,   Optional.empty(),
                  ImpactType.RECHECK, Optional.of(this.plReasoner.getTrueLiteral()),
                  ImpactType.REVISE,  Optional.empty());
  }

  public Map<ImpactType, Optional<String>> revise() {
    return Map.of(ImpactType.REUSE,   Optional.empty(),
                  ImpactType.RECHECK, Optional.empty(),
                  ImpactType.REVISE,  Optional.of(this.plReasoner.getTrueLiteral()));
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
    switch (this.impacted) {
      case PLGSNArgumentElement e when e.instanceOf(PLGSNChangeStep.GSN.getGoal()) -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case PLGSNArgumentElement e when e.instanceOf(PLGSNChangeStep.GSN.getStrategy()) -> {
        nextSteps.addAll(nextSupporters());
        nextSteps.addAll(nextContexts());
      }
      case PLGSNArgumentElement e when e.instanceOf(PLGSNChangeStep.GSN.getContextual()) -> {}
      default -> {}
    }
    // when not leaf, check for top down impact and propagate if present
    if (!nextSteps.isEmpty()) {
      var prevElem = this.forwardTrace.stream()
        .filter(PLGSNArgumentElement.class::isInstance)
        .map(PLGSNArgumentElement.class::cast)
        .findFirst();
      prevElem.ifPresent(e -> {
        if (e.getImpact().values().stream().anyMatch(Optional::isPresent)) {
          this.impacted.setImpact(e.getImpact());
        }
      });
    }

    return nextSteps;
  }

  @Override
  public void baselineImpact() {
    Map<ImpactType, Optional<String>> topImpact = null;
    var topElem = this.forwardTrace.stream()
      .filter(PLGSNArgumentElement.class::isInstance)
      .map(PLGSNArgumentElement.class::cast)
      .findFirst();
    if (topElem.isPresent()) {
      var topImpact2 = topElem.get().getImpact();
      if (topImpact2.values().stream().anyMatch(Optional::isPresent)) {
        topImpact = topImpact2;
      }
    }
    Map<ImpactType, Optional<String>> impact;
    if (this.backwardTrace.get(0).isEmpty()) {
      // leaf
      switch (this.impacted) {
        case PLGSNArgumentElement e when e.instanceOf(PLGSNChangeStep.GSN.getContextual()) -> {
          impact = reuse();
        }
        default -> {
          var phiDelta = (String) ChangeStep.data.get(PLGSNChangeStep.PHI_DELTA_KEY);
          var pc = this.impacted.getPresenceCondition();
          var check = this.plReasoner.checkConsistency(phiDelta, Set.of(pc));
          if (check) {
            var reuse = this.plReasoner.simplify(this.plReasoner.and(pc, this.plReasoner.not(phiDelta)));
            var recheck = this.plReasoner.simplify(this.plReasoner.and(pc, phiDelta));
            impact = Map.of(ImpactType.REUSE,   Optional.of(reuse),
                            ImpactType.RECHECK, Optional.of(recheck),
                            ImpactType.REVISE,  Optional.empty());
          }
          else {
            impact = reuse();
          }
        }
      }
      if (topImpact != null) {
        // add top down impact
        try {
          impact = min(List.of(topImpact, impact),
                       List.of(topElem.get().getPresenceCondition(), this.impacted.getPresenceCondition()));
        }
        catch (MMINTException e) {
          // can't happen
        }
      }
    }
    else {
      // bottom up impact
      var bottomImpacts = new ArrayList<Map<ImpactType, Optional<String>>>();
      var bottomImpactPCs = new ArrayList<String>();
      for (var bStep : getBackwardTrace().get(0)) {
        var impacted = bStep.getImpacted();
        bottomImpacts.add(impacted.getImpact()); // always use downstream impacts
        bottomImpactPCs.add(impacted.getPresenceCondition());
        if (impacted.instanceOf(PLGSNChangeStep.GSN.getStrategy())) {
          // downstream strategy: get supporters' impacts too
          impacted.getStreamOfReference(PLGSNChangeStep.GSN.getSupporter_Supports())
            .map(s -> ((PLGSNArgumentElement) s.getReference(PLGSNChangeStep.GSN.getSupportedBy_Source()).get(0)))
            .forEach(s -> {
              bottomImpacts.add(s.getImpact());
              bottomImpactPCs.add(s.getPresenceCondition());
            });
        }
      }
      if (topImpact != null) {
        // add top down impact
        bottomImpacts.add(topImpact);
        bottomImpactPCs.add(topElem.get().getPresenceCondition());
      }
      try {
        impact = min(bottomImpacts, bottomImpactPCs);
      }
      catch (MMINTException e) {
        // can't happen
        impact = revise();
      }
    }

    this.impacted.setImpact(addPhiNew(impact));
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
      this.backwardTrace.addAll(nextStep.getBackwardTrace());
    }
    if (templates.isEmpty()) {
      baselineImpact();
    }
    else {
      ((PLGSNTemplate) templates.get(0)).impact(this);
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
    var templates = this.impacted.getReference(PLGSNChangeStep.GSN.getArgumentElement_Template());
    if (!templates.isEmpty() && this.forwardTrace.contains(templates.get(0))) {
      return;
    }
    // separate syntactic vs semantic (template) behavior
    var nextSteps = (templates.isEmpty()) ? nextSteps() : ((PLGSNTemplate) templates.get(0)).nextRepairSteps(this);
    this.backwardTrace.add(nextSteps);
    for (var nextStep : nextSteps) {
      nextStep.repair();
    }
    if (templates.isEmpty()) {
      baselineRepair();
    }
    else {
      ((PLGSNTemplate) templates.get(0)).repair(this);
    }
  }

  public static Map<ImpactType, Optional<String>> addPhiNew(Map<ImpactType, Optional<String>> impact) {
    var phiNewOpt = (Optional<String>) ChangeStep.data.get(PLGSNChangeStep.PHI_NEW_KEY);
    if (phiNewOpt.isEmpty()) {
      return impact;
    }
    // add phiNew to existing impacts
    var phiNew = phiNewOpt.get();
    var reuse = impact.get(ImpactType.REUSE)
                      .map(r -> PLGSNChangeStep.PL_REASONER.simplify(
                         PLGSNChangeStep.PL_REASONER.and(r, PLGSNChangeStep.PL_REASONER.not(phiNew))))
                      .orElse(PLGSNChangeStep.PL_REASONER.not(phiNew));
    var recheck = impact.get(ImpactType.RECHECK)
                        .map(r -> PLGSNChangeStep.PL_REASONER.simplify(
                          PLGSNChangeStep.PL_REASONER.and(r, PLGSNChangeStep.PL_REASONER.not(phiNew))));
    var revise = impact.get(ImpactType.REVISE)
                       .map(r -> PLGSNChangeStep.PL_REASONER.simplify(PLGSNChangeStep.PL_REASONER.and(r, phiNew)))
                       .orElse(phiNew);

    return Map.of(ImpactType.REUSE,   Optional.of(reuse),
                  ImpactType.RECHECK, recheck,
                  ImpactType.REVISE,  Optional.of(revise));
  }

  public static Map<ImpactType, Optional<String>> min(List<Map<ImpactType, Optional<String>>> impacts,
                                                      List<String> presenceConditions) throws MMINTException {
    if (impacts.size() != presenceConditions.size()) {
      throw new MMINTException("Each impact must have an associated presence condition");
    }

    var _false = PLGSNChangeStep.PL_REASONER.getFalseLiteral();
    var phi = presenceConditions.get(0);
    var reusePhi = impacts.get(0).get(ImpactType.REUSE).orElse(_false);
    var recheckPhi = impacts.get(0).get(ImpactType.RECHECK).orElse(_false);
    var revisePhi = impacts.get(0).get(ImpactType.REVISE).orElse(_false);
    var i = 1;
    while (i < impacts.size()) {
      var psi = presenceConditions.get(i);
      var reusePsi = impacts.get(i).get(ImpactType.REUSE).orElse(_false);
      var recheckPsi = impacts.get(i).get(ImpactType.RECHECK).orElse(_false);
      var revisePsi = impacts.get(i).get(ImpactType.REVISE).orElse(_false);
      reusePhi = PLGSNChangeStep.PL_REASONER.simplify(
        PLGSNChangeStep.PL_REASONER.or(
          PLGSNChangeStep.PL_REASONER.and(reusePhi, reusePsi),
          PLGSNChangeStep.PL_REASONER.and(reusePhi, PLGSNChangeStep.PL_REASONER.not(psi)),
          PLGSNChangeStep.PL_REASONER.and(reusePsi, PLGSNChangeStep.PL_REASONER.not(phi))));
      recheckPhi = PLGSNChangeStep.PL_REASONER.simplify(
        PLGSNChangeStep.PL_REASONER.or(
          PLGSNChangeStep.PL_REASONER.and(recheckPhi, PLGSNChangeStep.PL_REASONER.not(psi)),
          PLGSNChangeStep.PL_REASONER.and(recheckPsi, PLGSNChangeStep.PL_REASONER.not(phi)),
          PLGSNChangeStep.PL_REASONER.and(
            PLGSNChangeStep.PL_REASONER.or(recheckPhi, recheckPsi),
            PLGSNChangeStep.PL_REASONER.not(revisePhi),
            PLGSNChangeStep.PL_REASONER.not(revisePsi))));
      revisePhi = PLGSNChangeStep.PL_REASONER.simplify(
        PLGSNChangeStep.PL_REASONER.or(revisePhi, revisePsi));
      phi = PLGSNChangeStep.PL_REASONER.simplify(PLGSNChangeStep.PL_REASONER.or(phi, psi));
      i++;
    }
    var phiPrime = (String) ChangeStep.data.get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
    var min = Map.of(ImpactType.REUSE,   PLGSNChangeStep.PL_REASONER.checkConsistency(phiPrime, Set.of(reusePhi)) ?
                                           Optional.of(reusePhi) : Optional.<String>empty(),
                     ImpactType.RECHECK, PLGSNChangeStep.PL_REASONER.checkConsistency(phiPrime, Set.of(recheckPhi)) ?
                                           Optional.of(recheckPhi) : Optional.<String>empty(),
                     ImpactType.REVISE,  PLGSNChangeStep.PL_REASONER.checkConsistency(phiPrime, Set.of(revisePhi)) ?
                                           Optional.of(revisePhi) : Optional.<String>empty());

    return min;
  }

  public static void setAllRemainingImpacts(PLGSNTemplate plTemplate, ImpactType impactType) {
    for (var plElem : plTemplate.getReference(PLGSNChangeStep.GSN.getTemplate_Elements())) {
      if (!plElem.getReference(PLGSNChangeStep.GSN.getArgumentElement_Status()).isEmpty()) {
        continue;
      }
      ((PLGSNArgumentElement) plElem).setImpact(impactType);
    }
  }

  public static void deleteDownstream(Class plElem) {
    var productLine = plElem.getProductLine();
    for (var plInContextOf : plElem.getReference(PLGSNChangeStep.GSN.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(PLGSNChangeStep.GSN.getInContextOf_Context())) {
        plContext.delete();
      }
      productLine.getClasses().remove(plInContextOf);
    }
    for (var plSupportedBy : plElem.getReference(PLGSNChangeStep.GSN.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(PLGSNChangeStep.GSN.getSupportedBy_Target())) {
        deleteDownstream(plSupporter);
      }
      productLine.getClasses().remove(plSupportedBy);
    }
    plElem.delete();
  }

  private static void changePC(PLGSNArgumentElement plElem, Function<String, String> change) {
    plElem.setPresenceCondition(change.apply(plElem.getPresenceCondition()));
    plElem.getAttributes().stream()
      .forEach(a -> a.setPresenceCondition(change.apply(a.getPresenceCondition())));
    plElem.getStreamOfReference(PLGSNChangeStep.GSN.getArgumentElement_Status())
      .forEach(i -> i.setPresenceCondition(change.apply(i.getPresenceCondition())));
    plElem.getReferences().stream()
      .forEach(r -> r.setPresenceCondition(change.apply(r.getPresenceCondition())));
    plElem.getReferencesAsTarget().stream()
      .forEach(r -> r.setPresenceCondition(change.apply(r.getPresenceCondition())));
  }

  public static void changePCDownstream(PLGSNArgumentElement plElem, Function<String, String> change) {
    changePC(plElem, change);
    plElem.getStreamOfReference(PLGSNChangeStep.GSN.getContextualizable_InContextOf())
      .forEach(ico -> {
        ico.setPresenceCondition(change.apply(ico.getPresenceCondition()));
        ico.getStreamOfReference(PLGSNChangeStep.GSN.getInContextOf_Context())
          .forEach(c -> changePC((PLGSNArgumentElement) c, change));
      });
    plElem.getStreamOfReference(PLGSNChangeStep.GSN.getSupportable_SupportedBy())
      .forEach(sb -> {
        sb.setPresenceCondition(change.apply(sb.getPresenceCondition()));
        sb.getStreamOfReference(PLGSNChangeStep.GSN.getSupportedBy_Target())
          .forEach(t -> changePCDownstream((PLGSNArgumentElement) t, change));
      });
  }
}
