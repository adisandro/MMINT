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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

  private Input input;
  private Output output;
  private Map<SliceType, Mapping> sliceTypes;
  protected Map<EObject, SliceInfo> allSliced;
  protected Map<EObject, SliceInfo> allVisited;

  private static class Input {
    private final static String IN_MODELREL = "criterion";
    private ModelRel critRel;
    private Model model;

    public Input(Map<String, Model> inputsByName) {
      this.critRel = (ModelRel) inputsByName.get(Input.IN_MODELREL);
      if (this.critRel.getModelEndpoints().size() > 1) { // critRel must be unary
        throw new IllegalArgumentException();
      }
      this.model = this.critRel.getModelEndpoints().get(0).getTarget();
    }
  }

  private static class Output {
    private final static String OUT_MODELREL = "slice";
    private ModelRel sliceRel;
    private MID mid;

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

  protected enum SliceType {
    ADD("http://se.cs.toronto.edu/mmint/SliceRel/Add"),
    DEL("http://se.cs.toronto.edu/mmint/SliceRel/Del"),
    MOD("http://se.cs.toronto.edu/mmint/SliceRel/Mod"),
    REVISE("http://se.cs.toronto.edu/mmint/SliceRel/Revise"),
    RECHECK_CONTENT("http://se.cs.toronto.edu/mmint/SliceRel/RecheckContent"),
    RECHECK_STATE("http://se.cs.toronto.edu/mmint/SliceRel/RecheckState");
    public final String id;

    private SliceType(String id) {
      this.id = id;
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
    public static BinaryOperator<SliceInfo> ORDER_DUPLICATES =
      (info1, info2) -> (info1.type.ordinal() <= info2.type.ordinal()) ? info1 : info2;

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
      .collect(Collectors.toMap(s -> s, s -> new SliceInfo(SliceType.REVISE, modelObj, "econtents"),
                                SliceInfo.ORDER_DUPLICATES));
    // MERGE_DUPLICATES is not needed here because of eContents() semantics, but is a good example for inheritors
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
    var slicedInfo = this.allSliced.get(critObj);
    if (slicedInfo != null && slicedInfo.type == info.type) {
      // stop early if already sliced with the same slice type
      return;
    }

    this.allSliced.put(critObj, info);
    this.allVisited.put(critObj, info);
    var visitedCur = Map.of(critObj, info);
    // iterate through the current set of newly sliced model elements
    // to identify the next ones that are going to be sliced
    while (!visitedCur.isEmpty()) {
      var visitedNext = new HashMap<EObject, SliceInfo>();
      for (var visitedObj : visitedCur.entrySet()) {
        // get all model elements directly sliced by the current one without adding duplicates
        var sliceStep = getDirectlySlicedElements(visitedObj.getKey(), visitedObj.getValue());
        this.allSliced.putAll(sliceStep.sliced);
        this.allVisited.putAll(sliceStep.visited);
        visitedNext.putAll(sliceStep.visited);
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
    var rs = new ResourceSetImpl();
    var r = rs.getResource(rUri, true);

    // loop through the input criterion and slice the model elements
    for (var critMapping : this.input.critRel.getMappings()) {
      var critType = SliceType.fromMapping(critMapping);
      for (var critModelElemEndpoint : critMapping.getModelElemEndpoints()) {
        var critModelElem = critModelElemEndpoint.getTarget();
        var critName = (critMapping.getName().equals("")) ?
          this.input.model.getName() + "." + critModelElem.getName() :
          critMapping.getName();
        try {
          var critModelObj = critModelElem.getEMFInstanceObject(r);
          sliceCriterionElement(critModelObj, new SliceInfo(critType, null, critName));
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