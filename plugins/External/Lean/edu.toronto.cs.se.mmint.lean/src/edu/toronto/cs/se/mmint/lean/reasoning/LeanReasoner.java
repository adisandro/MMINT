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
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class LeanReasoner implements IModelConstraintTrait {

  private final static String ENCODER_ID = "edu.toronto.cs.se.mmint.lean.operators.ToLean";
  private final static String LEAN_DIR = "lean";
  private final static String LEAN_CONSTRAINT = "constraint.lean";
  private final static String LEAN_CONFIG = "leanpkg.path";
  private final static String LEAN_EXEC = "lean";

  private String generateEncoding(Model model, String workingPath) throws Exception {
    var inputModels = ECollections.newBasicEList(model);
    var encoder = MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID, inputModels);
    var encoderInputs = encoder.checkAllowedInputs(inputModels); //TODO MMINT[JAVA16] Refactor using records
    encoder.setWorkingPath(workingPath);
    var encoded = encoder.startInstance(encoderInputs, null, ECollections.emptyEList(), Map.of(), null);

    // when multiple files are created, the first is the one we feed into Lean (i.e. a main)
    return FileUtils.getLastSegmentFromPath(encoded.getOutputModels().get(0).getUri());
  }

  @Override
  public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                                     throws Exception {
    var workingPath = MMINT.getActiveInstanceMIDFile().getParent().getFullPath().toString() + File.separator +
                      LeanReasoner.LEAN_DIR;
    var absWorkingPath = FileUtils.prependWorkspacePath(workingPath);
    try {
      /**TODO:
       * - Find where is lean's mathlab library (readlink -f $(type -P lean))
       * - Check what is lean's exit value in various cases
       */
      // project dir
      Files.createDirectory(Path.of(absWorkingPath));
      // constraint file
      Files.writeString(Path.of(absWorkingPath, LeanReasoner.LEAN_CONSTRAINT), constraint.getImplementation(),
                        StandardOpenOption.CREATE);
      // package config file
      var config = "builtin_path\npath .\n"; //TODO MMINT[JAVA15] Convert to text block;
      Files.writeString(Path.of(absWorkingPath, LeanReasoner.LEAN_CONFIG), config, StandardOpenOption.CREATE);
      // model encoding files
      var mainEncoding = generateEncoding(model, workingPath);
      // run lean
      var builder = new ProcessBuilder(LeanReasoner.LEAN_EXEC, mainEncoding);
      builder.directory(new File(absWorkingPath));
      var process = builder.start();
      var output = new StringBuilder();
      try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          output.append(line + System.lineSeparator());
        }
      }
      var exitValue = process.waitFor();
      if (exitValue != 0) {
        return false;
      }
      var result = output.toString().trim();
      if (result.equals("true")) {
        return true;
      }
      if (result.equals("false")) {
        return false;
      }
      throw new MMINTException(result);
    }
    finally {
      // clean up generated dir
      FileUtils.deleteDirectory(absWorkingPath, false);
    }
  }

}
