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
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.GSNPLBuilder;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

public class VQLQueryAnalysis implements IGSNPLAnalysis {

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
    // get template elems
    var safetyCase = (SafetyCase) template.eContainer();
    var builder = new GSNTemplatesBuilder(safetyCase);
    var templateElems = template.getElements();
    var queryStrategy = template.getElements().stream()
      .filter(Strategy.class::isInstance)
      .map(Strategy.class::cast)
      .findFirst().get();
    var safetyGoal = queryStrategy.getSupports().get(0).getSource();
    var filesCtx = (FilesContext) queryStrategy.getInContextOf().get(0).getContext();
    var scenarioGoal = (Goal) queryStrategy.getSupportedBy().get(3).getTarget();
    var resultStrategy = (Strategy) scenarioGoal.getSupportedBy().get(0).getTarget();
    var resultCtx = scenarioGoal.getInContextOf().get(0).getContext();
    var resultGoal = resultStrategy.getSupportedBy().get(0).getTarget();
    safetyGoal.instantiate(template);
    var safetyDesc = safetyGoal.getDescription();
    var resultId = resultGoal.getId();
    var resultDesc = resultGoal.getDescription().replace("{safety goal}", safetyDesc);
    scenarioGoal.setDescription(scenarioGoal.getDescription().replace("{safety goal}", safetyDesc));
    // run query and process results
    var modelPath = MIDDialogs.selectModelToImport(false);
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    templateElems.remove(resultGoal);
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
      templateElems.add(resultGoal);
      builder.addSupporter(resultStrategy, resultGoal);
      i++;
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  @Override
  public void import_(GSNPLAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {
    var types = GSNPackage.eINSTANCE;
    var builder = new GSNPLBuilder(productLine);
    var queryStrategy = (GSNPLArgumentElement) plTemplate.getStreamOfReference(types.getTemplate_Elements())
      .filter(c -> c.getType() == types.getStrategy())
      .findFirst().get();
    var desc = queryStrategy.getAttribute(types.getArgumentElement_Description()).get(0)
      .replace("model query", "lifted model query");
    queryStrategy.setAttribute(types.getArgumentElement_Description(), desc);
    var liftingGoal = builder.createGoal("G5", "The lifted query engine is correct", null);
    plTemplate.addReference(types.getTemplate_Elements(), liftingGoal);
    builder.addSupporter(queryStrategy, liftingGoal);
  }

  @Override
  public void instantiate(GSNPLAnalyticTemplate plTemplate) throws Exception {
    var types = GSNPackage.eINSTANCE;
    var productLine = (ProductLine) plTemplate.eContainer();
    var builder = new GSNPLBuilder(productLine);
    // get template elems
    var queryStrategy = (GSNPLArgumentElement) plTemplate.getStreamOfReference(types.getTemplate_Elements())
      .filter(c -> c.getType() == types.getStrategy())
      .findFirst().get();
    var safetyGoal = (GSNPLArgumentElement) queryStrategy
      .getReference(types.getSupporter_Supports()).get(0)
      .getReference(types.getSupportedBy_Source()).get(0);
    var filesCtx = queryStrategy
      .getReference(types.getContextualizable_InContextOf()).get(0)
      .getReference(types.getInContextOf_Context()).get(0);
    var scenarioGoal = queryStrategy
      .getReference(types.getSupportable_SupportedBy()).get(3)
      .getReference(types.getSupportedBy_Target()).get(0);
    var resultStrategy = (GSNPLArgumentElement) scenarioGoal
      .getReference(types.getSupportable_SupportedBy()).get(0)
      .getReference(types.getSupportedBy_Target()).get(0);
    var resultCtx = scenarioGoal
      .getReference(types.getContextualizable_InContextOf()).get(0)
      .getReference(types.getInContextOf_Context()).get(0);
    var resultGoal = (GSNPLArgumentElement) resultStrategy
      .getReference(types.getSupportable_SupportedBy()).get(0)
      .getReference(types.getSupportedBy_Target()).get(0);
    safetyGoal.instantiate(plTemplate);
    var safetyDesc = safetyGoal.getAttribute(types.getArgumentElement_Description()).get(0);
    var resultId = resultGoal.getAttribute(types.getArgumentElement_Id()).get(0);
    var resultDesc = resultGoal.getAttribute(types.getArgumentElement_Description()).get(0)
      .replace("{safety goal}", safetyDesc);
    var scenarioDesc = scenarioGoal.getAttribute(types.getArgumentElement_Description()).get(0)
                                   .replace("{safety goal}", safetyDesc);
    scenarioGoal.setAttribute(types.getArgumentElement_Description(), scenarioDesc);
    // run query and process results
    var modelPath = MIDDialogs.selectFile("Run Product Line analysis", "Select a Product Line model",
                                          "There are no Product Line models in the workspace", Set.of("productline"));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    resultGoal.delete();
    for (var supportedBy : resultGoal.getReference(types.getSupporter_Supports())) {
      supportedBy.delete();
    }
    var filesDesc = filesCtx.getAttribute(types.getArgumentElement_Description()).get(0)
                            .replace("{query}", querySpec.query().toString())
                            .replace("{model}", FileUtils.getLastSegmentFromPath(modelPath));
    filesCtx.setAttribute(types.getArgumentElement_Description(), filesDesc);
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
      plTemplate.addReference(types.getTemplate_Elements(), resultGoal, pc);
      builder.addSupporter(resultStrategy, resultGoal);
      i++;
    }
    resultCtx.setAttribute(types.getArgumentElement_Description(), resultCtxDesc);
  }
}
