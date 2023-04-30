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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class RandomMatch extends Match {
  private final static String MAPPING_NAME = "match";
  protected int numMatches;

  public static class RandomIn extends In {
    private final static String PROP_NUMMATCHES = "numMatches";

    public RandomIn(Map<String, Model> inputsByName) {
      super(inputsByName);
    }
  }

  @Override
  public void readInputProperties(Properties inputProperties) throws MMINTException {
    super.readInputProperties(inputProperties);
    this.numMatches = MIDOperatorIOUtils.getIntProperty(inputProperties, RandomIn.PROP_NUMMATCHES);
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new RandomIn(inputsByName);
    this.out = new UntypedOut(this.in, MIDTypeRegistry.getType(Match.OVERLAP_TYPE_URI), outputMIDsByName);
  }

  protected boolean areContainersMatched(EObject modelObj1, EObject modelObj2, Map<EObject, EObject> matched) {
    var modelObjCont1 = modelObj1.eContainer();
    var modelObjCont2 = modelObj2.eContainer();
    return (modelObjCont1.eContainer() == null && modelObjCont2.eContainer() == null) || // root children
           (matched.get(modelObjCont1) ==  modelObjCont2); // containers already matched
  }

  @Override
  protected void createMatchMappings(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2)
                                    throws MMINTException {
    var r = getState();
    int ri;
    var model1Count = modelObjAttrs1.values().stream().collect(Collectors.summingInt(objs -> objs.size()));
    var model2Count = modelObjAttrs2.values().stream().collect(Collectors.summingInt(objs -> objs.size()));
    var maxMatches = Math.min(this.numMatches, Math.min(model1Count, model2Count));
    var entries1 = new ArrayList<>(modelObjAttrs1.entrySet());
    var matched = new HashMap<EObject, EObject>();
    for (var i = 0; i < maxMatches; i++) {
      if (entries1.size() == 0) {
        break;
      }
      ri = r.nextInt(entries1.size());
      var entry1 = entries1.get(ri);
      var attrStr = entry1.getKey();
      var modelObjs1 = entry1.getValue();
      if (modelObjs1.isEmpty()) {
        entries1.remove(ri);
        i--;
        continue;
      }
      var modelObjs2 = modelObjAttrs2.get(attrStr);
      if (modelObjs2 == null || modelObjs2.isEmpty()) {
        entries1.remove(ri);
        i--;
        continue;
      }
      // random mappings are binary, with only one model element on both sides of the overlap
      ri = r.nextInt(modelObjs1.size());
      var modelObj1 = new ArrayList<>(modelObjs1).get(ri);
      ri = r.nextInt(modelObjs2.size());
      var modelObj2 = new ArrayList<>(modelObjs2).get(ri);
      // since the # of random matches is a subset of all possible matches
      // we have to check whether the containers have actually been matched already
      if (!areContainersMatched(modelObj1, modelObj2, matched)) {
        //TODO MMINT[MATCH] This could cause an infinite loop
        i--;
        continue;
      }
      modelObjs1.remove(modelObj1);
      modelObjs2.remove(modelObj2);
      matched.put(modelObj1, modelObj2);
      createMatchMapping(Set.of(modelObj1), Set.of(modelObj2), RandomMatch.MAPPING_NAME + i);
    }
  }
}
