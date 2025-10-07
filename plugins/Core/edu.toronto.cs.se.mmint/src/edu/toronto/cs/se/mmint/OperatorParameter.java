/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class OperatorParameter {
  public String name;
  public String type;
  public @Nullable String ext;
  public @Nullable String suffix;
  public int lower;
  public int upper;
  public @Nullable EObject root;

  public OperatorParameter() {
    this.name = null;
    this.type = null;
    this.ext = null;
    this.suffix = null;
    this.lower = 1;
    this.upper = 1;
    this.root = null;
  }

  public Model fromIn(OperatorParameter in, Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName)
                     throws Exception {
    //TODO Integrate in Operator
    // out model type
    var modelType = MIDTypeRegistry.<Model>getType(this.type);
    if (modelType == null) {
      throw new MMINTException("Model type " + this.type + " not found");
    }
    // out path
    var ext = this.ext;
    if (ext == null) {
      ext = modelType.getFileExtension();
    }
    var path = FileUtils.replaceFileExtensionInPath(inputsByName.get(in.name).getUri(), ext);
    if (this.suffix != null) {
      path = FileUtils.addFileNameSuffixInPath(path, this.suffix);
    }
    path = FileUtils.getUniquePath(path, true, false);
    // out model
    var model = modelType.createInstanceAndEditor(this.root, path, outputMIDsByName.get(this.name));

    return model;
  }
}
