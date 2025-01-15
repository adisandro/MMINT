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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.operators.bridge.ToProductLine;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class TextFileToSMProductLine extends ToProductLine {

  protected static class TextFileToSMPLOut extends Out {
    public TextFileToSMPLOut(Map<String, MID> outputMIDsByName, String workingPath, In in)
                                  throws MMINTException {
      super(outputMIDsByName, workingPath, in);
      this.productLine.setMetamodel(StateMachinePackage.eINSTANCE);
      this.plPath = workingPath + IPath.SEPARATOR +
                    FileUtils.replaceFileExtensionInPath(in.productModel.getName(),
                                                         this.plModelType.getFileExtension());
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.reasonerName = "LogicNG";
    this.presenceCondition = "$true";
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.in = new In(inputsByName, this.reasonerName, this.presenceCondition);
    this.out = new TextFileToSMPLOut(outputMIDsByName, getWorkingPath(), this.in);
  }

  @Override
  protected void toProductLine() throws IOException {
    var filePath = Paths.get(FileUtils.prependWorkspacePath(this.in.productModel.getUri()));
    var plStates = new HashMap<String, Class>();
    var parseStates = false;
    Class currTransition = null;
    var plSM = PLFactory.eINSTANCE.createClass();
    plSM.setType(StateMachinePackage.eINSTANCE.getStateMachine());
    this.out.productLine.getClasses().add(plSM);
    for (var line : Files.readAllLines(filePath)) {
      line = line.strip();
      if (line.isEmpty() || line.startsWith("LocalVars") || line.startsWith("bint")) {
        // ignore
        continue;
      }
      if (line.startsWith("Feature model: ")) {
        // feature model
        var featuresConstraint = line.substring("Feature model: ".length());
        this.out.productLine.setFeaturesConstraint(featuresConstraint);
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
        var pc = "";
        if (fromState.isAlwaysPresent()) {
          pc = toState.getPresenceCondition();
        }
        else if (toState.isAlwaysPresent()) {
          pc = fromState.getPresenceCondition();
        }
        else {
          pc = this.in.reasoner.simplify(
            this.in.reasoner.and(fromState.getPresenceCondition(), toState.getPresenceCondition()));
        }
        var plTransition = PLFactory.eINSTANCE.createClass();
        plTransition.setPresenceCondition(pc);
        plTransition.setType(StateMachinePackage.eINSTANCE.getTransition());
        this.out.productLine.getClasses().add(plTransition);
        plSM.addReference(StateMachinePackage.eINSTANCE.getStateMachine_Transitions(), plTransition);
        plTransition.addReference(StateMachinePackage.eINSTANCE.getTransition_Source(), fromState);
        plTransition.addReference(StateMachinePackage.eINSTANCE.getTransition_Target(), toState);
        currTransition = plTransition;
        continue;
      }
      if (line.startsWith("when ")) {
        // current transition trigger and action
        var tokens = line.substring("when ".length()).split(" do ");
        currTransition.addAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Trigger(), tokens[0].strip());
        if (tokens.length > 1) {
          currTransition.addAttribute(StateMachinePackage.eINSTANCE.getFiringElement_Action(), tokens[1].strip());
        }
        continue;
      }
      if (parseStates) {
        // state
        var tokens = line.split(",");
        var stateName = tokens[0].substring(1, tokens[0].length()-1);
        var pc = this.in.pc;
        var plState = PLFactory.eINSTANCE.createClass();
        if (tokens.length > 1) {
          tokens[1] = tokens[1].strip();
          pc = tokens[1].substring("<Features: ".length(), tokens[1].length()-1);
        }
        addPLClass(plState, stateName, pc, StateMachinePackage.eINSTANCE.getState(), plStates);
        plState.addAttribute(StateMachinePackage.eINSTANCE.getAbstractState_Name(), stateName);
        plSM.addReference(StateMachinePackage.eINSTANCE.getStateMachine_States(), plState);
        continue;
      }
    }
  }
}
