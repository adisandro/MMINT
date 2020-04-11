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

import java.util.HashMap;
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
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var sliced = new HashMap<EObject, SliceInfo>();
    var visited = new HashMap<EObject, SliceInfo>();

    if (modelObj instanceof Supportable) {
      // Assure18: C1, C2, V2.1
      // visit supported (parent) elements, slice goals only
      var newInfo = new SliceInfo(SliceType.RECHECK_STATE, modelObj, "supports");
      var visitedStream = ((Supportable) modelObj).getSupports().stream()
        .map(SupportedBy::getSource)
        .filter(v -> !this.allVisited.containsKey(v))
        .filter(v -> GSNUtils.isSupported(v, this.allSliced.keySet()));
      var slicedStream = visitedStream.filter(s -> s instanceof Goal);
      visited.putAll(visitedStream.collect(
        Collectors.toMap(v -> v, v -> newInfo, SliceInfo.ORDER_DUPLICATES)));
      sliced.putAll(slicedStream.collect(
        Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
    if (critObj instanceof Goal || // Assure18: C1
        critObj instanceof Solution ||  // Assure18: C2
        (critObj instanceof Strategy && (info.type == SliceType.DEL || info.type == SliceType.REVISE)) // Assure18: V2.1
    ) {
      // start from goals, solutions and strategies only
      super.sliceCriterionElement(critObj, info);
    }
    else {
      this.allSliced.put(critObj, info);
      this.allVisited.put(critObj, info);
    }
  }
}
