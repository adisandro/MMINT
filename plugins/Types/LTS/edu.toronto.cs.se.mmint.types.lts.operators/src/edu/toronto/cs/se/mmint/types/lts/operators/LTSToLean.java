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

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;

public class LTSToLean extends ToLean {

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws IOException {
    super.init(inputsByName, outputMIDsByName);
    this.leanGenerator = new LTSToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName()));
  }
}
