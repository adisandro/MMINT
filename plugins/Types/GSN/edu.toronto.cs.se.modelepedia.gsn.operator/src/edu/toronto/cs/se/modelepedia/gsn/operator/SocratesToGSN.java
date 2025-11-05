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
import edu.toronto.cs.se.modelepedia.gsn.DecoratorType;
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

  public final static String NODES = "nodes";
  public final static String NODE_ID = "lid";
  public final static String NODE_TYPE = "nodeType";
  public final static String NODE_TEXT = "text";
  public final static String NODE_DESC = "description";
  public final static String NODE_ROOT = "isRoot";
  public final static String NODE_CHILDREN = "children";

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.out0 = GSNFactory.eINSTANCE.createSafetyCase();
  }

  private void convert(Map<String, Model> inputsByName) throws Exception {
    final var DECORATOR_LABEL = "{N-ARY_SUBTREE} ";
    var json = Files.readString(Paths.get(
      FileUtils.prependWorkspacePath(inputsByName.get(SocratesToGSN.IN0.name()).getUri())));
    var jsonObj = JsonParser.parseString(json).getAsJsonObject();
    var idToElem = new HashMap<Integer, ArgumentElement>();
    var idToChildren = new HashMap<Integer, JsonArray>();
    var isTemplate = false;
    for (var node : jsonObj.get(SocratesToGSN.NODES).getAsJsonArray()) {
      var nodeObj = node.getAsJsonObject();
      var id = nodeObj.get(SocratesToGSN.NODE_ID).getAsInt();
      var gsnElem = switch(nodeObj.get(SocratesToGSN.NODE_TYPE).getAsString()) {
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
      var desc = nodeObj.get(SocratesToGSN.NODE_TEXT).getAsString();
      var extraDesc = nodeObj.get(SocratesToGSN.NODE_DESC);
      if (!extraDesc.isJsonNull()) {
        desc += "\n(" + extraDesc.getAsString() + ")";
      }
      if (desc.contains("<")) {
        gsnElem.setValid(false);
        isTemplate = true;
        desc = desc.replace("<", "{").replace(">", "}");
      }
      gsnElem.setDescription(desc);
      idToElem.put(id, gsnElem);
      idToChildren.put(id, nodeObj.get(SocratesToGSN.NODE_CHILDREN).getAsJsonArray());
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
          supportedBy.setTarget((Supporter) child);
          var supportable = (Supportable) parent;
          if (child.getDescription().startsWith(DECORATOR_LABEL)) {
            child.setDescription(child.getDescription().replace(DECORATOR_LABEL, ""));
            var decorator = GSNFactory.eINSTANCE.createRelationshipDecorator();
            decorator.setId(child.getId() + "N");
            decorator.setDescription(DECORATOR_LABEL);
            decorator.setType(DecoratorType.MULTIPLE);
            decorator.setCardinality(-1);
            decorator.setValid(false);
            idToElem.put(-childId.getAsInt(), decorator);
            ((Supportable) parent).getDecorators().add(decorator);
            supportable = decorator;
          }
          supportable.getSupportedBy().add(supportedBy);
        }
      }
    }
    if (isTemplate) {
      var template = GSNTemplatesFactory.eINSTANCE.createAnalyticTemplate();
      this.out0.getTemplates().add(template);
      var templateElems = template.getElements();
      for (var templateElem : idToElem.values()) {
        templateElem.setTemplateId(templateElem.getId());
        templateElems.add(templateElem);
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    convert(inputsByName);

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}
