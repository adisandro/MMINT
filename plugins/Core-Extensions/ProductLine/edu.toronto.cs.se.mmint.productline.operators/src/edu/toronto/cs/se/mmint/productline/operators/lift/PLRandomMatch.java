/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.operator.match.RandomMatch;
import edu.toronto.cs.se.mmint.operator.match.UntypedMatch;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.Reference;

public class PLRandomMatch extends RandomMatch {

  @Override
  protected @Nullable Object getMatchAttributeValue(EObject modelObj) {
    if (modelObj instanceof Attribute || modelObj instanceof Reference) {
      // don't match attributes and references
      return null;
    }
    var plClass = (Class) modelObj;
    if (this.matchOn.equals(UntypedMatch.ATTR_ECLASS)) {
      // value is the type name
      return plClass.getType().getName();
    }
    else {
      // value is in the attributes
      return plClass.getAttributes().stream()
        .filter(a -> a.getType().getName().equals(this.matchOn))
        .map(a -> a.getValue())
        .findFirst()
        .orElse(null);
    }
  }

  @Override
  protected boolean areContainersMatched(EObject modelObj1, EObject modelObj2, Map<EObject, EObject> matched) {
    var modelObjCont1 = ((Class) modelObj1).getEContainer();
    var modelObjCont2 = ((Class) modelObj2).getEContainer();
    return (modelObjCont1 == null && modelObjCont2 == null) || // roots
           (modelObjCont1.getEContainer() == null && modelObjCont2.getEContainer() == null) || // root children
           (matched.get(modelObjCont1) ==  modelObjCont2); // containers already matched
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
        var modelObj1 = (Class) iter1.next();
        var otherType = modelObj1.getType();
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
          if (type != ((Class) iter2.next()).getType()) {
            iter2.remove();
          }
        }
      }
    }
  }
}
