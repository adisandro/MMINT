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
import java.util.Set;

import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisRunnerImpl;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

public class QueryAnalysis extends AnalysisRunnerImpl {

  @Override
  public void instantiate(AnalysisTemplate template) throws Exception {
    // get template elems
    var safetyCase = (SafetyCase) template.eContainer();
    var builder = new GSNTemplatesBuilder(safetyCase);
    var templateElems = template.getElements();
    var queryStrategy = template.getElements().stream()
      .filter(Strategy.class::isInstance)
      .map(Strategy.class::cast)
      .findFirst().get();
    var queryCtx = queryStrategy.getInContextOf().get(0).getContext();
    var resultCtx = queryStrategy.getInContextOf().get(1).getContext();
    var resultGoal = queryStrategy.getSupportedBy().get(1).getTarget();
    var resultDesc = resultGoal.getDescription();
    templateElems.remove(resultGoal);
    safetyCase.getGoals().remove(resultGoal);
    queryStrategy.getSupportedBy().remove(1);
    // run query and process results
    var querySpec = SiriusEvaluateQuery.selectQuery(null);
    var modelPath = MIDDialogs.selectModelToImport(false);
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    queryCtx.setDescription("Query " + querySpec.query() + " on model " + modelPath);
    var resultCtxDesc = "";
    for (var i = 0; i < queryResults.size(); i++) {
      var queryResult = queryResults.get(i);
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, Set.of(), Set.of());
      resultCtxDesc += resultText;
      resultGoal = builder.createGoal("G" + (i+2), resultDesc.replace("For each scenario in Ctx1", resultText));
      templateElems.add(resultGoal);
      builder.addSupporter(queryStrategy, resultGoal);
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  @Override
  public void validate(AnalysisTemplate template) throws Exception {
  }
}
