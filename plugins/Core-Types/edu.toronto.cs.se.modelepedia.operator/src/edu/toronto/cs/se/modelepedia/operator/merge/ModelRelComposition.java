/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.merge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelRelComposition extends OperatorImpl {

	@NonNull
	private final static String INPUT_MODELREL1 = "rel1";
	@NonNull
	private final static String INPUT_MODELREL2 = "rel2";
	@NonNull
	private final static String OUTPUT_COMPOSEDMODELREL = "composedRel";

	@NonNull
	private final static String COMPOSEDMODELREL_SEPARATOR = "+";

	private @NonNull ModelRel createComposedModelRel(@NonNull ModelRel modelRel1, @NonNull ModelRel modelRel2, @NonNull Model model1, @NonNull Model model2, @NonNull Model modelPivot, @NonNull MultiModel instanceMID) throws MMINTException {

		//TODO MMINT[USABILITY] Modify apis to simplify the creation of models and model rels (e.g. incorporate createModelFile, add model element creation to link creation)
		EList<Model> targetModels = new BasicEList<>();
		targetModels.add(model1);
		targetModels.add(model2);
		ModelRel composedModelRel = MultiModelTypeHierarchy.getRootModelRelType().createInstanceAndEndpointsAndReferences(null, false, ModelOrigin.CREATED, targetModels);
		composedModelRel.setName(modelRel1.getName() + COMPOSEDMODELREL_SEPARATOR + modelRel2.getName());
		ModelEndpointReference composedModelEndpointRef1 = composedModelRel.getModelEndpointRefs().get(0);
		ModelEndpointReference composedModelEndpointRef2 = composedModelRel.getModelEndpointRefs().get(1);
		/*TODO
		 * model1 <-> modelPivot <-> model2
		 * model1 <-> model2
		 */
		// loop through links in modelRel1
		for (Link link1 : modelRel1.getLinks()) {
			// get model elements in model1
			List<ModelElement> modelElems1 = link1.getModelElemEndpoints().stream()
				.map(ModelElementEndpoint::getTarget)
				.filter(modelElem -> modelElem.eContainer() == model1)
				.collect(Collectors.toList());
			// get model elements in modelPivot from the modelRel1 side
			List<ModelElement> modelElemsPivot1 = link1.getModelElemEndpoints().stream()
				.map(ModelElementEndpoint::getTarget)
				.filter(modelElem -> modelElem.eContainer() == modelPivot)
				.collect(Collectors.toList());
			ModelEndpointReference modelEndpointRefPivot2 = modelRel2.getModelEndpointRefs().stream()
				.filter(modelEndpointRef -> modelEndpointRef.getObject().getTarget() == modelPivot)
				.collect(Collectors.toList())
				.get(0);
			// loop through model elements in modelPivot from the modelRel2 side
			for (ModelElementReference modelElemRefPivot2 : modelEndpointRefPivot2.getModelElemRefs()) {
				if (!modelElemsPivot1.contains(modelElemRefPivot2.getObject())) {
					continue;
				}
				// get model elements in model2
				List<LinkReference> linkRefs2 = modelElemRefPivot2.getModelElemEndpointRefs().stream()
					.map(modelElemEndpointRef -> (LinkReference) modelElemEndpointRef.eContainer())
					.collect(Collectors.toList());
				for (LinkReference linkRef2 : linkRefs2) {
					EList targetModelElemRefs = new BasicEList<>();
					for (ModelElement modelElem1 : modelElems1) {
						targetModelElemRefs.add(modelElem1.createInstanceReference(composedModelEndpointRef1));
					}
					List<ModelElement> modelElems2 = linkRef2.getModelElemEndpointRefs().stream()
						.map(ModelElementEndpointReference::getModelElemRef)
						.filter(modelElemRef-> (ModelEndpointReference) modelElemRef.eContainer() != modelEndpointRefPivot2)
						.map(ModelElementReference::getObject)
						.collect(Collectors.toList());
					for (ModelElement modelElem2 : modelElems2) {
						targetModelElemRefs.add(modelElem2.createInstanceReference(composedModelEndpointRef2));
					}
					LinkReference composedLinkRef = MultiModelTypeHierarchy.getRootLinkType().createInstanceAndReferenceAndEndpointsAndReferences(false, targetModelElemRefs);
					composedLinkRef.getObject().setName(link1.getName() + COMPOSEDMODELREL_SEPARATOR + linkRef2.getObject().getName());
				}
			}
		}

		return composedModelRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MultiModel> outputMIDsByName)
		throws Exception {

		ModelRel modelRel1 = (ModelRel) inputsByName.get(INPUT_MODELREL1);
		ModelRel modelRel2 = (ModelRel) inputsByName.get(INPUT_MODELREL2);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_COMPOSEDMODELREL);

		// check input constraints
		if (modelRel1.getModelEndpoints().size() != 2) {
			throw new MMINTException("The model relationship " + modelRel1 + " doesn't have 2 model endpoints");
		}
		if (modelRel2.getModelEndpoints().size() != 2) {
			throw new MMINTException("The model relationship " + modelRel2 + " doesn't have 2 model endpoints");
		}
		Model
			model11 = modelRel1.getModelEndpoints().get(0).getTarget(),
			model12 = modelRel1.getModelEndpoints().get(1).getTarget(),
			model21 = modelRel2.getModelEndpoints().get(0).getTarget(),
			model22 = modelRel2.getModelEndpoints().get(1).getTarget(),
			modelPivot = null, model1 = null, model2 = null;
		if (model11 == model21) {
			modelPivot = model11;
			model1 = model12;
			model2 = model22;
		}
		else if (model11 == model22) {
			modelPivot = model11;
			model1 = model12;
			model2 = model21;
		}
		else if (model12 == model21) {
			modelPivot = model12;
			model1 = model11;
			model2 = model22;
		}
		else if (model12 == model22) {
			modelPivot = model12;
			model1 = model11;
			model2 = model21;
		}
		if (modelPivot == null) {
			throw new MMINTException("The input model relationships don't share a model endpoint");
		}

		ModelRel composedModelRel = createComposedModelRel(modelRel1, modelRel2, model1, model2, modelPivot, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUTPUT_COMPOSEDMODELREL, composedModelRel);

		return outputsByName;
	}

}
