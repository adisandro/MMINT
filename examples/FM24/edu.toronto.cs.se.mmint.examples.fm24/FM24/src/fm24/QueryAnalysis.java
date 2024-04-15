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
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.GSNPLBuilder;
import edu.toronto.cs.se.mmint.types.gsn.templates.AnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisRunnerImpl;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
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
    // run query and process results
    var modelPath = MIDDialogs.selectModelToImport(false);
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    templateElems.remove(resultGoal);
    safetyCase.getGoals().remove(resultGoal);
    queryStrategy.getSupportedBy().remove(1);
    queryCtx.setDescription("Query '" + querySpec.query() + "' applied on model '" + modelPath + "'");
    var resultCtxDesc = (queryResults.isEmpty()) ? "No results" : "Query results:\n";
    for (var i = 0; i < queryResults.size(); i++) {
      var queryResult = queryResults.get(i);
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, null, null);
      resultCtxDesc += "'" + resultText + "'";
      resultGoal = builder.createGoal("G" + (i+2), resultDesc.replace("{For each scenario in Ctx1}",
                                                                      "Query result '" + resultText + "'"));
      resultGoal.setValid(false);
      templateElems.add(resultGoal);
      builder.addSupporter(queryStrategy, resultGoal);
    }
    resultCtx.setDescription(resultCtxDesc);
  }

  public void instantiate(GSNPLTemplate template) throws Exception {
    var types = GSNPackage.eINSTANCE;
    // get template elems
    var productLine = (ProductLine) template.eContainer();
    var builder = new GSNPLBuilder(productLine);
    var queryStrategy = template.getStreamOfReference(types.getTemplate_Elements())
      .filter(c -> c.getType() == types.getStrategy())
      .findFirst().get();
    var queryCtx = queryStrategy
      .getReference(types.getContextualizable_InContextOf()).get(0)
      .getReference(types.getInContextOf_Context()).get(0);
    var resultCtx = queryStrategy
      .getReference(types.getContextualizable_InContextOf()).get(1)
      .getReference(types.getInContextOf_Context()).get(0);
    var resultGoal = (GSNPLArgumentElement) queryStrategy
      .getReference(types.getSupportable_SupportedBy()).get(1)
      .getReference(types.getSupportedBy_Target()).get(0);
    var resultDesc = resultGoal.getAttribute(types.getArgumentElement_Description()).get(0);
    // run query and process results
    var modelPath = MIDDialogs.selectFile("", "", "", Set.of("productline"));
    var rootModelObj = FileUtils.readModelFile(modelPath, null, true);
    var querySpec = SiriusEvaluateQuery.selectQuery(rootModelObj);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    resultGoal.delete();
    for (var supportedBy : resultGoal.getReference(types.getSupporter_Supports())) {
      supportedBy.delete();
    }
    queryCtx.setAttribute(types.getArgumentElement_Description(),
                          "Query '" + querySpec.query() + "' applied on model '" + modelPath + "'");
    var resultCtxDesc = (queryResults.isEmpty()) ? "No results" : "Query results:\n";
    for (var i = 0; i < queryResults.size(); i++) {
      var queryResult = queryResults.get(i);
      var resultText = SiriusEvaluateQuery.queryResultToString(queryResult, null, null);
      resultCtxDesc += "'" + resultText + "'";
      resultGoal = builder.createGoal("G" + (i+2), resultDesc.replace("{For each scenario in Ctx1}",
                                                                      "Query result '" + resultText + "'"));
      resultGoal.setAttribute(types.getArgumentElement_Valid(), "false");
      template.addReference(types.getTemplate_Elements(), resultGoal);
      builder.addSupporter(null, resultGoal);
    }
    resultCtx.setAttribute(types.getArgumentElement_Description(), resultCtxDesc);
  }

  @Override
  public void validate(AnalysisTemplate template) throws Exception {
  }
}
