/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

public class VQLQueryAnalysis2 extends VQLQueryAnalysis {

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
    var dataKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getProperties().put(dataKey, results);
    var resultCtx = templateElems.get("resultCtx");
    var oldResults = resultCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).lines()
      .filter(l -> l.startsWith("'"))
      .map(l -> l.substring(1, l.length()-1))
      .collect(Collectors.toList());
    var o = 0; // old results counter
    var n = 0; // new results counter
    var deletedResults = false;
    var addedResults = false;
    while (n < results.size()) {
      var result = results.get(n);
      // new result
      if (o >= oldResults.size()) {
        addedResults = true;
        break;
      }
      var oldResult = oldResults.get(o);
      // same result, continue impact downstream
      if (oldResult.equals(result.getKey())) {
        //TODO consider possible pc change (result.getValue())
        var resultGoal = templateElems.get("resultGoal" + o);
        resultGoal.setImpact(ImpactType.REUSE, plReasoner.getTrueLiteral());
        var templateTrace = new LinkedHashSet<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.add(step.getImpacted());
        templateTrace.addAll(step.getTrace());
        var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
        nextSteps.addAll(templateStep.nextSupporters());
        o++;
        n++;
      }
      // deleted result
      else if (oldResults.contains(result.getKey())) {
        deletedResults = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          resultGoal.setImpact(ImpactType.REVISE, plReasoner.getTrueLiteral());
          var templateTrace = new LinkedHashSet<EObject>();
          templateTrace.add(plTemplate);
          templateTrace.add(step.getImpacted());
          templateTrace.addAll(step.getTrace());
          var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
          nextSteps.addAll(templateStep.nextSupporters());
          o++;
          oldResult = oldResults.get(o);
        }
      }
      // new result
      else {
        addedResults = true;
        n++;
      }
    }
    dataKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    ChangeStep.getProperties().put(dataKey, deletedResults || addedResults);

    return nextSteps;
  }

  @Override
  public void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step, List<PLGSNChangeStep> dependencySteps)
                    throws Exception {
    var plReasoner = ((ProductLine) plTemplate.eContainer()).getReasoner();
    var templateElems = plTemplate.getElementsById();
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var dataKey = getClass().getName() + "_REVISE_" + modelPath + "_" + queryFilePath + "_" + query;
    var revise = (Boolean) ChangeStep.getProperties().get(dataKey);
    dependencySteps.stream().map(s -> s.getImpacted().getImpact());//TODO continue
    var impactType = (revise) ? ImpactType.REVISE : ImpactType.REUSE; //TODO calculate from downstream
    templateElems.get("resultStrategy").setImpact(impactType, plReasoner.getTrueLiteral());
    templateElems.get("scenarioGoal").setImpact(impactType, plReasoner.getTrueLiteral());
    templateElems.get("queryStrategy").setImpact(impactType, plReasoner.getTrueLiteral());
    templateElems.get("safetyGoal").setImpact(impactType, plReasoner.getTrueLiteral());
    if (revise) {
      templateElems.get("resultCtx").setImpact(ImpactType.REVISE, plReasoner.getTrueLiteral());
    }
    // reuse everything else in the template
    PLGSNChangeStep.setAllImpacts(plTemplate, ImpactType.REUSE);
  }

  @Override
  public List<PLGSNChangeStep> repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var productLine = (ProductLine) plTemplate.eContainer();
    var plBuilder = new PLGSNBuilder(productLine);
    var plReasoner = productLine.getReasoner();
    var templateElems = plTemplate.getElementsById();
    var nextSteps = new ArrayList<PLGSNChangeStep>();
    // fetch query results on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var dataKey = getClass().getName() + "_RESULTS_" + modelPath + "_" + queryFilePath + "_" + query;
    var results = (List<Map.Entry<String, String>>) ChangeStep.getProperties().get(dataKey);
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
    var deletedResults = false;
    var addedResults = false;
    while (n < results.size()) {
      var result = results.get(n);
      // new result, add downstream branch
      if (o >= oldResults.size()) {
        addedResults = true;
        var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + n,
                                            "Query result '" + result.getKey() + "', " + safetyDesc, result.getValue(),
                                            "resultGoal" + n);
        resultCtxDesc += "\n'" + result.getKey() + "'";
        resultGoal.setImpact(ImpactType.REUSE, plReasoner.getTrueLiteral());
        n++;
        continue;
      }
      var oldResult = oldResults.get(o);
      // same result, continue repair downstream
      if (oldResult.equals(result.getKey())) {
        var resultGoal = templateElems.get("resultGoal" + o);
        resultGoal.setAttribute(this.gsn.getArgumentElement_Id(), resultId + n);
        resultGoal.setAttribute(this.gsn.getArgumentElement_TemplateId(), "resultGoal" + n);
        resultCtxDesc += "\n'" + result.getKey() + "'";
        var templateTrace = new LinkedHashSet<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.add(step.getImpacted());
        templateTrace.addAll(step.getTrace());
        var templateStep = new PLGSNChangeStep(resultGoal, templateTrace);
        nextSteps.addAll(templateStep.nextSupporters());
        o++;
        n++;
      }
      // deleted result, delete downstream branch
      else if (oldResults.contains(result.getKey())) {
        deletedResults = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          PLGSNChangeStep.deleteBranch(resultGoal);
          o++;
          oldResult = oldResults.get(o);
        }
      }
      // new result, add downstream branch
      else {
        addedResults = true;
        var resultGoal = createPLResultGoal(plTemplate, plBuilder, resultStrategy, resultId + n,
                                            "Query result '" + result.getKey() + "', " + safetyDesc, result.getValue(),
                                            "resultGoal" + n);
        resultCtxDesc += "\n'" + result.getKey() + "'";
        resultGoal.setImpact(ImpactType.REUSE, plReasoner.getTrueLiteral());
        n++;
      }
    }
    // clean impact on result strategy
    if (addedResults) {
      resultStrategy.setImpact(ImpactType.REUSE, plReasoner.getTrueLiteral());
    }
    // change result context and clean impact
    if (deletedResults || addedResults) {
      resultCtx.setAttribute(this.gsn.getArgumentElement_Description(), resultCtxDesc);
      resultCtx.setImpact(ImpactType.REUSE, plReasoner.getTrueLiteral());
    }

    return nextSteps;
  }
}
