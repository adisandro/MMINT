/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.splc23.operators;

import java.util.Map;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.productline.Class;

public class PLPreload extends OperatorImpl {
  private In in;

  private class In {
    public final static String MODEL = "pl";
    public Model plModel;

    public In(Map<String, Model> inputsByName) {
      this.plModel = inputsByName.get(In.MODEL);
    }
  }

  private void init(Map<String, Model> inputsByName) {
    this.in = new In(inputsByName);
  }

  private void preload() throws Exception {
    for (var modelObj : this.in.plModel.getEMFInstanceRoot().eContents()) {
      if (!(modelObj instanceof Class plClass)) {
        continue;
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName);
    preload();

    return Map.of();
  }
}
