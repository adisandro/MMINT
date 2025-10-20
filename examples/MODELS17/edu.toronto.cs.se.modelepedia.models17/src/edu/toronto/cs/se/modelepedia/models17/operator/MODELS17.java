/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.models17.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class MODELS17 extends OperatorImpl {

    // input-output
    private final static @NonNull String IN_MID1 = "models";
    private final static @NonNull String IN_MID2 = "criteria";
    private final static @NonNull String OUT_MID1 = "biggerModels";
    private final static @NonNull String OUT_MID2 = "biggerCriteria";
    private final static @NonNull String PROPERTY_IN_MULTIPLIER = "multiplier";
    // constants
    private final static @NonNull String OUT_MID_SUFFIX = "_bigger";

    // input
    private int multiplier;

    @Override
    public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {

        multiplier = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MULTIPLIER);
    }

    private ModelRel copyInstanceAndChangeModelPaths(ModelRel newModelRelType, ModelRel origModelRel,
                                                     String newNamesSuffix, MID modelsMID, MID newModelRelContainerMID)
                                                         throws Exception {

        // create initial empty copy
        String newModelRelName = origModelRel.getName() + newNamesSuffix;
        ModelRel newModelRel = (origModelRel instanceof BinaryModelRel) ?
            newModelRelType.createBinaryInstance(null, newModelRelName, newModelRelContainerMID) :
            (ModelRel) newModelRelType.createInstance(null, newModelRelName, newModelRelContainerMID);

        // models
        Map<String, ModelElementReference> newModelElemRefs = new HashMap<>();
        for (ModelEndpointReference origModelEndpointRef : origModelRel.getModelEndpointRefs()) {
            String origModelUri = origModelEndpointRef.getTargetUri();
            String newModelUri = FileUtils.addFileNameSuffixInPath(origModelUri, newNamesSuffix);
            Model newModel = modelsMID.getExtendibleElement(newModelUri);
            ModelEndpointReference newModelEndpointRef = origModelEndpointRef.getObject().getMetatype()
                .createInstance(newModel, newModelRel);
            // model elements
            URI newModelEMFUri = FileUtils.createEMFUri(newModelUri, true);
            ResourceSet rs = new ResourceSetImpl();
            Resource r = rs.getResource(newModelEMFUri, true);
            for (ModelElementReference origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
                String newModelElemUri = origModelElemRef.getUri()
                    .substring(0, origModelElemRef.getUri().indexOf(MMINT.ROLE_SEPARATOR))
                    .replace(origModelUri, newModelUri);
                EObject newModelObj = FileUtils.readModelObject(newModelElemUri, r);
                ModelElementReference newModelElemRef = newModelEndpointRef.createModelElementInstanceAndReference(
                    newModelObj, origModelElemRef.getObject().getName());
                newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
            }
        }
        // mappings
        for (MappingReference origMappingRef : origModelRel.getMappingRefs()) {
            MappingReference newMappingRef = origMappingRef.getObject().getMetatype().createInstanceAndReference(
                (origMappingRef.getObject() instanceof BinaryMapping), newModelRel);
            newMappingRef.getObject().setName(origMappingRef.getObject().getName());
            for (ModelElementEndpointReference origModelElemEndpointRef : origMappingRef.getModelElemEndpointRefs()) {
                String origModelUri = ((Model) origModelElemEndpointRef.getObject().getTarget().eContainer()).getUri();
                String newModelUri = FileUtils.addFileNameSuffixInPath(origModelUri, newNamesSuffix);
                ModelElementReference newModelElemRef = newModelElemRefs.get(
                    origModelElemEndpointRef.getTargetUri().replace(origModelUri, newModelUri));
                origModelElemEndpointRef.getObject().getMetatype().createInstanceAndReference(newModelElemRef,
                                                                                              newMappingRef);
            }
        }

        return newModelRel;
    }

    private void multiply(MID modelsMID, MID criteriaMIDRel, MID bigModelsMID, MID bigCriteriaMIDRel) {

        for (Model model : modelsMID.getModels()) {
            if (model instanceof ModelRel) {
                continue;
            }
            Model modelType = model.getMetatype();
            String modelName = FileUtils.getFileNameFromPath(model.getUri());
            for (int i = 0; i < multiplier; i++) {
                try {
                    modelType.copyInstance(model, modelName + i, bigModelsMID);
                }
                catch (Exception e) {
                    // continue
                }
            }
        }
        for (ModelRel traceRel : modelsMID.getModelRels()) {
            ModelRel traceRelType = traceRel.getMetatype();
            for (int i = 0; i < multiplier; i++) {
                try {
                    this.copyInstanceAndChangeModelPaths(traceRelType, traceRel, Integer.toString(i), bigModelsMID,
                                                         bigModelsMID);
                }
                catch (Exception e) {
                    // continue
                }
            }
        }
        for (ModelRel critRel : criteriaMIDRel.getModelRels()) {
            ModelRel critRelType = critRel.getMetatype();
            for (int i = 0; i < multiplier; i++) {
                try {
                    this.copyInstanceAndChangeModelPaths(critRelType, critRel, Integer.toString(i), bigModelsMID,
                                                         bigCriteriaMIDRel);
                }
                catch (Exception e) {
                    // continue
                }
            }
        }
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        // input
        Model modelsMIDModel = inputsByName.get(IN_MID1);
        Model criteriaMIDRelModel = inputsByName.get(IN_MID2);
        MID modelsMID = (MID) modelsMIDModel.getEMFInstanceRoot();
        MID criteriaMIDRel = (MID) criteriaMIDRelModel.getEMFInstanceRoot();

        // multiply the input
        MID bigModelsMID = MIDFactory.eINSTANCE.createMID();
        bigModelsMID.setLevel(MIDLevel.INSTANCES);
        MID bigCriteriaMIDRel = MIDFactory.eINSTANCE.createMID();
        bigCriteriaMIDRel.setLevel(MIDLevel.INSTANCES);
        this.multiply(modelsMID, criteriaMIDRel, bigModelsMID, bigCriteriaMIDRel);

        // output
        Model bigModelsMIDModel = modelsMIDModel.getMetatype().createInstanceAndEditor(
            bigModelsMID, FileUtils.addFileNameSuffixInPath(modelsMIDModel.getUri(), OUT_MID_SUFFIX),
            outputMIDsByName.get(OUT_MID1));
        Model bigCriteriaMIDRelModel = criteriaMIDRelModel.getMetatype().createInstanceAndEditor(
            bigCriteriaMIDRel, FileUtils.addFileNameSuffixInPath(criteriaMIDRelModel.getUri(), OUT_MID_SUFFIX),
            outputMIDsByName.get(OUT_MID2));
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MID1, bigModelsMIDModel);
        outputsByName.put(OUT_MID2, bigCriteriaMIDRelModel);

        return outputsByName;
    }

}
