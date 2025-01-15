/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.operator.match.Query;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class PLQuery extends Query {

  protected static class PLOut extends Out {
    public final static String PROP_OUT_TIMESAT = "timeSat";
    public final static String PROP_OUT_SATCALLS = "satCalls";
    public long timeSat;
    public int satCalls;

    public PLOut(Query operator) {
      super(operator);
      this.timeSat = 0;
      this.satCalls = 0;
    }

    @Override
    public Map<String, Model> packed() throws Exception {
      this.props.setProperty(PLOut.PROP_OUT_TIMESAT, String.valueOf(this.timeSat));
      this.props.setProperty(PLOut.PROP_OUT_SATCALLS, String.valueOf(this.satCalls));

      return super.packed();
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.in = new In(inputsByName);
    this.out = new PLOut(this);
  }

  @Override
  protected void runQuery() throws Exception {
    var pl = (ProductLine) this.in.model.getEMFInstanceRoot();
    var satReasoner = pl.getReasoner();
    satReasoner.toggleStats(true);
    super.runQuery();
    var satStats = satReasoner.getStats();
    ((PLOut) this.out).timeSat = satStats.time();
    ((PLOut) this.out).satCalls = satStats.numCalls();
    satReasoner.toggleStats(false);
  }
}
