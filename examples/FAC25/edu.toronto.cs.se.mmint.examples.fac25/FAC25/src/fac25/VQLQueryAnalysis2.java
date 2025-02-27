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
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNImpactStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ImpactStep;

public class VQLQueryAnalysis2 extends VQLQueryAnalysis {

  @Override
  public List<PLGSNImpactStep> impact(PLGSNAnalyticTemplate plTemplate, PLGSNImpactStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var nextSteps = new ArrayList<PLGSNImpactStep>();
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
    var dataKey = getClass().getName() + "_" + modelPath + "_" + queryFilePath + "_" + query;
    ImpactStep.getData().put(dataKey, results);
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
      // new result, revise decomposition
      if (o >= oldResults.size()) {
        addedResults = true;
        break;
      }
      var oldResult = oldResults.get(o);
      // same result, reuse and continue impact downstream
      if (oldResult.equals(result.getKey())) {
        //TODO consider possible pc change (result.getValue())
        var resultGoal = templateElems.get("resultGoal" + o);
        var templateTrace = new ArrayList<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.addAll(step.getTrace());
        var templateStep = new PLGSNImpactStep(resultGoal, templateTrace);
        templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultGoal),
                                                                        ImpactType.RECHECK, Optional.empty(),
                                                                        ImpactType.REVISE, Optional.empty()));
        nextSteps.addAll(templateStep.nextSupporters());
        o++;
        n++;
      }
      // deleted result, revise downstream
      else if (oldResults.contains(result.getKey())) {
        deletedResults = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          var templateTrace = new ArrayList<EObject>();
          templateTrace.add(plTemplate);
          templateTrace.addAll(step.getTrace());
          var templateStep = new PLGSNImpactStep(resultGoal, templateTrace);
          templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.empty(),
                                                                          ImpactType.RECHECK, Optional.empty(),
                                                                          ImpactType.REVISE, Optional.of(resultGoal)));
          nextSteps.addAll(templateStep.nextSupporters());
          o++;
          oldResult = oldResults.get(o);
        }
      }
      // new result, revise decomposition
      else {
        addedResults = true;
        n++;
      }
    }
    // revise result strategy
    if (addedResults) {
      var resultStrategy = templateElems.get("resultStrategy");
      var templateStep = new PLGSNImpactStep(resultStrategy);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.empty(),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.of(resultStrategy)));
    }
    // revise result context
    if (deletedResults || addedResults) {
      var templateStep = new PLGSNImpactStep(resultCtx);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.empty(),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.of(resultCtx)));
    }
    // reuse everything else in the template
    for (var plElem : plTemplate.getReference(this.gsn.getTemplate_Elements())) {
      if (!plElem.getReference(this.gsn.getArgumentElement_Status()).isEmpty()) {
        continue;
      }
      var templateStep = new PLGSNImpactStep((PLGSNArgumentElement) plElem);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(plElem),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.empty()));
    }

    return nextSteps;
  }

  private void deletePLBranch(Class plElem) {
    var productLine = plElem.getProductLine();
    for (var plInContextOf : plElem.getReference(this.gsn.getContextualizable_InContextOf())) {
      for (var plContext : plInContextOf.getReference(this.gsn.getInContextOf_Context())) {
        plContext.delete();
      }
      productLine.getClasses().remove(plInContextOf);
    }
    for (var plSupportedBy : plElem.getReference(this.gsn.getSupportable_SupportedBy())) {
      for (var plSupporter : plSupportedBy.getReference(this.gsn.getSupportedBy_Target())) {
        deletePLBranch(plSupporter);
      }
      productLine.getClasses().remove(plSupportedBy);
    }
    plElem.delete();
  }

  @Override
  public void repair(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var productLine = (ProductLine) plTemplate.eContainer();
    var plBuilder = new PLGSNBuilder(productLine);
    var templateElems = plTemplate.getElementsById();
    // fetch query results on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(this.gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var dataKey = getClass().getName() + "_" + modelPath + "_" + queryFilePath + "_" + query;
    var results = (List<Map.Entry<String, String>>) ImpactStep.getData().get(dataKey);
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
        //TODO should repair be integrated into ImpactStep?
        var templateStep = new PLGSNImpactStep(resultGoal);
        templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultGoal),
                                                                        ImpactType.RECHECK, Optional.empty(),
                                                                        ImpactType.REVISE, Optional.empty()));
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
        //TODO: how do we propagate repair with the current api?
        o++;
        n++;
      }
      // deleted result, delete downstream branch
      else if (oldResults.contains(result.getKey())) {
        deletedResults = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + o);
          deletePLBranch(resultGoal);
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
        var templateStep = new PLGSNImpactStep(resultGoal);
        templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultGoal),
                                                                        ImpactType.RECHECK, Optional.empty(),
                                                                        ImpactType.REVISE, Optional.empty()));
        n++;
      }
    }
    // clean impact on result strategy
    if (addedResults) {
      var templateStep = new PLGSNImpactStep(resultStrategy);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultStrategy),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.empty()));
    }
    // change result context and clean impact
    if (deletedResults || addedResults) {
      resultCtx.setAttribute(this.gsn.getArgumentElement_Description(), resultCtxDesc);
      var templateStep = new PLGSNImpactStep(resultCtx);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultCtx),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.empty()));
    }
  }
}
