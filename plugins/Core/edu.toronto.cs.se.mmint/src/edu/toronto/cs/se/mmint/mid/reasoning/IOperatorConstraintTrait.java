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

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The specification of a reasoning trait to check operator constraints.
 *
 * @author Alessio Di Sandro
 */
public interface IOperatorConstraintTrait {

  /**
   * Checks if a generic type is allowed for an operator type. This is used if there are cases when formal generic
   * parameter compliance alone ({@link edu.toronto.cs.se.mmint.mid.operator.Operator#selectAllowedGenerics(EList)})
   * is not enough.
   *
   *@param constraint The operator constraint.
   * @param genericTypeEndpoint
   *            The generic type endpoint.
   * @param genericType
   *            The generic type.
   * @param inputs
   *            The list of inputs.
   * @return True if the generic is allowed, false otherwise.
   */
  boolean checkOperatorGenericConstraint(ExtendibleElementConstraint constraint, GenericEndpoint genericTypeEndpoint,
                                         GenericElement genericType, List<OperatorInput> inputs);

  /**
   * Checks if all input models together, already individually validated as actual parameters, are allowed by an
   * operator type. This is used if there are cases when formal parameter compliance alone
   * ({@link edu.toronto.cs.se.mmint.mid.operator.Operator#checkAllowedInputs(EList)}) is not enough.
   *
   *@param constraint The operator constraint.
   * @param inputsByName
   *            The input model instances, identified by their formal parameter name.
   * @return True if the input models are allowed, false otherwise.
   */
  boolean checkOperatorInputConstraint(ExtendibleElementConstraint constraint, Map<String, Model> inputsByName);

  /**
   * Gets the models that should be the endpoints for each output model relationship of an operator instance. This is
   * used to create the model endpoints of model relationship outputs when creating a workflow, or to validate that
   * the model relationship outputs of an operator instance are valid after running it.
   * @param The operator constraint.
   * @param genericsByName
   *            The generics, identified by their formal name.
   * @param inputsByName
   *            The input model instances, identified by their formal parameter name or workflow variable name.
   * @param outputsByName
   *            The output model instances, identified by their formal parameter name or workflow id.
   *
   * @return A map of output model relationships and their endpoint models.
   */
  Map<ModelRel, List<Model>> getOperatorOutputConstraints(ExtendibleElementConstraint constraint,
                                                          Map<String, GenericElement> genericsByName,
                                                          Map<String, Model> inputsByName,
                                                          Map<String, Model> outputsByName);
}
