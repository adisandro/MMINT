/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.menu.MMINTLeanMathlibPathMenu;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class LeanReasoner implements IModelConstraintTrait {

  protected final static String ENCODER_ID = "edu.toronto.cs.se.mmint.lean.operators.ToLean";
  protected final static String LEAN_DIR = "lean/";
  protected final static String LEAN_COMMENT = "--";
  private final static String LEAN_PROPERTY = "property.lean";
  private final static String LEAN_CONFIG = "leanpkg.path";
  private final static String LEAN_EXEC = "lean";

  @Override
  public String getName() {
    return "Lean";
  }

  public boolean checkProperty(String encodingFileName, String property, String workingPath) throws Exception {
    var absWorkingPath = FileUtils.prependWorkspacePath(workingPath);
    // write property file
    Files.writeString(Path.of(absWorkingPath, LeanReasoner.LEAN_PROPERTY), property, StandardOpenOption.CREATE);
    // run lean from a shell
    var builder = new ProcessBuilder(LeanReasoner.LEAN_EXEC, encodingFileName);
    builder.redirectErrorStream(true);
    builder.directory(new File(absWorkingPath));
    var process = builder.start();
    var output = new StringBuilder();
    int exitValue;
    Thread readerThread;
    try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      readerThread = new Thread(() -> {
        String line;
        try {
          while ((line = reader.readLine()) != null) {
            output.append(line + System.lineSeparator());
          }
        }
        catch (IOException e) {
          // just terminate
        }
      });
      readerThread.start();
      exitValue = process.waitFor();
    }
    readerThread.join();
    var result = output.toString().trim();
    if (exitValue != 0) {
      throw new MMINTException(result);
    }

    return Boolean.valueOf(result);
  }

  public boolean checkProperty(MIDTypeHierarchy.PolyOperator<ToLean> encoder, String property, String workingPath)
                              throws Exception {
    var absWorkingPath = FileUtils.prependWorkspacePath(workingPath);
    // write lean config file
    var mathlibPath = MMINT.getPreference(MMINTLeanMathlibPathMenu.PREFERENCE_MENU_LEAN_MATHLIB_PATH);
    if (mathlibPath == null) {
      throw new MMINTException("Mathlib path not configured (set it in the MMINT top menu)");
    }
    if (System.getProperty("os.name").startsWith("Windows")) {
      // workaround for Windows absolute paths not recognized in leanpkg.path
      mathlibPath = Paths.get(absWorkingPath).relativize(Paths.get(mathlibPath)).toString();
    }
    var config = """
      builtin_path
      path .
      path\s""" + mathlibPath + File.separator + "src\n" +
      encoder.operator().getImportPaths().stream().map(p -> "path " + p).collect(Collectors.joining("\n"));
    Files.writeString(Path.of(absWorkingPath, LeanReasoner.LEAN_CONFIG), config, StandardOpenOption.CREATE);
    // generate model encoding files
    encoder.operator().setWorkingPath(workingPath);
    var encoded = encoder.operator().startInstance(encoder.inputs(), null, ECollections.emptyEList(), Map.of(), null);
    // when multiple files are created, the first is the one we feed into Lean (i.e. a main)
    var mainEncoding = FileUtils.getLastSegmentFromPath(encoded.getOutputModels().get(0).getUri());

    return checkProperty(mainEncoding, property, workingPath);
  }

  public boolean checkProperty(Model model, String property, String workingPath) throws Exception {
    // find poly encoder
    var encoder = MIDTypeHierarchy.<ToLean>getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));

    return checkProperty(encoder, property, workingPath);
  }

  @Override
  public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                                     throws Exception {
    var workingPath = MMINT.getActiveInstanceMIDFile().getParent().getFullPath().toString() + IPath.SEPARATOR +
                      LeanReasoner.LEAN_DIR;
    var absWorkingPath = FileUtils.prependWorkspacePath(workingPath);
    try {
      // create project dir
      Files.createDirectory(Path.of(absWorkingPath));
      // check property
      return checkProperty(model, constraint.getImplementation(), workingPath);
    }
    finally {
      // clean up generated dir
      FileUtils.deleteDirectory(absWorkingPath, false);
    }
  }
}
