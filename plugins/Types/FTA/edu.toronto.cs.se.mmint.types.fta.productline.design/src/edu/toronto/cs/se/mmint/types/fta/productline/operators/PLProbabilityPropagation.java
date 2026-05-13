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
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.GateLogic;

public class PLProbabilityPropagation extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("plFTA", PLPackage.eINSTANCE.eNS_URI);
  public ProductLine plFTA;
  public final static OperatorParameter OUT0 = new OperatorParameter("plFTAProp", PLPackage.eINSTANCE.eNS_URI, null,
                                                                     "_prop");
  public ProductLine plFTAProp;
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      var plFTA = (ProductLine) inputsByName.get(PLProbabilityPropagation.IN0.name()).getEMFInstanceRoot();
      if (plFTA.getMetamodel() != FTAPackage.eINSTANCE) {
        return false;
      }
      return true;
    }
  };
  protected FTAPackage types;
  protected IPLFeaturesTrait reasoner;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws Exception {
    this.plFTA = (ProductLine) inputsByName.get(PLProbabilityPropagation.IN0.name()).getEMFInstanceRoot();
    this.plFTAProp = EcoreUtil.copy(this.plFTA);
    this.types = FTAPackage.eINSTANCE;
    this.reasoner = this.plFTAProp.getReasoner();
  }

  private Map<String, BigDecimal> propagate(Class plEvent) {
    var pcsByProb = new HashMap<BigDecimal, List<String>>();
    var gates = plEvent.getReference(this.types.getEvent_Gate());
    if (gates.isEmpty()) { // basic event
      return plEvent.getAttributes().stream()
        .filter(a -> a.getType() == this.types.getEvent_Probability())
        .collect(Collectors.toMap(Attribute::getPresenceCondition, a -> new BigDecimal(a.getValue())));
    }
    var gateLogic = GateLogic.valueOf(gates.get(0).getAttribute(this.types.getGate_Logic()));
    plEvent.getAttributes().removeIf(a -> a.getType() == this.types.getEvent_Probability());
    // group sub probabilities by presence condition
    var subProbsByPC = new HashMap<String, List<BigDecimal>>();
    gates.get(0).getStreamOfReference(this.types.getGate_SubEvents())
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
      for (var subProbByPC2 : subProbsByPC.entrySet()) {
        var pc2 = subProbByPC2.getKey();
        if (this.plFTAProp.isInAllProducts(pc2)) {
          prob = switch (gateLogic) {
            case AND -> prob.multiply(subProbByPC2.getValue().stream().reduce(BigDecimal.ONE, BigDecimal::multiply));
            case OR  -> prob.add(subProbByPC2.getValue().stream().reduce(BigDecimal.ZERO, BigDecimal::add));
          };
        }
        else if (!pc.equals(pc2)) {
          probPCs.add(this.reasoner.not(pc2));
        }
      }
      if (this.reasoner.checkConsistency(this.plFTAProp.getFeaturesConstraint(), probPCs)) {
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
    if (this.reasoner.checkConsistency(this.plFTAProp.getFeaturesConstraint(), probPCs)) {
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
      plEvent.addAttribute(this.types.getEvent_Probability(), prob.toString(), probPC);
      probMap.put(probPC, prob);
    }

    return probMap;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var plTopEvent = this.plFTAProp.getRoot().getStreamOfReference(this.types.getFaultTree_Events())
      .filter(e -> e.getReference(this.types.getEvent_SuperGate()).isEmpty())
      .findFirst().get();
    propagate(plTopEvent);

    return outputFromInput(PLProbabilityPropagation.IN0, PLProbabilityPropagation.OUT0, inputsByName, outputMIDsByName);
  }
}
