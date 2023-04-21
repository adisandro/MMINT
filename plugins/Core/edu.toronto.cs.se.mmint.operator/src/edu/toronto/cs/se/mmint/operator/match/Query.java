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
package edu.toronto.cs.se.mmint.operator.match;

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
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Query extends OperatorImpl {
  private In in;
  private Out out;
  private IQueryTrait reasoner;
  private String queryPath;
  private String queryName;

  private class In {
    public final static String PROP_IN_REASONERNAME = "reasonerName";
    public final static String PROP_IN_QUERYPATH = "queryPath";
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
    public final static String MODEL = "sameModel";
    public long timeQuery;
    public int numResults;
    public MID mid;
    public Model sameModel;

    public Out(In in, Map<String, MID> outputMIDsByName) {
      this.timeQuery = 0;
      this.numResults = 0;
      this.mid = outputMIDsByName.get(Out.MODEL);
      this.sameModel = in.model;
    }

    public Map<String, Model> packed() throws Exception {
      var outProps = new Properties();
      outProps.setProperty(Out.PROP_OUT_TIMEQUERY, String.valueOf(this.timeQuery));
      outProps.setProperty(Out.PROP_OUT_NUMRESULTS, String.valueOf(this.numResults));
      MIDOperatorIOUtils.writeOutputProperties(Query.this, outProps);

      return Map.of(Out.MODEL, this.sameModel);
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.in = new In(inputsByName);
    this.out = new Out(this.in, outputMIDsByName);
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.queryPath = MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_IN_QUERYPATH);
    this.queryName = MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_IN_QUERYNAME);
    this.reasoner = (IQueryTrait) MMINT.getReasoner(
      MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_IN_REASONERNAME));
  }

  private void runQuery() throws Exception {
    var modelRootObj = this.in.model.getEMFInstanceRoot();
    var querySpec = new QuerySpec(this.reasoner, this.queryPath, this.queryName);
    var timeQueryStart = System.nanoTime();
    var queryResults = querySpec.evaluateQuery(modelRootObj, List.of());
    this.out.timeQuery = System.nanoTime() - timeQueryStart;
    this.out.numResults = queryResults.size();
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    runQuery();

    return this.out.packed();
  }
}
