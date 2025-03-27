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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery.ResultPrinter;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

/**
 * This template is a decomposition strategy based on identifying certain patterns in the underlying model with a VQL
 * query. It does not generate any evidence, but is supported by downstream goals corresponding to each of the
 * identified patterns.
 */
public class VQLQueryAnalysis implements IPLGSNAnalysis {
  protected GSNPackage gsn;

  public VQLQueryAnalysis() {
    this.gsn = GSNPackage.eINSTANCE;
  }

  public static ResultPrinter PL_NAME_PRINTER = (result) -> {
    if (result instanceof Class plClass) {
      // try finding a name
      var name = plClass.getAttributes().stream()
        .filter(a -> a.getType().getName().equals("name"))
        .map(a -> a.getValue())
        .collect(Collectors.joining(", "));
      if (!name.isEmpty()) {
        return name;
      }
    }
    return SiriusEvaluateQuery.NAME_PRINTER.prettyPrint(result);
  };

  protected List<String> getResults(List<Object> queryResults) {
    return queryResults.stream()
      .map(r -> SiriusEvaluateQuery.queryResultToString(r, SiriusEvaluateQuery.NAME_PRINTER, null, null))
      .filter(r -> r.startsWith("Alrm_"))
      .sorted() // for reproducibility
      .collect(Collectors.toList());
  }

  @Override
  public void instantiate(AnalyticTemplate template) throws Exception {
    var safetyCase = (SafetyCase) template.eContainer();
    var builder = new GSNTemplatesBuilder(safetyCase);
    // get template elems
    var templateElems = template.getElementsById();
    var safetyGoal = (Goal) templateElems.get("safetyGoal");
    var filesCtx = (FilesContext) templateElems.get("filesCtx");
    var scenarioGoal = (Goal) templateElems.get("scenarioGoal");
    var resultStrategy = (Strategy) templateElems.get("resultStrategy");
    var resultCtx = (Context) templateElems.get("resultCtx");
    var resultGoal = (Goal) templateElems.get("resultGoal");
    safetyGoal.instantiate();
    var safetyDesc = safetyGoal.getDescription();
    var resultId = resultGoal.getId();
    var resultDesc = resultGoal.getDescription().replace("{safety goal}", safetyDesc);
    scenarioGoal.setDescription(scenarioGoal.getDescription().replace("{safety goal}", safetyDesc));
    // run query and process results
    var modelPath = FileUtils.prependWorkspacePath(MIDDialogs.selectModelToImport(false));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    template.getElements().remove(resultGoal);
    safetyCase.getGoals().remove(resultGoal);
    resultStrategy.getSupportedBy().remove(0);
    filesCtx.setDescription(
      filesCtx.getDescription()
              .replace("{query}", querySpec.query().toString())
              .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath)));
    filesCtx.getPaths().add(querySpec.filePath());
    filesCtx.getPaths().add(modelPath);
    var results = getResults(queryResults);
    var resultCtxDesc = (results.isEmpty()) ? "No results" : "Query results:";
    var i = 0;
    for (var result : results) {
      resultCtxDesc += "\n'" + result + "'";
      resultGoal = builder.createGoal(resultId.replace("X", String.valueOf(i)),
                                      resultDesc.replace("{X}", "'" + result + "'"));
      resultGoal.setTemplateId("resultGoal" + i);
      template.getElements().add(resultGoal);
      builder.addSupporter(resultStrategy, resultGoal);
      i++;
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  @Override
  public void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var plBuilder = new PLGSNBuilder(productLine);
    var queryStrategy = plTemplate.getElementsById().get("queryStrategy");
    var desc = queryStrategy.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
      .replace("model query", "lifted model query");
    queryStrategy.setAttribute(this.gsn.getArgumentElement_Description(), desc);
    var liftedGoal = plBuilder.createGoal("G4", "The lifted query engine is correct", null);
    liftedGoal.addAttribute(this.gsn.getArgumentElement_TemplateId(), "liftedGoal");
    plTemplate.addReference(this.gsn.getTemplate_Elements(), liftedGoal);
    plBuilder.addSupporter(queryStrategy, liftedGoal);
  }

  protected List<Map.Entry<String, String>> getPLResults(List<Object> queryResults) {
    return queryResults.stream()
      .map(r -> Map.entry(
        SiriusEvaluateQuery.queryResultToString(r, VQLQueryAnalysis.PL_NAME_PRINTER, null, null),
        (r instanceof PLElement plResult) ? plResult.getPresenceCondition() : null))
      .filter(r -> r.getKey().startsWith("Alrm_"))
      .sorted(Map.Entry.comparingByKey()) // for reproducibility
      .collect(Collectors.toList());
  }

  protected PLGSNArgumentElement createPLResultGoal(PLGSNAnalyticTemplate plTemplate, PLGSNBuilder plBuilder,
                                                    PLGSNArgumentElement resultStrategy, String resultId,
                                                    String resultDesc, String resultPC, String templateId) {
    var resultGoal = plBuilder.createGoal(resultId, resultDesc, resultPC);
    resultGoal.addAttribute(this.gsn.getArgumentElement_TemplateId(), templateId);
    plTemplate.addReference(this.gsn.getTemplate_Elements(), resultGoal);
    plBuilder.addSupporter(resultStrategy, resultGoal);

    return resultGoal;
  }

  @Override
  public void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var productLine = (ProductLine) plTemplate.eContainer();
    var plBuilder = new PLGSNBuilder(productLine);
    // get template elems
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    var filesCtx = templateElems.get("filesCtx");
    var scenarioGoal = templateElems.get("scenarioGoal");
    var resultStrategy = templateElems.get("resultStrategy");
    var resultCtx = templateElems.get("resultCtx");
    var resultGoal = templateElems.get("resultGoal");
    safetyGoal.instantiate();
    var safetyDesc = safetyGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0);
    var resultId = resultGoal.getAttribute(this.gsn.getArgumentElement_Id()).get(0);
    var resultDesc = resultGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
      .replace("{safety goal}", safetyDesc);
    var scenarioDesc = scenarioGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
                                   .replace("{safety goal}", safetyDesc);
    scenarioGoal.setAttribute(this.gsn.getArgumentElement_Description(), scenarioDesc);
    // run query and process results
    var modelPath = FileUtils.prependWorkspacePath(
      MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                            "There are no Product Line models in the workspace", Set.of("productline")));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    resultGoal.delete();
    for (var supportedBy : resultGoal.getReference(this.gsn.getSupporter_Supports())) {
      supportedBy.delete();
    }
    var filesDesc = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0)
                            .replace("{query}", querySpec.query().toString())
                            .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(this.gsn.getArgumentElement_Description(), filesDesc);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(),
                              ECollections.asEList(List.of(querySpec.filePath(), modelPath)));
    var results = getPLResults(queryResults);
    var resultCtxDesc = (results.isEmpty()) ? "No results" : "Query results:";
    var i = 0;
    for (var result : results) {
      resultCtxDesc += "\n'" + result.getKey() + "'";
      createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId.replace("X", String.valueOf(i)),
                         resultDesc.replace("{X}", "'" + result.getKey() + "'"), result.getValue(), "resultGoal" + i);
      i++;
    }
    resultCtx.setAttribute(this.gsn.getArgumentElement_Description(), resultCtxDesc);
  }

  @Override
  public List<PLGSNChangeStep> nextImpactSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    var plReasoner = ((ProductLine) plTemplate.eContainer()).getReasoner();
    var templateElems = plTemplate.getElementsById();
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    // re-run query on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var plVQLReasoner = (IQueryTrait) MMINT.getReasoner("Viatra for Product Lines");
    var querySpec = new QuerySpec(plVQLReasoner, queryFilePath, query);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    // compare results
    var results = getPLResults(queryResults);
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getData().put(propsKey, results);
    var resultCtx = templateElems.get("resultCtx");
    var oldResults = resultCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).lines()
      .filter(l -> l.startsWith("'"))
      .map(l -> l.substring(1, l.length()-1))
      .collect(Collectors.toList());
    var o = 0; // old results counter
    var n = 0; // new results counter
    var revise = false;
    var newPCs = new HashSet<String>();
    while (n < results.size()) {
      var result = results.get(n);
      var pc = result.getValue();
      // new result
      if (o >= oldResults.size()) {
        revise = true;
        newPCs.add(pc);
        break;
      }
      var oldResult = oldResults.get(o);
      // same result, continue impact downstream
      if (oldResult.equals(result.getKey())) {
        var resultGoal = templateElems.get("resultGoal" + o);
        var oldPC = resultGoal.getPresenceCondition();
        // same presence condition, notify downstream with full reuse
        if (oldPC.equals(pc)) {
          resultGoal.setImpact(ImpactType.REUSE);
        }
        // presence condition changed, notify downstrean
        else {
          var phiPrime = (String) ChangeStep.getData().get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
          var reusePC = plReasoner.and(oldPC, pc); // we assume this is SAT
          var newPC = plReasoner.and(plReasoner.not(oldPC), pc);
          var newSAT = plReasoner.checkConsistency(phiPrime, Set.of(newPC));
          var reuseOpt = Optional.of(plReasoner.simplify(reusePC));
          var reviseOpt = newSAT ? Optional.of(plReasoner.simplify(newPC)) : Optional.<String>empty();
          var impactTypes = Map.of(ImpactType.REUSE,   reuseOpt,
                                   ImpactType.RECHECK, Optional.<String>empty(),
                                   ImpactType.REVISE,  reviseOpt);
          resultGoal.setImpact(impactTypes);
          if (newSAT) {
            revise = true;
            newPCs.add(newPC);
          }
        }
        var templateTrace = new LinkedHashSet<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.add(step.getImpacted());
        templateTrace.addAll(step.getForwardTrace());
        var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
        nextSteps.addAll(templateStep.nextSupporters());
        o++;
        n++;
      }
      // obsolete result, notify downstream with full revise
      else if (oldResults.contains(result.getKey())) {
        revise = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          resultGoal.setImpact(ImpactType.REVISE);
          var templateTrace = new LinkedHashSet<EObject>();
          templateTrace.add(plTemplate);
          templateTrace.add(step.getImpacted());
          templateTrace.addAll(step.getForwardTrace());
          var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
          nextSteps.addAll(templateStep.nextSupporters());
          o++;
          oldResult = oldResults.get(o);
        }
      }
      // new result
      else {
        revise = true;
        newPCs.add(pc);
        n++;
      }
    }
    if (!newPCs.isEmpty()) { // revise result strategy and context
      var newPC = plReasoner.or(newPCs.toArray(String[]::new));
      var impactTypes = PLGSNChangeStep.addPhiNew(
        Map.of(ImpactType.REUSE,   Optional.of(plReasoner.simplify(plReasoner.not(newPC))),
               ImpactType.RECHECK, Optional.empty(),
               ImpactType.REVISE,  Optional.of(plReasoner.simplify(newPC))));
      templateElems.get("resultStrategy").setImpact(impactTypes);
      templateElems.get("resultCtx").setImpact(impactTypes);
    }
    propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getData().put(propsKey, revise);

    return nextSteps;
  }

  @Override
  public void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    // combine new query results with downstream bottom up propagation
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    var revise = (Boolean) ChangeStep.getData().get(propsKey);
    propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var results = (List<Map.Entry<String, String>>) ChangeStep.getData().get(propsKey);
    // bottom up impact
    var impacts = new ArrayList<Map<ImpactType, Optional<String>>>();
    for (var i = 0; ; i++) {
      var resultGoal = templateElems.get("resultGoal" + i);
      if (resultGoal == null) {
        break;
      }
      //TODO to cover manual downstream nodes, we should always assign impact from downstream first
      var resultImpact = resultGoal.getImpact();
      var result = resultGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
      if (resultImpact.get(ImpactType.REVISE).isPresent() && resultImpact.get(ImpactType.REUSE).isEmpty() &&
          resultImpact.get(ImpactType.RECHECK).isEmpty() &&
          results.stream().noneMatch(r -> result.equals(r.getKey()))) {
        // do not participate if obsolete result
        continue;
      }
      impacts.add(resultImpact);
    }
    if (revise) { // include revised result strategy
      impacts.add(templateElems.get("resultStrategy").getImpact());
    }
    var impactTypes = PLGSNChangeStep.min(impacts);
    templateElems.get("scenarioGoal").setImpact(impactTypes);
    templateElems.get("safetyGoal").setImpact(impactTypes);
    // reuse everything else in the template
    PLGSNChangeStep.setAllRemainingImpacts(plTemplate, ImpactType.REUSE);
  }

  @Override
  public List<PLGSNChangeStep> nextRepairSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    var productLine = (ProductLine) plTemplate.eContainer();
    var plBuilder = new PLGSNBuilder(productLine);
    var templateElems = plTemplate.getElementsById();
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    // fetch query results on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var results = (List<Map.Entry<String, String>>) ChangeStep.getData().get(propsKey);
    var resultCtxDesc = (results.isEmpty()) ? "No results" : "Query results:";
    // compare results
    var safetyGoal = templateElems.get("safetyGoal");
    var safetyDesc = safetyGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0);
    var resultCtx = templateElems.get("resultCtx");
    var resultStrategy = templateElems.get("resultStrategy");
    var resultId = templateElems.get("resultGoal0").getAttribute(this.gsn.getArgumentElement_Id()).get(0)
                                .split("\\.")[0] + ".";
    var oldResults = resultCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).lines()
      .filter(l -> l.startsWith("'"))
      .map(l -> l.substring(1, l.length()-1))
      .collect(Collectors.toList());
    var o = 0; // old results counter
    var n = 0; // new results counter
    var x = 0; // extra results counter
    var revised = false;
    while (n < results.size()) {
      var result = results.get(n);
      var pc = result.getValue();
      // new result, add downstream branch
      if (o >= oldResults.size()) {
        revised = true;
        var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + (n+x),
                                            "Query result '" + result.getKey() + "', " + safetyDesc, result.getValue(),
                                            "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.getKey() + "'";
        resultGoal.setImpact(ImpactType.REVISE);
        n++;
        continue;
      }
      var oldResult = oldResults.get(o);
      // same result, continue repair downstream
      if (oldResult.equals(result.getKey())) {
        var resultGoal = templateElems.get("resultGoal" + o);
        var oldPC = resultGoal.getPresenceCondition();
        resultGoal.setAttribute(this.gsn.getArgumentElement_Id(), resultId + (n+x));
        resultGoal.setAttribute(this.gsn.getArgumentElement_TemplateId(), "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.getKey() + "'";
        var templateTrace = new LinkedHashSet<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.add(step.getImpacted());
        templateTrace.addAll(step.getForwardTrace());
        var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
        nextSteps.addAll(templateStep.nextSupporters());
        o++;
        n++;
        if (!oldPC.equals(pc)) { // presence condition changed
          var plReasoner = productLine.getReasoner();
          var phiPrime = (String) ChangeStep.getData().get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
          var reusePC = plReasoner.and(oldPC, pc);
          // modify existing result's presence condition
          resultGoal.setPresenceCondition(plReasoner.simplify(reusePC));
          var newPC = plReasoner.and(plReasoner.not(oldPC), pc);
          var newSAT = plReasoner.checkConsistency(phiPrime, Set.of(newPC));
          // create new result
          if (newSAT) {
            revised = true;
            x++;
            var resultGoalX = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + (n+x),
                                                 "Query result '" + result.getKey() + "', " + safetyDesc,
                                                 plReasoner.simplify(newPC), "resultGoal" + (n+x));
            resultGoalX.setImpact(ImpactType.REVISE);
          }
        }
      }
      // obsolete result, delete downstream branch
      else if (oldResults.contains(result.getKey())) {
        revised = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          PLGSNChangeStep.deleteDownstream(resultGoal);
          o++;
          oldResult = oldResults.get(o);
        }
      }
      // new result, add downstream branch
      else {
        revised = true;
        var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + (n+x),
                                            "Query result '" + result.getKey() + "', " + safetyDesc, result.getValue(),
                                            "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.getKey() + "'";
        resultGoal.setImpact(ImpactType.REVISE);
        n++;
      }
    }
    if (revised) {
      propsKey = getClass().getName() + "_CTX_" + modelPath + "_" + queryFilePath + "_" + query;
      ChangeStep.getData().put(propsKey, resultCtxDesc);
    }

    return nextSteps;
  }

  @Override
  public void repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    var revised = (Boolean) ChangeStep.getData().get(propsKey);
    // bottom up repair
    var impacts = new ArrayList<Map<ImpactType, Optional<String>>>();
    for (var i = 0; ; i++) {
      var resultGoal = templateElems.get("resultGoal" + i);
      if (resultGoal == null) {
        break;
      }
      impacts.add(resultGoal.getImpact());
    }
    var impactTypes = PLGSNChangeStep.min(impacts);
    templateElems.get("scenarioGoal").setImpact(impactTypes);
    templateElems.get("safetyGoal").setImpact(impactTypes);
    if (revised) { // clean impact on result strategy and context
      propsKey = getClass().getName() + "_CTX_" + modelPath + "_" + queryFilePath + "_" + query;
      var resultCtxDesc = (String) ChangeStep.getData().get(propsKey);
      templateElems.get("resultStrategy").setImpact(ImpactType.REUSE);
      var resultCtx = templateElems.get("resultCtx");
      resultCtx.setImpact(ImpactType.REUSE);
      resultCtx.setAttribute(this.gsn.getArgumentElement_Description(), resultCtxDesc);
    }
  }
}
