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
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRecheck extends Slice {

  @Override
  protected SliceStep getDirectlySlicedElements(SliceObject sliceObj) {
    var sliced = new HashSet<SliceObject>();
    var visited = new HashSet<SliceObject>();
    var modelObj = sliceObj.modelObj;

    if (modelObj instanceof Supportable) {
      // visit all supported elements, slice goals only
      var visitedStream = ((Supportable) modelObj).getSupports().stream()
        .map(SupportedBy::getSource)
        .filter(v -> !this.alreadyVisited.containsKey(v))
        .filter(v -> GSNUtils.isSupported(v, this.alreadySliced.keySet()));
      var slicedStream = visitedStream.filter(s -> s instanceof Goal);
      visited.addAll(visitedStream
        .map(v -> new SliceObject(v, SliceType.RECHECK_STATE))
        .collect(Collectors.toSet()));
      sliced.addAll(slicedStream
        .map(s -> new SliceObject(s, SliceType.RECHECK_STATE))
        .collect(Collectors.toSet()));
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected Map<SliceObject, EObject> getAllSlicedElements(SliceObject critObj) {
    var modelObj = critObj.modelObj;
    var type = critObj.type;

    if (modelObj instanceof Goal || modelObj instanceof Solution ||
        (modelObj instanceof Strategy && (type == SliceType.DEL || type == SliceType.REVISE))) {
      // start from goals, solutions and strategies only
      return super.getAllSlicedElements(critObj);
    }
    else {
      this.alreadySliced.put(modelObj, type);
      this.alreadyVisited.put(modelObj, type);
      return Map.of(critObj, null);
    }
  }
}
