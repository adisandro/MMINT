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

import edu.toronto.cs.se.mmint.productline.ProductLine;
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
  public void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step, List<PLGSNChangeStep> dependencySteps)
                    throws Exception {
    var plReasoner = ((ProductLine) plTemplate.eContainer()).getReasoner();
    var templateElems = plTemplate.getElementsById();
    var safetyGoal = templateElems.get("safetyGoal");
    if (safetyGoal == null) {
      safetyGoal = (PLGSNArgumentElement) step.getTrace().stream()
        .filter(t -> t instanceof PLGSNArgumentElement)
        .findFirst()
        .get();
    }
    var prevImpact = safetyGoal.getImpact();
    var satGoal = templateElems.get("satGoal");
    var impactType = ImpactType.REUSE;
    // re-run model checking
    if (prevImpact.get(ImpactType.REVISE).isEmpty()) {
      var filesCtx = templateElems.get("filesCtx");
      var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
      var propertyPath = paths.get(0);
      var modelPath = paths.get(1);
      var resultPath = paths.get(2);
      var result = runFTS4VMC(modelPath, propertyPath);
      var dataKey = getClass().getName() + "_" + modelPath + "_" + propertyPath + "_" + resultPath;
      ChangeStep.getProperties().put(dataKey, result);
      var holds = result.contains("TRUE");
      var oldHolds = satGoal.getAttribute(this.gsn.getArgumentElement_Description()).get(0).contains("holds");
      if (holds != oldHolds) {
        impactType = ImpactType.REVISE;
      }
    }
    // parents should be revised top down, do not re-run model checking but mark to revise
    else  {
      impactType = ImpactType.REVISE;
    }
    satGoal.setImpact(impactType, plReasoner.getTrueLiteral());
    templateElems.get("satSolution").setImpact(impactType, plReasoner.getTrueLiteral());
    templateElems.get("mcStrategy").setImpact(impactType, plReasoner.getTrueLiteral());
    safetyGoal.setImpact(impactType, plReasoner.getTrueLiteral());
    // reuse everything else in the template
    PLGSNChangeStep.setAllImpacts(plTemplate, ImpactType.REUSE);
  }

  @Override
  public List<PLGSNChangeStep> repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    return super.repair(plTemplate, step);
    //TODO nothing to be done, apart from updating holds/does not hold
  }
}
