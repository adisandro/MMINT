/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner;

/**
 * The specification of a reasoning trait to manage product line features.
 *
 * @author Alessio Di Sandro
 */
public interface IProductLineFeaturesTrait extends ISATReasoner {

  interface AggregatorLambda {
    Object aggregate(Object a, Object b);
  }

  enum Aggregator {
    COUNT((a, b) -> (int) a + (int) b),
    MIN((a, b) -> {
      if (!(a instanceof Comparable aa) || !(b instanceof Comparable bb)) {
        throw new IllegalArgumentException(a + " and " + b + " are not comparable");
      }
      return (aa.compareTo(bb) <= 0) ? aa : bb;
    }),
    MAX((a, b) -> {
      if (!(a instanceof Comparable aa) || !(b instanceof Comparable bb)) {
        throw new IllegalArgumentException(a + " and " + b + " are not comparable");
      }
      return (aa.compareTo(bb) >= 0) ? aa : bb;
    }),
    SUM((a, b) -> (int) a + (int) b);
    public AggregatorLambda lambda;
    Aggregator(AggregatorLambda lambda) {
      this.lambda = lambda;
    }
  }

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

  /**
   * Assigns boolean values to all features contained in a product line formula.
   *
   * @param plFormula
   *          A feature constraint or a presence condition.
   * @param featureValues
   *          The boolean values already assigned to features.
   * @param random
   *          A random generator. If null, the same assignment may be returned for the same product line formula.
   * @return An optional assignment of features to their boolean values (possibly including some of the values already
   *         assigned before the call), empty if the product line formula in unsatisfiable.
   */
  Optional<Map<String, Boolean>> assignFeatures(String plFormula, Map<String, Boolean> featureValues,
                                                @Nullable Random random);

  default Map<String, Map<Set<Object>, Object>> aggregate(Set<String> presenceConditions, String featuresConstraint,
                                                          Set<Object> aggregatedMatch, Object aggregatedValue,
                                                          Aggregator aggregator,
                                                          Map<String, Map<Set<Object>, Object>> aggregations)
                                                            throws Exception {
    return Map.of();
  }

  default Map<String, Map<Set<Object>, Object>> aggregate(String featuresConstraint,
                                                          Map<Map<Set<Object>, Object>, Set<String>> aggregationsByValue)
                                                            throws Exception {
    return Map.of();
  }
}
