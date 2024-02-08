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

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class SocratesToGSN extends OperatorImpl {
  private In in;
  private Out out;

  private static class In {
    private final static String MODEL = "json";
    private Model jsonFile;

    public In(Map<String, Model> inputsByName) {
      this.jsonFile = inputsByName.get(In.MODEL);
      if (!this.jsonFile.getFileExtension().equals("json")) {
        throw new IllegalArgumentException("Not a json file");
      }
    }
  }

  private static class Out {
    private final static String GSN_MODELTYPE = "";
    private final static String MODEL = "gsn";
    private MID instanceMID;
    private SafetyCase safetyCase;
    private String gsnPath;

    public Out(In in, Map<String, MID> outputMIDsByName) {
      this.instanceMID = outputMIDsByName.get(Out.MODEL);
      this.safetyCase = GSNFactory.eINSTANCE.createSafetyCase();
      this.gsnPath = FileUtils.replaceFileExtensionInPath(in.jsonFile.getUri(), GSNPackage.eNAME);
    }

    public Map<String, Model> packed() throws Exception {
      var gsnModel = MIDTypeRegistry.<Model>getType(Out.GSN_MODELTYPE)
        .createInstanceAndEditor(this.safetyCase, this.gsnPath, this.instanceMID);
      return Map.of(Out.MODEL, gsnModel);
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new In(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new Out(this.in, outputMIDsByName);
  }

  private void convert() throws Exception {
    var json = Files.readString(Paths.get(FileUtils.prependWorkspacePath(this.in.jsonFile.getUri())));
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
          this.out.safetyCase.getGoals().add(goal);
          yield goal;
        }
        case "STRATEGY" -> {
          var strategy = GSNFactory.eINSTANCE.createStrategy();
          strategy.setId("S" + id);
          this.out.safetyCase.getStrategies().add(strategy);
          yield strategy;
        }
        case "SOLUTION" -> {
          var solution = GSNFactory.eINSTANCE.createSolution();
          solution.setId("Sn" + id);
          this.out.safetyCase.getSolutions().add(solution);
          yield solution;
        }
        case "CONTEXT" -> {
          var context = GSNFactory.eINSTANCE.createContext();
          context.setId("C" + id);
          this.out.safetyCase.getContexts().add(context);
          yield context;
        }
        case "JUSTIFICATION" -> {
          var justification = GSNFactory.eINSTANCE.createJustification();
          justification.setId("J" + id);
          this.out.safetyCase.getJustifications().add(justification);
          yield justification;
        }
        case "ASSUMPTION" -> {
          var assumption = GSNFactory.eINSTANCE.createAssumption();
          assumption.setId("A" + id);
          this.out.safetyCase.getAssumptions().add(assumption);
          yield assumption;
        }
        case String type -> throw new MMINTException("Unsupported node " + type);
      };
      gsnElem.setDescription(nodeObj.get("text").getAsString());
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
    init(inputsByName, outputMIDsByName);
    convert();

    return this.out.packed();
  }
}
