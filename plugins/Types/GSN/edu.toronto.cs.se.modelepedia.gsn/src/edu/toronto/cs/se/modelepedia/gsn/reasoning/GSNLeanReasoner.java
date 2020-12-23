/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import java.util.List;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class GSNLeanReasoner extends LeanReasoner implements IGSNDecompositionTrait {

  @Override
  public String getName() {
    return "Lean2";
  }

  private String encodeProperty(String property, String modelName) {
    return "(fun p : path " + modelName + ", sat (" + property + ") p)";
  }

  @Override
  public void validatePropertyDecomposition(Model model, String property, List<String> subProperties) throws Exception {
    var modelName = model.getName();
    var encoding =
      "strategy.mk\n" +
      "(Claim.mk\n" +
        "(set.univ)\n" +
        encodeProperty(property, modelName) + "\n" +
      ")\n" +
      "([\n";
    encoding += subProperties.stream()
      .map(p -> encodeProperty(p, modelName))
      .collect(Collectors.joining(",\n"));
    encoding += "\n])\n";
    var workingPath = FileUtils.replaceLastSegmentInPath(model.getUri(), LeanReasoner.LEAN_DIR);
    var valid = checkProperty(model, encoding, workingPath);
    if (!valid) {
      throw new MMINTException("The property decomposition is not valid");
    }
  }
}
