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
package edu.toronto.cs.se.mmint.lean.reasoning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;

public class LeanReasoner implements IModelConstraintTrait {

  public final static String EXECUTABLE = "/path/to/lean";
  public final static String FILE = "/path/to/lean/project/temp.lean";

  private String generateEncoding(Model model) throws MMINTException {
    return "";
  }

  @Override
  public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                                     throws Exception {
    var encoding = generateEncoding(model);
    Files.writeString(Paths.get(LeanReasoner.FILE), encoding + "\n" + constraint.getImplementation());
    var builder = new ProcessBuilder(LeanReasoner.EXECUTABLE, LeanReasoner.FILE);
    var process = builder.start();
    var output = new StringBuilder();
    try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + System.lineSeparator());
      }
    }
    var result = process.waitFor();
    if (result != 0) {
      return false;
    }
    if (output.toString().trim().equals("tt")) {
      return true;
    }

    return false;
  }

}
