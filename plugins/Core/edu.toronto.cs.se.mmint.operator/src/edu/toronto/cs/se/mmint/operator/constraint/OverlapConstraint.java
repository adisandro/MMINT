/*******************************************************************************
 * Copyright (c) 2012, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.operator.constraint;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class OverlapConstraint extends MatchConstraint {

  @Override
  public boolean check(Model model) {
    if (!super.check(model)) {
      return false;
    }
    var extraMappings = ((ModelRel) model).getMappings().stream()
      .filter(mapping -> mapping.getMetatypeUri().equals("http://se.cs.toronto.edu/mmint/Overlap2/Mapping2"))
      .count();
    if (extraMappings != 0) {
      return false;
    }

    return true;
  }
}
