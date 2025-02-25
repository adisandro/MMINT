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
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNImpactStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

public class VQLQueryAnalysis2 extends VQLQueryAnalysis {

  @Override
  public List<PLGSNImpactStep> impact(PLGSNAnalyticTemplate plTemplate, PLGSNImpactStep step, Object change)
                                     throws Exception {
    var gsn = GSNPackage.eINSTANCE;
    var templateElems = plTemplate.getElementsById();
    var nextSteps = new ArrayList<PLGSNImpactStep>();
    // re-run query on modified model
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var queryFilePath = paths.get(0);
    var modelPath = paths.get(1);
    var query = filesCtx.getAttribute(gsn.getArgumentElement_Description()).get(0).split("'")[1];
    var rootModelObj = FileUtils.readModelFile(modelPath, null, false);
    var plVQLReasoner = (IQueryTrait) MMINT.getReasoner("Viatra for Product Lines");
    var querySpec = new QuerySpec(plVQLReasoner, queryFilePath, query);
    var queryResults = querySpec.evaluateQuery(rootModelObj, List.of());
    // compare results
    var results = getPLResults(queryResults);
    var resultCtx = templateElems.get("resultCtx");
    var oldResults = resultCtx.getAttribute(gsn.getArgumentElement_Description()).get(0).lines()
      .filter(l -> l.startsWith("'"))
      .map(l -> l.substring(1, l.length()-1))
      .collect(Collectors.toList());
    var i = 0;
    var j = 0;
    var deletedResults = false;
    var addedResults = false;
    while (i < results.size()) {
      var result = results.get(i);
      // new result, revise decomposition
      if (j == oldResults.size()) {
        addedResults = true;
        break;
      }
      var oldResult = oldResults.get(j);
      // same result, reuse and continue downstream
      if (oldResult.equals(result.getKey())) {
        //TODO consider possible pc change (result.getValue())
        var resultGoal = templateElems.get("resultGoal" + j);
        var templateTrace = new ArrayList<EObject>();
        templateTrace.add(plTemplate);
        templateTrace.addAll(step.getTrace());
        var templateStep = new PLGSNImpactStep(resultGoal, templateTrace);
        templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(resultGoal),
                                                                        ImpactType.RECHECK, Optional.empty(),
                                                                        ImpactType.REVISE, Optional.empty()));
        nextSteps.addAll(templateStep.nextSupporters());
        j++;
        i++;
      }
      // deleted result, revise downstream
      else if (oldResults.contains(result.getKey())) {
        deletedResults = true;
        while (!oldResult.equals(result.getKey())) {
          var resultGoal = templateElems.get("resultGoal" + j);
          var templateTrace = new ArrayList<EObject>();
          templateTrace.add(plTemplate);
          templateTrace.addAll(step.getTrace());
          var templateStep = new PLGSNImpactStep(resultGoal, templateTrace);
          templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.empty(),
                                                                          ImpactType.RECHECK, Optional.empty(),
                                                                          ImpactType.REVISE, Optional.of(resultGoal)));
          nextSteps.addAll(templateStep.nextSupporters());
          j++;
          oldResult = oldResults.get(j);
        }
      }
      // new result, revise decomposition
      else {
        addedResults = true;
        i++;
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
    for (var plElem : plTemplate.getReference(gsn.getTemplate_Elements())) {
      if (!plElem.getReference(gsn.getArgumentElement_Status()).isEmpty()) {
        continue;
      }
      var templateStep = new PLGSNImpactStep((PLGSNArgumentElement) plElem);
      templateStep.setImpact(templateStep.getCurrentImpacts(), Map.of(ImpactType.REUSE, Optional.of(plElem),
                                                                      ImpactType.RECHECK, Optional.empty(),
                                                                      ImpactType.REVISE, Optional.empty()));
    }

    return nextSteps;
  }

  @Override
  public void repair(PLGSNAnalyticTemplate plTemplate, Object change) throws Exception {
    super.repair(plTemplate, change);
    //TODO: Same result: invoke repair for downstream nodes, it's a problem for the other template
    //TODO: Del result: delete downstream branch and change results (repair)
    //TODO: New result: add downstream branch and change results (repair)
  }
}
