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
package ifm24;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class FTS4VMCAnalysis implements IPLGSNAnalysis {

  private String presenceCondition2Dot(String pc) {
    return pc.replace("&", "and").replace("|", "or").replace("~", "not ").replace("$true", "True");
  }

  private String productLine2Dot(ProductLine productLine, String name) {
    var types = StateMachinePackage.eINSTANCE;
    var out = "digraph " + name + "{";
    out += "\n  name=\"" + name + "\"";
    var fm = presenceCondition2Dot(productLine.getFeaturesConstraint());
    out += "\n  FM=\"" + fm + "\"";
    for (var s : productLine.getClasses()) {
      if (s.instanceOf(types.getInitialState())) {
        out += "\n  " + s.getAttribute(types.getAbstractState_Name()).get(0) + "[initial=True]";
        break;
      }
    }
    for (var t : productLine.getClasses()) {
      if (!t.instanceOf(types.getTransition())) {
        continue;
      }
      for (var src : t.getReference(types.getTransition_Source())) {
        var srcName = src.getAttribute(types.getAbstractState_Name()).get(0);
        for (var tgt : t.getReference(types.getTransition_Target())) {
          var tgtName = tgt.getAttribute(types.getAbstractState_Name()).get(0);
          out += "\n  " + srcName + " -> " + tgtName + "[label=\"" + tgtName + " | " +
                 presenceCondition2Dot(t.getPresenceCondition()) + "\"];";
        }
      }
    }
    out += "\n}";

    return out;
  }

  @Override
  public void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var builder = new PLGSNBuilder(productLine);
    var mcStrategy = plTemplate.getElementsById().get("mcStrategy");
    var desc = mcStrategy.getAttribute(gsn.getArgumentElement_Description()).get(0)
      .replace("model checking", "lifted model checking");
    mcStrategy.setAttribute(gsn.getArgumentElement_Description(), desc);
    var liftedGoal = builder.createGoal("G5", "The lifted model checker is correct", null);
    liftedGoal.addAttribute(gsn.getArgumentElement_TemplateId(), "liftedGoal");
    plTemplate.addReference(gsn.getTemplate_Elements(), liftedGoal);
    builder.addSupporter(mcStrategy, liftedGoal);
  }

  @Override
  public void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var templateElems = plTemplate.getElementsById();
    // convert model to .dot file
    var mcStrategy = templateElems.get("mcStrategy");
    var safetyGoal = (PLGSNArgumentElement) mcStrategy
      .getReference(gsn.getSupporter_Supports()).get(0)
      .getReference(gsn.getSupportedBy_Source()).get(0);
    String modelPath;
    var otherTemplates = safetyGoal.getReference(gsn.getArgumentElement_Template());
    var isConnected =
      !otherTemplates.isEmpty() &&
      otherTemplates.get(0).getAttribute(gsn.getTemplate_Id()).get(0).equals("QueryAnalysis");
    if (isConnected) {
      // connected with query analysis template, extract model from it
      var otherFilesCtx = ((PLGSNTemplate) otherTemplates.get(0)).getElementsById().get("filesCtx");
      var paths = otherFilesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
      modelPath = paths.get(1);
    }
    else {
      modelPath = FileUtils.prependWorkspacePath(
        MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                              "There are no Product Line models in the workspace", Set.of("productline")));
    }
    var modelName = FileUtils.getFileNameFromPath(modelPath);
    var modelPL = (ProductLine) FileUtils.readModelFile(modelPath, null, false);
    if (modelPL.getMetamodel() != StateMachinePackage.eINSTANCE) {
      throw new MMINTException("Model type '" + modelPL.getMetamodel().getNsURI() + "' not supported");
    }
    var dot = productLine2Dot(modelPL, modelName);
    var dotPath = FileUtils.replaceFileExtensionInPath(modelPath, "dot");
    var vmcPath = FileUtils.replaceFileExtensionInPath(modelPath, "vmc");
    FileUtils.createTextFile(dotPath, dot, false);
    // run model checker and process results
    var dialogInitial = (isConnected) ?
      safetyGoal.getAttribute(gsn.getArgumentElement_Description()).get(0).split("'")[1] :
      null;
    var property = MIDDialogs.getBigStringInput("Run Product Line analysis", "Insert model property to check",
                                                dialogInitial);
    final var PROPERTY_FILE = "property.txt";
    final var SAT_FILE = "result.out";
    var propertyPath = FileUtils.replaceLastSegmentInPath(modelPath, PROPERTY_FILE);
    Files.writeString(Paths.get(propertyPath), property);
    //TODO change all ids to match connected?
    var filesCtx = templateElems.get("filesCtx");
    var filesDesc = filesCtx.getAttribute(gsn.getArgumentElement_Description()).get(0)
      .replace("{property}", FileUtils.getLastSegmentFromPath(propertyPath))
      .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(gsn.getArgumentElement_Description(), filesDesc);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(),
                              ECollections.asEList(List.of(propertyPath, modelPath)));
    final var RUN_SH = """
      python3 -m venv venv
      source venv/bin/activate
      git clone https://github.com/fts4vmc/FTS4VMC.git &> /dev/null
      pip3 install -r FTS4VMC/requirements.txt &> /dev/null
      python3 FTS4VMC/translate.py\s""" + dotPath + " " +  vmcPath + " &> /dev/null\n" +
      "FTS4VMC/vmc65-linux " + vmcPath + " " + propertyPath;
    final var RUN_SH_FILE = "run.sh";
    var runPath = Paths.get(FileUtils.replaceLastSegmentInPath(modelPath, RUN_SH_FILE));
    Files.writeString(runPath, RUN_SH);
    var result = FileUtils.runShell(runPath.getParent().toString(), "bash", RUN_SH_FILE);
    Files.writeString(Paths.get(FileUtils.replaceLastSegmentInPath(modelPath, SAT_FILE)), result);
    var satGoal = templateElems.get("satGoal");
    var satGoalDesc = satGoal.getAttribute(gsn.getArgumentElement_Description()).get(0);
    var holds = (result.contains("TRUE")) ? "holds" : "does not hold";
    satGoal.setAttribute(gsn.getArgumentElement_Description(), satGoalDesc.replace("{holds?}", holds));
    var satSolution = templateElems.get("satSolution");
    var satSolDesc = satSolution.getAttribute(gsn.getArgumentElement_Description()).get(0)
      .replace("{output}", SAT_FILE);
    satSolution.setAttribute(gsn.getArgumentElement_Description(), satSolDesc);
    if (!safetyGoal.isAlwaysPresent()) {
      var pc = safetyGoal.getPresenceCondition();
      plTemplate.getStreamOfReference(gsn.getTemplate_Elements()).forEach(e -> {
        e.setPresenceCondition(pc);
        e.getStreamOfReference(gsn.getSupportable_SupportedBy()).forEach(sb -> sb.setPresenceCondition(pc));
        e.getStreamOfReference(gsn.getContextualizable_InContextOf()).forEach(ico -> ico.setPresenceCondition(pc));
      });
    }
  }
}
