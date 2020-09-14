/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The specification of a reasoning trait to check megamodel constraints.
 *
 * @author Alessio Di Sandro
 */
public interface IConstraintTrait {

  /**
   * Checks if a constraint is satisfied on a model.
   *
   * @param model
   *          The model.
   * @param constraint
   *          The constraint.
   * @return True if the constraint is satisfied, false otherwise.
   */
  boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                              throws Exception;

  boolean checkOperatorGenericConstraint(ExtendibleElementConstraint constraint, GenericEndpoint genericTypeEndpoint,
                                         GenericElement genericType, List<OperatorInput> inputs);

  boolean checkOperatorInputConstraint(ExtendibleElementConstraint constraint, Map<String, Model> inputsByName);

  Map<ModelRel, List<Model>> getOperatorOutputConstraints(ExtendibleElementConstraint constraint,
                                                          Map<String, GenericElement> genericsByName,
                                                          Map<String, Model> inputsByName,
                                                          Map<String, Model> outputsByName);

}
