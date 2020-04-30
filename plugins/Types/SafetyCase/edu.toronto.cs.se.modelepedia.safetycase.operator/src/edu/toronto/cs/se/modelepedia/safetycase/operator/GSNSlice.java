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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;

public class GSNSlice extends Slice {

  // Determines whether a change impact is propagated up or not given the
  // source impacted element and a set of other impacted elements.
  //TODO MMINT[GSN] Review, it has a view of alreadySliced at the time it's invoked
  private boolean isSupported(Supportable elem, Set<EObject> alreadySliced) {
    // If a core element is impacted, then its parents are also impacted.
    if (elem instanceof CoreElement) {
      return true;
    }
    // Count the number of children impacted.
    var isPropagated = false;
    var impactCount = 0;
    var totalCount = 0;
    for (var rel : elem.getSupportedBy()) {
      totalCount += 1;
      var target = rel.getTarget();
      if (alreadySliced.contains(target)) {
        impactCount += 1;
      }
      else if (target instanceof SupportConnector) {
        if (isSupported((SupportConnector) target, alreadySliced)) {
          impactCount += 1;
        }
      }
    }
    // If an AND-connector or an XOR-connector is impacted, then its parents are
    // impacted if any of its children are impacted.
    if ((elem instanceof AndSupporter) || (elem instanceof XorSupporter)) {
      if (impactCount >= 1) {
        isPropagated = true;
      }
    }
    // If an OR-connector is impacted, then its parents are
    // impacted if all its children are impacted.
    else if (elem instanceof OrSupporter) {
      if (impactCount == totalCount) {
        isPropagated = true;
      }
    }
    // If an M-of-N connector is impacted, then its parents are
    // impacted if more than (N-M) children are impacted.
    else if (elem instanceof MofNSupporter) {
      var target = ((MofNSupporter) elem).getTarget();
      if (impactCount > totalCount - target) {
        isPropagated = true;
      }
    }

    return isPropagated;
  }

  /**
   * Assure18 rules: V1.parents, V2.1, V4, C1, C2.
   * Content: visit supported (parent) connectors, slice supported strategies.
   * State: visit supported (parent) elements, slice supported goals.
   */
  private SliceStep ruleSupports(Supporter modelObj, SliceInfo info) {
    var newInfo = info.rule.equals("supportsContent") ?
      new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportsContent") :
      new SliceInfo(SliceType.RECHECK_STATE, modelObj, "supportsState");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupports()) {
      var supported = supportedBy.getSource();
      if (!isSupported(supported, this.allSliced.keySet())) {
        continue;
      }
      if (!this.allVisited.containsKey(supported) && (
            info.rule.equals("supportsState") || supported instanceof SupportConnector)) {
        visited.merge(supported, newInfo, SliceInfo.ORDER_DUPLICATES);
      }
      if (!this.allSliced.containsKey(supported) && (
            (info.rule.equals("supportsState") && supported instanceof Goal) ||
            info.rule.equals("supportsContent"))) {
        sliced.merge(supported, newInfo, SliceInfo.ORDER_DUPLICATES);
      }
    }

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rules: V1.children, V2.2.
   * Visit supporting (children) connectors, slice supporting core elements.
   */
  private SliceStep ruleSupportedBy(Supportable modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedBy");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupportedBy()) {
      var supporting = supportedBy.getTarget();
      if (!this.allVisited.containsKey(supporting) && supporting instanceof SupportConnector) {
        visited.merge(supporting, newInfo, SliceInfo.ORDER_DUPLICATES);
      }
      if (!this.allSliced.containsKey(supporting) && supporting instanceof CoreElement) {
        sliced.merge(supporting, newInfo, SliceInfo.ORDER_DUPLICATES);
      }
    }

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
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var inContextOf : modelObj.getContextOf()) {
      var contextOf = inContextOf.getContextOf();
      if (!this.allVisited.containsKey(contextOf)) {
        // continues to ruleSupportedByContextOf
        visited.merge(contextOf, newInfoVisited, SliceInfo.ORDER_DUPLICATES);
      }
      if (!this.allSliced.containsKey(contextOf)) {
        sliced.merge(contextOf, newInfoSliced, SliceInfo.ORDER_DUPLICATES);
      }
    }

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rule: V3.2.
   * Visit supporting (children) elements, slice supporting core elements and attached contexts.
   */
  private SliceStep ruleSupportedByContextOf(DecomposableCoreElement modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "supportedByContextOf");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupportedBy()) {
      var supporting = supportedBy.getTarget();
      if (!this.allVisited.containsKey(supporting)) {
        visited.merge(supporting, newInfo, SliceInfo.ORDER_DUPLICATES);
      }
      if (!this.allSliced.containsKey(supporting) && supporting instanceof CoreElement) {
        sliced.merge(supporting, newInfo, SliceInfo.ORDER_DUPLICATES);
        if (supporting instanceof DecomposableCoreElement) {
          for (var inContextOf : ((DecomposableCoreElement) supporting).getInContextOf()) {
            sliced.merge(inContextOf.getContext(), newInfo, SliceInfo.ORDER_DUPLICATES);
          }
        }
      }
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var sliceStep = switch (info.rule) {
      case "contextOf" -> ruleContextOf((ContextualElement) modelObj, info);
      case "inContextOf" -> ruleInContextOf((Strategy) modelObj, info);
      case "supportedBy" -> ruleSupportedBy((Supportable) modelObj, info);
      case "supportedByContextOf" -> ruleSupportedByContextOf((DecomposableCoreElement) modelObj, info);
      case "supportsContent", "supportsState" -> ruleSupports((Supporter) modelObj, info);
      //TODO MMINT[GSN] To add: if at the end an ASIL decomposition strategy is impacted, then its independence goal among all children is also impacted
      default -> new SliceStep();
    };

    return sliceStep;
  }

  protected void sliceRule(EObject critObj, SliceInfo info) {
    var realSliced = this.allSliced;
    var realVisited = this.allVisited;
    this.allSliced = new HashMap<>();
    this.allVisited = new HashMap<>();
    this.allSliced.put(critObj, info);
    this.allVisited.put(critObj, info);
    super.sliceCriterionElement(critObj, info);
    this.allSliced.remove(critObj);
    this.allVisited.remove(critObj);
    new SliceStep(this.allSliced, this.allVisited).mergeInto(realSliced, realVisited);
    this.allSliced = realSliced;
    this.allVisited = realVisited;
  }

  /**
   * This slicer follows a rule-based approach, rather than element-based.
   * (and it has a filter on initial allowed types from the criterion)
   * Rules reset the sliced/visited sets every time, i.e. each rule is executed independently.
   * TODO: With ModelRelPropagation, we lose one step of the prevObj chain, can we even fix it?
   */
  @Override
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
    var tempInfo = new SliceInfo(info);
    if (critObj instanceof Goal) {
      if (info.type == SliceType.DEL || info.type == SliceType.REVISE) {
        tempInfo.rule = "supportsContent";
        sliceRule(critObj, tempInfo);
        tempInfo.rule = "supportedBy";
        sliceRule(critObj, tempInfo);
      }
      tempInfo.rule = "supportsState";
      sliceRule(critObj, tempInfo);
    }
    else if (critObj instanceof Strategy && (
             info.type == SliceType.DEL || info.type == SliceType.REVISE)) {
      tempInfo.rule = "supportedBy";
      sliceRule(critObj, tempInfo);
      tempInfo.rule = "inContextOf";
      sliceRule(critObj, tempInfo);
      tempInfo.rule = "supportsState";
      sliceRule(critObj, tempInfo);
    }
    else if (critObj instanceof ContextualElement && (
             info.type == SliceType.DEL || info.type == SliceType.REVISE)) {
      tempInfo.rule = "contextOf";
      sliceRule(critObj, tempInfo);
    }
    else if (critObj instanceof Solution) {
      if (info.type == SliceType.DEL || info.type == SliceType.REVISE) {
        tempInfo.rule = "supportsContent";
        sliceRule(critObj, tempInfo);
      }
      tempInfo.rule = "supportsState";
      sliceRule(critObj, tempInfo);
    }
  }
}
