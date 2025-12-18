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
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.jdt.annotation.NonNullByDefault;

import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery.ResultPrinter;
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
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

/**
 * This template is a decomposition strategy based on identifying certain patterns in the underlying model with a VQL
 * query. It does not generate any evidence, but is supported by downstream goals corresponding to each of the
 * identified patterns.
 */
@NonNullByDefault
public class VQLQueryAnalysis implements IPLGSNAnalysis {
  protected GSNPackage gsn;

  public VQLQueryAnalysis() {
    this.gsn = GSNPackage.eINSTANCE;
  }

  public static ResultPrinter PL_NAME_PRINTER = result -> {
    if (result instanceof Class plClass) {
      // try finding a name
      var name = plClass.getAttributes().stream()
        .filter(a -> a.getType().getName().equals("name"))
        .map(Attribute::getValue)
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
    var desc = queryStrategy.getAttribute(this.gsn.getArgumentElement_Description())
      .replace("model query", "lifted model query");
    queryStrategy.setAttribute(this.gsn.getArgumentElement_Description(), desc);
    var liftedGoal = plBuilder.createGoal(Map.of(
      this.gsn.getArgumentElement_Id(), "G5",
      this.gsn.getArgumentElement_Description(), "The lifted query engine is correct",
      this.gsn.getArgumentElement_TemplateId(), "liftedGoal"));
    plBuilder.support(queryStrategy, liftedGoal);
    plTemplate.addReference(this.gsn.getTemplate_Elements(), liftedGoal);
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
    var resultGoal = plBuilder.createGoal(
      Map.of(this.gsn.getArgumentElement_Id(), resultId,
             this.gsn.getArgumentElement_Description(), resultDesc,
             this.gsn.getArgumentElement_TemplateId(), templateId),
      resultPC);
    plBuilder.support(resultStrategy, resultGoal);
    plTemplate.addReference(this.gsn.getTemplate_Elements(), resultGoal);

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
    var safetyDesc = safetyGoal.getAttribute(this.gsn.getArgumentElement_Description());
    var resultId = resultGoal.getAttribute(this.gsn.getArgumentElement_Id());
    var resultDesc = resultGoal.getAttribute(this.gsn.getArgumentElement_Description())
      .replace("{safety goal}", safetyDesc);
    var scenarioDesc = scenarioGoal.getAttribute(this.gsn.getArgumentElement_Description())
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
    var filesDesc = filesCtx.getAttribute(this.gsn.getArgumentElement_Description())
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
}
