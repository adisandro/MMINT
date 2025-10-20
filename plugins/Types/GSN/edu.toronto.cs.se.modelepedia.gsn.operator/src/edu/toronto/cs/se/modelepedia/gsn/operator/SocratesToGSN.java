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
import java.util.Properties;

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
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesFactory;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class SocratesToGSN extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("json", FilePackage.eNS_URI);
  public final static OperatorParameter OUT0 = new OperatorParameter("gsn", GSNPackage.eNS_URI, GSNPackage.eNAME, null);
  public SafetyCase out0;
  public final static IJavaOperatorConstraint CONSTRAINT = new IJavaOperatorConstraint() {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      if (!inputsByName.get(SocratesToGSN.IN0.name()).getFileExtension().equals("json")) {
        return false;
      }
      return true;
    }
  };

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.out0 = GSNFactory.eINSTANCE.createSafetyCase();
  }

  private void convert(Map<String, Model> inputsByName) throws Exception {
    var json = Files.readString(Paths.get(
      FileUtils.prependWorkspacePath(inputsByName.get(SocratesToGSN.IN0.name()).getUri())));
    var jsonObj = JsonParser.parseString(json).getAsJsonObject();
    var idToElem = new HashMap<Integer, ArgumentElement>();
    var idToChildren = new HashMap<Integer, JsonArray>();
    var isTemplate = false;
    for (var node : jsonObj.get("nodes").getAsJsonArray()) {
      var nodeObj = node.getAsJsonObject();
      var id = nodeObj.get("lid").getAsInt();
      var gsnElem = switch(nodeObj.get("nodeType").getAsString()) {
        case "GOAL" -> {
          var goal = GSNFactory.eINSTANCE.createGoal();
          goal.setId("G" + id);
          this.out0.getGoals().add(goal);
          yield goal;
        }
        case "STRATEGY" -> {
          var strategy = GSNFactory.eINSTANCE.createStrategy();
          strategy.setId("S" + id);
          this.out0.getStrategies().add(strategy);
          yield strategy;
        }
        case "SOLUTION" -> {
          var solution = GSNFactory.eINSTANCE.createSolution();
          solution.setId("Sn" + id);
          this.out0.getSolutions().add(solution);
          yield solution;
        }
        case "CONTEXT" -> {
          var context = GSNFactory.eINSTANCE.createContext();
          context.setId("C" + id);
          this.out0.getContexts().add(context);
          yield context;
        }
        case "JUSTIFICATION" -> {
          var justification = GSNFactory.eINSTANCE.createJustification();
          justification.setId("J" + id);
          this.out0.getJustifications().add(justification);
          yield justification;
        }
        case "ASSUMPTION" -> {
          var assumption = GSNFactory.eINSTANCE.createAssumption();
          assumption.setId("A" + id);
          this.out0.getAssumptions().add(assumption);
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
      if (desc.contains("{")) {
        gsnElem.setValid(false);
        isTemplate = true;
      }
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
    if (isTemplate) {
      var template = GSNTemplatesFactory.eINSTANCE.createAnalyticTemplate();
      template.getElements().addAll(idToElem.values());
      this.out0.getTemplates().add(template);
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    convert(inputsByName);

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}
