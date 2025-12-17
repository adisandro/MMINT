/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.operators;

import java.util.Map;
import java.util.Properties;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.productline.operators.bridge.ToProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.util.PLGSNBuilder;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNToProductLine extends ToProductLine {
  public final static OperatorParameter IN0 = ToProductLine.IN0.specialize(GSNPackage.eNS_URI);

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    super.init(inputProperties, inputsByName);
    this.builder = new PLGSNBuilder(this.out0);
  }
}
