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
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.classdiagram.operator;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.match.Match;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;

public class CDMatch extends Match {

  private void filterAssociations(Map<String, Set<EObject>> modelObjAttrs) {
    var iter = modelObjAttrs.entrySet().iterator();
    while (iter.hasNext()) {
      var modelObjs = iter.next().getValue();
      if (modelObjs.isEmpty()) {
        continue;
      }
      var areAssociations = modelObjs.stream().allMatch(modelObj -> modelObj instanceof Association);
      if (!areAssociations) {
        continue;
      }
      var association = (Association) modelObjs.iterator().next();
      try {
        var srcAttr = (String) FileUtils.getModelObjectFeature(association.getSource(), this.matchOn);
        var srcMatch = modelObjAttrs.get(srcAttr);
        var tgtAttr = (String) FileUtils.getModelObjectFeature(association.getTarget(), this.matchOn);
        var tgtMatch = modelObjAttrs.get(tgtAttr);
        var endpointsCheck =
          modelObjs.stream()
            .map(modelObj -> ((Association) modelObj).getSource())
            .allMatch(clazz -> srcMatch.contains(clazz)) &&
          modelObjs.stream()
            .map(modelObj -> ((Association) modelObj).getTarget())
            .allMatch(clazz -> tgtMatch.contains(clazz));
        if (!endpointsCheck) {
          iter.remove();
        }
      }
      catch (MMINTException e) {
        iter.remove();
      }
    }
  }

  @Override
  protected void filterMatches(Map<String, Set<EObject>> modelObjAttrs1, Map<String, Set<EObject>> modelObjAttrs2) {
    filterAssociations(modelObjAttrs1);
    filterAssociations(modelObjAttrs2);
  }
}
