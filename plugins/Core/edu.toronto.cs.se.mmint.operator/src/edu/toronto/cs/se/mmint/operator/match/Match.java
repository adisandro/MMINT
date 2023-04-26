/*******************************************************************************
 * Copyright (c) 2012, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.operator.match;


import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

public class Match extends UntypedMatch {
  private final static String OVERLAP_TYPE_URI = "http://se.cs.toronto.edu/mmint/Overlap";

  public static class In2 extends In {
    public In2(Map<String, Model> inputsByName) {
      super(inputsByName);
      if (!this.model1.getMetatypeUri().equals(this.model2.getMetatypeUri())) {
        //TODO MMINT[POLY] Use instanceOf when it's optimized (automatic caching of runtime types)
        throw new IllegalArgumentException();
      }
    }
  }

  public static class Constraint2 extends Constraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new In2(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In2(inputsByName);
    this.out = new Out(this.in, MIDTypeRegistry.getType(Match.OVERLAP_TYPE_URI), outputMIDsByName);
  }

  @Override
  protected void matchAttributes(Model model, Map<String, Set<EObject>> modelObjAttrs,
                                 Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {
    super.matchAttributes(model, modelObjAttrs, modelObjTable);
  }

  @Override
  protected void createMatchMappings(Map<String, Set<EObject>> modelObjAttrs,
                                     Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {
    for (var modelObjs : modelObjAttrs.values()) {
      EClass type = null;
      for (var iter = modelObjs.iterator(); iter.hasNext();) {
        var modelObj = iter.next();
        // remove entries with unmatched container
        var modelObjContainer = modelObj.eContainer();
        if (modelObjContainer != null && !modelObjTable.containsKey(modelObjContainer)) {
          iter.remove();
          continue;
        }
        // remove entries that don't share the same type
        var otherType = modelObj.eClass();
        if (type == null) {
          type = otherType;
        }
        else if (type != otherType) {
          iter.remove();
        }
      }
    }
    super.createMatchMappings(modelObjAttrs, modelObjTable);
  }
}
