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
package edu.toronto.cs.se.mmint.types.gsn.templates.reasoning;

import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNChangeStep;

public interface IAnalysis {
  default boolean runsFirst() {
    return true;
  }
  default void import_(AnalyticTemplate template, SafetyCase safetyCase) throws Exception {}
  default void instantiate(AnalyticTemplate template) throws Exception {}
  default void validate(AnalyticTemplate template) throws Exception {}
  default List<GSNChangeStep> nextImpactSteps(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    return step.nextSteps();
  }
  default void impact(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    step.baselineImpact();
  }
  default List<GSNChangeStep> nextRepairSteps(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    return step.nextSteps();
  }
  default void repair(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    step.baselineRepair();
  }
  /**
   * Requirements:
   * 1) oldData and newData ordered by the same criterion
   * 2) Underlying template used a decorator to instantiate multiple nodes
   */
  default <T, D extends IAnalysisData<T>> void dataLoop(String methodPrefix, List<D> oldData, List<D> newData,
                                                        Map<String, T> templateElems, Object[] params)
                                                       throws Exception {
    if (newData.isEmpty()) {
      return;
    }
    var dataClass = newData.get(0).getClass();
    var new_ = dataClass.getMethod(methodPrefix + "New", String.class, Map.class, Object[].class);
    var same = dataClass.getMethod(methodPrefix + "Same", IAnalysisData.class, String.class, String.class, Map.class,
                                   Object[].class);
    var del = dataClass.getMethod(methodPrefix + "Del", String.class, Map.class, Object[].class);
    var o = 0; // old results counter
    var n = 0; // new results counter
    while (n < newData.size()) {
      var newDatum = newData.get(n);
      var newSuffix = "." + (n + 1);
      // new result
      if (o >= oldData.size()) {
        new_.invoke(newDatum, newSuffix, templateElems, params);
        n++;
        continue;
      }
      var oldDatum = oldData.get(o);
      var oldSuffix = "." + (o + 1);
      // same result
      if (newDatum.isSame(oldDatum)) {
        same.invoke(newDatum, oldDatum, oldSuffix, newSuffix, templateElems, params);
        o++;
        n++;
      }
      // deleted result
      else if (newDatum.isDel(oldData)) {
        del.invoke(oldDatum, oldSuffix, templateElems, params);
        o++;
      }
      // new result
      else {
        new_.invoke(newDatum, newSuffix, templateElems, params);
        n++;
      }
    }
  }
}
