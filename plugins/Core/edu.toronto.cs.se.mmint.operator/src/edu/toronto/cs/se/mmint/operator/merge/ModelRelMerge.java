/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
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

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			/**TODO MMINT[WORKFLOW]
			 * 4) think about interaction with variable outputs
			 * 6) think about how to enforce constraint inherited by overloaded operators, look for them or simply override the constraint and add it to the ext point
			 */
			ModelRel modelRel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			ModelRel modelRel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			if ( // works with unary and binary rels, as long as they're both unary or both binary
				modelRel1.getModelEndpoints().size() == 0 ||
				modelRel2.getModelEndpoints().size() == 0 ||
				modelRel1.getModelEndpoints().size() > 2 ||
				modelRel2.getModelEndpoints().size() > 2 ||
				modelRel1.getModelEndpoints().size() != modelRel2.getModelEndpoints().size()
			) {
				return false;
			}
			// unary
			String modelPath11 = modelRel1.getModelEndpoints().get(0).getTargetUri();
			String modelPath21 = modelRel2.getModelEndpoints().get(0).getTargetUri();
			if (modelRel1.getModelEndpoints().size() == 1) {
				return (modelPath11.equals(modelPath21)) ? true : false;
			}
			// binary
			String modelPath12 = modelRel1.getModelEndpoints().get(1).getTargetUri();
			String modelPath22 = modelRel2.getModelEndpoints().get(1).getTargetUri();
			if (modelPath11.equals(modelPath21) && modelPath12.equals(modelPath22)) {
				return true;
			}
			else if (modelPath11.equals(modelPath22) && modelPath12.equals(modelPath21)) {
				return true;
			}

			return false;
		}

		@Override
		public Map<ModelRel, List<Model>> getAllowedModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

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

	private static class Input {

		private ModelRel modelRel1;
		private ModelRel modelRel2;
		private Model model1;
		private Model model2;

		public Input(Map<String, Model> inputsByName) {

			this.modelRel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			this.modelRel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			this.model1 = null;
			this.model2 = null;
			Model model11 = this.modelRel1.getModelEndpoints().get(0).getTarget();
			if (this.modelRel1.getModelEndpoints().size() == 1) { // unary
				this.model1 = model11;
			}
			else { // binary
				Model model21 = this.modelRel2.getModelEndpoints().get(0).getTarget();
				Model model12 = this.modelRel1.getModelEndpoints().get(1).getTarget();
				Model model22 = this.modelRel2.getModelEndpoints().get(1).getTarget();
				if (model11.getUri().equals(model21.getUri()) && model12.getUri().equals(model22.getUri())) {
					this.model1 = model11;
					this.model2 = model22;
				}
				else { // model11.getUri().equals(model22.getUri()) && model12.getUri().equals(model21.getUri())
					this.model1 = model11;
					this.model2 = model21;
				}
			}
		}

	}

	private void populate(ModelRel mergedModelRel, ModelRel origModelRel, MID instanceMID) throws MMINTException {

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		for (ModelEndpointReference origModelEndpointRef : origModelRel.getModelEndpointRefs()) {
			List<ModelEndpointReference> newModelEndpointRefs = MIDRegistry.getEndpointReferences(origModelEndpointRef.getTargetUri(), mergedModelRel.getModelEndpointRefs());
			ModelEndpointReference newModelEndpointRef;
			if (newModelEndpointRefs.isEmpty()) {
				Model newModel = instanceMID.getExtendibleElement(origModelEndpointRef.getTargetUri());
				newModelEndpointRef = origModelEndpointRef.getObject().getMetatype().createInstance(newModel, mergedModelRel);
			}
			else {
				//TODO MMINT[REDUCE] this is suspect, what about model rels with endpoints to the same model?
				newModelEndpointRef = newModelEndpointRefs.get(0);
			}
			// model elements
			for (ModelElementReference origModelElemRef : origModelEndpointRef.getModelElemRefs()) {
				ModelElementReference newModelElemRef = MIDRegistry.getReference(origModelElemRef, newModelEndpointRef.getModelElemRefs());
				if (newModelElemRef == null) {
					EObject newModelObj = origModelElemRef.getObject().getEMFInstanceObject();
					newModelElemRef = newModelEndpointRef.createModelElementInstanceAndReference(newModelObj, origModelElemRef.getObject().getName());
					newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
				}
			}
		}
		// links
		for (MappingReference origMappingRef : origModelRel.getMappingRefs()) {
			//TODO MMINT[REDUCE] this is suspect, what about two orig mappings with the same exact endpoints?
			if (mergedModelRel.getMappingRefs().stream()
				.anyMatch(mappingRef -> mappingRef.getModelElemEndpointRefs().stream()
					.map(ModelElementEndpointReference::getTargetUri)
					.collect(Collectors.toSet())
					.containsAll(origMappingRef.getModelElemEndpointRefs().stream()
						.map(ModelElementEndpointReference::getTargetUri)
						.collect(Collectors.toSet())))) {
				continue;
			}
			MappingReference newMappingRef = origMappingRef.getObject().getMetatype().createInstanceAndReference((origMappingRef.getObject() instanceof BinaryMapping), mergedModelRel);
			newMappingRef.getObject().setName(origMappingRef.getObject().getName());
			for (ModelElementEndpointReference origModelElemEndpointRef : origMappingRef.getModelElemEndpointRefs()) {
				ModelElementReference newModelElemRef = newModelElemRefs.get(origModelElemEndpointRef.getTargetUri());
				origModelElemEndpointRef.getObject().getMetatype().createInstanceAndReference(newModelElemRef, newMappingRef);
			}
		}
	}

	private @NonNull ModelRel merge(@NonNull ModelRel modelRel1, @NonNull ModelRel modelRel2,
		@NonNull Model model1, @Nullable Model model2, @NonNull MID instanceMID)
		throws MMINTException {

		ModelRel mergedRel = null;
		if (model2 == null) { // unary
			mergedRel = MIDTypeHierarchy.getRootModelRelType().createInstanceAndEndpoints(
				null,
				modelRel1.getName() + MERGE_SEPARATOR + modelRel2.getName(),
				ECollections.asEList(model1),
				instanceMID);
		}
		else { // binary
			mergedRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
				null,
				modelRel1.getName() + MERGE_SEPARATOR + modelRel2.getName(),
				model1,
				model2,
				instanceMID);
		}
		populate(mergedRel, modelRel1, instanceMID);
		populate(mergedRel, modelRel2, instanceMID);

		return mergedRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
		throws Exception {

		// input
		Input input = new Input(inputsByName);

		// merge the two model rels
		ModelRel mergedRel = this.merge(input.modelRel1, input.modelRel2, input.model1, input.model2, outputMIDsByName.get(OUT_MODELREL));

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, mergedRel);

		return outputsByName;
	}

}
