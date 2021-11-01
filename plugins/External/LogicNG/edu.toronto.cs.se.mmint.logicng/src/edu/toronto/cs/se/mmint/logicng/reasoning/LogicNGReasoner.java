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
package edu.toronto.cs.se.mmint.logicng.reasoning;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeatureConstraintTrait;

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
    return Arrays.stream(plFormula.strip().split("[\\s\\(\\)\\|&~]"))
      .filter(v -> !v.isBlank())
      .collect(Collectors.toSet());
  }

  @Override
  public boolean checkConsistency(String featuresConstraint, Set<String> presenceConditions) {
    return false;
  }

  @Override
  public boolean checkConsistency(String plInstantiatedFormula) {
    return false;
  }

}
