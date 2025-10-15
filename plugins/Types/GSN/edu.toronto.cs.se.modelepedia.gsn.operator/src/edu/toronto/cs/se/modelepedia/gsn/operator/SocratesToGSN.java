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
package edu.toronto.cs.se.modelepedia.gsn.operator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class SocratesToGSN extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter();
  public final static OperatorParameter OUT0 = new OperatorParameter();
  static {
    SocratesToGSN.IN0.name = "json";
    SocratesToGSN.IN0.type = FilePackage.eNS_URI;
    SocratesToGSN.OUT0.name = "gsn";
    SocratesToGSN.OUT0.type = GSNPackage.eNS_URI;
    SocratesToGSN.OUT0.ext = GSNPackage.eNAME;
  }
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      if (!inputsByName.get(SocratesToGSN.IN0.name).getFileExtension().equals("json")) {
        return false;
      }
      return true;
    }
  };

  private void convert(Map<String, Model> inputsByName) throws Exception {
    var safetyCase = GSNFactory.eINSTANCE.createSafetyCase();
    SocratesToGSN.OUT0.root = safetyCase;
    var json = Files.readString(Paths.get(
      FileUtils.prependWorkspacePath(inputsByName.get(SocratesToGSN.IN0.name).getUri())));

    var jsonObj = JsonParser.parseString(json).getAsJsonObject();
    var idToElem = new HashMap<Integer, ArgumentElement>();
    var idToChildren = new HashMap<Integer, JsonArray>();
    for (var node : jsonObj.get("nodes").getAsJsonArray()) {
      var nodeObj = node.getAsJsonObject();
      var id = nodeObj.get("lid").getAsInt();
      var gsnElem = switch(nodeObj.get("nodeType").getAsString()) {
        case "GOAL" -> {
          var goal = GSNFactory.eINSTANCE.createGoal();
          goal.setId("G" + id);
          safetyCase.getGoals().add(goal);
          yield goal;
        }
        case "STRATEGY" -> {
          var strategy = GSNFactory.eINSTANCE.createStrategy();
          strategy.setId("S" + id);
          safetyCase.getStrategies().add(strategy);
          yield strategy;
        }
        case "SOLUTION" -> {
          var solution = GSNFactory.eINSTANCE.createSolution();
          solution.setId("Sn" + id);
          safetyCase.getSolutions().add(solution);
          yield solution;
        }
        case "CONTEXT" -> {
          var context = GSNFactory.eINSTANCE.createContext();
          context.setId("C" + id);
          safetyCase.getContexts().add(context);
          yield context;
        }
        case "JUSTIFICATION" -> {
          var justification = GSNFactory.eINSTANCE.createJustification();
          justification.setId("J" + id);
          safetyCase.getJustifications().add(justification);
          yield justification;
        }
        case "ASSUMPTION" -> {
          var assumption = GSNFactory.eINSTANCE.createAssumption();
          assumption.setId("A" + id);
          safetyCase.getAssumptions().add(assumption);
          yield assumption;
        }
        case String type -> throw new MMINTException("Unsupported node " + type);
      };
      var desc = nodeObj.get("text").getAsString();
      var extraDesc = nodeObj.get("description");
      if (!extraDesc.isJsonNull()) {
        desc += "\n(" + extraDesc.getAsString() + ")";
      }
      gsnElem.setDescription(desc);
      idToElem.put(id, gsnElem);
      idToChildren.put(id, nodeObj.get("children").getAsJsonArray());
    }
    for (var childEntry : idToChildren.entrySet()) {
      var parent = idToElem.get(childEntry.getKey());
      for (var childId : childEntry.getValue()) {
        var child = idToElem.get(childId.getAsInt());
        if (child instanceof Contextual contextual) {
          var inContextOf = GSNFactory.eINSTANCE.createInContextOf();
          ((Contextualizable) parent).getInContextOf().add(inContextOf);
          inContextOf.setContext(contextual);
        }
        else { // instanceof Supporter
          var supportedBy = GSNFactory.eINSTANCE.createSupportedBy();
          ((Supportable) parent).getSupportedBy().add(supportedBy);
          supportedBy.setTarget((Supporter) child);
        }
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    convert(inputsByName);
    var out0 = SocratesToGSN.OUT0.fromIn(SocratesToGSN.IN0, this, inputsByName, outputMIDsByName);

    return Map.of(SocratesToGSN.OUT0.name, out0);
  }
}
