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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery.ResultPrinter;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IPLGSNAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

public class VQLQueryAnalysis implements IPLGSNAnalysis {

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
    var modelPath = MIDDialogs.selectModelToImport(false);
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    template.getElements().remove(resultGoal);
    safetyCase.getGoals().remove(resultGoal);
    resultStrategy.getSupportedBy().remove(0);
    filesCtx.setDescription(
      filesCtx.getDescription()
              .replace("{query}", querySpec.query().toString())
              .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath)));
    filesCtx.getPaths().add(FileUtils.prependWorkspacePath(querySpec.filePath()));
    filesCtx.getPaths().add(FileUtils.prependWorkspacePath(modelPath));
    var resultCtxDesc = (queryResults.isEmpty()) ? "No results" : "Query results:";
    var i = 0;
    for (var queryResult : queryResults) {
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, SiriusEvaluateQuery.NAME_PRINTER, null,
                                                               null);
      if (!resultText.startsWith("Alrm_")) {
        continue;
      }
      resultCtxDesc += "\n'" + resultText + "'";
      resultGoal = builder.createGoal(resultId.replace("X", String.valueOf(i)),
                                      resultDesc.replace("{X}", "'" + resultText + "'"));
      resultGoal.setTemplateId("resultGoal" + i);
      template.getElements().add(resultGoal);
      builder.addSupporter(resultStrategy, resultGoal);
      i++;
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  @Override
  public void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var builder = new PLGSNBuilder(productLine);
    var queryStrategy = plTemplate.getElementsById().get("queryStrategy");
    var desc = queryStrategy.getAttribute(gsn.getArgumentElement_Description()).get(0)
      .replace("model query", "lifted model query");
    queryStrategy.setAttribute(gsn.getArgumentElement_Description(), desc);
    var liftedGoal = builder.createGoal("G5", "The lifted query engine is correct", null);
    liftedGoal.addAttribute(gsn.getArgumentElement_TemplateId(), "liftedGoal");
    plTemplate.addReference(gsn.getTemplate_Elements(), liftedGoal);
    builder.addSupporter(queryStrategy, liftedGoal);
  }

  @Override
  public void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var productLine = (ProductLine) plTemplate.eContainer();
    var builder = new PLGSNBuilder(productLine);
    // get template elems
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    var filesCtx = templateElems.get("filesCtx");
    var scenarioGoal = templateElems.get("scenarioGoal");
    var resultStrategy = templateElems.get("resultStrategy");
    var resultCtx = templateElems.get("resultCtx");
    var resultGoal = templateElems.get("resultGoal");
    safetyGoal.instantiate();
    var safetyDesc = safetyGoal.getAttribute(gsn.getArgumentElement_Description()).get(0);
    var resultId = resultGoal.getAttribute(gsn.getArgumentElement_Id()).get(0);
    var resultDesc = resultGoal.getAttribute(gsn.getArgumentElement_Description()).get(0)
      .replace("{safety goal}", safetyDesc);
    var scenarioDesc = scenarioGoal.getAttribute(gsn.getArgumentElement_Description()).get(0)
                                   .replace("{safety goal}", safetyDesc);
    scenarioGoal.setAttribute(gsn.getArgumentElement_Description(), scenarioDesc);
    // run query and process results
    var modelPath = MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                                          "There are no Product Line models in the workspace", Set.of("productline"));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    resultGoal.delete();
    for (var supportedBy : resultGoal.getReference(gsn.getSupporter_Supports())) {
      supportedBy.delete();
    }
    var filesDesc = filesCtx.getAttribute(gsn.getArgumentElement_Description()).get(0)
                            .replace("{query}", querySpec.query().toString())
                            .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(gsn.getArgumentElement_Description(), filesDesc);
    filesCtx.setManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths(),
                              ECollections.asEList(List.of(FileUtils.prependWorkspacePath(querySpec.filePath()),
                                                           FileUtils.prependWorkspacePath(modelPath))));
    var resultCtxDesc = (queryResults.isEmpty()) ? "No results" : "Query results:";
    var i = 0;
    for (var queryResult : queryResults) {
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, VQLQueryAnalysis.PL_NAME_PRINTER, null,
                                                               null);
      if (!resultText.startsWith("Alrm_")) {
        continue;
      }
      var pc = ((PLElement) queryResult).getPresenceCondition();
      resultCtxDesc += "\n'" + resultText + "'";
      resultGoal = builder.createGoal(resultId.replace("X", String.valueOf(i)),
                                      resultDesc.replace("{X}", "'" + resultText + "'"), pc);
      resultGoal.addAttribute(gsn.getArgumentElement_TemplateId(), "resultGoal" + i);
      plTemplate.addReference(gsn.getTemplate_Elements(), resultGoal, pc);
      builder.addSupporter(resultStrategy, resultGoal);
      i++;
    }
    resultCtx.setAttribute(gsn.getArgumentElement_Description(), resultCtxDesc);
  }
}
