/**
 * Copyright (c) 2012-2022 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;

/**
 * The specification of a reasoning trait to check model constraints.
 *
 * @author Alessio Di Sandro
 */
public interface IModelConstraintTrait extends IReasoner {

  /**
   * Checks if a constraint is satisfied on a model.
   *
   * @param model
   *          The model.
   * @param constraint
   *          The model constraint.
   * @param constraintLevel
   *          Whether it is a type or instance constraint.
   * @return True if the constraint is satisfied, false otherwise.
   * @throws Exception
   *           If the reasoner fails at evaluating the constraint for any reason (e.g. malformed constraint).
   */
  boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                              throws Exception;
}
