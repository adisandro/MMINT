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

import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

public class FTS4VMCAnalysis2 extends FTS4VMCAnalysis {

  @Override
  public List<PLGSNChangeStep> impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    var templateElems = plTemplate.getElementsById();
    var prevImpact = step.getPreviousImpact();
    // re-run model checking
    if (prevImpact.get(ImpactType.REUSE).isPresent() || prevImpact.get(ImpactType.RECHECK).isPresent()) {

    }
    // parents should be revised, do not re-run model checking but mark as revise
    else if (prevImpact.get(ImpactType.REVISE).isPresent()) {

    }
    var filesCtx = templateElems.get("filesCtx");
    var paths = filesCtx.getManyAttribute(GSNTemplatesPackage.eINSTANCE.getFilesContext_Paths()).get(0);
    var propertyPath = paths.get(0);
    var modelPath = paths.get(1);
    var satGoal = templateElems.get("satGoal");
    var satSolution = templateElems.get("satSolution");
    //TODO regen model dot/vmc file, shell script
    //TODO impact starting from this very template: re-run model checking
    //TODO prev impact = reuse/recheck: re-run model checking
    //TODO prev impact = revise: don't re-run, mark as revise
    return super.impact(plTemplate, step);
  }

  @Override
  public List<PLGSNChangeStep> repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    return super.repair(plTemplate, step);
    //TODO nothing to be done, really, apart from updating holds/does not hold
  }
}
