/*******************************************************************************
 * Copyright (c) 2024, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.reasoning;

import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.IPLGSNChangeDel;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.IPLGSNChangeNew;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.IPLGSNChangeSame;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNChangeStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;

public interface IPLGSNAnalysis extends IAnalysis {
  default void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {}
  default void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {}
  default void validate(PLGSNAnalyticTemplate plTemplate) throws Exception {}
  default List<PLGSNChangeStep> nextImpactSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                               throws Exception {
    return step.nextSteps();
  }
  default void impact(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    step.baselineImpact();
  }
  default List<PLGSNChangeStep> nextRepairSteps(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step)
                                               throws Exception {
    return step.nextSteps();
  }
  default void repair(PLGSNAnalyticTemplate plTemplate, PLGSNChangeStep step) throws Exception {
    step.baselineRepair();
  }
  default <T> void changeLoop(List<T> oldData, List<T> newData, Map<String, PLGSNArgumentElement> templateElems,
                              BiPredicate<T, T> isSame, BiPredicate<List<T>, T> isDel, IPLGSNChangeNew<T> new_,
                              IPLGSNChangeSame<T> same, IPLGSNChangeDel<T> del, Object[] params) {
    var o = 0; // old results counter
    var n = 0; // new results counter
    while (n < newData.size()) {
      var newDatum = newData.get(n);
      // new result
      if (o >= oldData.size()) {
        new_.change(newDatum, n, templateElems, params);
        n++;
        continue;
      }
      var oldDatum = oldData.get(o);
      // same result
      if (isSame.test(oldDatum, newDatum)) {
        same.change(oldDatum, o, newDatum, n, templateElems, params);
        o++;
        n++;
      }
      // deleted result
      else if (isDel.test(oldData, newDatum)) {
        //TODO VQLQueryAnalysis has a loop here, check if it can be managed by the outer loop
        del.change(oldDatum, o, templateElems, params);
        o++;
      }
      // new result
      else {
        new_.change(newDatum, n, templateElems, params);
        n++;
      }
    }
  }
}
