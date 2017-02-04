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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorInputConstraint;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorOutputConstraint;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelRelComposition extends OperatorImpl {

	public static class InputConstraint implements IJavaOperatorInputConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel rel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			ModelRel rel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			if (rel1.getModelEndpoints().size() != 2 || rel2.getModelEndpoints().size() != 2) {
				return false;
			}
			String modelPath11 = rel1.getModelEndpoints().get(0).getTargetUri();
			String modelPath12 = rel1.getModelEndpoints().get(1).getTargetUri();
			String modelPath21 = rel2.getModelEndpoints().get(0).getTargetUri();
			String modelPath22 = rel2.getModelEndpoints().get(1).getTargetUri();
			if (!modelPath11.equals(modelPath21) && !modelPath11.equals(modelPath22) && !modelPath12.equals(modelPath21) && !modelPath12.equals(modelPath22)) {
				return false;
			}

			return true;
		}
	}

	public static class OutputConstraint implements IJavaOperatorOutputConstraint {

		@Override
		public Map<ModelRel, List<Model>> getAllowedModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			ModelRel rel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			ModelRel rel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			Model model11 = rel1.getModelEndpoints().get(0).getTarget();
			Model model12 = rel1.getModelEndpoints().get(1).getTarget();
			Model model21 = rel2.getModelEndpoints().get(0).getTarget();
			Model model22 = rel2.getModelEndpoints().get(1).getTarget();
			Model model1 = null, model2 = null;
			if (model11 == model21) {
				model1 = model12;
				model2 = model22;
			}
			else if (model11 == model22) {
				model1 = model12;
				model2 = model21;
			}
			else if (model12 == model21) {
				model1 = model11;
				model2 = model22;
			}
			else { // model12 == model22
				model1 = model11;
				model2 = model21;
			}
			ModelRel composedRel = (ModelRel) outputsByName.get(OUT_MODELREL);
			Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
			List<Model> endpointModels = new ArrayList<>();
			endpointModels.add(model1);
			endpointModels.add(model2);
			validOutputs.put(composedRel, endpointModels);

			return validOutputs;
		}
	}

	// input-output
	private final static @NonNull String IN_MODELREL1 = "rel1";
	private final static @NonNull String IN_MODELREL2 = "rel2";
	private final static @NonNull String OUT_MODELREL = "composition";
	// constants
	private final static @NonNull String COMPOSITION_SEPARATOR = "+";

	private @NonNull ModelRel compose(@NonNull ModelRel modelRel1, @NonNull ModelRel modelRel2,
		@NonNull Model model1, @NonNull Model model2, @NonNull Model modelPivot, @NonNull MID instanceMID)
		throws MMINTException {

		// TODO MMINT[USABILITY] Modify apis to simplify the creation of models and model rels (e.g. incorporate
		// createModelFile, add model element creation to link creation)
		ModelRel composedRel = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			modelRel1.getName() + COMPOSITION_SEPARATOR + modelRel2.getName(),
			model1,
			model2,
			instanceMID);
		ModelEndpointReference composedModelEndpointRef1 = composedRel.getModelEndpointRefs().get(0);
		ModelEndpointReference composedModelEndpointRef2 = composedRel.getModelEndpointRefs().get(1);
		// loop through mappings in modelRel1
		for (Mapping mapping1 : modelRel1.getMappings()) {
			// get model elements in model1
			List<ModelElement> modelElems1 = mapping1.getModelElemEndpoints().stream()
				.map(ModelElementEndpoint::getTarget)
				.filter(modelElem -> modelElem.eContainer() == model1)
				.collect(Collectors.toList());
			// get model elements in modelPivot from the modelRel1 side
			List<ModelElement> modelElemsPivot1 = mapping1.getModelElemEndpoints().stream()
				.map(ModelElementEndpoint::getTarget)
				.filter(modelElem -> modelElem.eContainer() == modelPivot)
				.collect(Collectors.toList());
			ModelEndpointReference modelEndpointRefPivot2 = modelRel2.getModelEndpointRefs().stream()
				.filter(modelEndpointRef -> modelEndpointRef.getObject().getTarget() == modelPivot)
				.collect(Collectors.toList()).get(0);
			// loop through model elements in modelPivot from the modelRel2 side
			for (ModelElementReference modelElemRefPivot2 : modelEndpointRefPivot2.getModelElemRefs()) {
				if (!modelElemsPivot1.contains(modelElemRefPivot2.getObject())) {
					continue;
				}
				// get model elements in model2
				List<MappingReference> mappingRefs2 = modelElemRefPivot2.getModelElemEndpointRefs().stream()
					.map(modelElemEndpointRef -> (MappingReference) modelElemEndpointRef.eContainer())
					.collect(Collectors.toList());
				for (MappingReference mappingRef2 : mappingRefs2) {
					EList<ModelElementReference> targetModelElemRefs = new BasicEList<>();
					for (ModelElement modelElem1 : modelElems1) {
						targetModelElemRefs.add(modelElem1.createInstanceReference(composedModelEndpointRef1));
					}
					List<ModelElement> modelElems2 = mappingRef2.getModelElemEndpointRefs().stream()
						.map(ModelElementEndpointReference::getModelElemRef)
						.filter(
							modelElemRef ->
							(ModelEndpointReference) modelElemRef.eContainer() != modelEndpointRefPivot2)
						.map(ModelElementReference::getObject).collect(Collectors.toList());
					for (ModelElement modelElem2 : modelElems2) {
						targetModelElemRefs.add(modelElem2.createInstanceReference(composedModelEndpointRef2));
					}
					// create the composed mapping
					MappingReference composedMappingRef = MIDTypeHierarchy.getRootMappingType()
						.createInstanceAndReferenceAndEndpointsAndReferences(false, targetModelElemRefs);
					composedMappingRef.getObject().setName(
						mapping1.getName() + COMPOSITION_SEPARATOR + mappingRef2.getObject().getName());
				}
			}
		}

		return composedRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
		throws Exception {

		// input
		ModelRel rel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
		ModelRel rel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
		Model model11 = rel1.getModelEndpoints().get(0).getTarget();
		Model model12 = rel1.getModelEndpoints().get(1).getTarget();
		Model model21 = rel2.getModelEndpoints().get(0).getTarget();
		Model model22 = rel2.getModelEndpoints().get(1).getTarget();
		Model modelPivot = null, model1 = null, model2 = null;
		if (model11.getUri().equals(model21.getUri())) {
			modelPivot = model11;
			model1 = model12;
			model2 = model22;
		}
		else if (model11.getUri().equals(model22.getUri())) {
			modelPivot = model11;
			model1 = model12;
			model2 = model21;
		}
		else if (model12.getUri().equals(model21.getUri())) {
			modelPivot = model12;
			model1 = model11;
			model2 = model22;
		}
		else { // model12.getUri().equals(model22.getUri())
			modelPivot = model12;
			model1 = model11;
			model2 = model21;
		}

		// compose the two model rels, using the shared model as pivot
		ModelRel composedRel = compose(
			rel1,
			rel2,
			model1,
			model2,
			modelPivot,
			outputMIDsByName.get(OUT_MODELREL));

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, composedRel);

		return outputsByName;
	}

}
