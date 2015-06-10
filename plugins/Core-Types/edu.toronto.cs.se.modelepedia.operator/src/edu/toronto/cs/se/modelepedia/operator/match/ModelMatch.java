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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
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
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelMatch extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL1 = "model1";
	private final static @NonNull String IN_MODEL2 = "model2";
	private final static @NonNull String OUT_MODELREL = "match";
	private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE = "matchAttribute";
	private final static @NonNull String PROPERTY_IN_MATCHATTRIBUTE_DEFAULT = "name";
	// constants
	private final static @NonNull String MODELREL_NAME = "match";

	private String matchAttribute;

	@Override
	public boolean isCommutative() {

		return true;
	}

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		matchAttribute = MultiModelOperatorUtils.getOptionalStringProperty(inputProperties, PROPERTY_IN_MATCHATTRIBUTE, PROPERTY_IN_MATCHATTRIBUTE_DEFAULT);
	}

	@Override
	public boolean isAllowedInput(Map<String, Model> inputsByName) throws MMINTException {

		boolean allowed = super.isAllowedInput(inputsByName);
		if (!allowed) {
			return false;
		}
		Model srcModel = inputsByName.get(IN_MODEL1);
		Model tgtModel = inputsByName.get(IN_MODEL2);
		if (srcModel == tgtModel) {
			return false;
		}

		return true;
	}

	private void matchModelObjAttributes(EObject modelObj, ModelEndpointReference modelEndpointRef, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) {

		Object modelObjAttr;
		try {
			modelObjAttr = MultiModelUtils.getModelObjFeature(modelObj, matchAttribute);
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
			matchModelObjAttributes(contained, modelEndpointRef, modelObjAttrs, modelObjTable);
		}
	}

	protected void createMatchLinks(ModelRel matchRel, Map<String, Set<EObject>> modelObjAttrs, Map<EObject, ModelEndpointReference> modelObjTable) throws MMINTException {

		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeHierarchy.getRootModelElementTypeEndpoint();
		for (Entry<String, Set<EObject>> entry : modelObjAttrs.entrySet()) {
			Set<EObject> modelObjs = entry.getValue();
			if (modelObjs.size() < 2) {
				continue;
			}
			String modelObjAttr = entry.getKey();
			// create link
			LinkReference matchLinkRef = rootLinkType.createInstanceAndReference((modelObjs.size() == 2), matchRel);
			matchLinkRef.getObject().setName(modelObjAttr);
			for (EObject modelObj : modelObjs) {
				ModelEndpointReference modelEndpointRef = modelObjTable.get(modelObj);
				// create model element
				ModelElementReference matchModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(modelObj, null, modelEndpointRef);
				// create model element endpoints
				rootModelElemTypeEndpoint.createInstanceAndReference(matchModelElemRef, matchLinkRef);
			}
		}
	}

	private ModelRel match(List<Model> models, MultiModel instanceMID) throws MMINTException {

		// create model relationship among models
		ModelRel matchRel = MultiModelTypeHierarchy.getRootModelRelType().createInstance(null, (models.size() == 2), ModelOrigin.CREATED, instanceMID);
		matchRel.setName(MODELREL_NAME);
		// loop through selected models
		ModelEndpoint rootModelTypeEndpoint = MultiModelTypeHierarchy.getRootModelTypeEndpoint();
		Map<String, Set<EObject>> modelObjAttrs = new HashMap<>();
		Map<EObject, ModelEndpointReference> modelObjTable = new HashMap<EObject, ModelEndpointReference>();
		for (Model model : models) {
			// create model endpoint
			ModelEndpointReference newModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(model, matchRel);
			// look for identical names in the models
			matchModelObjAttributes(model.getEMFInstanceRoot(), newModelEndpointRef, modelObjAttrs, modelObjTable);
		}
		// create model relationship links
		createMatchLinks(matchRel, modelObjAttrs, modelObjTable);

		return matchRel;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		//TODO MMINT[MAP] Reenable when map handles varargs
		//List<Model> models = MultiModelOperatorUtils.getVarargs(inputsByName, IN_MODEL1);
		List<Model> models = new ArrayList<>();
		models.add(inputsByName.get(IN_MODEL1));
		models.add(inputsByName.get(IN_MODEL2));

		// create match
		ModelRel matchRel = match(models, outputMIDsByName.get(OUT_MODELREL));

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, matchRel);

		return outputsByName;
	}

}
