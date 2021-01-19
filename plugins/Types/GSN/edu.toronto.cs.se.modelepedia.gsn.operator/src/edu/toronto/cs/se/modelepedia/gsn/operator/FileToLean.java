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
package edu.toronto.cs.se.modelepedia.gsn.operator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder;

public class FileToLean extends ToLean implements IGSNLeanEncoder {

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      var input = new Input(inputsByName);
      return input.model.getFileExtension().equals(ToLean.LEAN_EXT.substring(1));
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    var modelPath = this.input.model.getUri();
    var modelDir = FileUtils.getAllButLastSegmentFromPath(modelPath);
    var filePath = modelPath;
    var workingPath = getWorkingPath() + IPath.SEPARATOR;
    if (!modelDir.equals(workingPath)) {
      filePath = workingPath + FileUtils.getLastSegmentFromPath(modelPath);
      Files.copy(Paths.get(FileUtils.prependWorkspacePath(modelPath)),
                 Paths.get(FileUtils.prependWorkspacePath(filePath)), StandardCopyOption.REPLACE_EXISTING);
      this.output.leanPaths.add(filePath);
    }
    else {
      this.output.leanModels.add(this.input.model);
    }
  }

  @Override
  public String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    return property + "\n" + String.join("\n", subProperties);
  }
}
