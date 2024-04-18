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

import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalysisTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysisRunner;

public interface IGSNPLAnalysisRunner extends IAnalysisRunner {
  void instantiate(GSNPLAnalysisTemplate plTemplate) throws Exception;
  void validate(GSNPLAnalysisTemplate plTemplate) throws Exception;
}
