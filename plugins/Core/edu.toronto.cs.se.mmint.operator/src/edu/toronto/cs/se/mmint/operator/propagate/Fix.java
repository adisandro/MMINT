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
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Fix extends NestingOperatorImpl {

    // input-output
    private final static @NonNull String IN_MODELS = "models";
    private final static @NonNull String OUT_MODELS = "fixedModels";
    private final static @NonNull String GENERIC_OPERATORTYPE = "FIXER";
    // constants
    private final static @NonNull String FIXED_MODEL_SUFFIX = "_fixed";

    public static class Constraint implements IJavaOperatorConstraint {

        @Override
        public boolean isAllowedGeneric(@NonNull GenericEndpoint genericTypeEndpoint,
                                        @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

            final String FIX_URI = "http://se.cs.toronto.edu/modelepedia/Operator_Fix";
            Operator fixerOperatorType = (Operator) genericType;
            // no nesting
            if (fixerOperatorType.getUri().equals(FIX_URI)) {
                return false;
            }
            // would not stop from infinite cycle
            if (inputs.size() == 0) {
                return false;
            }
            // no varargs for the fixer
            if (Stream.concat(fixerOperatorType.getInputs().stream(), fixerOperatorType.getOutputs().stream())
                      .anyMatch(modelTypeEndpoint -> modelTypeEndpoint.getUpperBound() > 1)) {
                return false;
            }
            // must connect outputs to inputs
            if (fixerOperatorType.getInputs().size() != fixerOperatorType.getOutputs().size()) {
                return false;
            }
            // inputs must be valid for the fixer
            String runtimeTypingPreference = null;
            if (inputs.get(0).getModel().isWorkflowsLevel()) {
                runtimeTypingPreference = MMINT
                    .getPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED);
                MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED, "false");
            }
            EList<Model> inputModels = ECollections.asEList(
                inputs.stream()
                      .map(OperatorInput::getModel)
                      .collect(Collectors.toList()));
            try {
                if (fixerOperatorType.checkAllowedInputs(inputModels) == null) {
                    return false;
                }

                return true;
            }
            catch (MMINTException e) {
                return false;
            }
            finally {
                if (runtimeTypingPreference != null) {
                    MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED,
                                        runtimeTypingPreference);
                }
            }
        }
    }

    @Override
    public void createWorkflowInstanceOutputs(Operator newOperator, Map<String, Model> inputsByName, MID workflowMID)
                throws MMINTException {

        // create the vararg fixed models
        Map<String, Model> outputsByName = new HashMap<>();
        Operator fixerOperatorType = (Operator) newOperator.getGenerics().get(0).getTarget();
        for (int i = 0; i < fixerOperatorType.getOutputs().size(); i++) {
            ModelEndpoint outputModelTypeEndpoint = fixerOperatorType.getOutputs().get(i);
            String outputModelId = MIDRegistry.getNextWorkflowID(workflowMID);
            Model outputModel = outputModelTypeEndpoint.getTarget().createWorkflowInstance(outputModelId, workflowMID);
            ModelEndpoint outputModelEndpoint = this.getOutputs().get(0).createWorkflowInstance(
                outputModel,
                newOperator,
                OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
            outputModelEndpoint.setName(outputModelEndpoint.getName() + i);
            outputsByName.put(outputModelTypeEndpoint.getName(), outputModel);
        }
        // use the fixer operator constraints in case of output model rels
        List<Model> inputModels = MIDOperatorIOUtils.getVarargs(inputsByName, this.getInputs().get(0).getName());
        inputsByName.clear();
        for (int i = 0; i < fixerOperatorType.getInputs().size(); i++) {
            inputsByName.put(fixerOperatorType.getInputs().get(i).getName(), inputModels.get(i));
        }
        Map<ModelRel, List<Model>> validOutputs = MIDConstraintChecker
            .getOperatorOutputConstraints(fixerOperatorType.getClosestTypeConstraint(), inputsByName, outputsByName);
        for (Entry<ModelRel, List<Model>> validOutput : validOutputs.entrySet()) {
            ModelRel outputModelRel = validOutput.getKey();
            for (Model endpointModel : validOutput.getValue()) {
                String modelTypeEndpointUri = MIDConstraintChecker.getAllowedModelEndpoints(outputModelRel, null,
                                                                                            endpointModel).get(0);
                ModelEndpoint modelTypeEndpoint = MIDTypeRegistry.getType(modelTypeEndpointUri);
                modelTypeEndpoint.createWorkflowInstance(endpointModel, outputModelRel);
            }
        }
    }

    private boolean isFixed(Model model1, Model model2) {

        ResourceSet srcResourceSet = new ResourceSetImpl();
        FileUtils.getResource(URI.createPlatformResourceURI(model1.getUri(), true), srcResourceSet);
        ResourceSet tgtResourceSet = new ResourceSetImpl();
        FileUtils.getResource(URI.createPlatformResourceURI(model2.getUri(), true), tgtResourceSet);
        IComparisonScope scope = new DefaultComparisonScope(srcResourceSet, tgtResourceSet, null);
        Comparison comparison = EMFCompare.builder().build().compare(scope);
        if (!comparison.getDifferences().isEmpty()) {
            return false;
        }

        return true;
    }

    private Map<String, Integer> getEndpointRefsMap(List<? extends ExtendibleElementEndpointReference> endpointRefs) {

        Map<String, Integer> endpointRefsMap = new HashMap<>();
        for (ExtendibleElementEndpointReference endpointRef : endpointRefs) {
            String endpointTargetUri = endpointRef.getTargetUri();
            Integer numEndpoints = endpointRefsMap.putIfAbsent(endpointTargetUri, new Integer(1));
            if (numEndpoints != null) {
                endpointRefsMap.put(endpointTargetUri, new Integer(numEndpoints + 1));
            }
        }

        return endpointRefsMap;
    }

    private Set<String> getModelElemUris(List<ModelElementReference> modelElemRefs) {

        return modelElemRefs.stream()
            .map(ModelElementReference::getUri)
            .collect(Collectors.toSet());
    }

    private Map<Map<String, Integer>, Integer> getMappingRefsMap(List<MappingReference> mappingRefs) {

        Map<Map<String, Integer>, Integer> mappingRefsMap = new HashMap<>();
        for (MappingReference mappingRef : mappingRefs) {
            Map<String, Integer> endpointRefsMap = this.getEndpointRefsMap(mappingRef.getModelElemEndpointRefs());
            Integer numMappings = mappingRefsMap.putIfAbsent(endpointRefsMap, new Integer(1));
            if (numMappings != null) {
                mappingRefsMap.put(endpointRefsMap, new Integer(numMappings + 1));
            }
        }

        return mappingRefsMap;
    }

    private boolean isFixed(ModelRel modelRel1, ModelRel modelRel2) {

        // check model endpoints
        if (modelRel1.getModelEndpointRefs().size() != modelRel2.getModelEndpointRefs().size() ||
            modelRel1.getMappingRefs().size() != modelRel2.getMappingRefs().size()) {
            return false;
        }
        Map<String, Integer> modelEndpointRefsMap1 = this.getEndpointRefsMap(modelRel1.getModelEndpointRefs());
        Map<String, Integer> modelEndpointRefsMap2 = this.getEndpointRefsMap(modelRel2.getModelEndpointRefs());
        if (!modelEndpointRefsMap1.equals(modelEndpointRefsMap2)) {
            return false;
        }
        // check model elements
        for (ModelEndpointReference modelEndpointRef1 : modelRel1.getModelEndpointRefs()) {
            Set<String> modelElemUris1 = this.getModelElemUris(modelEndpointRef1.getModelElemRefs());
            List<ModelEndpointReference> modelEndpointRefs2 = MIDRegistry.getEndpointReferences(
                modelEndpointRef1.getTargetUri(), modelRel2.getModelEndpointRefs());
            boolean modelElemEquals = false;
            for (ModelEndpointReference modelEndpointRef2 : modelEndpointRefs2) {
                Set<String> modelElemUris2 = this.getModelElemUris(modelEndpointRef2.getModelElemRefs());
                if (modelElemUris1.equals(modelElemUris2)) {
                    // at least one must be equal here, == all must be equal when considering the outer loop
                    modelElemEquals = true;
                    break;
                }
            }
            if (!modelElemEquals) {
                return false;
            }
        }
        // check mappings
        Map<Map<String, Integer>, Integer> mappingRefsMap1 = this.getMappingRefsMap(modelRel1.getMappingRefs());
        Map<Map<String, Integer>, Integer> mappingRefsMap2 = this.getMappingRefsMap(modelRel2.getMappingRefs());
        if (!mappingRefsMap1.equals(mappingRefsMap2)) {
            return false;
        }

        return true;
    }

    private boolean areFixed(@NonNull List<Model> inModels, @NonNull List<Model> outModels) throws MMINTException {

        Model midModelType = MIDTypeRegistry.getMIDModelType();
        for (int i = 0; i < inModels.size(); i++) {
            Model inModel = inModels.get(i), outModel = outModels.get(i);
            if (MIDTypeHierarchy.instanceOf(inModel, midModelType.getUri(), false)) { // the model is a MID, recursion
                MID inMID = (MID) inModel.getEMFInstanceRoot(), outMID = (MID) outModel.getEMFInstanceRoot();
                if (inMID.getModels().size() != outMID.getModels().size()) {
                    return false;
                }
                //TODO MMINT[FIXEDPOINT] MID comparison is not smart, assumes models are in the same order
                if (!this.areFixed(inMID.getModels(), outMID.getModels())) {
                    return false;
                }
            }
            else {
                if (inModel instanceof ModelRel) { // model relationships
                    if (!this.isFixed((ModelRel) inModel, (ModelRel) outModel)) {
                        return false;
                    }
                }
                else { // models
                    if (!this.isFixed(inModel, outModel)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private @NonNull List<Model> fix(@NonNull List<Model> models, @NonNull Operator fixerOperatorType,
                                     @NonNull Map<String, MID> outputMIDsByFixerOutputs) throws Exception {

        // prepare nested MID
        MID fixingMID = super.getNestedInstanceMID();
        if (fixingMID != null) {
            createNestedInstanceMIDModelShortcuts(new HashSet<>(models));
        }

        // fixer loop
        EList<Model> inModels;
        EList<Model> outModels = ECollections.asEList(models);
        Operator fixerOperator;
        int i = 0;
        do {
            inModels = outModels;
            EList<OperatorInput> fixerInputs = fixerOperatorType.checkAllowedInputs(inModels);
            EList<OperatorGeneric> fixerGenerics = fixerOperatorType.selectAllowedGenerics(fixerInputs);
            Map<String, MID> fixerOutputsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(fixerOperatorType,
                                                                                                fixingMID);
            fixerOperator = fixerOperatorType.startInstance(fixerInputs, null, fixerGenerics, fixerOutputsByName,
                                                            fixingMID);
            fixerOperator.setName(fixerOperator.getName() + i);
            outModels = fixerOperator.getOutputModels();
            i++;
        }
        while (!this.areFixed(inModels, outModels));

        // copy final outputs into their proper instance MIDs and make them shortcuts in the nested MID
        Map<Model, Model> fixedToOutModels = super.replaceNestedModelsWithShortcuts(fixerOperator,
                                                                                    outputMIDsByFixerOutputs);
        for (Entry<Model, Model> fixedToOut : fixedToOutModels.entrySet()) {
            int j = outModels.indexOf(fixedToOut.getKey());
            if (j != -1) {
                outModels.set(j, fixedToOut.getValue());
            }
        }

        // finalize nested MID
        if (fixingMID != null) {
            super.writeNestedInstanceMID();
        }

        return outModels;
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {

        // input
        List<Model> models = MIDOperatorIOUtils.getVarargs(inputsByName, Fix.IN_MODELS);
        Operator fixerOperatorType = (Operator) genericsByName.get(Fix.GENERIC_OPERATORTYPE);
        Map<String, MID> outputMIDsByFixerOutputs = MIDOperatorIOUtils.getVarargOutputMIDsByOtherName(
            outputMIDsByName,
            Fix.OUT_MODELS,
            fixerOperatorType.getOutputs());
        //TODO MMINT[FIXEDPOINT] Running a workflow as fixer breaks when traceability is disabled, because it can't detect the outputs

        // loop until outputs are equal to inputs
        List<Model> fixedModels = this.fix(models, fixerOperatorType, outputMIDsByFixerOutputs);

        // output
        Map<String, Model> outputsByName = MIDOperatorIOUtils.setVarargs(fixedModels, Fix.OUT_MODELS);

        return outputsByName;
    }

}
