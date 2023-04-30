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
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;

public class Match extends UntypedMatch {
  protected final static String OVERLAP_TYPE_URI = "http://se.cs.toronto.edu/mmint/Overlap";

  public static class In extends UntypedIn {
    public In(Map<String, Model> inputsByName) {
      super(inputsByName);
      if (!this.model1.getMetatypeUri().equals(this.model2.getMetatypeUri())) {
        //TODO MMINT[POLY] Use instanceOf when it's optimized (automatic caching of runtime types)
        throw new IllegalArgumentException();
      }
    }
  }

  public static class Constraint extends UntypedConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new In(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    this.in = new In(inputsByName);
    this.out = new UntypedOut(this.in, MIDTypeRegistry.getType(Match.OVERLAP_TYPE_URI), outputMIDsByName);
  }

  @Override
  protected void filterMatches(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2) {
    if (this.matchOn.equals("eClass")) {
      // all entries are categorized by type already
      return;
    }
    // remove entries that don't share the same type
    for (var entry1 : modelObjAttrs1.entrySet()) {
      var attrStr = entry1.getKey();
      var modelObjs1 = entry1.getValue();
      EClass type = null;
      for (var iter1 = modelObjs1.iterator(); iter1.hasNext();) {
        var modelObj1 = iter1.next();
        var otherType = modelObj1.eClass();
        if (type == null) {
          type = otherType;
        }
        else if (type != otherType) {
          iter1.remove();
        }
      }
      var modelObjs2 = modelObjAttrs2.get(attrStr);
      if (modelObjs2 != null) {
        for (var iter2 = modelObjs2.iterator(); iter2.hasNext();) {
          if (type != iter2.next().eClass()) {
            iter2.remove();
          }
        }
      }
    }
  }
}
