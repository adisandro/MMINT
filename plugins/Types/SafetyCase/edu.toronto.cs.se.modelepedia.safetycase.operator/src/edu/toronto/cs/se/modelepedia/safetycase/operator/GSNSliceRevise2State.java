/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRevise2State extends Slice {

  @Override
  protected SliceStep getDirectlySlicedElements(SliceObject sliceObj) {
    var sliced = new HashSet<SliceObject>();
    var visited = new HashSet<SliceObject>();

    if (sliceObj.modelObj instanceof Supportable) {
      // visit supported ancestors, slice visited goals
      if (GSNUtils.isPropagatedUp((Supportable) sliceObj.modelObj, this.alreadyVisited.keySet())) {
        var supported = ((Supportable) sliceObj.modelObj).getSupports().stream()
          .map(SupportedBy::getSource)
          .filter(s -> !this.alreadyVisited.containsKey(s));
        visited.addAll(supported.map(s -> new SliceObject(s, SliceType.RECHECK_STATE))
                                .collect(Collectors.toSet()));
        sliced.addAll(supported.filter(s -> s instanceof Goal)
                               .map(s -> new SliceObject(s, SliceType.RECHECK_STATE))
                               .collect(Collectors.toSet()));
      }
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected Map<SliceObject, EObject> getAllSlicedElements(SliceObject critObj) {
    // only if input is a strategy the state validity should be revised for all ancestor goals.
    if (!(critObj.modelObj instanceof Strategy)) {
      this.alreadySliced.put(critObj.modelObj, critObj.type);
      this.alreadyVisited.put(critObj.modelObj, critObj.type);
      return Map.of(critObj, null);
    }
    return super.getAllSlicedElements(critObj);
  }
}
