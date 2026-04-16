/*******************************************************************************
 * Copyright (c) 2024, 2026 Alessio Di Sandro.
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
package fac26;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery.ResultPrinter;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Attribute;
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
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysisData;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * This template is a decomposition strategy based on identifying certain patterns in the underlying model with a VQL
 * query. It does not generate any evidence, but is supported by downstream goals corresponding to each of the
 * identified patterns.
 */
@NonNullByDefault
public class VQLQueryAnalysis implements IPLGSNAnalysis {
  protected static GSNPackage GSN = GSNPackage.eINSTANCE;

  public static ResultPrinter PL_NAME_PRINTER = result -> {
    if (result instanceof Class plClass) {
      // try finding a name attribute
      var name = plClass.getAttributes().stream()
        .map(Attribute::getType)
        .filter(t -> t.getName().equals("name"))
        .findFirst()
        .map(t -> plClass.getAttribute(t));
      if (name.isPresent()) {
        return name.get();
      }
    }
    return SiriusEvaluateQuery.NAME_PRINTER.prettyPrint(result);
  };

  public record QueryResult(String result, Optional<String> presenceCondition)
                implements IAnalysisData<PLGSNArgumentElement> {

    public QueryResult(Object queryResult) {
      var result = SiriusEvaluateQuery.queryResultToString(queryResult, VQLQueryAnalysis.PL_NAME_PRINTER, null, null);
      var pc = Optional.ofNullable(
        (queryResult instanceof PLElement plResult) ? plResult.getPresenceCondition() : null);
      this(result, pc);
    }

    public QueryResult(PLGSNArgumentElement resultGoal) {
      var name = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
      this(name, Optional.of(resultGoal.getPresenceCondition()));
    }

    public static List<QueryResult> fromQuery(QuerySpec querySpec, EObject rootModelObj) throws Exception {
      var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
      return queryResults.stream()
        .map(QueryResult::new)
        .filter(r -> r.result().startsWith("Alrm_"))
        .sorted(Comparator.comparing(QueryResult::result))
        .toList();
    }

    public static List<QueryResult> fromGSN(Map<String, PLGSNArgumentElement> templateElems) {
      return templateElems.entrySet().stream()
        .filter(e -> e.getKey().startsWith("resultGoal"))
        .sorted(Comparator.comparing(Entry::getKey))
        .map(e -> new QueryResult(e.getValue()))
        .toList();
    }
  }

  @Override
  public void instantiate(AnalyticTemplate template) throws Exception {
    // get template elems
    var templateElems = template.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    var filesCtx = (FilesContext) templateElems.get("filesCtx");
    var scenarioGoal = templateElems.get("scenarioGoal");
    var resultGoal = templateElems.get("resultGoal");
    safetyGoal.instantiate();
    var safetyDesc = safetyGoal.getDescription();
    var resultDesc = resultGoal.getDescription().replace(GSNBuilder.placeholder("safety goal"), safetyDesc);
    resultGoal.setDescription(resultDesc);
    var scenarioDesc = scenarioGoal.getDescription().replace(GSNBuilder.placeholder("safety goal"), safetyDesc);
    scenarioGoal.setDescription(scenarioDesc);
    // run query and process results
    var modelPath = FileUtils.prependWorkspacePath(MIDDialogs.selectModelToImport(false));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var results = QueryResult.fromQuery(querySpec, rootModelObj);
    var numResults = results.size();
    var filesDesc = filesCtx.getDescription()
                            .replace(GSNBuilder.placeholder("query"), querySpec.query().toString())
                            .replace(GSNBuilder.placeholder("model"), FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setDescription(filesDesc);
    filesCtx.getPaths().add(querySpec.filePath());
    filesCtx.getPaths().add(modelPath);
    var resultCtxDesc = (results.isEmpty()) ? "No results" : "Query results:";
    var resultsDeco = templateElems.get("resultsDecorator");
    resultsDeco.setDescription(Integer.toString(numResults));
    resultsDeco.instantiate(); // instantiate decorator with hint to create numResults subtrees
    templateElems = template.getElementsById(); // fetch after decorator instantiation
    for (var i = 0; i < numResults; i++) {
      var result = results.get(i);
      var idSuffix = "." + (i+1);
      resultGoal = templateElems.get("resultGoal" + idSuffix);
      resultDesc = resultGoal.getDescription()
                             .replace(GSNBuilder.placeholder("result" + idSuffix),  "'" + result.result() + "'");
      resultGoal.setDescription(resultDesc);
      resultCtxDesc += "\n'" + result.result() + "'";
    }
    templateElems.get("resultCtx").setDescription(resultCtxDesc);
  }

  @Override
  public void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var plBuilder = new PLGSNBuilder(productLine);
    var queryStrategy = plTemplate.getElementsById().get("queryStrategy");
    var queryDesc = queryStrategy.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description())
                                 .replace("model query", "lifted model query");
    queryStrategy.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), queryDesc);
    var liftedGoal = plBuilder.createGoal(Map.of(
      VQLQueryAnalysis.GSN.getArgumentElement_Id(), "G4",
      VQLQueryAnalysis.GSN.getArgumentElement_Description(), "The lifted query engine is correct",
      VQLQueryAnalysis.GSN.getArgumentElement_TemplateId(), "liftedGoal"));
    plBuilder.support(queryStrategy, liftedGoal);
    plTemplate.addReference(VQLQueryAnalysis.GSN.getTemplate_Elements(), liftedGoal);
  }

  protected PLGSNArgumentElement createPLResultGoal(PLGSNAnalyticTemplate plTemplate, PLGSNBuilder plBuilder,
                                                    PLGSNArgumentElement resultStrategy, String resultId,
                                                    String resultDesc, String resultPC, String templateId) {
    var resultGoal = plBuilder.createGoal(
      Map.of(VQLQueryAnalysis.GSN.getArgumentElement_Id(), resultId,
             VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultDesc,
             VQLQueryAnalysis.GSN.getArgumentElement_TemplateId(), templateId),
      resultPC);
    plBuilder.support(resultStrategy, resultGoal);
    plTemplate.addReference(VQLQueryAnalysis.GSN.getTemplate_Elements(), resultGoal);

    return resultGoal;
  }

  @Override
  public void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var productLine = (ProductLine) plTemplate.eContainer();
    // get template elems
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    var filesCtx = templateElems.get("filesCtx");
    var scenarioGoal = templateElems.get("scenarioGoal");
    var resultGoal = templateElems.get("resultGoal");
    safetyGoal.instantiate();
    var safetyDesc = safetyGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description());
    var resultDesc = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description())
                               .replace(GSNBuilder.placeholder("safety goal"), safetyDesc);
    resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultDesc);
    var scenarioDesc = scenarioGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description())
                                   .replace(GSNBuilder.placeholder("safety goal"), safetyDesc);
    scenarioGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), scenarioDesc);
    // run query and process results
    var modelPath = FileUtils.prependWorkspacePath(
      MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                            "There are no Product Line models in the workspace", Set.of("productline")));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var results = QueryResult.fromQuery(querySpec, rootModelObj);
    var numResults = results.size();
    var filesDesc = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description())
                            .replace(GSNBuilder.placeholder("query"), querySpec.query().toString())
                            .replace(GSNBuilder.placeholder("model"), FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), filesDesc);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(),
                              ECollections.asEList(querySpec.filePath(), modelPath));
    var resultCtxDesc = (results.isEmpty()) ? "No results" : "Query results:";
    var resultsDeco = templateElems.get("resultsDecorator");
    resultsDeco.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), Integer.toString(numResults));
    resultsDeco.instantiate(); // instantiate decorator with hint to create numResults subtrees
    templateElems = plTemplate.getElementsById(); // fetch after decorator instantiation
    for (var i = 0; i < numResults; i++) {
      var result = results.get(i);
      var idSuffix = "." + (i+1);
      resultGoal = templateElems.get("resultGoal" + idSuffix);
      resultDesc = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description())
                             .replace(GSNBuilder.placeholder("result" + idSuffix),  "'" + result.result() + "'");
      resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultDesc);
      if (result.presenceCondition().isPresent()) {
        var pc = result.presenceCondition().get();
        resultGoal.setPresenceCondition(productLine.mergePresenceConditions(resultGoal.getPresenceCondition(), pc));
      }
      resultCtxDesc += "\n'" + result.result() + "'";
    }
    templateElems.get("resultCtx").setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultCtxDesc);
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
    var query = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var plVQLReasoner = (IQueryTrait) MMINT.getReasoner("Viatra for Product Lines");
    var querySpec = new QuerySpec(plVQLReasoner, queryFilePath, query);
    var newResults = QueryResult.fromQuery(querySpec, rootModelObj);
    // compare results
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getData().put(propsKey, newResults);
    var o = 0; // old results counter
    var n = 0; // new results counter
    var revise = false;
    var newPCs = new HashSet<String>();
    var params = new Object[] {};
    var oldResults = QueryResult.fromGSN(templateElems);
    dataLoop("impact", oldResults, newResults, templateElems, params);
    while (n < newResults.size()) {
      var result = newResults.get(n);
      var pc = result.presenceCondition().orElse(null);
      // new result
      if (o >= oldResults.size()) {
        revise = true;
        newPCs.add(pc);
        break;
      }
      var oldResult = oldResults.get(o);
      // same result, continue impact downstream
      if (oldResult.result().equals(result.result())) {
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
      else if (oldResults.contains(result.result())) {
        revise = true;
        while (!oldResult.result().equals(result.result())) {
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
    var query = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
    var propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    var revise = (Boolean) ChangeStep.getData().get(propsKey);
    propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var results = (List<QueryResult>) ChangeStep.getData().get(propsKey);
    // bottom up impact
    var impacts = new ArrayList<Map<ImpactType, Optional<String>>>();
    var impactPCs = new ArrayList<String>();
    for (var i = 0; ; i++) {
      var resultGoal = templateElems.get("resultGoal" + i);
      if (resultGoal == null) {
        break;
      }
      //TODO to cover manual downstream nodes, we should always assign impact from downstream first
      var resultImpact = resultGoal.getImpact();
      var result = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
      if (resultImpact.get(ImpactType.REVISE).isPresent() && resultImpact.get(ImpactType.REUSE).isEmpty() &&
          resultImpact.get(ImpactType.RECHECK).isEmpty() &&
          results.stream().noneMatch(r -> result.equals(r.result()))) {
        // do not participate if obsolete result
        continue;
      }
      impacts.add(resultImpact);
      impactPCs.add(resultGoal.getPresenceCondition());
    }
    if (revise) { // include revised result strategy
      var resultStrategy = templateElems.get("resultStrategy");
      impacts.add(resultStrategy.getImpact());
      impactPCs.add(resultStrategy.getPresenceCondition());
    }
    var impact = PLGSNChangeStep.min(impacts, impactPCs);
    templateElems.get("scenarioGoal").setImpact(impact);
    templateElems.get("safetyGoal").setImpact(impact);
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
    var query = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var newResults = (List<QueryResult>) ChangeStep.getData().get(propsKey);
    var resultCtxDesc = (newResults.isEmpty()) ? "No results" : "Query results:";
    // compare results
    var safetyGoal = templateElems.get("safetyGoal");
    var safetyDesc = safetyGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description());
    var resultCtx = templateElems.get("resultCtx");
    var resultStrategy = templateElems.get("resultStrategy");
    var resultId = templateElems.get("resultGoal0").getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Id())
                                .split("\\.")[0] + ".";
    var oldResults = QueryResult.fromGSN(templateElems);
    var o = 0; // old results counter
    var n = 0; // new results counter
    var x = 0; // extra results counter
    var revised = false;
    while (n < newResults.size()) {
      var result = newResults.get(n);
      var pc = result.presenceCondition().orElse(null);
      // new result, add downstream branch
      if (o >= oldResults.size()) {
        revised = true;
        var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + (n+x),
                                            "Query result '" + result.result() + "', " + safetyDesc, pc,
                                            "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.result() + "'";
        resultGoal.setImpact(ImpactType.REVISE);
        n++;
        continue;
      }
      var oldResult = oldResults.get(o);
      // same result, continue repair downstream
      if (oldResult.result().equals(result.result())) {
        var resultGoal = templateElems.get("resultGoal" + o);
        var oldPC = resultGoal.getPresenceCondition();
        resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Id(), resultId + (n+x));
        resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_TemplateId(), "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.result() + "'";
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
          var reusePC = plReasoner.simplify(plReasoner.and(oldPC, pc));
          if (!oldPC.equals(reusePC)) { // modify existing result's presence condition
            PLGSNChangeStep.changePCDownstream(resultGoal, p -> p.replace(oldPC, reusePC));
          }
          var newPC = plReasoner.and(plReasoner.not(oldPC), pc);
          var phiPrime = (String) ChangeStep.getData().get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
          var newSAT = plReasoner.checkConsistency(phiPrime, Set.of(newPC));
          // create new result
          if (newSAT) {
            revised = true;
            x++;
            var resultGoalX = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + (n+x),
                                                 "Query result '" + result.result() + "', " + safetyDesc,
                                                 plReasoner.simplify(newPC), "resultGoal" + (n+x));
            resultGoalX.setImpact(ImpactType.REVISE);
          }
        }
      }
      // obsolete result, delete downstream branch
      else if (oldResults.contains(result.result())) {
        revised = true;
        while (!oldResult.result().equals(result.result())) {
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
                                            "Query result '" + result.result() + "', " + safetyDesc, pc,
                                            "resultGoal" + (n+x));
        resultCtxDesc += "\n'" + result.result() + "'";
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
    var query = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
    var propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    var revised = (Boolean) ChangeStep.getData().get(propsKey);
    // bottom up repair
    var impacts = new ArrayList<Map<ImpactType, Optional<String>>>();
    var impactPCs = new ArrayList<String>();
    for (var i = 0; ; i++) {
      var resultGoal = templateElems.get("resultGoal" + i);
      if (resultGoal == null) {
        break;
      }
      impacts.add(resultGoal.getImpact());
      impactPCs.add(resultGoal.getPresenceCondition());
    }
    var impact = PLGSNChangeStep.min(impacts, impactPCs);
    templateElems.get("scenarioGoal").setImpact(impact);
    templateElems.get("safetyGoal").setImpact(impact);
    if (revised) { // clean impact on result strategy and context
      propsKey = getClass().getName() + "_CTX_" + modelPath + "_" + queryFilePath + "_" + query;
      var resultCtxDesc = (String) ChangeStep.getData().get(propsKey);
      templateElems.get("resultStrategy").setImpact(ImpactType.REUSE);
      var resultCtx = templateElems.get("resultCtx");
      resultCtx.setImpact(ImpactType.REUSE);
      resultCtx.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultCtxDesc);
    }
  }
}
