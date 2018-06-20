/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ModelRelMerge extends OperatorImpl {

    // input-output
    private final static @NonNull String IN_MODELREL1 = "rel1";
    private final static @NonNull String IN_MODELREL2 = "rel2";
    private final static @NonNull String OUT_MODELREL = "merge";
    // constants
    private final static @NonNull String MERGE_SEPARATOR = "+";
    // state
    private Map<String, ModelElementReference> mergedModelElemRefs;
    private Map<Set<String>, MappingReference> mergedMappingRefs;

    private static class Input {

        private ModelRel rel1;
        private ModelRel rel2;
        private Model model1;
        private Model model2;

        public Input(Map<String, Model> inputsByName) {

            this.rel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
            this.rel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
            if (this.rel1 == this.rel2) {
                throw new IllegalArgumentException();
            }
            if (this.rel1.getMetatype() != this.rel2.getMetatype()) {
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
            Model model11 = this.rel1.getModelEndpoints().get(0).getTarget();
            Model model21 = this.rel2.getModelEndpoints().get(0).getTarget();
            if (this.rel1.getModelEndpoints().size() == 1) { // unary
                if (model11.getUri().equals(model21.getUri())) {
                    this.model1 = model11;
                }
            }
            else { // binary
                Model model12 = this.rel1.getModelEndpoints().get(1).getTarget();
                Model model22 = this.rel2.getModelEndpoints().get(1).getTarget();
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

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {

            try {
                new Input(inputsByName);
                return true;
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }

        @Override
        public @NonNull Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            ModelRel mergedRel = (ModelRel) outputsByName.get(OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.model1);
            if (input.model2 != null) {
                endpointModels.add(input.model2);
            }
            validOutputs.put(mergedRel, endpointModels);

            return validOutputs;
        }
    }

    @Override
    public boolean isCommutative() {

        //TODO MMINT[OPERATOR] Should it be in the xml schema, or is it part of the effort to have as much as possible in the code?
        return true;
    }

    private void init() {

        this.mergedModelElemRefs = new HashMap<>();
        this.mergedMappingRefs = new HashMap<>();
    }

    private void populate(ModelRel mergedRel, ModelRel origRel, MID instanceMID) throws MMINTException {

        // models
        for (ModelEndpointReference origModelEndpointRef : origRel.getModelEndpointRefs()) {
            List<ModelEndpointReference> mergedModelEndpointRefs = MIDRegistry.getEndpointReferences(
                origModelEndpointRef.getTargetUri(), mergedRel.getModelEndpointRefs());
            ModelEndpointReference mergedModelEndpointRef;
            if (mergedModelEndpointRefs.isEmpty()) {
                Model model = instanceMID.getExtendibleElement(origModelEndpointRef.getTargetUri());
                mergedModelEndpointRef = origModelEndpointRef.getObject().getMetatype().createInstance(model,
                                                                                                       mergedRel);
            }
            else {
                //TODO MMINT[REDUCE] this is suspect, what about model rels with endpoints to the same model?
                mergedModelEndpointRef = mergedModelEndpointRefs.get(0);
            }
            // model elements
            for (ModelElementReference origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
                ModelElementReference mergedModelElemRef = this.mergedModelElemRefs.get(origModelElemRef.getUri());
                if (mergedModelElemRef == null) {
                    EObject mergedModelObj = origModelElemRef.getObject().getEMFInstanceObject(null);
                    mergedModelElemRef = mergedModelEndpointRef.createModelElementInstanceAndReference(
                        mergedModelObj, origModelElemRef.getObject().getName());
                    this.mergedModelElemRefs.put(mergedModelElemRef.getUri(), mergedModelElemRef);
                }
            }
        }
        // mappings
        for (MappingReference origMappingRef : origRel.getMappingRefs()) {
            Set<String> origMappingRefEndpoints = Collections.unmodifiableSet(
                origMappingRef.getModelElemEndpointRefs().stream()
                    .map(ModelElementEndpointReference::getTargetUri)
                    .collect(Collectors.toSet()));
            MappingReference mergedMappingRef = this.mergedMappingRefs.get(origMappingRefEndpoints);
            if (mergedMappingRef == null) {
                mergedMappingRef = origMappingRef.getObject().getMetatype()
                    .createInstanceAndReference((origMappingRef.getObject() instanceof BinaryMapping), mergedRel);
                mergedMappingRef.getObject().setName(origMappingRef.getObject().getName());
                for (ModelElementEndpointReference origModelElemEndpointRef : origMappingRef.getModelElemEndpointRefs()) {
                    ModelElementReference mergedModelElemRef = this.mergedModelElemRefs.get(
                        origModelElemEndpointRef.getTargetUri());
                    origModelElemEndpointRef.getObject().getMetatype()
                        .createInstanceAndReference(mergedModelElemRef, mergedMappingRef);
                }
                this.mergedMappingRefs.put(origMappingRefEndpoints, mergedMappingRef);
            }
            else {
                // warning: this will merge mappings with same endpoints even from a single rel
                String mergedName = mergedMappingRef.getObject().getName() + MERGE_SEPARATOR +
                                    origMappingRef.getObject().getName();
                mergedMappingRef.getObject().setName(mergedName);
            }
        }
    }

    private @NonNull ModelRel merge(@NonNull ModelRel rel1, @NonNull ModelRel rel2, @NonNull Model model1,
                                    @Nullable Model model2, @NonNull MID instanceMID) throws MMINTException {

        ModelRel mergedRel = null;
        String mergedRelName = rel1.getName() + MERGE_SEPARATOR + rel2.getName();
        if (rel1 instanceof BinaryModelRel && rel2 instanceof BinaryModelRel) { // binary merge
            mergedRel = rel1.getMetatype().createBinaryInstanceAndEndpoints(null, mergedRelName, model1, model2,
                                                                            instanceMID);
        }
        else { // unary merge, or binary merge with nary rel
            EList<Model> models = (model2 == null) ?
                ECollections.asEList(model1) :
                ECollections.asEList(model1, model2);
            mergedRel = rel1.getMetatype().createInstanceAndEndpoints(null, mergedRelName, models, instanceMID);
        }
        populate(mergedRel, rel1, instanceMID);
        populate(mergedRel, rel2, instanceMID);

        return mergedRel;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName,
        java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
        throws Exception {

        // input
        Input input = new Input(inputsByName);
        init();

        // merge the two model rels
        ModelRel mergedRel = this.merge(input.rel1, input.rel2, input.model1, input.model2,
                                        outputMIDsByName.get(OUT_MODELREL));

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, mergedRel);

        return outputsByName;
    }

}
