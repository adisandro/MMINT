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

import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;

public class GSNLeanReasoner extends LeanReasoner implements IDecompositionTrait {

  @Override
  public String getName() {
    return "Lean2";
  }

  private String encodeProperty(String property, String modelName) {
    return "(fun p : path " + modelName + ", sat (" + property + ") p)";
  }

  @Override
  public void validatePropertyDecomposition(Model model, String property, List<String> subProperties) throws Exception {
    /**TODO
     * Pass model or root element?
     * invoke checkModelConstraint or decouple portion of it?
     */
    var modelName = model.getName();
    var encoding =
      "strategy.mk" +
      "(Claim.mk" +
        "(set.univ)" +
        encodeProperty(property, modelName) +
      ")" +
      "([";
    for (var subProperty : subProperties) {
      encoding += encodeProperty(subProperty, modelName);
    }
    encoding += ")]";
    var constraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
    constraint.setLanguage(getName());
    constraint.setImplementation(encoding);
    checkModelConstraint(model, constraint, MIDLevel.INSTANCES);
  }
}
