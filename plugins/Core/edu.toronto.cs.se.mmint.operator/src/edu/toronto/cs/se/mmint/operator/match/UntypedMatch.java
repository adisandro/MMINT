/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.match;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class UntypedMatch extends OperatorImpl {

    // input-output
    private final static @NonNull String IN_MODEL1 = "model1";
    private final static @NonNull String IN_MODEL2 = "model2";
    private final static @NonNull String OUT_MODELREL = "overlap";
    private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE = "matchAttribute";
    private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE_DEFAULT = "name";
    // constants
    private final static @NonNull String MATCH_SEPARATOR = "∩";
    // state
    protected String matchAttribute;
    protected ModelRel modelRelType;
    protected ModelEndpoint modelTypeEndpoint;
    protected Mapping mappingType;
    protected ModelElementEndpoint modelElemTypeEndpoint;

    protected static class Input {

        protected Model model1;
        protected Model model2;

        public Input(Map<String, Model> inputsByName) {

            this.model1 = inputsByName.get(IN_MODEL1);
            this.model2 = inputsByName.get(IN_MODEL2);
            if (this.model1.getUri().equals(this.model2.getUri())) {
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
        public @NonNull Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, @NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            ModelRel matchRel = (ModelRel) outputsByName.get(OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.model1);
            endpointModels.add(input.model2);
            validOutputs.put(matchRel, endpointModels);

            return validOutputs;
        }
    }

    @Override
    public boolean isCommutative() {

        return true;
    }

    @Override
    public void readInputProperties(Properties inputProperties) throws MMINTException {

        this.matchAttribute = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, PROPERTY_IN_MATCHATTRIBUTE, PROPERTY_IN_MATCHATTRIBUTE_DEFAULT);
    }

    protected void init() {

        this.modelRelType = MIDTypeHierarchy.getRootModelRelType();
        //TODO MMINT[MODELREL] Make it easier to pick/create the rest once the model rel type is chosen
        this.modelTypeEndpoint = MIDTypeHierarchy.getRootModelTypeEndpoint();
        this.mappingType = MIDTypeHierarchy.getRootMappingType();
        this.modelElemTypeEndpoint = MIDTypeHierarchy.getRootModelElementTypeEndpoint();
    }

    private void matchModelObjAttributes(EObject modelObj, ModelEndpointReference modelEndpointRef, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) {

        Object modelObjAttr;
        try {
            modelObjAttr = FileUtils.getModelObjectFeature(modelObj, this.matchAttribute);
            if (modelObjAttr != null && modelObjAttr instanceof String) {
                Set<EObject> modelObjs = modelObjAttrs.get(modelObjAttr);
                if (modelObjs == null) {
                    modelObjs = new HashSet<>();
                    modelObjAttrs.put((String) modelObjAttr, modelObjs);
                }
                modelObjs.add(modelObj);
                modelObjTable.put(modelObj, modelEndpointRef);
            }
        }
        catch (MMINTException e) {
            // do nothing
        }
        for (EObject contained : modelObj.eContents()) {
            this.matchModelObjAttributes(contained, modelEndpointRef, modelObjAttrs, modelObjTable);
        }
    }

    protected void createMatchLinks(ModelRel overlapRel, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {

        for (Entry<String, Set<EObject>> entry : modelObjAttrs.entrySet()) {
            Set<EObject> modelObjs = entry.getValue();
            if (modelObjs.size() < 2) {
                continue;
            }
            String modelObjAttr = entry.getKey();
            // create link
            MappingReference matchMappingRef = this.mappingType.createInstanceAndReference(false, overlapRel);
            matchMappingRef.getObject().setName(modelObjAttr);
            for (EObject modelObj : modelObjs) {
                ModelEndpointReference modelEndpointRef = modelObjTable.get(modelObj);
                // create model element
                ModelElementReference matchModelElemRef = modelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
                // create model element endpoints
                this.modelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchMappingRef);
            }
        }
    }

    private ModelRel match(List<Model> models, MID instanceMID) throws MMINTException, IOException {

        // create model relationship among models
        String overlapRelName = String.join(MATCH_SEPARATOR,
                                            models.stream().map(Model::getName).collect(Collectors.toList()));
        ModelRel overlapRel = (ModelRel) this.modelRelType.createInstance(null, overlapRelName, instanceMID);
        // loop through selected models
        Map<String, Set<EObject>> modelObjAttrs = new HashMap<>();
        Map<EObject, ModelEndpointReference> modelObjTable = new HashMap<>();
        for (Model model : models) {
            // create model endpoint
            ModelEndpointReference newModelEndpointRef = this.modelTypeEndpoint.createInstance(model, overlapRel);
            // look for identical names in the models
            this.matchModelObjAttributes(model.getEMFInstanceRoot(), newModelEndpointRef, modelObjAttrs, modelObjTable);
        }
        // create model relationship links
        this.createMatchLinks(overlapRel, modelObjAttrs, modelObjTable);

        return overlapRel;
    }

    @Override
    public Map<String, Model> run(
            Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {

        // input
        Input input = new Input(inputsByName);
        this.init();

        // create match
        List<Model> models = new ArrayList<>();
        models.add(input.model1);
        models.add(input.model2);
        ModelRel overlapRel = this.match(models, outputMIDsByName.get(OUT_MODELREL));

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, overlapRel);

        return outputsByName;
    }

}
