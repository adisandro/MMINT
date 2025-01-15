/*******************************************************************************
 * Copyright (c) 2022, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.uml.operators;

import java.util.List;
import java.util.Map;

import org.eclipse.uml2.uml.PackageableElement;

import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder;

public class UMLToLean extends ToLean implements IGSNLeanEncoder {

  @Override
  public List<String> getImportPaths() {
    return List.of("Architectural");
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    this.leanGenerator = new UMLToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName(), ToLean.LEAN_SANITIZE_REGEXP));
  }

  @Override
  public String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    var mainClassName = ((org.eclipse.uml2.uml.Model) model.getEMFInstanceRoot()).getPackagedElements().stream()
      .filter(pe -> pe instanceof org.eclipse.uml2.uml.Class clazz &&
                    clazz.getOwnedAttributes().stream()
                      .filter(a -> a instanceof org.eclipse.uml2.uml.Property)
                      .count() > 0)
      .map(PackageableElement::getName)
      .findFirst()
      .orElseThrow();
    var encoding =
      "ArchitectureWithContracts.mk\n" +
      mainClassName + "_ARCH_MODEL\n" +
      property + "\n" +
      "(toMap [\n" +
      String.join(",\n", subProperties) + "\n" +
      "]) (by {auto_all_comps})\n";

    return encoding;
  }
}
