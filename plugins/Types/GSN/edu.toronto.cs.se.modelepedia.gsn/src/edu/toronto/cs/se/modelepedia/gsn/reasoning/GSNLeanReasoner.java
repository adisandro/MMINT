/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;

public class GSNLeanReasoner extends LeanReasoner implements IDecompositionTrait {

  @Override
  public String getName() {
    return "Lean2";
  }
}
