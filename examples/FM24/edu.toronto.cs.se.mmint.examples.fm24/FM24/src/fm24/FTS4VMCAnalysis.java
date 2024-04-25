/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package fm24;

import java.nio.file.Files;
import java.nio.file.Paths;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.GSNPLBuilder;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class FTS4VMCAnalysis implements IGSNPLAnalysis {

  private String convertPC(String pc) {
    return pc.replace("&", "and").replace("|", "or").replace("~", "not ").replace("$true", "True");
  }

  private String convertPL(ProductLine productLine, String name) {
    var types = StateMachinePackage.eINSTANCE;
    var out = "digraph " + name + "{";
    out += "\n  name=\"" + name + "\"";
    var fm = convertPC(productLine.getFeaturesConstraint());
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
                 convertPC(t.getPresenceCondition()) + "\"];";
        }
      }
    }
    out += "\n}";

    return out;
  }

  @Override
  public void instantiate(GSNPLAnalyticTemplate plTemplate) throws Exception {
    var types = GSNPackage.eINSTANCE;
    var productLine = (ProductLine) plTemplate.eContainer();
    var builder = new GSNPLBuilder(productLine);
    // convert model to .dot file
    var mcStrategy = (GSNPLArgumentElement) plTemplate.getStreamOfReference(types.getTemplate_Elements())
      .filter(c -> c.getType() == types.getStrategy())
      .findFirst().get();
    //TODO check if connected with previous template: if yes, get model path, else ask for it
    var modelPath = "/FM24/model/R1.productline";
    modelPath = FileUtils.prependWorkspacePath(modelPath);
    var modelName = FileUtils.getFileNameFromPath(modelPath);
    var modelPL = (ProductLine) FileUtils.readModelFile(modelPath, null, false);
    if (modelPL.getMetamodel() != StateMachinePackage.eINSTANCE) {
      throw new MMINTException("Model type '" + modelPL.getMetamodel().getNsURI() + "' not supported");
    }
    var out = convertPL(modelPL, modelName);
    var outPath = FileUtils.replaceFileExtensionInPath(modelPath, "dot");
    var outPath2 = FileUtils.replaceFileExtensionInPath(modelPath, "txt");
    FileUtils.createTextFile(outPath, out, false);
    // run model checker and process results
    //TODO check if connected with previous template: if yes, construct property, else ask for it (text, not file)
    var property = "AG(Alrm_DoseRateHardLimitsViolationS => A[not(Infusion_NormalOperationS) U (E_ClearAlarmS)])";
    final var PROPERTY_FILE = "property.txt";
    var propertyPath = FileUtils.replaceLastSegmentInPath(modelPath, PROPERTY_FILE);
    Files.writeString(Paths.get(propertyPath), property);
    var filesCtx = mcStrategy
      .getReference(types.getContextualizable_InContextOf()).get(0)
      .getReference(types.getInContextOf_Context()).get(0);
    var filesDesc = filesCtx.getAttribute(types.getArgumentElement_Description()).get(0)
      .replace("{property}", FileUtils.getLastSegmentFromPath(propertyPath))
      .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(types.getArgumentElement_Description(), filesDesc);
    filesCtx.addAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(), propertyPath);
    filesCtx.addAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(), modelPath);
    final var RUN_SH = """
      python3 -m venv venv
      source venv/bin/activate
      git clone https://github.com/fts4vmc/FTS4VMC.git
      pip3 install -r FTS4VMC/requirements.txt
      python3 translate.py""" + outPath + " " +  outPath2 + "\n" +
      "FTS4VMC/vmc65-linux " + outPath2 + " " + propertyPath;
    final var RUN_SH_FILE = "run.sh";
    var runPath = Paths.get(FileUtils.replaceLastSegmentInPath(modelPath, RUN_SH_FILE));
    Files.writeString(runPath, RUN_SH);
    var result = FileUtils.runShell(runPath.getParent().toString(), "bash", RUN_SH_FILE);
    var satGoal = mcStrategy
      .getReference(types.getSupportable_SupportedBy()).get(2)
      .getReference(types.getSupportedBy_Target()).get(0);
    var satDesc = satGoal.getAttribute(types.getArgumentElement_Description()).get(0);
    var holds = (result.contains("TRUE")) ? "holds" : "does not hold";
    satGoal.setAttribute(types.getArgumentElement_Description(), satDesc.replace("{holds?}", holds));
    var liftingGoal = builder.createGoal("G4", "The lifted model checker is correct", null);
    plTemplate.addReference(types.getTemplate_Elements(), liftingGoal);
    builder.addSupporter(mcStrategy, liftingGoal);
  }
}
