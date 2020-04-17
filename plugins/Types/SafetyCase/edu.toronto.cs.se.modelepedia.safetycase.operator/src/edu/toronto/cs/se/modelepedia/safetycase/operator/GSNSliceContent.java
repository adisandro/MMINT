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

public class GSNSliceContent extends Slice {

  /**
   * Assure18 rules: V1.parents, V4.
   * Visit supported (parent) connectors, slice supported goals.
   */
  private SliceStep ruleSupports(Supporter modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supports");

    var supportedStream = modelObj.getSupports().stream()
      .map(SupportedBy::getSource)
      .filter(s -> !this.allVisited.containsKey(s) && !this.allSliced.containsKey(s))
      .filter(v -> GSNSlice.isSupported(v, this.allSliced.keySet()));
    var visited = supportedStream
      .filter(s -> s instanceof SupportConnector)
      .collect(Collectors.toMap(v -> (EObject) v, v -> newInfo, SliceInfo.ORDER_DUPLICATES));
    var sliced = supportedStream
      .filter(s -> s instanceof Goal)
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES));

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rules: V1.children, V2.2.
   * Visit supporting (children) connectors, slice supporting core elements.
   */
  private SliceStep ruleSupportedBy(Supportable modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedBy");

    var supportingStream = modelObj.getSupportedBy().stream()
      .map(SupportedBy::getTarget)
      .filter(s -> !this.allVisited.containsKey(s) && !this.allSliced.containsKey(s));
    var visited = supportingStream
      .filter(v -> v instanceof SupportConnector)
      .collect(Collectors.toMap(v -> (EObject) v, v -> newInfo, SliceInfo.ORDER_DUPLICATES));
    var sliced = supportingStream
      .filter(s -> s instanceof CoreElement)
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES));

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rule: V2.3.
   * Slice connected contextual elements.
   */
  private SliceStep ruleInContextOf(Strategy modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "inContextOf");

    var sliced = modelObj.getInContextOf().stream()
      .map(InContextOf::getContext)
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES));

    return new SliceStep(sliced, new HashMap<EObject, SliceInfo>());
  }

  /**
   * Assure18 rule: V3.1.
   * Visit and slice attached elements.
   */
  private SliceStep ruleContextOf(ContextualElement modelObj, SliceInfo info) {
    var newInfoVisited = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedByContextOf");
    var newInfoSliced = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "contextOf");

    var decomposableStream = modelObj.getContextOf().stream()
      .map(InContextOf::getContextOf)
      .filter(d -> !this.allVisited.containsKey(d) && !this.allSliced.containsKey(d));
    var visited = decomposableStream // continues to ruleSupportedByContextOf
      .collect(Collectors.toMap(v -> (EObject) v, v -> newInfoVisited, SliceInfo.ORDER_DUPLICATES));
    var sliced = decomposableStream
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfoSliced, SliceInfo.ORDER_DUPLICATES));

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rule: V3.2.
   * Visit supporting (children) elements, slice supporting core elements and attached contexts.
   */
  private SliceStep ruleSupportedByContextOf(DecomposableCoreElement modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedByContextOf");

    var supportingStream = modelObj.getSupportedBy().stream()
      .map(SupportedBy::getTarget)
      .filter(s -> !this.allVisited.containsKey(s));
    var visited = supportingStream
      .collect(Collectors.toMap(v -> (EObject) v, v -> newInfo, SliceInfo.ORDER_DUPLICATES));
    var sliced = supportingStream
      .filter(s -> s instanceof CoreElement)
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES));
    sliced.putAll(supportingStream
      .filter(s -> s instanceof DecomposableCoreElement)
      .flatMap(s -> ((DecomposableCoreElement) s).getInContextOf().stream())
      .map(InContextOf::getContext)
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, SliceInfo.ORDER_DUPLICATES)));

    return new SliceStep(sliced, visited);
  }

  /**
   * This slicer follows a rule-based approach, rather than element-based.
   * (and it has a filter on initial allowed types from the criterion)
   */
  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    SliceStep sliceStep;

    if (info.prevObj == null) {
      // criterion object
      if (info.type == SliceType.DEL || info.type == SliceType.REVISE) {
        if (modelObj instanceof Goal) {
          var supports = ruleSupports((Goal) modelObj, info);
          var supportedBy = ruleSupportedBy((Goal) modelObj, info);
          sliceStep = new SliceStep(supports, supportedBy);
        }
        else if (modelObj instanceof Strategy) {
          var supportedBy = ruleSupportedBy((Strategy) modelObj, info);
          var inContextOf = ruleInContextOf((Strategy) modelObj, info);
          sliceStep = new SliceStep(supportedBy, inContextOf);
        }
        else if (modelObj instanceof ContextualElement) {
          sliceStep = ruleContextOf((ContextualElement) modelObj, info);
        }
        else if (modelObj instanceof Solution) {
          sliceStep = ruleSupports((Solution) modelObj, info);
        }
        else {
          sliceStep = new SliceStep();
        }
      }
      else {
        sliceStep = new SliceStep();
      }
    }
    else {
      // recursive slice from this operator
      sliceStep = switch (info.rule) {
        // inContextOf is not recursive
        case "supports" -> ruleSupports((Supporter) modelObj, info);
        case "supportedBy" -> ruleSupportedBy((Supportable) modelObj, info);
        case "supportedByContextOf" -> ruleSupportedByContextOf((DecomposableCoreElement) modelObj, info);
        default -> new SliceStep();
      };
    }

    //TODO MMINT[GSN] If at the end an ASIL decomposition strategy is impacted, then its independence goal among all children is also impacted
    return sliceStep;
  }

  /**
   * Resets for each criterion, i.e. executes each rule independently.
   */
  @Override
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
    var slicedBackup = this.allSliced;
    var visitedBackup = this.allVisited;
    this.allSliced = new HashMap<>();
    this.allVisited = new HashMap<>();
    super.sliceCriterionElement(critObj, info);
    new SliceStep(this.allSliced, this.allVisited).mergeInto(slicedBackup, visitedBackup);
    this.allSliced = slicedBackup;
    this.allVisited = visitedBackup;
  }
}
