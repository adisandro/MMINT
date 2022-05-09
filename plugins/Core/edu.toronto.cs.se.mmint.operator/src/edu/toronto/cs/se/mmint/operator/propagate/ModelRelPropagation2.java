/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;

import com.google.common.collect.Sets;

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
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ModelRelPropagation2 extends OperatorImpl {
  private In in;
  private Out out;

  private static class In {
    private final static String IN_MODELREL = "original";
    private final static String IN_MODELRELS = "traces";
    private ModelRel origRel;
    private List<ModelRel> traceRels;
    private List<Model> sharedModels;
    private List<Model> propModels;

    public In(Map<String, Model> inputsByName) {
      var relsByName = inputsByName.entrySet().stream()
        .filter(e -> e.getValue() instanceof ModelRel)
        .collect(Collectors.toMap(e -> e.getKey(), e -> (ModelRel) e.getValue()));
      this.origRel = relsByName.get(In.IN_MODELREL);
      this.traceRels = MIDOperatorIOUtils.getVarargs(relsByName, In.IN_MODELRELS);
      if (this.traceRels.size() != this.origRel.getModelEndpoints().size()) {
        // must have one trace rel for each orig rel endpoint
        throw new IllegalArgumentException();
      }
      if (this.traceRels.contains(this.origRel)) {
        // must be different rels
        throw new IllegalArgumentException();
      }
      if (this.traceRels.stream().anyMatch(r -> r.getModelEndpoints().size() != 2)) {
        // trace rels must be binary or nary with 2 endpoints
        throw new IllegalArgumentException();
      }
      this.sharedModels = new ArrayList<>(this.traceRels.size());
      this.propModels = new ArrayList<>(this.traceRels.size());
      for (var traceRel : this.traceRels) {
        var model21 = traceRel.getModelEndpoints().get(0).getTarget();
        var model22 = traceRel.getModelEndpoints().get(1).getTarget();
        Model sharedModel, propModel;
        if (this.origRel.getModelEndpoints().stream()
              .anyMatch(me -> me.getTargetUri().equals(model21.getUri()))) {
          sharedModel = model21;
          propModel = model22;
        }
        else if (this.origRel.getModelEndpoints().stream()
                   .anyMatch(me -> me.getTargetUri().equals(model22.getUri()))) {
          sharedModel = model22;
          propModel = model21;
        }
        else {
          // must share a model
          throw new IllegalArgumentException();
        }
        if (traceRel instanceof BinaryModelRel binaryTraceRel &&
            !sharedModel.getUri().equals(binaryTraceRel.getSourceModel().getUri())) {
          // if trace rel is binary, the direction must be from shared model to prop model
          throw new IllegalArgumentException();
        }
        this.sharedModels.add(sharedModel);
        this.propModels.add(propModel);
      }
    }
  }

  private static class Out {
    private final static String OUT_MODELREL = "propagated";
    public ModelRel propRel;
    public MID mid;

    public Out(In input, Map<String, MID> outputMIDsByName) throws MMINTException {
      this.mid = outputMIDsByName.get(Out.OUT_MODELREL);
      // propagate to the same rel type if possible, or fallback to the closest supertype
      var propRelType = input.origRel.getMetatype();
      while (propRelType != null) {
        try {
          this.propRel = propRelType
            .createInstanceAndEndpoints(null, Out.OUT_MODELREL, ECollections.asEList(input.propModels), this.mid);
          break;
        }
        catch (MMINTException e) {
          propRelType = (ModelRel) propRelType.getSupertype();
        }
      }
    }

    public Map<String, Model> packed() {
      return Map.of(Out.OUT_MODELREL, this.propRel);
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean checkInputs(Map<String, Model> inputsByName) {
      try {
        new In(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }

    @Override
    public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
                                                                 Map<String, Model> inputsByName,
                                                                 Map<String, Model> outputsByName) {
      var input = new In(inputsByName);
      var propRel = (ModelRel) outputsByName.get(Out.OUT_MODELREL);

      return Map.of(propRel, input.propModels);
    }
  }

  private void propagate() throws MMINTException {
    // each trace is a set of orig elems pointing to a set of prop elems
    // there can be some with the same orig elems but different prop elems
    var traces = new HashMap<Set<String>, Set<Set<ModelElementReference>>>();
    for (var i = 0; i < this.in.traceRels.size(); i++) {
      var traceRel = this.in.traceRels.get(i);
      var propModelPath = this.in.propModels.get(i).getUri();
      var sharedModelPath = this.in.sharedModels.get(i).getUri();
      var propModelEndpointRef = this.out.propRel.getModelEndpointRefs().get(i);
      // get only the sharedModel elems that are in origRel, in case there are traces for other sharedModel elems
      var allOrigModelObjUris = this.in.origRel.getModelEndpointRefs().stream()
        .filter(mer -> mer.getTargetUri().equals(sharedModelPath))
        .flatMap(mer -> mer.getModelElemRefs().stream())
        .map(mer -> MIDRegistry.getModelObjectUri(mer.getObject()))
        .collect(Collectors.toSet());
      // loop through traceability mappings (can be n-ary, and not include any sharedModel or propModel elem)
      for (var traceMapping : traceRel.getMappings()) {
//        //TODO MMINT[REL] A binary mapping was really born as a shortcut shape for two endpoints, not as a way to express direction
//        if (
//          traceMapping instanceof BinaryMapping &&
//          propModelPath.equals(MIDRegistry.getModelUri(MIDRegistry.getModelObjectUri(
//            traceMapping.getModelElemEndpoints().get(i).getTarget())))
//        ) {
//          // if trace mapping is binary, the direction must be from sharedModel to propModel
//          continue;
//        }
        Set<String> origModelObjUris = null;
        Set<ModelElement> propModelElems = null;
        for (var traceModelElemEndpoint : traceMapping.getModelElemEndpoints()) {
          var traceModelElem = traceModelElemEndpoint.getTarget();
          var traceModelObjUri = MIDRegistry.getModelObjectUri(traceModelElem);
          if (allOrigModelObjUris.contains(traceModelObjUri)) {
            // collect model elems from sharedModel to propagate from
            if (origModelObjUris == null) {
              origModelObjUris = new HashSet<>();
            }
            origModelObjUris.add(traceModelObjUri);
          }
          else if (propModelPath.equals(MIDRegistry.getModelUri(traceModelObjUri))) {
            // collect model elems from propModel to propagate to
            if (propModelElems == null) {
              propModelElems = new HashSet<>();
            }
            propModelElems.add(traceModelElem);
          }
        }
        // no model elems in either sharedModel or propModel == no propagation for this trace mapping
        if (origModelObjUris == null || propModelElems == null) {
          continue;
        }
        var propModelElemRefs = new HashSet<ModelElementReference>();
        traces.computeIfAbsent(origModelObjUris, k -> new HashSet<>()).add(propModelElemRefs);
        // propagate model elems
        for (var propModelElem : propModelElems) {
          var propModelObjUri = MIDRegistry.getModelObjectUri(propModelElem);
          var propModelElemRefOpt = propModelEndpointRef.getModelElemRefs().stream()
            .filter(mer -> propModelObjUri.equals(MIDRegistry.getModelObjectUri(mer.getObject())))
            .findAny();
          var propModelElemRef = (propModelElemRefOpt.isPresent()) ?
            propModelElemRefOpt.get() :
            propModelEndpointRef.createModelElementInstanceAndReference(propModelElem.getEMFInstanceObject(),
                                                                        propModelElem.getName());
          propModelElemRefs.add(propModelElemRef);
        }
      }
    }

    // propagate orig mappings to prop
origMappings:
    for (var origMapping : this.in.origRel.getMappings()) {
      var origModelObjUrisByModel = new HashMap<String, Set<String>>();
      // split orig elems by model
      for (var origModelElemEndpoint : origMapping.getModelElemEndpoints()) {
        var origModelObjUri = MIDRegistry.getModelObjectUri(origModelElemEndpoint.getTarget());
        var origModelPath = MIDRegistry.getModelUri(origModelObjUri);
        origModelObjUrisByModel.computeIfAbsent(origModelPath, k -> new HashSet<>()).add(origModelObjUri);
      }
      // split traces by model
      var tracesByModel = new ArrayList<Set<Set<ModelElementReference>>>();
      for (var origModelObjUris : origModelObjUrisByModel.values()) {
        var traceSet = traces.get(origModelObjUris);
        if (traceSet == null) {
          // all orig elems must be in the trace for the orig mapping to be propagated
          continue origMappings;
        }
        tracesByModel.add(traceSet);
      }
      // do cartesian product (for traces with same orig elems and different prop elems)
      var cartesianTraces = Sets.cartesianProduct(tracesByModel);
      for (var cartesianEntry : cartesianTraces) {
        var allPropModelElemRefs = new ArrayList<ModelElementReference>();
        for (var propModelElemRefs : cartesianEntry) {
          allPropModelElemRefs.addAll(propModelElemRefs);
        }
        // propagate to the same mapping type if possible, or fallback to the closest supertype
        var propMappingType = origMapping.getMetatype();
        while (propMappingType != null) {
          try {
            var propMappingRef = propMappingType.createInstanceAndReferenceAndEndpointsAndReferences(
              origMapping instanceof BinaryMapping && allPropModelElemRefs.size() == 2,
              ECollections.asEList(allPropModelElemRefs));
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
    this.in = new In(inputsByName);
    this.out = new Out(this.in, outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    propagate();

    return this.out.packed();
  }
}
