/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.types.lts.LTSPackage;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder;

public class LTSToLean extends ToLean implements IGSNLeanEncoder {

  private final static String LEAN_EXT = ".lean";
  private final static String LEAN_MAIN_FILE = "main" + LTSToLean.LEAN_EXT;
  private final static String LEAN_BUNDLE_DIR = "lean/";

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
      var fileName = (i == 0) ? LTSToLean.LEAN_MAIN_FILE : inputsByName.get(Input.MODEL).getName();
      var outputName = outputModelEndpoint.getName() + fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
      outputModelEndpoint.setName(outputName);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    var workingPath = getWorkingPath() + IPath.SEPARATOR;
    // dynamic lean files generated from the input model
    super.output.leanPaths.add(workingPath + LTSToLean.LEAN_MAIN_FILE);
    super.output.leanPaths.add(workingPath + this.input.model.getName() + LTSToLean.LEAN_EXT);
    this.leanGenerator = new LTSToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName()));
    // static lean files from this bundle
    var bundlePath = MIDTypeRegistry.getFileBundlePath(this.getMetatype(), LTSToLean.LEAN_BUNDLE_DIR);
    FileUtils.copyDirectory(bundlePath, false, workingPath, true);
  }

  @Override
  public List<PropertyTemplate> getTemplateProperties() {
    var validTypes = Set.of(LTSPackage.eINSTANCE.getLabeledElement());
    var x = new PropertyVariable("X", validTypes);
    var y = new PropertyVariable("Y", validTypes);
    var a = new PropertyVariable("A", validTypes);
    var b = new PropertyVariable("B", validTypes);
    var absent1 = new PropertyTemplate("absent.globally (coe X)",
                                       "X must not happen",
                                       "Absence", List.of(x));
    var absent2 = new PropertyTemplate("absent.before (coe X) (coe A)",
                                       "X must not happen before A",
                                       "Absence", List.of(x, a));
    var absent3 = new PropertyTemplate("absent.after (coe X) (coe B)",
                                       "X must not happen after B",
                                       "Absence", List.of(x, b));
    var absent4 = new PropertyTemplate("absent.between (coe X) (coe A) (coe B)",
                                       "X must not happen between A and B",
                                       "Absence", List.of(x, a, b));
    var absent5 = new PropertyTemplate("absent.after_until (coe X) (coe A) (coe B)",
                                       "X must not happen after A and until B",
                                       "Absence", List.of(x, a, b));
    var exist1  = new PropertyTemplate("exist.globally (coe X)",
                                       "X must happen",
                                       "Existence", List.of(x));
    var exist2  = new PropertyTemplate("exist.before (coe X) (coe A)",
                                       "X must happen before A",
                                       "Existence", List.of(x, a));
    var exist3  = new PropertyTemplate("exist.after (coe X) (coe B)",
                                       "X must happen after B",
                                       "Existence", List.of(x, b));
    var exist4  = new PropertyTemplate("exist.between (coe X) (coe A) (coe B)",
                                       "X must happen between A and B",
                                       "Existence", List.of(x, a, b));
    var exist5  = new PropertyTemplate("exist.after_until (coe X) (coe A) (coe B)",
                                       "X must happen after A and until B",
                                       "Existence", List.of(x, a, b));
    var univ1   = new PropertyTemplate("universal.globally (coe X)",
                                       "X and only X must happen",
                                       "Universal", List.of(x));
    var univ2   = new PropertyTemplate("universal.before (coe X) (coe A)",
                                       "X and only X must happen before A",
                                       "Universal", List.of(x, a));
    var univ3   = new PropertyTemplate("universal.after (coe X) (coe B)",
                                       "X and only X must happen after B",
                                       "Universal", List.of(x, b));
    var univ4   = new PropertyTemplate("universal.between (coe X) (coe A) (coe B)",
                                       "X and only X must happen between A and B",
                                       "Universal", List.of(x, a, b));
    var univ5   = new PropertyTemplate("universal.after_until (coe X) (coe A) (coe B)",
                                       "X and only X must happen after A and until B",
                                       "Universal", List.of(x, a, b));
    var prec1   = new PropertyTemplate("precedes.globally (coe X) (coe Y)",
                                       "If Y happens, X must precede Y",
                                       "Precedence", List.of(x, y));
    var prec2   = new PropertyTemplate("precedes.before (coe X) (coe Y) (coe A)",
                                       "If Y happens before A, X must precede Y",
                                       "Precedence", List.of(x, y, a));
    var prec3   = new PropertyTemplate("precedes.after (coe X) (coe Y) (coe B)",
                                       "If Y happens after B, X must precede Y",
                                       "Precedence", List.of(x, y, b));
    var prec4   = new PropertyTemplate("precedes.between (coe X) (coe Y) (coe A) (coe B)",
                                       "If Y happens between A and B, X must precede Y",
                                       "Precedence", List.of(x, y, a, b));
    var prec5   = new PropertyTemplate("precedes.after_until (coe X) (coe Y) (coe A) (coe B)",
                                       "If Y happens between A and until B, X must precede Y",
                                       "Precedence", List.of(x, y, a, b));
    var resp1   = new PropertyTemplate("responds.globally (coe Y) (coe X)",
                                       "If X happens, Y must follow X",
                                       "Response", List.of(y, x));
    var resp2   = new PropertyTemplate("responds.before (coe Y) (coe X) (coe A)",
                                       "If X happens before A, Y must follow X",
                                       "Response", List.of(y, x, a));
    var resp3   = new PropertyTemplate("responds.after (coe Y) (coe X) (coe B)",
                                       "If X happens after B, Y must follow X",
                                       "Response", List.of(y, x, b));
    var resp4   = new PropertyTemplate("responds.between (coe Y) (coe X) (coe A) (coe B)",
                                       "If X happens between A and B, Y must follow X",
                                       "Response", List.of(y, x, a, b));
    var resp5   = new PropertyTemplate("responds.after_until (coe Y) (coe X) (coe A) (coe B)",
                                       "If X happens between A and until B, Y must follow X",
                                       "Response", List.of(y, x, a, b));

    return List.of(absent1, absent2, absent3, absent4, absent5,
                   exist1,  exist2,  exist3,  exist4,  exist5,
                   univ1,   univ2,   univ3,   univ4,   univ5,
                   prec1,   prec2,   prec3,   prec4,   prec5,
                   resp1,   resp2,   resp3,   resp4,   resp5);
  }

  private String encodeProperty(String modelName, String property) {
    return "(fun p : path " + modelName + ", sat (" + property + ") p)";
  }

  @Override
  public String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    var modelName = model.getName();
    var encoding =
      "strategy.mk\n" +
      "(Claim.mk\n" +
        "(set.univ)\n" +
        encodeProperty(modelName, property) + "\n" +
      ")\n" +
      "([\n";
    encoding += subProperties.stream()
      .map(p -> encodeProperty(modelName, p))
      .collect(Collectors.joining(",\n"));
    encoding += "\n])\n";

    return encoding;
  }
}
