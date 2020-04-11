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
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

public class GSNSliceRevise extends Slice {

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var sliced = new HashMap<EObject, SliceInfo>();
    var visited = new HashMap<EObject, SliceInfo>();

    if (modelObj instanceof DecomposableCoreElement || modelObj instanceof SupportConnector) {
      // Assure18: V1.children, V2.2, V3.2
      var supportingStream = ((Supportable) modelObj).getSupportedBy().stream()
        .map(SupportedBy::getTarget)
        .filter(s -> !this.allVisited.containsKey(s) && !this.allSliced.containsKey(s));//TODO?
      if (info.rule.equals("contextOf")) {
        // V3.2
        // visit all supporting (children) elements, slice supporting core elements
        var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "contextOf");
        visited.putAll(supportingStream
          .collect(Collectors.toMap(v -> v, v -> newInfo, SliceInfo.ORDER_DUPLICATES)));
        sliced.putAll(supportingStream
          .filter(s -> s instanceof CoreElement)
          .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
      }
      else {
        // V1.children, V2.2
        // visit supporting (children) connectors, slice supporting core elements
        var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedBy");
        visited.putAll(supportingStream
          .filter(v -> v instanceof SupportConnector)
          .collect(Collectors.toMap(v -> v, v -> newInfo, SliceInfo.ORDER_DUPLICATES)));
        sliced.putAll(supportingStream
          .filter(s -> s instanceof CoreElement)
          .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
      }
    }
    if (modelObj instanceof Goal || modelObj instanceof Solution) {
      // Assure18: V1.parents, V4
      // slice supported (parent) elements
      //TODO(including support connectors?)
      var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supports");
      sliced.putAll(
        ((Supporter) modelObj).getSupports().stream()
          .map(SupportedBy::getSource)
          .filter(s -> !this.allSliced.containsKey(s))
          .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
    }
    if (modelObj instanceof Strategy) {
      // Assure18: V2.3
      // slice connected contextual elements
      var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "inContextOf");
      sliced.putAll(
        ((Strategy) modelObj).getInContextOf().stream()
          .map(InContextOf::getContext)
          .filter(s -> !this.allSliced.containsKey(s))
          .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
    }
    if (modelObj instanceof Context || modelObj instanceof Assumption) {
      // Assure18: V3.1, V3.2
      // slice all argument elements that use or inherit it
      var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "contextOf");
      sliced.putAll(
        ((ContextualElement) modelObj).getContextOf().stream()
          .map(InContextOf::getContextOf)
          .flatMap(s -> GSNUtils.getContextInheritors(s, this.allSliced.keySet()).stream())
          .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));

      var decomposableStream = ((ContextualElement) modelObj).getContextOf().stream()
        .map(InContextOf::getContextOf)
        .filter(d -> !this.allVisited.containsKey(d) && !this.allSliced.containsKey(d));//TODO?
      visited.putAll(decomposableStream // V3.2
        .collect(Collectors.toMap(v -> v, v -> newInfo, SliceInfo.ORDER_DUPLICATES)));
      sliced.putAll(decomposableStream // V3.1
        .collect(Collectors.toMap(s -> s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
    //TODO Redo per-starting element, i.e. with 4 separate getDirectlySlicedElements (how to change api?)
    if ((info.type == SliceType.DEL || info.type == SliceType.REVISE) &&
        (critObj instanceof Goal || // Assure18: V1
         critObj instanceof Strategy || // Assure18: V2
         critObj instanceof Context || critObj instanceof Assumption || // Assure18: V3
         critObj instanceof Solution) // Assure18: V4
    ) {
      // start from goals, strategies, contextes and solutions only
      super.sliceCriterionElement(critObj, info);
    }
    else {
      this.allSliced.put(critObj, info);
      this.allVisited.put(critObj, info);
    }
  }
}
