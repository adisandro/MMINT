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
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ModelRelPropagation extends OperatorImpl {

  private Input input;
  private Output output;

  private static class Input {
    private final static String IN_MODELREL1 = "original";
    private final static String IN_MODELREL2 = "trace";
    private ModelRel origRel;
    private ModelRel traceRel;
    private Model sharedModel;
    private Model propModel;

    public Input(Map<String, Model> inputsByName) {
      this.origRel = (ModelRel) inputsByName.get(Input.IN_MODELREL1);
      this.traceRel = (ModelRel) inputsByName.get(Input.IN_MODELREL2);
      if (this.origRel == this.traceRel) {
        // must be different rels
        throw new IllegalArgumentException();
      }
      if (this.origRel.getModelEndpoints().size() != 1 || this.traceRel.getModelEndpoints().size() != 2) {
        // origRel must be unary, traceRel must be binary or nary with 2 endpoints
        throw new IllegalArgumentException();
      }
      this.sharedModel = this.origRel.getModelEndpoints().get(0).getTarget();
      var model21 = this.traceRel.getModelEndpoints().get(0).getTarget();
      var model22 = this.traceRel.getModelEndpoints().get(1).getTarget();
      if (this.sharedModel.getUri().equals(model21.getUri())) {
        this.propModel = model22;
      }
      else if (this.sharedModel.getUri().equals(model22.getUri())) {
        this.propModel = model21;
      }
      else {
        // must share a model
        throw new IllegalArgumentException();
      }
      if (
        this.traceRel instanceof BinaryModelRel &&
        !this.sharedModel.getUri().equals(((BinaryModelRel) this.traceRel).getSourceModel().getUri())
      ) {
        // if traceRel is binary, the direction must be from sharedModel to propModel
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    private final static String OUT_MODELREL = "propagated";
    public ModelRel propRel;
    public MID mid;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws MMINTException {
      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
      // propagate to the same rel type if possible, or fallback to the closest supertype
      var propRelType = input.origRel.getMetatype();
      while (propRelType != null) {
        try {
          this.propRel = propRelType
            .createInstanceAndEndpoints(null, Output.OUT_MODELREL, ECollections.newBasicEList(input.propModel), this.mid);
          break;
        }
        catch (MMINTException e) {
          propRelType = (ModelRel) propRelType.getSupertype();
        }
      }
    }

    public Map<String, Model> packed() {
      return Map.of(Output.OUT_MODELREL, this.propRel);
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
      var propRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      return Map.of(propRel, List.of(input.propModel));
    }
  }

  private void propagate() throws MMINTException {

    // prepare the propagated rel
    var propModelEndpointRef = this.output.propRel.getModelEndpointRefs().get(0);
    var propModelPath = this.input.propModel.getUri();
    var propModelEMFUri = FileUtils.createEMFUri(propModelPath, true);
    var propModelEMFResource = FileUtils.getResource(propModelEMFUri, null);
    // get sharedModel elements that are in origRel, in case there are traces for other sharedModel elements
    var origModelObjUris = this.input.origRel.getModelEndpointRefs().get(0).getModelElemRefs().stream()
      .map(origModelElemRef -> MIDRegistry.getModelObjectUri(origModelElemRef.getObject()))
      .collect(Collectors.toSet());
    // loop through traceability mappings (can be n-ary, and not include any sharedModel or propModel model elem)
    var origToProp = new HashMap<String, Set<Set<ModelElementReference>>>();
    for (var traceMapping : this.input.traceRel.getMappings()) {
//TODO MMINT[REL] A binary mapping was really born as a shortcut shape for two endpoints, not a way to express direction
//      if (
//        traceMapping instanceof BinaryMapping &&
//        propModelUri.equals(MIDRegistry.getModelUri(MIDRegistry.getModelObjectUri(
//          traceMapping.getModelElemEndpoints().get(0).getTarget())))
//      ) {
//        // if trace mapping is binary, the direction must be from sharedModel to propModel
//        continue;
//      }
      Set<ModelElement> propModelElems = null;
      Set<ModelElementReference> propModelElemRefs = null;
      for (var traceModelElemEndpoint : traceMapping.getModelElemEndpoints()) {
        var traceModelElem = traceModelElemEndpoint.getTarget();
        var traceModelElemUri = MIDRegistry.getModelObjectUri(traceModelElem);
        if (propModelPath.equals(MIDRegistry.getModelUri(traceModelElemUri))) {
          // collect model elems from propModel to propagate to
          if (propModelElems == null) {
            propModelElems = new HashSet<>();
          }
          propModelElems.add(traceModelElem);
        }
        else if (origModelObjUris.contains(traceModelElemUri)) {
          // collect model elems from sharedModel to propagate from
          //TODO MMINT[SLICE] handle n-ary with multiple from sharedModel
          propModelElemRefs = new HashSet<>();
          origToProp.computeIfAbsent(traceModelElemUri, k -> new HashSet<>()).add(propModelElemRefs);
        }
      }
      // no model elems in either sharedModel or propModel == no propagation for this trace mapping
      if (propModelElems == null || propModelElemRefs == null) {
        continue;
      }
      // propagate model elems
      for (var propModelElem : propModelElems) {
        var propModelElemUri = MIDRegistry.getModelObjectUri(propModelElem);
        var propModelElemRef = propModelEndpointRef.getModelElemRefs().stream()
          .filter(e -> propModelElemUri.equals(MIDRegistry.getModelObjectUri(e.getObject())))
          .findAny();
        propModelElemRefs.add(
          (propModelElemRef.isPresent()) ?
            propModelElemRef.get() :
            propModelEndpointRef.createModelElementInstanceAndReference(
              propModelElem.getEMFInstanceObject(propModelEMFResource), propModelElem.getName()));
      }
    }

    // propagate orig mappings to prop
    for (var origMapping : this.input.origRel.getMappings()) {
      var allTraces = new ArrayList<Set<Set<ModelElementReference>>>();
      for (var origModelElemEndpoint : origMapping.getModelElemEndpoints()) {
        var origModelElem = origModelElemEndpoint.getTarget();
        var origModelElemUri = MIDRegistry.getModelObjectUri(origModelElem);
        var trace = origToProp.get(origModelElemUri);
        if (trace != null) {
          allTraces.add(trace);
        }
      }
      if (allTraces.isEmpty()) { // nothing to propagate
        continue;
      }
      // the pivot trace is the one with the most trace mappings
      // it has meaning for binary/nary orig mappings, where there are other traces
      // while a unary orig mapping has a single trace
      var pivotTrace = Collections.max(allTraces, Comparator.comparingInt(Set::size));
      var propModelElemRefs = new ArrayList<ModelElementReference>();
      for (var trace : allTraces) {
        if (trace == pivotTrace) {
          continue;
        }
        trace.forEach(t -> propModelElemRefs.addAll(t));
      }
      for (var pivotPropModelElemRefs : pivotTrace) {
        var allPropModelElemRefs = ECollections.newBasicEList(propModelElemRefs);
        allPropModelElemRefs.addAll(pivotPropModelElemRefs);
        if (allPropModelElemRefs.isEmpty()) { // nothing to propagate
          continue;
        }
        // propagate to the same mapping type if possible, or fallback to the closest supertype
        var propMappingType = origMapping.getMetatype();
        while (propMappingType != null) {
          try {
            var propMappingRef = propMappingType.createInstanceAndReferenceAndEndpointsAndReferences(
                origMapping instanceof BinaryMapping && allPropModelElemRefs.size() == 2, allPropModelElemRefs);
            propMappingRef.getObject().setName(origMapping.getName());
            break;
          }
          catch (MMINTException e) {
            propMappingType = propMappingType.getSupertype();
          }
        }
      }
    }
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    propagate();
    return this.output.packed();
  }
}
