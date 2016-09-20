/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorInputConstraint;
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

	public static class InputConstraint implements IJavaOperatorInputConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel modelRel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			ModelRel modelRel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			if (modelRel1.getModelEndpoints().size() != 2 || modelRel2.getModelEndpoints().size() != 2) {
				return false;
			}
			Model model11 = modelRel1.getModelEndpoints().get(0).getTarget();
			Model model12 = modelRel1.getModelEndpoints().get(1).getTarget();
			Model model21 = modelRel2.getModelEndpoints().get(0).getTarget();
			Model model22 = modelRel2.getModelEndpoints().get(1).getTarget();
			if (model11 == model21 && model12 == model22) {
				return true;
			}
			else if (model11 == model22 && model12 == model21) {
				return true;
			}

			return false;
		}
	}

	// input-output
	private final static @NonNull String IN_MODELREL1 = "rel1";
	private final static @NonNull String IN_MODELREL2 = "rel2";
	private final static @NonNull String OUT_MODELREL = "merge";
	// constants
	private final static @NonNull String MERGE_SEPARATOR = "+";

	private void populate(ModelRel mergedModelRel, ModelRel origModelRel, MID instanceMID) throws MMINTException {

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		for (ModelEndpointReference origModelEndpointRef : origModelRel.getModelEndpointRefs()) {
			List<ModelEndpointReference> newModelEndpointRefs = MIDRegistry.getEndpointReferences(origModelEndpointRef.getTargetUri(), mergedModelRel.getModelEndpointRefs());
			ModelEndpointReference newModelEndpointRef;
			if (newModelEndpointRefs.isEmpty()) {
				Model newModel = MIDRegistry.getExtendibleElement(origModelEndpointRef.getTargetUri(), instanceMID);
				newModelEndpointRef = origModelEndpointRef.getObject().getMetatype().createInstance(newModel, mergedModelRel);
			}
			else {
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
		@NonNull Model model1, @NonNull Model model2, @NonNull MID instanceMID)
		throws MMINTException {

		ModelRel mergedRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			model1,
			model2,
			instanceMID);
		mergedRel.setName(modelRel1.getName() + MERGE_SEPARATOR + modelRel2.getName());
		populate(mergedRel, modelRel1, instanceMID);
		populate(mergedRel, modelRel2, instanceMID);

		return mergedRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
		throws Exception {

		// input
		ModelRel modelRel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
		ModelRel modelRel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
		Model model11 = modelRel1.getModelEndpoints().get(0).getTarget();
		Model model12 = modelRel1.getModelEndpoints().get(1).getTarget();
		Model model21 = modelRel2.getModelEndpoints().get(0).getTarget();
		Model model22 = modelRel2.getModelEndpoints().get(1).getTarget();
		Model model1 = null, model2 = null;
		if (model11 == model21 && model12 == model22) {
			model1 = model11;
			model2 = model22;
		}
		else { // model11 == model22 && model12 == model21
			model1 = model11;
			model2 = model21;
		}

		// merge the two model rels
		ModelRel mergedRel = merge(modelRel1, modelRel2, model1, model2, outputMIDsByName.get(OUT_MODELREL));

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, mergedRel);

		return outputsByName;
	}

}
