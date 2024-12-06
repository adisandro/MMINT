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
package edu.toronto.cs.se.mmint.types.gsn.templates.reasoning;

import java.util.List;

import edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.ImpactStep;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.impl.ImpactStepImpl;

public interface IAnalysis {
  default void import_(AnalyticTemplate template, SafetyCase safetyCase) throws Exception {}
  default void instantiate(AnalyticTemplate template) throws Exception {}
  default void validate(AnalyticTemplate template) throws Exception {}
  default List<ImpactStep> impact(AnalyticTemplate template, ImpactStep step, Object change) throws Exception {
    var lastImpactType = step.getTrace().stream()
      .filter(o -> o instanceof ArgumentElement)
      .map(o -> ((ArgumentElement) o).getStatus().getType())
      .findFirst()
      .orElse(ImpactType.RECHECK); //TODO: derive from change
    return ((ImpactStepImpl) step).nextArgumentElements(change, lastImpactType);
  }
  default boolean runsFirst() {
    return true;
  }
}
