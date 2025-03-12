/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNChangeStep;

public interface IAnalysis {
  default void import_(AnalyticTemplate template, SafetyCase safetyCase) throws Exception {}
  default void instantiate(AnalyticTemplate template) throws Exception {}
  default void validate(AnalyticTemplate template) throws Exception {}
  default List<GSNChangeStep> nextImpactSteps(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    return step.nextSteps();
  }
  default void impact(AnalyticTemplate template, GSNChangeStep step, List<GSNChangeStep> dependencySteps)
                     throws Exception {
    step.baselineImpact(dependencySteps);
  }
  default List<GSNChangeStep> repair(AnalyticTemplate template, GSNChangeStep step) throws Exception {
    return step.nextSteps();
  }
  default boolean runsFirst() {
    return true;
  }
}
