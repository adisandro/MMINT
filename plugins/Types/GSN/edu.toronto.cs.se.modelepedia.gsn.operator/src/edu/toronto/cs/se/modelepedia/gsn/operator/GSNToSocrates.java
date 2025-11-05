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

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.ecore.EObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.OperatorParameter;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class GSNToSocrates extends OperatorImpl {
  public final static OperatorParameter IN0 = new OperatorParameter("gsn", GSNPackage.eNS_URI);
  public SafetyCase in0;
  public final static OperatorParameter OUT0 = new OperatorParameter("json", FilePackage.eNS_URI, "json", null);
  public EObject out0;
  public final static String PROP_OWNER = "owner";
  protected String owner;

  @Override
  public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {
    //TODO change to ask with dialog
    this.owner = MIDOperatorIOUtils.getStringProperty(inputProperties, GSNToSocrates.PROP_OWNER);
    this.in0 = (SafetyCase) inputsByName.get(GSNToSocrates.IN0.name()).getEMFInstanceRoot();
    this.out0 = null; // do not create output model file
  }

  private Integer getNodeId(ArgumentElement elem) {
    return Integer.parseInt(elem.getId().replaceAll("[^\\d]+", ""));
  }

  private JsonObject createRoot(String inName) {
    while (inName.length() <= 2) {
      inName += "_";
    }
    var jsonObj = new JsonObject();
    jsonObj.addProperty("type", "GSN");
    jsonObj.addProperty("name", inName);
    jsonObj.addProperty("owner", this.owner);
    var now = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxx")).toString();
    jsonObj.addProperty("created", now);
    jsonObj.addProperty("modified", now);
    var schema = new JsonObject();
    jsonObj.add("schema", schema);
    schema.addProperty("version", 10);

    return jsonObj;
  }

  private String convert(String inName) throws Exception {
    var jsonObj = createRoot(inName);
    var nodes = new JsonArray();
    jsonObj.add(SocratesToGSN.NODES, nodes);
    for (var iter = this.in0.eAllContents(); iter.hasNext();) {
      if (!(iter.next() instanceof ArgumentElement elem)) {
        continue;
      }
      var elemId = getNodeId(elem);
      var nodeObj = new JsonObject();
      nodes.add(nodeObj);
      nodeObj.addProperty(SocratesToGSN.NODE_ID, elemId);
      nodeObj.addProperty(SocratesToGSN.NODE_TYPE, elem.eClass().getName().toUpperCase());
      nodeObj.addProperty(SocratesToGSN.NODE_TEXT, elem.getDescription());
      nodeObj.add(SocratesToGSN.NODE_DESC, null);
      var isRoot = false;
      if (elem instanceof Supporter supp && supp.getSupports().size() == 0) {
        isRoot = true;
        jsonObj.addProperty("root", elemId);
      }
      nodeObj.addProperty(SocratesToGSN.NODE_ROOT, isRoot);
      var children = new JsonArray();
      nodeObj.add(SocratesToGSN.NODE_CHILDREN, children);
      if (elem instanceof Contextualizable con) {
        con.getInContextOf().stream().forEach(ico -> children.add(getNodeId(ico.getContext())));
      }
      if (elem instanceof Supportable supp) {
        supp.getSupportedBy().stream().forEach(sb -> children.add(getNodeId(sb.getTarget())));
      }
    }

    return new Gson().toJson(jsonObj);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    var json = convert(inputsByName.get(GSNToSocrates.IN0.name()).getName());
    var outputMap = outputFromInput(0, 0, inputsByName, outputMIDsByName);
    FileUtils.createTextFile(outputMap.get(GSNToSocrates.OUT0.name()).getUri(), json, true);

    return outputMap;
  }
}
