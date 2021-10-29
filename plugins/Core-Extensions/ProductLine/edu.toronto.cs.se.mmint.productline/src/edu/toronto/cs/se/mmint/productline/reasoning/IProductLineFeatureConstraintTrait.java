/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.reasoning;

import java.util.Set;

import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;

/**
 * The specification of a reasoning trait to check product line feature constraints.
 *
 * @author Alessio Di Sandro
 */
public interface IProductLineFeatureConstraintTrait extends IReasoner {

  /**
   * Gets the set of features from a product line formula.
   *
   * @param plFormula
   *          A feature constraint or a presence condition.
   * @return The set of features that are used in the formula.
   */
  Set<String> getFeatures(String plFormula);

  /**
   * Checks whether a set of presence conditions are consistent with a constraint on features, i.e. can be in the same
   * product.
   *
   * @param featuresConstraint
   *          The constraint on features.
   * @param presenceConditions
   *          The set of presence conditions to check.
   * @return True if the consistency check is satisfied, false otherwise.
   */
  boolean checkConsistency(String featuresConstraint, Set<String> presenceConditions);

  /**
   * Checks whether an instantiated product line formula is consistent, i.e. is logically satisfiable.
   *
   * @param plInstantiatedFormula
   *          A feature constraint or a presence condition, where all features have been replaced with a true or false
   *          value.
   * @return True if the consistency check is satisfied, false otherwise.
   */
  boolean checkConsistency(String plInstantiatedFormula);
}
