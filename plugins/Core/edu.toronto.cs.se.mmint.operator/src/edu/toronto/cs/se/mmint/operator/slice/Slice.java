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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
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
  protected Map<EObject, SliceType> alreadySliced;
  protected Map<EObject, SliceType> alreadyVisited;

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

  protected class SliceObject {
    public EObject modelObj;
    public SliceType type;
    public SliceObject(EObject modelObj, SliceType type) {
      this.modelObj = modelObj;
      this.type = type;
    }
  }

  protected class SliceStep {
    public Set<SliceObject> sliced;
    public Set<SliceObject> visited;
    public SliceStep(Set<SliceObject> sliced, Set<SliceObject> visited) {
      this.sliced = sliced;
      this.visited = visited;
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
    this.sliceTypes = new HashMap<>();
    this.alreadySliced = new HashMap<>();
    this.alreadyVisited = new HashMap<>();
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
   * @param sliceObj
   *          The model object to apply the slicing rules to, together with its type of slicing.
   * @return The model objects to be added to the slice set, the model objects to visit next (they may or may not be
   *         equivalent), and the type of slicing applied for each model object.
   */
  protected SliceStep getDirectlySlicedElements(SliceObject sliceObj) {
    // only rule: contained model objects are sliced and visited
    var sliced = sliceObj.modelObj.eContents().stream()
      .filter(obj -> !this.alreadySliced.containsKey(obj))
      .map(obj -> new SliceObject(obj, SliceType.REVISE))
      .collect(Collectors.toSet());
    return new SliceStep(sliced, sliced);
  }

  /**
   * Gets all sliced model objects recursively, starting from a model object that is part of the input slice criterion
   * and following the slicing rules.
   *
   * @param critObj
   *          The starting model object (part of the slice criterion), together with its type of slicing.
   * @return The sliced model objects as keys, together with their type of slicing, and the model object that caused
   *         them to be sliced as values.
   */
  protected Map<SliceObject, EObject> getAllSlicedElements(SliceObject critObj) {
    var sliced = new HashMap<SliceObject, EObject>();
    sliced.put(critObj, null);
    this.alreadySliced.put(critObj.modelObj, critObj.type);
    var visitedCur = Set.of(critObj);
    this.alreadyVisited.put(critObj.modelObj, critObj.type);

    // iterate through the current set of newly sliced model elements
    // to identify the next ones that are going to be sliced
    while (!visitedCur.isEmpty()) {
      var visitedNext = new HashSet<SliceObject>();
      for (var visitedObj : visitedCur) {
        // get all model elements directly sliced by the current one without adding duplicates
        var slicedObjs = getDirectlySlicedElements(visitedObj);
        slicedObjs.sliced.stream().forEach(s -> {
          sliced.put(s, visitedObj.modelObj);
          this.alreadySliced.put(s.modelObj, s.type); });
        slicedObjs.visited.stream().forEach(v -> {
          visitedNext.add(v);
          this.alreadyVisited.put(v.modelObj, v.type); });
      }
      // prepare for next iteration
      visitedCur = visitedNext;
    }

    return sliced;
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

    // loop through the model objects in the input criterion
    for (var critModelElemRef : critModelEndpointRef.getModelElemRefs()) {
      try {
        var critModelObj = critModelElemRef.getObject().getEMFInstanceObject(r);
        Mapping critMapping = null;
        SliceType critType = null;
        if (critModelElemRef.getModelElemEndpointRefs().size() == 1) { // criterion with info about previous slice steps
          critMapping = ((MappingReference) critModelElemRef.getModelElemEndpointRefs().get(0).eContainer())
                          .getObject();
          critType = SliceType.fromMapping(critMapping);
        }
        // add sliced elements to the output model relation
        var slicedFromCrit = getAllSlicedElements(new SliceObject(critModelObj, critType));
        for (var slicedFromCritEntry : slicedFromCrit.entrySet()) {
          var slicee = slicedFromCritEntry.getKey();
          var slicer = slicedFromCritEntry.getValue();
          try {
            var sliceModelElemRef = sliceModelEndpointRef.createModelElementInstanceAndReference(slicee.modelObj, null);
            var sliceMappingRef = this.sliceTypes.get(slicee.type).createInstanceAndReferenceAndEndpointsAndReferences(
                                    false, ECollections.asEList(sliceModelElemRef));
            String slicerName = null;
            if (slicer == null) { // slicee == critModelObj
              slicerName = (critMapping == null) ?
                this.input.model.getName() + "." + critModelElemRef.getObject().getName() :
                critMapping.getName();
            }
            else {
              var slicerEInfo = MIDRegistry.getModelElementEMFInfo(slicer, MIDLevel.INSTANCES);
              slicerName = this.input.model.getName() + "." +
                           MIDRegistry.getModelElementName(slicerEInfo, slicer, MIDLevel.INSTANCES);
            }
            sliceMappingRef.getObject().setName(slicerName);
          }
          catch (MMINTException e) {
            MMINTException.print(IStatus.WARNING, "Skipping sliced model element " + slicee.modelObj, e);
          }
        }
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.WARNING,
                             "Skipping criterion model element " + critModelElemRef.getObject().getName(), e);
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