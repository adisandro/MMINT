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

import java.util.Map;
import java.util.Set;

import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineQueryTrait.Aggregator;

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
   * Checks whether a set of presence conditions are consistent with a constraint on features, i.e. if they can be in
   * the same product.
   *
   * @param featuresConstraint
   *          The constraint on features.
   * @param presenceConditions
   *          The set of presence conditions to check.
   * @return True if the consistency check is satisfied, false otherwise.
   */
  boolean checkConsistency(String featuresConstraint, Set<String> presenceConditions);

  /**
   * Checks whether a product line formula is consistent when all features are replaced with a true or false value, i.e.
   * if it is logically satisfiable.
   *
   * @param plFormula
   *          A feature constraint or a presence condition.
   * @param featureValues
   *          The features to be replaced with a true or false value.
   * @return True if the consistency check is satisfied, false otherwise.
   */
  boolean checkConsistency(String plFormula, Map<String, Boolean> featureValues);

  default Map<String, Map<Set<Object>, Integer>> aggregate(Set<String> presenceConditions, String featuresConstraint,
                                                           Set<Object> aggregationGroup, int aggregatedValue,
                                                           Aggregator aggregator,
                                                           Map<String, Map<Set<Object>, Integer>> aggregations)
                                                             throws Exception {
    return Map.of();
  }
}
