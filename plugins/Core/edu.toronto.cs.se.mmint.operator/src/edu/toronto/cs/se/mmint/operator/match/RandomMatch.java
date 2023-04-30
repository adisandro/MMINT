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

  @Override
  protected void createMatchMappings(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2)
                                    throws MMINTException {
    var r = getState();
    int ri;
    var entries1 = modelObjAttrs1.entrySet().stream()
      .filter(e -> e.getValue().size() >= 1)
      .collect(Collectors.toList());
    for (var i = 0; i < this.numMatches; i++) {
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
      ri = r.nextInt(modelObjs1.size());
      var modelObj1 = new ArrayList<>(modelObjs1).get(ri);
      ri = r.nextInt(modelObjs2.size());
      var modelObj2 = new ArrayList<>(modelObjs2).get(ri);
      //TODO we have to check if the container has been picked
      // random mappings are binary, with only one model element on both sides of the overlap
      modelObjs1.remove(modelObj1);
      modelObjs2.remove(modelObj2);
      createMatchMapping(Set.of(modelObj1), Set.of(modelObj2), RandomMatch.MAPPING_NAME + i);
    }
  }
}
