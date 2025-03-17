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

import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

public class FTS4VMCAnalysis2 extends FTS4VMCAnalysis {

  @Override
  public List<PLGSNChangeStep> nextImpactSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                              throws Exception {
    // leaf template
    return List.of();
  }

  @Override
  public void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    if (safetyGoal == null) {
      // using the forward trace to get safetyGoal does not work with linked templates, so navigate the gsn tree
      safetyGoal = (PLGSNArgumentElement) templateElems.get("mcStrategy")
        .getReference(this.gsn.getSupporter_Supports()).get(0)
        .getReference(this.gsn.getSupportedBy_Source()).get(0);
    }
    var prevImpact = safetyGoal.getImpact();
    var satGoal = templateElems.get("satGoal");
    var satSolution = templateElems.get("satSolution");
    Map<ImpactType, Optional<String>> impactType;
    if (prevImpact.get(ImpactType.REVISE).isPresent()) {
      // parents should be revised top down, do not re-run model checking but mark to revise
      impactType = PLGSNChangeStep.REVISE;
    }
    else if ((boolean) ChangeStep.getData().get(ChangeStep.RUN_EVIDENCE_ANALYSES_KEY)) {
      // re-run model checking
      var filesCtx = templateElems.get("filesCtx");
      var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
      var propertyPath = paths.get(0);
      var modelPath = paths.get(1);
      var resultPath = paths.get(2);
      var result = runFTS4VMC(modelPath, propertyPath);
      var propsKey = getClass().getName() + "_" + modelPath + "_" + propertyPath + "_" + resultPath;
      ChangeStep.getData().put(propsKey, result);
      var holds = result.contains("TRUE");
      var oldHolds = satGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).contains("holds");
      impactType = (holds == oldHolds) ? PLGSNChangeStep.REUSE : PLGSNChangeStep.REVISE;
    }
    else {
      var templateStep = new PLGSNChangeStep(satSolution);
      templateStep.getBackwardTrace().add(List.of());
      templateStep.baselineImpact();
      impactType = satSolution.getImpact();
    }
    satGoal.setImpact(impactType);
    satSolution.setImpact(impactType);
    safetyGoal.setImpact(impactType);
    // reuse everything else in the template
    PLGSNChangeStep.setAllImpacts(plTemplate, PLGSNChangeStep.REUSE);
  }

  @Override
  public List<PLGSNChangeStep> repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    return super.repair(plTemplate, step);
    //TODO nothing to be done, apart from updating holds/does not hold and storing result
  }
}
