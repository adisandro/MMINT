/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.simulink.operators;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.AnnotateSlice;
import hu.bme.mit.massif.simulink.SimulinkElement;
import hu.bme.mit.massif.simulink.SimulinkModel;

public class SimulinkAnnotateSlice extends AnnotateSlice {

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    super.init(inputsByName, outputMIDsByName);
    this.output.annotatedPath = FileUtils.replaceFileExtensionInPath(this.output.annotatedPath, "m");
  }

  @Override
  protected void annotate() throws Exception {
    var simulinkRoot = (SimulinkModel) this.input.model.getEMFInstanceRoot();
    var filePath = FileUtils.prependWorkspacePath(this.output.annotatedPath);
    try (var buffer = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"))) {
      buffer.write("sl_refresh_customizations;\n");
      buffer.write("r = ReachCoreach('" + simulinkRoot.getSimulinkRef().getName() + "');\n");
      buffer.write("r.clear();\n");
      var simulinkIds = this.input.sliceRel.getMappingRefs().stream()
        .flatMap(mr -> mr.getModelElemEndpointRefs().stream())
        .map(meer -> ((SimulinkElement) meer.getModelElemRef().getObject().getEMFInstanceObject()).getSimulinkRef())
        .map(sr -> "'" + sr.getQualifier() + "/" + sr.getName() + "'")
        .collect(Collectors.joining(","));
      buffer.write("r.reachAll({" + simulinkIds + "}, []);\n");
    }
  }
}
