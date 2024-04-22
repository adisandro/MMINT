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

import java.util.List;

import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

public class QueryAnalysis implements IAnalysis {

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
    var scenarioGoal = (Goal) queryStrategy.getSupportedBy().get(2).getTarget();
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
    resultStrategy.getSupportedBy().remove(1);
    filesCtx.setDescription("Query '" + querySpec.query() + "' evaluated on model '" + modelPath + "'");
    filesCtx.getPaths().add(modelPath);
    filesCtx.getPaths().add(querySpec.filePath());
    var resultCtxDesc = (queryResults.isEmpty()) ? "No results" : "Query results:";
    for (var i = 0; i < queryResults.size(); i++) {
      var queryResult = queryResults.get(i);
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, SiriusEvaluateQuery.NAME_PRINTER, null,
                                                               null);
      resultCtxDesc += "\n'" + resultText + "'";
      resultGoal = builder.createGoal(resultId.replace("X", String.valueOf(i)),
                                      resultDesc.replace("{X}", "'" + resultText + "'"));
      templateElems.add(resultGoal);
      builder.addSupporter(resultStrategy, resultGoal);
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  @Override
  public void validate(AnalyticTemplate template) throws Exception {
  }
}
