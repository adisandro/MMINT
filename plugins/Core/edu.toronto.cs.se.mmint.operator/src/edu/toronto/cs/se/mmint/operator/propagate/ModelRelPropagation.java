/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ModelRelPropagation extends OperatorImpl {

    private final static @NonNull String IN_MODELREL1 = "original";
    private final static @NonNull String IN_MODELREL2 = "trace";
    private final static @NonNull String OUT_MODELREL = "propagated";

    private static class Input {

        private ModelRel origRel;
        private ModelRel traceRel;
        private Model sharedModel;
        private Model propModel;

        public Input(Map<String, Model> inputsByName) {

            this.origRel = (ModelRel) inputsByName.get(IN_MODELREL1);
            this.traceRel = (ModelRel) inputsByName.get(IN_MODELREL2);
            if (this.origRel == this.traceRel) {
                // must be different rels
                throw new IllegalArgumentException();
            }
            if (this.origRel.getModelEndpoints().size() != 1 || this.traceRel.getModelEndpoints().size() != 2) {
                // origRel must be unary, traceRel must be binary or nary with 2 endpoints
                throw new IllegalArgumentException();
            }
            this.sharedModel = this.origRel.getModelEndpoints().get(0).getTarget();
            Model model21 = this.traceRel.getModelEndpoints().get(0).getTarget();
            Model model22 = this.traceRel.getModelEndpoints().get(1).getTarget();
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
        public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            ModelRel propRel = (ModelRel) outputsByName.get(OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.propModel);
            validOutputs.put(propRel, endpointModels);

            return validOutputs;
        }
    }

    private ModelRel propagate(ModelRel origRel, ModelRel traceRel, Model sharedModel, Model propModel, MID outputMID) throws MMINTException {

        // prepare the propagated rel
        ModelRel propRel = origRel.getMetatype()
                                  .createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(propModel),
                                                              outputMID);
        ModelEndpointReference propModel2EndpointRef = propRel.getModelEndpointRefs().get(0);
        String propModelUri = propModel.getUri();
        URI propModelEMFUri = FileUtils.createEMFUri(propModelUri, true);
        Resource propModelEMFResource = new ResourceSetImpl().getResource(propModelEMFUri, true);

        // get uris of original model objects
        Set<String> origModelObjUris = origRel.getModelEndpointRefs().get(0).getModelElemRefs().stream()
            .map(origModelElemRef -> MIDRegistry.getModelObjectUri(origModelElemRef.getObject()))
            .collect(Collectors.toSet());

        // loop through traceability mappings (can be n-ary, and not include any original model object)
        Map<String, Set<ModelElementReference>> origToProp = new HashMap<>();
        for (Mapping traceMapping : traceRel.getMappings()) {
            if (
                traceMapping instanceof BinaryMapping &&
                propModelUri.equals(MIDRegistry.getModelUri(
                    MIDRegistry.getModelObjectUri(traceMapping.getModelElemEndpoints().get(0).getTarget())))
            ) {
                // if trace mapping is binary, the direction must be from sharedModel to propModel
                continue;
            }
            Set<ModelElement> propModelElems = new HashSet<>();
            Set<ModelElementReference> propModelElemRefs = null;
            for (ModelElementEndpoint traceModelElemEndpoint : traceMapping.getModelElemEndpoints()) {
                ModelElement traceModelElem = traceModelElemEndpoint.getTarget();
                String traceModelElemUri = MIDRegistry.getModelObjectUri(traceModelElem);
                // propagate if a model elem from sharedModel is found
                if (origModelObjUris.contains(traceModelElemUri)) {
                    //TODO MMINT[SLICE] handle n-ary with multiple from sharedModel
                    propModelElemRefs = origToProp.get(traceModelElemUri);
                    if (propModelElemRefs == null) {
                        propModelElemRefs = new HashSet<>();
                        origToProp.put(traceModelElemUri, propModelElemRefs);
                    }
                    continue;
                }
                // collect model elems from propModel to propagate
                if (traceModelElemUri.startsWith(propModelUri)) {
                    propModelElems.add(traceModelElem);
                }
            }
            // no model elems from sharedModel == no propagation for this trace mapping
            if (propModelElemRefs == null) {
                continue;
            }
            // propagate model elems
            for (ModelElement propModelElem : propModelElems) {
                EObject propModelObj = propModelElem.getEMFInstanceObject(propModelEMFResource);
                ModelElementReference propModelElemRef = propModel2EndpointRef.createModelElementInstanceAndReference(
                                                             propModelObj, null);
                propModelElemRefs.add(propModelElemRef);
            }
        }

        // loop through orig mappings, and propagate them to prop
        for (Mapping origMapping : origRel.getMappings()) {
            EList<ModelElementReference> propModelElemRefs = ECollections.newBasicEList();
            for (ModelElementEndpoint origModelElemEndpoint : origMapping.getModelElemEndpoints()) {
                ModelElement origModelElem = origModelElemEndpoint.getTarget();
                String origModelElemUri = MIDRegistry.getModelObjectUri(origModelElem);
                Set<ModelElementReference> propModelElemRefs2 = origToProp.get(origModelElemUri);
                if (propModelElemRefs2 != null) {
                    propModelElemRefs.addAll(propModelElemRefs2);
                }
            }
            if (propModelElemRefs.isEmpty()) { // nothing to propagate
                continue;
            }
            // propagate mapping
            MappingReference propMappingRef = origMapping.getMetatype()
                .createInstanceAndReferenceAndEndpointsAndReferences(
                    origMapping instanceof BinaryMapping && propModelElemRefs.size() == 2, propModelElemRefs);
            propMappingRef.getObject().setName(origMapping.getName());
        }

        return propRel;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {

        // input
        Input input = new Input(inputsByName);
        MID outputMID = outputMIDsByName.get(OUT_MODELREL);

        // propagate the unary original rel through the trace rel
        ModelRel propRel = propagate(input.origRel, input.traceRel, input.sharedModel, input.propModel, outputMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, propRel);

        return outputsByName;
    }

}
