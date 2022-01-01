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
package edu.toronto.cs.se.mmint.logicng.reasoning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.logicng.datastructures.Substitution;
import org.logicng.datastructures.Tristate;
import org.logicng.formulas.FormulaFactory;
import org.logicng.io.parsers.ParserException;
import org.logicng.io.parsers.PropositionalParser;
import org.logicng.solvers.MiniSat;

import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeatureConstraintTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineQueryTrait.Aggregator;

public class LogicNGReasoner implements IProductLineFeatureConstraintTrait {

  @Override
  public String getName() {
    return "LogicNG";
  }

  @Override
  public Set<String> getFeatures(String plFormula) {
    if (plFormula.isBlank()) {
      return Set.of();
    }
    return Arrays.stream(plFormula.strip().split("[\\s\\(\\)\\|&~]|\\b(?:true)\\b"))
      .filter(v -> !v.isBlank())
      .collect(Collectors.toSet());
  }

  @Override
  public boolean checkConsistency(String featuresConstraint, Set<String> presenceConditions) {
    var factory = new FormulaFactory();
    var parser = new PropositionalParser(factory);
    var minisat = MiniSat.miniSat(factory);
    try {
      minisat.add(parser.parse(featuresConstraint));
      for (var presenceCondition : presenceConditions) {
        minisat.add(parser.parse(presenceCondition));
      }
      return minisat.sat() == Tristate.TRUE;
    }
    catch (ParserException e) {
      return false;
    }
  }

  @Override
  public boolean checkConsistency(String plFormula, Map<String, Boolean> featureValues) {
    var factory = new FormulaFactory();
    var parser = new PropositionalParser(factory);
    var minisat = MiniSat.miniSat(factory);
    try {
      var formula = parser.parse(plFormula);
      var sub = new Substitution();
      featureValues.forEach((k, v) -> sub.addMapping(factory.variable(k), factory.constant(v)));
      formula = formula.substitute(sub);
      minisat.add(formula);

      return minisat.sat() == Tristate.TRUE;
    }
    catch (ParserException e) {
      return false;
    }
  }

  @Override
  public Map<String, Map<Set<Object>, Integer>> aggregate(Set<String> presenceConditions, String featuresConstraint,
                                                          Set<Object> aggregationGroup, int aggregatedValue,
                                                          Aggregator aggregator,
                                                          Map<String, Map<Set<Object>, Integer>> aggregations)
                                                            throws ParserException {
    var plFormula = presenceConditions.stream().collect(Collectors.joining(" & "));
    var factory = new FormulaFactory();
    var parser = new PropositionalParser(factory);
    var minisat = MiniSat.miniSat(factory);
    var featuresFormula = parser.parse(featuresConstraint);
    var formula = parser.parse(plFormula);
    var notFormula = factory.not(formula);
    var newAggregations = new HashMap<String, Map<Set<Object>, Integer>>();
    if (aggregations.isEmpty()) {
      newAggregations.put(formula.toString(), Map.of(aggregationGroup, aggregatedValue));
      newAggregations.put(notFormula.toString(), Map.of(aggregationGroup, aggregator.emptyValue()));
      return newAggregations;
    }
    for (var aggregationEntry : aggregations.entrySet()) {
      var currFormula = parser.parse(aggregationEntry.getKey());
      var currAggregation = aggregationEntry.getValue();
      var formula2 = factory.and(formula, currFormula);
      var notFormula2 = factory.and(notFormula, currFormula);
      minisat.add(featuresFormula);
      minisat.add(formula2);
      if (minisat.sat() == Tristate.TRUE) {
        var newAggregation = new HashMap<>(currAggregation);
        newAggregation.compute(
          aggregationGroup, (k, v) -> (v == null) ? aggregatedValue : aggregator.aggregate().apply(v, aggregatedValue));
        var otherAggregations = newAggregations.get(formula2.toString());
        if (otherAggregations == null) {
          newAggregations.put(formula2.toString(), newAggregation);
        }
        else {
          newAggregation.forEach(
            (k, v) -> otherAggregations.merge(k, v, (v1, v2) -> aggregator.aggregate().apply(v1, v2)));
        }
      }
      //TODO Is the commented part necessary or is it always filtered out?
//      minisat.reset();
//      minisat.add(featuresFormula);
//      minisat.add(notFormula2);
//      if (minisat.sat() == Tristate.TRUE) {
//        var newAggregation = new HashMap<>(currAggregation);
//        newAggregation.putIfAbsent(aggregationGroup, aggregator.emptyValue());
//        var otherAggregations = newAggregations.get(notFormula2.toString());
//        if (otherAggregations == null) {
//          newAggregations.put(notFormula2.toString(), newAggregation);
//        }
//        else {
//          newAggregation.forEach(
//            (k, v) -> otherAggregations.merge(k, v, (v1, v2) -> aggregator.aggregate().apply(v1, v2)));
//        }
//      }
      minisat.reset();
    }

    return newAggregations;
  }
}
