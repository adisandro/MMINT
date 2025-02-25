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
package edu.toronto.cs.se.mmint.types.gsn.productline.reasoning;

import java.util.List;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNImpactStep;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;

public interface IPLGSNAnalysis extends IAnalysis {
  default void import_(PLGSNAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {}
  default void instantiate(PLGSNAnalyticTemplate plTemplate) throws Exception {}
  default void validate(PLGSNAnalyticTemplate plTemplate) throws Exception {}
  default List<PLGSNImpactStep> impact(PLGSNAnalyticTemplate plTemplate, PLGSNImpactStep step) throws Exception {
    return step.nextSteps();
  }
  default void repair(PLGSNAnalyticTemplate plTemplate) throws Exception {}
}
