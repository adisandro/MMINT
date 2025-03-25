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
package fac25;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

/**
 * This template is producing evidence based on checking a property over the underlying model with the FTS4VMC model
 * checker. It is a leaf template, with no downstream supporters.
 */
public class FTS4VMCAnalysis implements IPLGSNAnalysis {
  protected final static String PROPERTY_FILE = "property.txt";
  protected final static String RUN_FILE = "run.sh";
  protected final static String SAT_FILE = "result.out";
  protected GSNPackage gsn;

  public FTS4VMCAnalysis() {
    this.gsn = GSNPackage.eINSTANCE;
  }

  private String presenceCondition2Dot(String pc) {
    return pc.replace("&", "and").replace("|", "or").replace("~", "not ").replace("$true", "True");
  }

  protected String productLine2Dot(ProductLine productLine, String name) {
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

  protected String runFTS4VMC(String modelPath, String propertyPath) throws Exception {
    var modelPL = (ProductLine) FileUtils.readModelFile(modelPath, null, false);
    if (modelPL.getMetamodel() != StateMachinePackage.eINSTANCE) {
      throw new MMINTException("Model type '" + modelPL.getMetamodel().getNsURI() + "' not supported");
    }
    var modelName = FileUtils.getFileNameFromPath(modelPath);
    var dot = productLine2Dot(modelPL, modelName);
    var dotPath = FileUtils.replaceFileExtensionInPath(modelPath, "dot");
    var vmcPath = FileUtils.replaceFileExtensionInPath(modelPath, "vmc");
    FileUtils.createTextFile(dotPath, dot, false);
    final var RUN_SH = """
      python3 -m venv venv
      source venv/bin/activate
      git clone https://github.com/fts4vmc/FTS4VMC.git &> /dev/null
      pip3 install -r FTS4VMC/requirements.txt &> /dev/null
      pip3 install --upgrade z3-solver &> /dev/null
      python3 FTS4VMC/translate.py\s""" + dotPath + " " +  vmcPath + " &> /dev/null\n" +
      "FTS4VMC/vmc65-linux " + vmcPath + " " + propertyPath;
    var runPath = Paths.get(FileUtils.replaceLastSegmentInPath(modelPath, FTS4VMCAnalysis.RUN_FILE));
    Files.writeString(runPath, RUN_SH);
    var result = FileUtils.runShell(runPath.getParent().toString(), "bash", FTS4VMCAnalysis.RUN_FILE);

    return result;
  }

  @Override
  public void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var builder = new PLGSNBuilder(productLine);
    var mcStrategy = plTemplate.getElementsById().get("mcStrategy");
    var desc = mcStrategy.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
      .replace("model checking", "lifted model checking");
    mcStrategy.setAttribute(this.gsn.getArgumentElement_Description(), desc);
    var liftedGoal = builder.createGoal("G4", "The lifted model checker is correct", null);
    liftedGoal.addAttribute(this.gsn.getArgumentElement_TemplateId(), "liftedGoal");
    plTemplate.addReference(this.gsn.getTemplate_Elements(), liftedGoal);
    builder.addSupporter(mcStrategy, liftedGoal);
  }

  private PLGSNArgumentElement getSafetyGoal(Map<String, PLGSNArgumentElement> templateElems) {
    var safetyGoal = templateElems.get("safetyGoal");
    if (safetyGoal == null) {
      // using the forward trace to get safetyGoal does not work with linked templates, so navigate the gsn tree
      safetyGoal = (PLGSNArgumentElement) templateElems.get("mcStrategy")
        .getReference(this.gsn.getSupporter_Supports()).get(0)
        .getReference(this.gsn.getSupportedBy_Source()).get(0);
    }

    return safetyGoal;
  }

  @Override
  public void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var templateElems = plTemplate.getElementsById();
    // select PL model and property
    String modelPath = null;
    String dialogInitial = null;
    var safetyGoal = getSafetyGoal(templateElems);
    if (!templateElems.containsKey("safetyGoal")) {
      var otherTemplate = safetyGoal.getReference(this.gsn.getArgumentElement_Template());
      if (!otherTemplate.isEmpty()) {
        var otherFilesCtx = ((PLGSNTemplate) otherTemplate.get(0)).getElementsById().get("filesCtx");
        if (otherFilesCtx != null) {
          // connected with model-based template, extract model from it
          var paths = otherFilesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
          modelPath = paths.get(1);
          dialogInitial = safetyGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
        }
      }
    }
    if (modelPath == null) {
      modelPath = FileUtils.prependWorkspacePath(
        MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                              "There are no Product Line models in the workspace", Set.of("productline")));
    }
    var property = MIDDialogs.getBigStringInput("Run Product Line analysis", "Insert model property to check",
                                                dialogInitial);
    var propertyPath = FileUtils.getUniquePath(
      FileUtils.replaceLastSegmentInPath(modelPath, FTS4VMCAnalysis.PROPERTY_FILE), false, false);
    Files.writeString(Paths.get(propertyPath), property);
    // run model checker and process results
    var result = runFTS4VMC(modelPath, propertyPath);
    var resultPath = FileUtils.getUniquePath(
      FileUtils.replaceLastSegmentInPath(modelPath, FTS4VMCAnalysis.SAT_FILE), false, false);
    Files.writeString(Paths.get(resultPath), result);
    var filesCtx = templateElems.get("filesCtx");
    var filesDesc = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
      .replace("{property}", FileUtils.getLastSegmentFromPath(propertyPath))
      .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(this.gsn.getArgumentElement_Description(), filesDesc);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(),
                              ECollections.asEList(List.of(propertyPath, modelPath, resultPath)));
    var satGoal = templateElems.get("satGoal");
    var satGoalDesc = satGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0);
    var holds = (result.contains("TRUE")) ? "holds" : "does not hold";
    satGoal.setAttribute(this.gsn.getArgumentElement_Description(), satGoalDesc.replace("{holds?}", holds));
    var satSolution = templateElems.get("satSolution");
    var satSolDesc = satSolution.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
      .replace("{output}", FileUtils.getLastSegmentFromPath(resultPath));
    satSolution.setAttribute(this.gsn.getArgumentElement_Description(), satSolDesc);
    if (!safetyGoal.isAlwaysPresent()) {
      var pc = safetyGoal.getPresenceCondition();
      plTemplate.getStreamOfReference(this.gsn.getTemplate_Elements()).forEach(e -> {
        e.setPresenceCondition(pc);
        e.getStreamOfReference(this.gsn.getSupportable_SupportedBy()).forEach(sb -> sb.setPresenceCondition(pc));
        e.getStreamOfReference(this.gsn.getContextualizable_InContextOf()).forEach(ico -> ico.setPresenceCondition(pc));
      });
    }
  }

  @Override
  public List<PLGSNChangeStep> nextImpactSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    // leaf template
    return List.of();
  }

  @Override
  public void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = getSafetyGoal(templateElems);
    var prevImpact = safetyGoal.getImpact();
    var satGoal = templateElems.get("satGoal");
    var satSolution = templateElems.get("satSolution");
    Map<ImpactType, Optional<String>> impactType;
    if (prevImpact.get(ImpactType.REVISE).isPresent()) {
      // parents should be revised top down, do not re-run model checking but mark to revise
      impactType = PLGSNChangeStep.REVISE;
    }
    else if ((boolean) ChangeStep.getData().get(ChangeStep.EAGER_EVIDENCE_IMPACT_KEY)) {
      // re-run model checking
      var filesCtx = templateElems.get("filesCtx");
      var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
      var propertyPath = paths.get(0);
      var modelPath = paths.get(1);
      var resultPath = paths.get(2);
      var result = runFTS4VMC(modelPath, propertyPath);
      var propsKey = getClass().getName() + "_" + modelPath + "_" + propertyPath + "_" + resultPath;
      ChangeStep.getData().put(propsKey, result);
      var holds = result.contains("TRUE");
      var oldHolds = satGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).contains("holds");
      impactType = (holds == oldHolds) ? PLGSNChangeStep.REUSE : PLGSNChangeStep.REVISE;
    }
    else {
      var templateStep = new PLGSNChangeStep(satSolution);
      templateStep.getBackwardTrace().add(List.of());
      templateStep.baselineImpact();
      impactType = satSolution.getImpact();
    }
    satGoal.setImpact(impactType);
    satSolution.setImpact(impactType);
    safetyGoal.setImpact(impactType);
    // reuse everything else in the template
    PLGSNChangeStep.setAllImpacts(plTemplate, PLGSNChangeStep.REUSE);
  }

  @Override
  public List<PLGSNChangeStep> nextRepairSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    // leaf template
    return List.of();
  }

  @Override
  public void repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var satGoal = templateElems.get("satGoal");
    var satSolution = templateElems.get("satSolution");
    var satImpact = satGoal.getImpact();
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var propertyPath = paths.get(0);
    var modelPath = paths.get(1);
    var oldResultPath = paths.get(2);
    String result;
    var propsKey = getClass().getName() + "_" + modelPath + "_" + propertyPath + "_" + oldResultPath;
    if (!(boolean) ChangeStep.getData().get(ChangeStep.EAGER_EVIDENCE_IMPACT_KEY) &&
        (satImpact.get(ImpactType.REVISE).isPresent() || satImpact.get(ImpactType.RECHECK).isPresent())) {
      // re-run model checking
      result = runFTS4VMC(modelPath, propertyPath);
      ChangeStep.getData().put(propsKey, result);
      var holds = result.contains("TRUE");
      var oldHolds = satGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).contains("holds");
      var impactType = (holds == oldHolds) ? PLGSNChangeStep.REUSE : PLGSNChangeStep.REVISE;
      var safetyGoal = getSafetyGoal(templateElems);
      satGoal.setImpact(impactType);
      satSolution.setImpact(impactType);
      safetyGoal.setImpact(impactType);
    }
    // store new result (either from impact re-run, or repair re-run)
    result = (String) ChangeStep.getData().get(propsKey);
    var resultPath = FileUtils.getUniquePath(
      FileUtils.replaceLastSegmentInPath(modelPath, FTS4VMCAnalysis.SAT_FILE), false, false);
    Files.writeString(Paths.get(resultPath), result);
    paths.set(2, resultPath);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(), paths);
    var oldSatDesc = satSolution.getAttribute(this.gsn.getArgumentElement_Description()).get(0);
    var satDesc = oldSatDesc.replace(FileUtils.getLastSegmentFromPath(oldResultPath),
                                     FileUtils.getLastSegmentFromPath(resultPath));
    satSolution.setAttribute(this.gsn.getArgumentElement_Description(), satDesc);
  }
}
