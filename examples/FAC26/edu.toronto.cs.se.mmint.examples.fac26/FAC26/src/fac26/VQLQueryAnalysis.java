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
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

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
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
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

  public record QueryResult(String result, String presenceCondition)
                implements IAnalysisData<PLGSNArgumentElement> {

    public QueryResult(Object queryResult, String defaultPC) {
      var result = SiriusEvaluateQuery.queryResultToString(queryResult, VQLQueryAnalysis.PL_NAME_PRINTER, null, null);
      var pc = (queryResult instanceof PLElement plResult) ? plResult.getPresenceCondition() : defaultPC;
      this(result, pc);
    }

    public QueryResult(PLGSNArgumentElement resultGoal) {
      var name = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
      this(name, resultGoal.getPresenceCondition());
    }

    @Override
    public boolean equals(@Nullable Object anObject) {
      if (anObject == null || !(anObject instanceof QueryResult aQueryResult)) {
        return false;
      }
      return this.result().equals(aQueryResult.result());
    }

    public static List<QueryResult> fromQuery(QuerySpec querySpec, EObject rootModelObj) throws Exception {
      var defaultPC = (rootModelObj instanceof ProductLine pl) ? pl.getReasoner().getTrueLiteral() : null;
      var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
      return queryResults.stream()
        .map(r -> new QueryResult(r, defaultPC))
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

    @Override
    public void impactNew(String newSuffix, Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      params[0] = true; // revise flag
      var newPCs = (Set<String>) params[1];
      newPCs.add(presenceCondition());
    }

    @Override
    public void impactSame(IAnalysisData<PLGSNArgumentElement> oldDatum, String oldSuffix, String newSuffix,
                           Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      var newPCs = (Set<String>) params[1];
      var nextSteps = (List<PLGSNChangeStep>) params[2];
      var plTemplate = (PLGSNAnalyticTemplate) params[3];
      var plReasoner = (IPLFeaturesTrait) params[4];
      var step = (PLGSNChangeStep) params[5];
      var resultGoal = templateElems.get("resultGoal" + oldSuffix);
      var oldPC = ((QueryResult) oldDatum).presenceCondition();
      var newPC = presenceCondition();
      if (oldPC.equals(newPC)) { // same presence condition, notify downstream with full reuse
        resultGoal.setImpact(ImpactType.REUSE);
      }
      else { // presence condition changed, notify downstream
        var phiPrime = (String) ChangeStep.getData().get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
        var reusePC = plReasoner.and(oldPC, newPC); // we assume this is SAT
        var reuseOpt = Optional.of(plReasoner.simplify(reusePC));
        var newPC2 = plReasoner.and(plReasoner.not(oldPC), newPC);
        var newSAT = plReasoner.checkConsistency(phiPrime, Set.of(newPC2));
        var reviseOpt = newSAT ? Optional.of(plReasoner.simplify(newPC2)) : Optional.<String>empty();
        var impactTypes = Map.of(ImpactType.REUSE,   reuseOpt,
                                 ImpactType.RECHECK, Optional.<String>empty(),
                                 ImpactType.REVISE,  reviseOpt);
        resultGoal.setImpact(impactTypes);
        if (newSAT) {
          params[0] = true; // revise flag
          newPCs.add(newPC2);
        }
      }
      var templateTrace = new LinkedHashSet<EObject>();
      templateTrace.add(plTemplate);
      templateTrace.add(step.getImpacted());
      templateTrace.addAll(step.getForwardTrace());
      var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
      nextSteps.addAll(templateStep.nextSupporters());
    }

    @Override
    public void impactDel(String oldSuffix, Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      params[0] = true; // revise flag
      var nextSteps = (List<PLGSNChangeStep>) params[2];
      var plTemplate = (PLGSNAnalyticTemplate) params[3];
      var step = (PLGSNChangeStep) params[5];
      var resultGoal = templateElems.get("resultGoal" + oldSuffix);
      resultGoal.setImpact(ImpactType.REVISE); // notify downstream with full revise
      var templateTrace = new LinkedHashSet<EObject>();
      templateTrace.add(plTemplate);
      templateTrace.add(step.getImpacted());
      templateTrace.addAll(step.getForwardTrace());
      var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
      nextSteps.addAll(templateStep.nextSupporters());
    }

    private PLGSNArgumentElement createPLResultGoal(PLGSNAnalyticTemplate plTemplate, PLGSNBuilder plBuilder,
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
    public void repairNew(String newSuffix, Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      params[0] = true; // revised flag
      var x = (int) params[1];
      var safetyDesc = (String) params[3];
      var plTemplate = (PLGSNAnalyticTemplate) params[4];
      var plBuilder = (PLGSNBuilder) params[6];
      var n = Integer.parseInt(newSuffix.substring(1));
      var xSuffix = "." + (n + x);
      // add downstream branch
      var resultStrategy = templateElems.get("resultStrategy");
      var resultId = templateElems.get("resultGoal.1").getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Id())
        .split("\\.")[0];
      var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + xSuffix,
                                          "Query result '" + result() + "', " + safetyDesc, presenceCondition(),
                                          "resultGoal" + xSuffix);
      resultGoal.setImpact(ImpactType.REVISE);
    }

    @Override
    public void repairSame(IAnalysisData<PLGSNArgumentElement> oldDatum, String oldSuffix, String newSuffix,
                           Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      var x = (int) params[1];
      var nextSteps = (List<PLGSNChangeStep>) params[2];
      var safetyDesc = (String) params[3];
      var plTemplate = (PLGSNAnalyticTemplate) params[4];
      var plReasoner = (IPLFeaturesTrait) params[5];
      var plBuilder = (PLGSNBuilder) params[6];
      var step = (PLGSNChangeStep) params[7];
      var n = Integer.parseInt(newSuffix.substring(1));
      var xSuffix = "." + (n + x);
      // continue repair downstream
      var resultGoal = templateElems.get("resultGoal" + oldSuffix);
      var resultId = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Id()).split("\\.")[0];
      resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Id(), resultId + xSuffix);
      resultGoal.setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_TemplateId(), "resultGoal" + xSuffix);
      var templateTrace = new LinkedHashSet<EObject>();
      templateTrace.add(plTemplate);
      templateTrace.add(step.getImpacted());
      templateTrace.addAll(step.getForwardTrace());
      var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
      nextSteps.addAll(templateStep.nextSupporters());
      var oldPC = resultGoal.getPresenceCondition();
      var newPC = presenceCondition();
      if (!oldPC.equals(newPC)) { // presence condition changed
        var reusePC = plReasoner.simplify(plReasoner.and(oldPC, newPC));
        if (!oldPC.equals(reusePC)) { // modify existing result's presence condition
          PLGSNChangeStep.changePCDownstream(resultGoal, p -> p.replace(oldPC, reusePC));
        }
        var newPC2 = plReasoner.and(plReasoner.not(oldPC), newPC);
        var phiPrime = (String) ChangeStep.getData().get(PLGSNChangeStep.NEW_FEATURES_CONSTRAINT_KEY);
        var newSAT = plReasoner.checkConsistency(phiPrime, Set.of(newPC2));
        // create new result
        if (newSAT) {
          params[0] = true; // revised flag
          params[1] = ++x;
          xSuffix = "." + (n + x);
          var resultStrategy = templateElems.get("resultStrategy");
          var resultGoalX = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + xSuffix,
                                               "Query result '" + result() + "', " + safetyDesc,
                                               plReasoner.simplify(newPC2), "resultGoal" + xSuffix);
          resultGoalX.setImpact(ImpactType.REVISE);
        }
      }
    }

    @Override
    public void repairDel(String oldSuffix, Map<String, PLGSNArgumentElement> templateElems, Object... params) {
      params[0] = true; // revised flag
      // delete downstream branch
      var resultGoal = templateElems.get("resultGoal" + oldSuffix);
      PLGSNChangeStep.deleteDownstream(resultGoal);
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
      resultGoal.setPresenceCondition(
        productLine.mergePresenceConditions(resultGoal.getPresenceCondition(), result.presenceCondition()));
      resultCtxDesc += "\n'" + result.result() + "'";
    }
    templateElems.get("resultCtx").setAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description(), resultCtxDesc);
  }

  @Override
  public List<PLGSNChangeStep> nextImpactSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    var plReasoner = ((ProductLine) plTemplate.eContainer()).getReasoner();
    var templateElems = plTemplate.getElementsById();
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
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getData().put(propsKey, newResults);
    // compare results
    var oldResults = QueryResult.fromGSN(templateElems);
    var newPCs = new HashSet<String>();
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    var params = new Object[] {false, newPCs, nextSteps, plTemplate, plReasoner, step};
    dataLoop("impact", oldResults, newResults, templateElems, params);
    var revise = (boolean) params[0];
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
    var newResults = (List<QueryResult>) ChangeStep.getData().get(propsKey);
    // bottom up impact
    var impacts = new ArrayList<Map<ImpactType, Optional<String>>>();
    var impactPCs = new ArrayList<String>();
    for (var i = 1; ; i++) {
      var resultGoal = templateElems.get("resultGoal." + i);
      if (resultGoal == null) {
        break;
      }
      //TODO to cover manual downstream nodes, we should always assign impact from downstream first
      var resultImpact = resultGoal.getImpact();
      var result = resultGoal.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
      if (resultImpact.get(ImpactType.REVISE).isPresent() && resultImpact.get(ImpactType.REUSE).isEmpty() &&
          resultImpact.get(ImpactType.RECHECK).isEmpty() &&
          newResults.stream().noneMatch(nr -> result.equals(nr.result()))) {
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
    var plReasoner = productLine.getReasoner();
    var plBuilder = new PLGSNBuilder(productLine);
    var templateElems = plTemplate.getElementsById();
    // fetch query results on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description()).split("'")[1];
    var propsKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var newResults = (List<QueryResult>) ChangeStep.getData().get(propsKey);
    // compare results
    var oldResults = QueryResult.fromGSN(templateElems);
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    var safetyDesc = templateElems.get("safetyGoal")
      .getAttribute(VQLQueryAnalysis.GSN.getArgumentElement_Description());
    var params = new Object[] {false, 0, nextSteps, safetyDesc, plTemplate, plReasoner, plBuilder, step};
    dataLoop("repair", oldResults, newResults, templateElems, params);
    var revised = (boolean) params[0];
    propsKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getData().put(propsKey, revised);
    if (revised) {
      var resultCtxDesc = (newResults.isEmpty()) ?
        "No results" :
        "Query results:" + newResults.stream().map(nr -> "\n'" + nr.result() + "'").collect(Collectors.joining());
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
    for (var i = 1; ; i++) {
      var resultGoal = templateElems.get("resultGoal." + i);
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
