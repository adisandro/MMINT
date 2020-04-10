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
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

public class GSNSliceRevise extends Slice {

  @Override
  protected SliceStep getDirectlySlicedElements(SliceObject sliceObj) {
    var sliced = new HashSet<SliceObject>();
    var visited = new HashSet<SliceObject>();
    var modelObj = sliceObj.modelObj;

    if (modelObj instanceof DecomposableCoreElement) {
      // slice child core elements
      sliced.addAll(
        GSNUtils.getChildCoreElements((DecomposableCoreElement) modelObj, this.alreadySliced.keySet()).stream()
          .map(s -> new SliceObject(s, SliceType.RECHECK_CONTENT))
          .collect(Collectors.toSet()));
      //TODO If recursion is allowed, use visited for SupportConnector
    }
    if (modelObj instanceof Goal || modelObj instanceof Solution) {
      // slice parent supportables (including support connectors)
      sliced.addAll(
        ((Supporter) modelObj).getSupports().stream()
          .map(SupportedBy::getSource)
          .filter(s -> !this.alreadySliced.containsKey(s))
          .map(s -> new SliceObject(s, SliceType.RECHECK_CONTENT))
          .collect(Collectors.toSet()));
    }
    if (modelObj instanceof Strategy) {
      // slice any contexts and justifications connected to it
      sliced.addAll(
        ((Strategy) modelObj).getInContextOf().stream()
          .map(InContextOf::getContext)
          .filter(s -> !this.alreadySliced.containsKey(s))
          .map(s -> new SliceObject(s, SliceType.RECHECK_CONTENT))
          .collect(Collectors.toSet()));
    }
    if (modelObj instanceof Context || modelObj instanceof Assumption) {
      // slice all argument elements that use or inherit it
      ((ContextualElement) modelObj).getContextOf().stream()
        .map(InContextOf::getContextOf)
        .flatMap(s -> GSNUtils.getContextInheritors(s, this.alreadySliced.keySet()).stream())
        .map(s -> new SliceObject(s, SliceType.RECHECK_CONTENT))
        .collect(Collectors.toSet());
    }

    return new SliceStep(sliced, sliced);
  }


  @Override
  protected Map<SliceObject, EObject> getAllSlicedElements(SliceObject critObj) {
    var modelObj = critObj.modelObj;
    var type = critObj.type;

    if ((type == SliceType.DEL || type == SliceType.REVISE) &&
        (modelObj instanceof Goal || modelObj instanceof Strategy || modelObj instanceof Context ||
         modelObj instanceof Solution)) {
      // start from goals, strategies, contextes and solutions only
      return super.getAllSlicedElements(critObj);
    }
    else {
      this.alreadySliced.put(modelObj, type);
      this.alreadyVisited.put(modelObj, type);
      return Map.of(critObj, null);
    }
  }
}
