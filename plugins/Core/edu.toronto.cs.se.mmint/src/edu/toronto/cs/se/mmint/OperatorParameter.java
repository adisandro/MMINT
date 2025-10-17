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

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class OperatorParameter {
  public String name;
  public String type;
  public int lower;
  public int upper;
  public @Nullable String ext;
  public @Nullable String suffix;
  public @Nullable EObject root;
  public @Nullable OperatorParameter superParam;

  public OperatorParameter() {
    this.name = null;
    this.type = null;
    this.lower = 1;
    this.upper = 1;
    this.ext = null;
    this.suffix = null;
    this.root = null;
    this.superParam = null;
  }

  public OperatorParameter(OperatorParameter superParam) {
    this.name = superParam.name;
    this.type = superParam.type;
    this.lower = superParam.lower;
    this.upper = superParam.upper;
    this.ext = superParam.ext;
    this.suffix = superParam.suffix;
    this.root = superParam.root;
    this.superParam = superParam;
  }

  public static Model outFromIn(Operator operator, String outName, String inName, Map<String, Model> inputsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var outParam = (OperatorParameter) operator.getClass().getField(outName).get(operator);
    var inParam = (OperatorParameter) operator.getClass().getField(inName).get(operator);

    return outParam.fromIn(inParam, operator, inputsByName, outputMIDsByName);
  }

  private Model fromIn(OperatorParameter in, Operator operator, Map<String, Model> inputsByName,
                       Map<String, MID> outputMIDsByName) throws Exception {
    /**TODO
     * 0) Properly handle inheritance:
     * 0a) check if mmint creates the right structures (Can I skip the explicit override of params that don't change?)
     * 1) Integrate somewhere in Operator: extract Operator{Parameter|Input|Generic} from model as records
     * 2) Modify readInputProperties to be a more full-fledged initializer of in/out structures: required for inheritance
     * 3) Add automatic cleanup of in/out roots, which are static and thus shared (maybe they should not be in operator param, root is an instance thing)
     */
    // out model type
    var outModelType = MIDTypeRegistry.<Model>getType(this.type);
    if (outModelType == null) {
      throw new MMINTException("Model type " + this.type + " not found");
    }
    // out path
    var inModel = inputsByName.get(in.name);
    var outModelName = inModel.getName().split("\\.")[0]; // removes file extensions in names, e.g. from File model type
    if (this.suffix != null) {
      outModelName += this.suffix;
    }
    outModelName += ".";
    outModelName += (this.ext == null) ? outModelType.getFileExtension() : this.ext;
    var outPath = (operator.getWorkingPath() == null) ?
      FileUtils.replaceLastSegmentInPath(inModel.getUri(), outModelName) :
      operator.getWorkingPath() + IPath.SEPARATOR + outModelName;
    outPath = FileUtils.getUniquePath(outPath, true, false);
    // out model
    var outModel = outModelType.createInstanceAndEditor(this.root, outPath, outputMIDsByName.get(this.name));
    // free the memory
    in.root = null;
    this.root = null;

    return outModel;
  }
}
