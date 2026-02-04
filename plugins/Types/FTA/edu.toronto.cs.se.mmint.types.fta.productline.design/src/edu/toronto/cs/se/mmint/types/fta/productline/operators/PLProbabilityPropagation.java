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
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
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

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    var plFTAModel = inputsByName.get(PLProbabilityPropagation.IN0.name());
    this.in0 = (ProductLine) plFTAModel.getEMFInstanceRoot();
    this.out0 = EcoreUtil.copy(this.in0);
    this.fta = FTAPackage.eINSTANCE;
  }

  private BigDecimal propagate(Class plEvent) {
    var gates = plEvent.getReference(this.fta.getEvent_Gate());
    if (gates.isEmpty()) { // basic event
      return new BigDecimal(plEvent.getAttribute(this.fta.getEvent_Probability()));
    }
    var subProbs = gates.get(0).getStreamOfReference(this.fta.getGate_SubEvents()).map(this::propagate);
    var prob = switch (GateLogic.valueOf(gates.get(0).getAttribute(this.fta.getGate_Logic()))) {
      case AND -> subProbs.reduce(BigDecimal.ONE, BigDecimal::multiply);
      case OR  -> subProbs.reduce(BigDecimal.ZERO, BigDecimal::add);
    };
    plEvent.setAttribute(this.fta.getEvent_Probability(), prob.toString());

    return prob;
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
