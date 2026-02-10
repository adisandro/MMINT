/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta.productline.operators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.GateLogic;

public class PLProbabilityPropagation extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("plFTA", PLPackage.eINSTANCE.eNS_URI);
  public ProductLine in0;
  public final static OperatorParameter OUT0 = new OperatorParameter("plFTAProp", PLPackage.eINSTANCE.eNS_URI, null,
                                                                     "_prop");
  public ProductLine out0;
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      var plModel = inputsByName.get(PLProbabilityPropagation.IN0.name());
      if (((ProductLine) plModel.getEMFInstanceRoot()).getMetamodel() != FTAPackage.eINSTANCE) {
        return false;
      }
      return true;
    }
  };
  protected FTAPackage fta;
  protected IPLFeaturesTrait reasoner;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws Exception {
    var plFTAModel = inputsByName.get(PLProbabilityPropagation.IN0.name());
    this.in0 = (ProductLine) plFTAModel.getEMFInstanceRoot();
    this.out0 = EcoreUtil.copy(this.in0);
    this.fta = FTAPackage.eINSTANCE;
    this.reasoner = this.out0.getReasoner();
  }

  private Map<String, BigDecimal> propagate(Class plEvent) {
    var pcsByProb = new HashMap<BigDecimal, List<String>>();
    var gates = plEvent.getReference(this.fta.getEvent_Gate());
    if (gates.isEmpty()) { // basic event
      var prob = new BigDecimal(plEvent.getAttribute(this.fta.getEvent_Probability()));
      return Map.of(plEvent.getPresenceCondition(), prob);
    }
    var gateLogic = GateLogic.valueOf(gates.get(0).getAttribute(this.fta.getGate_Logic()));
    plEvent.getAttributes().removeIf(a -> a.getType() == this.fta.getEvent_Probability());
    // group sub probabilities by presence condition
    var subProbsByPC = new HashMap<String, List<BigDecimal>>();
    gates.get(0).getStreamOfReference(this.fta.getGate_SubEvents())
      .map(this::propagate)
      .forEach(subProb ->
        subProb.forEach(
          (pc, prob) -> subProbsByPC.computeIfAbsent(pc, _ -> new ArrayList<BigDecimal>()).add(prob)));
    // pc & (!other pcs)
    for (var subProbByPC : subProbsByPC.entrySet()) {
      var probPCs = new HashSet<String>();
      probPCs.add(plEvent.getPresenceCondition());
      var pc = subProbByPC.getKey();
      probPCs.add(pc);
      var prob = switch (gateLogic) {
        case AND -> subProbByPC.getValue().stream().reduce(BigDecimal.ONE, BigDecimal::multiply);
        case OR  -> subProbByPC.getValue().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
      };
      probPCs.addAll(subProbsByPC.keySet().stream().filter(pc2 -> !pc.equals(pc2)).map(this.reasoner::not).toList());
      if (this.reasoner.checkConsistency(this.out0.getFeaturesConstraint(), probPCs)) {
        var probPC = this.reasoner.simplify(this.reasoner.and(probPCs.toArray(new String[0])));
        pcsByProb.computeIfAbsent(prob, _ -> new ArrayList<String>()).add(probPC);
      }
    }
    // pc & (other pcs)
    var probPCs = new HashSet<String>();
    probPCs.add(plEvent.getPresenceCondition());
    var allProb = switch (gateLogic) {
      case AND -> BigDecimal.ONE;
      case OR  -> BigDecimal.ZERO;
    };
    for (var subProbByPC : subProbsByPC.entrySet()) {
      var pc = subProbByPC.getKey();
      probPCs.add(pc);
      allProb = switch (gateLogic) {
        case AND -> allProb.multiply(subProbByPC.getValue().stream().reduce(BigDecimal.ONE, BigDecimal::multiply));
        case OR  -> allProb.add(subProbByPC.getValue().stream().reduce(BigDecimal.ZERO, BigDecimal::add));
      };
    }
    if (this.reasoner.checkConsistency(this.out0.getFeaturesConstraint(), probPCs)) {
      var probPC = this.reasoner.simplify(this.reasoner.and(probPCs.toArray(new String[0])));
      pcsByProb.computeIfAbsent(allProb, _ -> new ArrayList<String>()).add(probPC);
    }
    // compact the same probabilities
    var probMap = new HashMap<String, BigDecimal>();
    for (var pcByProb : pcsByProb.entrySet()) {
      var prob = pcByProb.getKey();
      var pcs = pcByProb.getValue();
      var probPC = (pcs.size() == 1) ?
        pcs.get(0) :
        this.reasoner.simplify(this.reasoner.or(pcs.toArray(new String[0]))); // no need to check for consistency
      plEvent.addAttribute(this.fta.getEvent_Probability(), prob.toString(), probPC);
      probMap.put(probPC, prob);
    }

    return probMap;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var plTopEvent = this.out0.getRoot().getStreamOfReference(this.fta.getFaultTree_Events())
      .filter(e -> e.getReference(this.fta.getEvent_SuperGate()).isEmpty())
      .findFirst().get();
    propagate(plTopEvent);

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}
