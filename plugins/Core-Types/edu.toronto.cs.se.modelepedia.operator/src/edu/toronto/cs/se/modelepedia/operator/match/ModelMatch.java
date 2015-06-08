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
package edu.toronto.cs.se.modelepedia.operator.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelMatch extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELS = "models";
	private final static @NonNull String OUT_MODELREL = "match";
	private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE = "matchAttribute";
	private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE_DEFAULT = "name";
	// constants
	private final static @NonNull String MODELREL_NAME = "match";

	private String matchAttribute;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		matchAttribute = MultiModelOperatorUtils.getOptionalStringProperty(inputProperties, PROPERTY_IN_MATCHATTRIBUTE, PROPERTY_IN_MATCHATTRIBUTE_DEFAULT);
	}

	private void checkModelObjNames(EObject container, ModelEndpointReference modelEndpointRef, HashMap<String, ArrayList<EObject>> modelObjNames, HashMap<EObject, ModelEndpointReference> modelObjTable) {

		EStructuralFeature feature = container.eClass().getEStructuralFeature(matchAttribute);
		if (feature != null && feature instanceof EAttribute && container.eGet(feature) instanceof String) {
			String modelObjName = (String) container.eGet(feature);
			ArrayList<EObject> modelObjs = modelObjNames.get(modelObjName);
			if (modelObjs == null) {
				modelObjs = new ArrayList<EObject>();
				modelObjNames.put(modelObjName, modelObjs);
			}
			modelObjs.add(container);
			modelObjTable.put(container, modelEndpointRef);
		}
		for (EObject contained : container.eContents()) {
			checkModelObjNames(contained, modelEndpointRef, modelObjNames, modelObjTable);
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		List<Model> models = MultiModelOperatorUtils.getVarargs(inputsByName, IN_MODELS);

		// create model relationship among models
		ModelRel matchRel = MultiModelTypeHierarchy.getRootModelRelType().createInstance(null, (inputsByName.size() == 2), ModelOrigin.CREATED, outputMIDsByName.get(OUT_MODELREL));
		matchRel.setName(MODELREL_NAME);
		// loop through selected models
		ModelEndpoint rootModelTypeEndpoint = MultiModelTypeHierarchy.getRootModelTypeEndpoint();
		HashMap<String, ArrayList<EObject>> modelObjNames = new HashMap<String, ArrayList<EObject>>();
		HashMap<EObject, ModelEndpointReference> modelObjTable = new HashMap<EObject, ModelEndpointReference>();
		for (Model model : models) {
			// create model endpoint
			ModelEndpointReference newModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(model, matchRel);
			// look for identical names in the models
			checkModelObjNames(model.getEMFInstanceRoot(), newModelEndpointRef, modelObjNames, modelObjTable);
		}

		// create model relationship structure
		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeHierarchy.getRootModelElementTypeEndpoint();
		for (Entry<String, ArrayList<EObject>> entry : modelObjNames.entrySet()) {
			String modelObjName = entry.getKey();
			ArrayList<EObject> modelObjs = entry.getValue();
			if (modelObjs.size() > 1) {
				// create link
				LinkReference matchLinkRef = rootLinkType.createInstanceAndReference((modelObjs.size() == 2), matchRel);
				matchLinkRef.getObject().setName(modelObjName);
				for (EObject modelObj : modelObjs) {
					ModelEndpointReference modelEndpointRef = modelObjTable.get(modelObj);
					// create model element
					ModelElementReference matchModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(modelObj, null, modelEndpointRef);
					// create model element endpoints
					rootModelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchLinkRef);
				}
			}
		}

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, matchRel);

		return outputsByName;
	}

}
