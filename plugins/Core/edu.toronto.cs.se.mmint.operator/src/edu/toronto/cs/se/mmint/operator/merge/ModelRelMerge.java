/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.merge;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ModelRelMerge extends OperatorImpl {

  private Input input;
  private Output output;
  private Map<String, ModelElementReference> mergedModelElemRefs;
  private Map<Set<String>, MappingReference> mergedMappingRefs;

  private static class Input {
    private final static String IN_MODELREL1 = "rel1";
    private final static String IN_MODELREL2 = "rel2";
    private ModelRel rel1;
    private ModelRel rel2;
    private Model model1;
    private Model model2;

    public Input(Map<String, Model> inputsByName) {
      this.rel1 = (ModelRel) inputsByName.get(Input.IN_MODELREL1);
      this.rel2 = (ModelRel) inputsByName.get(Input.IN_MODELREL2);
      if (this.rel1 == this.rel2) {
        throw new IllegalArgumentException();
      }
      if ( // works with unary and binary rels, as long as they're both unary or both binary
        this.rel1.getModelEndpoints().size() == 0 ||
        this.rel2.getModelEndpoints().size() == 0 ||
        this.rel1.getModelEndpoints().size() > 2 ||
        this.rel2.getModelEndpoints().size() > 2 ||
        this.rel1.getModelEndpoints().size() != this.rel2.getModelEndpoints().size()
      ) {
        throw new IllegalArgumentException();
      }
      this.model1 = null;
      this.model2 = null;
      var model11 = this.rel1.getModelEndpoints().get(0).getTarget();
      var model21 = this.rel2.getModelEndpoints().get(0).getTarget();
      if (this.rel1.getModelEndpoints().size() == 1) { // unary
        if (model11.getUri().equals(model21.getUri())) {
          this.model1 = model11;
        }
      }
      else { // binary
        var model12 = this.rel1.getModelEndpoints().get(1).getTarget();
        var model22 = this.rel2.getModelEndpoints().get(1).getTarget();
        if (model11.getUri().equals(model21.getUri()) && model12.getUri().equals(model22.getUri())) {
          this.model1 = model11;
          this.model2 = model22;
        }
        else if (model11.getUri().equals(model22.getUri()) && model12.getUri().equals(model21.getUri())) {
          this.model1 = model11;
          this.model2 = model21;
        }
      }
      if (this.model1 == null) { // model paths don't match
        throw new IllegalArgumentException();
      }
    }
  }

  private static class Output {
    public final static String OUT_SEPARATOR = "+";
    private final static String OUT_MODELREL = "merged";
    private ModelRel mergedRel;
    private MID mid;

    public Output(Input input, Map<String, MID> outputMIDsByName) throws MMINTException {
      this.mid = outputMIDsByName.get(Output.OUT_MODELREL);
      // merge to the same rel type if possible, or go up to the lowest common subtype
      ModelRel mergedRelType = null;
      var rel1Type = input.rel1.getMetatype();
      var rel2Type = input.rel2.getMetatype();
      if (rel1Type == rel2Type) {
        mergedRelType = rel1Type;
      }
      else if (MIDTypeHierarchy.isSubtypeOf(rel1Type.getUri(), rel2Type.getUri())) {
        mergedRelType = rel1Type;
      }
      else if (MIDTypeHierarchy.isSubtypeOf(rel2Type.getUri(), rel1Type.getUri())) {
        mergedRelType = rel2Type;
      }
      else {
        // TODO MMINT[MERGE] Run a proper lowest common subtype algorithm
        throw new IllegalArgumentException();
      }
      var mergedRelName = input.rel1.getName() + Output.OUT_SEPARATOR + input.rel2.getName();
      if (input.rel1 instanceof BinaryModelRel && input.rel2 instanceof BinaryModelRel) {
        // binary merge
        this.mergedRel = mergedRelType.createBinaryInstanceAndEndpoints(null, mergedRelName, input.model1, input.model2,
                                                                        this.mid);
      }
      else {
        // unary merge, or binary merge with nary rel
        var models = (input.model2 == null) ?
          ECollections.asEList(input.model1) :
          ECollections.asEList(input.model1, input.model2);
        this.mergedRel = mergedRelType.createInstanceAndEndpoints(null, mergedRelName, models, this.mid);
      }
    }

    public Map<String, Model> packed() {
      return Map.of(Output.OUT_MODELREL, this.mergedRel);
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
      var mergedRel = (ModelRel) outputsByName.get(Output.OUT_MODELREL);
      mergedRel.setMetatypeUri(input.rel1.getMetatypeUri());
      var endpointModels = (input.model2 == null) ?
        List.of(input.model1) :
        List.of(input.model1, input.model2);
      return Map.of(mergedRel, endpointModels);
    }
  }

  @Override
  public boolean isCommutative() {
    //TODO MMINT[OPERATOR] Should it be in the xml schema, or is it part of the effort to have as much as possible in the code?
    return true;
  }

  private void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    this.mergedModelElemRefs = new HashMap<>();
    this.mergedMappingRefs = new HashMap<>();
    this.input = new Input(inputsByName);
    this.output = new Output(this.input, outputMIDsByName);
  }

  private void merge(ModelRel origRel) throws MMINTException {
    // TODO MMINT[MERGE] merged model elems and mappings should not take the orig type as-is, but check for potential overriding first
    // models
    for (var origModelEndpointRef : origRel.getModelEndpointRefs()) {
      var mergedModelEndpointRefs = MIDRegistry.getEndpointReferences(
        origModelEndpointRef.getTargetUri(), this.output.mergedRel.getModelEndpointRefs());
      //TODO MMINT[REDUCE] this is suspect, what about model rels with endpoints to the same model?
      var mergedModelEndpointRef = mergedModelEndpointRefs.get(0);
      // model elements
      for (var origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
        var mergedModelElemRef = this.mergedModelElemRefs.get(origModelElemRef.getUri());
        if (mergedModelElemRef == null) {
          var mergedModelObj = origModelElemRef.getObject().getEMFInstanceObject();
          mergedModelElemRef = mergedModelEndpointRef.createModelElementInstanceAndReference(
            mergedModelObj, origModelElemRef.getObject().getName());
          this.mergedModelElemRefs.put(mergedModelElemRef.getUri(), mergedModelElemRef);
        }
      }
    }
    // mappings
    for (var origMappingRef : origRel.getMappingRefs()) {
      // warning: this will merge mappings with same endpoints and type even from a single rel
      var origMapping = origMappingRef.getObject();
      var origMappingRefKey = Collections.unmodifiableSet(
        Stream.concat(
          Stream.of(origMapping.getMetatypeUri()), // don't merge mappings of different type
          origMappingRef.getModelElemEndpointRefs().stream().map(ModelElementEndpointReference::getTargetUri))
        .collect(Collectors.toSet()));
      var mergedMappingRef = this.mergedMappingRefs.get(origMappingRefKey);
      if (mergedMappingRef == null) {
        mergedMappingRef = origMapping.getMetatype()
          .createInstanceAndReference((origMapping instanceof BinaryMapping), this.output.mergedRel);
        mergedMappingRef.getObject().setName(origMapping.getName());
        for (var origModelElemEndpointRef : origMappingRef.getModelElemEndpointRefs()) {
          var mergedModelElemRef = this.mergedModelElemRefs.get(origModelElemEndpointRef.getTargetUri());
          origModelElemEndpointRef.getObject().getMetatype()
            .createInstanceAndReference(mergedModelElemRef, mergedMappingRef);
        }
        this.mergedMappingRefs.put(origMappingRefKey, mergedMappingRef);
      }
      else {
        var mergedName = mergedMappingRef.getObject().getName();
        if (!mergedName.equals(origMapping.getName())) {
          mergedName = mergedMappingRef.getObject().getName() + Output.OUT_SEPARATOR + origMapping.getName();
          mergedMappingRef.getObject().setName(mergedName);
        }
      }
    }
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    init(inputsByName, outputMIDsByName);
    merge(this.input.rel1);
    merge(this.input.rel2);
    return this.output.packed();
  }
}
