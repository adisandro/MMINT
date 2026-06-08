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
package edu.toronto.cs.se.mmint.operator.match;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class Query extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("model", MMINTConstants.ROOT_MODEL_URI);
  public EObject model;

  public final static String PROP_QUERYPATH = "queryPath";
  protected String queryPath;
  public final static String PROP_QUERYNAME = "queryName";
  protected String queryName;
  public final static String PROP_REASONERNAME = "reasonerName";
  protected IQueryTrait reasoner;
  public final static String PROP_TIMEQUERY = "timeQuery";
  protected long timeQuery;
  public final static String PROP_NUMRESULTS = "numResults";
  protected int numResults;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws Exception {
    this.model = inputsByName.get(Query.IN0.name()).getEMFInstanceRoot();
    this.queryPath = FileUtils.prependWorkspacePath(
      MIDOperatorIOUtils.getStringProp(inputProperties, Query.PROP_QUERYPATH, Optional.empty()));
    this.queryName = MIDOperatorIOUtils.getStringProp(inputProperties, Query.PROP_QUERYNAME, Optional.empty());
    this.reasoner = (IQueryTrait) MMINT.getReasoner(
      MIDOperatorIOUtils.getStringProp(inputProperties, Query.PROP_REASONERNAME, Optional.empty()));
    this.timeQuery = 0;
    this.numResults = 0;
  }

  protected void runQuery() throws Exception {
    var querySpec = new QuerySpec(this.reasoner, this.queryPath, this.queryName);
    var timeQueryStart = System.nanoTime();
    var queryResults = querySpec.evaluateQuery(this.model, List.of());
    this.timeQuery = System.nanoTime() - timeQueryStart;
    this.numResults = queryResults.size();
  }

  protected void setOutputProperties(Properties outProps) {
    outProps.setProperty(Query.PROP_TIMEQUERY, String.valueOf(this.timeQuery));
    outProps.setProperty(Query.PROP_NUMRESULTS, String.valueOf(this.numResults));
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    runQuery();
    var props = new Properties();
    setOutputProperties(props);
    MIDOperatorIOUtils.writeOutputProperties(this, props);

    return Map.of();
  }
}