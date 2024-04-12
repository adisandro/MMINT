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
package fm24;

import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusEvaluateQuery;
import edu.toronto.cs.se.mmint.types.gsn.templates.impl.AnalysisRunnerImpl;

public class QueryAnalysis extends AnalysisRunnerImpl {

  @Override
  public void instantiate() throws Exception {
    var querySpec = SiriusEvaluateQuery.selectQuery(null);
  }

  @Override
  public void validate() throws Exception {
  }
}
