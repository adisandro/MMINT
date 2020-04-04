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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRevise2State extends Slice {

  @Override
  protected Map<EObject, EObject> getAllSlicedElements(EObject critModelObj, Set<EObject> alreadySliced) {
    //TODO Generalize this version of the algorithm up into Slice?
    var sliced = new HashMap<EObject, EObject>();
    sliced.put(critModelObj, null);
    alreadySliced.add(critModelObj);
    // only if input is a strategy the state validity should be revised for all ancestor goals.
    if (!(critModelObj instanceof Strategy)) {
      return sliced;
    }
    var visitedCur = Set.of(critModelObj);
    var alreadyVisited = new HashSet<>(alreadySliced);

    // iterate through the current set of newly propagated model elements
    // to identify the next ones that are going to be sliced and propagated
    while (!visitedCur.isEmpty()) {
      var visitedNext = new HashSet<EObject>();
      for (var modelObj : visitedCur) {
        // get all model elements directly sliced and propagated by the current one without adding duplicates
        var slicedModelObjs = getDirectlySlicedElements(modelObj, alreadyVisited);
        var visitedModelObjs = getDirectlyVisitedElements(modelObj, alreadyVisited);
        slicedModelObjs.stream().forEach(s -> sliced.put(s, modelObj));
        visitedNext.addAll(visitedModelObjs);
        alreadySliced.addAll(slicedModelObjs);
        alreadyVisited.addAll(visitedModelObjs);
      }
      // prepare for next iteration
      visitedCur = visitedNext;
    }

    return sliced;
  }

  protected Set<EObject> getDirectlyVisitedElements(EObject modelObj, Set<EObject> alreadyPropagated) {
    var propagated = new HashSet<EObject>();

    // propagate to supported ancestors
    if (modelObj instanceof Supportable) {
      if (GSNUtils.isPropagatedUp((Supportable) modelObj, alreadyPropagated)) {
        var supported = ((Supportable) modelObj).getSupports().stream()
                                                .map(SupportedBy::getSource)
                                                .filter(s -> !alreadyPropagated.contains(s))
                                                .collect(Collectors.toSet());
        propagated.addAll(supported);
      }
    }

    return propagated;
  }

  @Override
  protected Set<EObject> getDirectlySlicedElements(EObject modelObj, Set<EObject> alreadyPropagated) {
    // slice all propagated goals
    var sliced = getDirectlyVisitedElements(modelObj, alreadyPropagated).stream()
                   .filter(p -> p instanceof Goal)
                   .collect(Collectors.toSet());

    return sliced;
  }
}
