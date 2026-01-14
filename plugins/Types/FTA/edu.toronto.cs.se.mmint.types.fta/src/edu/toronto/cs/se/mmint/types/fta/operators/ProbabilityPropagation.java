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
package edu.toronto.cs.se.mmint.types.fta.operators;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.types.fta.Event;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.FaultTree;

public class ProbabilityPropagation extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("fta", FTAPackage.eINSTANCE.eNS_URI);
  public FaultTree in0;
  public final static OperatorParameter OUT0 = new OperatorParameter("ftaProp", FTAPackage.eINSTANCE.eNS_URI, null,
                                                                     "_prop");
  public FaultTree out0;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    var ftaModel = inputsByName.get(ProbabilityPropagation.IN0.name());
    this.in0 = (FaultTree) ftaModel.getEMFInstanceRoot();
    this.out0 = EcoreUtil.copy(this.in0);
  }

  private BigDecimal propagate(Event event) {
    var gate = event.getGate();
    if (gate == null) { // basic event
      return event.getProbability();
    }
    var subProbs = gate.getSubEvents().stream().map(this::propagate);
    var prob = switch (gate.getLogic()) {
      case AND -> subProbs.reduce(BigDecimal.ONE, BigDecimal::multiply);
      case OR -> subProbs.reduce(BigDecimal.ZERO, BigDecimal::add);
    };
    event.setProbability(prob);

    return prob;
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    propagate(this.out0.getTopEvent());

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}
