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
package edu.toronto.cs.se.modelepedia.gsn.operator;

import java.util.Map;

import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNToSocrates extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("gsn", GSNPackage.eNS_URI);
  public final static OperatorParameter OUT0 = new OperatorParameter("json", FilePackage.eNS_URI, "json", null);

  private void convert() throws Exception {
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    convert();

    return outputFromInput(0, 0, inputsByName, outputMIDsByName);
  }
}
