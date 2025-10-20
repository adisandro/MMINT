/*******************************************************************************
 * Copyright (c) 2022, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.examples.vamos23.operators;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.reasoning.ISATReasoner;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class VAMOS23 extends OperatorImpl {
  private In in;
  private Out out;
  private String queryName;

  private class In {
    public final static String PROP_IN_QUERYNAME = "queryName";
    public final static String MODEL = "model";
    public Model model;

    public In(Map<String, Model> inputsByName) {
      this.model = inputsByName.get(In.MODEL);
    }
  }

  private class Out {
    public final static String PROP_OUT_TIMEQUERY = "timeQuery";
    public final static String PROP_OUT_NUMRESULTS = "numResults";
    public final static String PROP_OUT_TIMESAT = "timeSat";
    public final static String PROP_OUT_SATCALLS = "satCalls";
    public long timeQuery;
    public int numResults;
    public long timeSat;
    public int satCalls;

    public Out() {
      this.timeQuery = 0;
      this.numResults = 0;
      this.timeSat = 0;
      this.satCalls = 0;
    }

    public Map<String, Model> packed() throws Exception {
      var outProps = new Properties();
      outProps.setProperty(Out.PROP_OUT_TIMEQUERY, String.valueOf(this.timeQuery));
      outProps.setProperty(Out.PROP_OUT_NUMRESULTS, String.valueOf(this.numResults));
      outProps.setProperty(Out.PROP_OUT_TIMESAT, String.valueOf(this.timeSat));
      outProps.setProperty(Out.PROP_OUT_SATCALLS, String.valueOf(this.satCalls));
      MIDOperatorIOUtils.writeOutputProperties(VAMOS23.this, outProps);

      return Map.of();
    }
  }

  private void init(Map<String, Model> inputsByName) {
    this.in = new In(inputsByName);
    this.out = new Out();
  }

  @Override
  public void readInputProperties(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    this.queryName = MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_IN_QUERYNAME);
  }

  private void vamos23() throws Exception {
    var modelRootObj = this.in.model.getEMFInstanceRoot();
    String reasonerName;
    ISATReasoner satReasoner = null;
    if (modelRootObj instanceof ProductLine plRoot) {
      reasonerName = "Viatra for Product Lines";
      satReasoner = plRoot.getReasoner();
    }
    else {
      reasonerName = "Viatra";
    }
    var queryReasoner = (IQueryTrait) MMINT.getReasoner(reasonerName);
    var querySpec = new QuerySpec(queryReasoner, FileUtils.prependWorkspacePath("/VAMOS23/src/vamos23/evaluation.vql"),
                                  this.queryName);
    if (satReasoner != null) {
      satReasoner.toggleStats(true);
    }
    var timeQueryStart = System.nanoTime();
    var queryResults = querySpec.evaluateQuery(modelRootObj, List.of());
    this.out.timeQuery = System.nanoTime() - timeQueryStart;
    this.out.numResults = queryResults.size();
    if (satReasoner != null) {
      var satStats = satReasoner.getStats();
      this.out.timeSat = satStats.time();
      this.out.satCalls = satStats.numCalls();
      satReasoner.toggleStats(false);
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName);
    vamos23();

    return this.out.packed();
  }
}
