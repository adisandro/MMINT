/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.ifm24.operators;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.operators.bridge.ToProductLine;
import edu.toronto.cs.se.mmint.types.statemachine.productline.util.PLStateMachineBuilder;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class TextFileToSMProductLine extends ToProductLine {
  public final static OperatorParameter IN0 = ToProductLine.IN0.specialize(FilePackage.eNS_URI);

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    inputProperties.setProperty(ToProductLine.PROP_REASONERNAME, "LogicNG");
    inputProperties.setProperty(ToProductLine.PROP_PRESENCECONDITION, "$true");
    super.init(inputProperties, inputsByName);
    this.out0.setMetamodel(StateMachinePackage.eINSTANCE);
    this.builder = new PLStateMachineBuilder(this.out0);
  }

  @Override
  protected void toProductLine(Map<String, Model> inputsByName) throws Exception {
    var filePath = Paths.get(
      FileUtils.prependWorkspacePath(inputsByName.get(TextFileToSMProductLine.IN0.name()).getUri()));
    var plStates = new HashMap<String, Class>();
    var parseStates = false;
    Class currTransition = null;
    var plSM = this.builder.create(StateMachinePackage.eINSTANCE.getStateMachine(), this.presenceCondition);
    for (var line : Files.readAllLines(filePath)) {
      line = line.strip();
      if (line.isEmpty() || line.startsWith("LocalVars") || line.startsWith("bint")) {
        // ignore
        continue;
      }
      if (line.startsWith("Feature model: ")) {
        // feature model
        var featuresConstraint = line.substring("Feature model: ".length());
        this.out0.setFeaturesConstraint(featuresConstraint);
        continue;
      }
      if (line.startsWith("States:")) {
        // states following
        parseStates = true;
        continue;
      }
      if (line.startsWith("InitialState: \"")) {
        // initial state and end of state parsing
        parseStates = false;
        var initStateName = line.substring("InitialState: \"".length(), line.length()-2);
        plStates.get(initStateName).setType(StateMachinePackage.eINSTANCE.getInitialState());
        continue;
      }
      if (line.startsWith("Transition: ")) {
        // all states are already parsed before transitions
        var tokens = line.split("\"");
        var fromState = plStates.get(tokens[1]);
        var toState = plStates.get(tokens[3]);
        var plTransition = this.builder.connect(StateMachinePackage.eINSTANCE.getTransition(), fromState, toState);
        currTransition = plTransition;
        continue;
      }
      if (line.startsWith("when ")) {
        // current transition trigger and action
        var tokens = line.substring("when ".length()).split(" do ");
        currTransition.setAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Trigger(), tokens[0].strip());
        if (tokens.length > 1) {
          currTransition.setAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Action(), tokens[1].strip());
        }
        continue;
      }
      if (parseStates) {
        // state
        var tokens = line.split(",");
        var stateName = tokens[0].substring(1, tokens[0].length()-1);
        var pc = this.presenceCondition;
        if (tokens.length > 1) {
          tokens[1] = tokens[1].strip();
          pc = tokens[1].substring("<Features: ".length(), tokens[1].length()-1);
        }
        var plState = this.builder.create(StateMachinePackage.eINSTANCE.getState(), plSM, pc);
        plState.setAttribute(StateMachinePackage.eINSTANCE.getAbstractState_Name(), stateName);
        plStates.put(stateName, plState);
        continue;
      }
    }
  }
}
