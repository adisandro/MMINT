/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
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

  private void preload() throws MMINTException {
    var modelElemType = MIDTypeHierarchy.getRootModelElementType();
    for (var modelObj : this.in.plModel.getEMFInstanceRoot().eContents()) {
      if (!(modelObj instanceof Class plClass)) {
        continue;
      }
      var modelElemUri = MIDRegistry.getModelElementUri(modelObj) + MMINTConstants.ROLE_SEPARATOR +
                         modelElemType.getUri();
      var eInfo = MIDRegistry.getModelElementEMFInfo(modelObj, MIDLevel.INSTANCES);
      var modelElemName = MIDRegistry.getModelElementName(eInfo, modelObj, MIDLevel.INSTANCES);
      ((ModelElementImpl) modelElemType).createInstance(modelElemUri, modelElemName, eInfo, this.in.plModel);
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
