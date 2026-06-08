/*******************************************************************************
 * Copyright (c) 2023, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.operators.lift;

import java.util.Map;
import java.util.Properties;

import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.operator.match.Query;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class PLQuery extends Query {
  public final static OperatorParameter IN0 = Query.IN0.specialize(PLPackage.eNS_URI);

  public final static String PROP_TIMESAT = "timeSat";
  protected long timeSat;
  public final static String PROP_SATCALLS = "satCalls";
  protected int satCalls;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws Exception {
    super.init(inputProperties, inputsByName);
    this.timeSat = 0;
    this.satCalls = 0;
  }

  @Override
  protected void runQuery() throws Exception {
    var pl = (ProductLine) super.model;
    var satReasoner = pl.getReasoner();
    satReasoner.toggleStats(true);
    super.runQuery();
    var satStats = satReasoner.getStats();
    this.timeSat = satStats.time();
    this.satCalls = satStats.numCalls();
    satReasoner.toggleStats(false);
  }

  @Override
  protected void setOutputProperties(Properties outProps) {
    super.setOutputProperties(outProps);
    outProps.setProperty(PLQuery.PROP_TIMESAT, String.valueOf(this.timeSat));
    outProps.setProperty(PLQuery.PROP_SATCALLS, String.valueOf(this.satCalls));
  }
}
