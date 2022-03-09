/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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

import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder;

public class UMLToLean extends ToLean implements IGSNLeanEncoder {

  private final static String LEAN_MAIN_FILE = "main" + ToLean.LEAN_EXT;

  @Override
  public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, GenericElement> genericsByName,
                                            Map<String, Model> inputsByName, MID workflowMID) throws MMINTException {
    var fileModelType = MIDTypeRegistry.<Model>getType(Output.MODEL_TYPE_ID);
    // dynamic lean files as varargs
    for (var i = 0; i < 2; i++) {
      var outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
      var outputModel = fileModelType.createWorkflowInstance(outputModelId, workflowMID);
      var outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
        outputModel, newOperator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
      var fileName = (i == 0) ? UMLToLean.LEAN_MAIN_FILE : inputsByName.get(Input.MODEL).getName();
      var outputName = outputModelEndpoint.getName() + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
      outputModelEndpoint.setName(outputName);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    var workingPath = getWorkingPath() + IPath.SEPARATOR;
    // dynamic lean files generated from the input model
    this.output.leanPaths.add(workingPath + UMLToLean.LEAN_MAIN_FILE);
    this.output.leanPaths.add(workingPath + this.input.model.getName() + ToLean.LEAN_EXT);
    this.leanGenerator = new UMLToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName(), ToLean.LEAN_SANITIZE_REGEXP));
  }

  @Override
  public String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    var modelName = model.getName();
    var encoding =
      "ArchitectureWithContracts.mk\n" +
      modelName + "_ARCH_MODEL\n" +
      property + "\n" +
      "(toMap [\n" +
      String.join(",\n", subProperties) + "\n" +
      "]) (by {auto_all_comps})\n";

    return encoding;
  }
}