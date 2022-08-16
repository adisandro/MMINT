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
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.Nullable;
import org.logicng.datastructures.Assignment;
import org.logicng.datastructures.Substitution;
import org.logicng.datastructures.Tristate;
import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.logicng.io.parsers.ParserException;
import org.logicng.io.parsers.PropositionalParser;
import org.logicng.solvers.MiniSat;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeatureConstraintTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineQueryTrait.AggregatorLambda;

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
      MMINTException.print(IStatus.WARNING, "Error parsing " + getName() + " formula, returning false", e);
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
      MMINTException.print(IStatus.WARNING, "Error parsing " + getName() + " formula, returning false", e);
      return false;
    }
  }

  @Override
  public Optional<Map<String, Boolean>> assignFeatures(String plFormula, Map<String, Boolean> featureValues,
                                                       @Nullable Random random) {
    var newFeatureValues = new HashMap<String, Boolean>();
    var factory = new FormulaFactory();
    var parser = new PropositionalParser(factory);
    var minisat = MiniSat.miniSat(factory);
    try {
      var formula = parser.parse(plFormula);
      if (!featureValues.isEmpty()) {
        var sub = new Substitution();
        featureValues.forEach((k, v) -> sub.addMapping(factory.variable(k), factory.constant(v)));
        formula = formula.substitute(sub);
      }
      minisat.add(formula);
      var sat = minisat.sat();
      if (sat != Tristate.TRUE) {
        return Optional.empty();
      }
      Assignment assignment;
      if (random != null) {
        var assignments = minisat.enumerateAllModels();
        assignment = assignments.get(random.nextInt(assignments.size()));
      }
      else {
        assignment = minisat.model();
      }
      for (var pos : assignment.positiveVariables()) {
        newFeatureValues.put(pos.name(), true);
      }
      for (var neg : assignment.negativeVariables()) {
        newFeatureValues.put(neg.name(), false);
      }
      return Optional.of(newFeatureValues);
    }
    catch (ParserException e) {
      MMINTException.print(IStatus.WARNING, "Error parsing " + getName() + " formula, returning empty model", e);
      return Optional.empty();
    }
  }

  private void aggregate2(MiniSat minisat, Formula featuresFormula, Formula formula,
                          Map<Set<Object>, Object> currAggregation, Set<Object> aggregatedMatch, Object aggregatedValue,
                          AggregatorLambda aggregator, Map<String, Map<Set<Object>, Object>> newAggregations,
                          boolean positive) {
    minisat.add(featuresFormula);
    minisat.add(formula);
    if (minisat.sat() == Tristate.TRUE) {
      var newAggregation = new HashMap<>(currAggregation);
      if (positive) {
        newAggregation.compute(
          aggregatedMatch, (k, v) -> (v == null) ? aggregatedValue : aggregator.apply(v, aggregatedValue));
      }
      else {
        newAggregation.putIfAbsent(aggregatedMatch, null);
      }
      var otherAggregation = newAggregations.get(formula.toString());
      if (otherAggregation == null) {
        newAggregations.put(formula.toString(), newAggregation);
      }
      else {
        newAggregation.forEach(
          (k, v) -> otherAggregation.merge(k, v, (v1, v2) -> aggregator.apply(v1, v2)));
      }
    }
    minisat.reset();
  }

  @Override
  public Map<String, Map<Set<Object>, Object>> aggregate(Set<String> presenceConditions, String featuresConstraint,
                                                         Set<Object> aggregatedMatch, Object aggregatedValue,
                                                         AggregatorLambda aggregator,
                                                         Map<String, Map<Set<Object>, Object>> aggregations)
                                                           throws ParserException {
    var plFormula = presenceConditions.stream().collect(Collectors.joining(" & "));
    var factory = new FormulaFactory();
    var parser = new PropositionalParser(factory);
    var minisat = MiniSat.miniSat(factory);
    var featuresFormula = parser.parse(featuresConstraint);
    var formula = parser.parse(plFormula);
    var notFormula = factory.not(formula);
    var newAggregations = new HashMap<String, Map<Set<Object>, Object>>();
    if (aggregations.isEmpty()) {
      newAggregations.put(formula.toString(), Map.of(aggregatedMatch, aggregatedValue));
      var emptyPlaceholder = new HashMap<Set<Object>, Object>(1);
      emptyPlaceholder.put(aggregatedMatch, null);
      newAggregations.put(notFormula.toString(), emptyPlaceholder);
      return newAggregations;
    }
    for (var aggregationEntry : aggregations.entrySet()) {
      var currFormula = parser.parse(aggregationEntry.getKey());
      var currAggregation = aggregationEntry.getValue();
      var formula2 = factory.and(formula, currFormula);
      var notFormula2 = factory.and(notFormula, currFormula);
      aggregate2(minisat, featuresFormula, formula2, currAggregation, aggregatedMatch, aggregatedValue, aggregator,
                 newAggregations, true);
      aggregate2(minisat, featuresFormula, notFormula2, currAggregation, aggregatedMatch, aggregatedValue, aggregator,
                 newAggregations, false);
    }

    return newAggregations;
  }
}
