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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class LeanReasoner implements IModelConstraintTrait {

  public final static String ENCODER_ID = "edu.toronto.cs.se.mmint.lean.operators.ToLean";
  public final static String EXECUTABLE = "/path/to/lean";
  public final static String FILE = "/path/to/lean/project/temp.lean";

  private String generateEncoding(Model model) throws Exception {
    var abstractEncoder = MIDTypeRegistry.<Operator>getType(LeanReasoner.ENCODER_ID);
    var polyEncoders = MIDTypeHierarchy.getSubtypes(abstractEncoder);
    var polyIter = MIDTypeHierarchy.getInverseTypeHierarchyIterator(polyEncoders);
    var inputModels = ECollections.newBasicEList(model);
    EList<OperatorInput> encoderInputs = null;
    Operator encoder = null;
    while (polyIter.hasNext()) { // start from the most specialized operator backwards
      var polyEncoder = polyIter.next();
      encoderInputs = polyEncoder.checkAllowedInputs(inputModels);
      if (encoderInputs != null) {
        encoder = polyEncoder;
        break;
      }
    }
    if (encoder == null) {
      throw new MMINTException("No Lean encoder available");
    }
    var encoded = encoder.startInstance(encoderInputs, null, ECollections.emptyEList(), Map.of(), null);

    return encoded.getOutputModels().get(0).getUri();
  }

  @Override
  public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
                                     throws Exception {
    var encodingPath = generateEncoding(model);
    Files.writeString(Paths.get(FileUtils.prependWorkspacePath(encodingPath)), constraint.getImplementation(),
                      StandardOpenOption.APPEND);
//    Files.writeString(Paths.get(LeanReasoner.FILE), constraint.getImplementation());
//    var builder = new ProcessBuilder(LeanReasoner.EXECUTABLE, LeanReasoner.FILE);
//    var process = builder.start();
//    var output = new StringBuilder();
//    try (var reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
//      String line;
//      while ((line = reader.readLine()) != null) {
//        output.append(line + System.lineSeparator());
//      }
//    }
//    var result = process.waitFor();
//    if (result != 0) {
//      return false;
//    }
//    if (output.toString().trim().equals("tt")) {
//      return true;
//    }

    return false;
  }

}
