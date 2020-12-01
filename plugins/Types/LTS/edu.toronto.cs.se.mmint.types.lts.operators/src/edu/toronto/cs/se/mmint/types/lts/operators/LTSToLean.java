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
package edu.toronto.cs.se.mmint.types.lts.operators;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class LTSToLean extends ToLean {

  private final static String LEAN_EXT = ".lean";
  private final static String LEAN_GEN_FILE = "main" + LTSToLean.LEAN_EXT;
  private final static List<String> LEAN_BUNDLE_FILES = List.of("justification" + LTSToLean.LEAN_EXT,
                                                                "LTS"           + LTSToLean.LEAN_EXT,
                                                                "Meta"          + LTSToLean.LEAN_EXT);
  private final static String LEAN_BUNDLE_DIR = "lean";

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    // dnamic lean files generated from the input model
    super.output.leanPaths.add(getWorkingPath() + File.separator + LTSToLean.LEAN_GEN_FILE);
    super.output.leanPaths.add(getWorkingPath() + File.separator + this.input.model.getName() + LTSToLean.LEAN_EXT);
    // static lean files from this bundle
    for (var LEAN_BUNDLE_FILE : LTSToLean.LEAN_BUNDLE_FILES) {
      var leanPath = getWorkingPath() + File.separator + LEAN_BUNDLE_FILE;
      var bundlePath = MIDTypeRegistry.getFileBundlePath(this.getMetatype(),
                                                         LTSToLean.LEAN_BUNDLE_DIR + File.separator + LEAN_BUNDLE_FILE);
      Files.copy(Path.of(bundlePath), Path.of(FileUtils.prependWorkspacePath(leanPath)),
                 StandardCopyOption.REPLACE_EXISTING);
      super.output.leanPaths.add(leanPath);
    }
    this.leanGenerator = new LTSToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName()));
    /**PLAN:
     * 3a) LTSToLean: Extract the dir if in binary bundle
     * 3b) LTSToLean: Generate modelName.lean + main.lean into the dir + leanpkg.path
     * 3c) LeanReasoner: Write the property into a file
     * 3d) LeanReasoner: cd to the dir
     * 3e) LeanReasoner: Invoke lean binary (native vs trylean path)
     * 3f) LeanReasoner: Clean up afterwards
     * QUESTIONS:
     * - LeanReasoner does not know how the encoding is implemented (one or multiple files), so it'll create a directory
     *   with leanpkg.path, launch ToLean (which must have vararg outputs, or a new Folder output),
     *   create a constraint.lean, and invoke lean on the first output
     * - How to configure where the Lean executable is? (installed vs trylean)
     * - LTSToLean should override the workflow output constraint
     */
  }
}
