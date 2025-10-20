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
import java.util.Objects;
import java.util.Optional;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

/**
 * A parameter for an operator type.
 */
public record OperatorParameter(
  String name, String type, int lower, int upper, Optional<String> ext, Optional<String> suffix) {

  public OperatorParameter {
    Objects.requireNonNull(name);
    Objects.requireNonNull(type);
  }

  public OperatorParameter(String name, String type) {
    this(name, type, 1, 1, Optional.empty(), Optional.empty());
  }

  public OperatorParameter(String name, String type, int lower, int upper) {
    this(name, type, lower, upper, Optional.empty(), Optional.empty());
  }

  public OperatorParameter(String name, String type, @Nullable String ext, @Nullable String suffix) {
    this(name, type, 1, 1, Optional.ofNullable(ext), Optional.ofNullable(suffix));
  }

  public OperatorParameter specialize(String type) {
    return new OperatorParameter(name(), type, lower(), upper(), ext(), suffix());
  }

  public static Map<String, Model> outFromIn(Operator operator, int outIndex, int inIndex,
                                             Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName)
                                            throws Exception {
    var outName = MMINTConstants.OPERATORS_OUTPUTS + inIndex;
    var out = (OperatorParameter) operator.getClass().getField(outName).get(operator);
    var inName = MMINTConstants.OPERATORS_INPUTS + inIndex;
    var in = (OperatorParameter) operator.getClass().getField(inName).get(operator);

    // out model type
    var outModelType = MIDTypeRegistry.<Model>getType(out.type());
    if (outModelType == null) {
      throw new MMINTException("Model type " + out.type() + " not found");
    }
    // out path
    var inModel = inputsByName.get(in.name());
    var outModelName = inModel.getName().split("\\.")[0]; // removes file extensions in names, e.g. from File model type
    outModelName += out.suffix().orElse("") + "." + out.ext().orElse(outModelType.getFileExtension());
    var outPath = (operator.getWorkingPath() == null) ?
      FileUtils.replaceLastSegmentInPath(inModel.getUri(), outModelName) :
      operator.getWorkingPath() + IPath.SEPARATOR + outModelName;
    outPath = FileUtils.getUniquePath(outPath, true, false);
    // out model
    var outRoot = (EObject) operator.getClass().getField(outName.toLowerCase()).get(operator);
    var outModel = outModelType.createInstanceAndEditor(outRoot, outPath, outputMIDsByName.get(out.name()));

    return Map.of(out.name(), outModel);
  }
}
