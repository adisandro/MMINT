/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.gsn.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;

public class GSNSlice extends Slice {

  public static final String REL_TYPE_ID = "http://se.cs.toronto.edu/modelepedia/GSNSliceRel";

  public class GSNSliceType extends SliceType {
    public static final String RECHECK_CONTENT = "http://se.cs.toronto.edu/modelepedia/GSNSliceRel/RecheckContent";
    public static final String RECHECK_STATE = "http://se.cs.toronto.edu/modelepedia/GSNSliceRel/RecheckState";
    public GSNSliceType(String id, int priority) throws MMINTException {
      super(id, priority);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    basicInit(inputsByName, outputMIDsByName);
    var gsnSliceRelType = MIDTypeRegistry.<ModelRel>getType(GSNSlice.REL_TYPE_ID);
    if (gsnSliceRelType == null) {
      throw new MMINTException("Missing GSN slice rel type " + GSNSlice.REL_TYPE_ID);
    }
    this.output.sliceRel = gsnSliceRelType.createInstanceAndEndpoints(null, Output.OUT_MODELREL,
                                                                      ECollections.asEList(this.input.model),
                                                                      this.output.mid);
    this.sliceTypes.put(GSNSliceType.RECHECK_CONTENT, new GSNSliceType(GSNSliceType.RECHECK_CONTENT, 51));
    this.sliceTypes.put(GSNSliceType.RECHECK_STATE, new GSNSliceType(GSNSliceType.RECHECK_STATE, 52));
  }

  // Determines whether a change impact is propagated up or not given the
  // source impacted element and a set of other impacted elements.
  //TODO MMINT[GSN] Review, it has a view of alreadySliced at the time it's invoked
  private boolean isSupported(Supportable elem, Set<EObject> alreadySliced) {
    // If a core element is impacted, then its parents are also impacted.
    if (elem instanceof Goal || elem instanceof Strategy || elem instanceof Solution) {
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
      else if (target instanceof RelationshipDecorator decorator) {
        if (isSupported(decorator, alreadySliced)) {
          impactCount += 1;
        }
      }
    }
    if (elem instanceof RelationshipDecorator decorator) {
      isPropagated = switch (decorator.getType()) {
        // If an AND-connector is impacted, then its parents are
        // impacted if any of its children are impacted.
        case MULTIPLE -> {
          yield (impactCount >= 1) ? true : false;
        }
        // If an OR-connector is impacted, then its parents are
        // impacted if all its children are impacted.
        case OPTIONAL -> {
          yield (impactCount == totalCount) ? true : false;
        }
        // If an M-of-N connector is impacted, then its parents are
        // impacted if more than (N-M) children are impacted.
        case CHOICE -> {
          yield (impactCount > (totalCount - decorator.getCardinality())) ? true : false;
        }
        default -> false;
      };
    }

    return isPropagated;
  }

  /**
   * Assure18 rules: V1.parents, V2.1, V4, C1, C2.
   * Content: visit supported (parent) decorators, slice supported strategies.
   * State: visit supported (parent) elements, slice supported goals.
   */
  private SliceStep ruleSupports(Supporter modelObj, SliceInfo info) {
    var newInfo = "supportsContent".equals(info.rule()) ?
      new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "supportsContent") :
      new SliceInfo(GSNSliceType.RECHECK_STATE, modelObj, "supportsState");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupports()) {
      var supported = supportedBy.getSource();
      if (!isSupported(supported, this.allSliced.keySet())) {
        continue;
      }
      if (!this.allVisited.containsKey(supported)) {
        if (info.rule().equals("supportsState")) {
          visited.merge(supported, newInfo, this.typesOrder);
        }
        else if (supported instanceof RelationshipDecorator decorator) {
          visited.merge(supported, newInfo, this.typesOrder);
          visited.merge(supported.eContainer(), newInfo, this.typesOrder);
        }
      }
      if (!this.allSliced.containsKey(supported) && (
            (info.rule().equals("supportsState") && supported instanceof Goal) ||
            info.rule().equals("supportsContent"))) {
        sliced.merge(supported, newInfo, this.typesOrder);
      }
    }

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rules: V1.children, V2.2.
   * Visit supporting (children) decorators, slice supporting elements.
   */
  private SliceStep ruleSupportedBy(Supportable modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "supportedBy");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupportedBy()) {
      var supporting = supportedBy.getTarget();
      if (!this.allSliced.containsKey(supporting)) {
        sliced.merge(supporting, newInfo, this.typesOrder);
      }
    }
    for (var decorator : modelObj.getDecorators()) {
      if (!this.allVisited.containsKey(decorator)) {
        visited.merge(decorator, newInfo, this.typesOrder);
      }
    }

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rule: V2.3.
   * Slice connected contextual elements.
   */
  private SliceStep ruleInContextOf(Strategy modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "inContextOf");

    var sliced = modelObj.getInContextOf().stream()
      .map(InContextOf::getContext)
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> (EObject) s, s -> newInfo, this.typesOrder));

    return new SliceStep(sliced, new HashMap<>());
  }

  /**
   * Assure18 rule: V3.1.
   * Visit and slice attached elements.
   */
  private SliceStep ruleContextOf(Contextual modelObj, SliceInfo info) {
    var newInfoVisited = new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "supportedByContextOf");
    var newInfoSliced = new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "contextOf");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var inContextOf : modelObj.getContextOf()) {
      var contextOf = inContextOf.getContextOf();
      if (!this.allVisited.containsKey(contextOf)) {
        // continues to ruleSupportedByContextOf
        visited.merge(contextOf, newInfoVisited, this.typesOrder);
      }
      if (!this.allSliced.containsKey(contextOf)) {
        sliced.merge(contextOf, newInfoSliced, this.typesOrder);
      }
    }

    return new SliceStep(sliced, visited);
  }

  /**
   * Assure18 rule: V3.2.
   * Visit supporting (children) elements, slice supporting elements and attached contexts.
   */
  private SliceStep ruleSupportedByContextOf(Supportable modelObj, SliceInfo info) {
    var newInfo = new SliceInfo(GSNSliceType.RECHECK_CONTENT, modelObj, "supportedByContextOf");
    var visited = new HashMap<EObject, SliceInfo>();
    var sliced = new HashMap<EObject, SliceInfo>();

    for (var supportedBy : modelObj.getSupportedBy()) {
      var supporting = supportedBy.getTarget();
      if (!this.allVisited.containsKey(supporting)) {
        visited.merge(supporting, newInfo, this.typesOrder);
      }
      if (!this.allSliced.containsKey(supporting)) {
        sliced.merge(supporting, newInfo, this.typesOrder);
        if (supporting instanceof Contextualizable contextualizable) {
          for (var inContextOf : contextualizable.getInContextOf()) {
            sliced.merge(inContextOf.getContext(), newInfo, this.typesOrder);
          }
        }
      }
    }
    for (var decorator : modelObj.getDecorators()) {
      if (!this.allVisited.containsKey(decorator)) {
        visited.merge(decorator, newInfo, this.typesOrder);
      }
    }

    return new SliceStep(sliced, visited);
  }

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var sliceStep = switch (info.rule()) {
      case "contextOf" -> ruleContextOf((Contextual) modelObj, info);
      case "inContextOf" -> ruleInContextOf((Strategy) modelObj, info);
      case "supportedBy" -> ruleSupportedBy((Supportable) modelObj, info);
      case "supportedByContextOf" -> ruleSupportedByContextOf((Supportable) modelObj, info);
      case "supportsContent", "supportsState" -> ruleSupports((Supporter) modelObj, info);
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
   */
  @Override
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
    // TODO: With ModelRelPropagation, we lose one step of the prevObj chain, can we even fix it?
    if (critObj instanceof Goal) {
      if (SliceType.DEL.equals(info.typeId()) ||
          SliceType.REVISE.equals(info.typeId())) {
        sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportsContent"));
        sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportedBy"));
      }
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportsState"));
    }
    else if (critObj instanceof Strategy && (
               SliceType.DEL.equals(info.typeId()) ||
               SliceType.REVISE.equals(info.typeId()))) {
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportedBy"));
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "inContextOf"));
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportsState"));
    }
    else if (critObj instanceof Contextual && (
               SliceType.DEL.equals(info.typeId()) ||
               SliceType.REVISE.equals(info.typeId()))) {
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "contextOf"));
    }
    else if (critObj instanceof Solution) {
      if (SliceType.DEL.equals(info.typeId()) ||
          SliceType.REVISE.equals(info.typeId())) {
        sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportsContent"));
      }
      sliceRule(critObj, new SliceInfo(info.typeId(), info.prevObj(), "supportsState"));
    }
  }
}
