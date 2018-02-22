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
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

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

    protected Predicate<EObject> notIn(Set<EObject> alreadyImpacted) {

        return modelObj -> !alreadyImpacted.contains(modelObj);
    }

    // Returns the set of model elements that may be directly impacted
    // by the input model element.
    // By default, the contained elements are assumed to be impacted.
    protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

        return modelObj.eContents().stream()
            .filter(notIn(alreadyImpacted))
            .collect(Collectors.toSet());
    }

    // Returns the complete set of model elements that may be impacted
    // by the input set of model elements.
    protected Set<EObject> getAllImpactedElements(Set<EObject> criterion) {

        Set<EObject> impacted = new HashSet<>(criterion);
        Set<EObject> impactedCur = new HashSet<>(criterion);

        // Iterate through the current set of newly added model elements
        // to identify all others that may be potentially impacted.
        while (!impactedCur.isEmpty()) {
            Set<EObject> impactedNext = new HashSet<>();
            for (EObject modelObj : impactedCur) {
                // Get all model elements directly impacted by the current
                // one without adding duplicates.
                impactedNext.addAll(getDirectlyImpactedElements(modelObj, impacted));
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

        // Retrieve resource corresponding to the model instance.
        ModelEndpointReference critModelEndpointRef = critRel.getModelEndpointRefs().get(0);
        URI rUri = FileUtils.createEMFUri(critModelEndpointRef.getTargetUri(), true);
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.getResource(rUri, true);

        // Extract the model elements in the input criterion.
        Set<EObject> criterion = new HashSet<>();
        for (ModelElementReference mer : critModelEndpointRef.getModelElemRefs()) {
            try {
                criterion.add(mer.getObject().getEMFInstanceObject(r));
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING,
                                     "Skipping criterion model element " + mer.getObject().getName(), e);
            }
        }

        // Add impacted elements to the output model relation.
        Set<EObject> impacted = getAllImpactedElements(criterion);
        ModelEndpointReference sliceModelEndpointRef = sliceRel.getModelEndpointRefs().get(0);
        for (EObject modelObj : impacted) {
            try {
                sliceModelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING, "Skipping slice model element " + modelObj, e);
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