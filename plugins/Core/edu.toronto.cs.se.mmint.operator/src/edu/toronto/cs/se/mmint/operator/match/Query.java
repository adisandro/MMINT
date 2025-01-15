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
  protected In in;
  protected Out out;
  private IQueryTrait reasoner;
  private String queryPath;
  private String queryName;

  protected static class In {
    public final static String PROP_REASONERNAME = "reasonerName";
    public final static String PROP_QUERYPATH = "queryPath";
    public final static String PROP_QUERYNAME = "queryName";
    public final static String MODEL = "model";
    public Model model;

    public In(Map<String, Model> inputsByName) {
      this.model = inputsByName.get(In.MODEL);
    }
  }

  protected static class Out {
    public final static String PROP_TIMEQUERY = "timeQuery";
    public final static String PROP_NUMRESULTS = "numResults";
    public Query operator;
    public Properties props;
    public long timeQuery;
    public int numResults;

    public Out(Query operator) {
      this.operator = operator;
      this.props = new Properties();
      this.timeQuery = 0;
      this.numResults = 0;
    }

    public Map<String, Model> packed() throws Exception {
      this.props.setProperty(Out.PROP_TIMEQUERY, String.valueOf(this.timeQuery));
      this.props.setProperty(Out.PROP_NUMRESULTS, String.valueOf(this.numResults));
      MIDOperatorIOUtils.writeOutputProperties(this.operator, this.props);

      return Map.of();
    }
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.in = new In(inputsByName);
    this.out = new Out(this);
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    this.queryPath = MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_QUERYPATH);
    this.queryName = MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_QUERYNAME);
    this.reasoner = (IQueryTrait) MMINT.getReasoner(
      MIDOperatorIOUtils.getStringProperty(inputProperties, In.PROP_REASONERNAME));
  }

  protected void runQuery() throws Exception {
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
