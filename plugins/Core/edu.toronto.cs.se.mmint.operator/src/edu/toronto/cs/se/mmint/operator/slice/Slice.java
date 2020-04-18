/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 *  Nick Fung - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * Performs a slice on a model instance starting from a slicing criterion, which is a unary model relation containing
 * the initial model elements to slice, and propagating to other model elements following a set of rules.
 */
public class Slice extends OperatorImpl {

  protected Input input;
  protected Output output;
  protected Map<SliceType, Mapping> sliceTypes;
  protected Map<EObject, SliceInfo> allSliced;
  protected Map<EObject, SliceInfo> allVisited;

  protected static class Input {
    public final static String IN_MODELREL = "criterion";
    public ModelRel critRel;
    public Model model;

    public Input(Map<String, Model> inputsByName) {
      this.critRel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
      if (this.critRel.getModelEndpoints().size() > 1) { // critRel must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.critRel.getModelEndpoints().get(0).getTarget();
    }
  }

  protected static class Output {
    public final static String OUT_MODELREL = "slice";
    public ModelRel sliceRel;
    public MID mid;

    public Output(Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
    }

    public Map<String, Model> packed() {
      return Map.of(Output.OUT_MODELREL, this.sliceRel);
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean isAllowedInput(Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }

    @Override
    public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName,
                                                                        Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var sliceRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      return Map.of(sliceRel, List.of(input.model));
    }
  }

  public enum SliceType {
    ADD("http://se.cs.toronto.edu/mmint/SliceRel/Add", 1),
    DEL("http://se.cs.toronto.edu/mmint/SliceRel/Del", 2),
    MOD("http://se.cs.toronto.edu/mmint/SliceRel/Mod", 3),
    REVISE("http://se.cs.toronto.edu/mmint/SliceRel/Revise", 4),
    RECHECK_CONTENT("http://se.cs.toronto.edu/mmint/SliceRel/RecheckContent", 5),
    RECHECK_STATE("http://se.cs.toronto.edu/mmint/SliceRel/RecheckState", 6);
    public final static Comparator<SliceType> COMPARATOR =
      (type1, type2) -> type1.priority - type2.priority;
    public final String id;
    public final int priority;

    private SliceType(String id, int priority) {
      this.id = id;
      this.priority = priority;
    }

    public static @Nullable SliceType fromMapping(Mapping mapping) {
      var mappingTypeId = mapping.getMetatypeUri();
      for (var type : values()) {
        if (type.id.equals(mappingTypeId)) {
          return type;
        }
      }
      return null;
    }
  };

  protected static class SliceInfo {
    public SliceType type;
    public @Nullable EObject prevObj;
    public @Nullable String rule;
    public final static BinaryOperator<SliceInfo> ORDER_DUPLICATES =
      (info1, info2) -> (info1.type.priority < info2.type.priority) ? info1 : info2;

    public SliceInfo(SliceType type, @Nullable EObject prevObj) {
      this.type = type;
      this.prevObj = prevObj;
    }
    public SliceInfo(SliceType type, @Nullable EObject prevObj, @Nullable String rule) {
      this(type, prevObj);
      this.rule = rule;
    }
  }

  protected class SliceStep {
    public Map<EObject, SliceInfo> sliced;
    public Map<EObject, SliceInfo> visited;
    public SliceStep() {
      var emptyMap = new HashMap<EObject, SliceInfo>();
      this.sliced = emptyMap;
      this.visited = emptyMap;
    }
    public SliceStep(Map<EObject, SliceInfo> sliced, Map<EObject, SliceInfo> visited) {
      this.sliced = sliced;
      this.visited = visited;
    }
    public SliceStep(SliceStep... steps) {
      this.sliced = new HashMap<>();
      this.visited = new HashMap<>();
      for (var step : steps) {
        step.mergeInto(this.sliced, this.visited);
      }
    }
    /**
     * Merges this slice step into existing sets of sliced and visited elements. You should use this function instead of
     * e.g.
     *
     * <pre>
     * {@code
     * SliceStep sliceStep = ...;
     * sliced.putAll(sliceStep.sliced);
     * }
     * </pre>
     *
     * to enforce a reproducible ordering of elements that are sliced multiple times with different slicing types.
     *
     * @param sliced
     *          A map of sliced elements and their slicing info.
     * @param visited
     *          A map of visited elements and their slicing info.
     */
    public void mergeInto(@Nullable Map<EObject, SliceInfo> sliced, @Nullable Map<EObject, SliceInfo> visited) {
      if (sliced != null) {
        this.sliced.forEach((k, v) -> sliced.merge(k, v, SliceInfo.ORDER_DUPLICATES));
      }
      if (visited != null) {
        this.visited.forEach((k, v) -> visited.merge(k, v, SliceInfo.ORDER_DUPLICATES));
      }
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
    this.sliceTypes = new HashMap<>();
    this.allSliced = new HashMap<>();
    this.allVisited = new HashMap<>();
    for (var sliceType : SliceType.values()) {
      var mappingType = MIDTypeRegistry.<Mapping>getType(sliceType.id);
      if (mappingType == null) {
        throw new MMINTException("Missing SliceRel mapping type " + sliceType.id);
      }
      this.sliceTypes.put(sliceType, mappingType);
    }
  }

  /**
   * Gets model objects sliced by applying the rules to a single model object.
   *
   * @param modelObj
   *          The model object to apply the slicing rules to.
   * @param info
   *          The slicing information.
   * @return The model objects to be added to the slice set, the model objects to visit next (they may or may not be
   *         equivalent), and the slicing information applied for each model object.
   */
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    // only rule: contained model objects are sliced and visited
    var sliced = modelObj.eContents().stream()
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> s, s -> new SliceInfo(SliceType.RECHECK_CONTENT, modelObj, "econtents"),
                                SliceInfo.ORDER_DUPLICATES));
    // MERGE_DUPLICATES is not strictly needed here because of eContents() semantics (no duplicates)
    // it's usually good for inheritors, both to avoid the stream exception on duplicates and to order slicing types
    return new SliceStep(sliced, sliced);
  }

  /**
   * Slice model objects recursively, starting from a model object that is part of the input slice criterion and
   * following the slicing rules.
   *
   * @param critObj
   *          The starting model object (part of the slice criterion)
   * @param info
   *          The slicing information.
   */
  protected void sliceCriterionElement(EObject critObj, SliceInfo info) {
//    var slicedInfo = this.allSliced.get(critObj);
//    if (slicedInfo != null && slicedInfo.type == info.type) {
//      // stop early if already sliced with the same slice type
//      return;
//    }
    var visitedCur = Map.of(critObj, info);
    // iterate through the current set of newly sliced model elements
    // to identify the next ones that are going to be sliced
    while (!visitedCur.isEmpty()) {
      var visitedNext = new HashMap<EObject, SliceInfo>();
      for (var visitedObj : visitedCur.entrySet()) {
        // get all model elements directly sliced by the current one without adding duplicates
        var sliceStep = getDirectlySlicedElements(visitedObj.getKey(), visitedObj.getValue());
        sliceStep.mergeInto(this.allSliced, this.allVisited);
        sliceStep.mergeInto(null, visitedNext);
      }
      // prepare for next iteration
      visitedCur = visitedNext;
    }
  }

  protected void slice() throws MMINTException {
    this.output.sliceRel = this.input.critRel.getMetatype()
      .createInstanceAndEndpoints(null, Output.OUT_MODELREL, ECollections.asEList(this.input.model), this.output.mid);
    var sliceModelEndpointRef = this.output.sliceRel.getModelEndpointRefs().get(0);

    // retrieve resource corresponding to the model instance
    var critModelEndpointRef = this.input.critRel.getModelEndpointRefs().get(0);
    var rUri = FileUtils.createEMFUri(critModelEndpointRef.getTargetUri(), true);
    var r = FileUtils.getResource(rUri, null);

    // loop through the input criterion and slice the model elements
    for (var critMapping : this.input.critRel.getMappings()) {
      var critType = SliceType.fromMapping(critMapping);
      for (var critModelElemEndpoint : critMapping.getModelElemEndpoints()) {
        var critModelElem = critModelElemEndpoint.getTarget();
        var critName = critMapping.getName();
        var ruleName = (critName.equals("")) ?
          this.input.model.getName() + "." + critModelElem.getName() :
          critName;
        var info = new SliceInfo(critType, null, ruleName);
        try {
          var critModelObj = critModelElem.getEMFInstanceObject(r);
          // pass criterion to output as-is first
          this.allSliced.merge(critModelObj, info, SliceInfo.ORDER_DUPLICATES);
          this.allVisited.merge(critModelObj, info, SliceInfo.ORDER_DUPLICATES);
          // slice only from external causes or original criterion input
          // e.g. in a fixed-point loop don't re-run from previous internal results
          if (!critName.startsWith(this.input.model.getName())) {
            sliceCriterionElement(critModelObj, info);
          }
        }
        catch (MMINTException e) {
          MMINTException.print(IStatus.WARNING, "Skipping criterion model element " + critModelElem.getName(), e);
        }
      }
    }

    // create output model rel from sliced elements
    for (var sliced : this.allSliced.entrySet()) {
      var modelObj = sliced.getKey();
      var info = sliced.getValue();
      try {
        var modelElemRef = sliceModelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
        var mappingRef = this.sliceTypes.get(info.type).createInstanceAndReferenceAndEndpointsAndReferences(
                           false, ECollections.asEList(modelElemRef));
        String mappingName = null;
        if (info.prevObj == null) { // from criterion
          mappingName = info.rule;
        }
        else {
          var slicerEInfo = MIDRegistry.getModelElementEMFInfo(info.prevObj, MIDLevel.INSTANCES);
          mappingName = this.input.model.getName() + "." +
                        MIDRegistry.getModelElementName(slicerEInfo, info.prevObj, MIDLevel.INSTANCES);
        }
        mappingRef.getObject().setName(mappingName);
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.WARNING, "Skipping sliced model element " + modelObj, e);
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    slice();
    return this.output.packed();
  }
}