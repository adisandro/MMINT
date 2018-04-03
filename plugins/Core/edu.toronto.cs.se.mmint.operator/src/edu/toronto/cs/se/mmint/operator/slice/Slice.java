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
package edu.toronto.cs.se.mmint.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

// The slice operator performs a slice on a model instance given the input
// slicing criteria, which is a unary model relation containing the model
// elements to slice.
public class Slice extends OperatorImpl {

    // input-output
    protected final static @NonNull String IN_MODELREL = "criterion";
    protected final static @NonNull String OUT_MODELREL = "slice";

    public static class OperatorConstraint implements IJavaOperatorConstraint {

        @Override
        public boolean isAllowedInput(Map<String, Model> inputsByName) {

            ModelRel critRel = (ModelRel) inputsByName.get(IN_MODELREL);
            if (critRel.getModelEndpoints().size() > 1) {
                return false;
            }

            return true;
        }

        @Override
        public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

            Input input = new Input(inputsByName);
            ModelRel sliceRel = (ModelRel) outputsByName.get(OUT_MODELREL);
            Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
            List<Model> endpointModels = new ArrayList<>();
            endpointModels.add(input.model);
            validOutputs.put(sliceRel, endpointModels);

            return validOutputs;
        }

    }

    private static class Input {

        private ModelRel critRel;
        private Model model;

        public Input(Map<String, Model> inputsByName) {

            this.critRel = (ModelRel) inputsByName.get(IN_MODELREL);
            this.model = this.critRel.getModelEndpoints().get(0).getTarget();
        }
    }

    // Returns the set of model elements that may be directly impacted
    // by the input model element.
    // By default, the contained elements are assumed to be impacted.
    protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

        return modelObj.eContents().stream()
            .filter(modelObj2 -> !alreadyImpacted.contains(modelObj2))
            .collect(Collectors.toSet());
    }

    // Returns the complete set of model elements that may be impacted
    // by the input model element.
    protected Set<EObject> getAllImpactedElements(EObject critModelObj, Set<EObject> alreadyImpacted) {

        Set<EObject> impacted = new HashSet<>(), impactedCur = new HashSet<>();
        impacted.add(critModelObj);
        impactedCur.add(critModelObj);
        alreadyImpacted.add(critModelObj);

        // Iterate through the current set of newly added model elements
        // to identify all others that may be potentially impacted.
        while (!impactedCur.isEmpty()) {
            Set<EObject> impactedNext = new HashSet<>();
            for (EObject modelObj : impactedCur) {
                // Get all model elements directly impacted by the current
                // one without adding duplicates.
                Set<EObject> impactedModelObjs = getDirectlyImpactedElements(modelObj, alreadyImpacted);
                impactedNext.addAll(impactedModelObjs);
                alreadyImpacted.addAll(impactedModelObjs);
            }
            // Prepare for next iteration.
            impacted.addAll(impactedNext);
            impactedCur = impactedNext;
        }

        return impacted;
    }

    protected ModelRel slice(ModelRel critRel, Model model, MID outputMID) throws MMINTException {

        ModelRel sliceRel = critRel.getMetatype()
            .createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);
        ModelEndpointReference sliceModelEndpointRef = sliceRel.getModelEndpointRefs().get(0);

        // retrieve resource corresponding to the model instance
        ModelEndpointReference critModelEndpointRef = critRel.getModelEndpointRefs().get(0);
        URI rUri = FileUtils.createEMFUri(critModelEndpointRef.getTargetUri(), true);
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.getResource(rUri, true);

        // loop through the model objects in the input criterion
        Set<EObject> impacted = new HashSet<>();
        for (ModelElementReference critModelElemRef : critModelEndpointRef.getModelElemRefs()) {
            try {
                EObject critModelObj = critModelElemRef.getObject().getEMFInstanceObject(r);
                String critName;
                if (critModelElemRef.getModelElemEndpointRefs().size() == 1) { // criterion with info about previous slice steps
                    critName = ((MappingReference) critModelElemRef.getModelElemEndpointRefs().get(0).eContainer())
                                   .getObject().getName();
                }
                else { // normal criterion
                    EMFInfo critEInfo = MIDRegistry.getModelElementEMFInfo(critModelObj, MIDLevel.INSTANCES);
                    critName = MIDRegistry.getModelElementName(critEInfo, critModelObj, MIDLevel.INSTANCES);
                }
                // add impacted elements to the output model relation
                Set<EObject> impModelObjs = getAllImpactedElements(critModelObj, impacted);
                for (EObject impModelObj : impModelObjs) {
                    try {
                        ModelElementReference impModelElemRef = sliceModelEndpointRef
                            .createModelElementInstanceAndReference(impModelObj, null);
                        MappingReference impMappingRef = MIDTypeHierarchy.getRootMappingType()
                            .createInstanceAndReferenceAndEndpointsAndReferences(
                                false, ECollections.asEList(impModelElemRef));
                        impMappingRef.getObject().setName(critName);
                    }
                    catch (MMINTException e) {
                        MMINTException.print(IStatus.WARNING, "Skipping slice model element " + impModelObj, e);
                    }
                }
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING,
                                     "Skipping criterion model element " + critModelElemRef.getObject().getName(), e);
            }
        }

        return sliceRel;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {

        // input
        Input input = new Input(inputsByName);
        MID outputMID = outputMIDsByName.get(OUT_MODELREL);

        // create the slice from the initial criterion and the rules
        ModelRel sliceRel = slice(input.critRel, input.model, outputMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_MODELREL, sliceRel);

        return outputsByName;
    }

}