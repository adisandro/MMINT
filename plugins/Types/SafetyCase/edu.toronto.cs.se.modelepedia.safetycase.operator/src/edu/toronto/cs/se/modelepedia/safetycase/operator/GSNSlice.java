/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashSet;
import java.util.stream.Collectors;

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
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

/*
 * TODO
 * Algorithm:
 * REVISE:
 * 1) Trace deleted elements to gsn
 * RECHECK CONTENT:
 * 1) Trace deleted elements to gsn
 * 2) Apply V1, V2, V3, V4 once (not recursively)
 * 3) Add traced sysmega slice
 * RECHECK STATE:
 * 1) Trace deleted elements to gsn
 * 2) Apply V2 once (not recursively)
 * 3) Add traced sysmega slice
 * 4) Apply C1, C2 recursively
 * RECHECK:
 * 1) Trace deleted elements to gsn
 * 2) Apply V1, V2, V3, V4 once (not recursively)
 * 3) Add traced sysmega slice
 * 4) Apply C1, C2 recursively (excluding newly generated RECHECK_CONTENT)
 *
 * Questions:
 * - Remap traced sysmega slice to MOD, or keep them as R_C? (works only because system slicers mark them as R_C)
 * - Order criteria to do DEL first, or use SliceType in alreadySliced to overwrite? (e.g. from R_S to R_C)
 * - ModelRelMerge merges mappings with different type, it should be fixed. (Implications for slicing?)
 * - Some slice rules are dependent on the crit element being of a certain type. (Need to carry that info)
 * - GSNSlice is a multiple-pass slicer. (Slice must be generalized with a method to execute a pass)
 */
public class GSNSlice extends Slice {

  private SliceStep gsnSliceRevise2Content(SliceObject sliceObj) {
    var sliced = new HashSet<SliceObject>();
    var modelObj = sliceObj.modelObj;

    if (modelObj instanceof DecomposableCoreElement) {
      // slice child core elements
      sliced.addAll(
        GSNUtils.getChildCoreElements((DecomposableCoreElement) modelObj, this.alreadySliced.keySet()).stream()
          .map(s -> new SliceObject(s, SliceType.RECHECK_CONTENT))
          .collect(Collectors.toSet()));
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

  private SliceStep gsnSliceRevise2State(SliceObject sliceObj) {
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

  private SliceStep gsnSliceRecheck(SliceObject sliceObj) {
    var sliced = new HashSet<SliceObject>();

    if (sliceObj.modelObj instanceof Goal || sliceObj.modelObj instanceof Solution) {
      // slice all ancestor goals
      sliced.addAll(
        GSNUtils.getAncestorGoals((CoreElement) sliceObj.modelObj, this.alreadySliced.keySet()).stream()
          .filter(a -> !this.alreadySliced.containsKey(a))
          .map(a -> new SliceObject(a, SliceType.RECHECK_STATE))
          .collect(Collectors.toSet()));
    }

    return new SliceStep(sliced, sliced);
  }

  @Override
  protected SliceStep getDirectlySlicedElements(SliceObject sliceObj) {
    var emptySet = new HashSet<SliceObject>();
    var emptyStep = new SliceStep(emptySet, emptySet);

    return switch (sliceObj.type) {
      case ADD -> emptyStep;
      case DEL -> {
        var all = gsnSliceRevise2Content(sliceObj);
        var state1 = gsnSliceRevise2State(sliceObj);
        for (var stateObj : state1.sliced) {
          var state2 = gsnSliceRecheck(stateObj);
          all.sliced.addAll(state2.sliced);
          all.visited.addAll(state2.visited);
        }
        var state3 = gsnSliceRecheck(sliceObj);
        all.sliced.addAll(state3.sliced);
        all.visited.addAll(state3.visited);
        yield all;
      }
      case MOD -> gsnSliceRecheck(sliceObj);
      case REVISE -> emptyStep;
      case RECHECK_CONTENT -> gsnSliceRevise2Content(sliceObj);
      case RECHECK_STATE -> gsnSliceRecheck(sliceObj);
    };
  }
}
