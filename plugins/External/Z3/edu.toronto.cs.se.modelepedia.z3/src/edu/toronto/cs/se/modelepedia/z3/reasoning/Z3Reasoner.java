/**
 * Copyright (c) 2012-2024 Alessio Di Sandro, Naama Ben-David, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Naama Ben-David - Concretization highlighting.
 */
package edu.toronto.cs.se.modelepedia.z3.reasoning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;
import edu.toronto.cs.se.modelepedia.z3.Z3Solver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

//TODO MMINT[Z3] Support refinement and highlighting for the complex full-MAVO encoding
public class Z3Reasoner implements IModelConstraintTrait, IPLFeaturesTrait {

  @Override
  public String getName() {
    return "Z3";
  }

  @Override
  public String getTrueLiteral() {
    return "true";
  }

  @Override
  public String getFalseLiteral() {
    return "false";
  }

  @Override
  public String getANDSyntax() {
    return "(and ($1) ($2))";
  }

  @Override
  public String getORSyntax() {
    return "(or ($1) ($2))";
  }

  @Override
  public String getNOTSyntax() {
    return "(not ($1))";
  }

  @Override
  public String getIMPLYSyntax() {
    return "(=> ($1) ($2))";
  }

  @Override
  public String getEQUIVSyntax() {
    return "(<=> ($1) ($2))";
  }

  @Override
	public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel) {

    return new Z3Solver().checkSat(Z3Utils.assertion(constraint.getImplementation())).isSAT();
	}

	@Override
  public Set<String> getFeatures(String plFormula) {
    if (plFormula.isBlank()) {
      return Set.of();
    }
    return Arrays.stream(plFormula.strip().split("[\\s\\(\\)]|\\b(?:or|and|not|true|false)\\b"))
      .filter(v -> !v.isBlank())
      .collect(Collectors.toSet());
  }

	@Override
	public boolean checkConsistency(String featuresConstraint, Set<String> presenceConditions) {
    var smtEncoding = "";
    var features = getFeatures(featuresConstraint);
    var smtBody = featuresConstraint + " ";
    var allFeatures = new HashSet<>(features);
    for (var feature : features) {
      smtEncoding += Z3Utils.constant(feature, Z3Utils.SMTLIB_TYPE_BOOL);
    }
    for (var presenceCondition : presenceConditions) {
      smtBody += presenceCondition + " ";
      features = getFeatures(presenceCondition);
      for (var feature : features) {
        if (allFeatures.contains(feature)) {
          continue;
        }
        smtEncoding += Z3Utils.constant(feature, Z3Utils.SMTLIB_TYPE_BOOL);
        allFeatures.add(feature);
      }
    }
    smtEncoding += Z3Utils.assertion(Z3Utils.and(smtBody));

    return new Z3Solver().checkSat(smtEncoding).isSAT();
	}

  @Override
  public boolean checkConsistency(String plFormula, Map<String, Boolean> featureValues) {
    for (var featureValue : featureValues.entrySet()) {
      plFormula = plFormula.replaceAll("\\b" + featureValue.getKey() + "\\b", featureValue.getValue().toString());
    }

    return new Z3Solver().checkSat(Z3Utils.assertion(plFormula)).isSAT();
  }

  @Override
  public Optional<Map<String, Boolean>> assignFeatures(String plFormula, Map<String, Boolean> featureValues,
                                                       @Nullable Random random) {
    //TODO MMINT[PL] Implement
    return Optional.empty();
  }
}
