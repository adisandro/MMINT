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
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * Performs a slice on a model instance starting from a slicing criterion, which is a unary model relation containing
 * the initial model elements to slice, and propagating to other model elements following a set of rules.
 */
public class Slice extends OperatorImpl {

  protected Input input;
  protected Output output;
  protected Map<String, SliceType> sliceTypes;
  protected Map<EObject, SliceInfo> allSliced;
  protected Map<EObject, SliceInfo> allVisited;
  protected BinaryOperator<SliceInfo> typesOrder;

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
    public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                        Map<String, Model> inputsByName, Map<String, Model> outputsByName) {
      var input = new Input(inputsByName);
      var sliceRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      return Map.of(sliceRel, List.of(input.model));
    }
  }

  public static class SliceType {
    public static final String ADD = "http://se.cs.toronto.edu/mmint/SliceRel/Add";
    public static final String DEL = "http://se.cs.toronto.edu/mmint/SliceRel/Del";
    public static final String MOD = "http://se.cs.toronto.edu/mmint/SliceRel/Mod";
    public static final String REVISE = "http://se.cs.toronto.edu/mmint/SliceRel/Revise";
    public static final String RECHECK = "http://se.cs.toronto.edu/mmint/SliceRel/Recheck";
    public @Nullable Mapping mappingType;
    public int priority;
    public SliceType(String id, int priority) throws MMINTException {
      this.mappingType = MIDTypeRegistry.<Mapping>getType(id);
      if (this.mappingType == null) {
        throw new MMINTException("Missing slice mapping type " + id);
      }
      this.priority = priority;
    }
  }

  protected static class SliceInfo {
    public String typeId;
    public @Nullable EObject prevObj;
    public @Nullable String rule;
    public SliceInfo(String typeId, @Nullable EObject prevObj) {
      this.typeId = typeId;
      this.prevObj = prevObj;
    }
    public SliceInfo(String typeId, @Nullable EObject prevObj, @Nullable String rule) {
      this(typeId, prevObj);
      this.rule = rule;
    }
    public SliceInfo(SliceInfo info) {
      this(info.typeId, info.prevObj, info.rule);
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
        this.sliced.forEach((k, v) -> sliced.merge(k, v, Slice.this.typesOrder));
      }
      if (visited != null) {
        this.visited.forEach((k, v) -> visited.merge(k, v, Slice.this.typesOrder));
      }
    }
  }

  protected void basicInit(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
    this.allSliced = new HashMap<>();
    this.allVisited = new HashMap<>();
    // allow priorities to be modifiable by slicers
    this.sliceTypes = new HashMap<>();
    this.sliceTypes.put(SliceType.ADD, new SliceType(SliceType.ADD, 10));
    this.sliceTypes.put(SliceType.DEL, new SliceType(SliceType.DEL, 20));
    this.sliceTypes.put(SliceType.MOD, new SliceType(SliceType.MOD, 30));
    this.sliceTypes.put(SliceType.REVISE, new SliceType(SliceType.REVISE, 40));
    this.sliceTypes.put(SliceType.RECHECK, new SliceType(SliceType.RECHECK, 50));
    this.typesOrder = (info1, info2) ->
      (this.sliceTypes.get(info1.typeId).priority < this.sliceTypes.get(info2.typeId).priority) ?
        info1 :
        info2;
  }

  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    basicInit(inputsByName, outputMIDsByName);
    this.output.sliceRel = this.input.critRel.getMetatype()
      .createInstanceAndEndpoints(null, Output.OUT_MODELREL, ECollections.asEList(this.input.model), this.output.mid);
  }

  /**
   * Utility function for inheritors.
   */
  protected void add(@Nullable EObject candidateObj, SliceInfo info, HashMap<EObject, SliceInfo> results,
                     Map<EObject, SliceInfo> exclusions) {
    if (candidateObj != null && !exclusions.containsKey(candidateObj)) {
      results.merge(candidateObj, info, this.typesOrder);
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
      .collect(Collectors.toMap(s -> s, s -> new SliceInfo(SliceType.RECHECK, modelObj, "econtents"),
                                this.typesOrder));
    // ORDER_DUPLICATES is not strictly needed here because of eContents() semantics (no duplicates)
    // it's useful for inheritors, both to avoid the stream exception on duplicates and to order annotations by priority
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
    // retrieve resource corresponding to the model instance
    var critModelEndpointRef = this.input.critRel.getModelEndpointRefs().get(0);

    // loop through the input criterion and slice the model elements
    for (var critMapping : this.input.critRel.getMappings()) {
      for (var critModelElemEndpoint : critMapping.getModelElemEndpoints()) {
        var critModelElem = critModelElemEndpoint.getTarget();
        var critName = critMapping.getName();
        var ruleName = (critName.equals("")) ?
          this.input.model.getName() + "." + critModelElem.getName() :
          critName;
        var info = new SliceInfo(critMapping.getMetatypeUri(), null, ruleName);
        var critModelObj = critModelElem.getEMFInstanceObject();
        if (critModelObj == null) {
          continue;
        }
        // pass criterion to output as-is first
        this.allSliced.merge(critModelObj, info, this.typesOrder);
        this.allVisited.merge(critModelObj, info, this.typesOrder);
        // slice only from external causes or original criterion input
        // e.g. in a fixed-point loop don't re-run from previous internal results
        if (!critName.startsWith(this.input.model.getName())) {
          sliceCriterionElement(critModelObj, info);
        }
      }
    }

    // create output model rel from sliced elements
    var sliceModelEndpointRef = this.output.sliceRel.getModelEndpointRefs().get(0);
    for (var sliced : this.allSliced.entrySet()) {
      var modelObj = sliced.getKey();
      var info = sliced.getValue();
      try {
        var modelElemRef = sliceModelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
        var mappingRef = this.sliceTypes.get(info.typeId).mappingType
          .createInstanceAndReferenceAndEndpointsAndReferences(false, ECollections.asEList(modelElemRef));
        while (info.prevObj != null && !this.allSliced.containsKey(info.prevObj)) {
          // navigate the chain of visited objs, if any, to get the last sliced prevObj
          info = this.allVisited.get(info.prevObj);
        }
        String mappingName = null;
        if (info.prevObj == null) {
          // from criterion
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