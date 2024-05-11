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
package edu.toronto.cs.se.mmint.types.gsn.productline.reasoning;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;

public interface IGSNPLAnalysis extends IAnalysis {
  default void import_(GSNPLAnalyticTemplate plTemplate, ProductLine productLine) throws Exception {}
  default void instantiate(GSNPLAnalyticTemplate plTemplate) throws Exception {}
  default void validate(GSNPLAnalyticTemplate plTemplate) throws Exception {}
}
