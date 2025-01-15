/*******************************************************************************
 * Copyright (c) 2012, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.operator.constraint;

import java.util.Set;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public abstract class MatchConstraint implements IJavaModelConstraint {

  @Override
  public boolean check(Model model) {
    if (((ModelRel) model).getModelEndpoints().size() < 2) {
      return false;
    }
    Set<String> modelTypeNames = ((ModelRel) model).getModelEndpoints().stream()
      .map(modelEndpoint -> modelEndpoint.getTarget().getMetatypeUri())
      .collect(Collectors.toSet());
    //TODO MMINT[POLY] Use instanceOf when it's optimized (automatic caching of runtime types)
    if (modelTypeNames.size() > 1) {
      return false;
    }
    for (Mapping mapping : ((ModelRel) model).getMappings()) {
      Set<String> modelElemClassNames = mapping.getModelElemEndpoints().stream()
        .map(modelElemEndpoint -> modelElemEndpoint.getTarget().getEInfo().getClassName())
        .collect(Collectors.toSet());
      if (modelElemClassNames.size() > 1) {
        return false;
      }
    }

    return true;
  }
}
