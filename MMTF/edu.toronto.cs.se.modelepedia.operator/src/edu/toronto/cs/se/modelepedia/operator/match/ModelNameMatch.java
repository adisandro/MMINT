/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class ModelNameMatch extends OperatorExecutableImpl {

	private final static String NAME_FEATURE = "name";
	private final static String MODELREL_NAME = "nameMatch";

	private void checkModelObjNames(EObject container, ModelEndpointReference modelEndpointRef, HashMap<String, ArrayList<EObject>> modelObjNames, HashMap<EObject, ModelEndpointReference> modelObjTable) {

		EStructuralFeature feature = container.eClass().getEStructuralFeature(NAME_FEATURE);
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
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// create model relationship among models
		MultiModel multiModel = MultiModelRegistry.getMultiModel(actualParameters.get(0));
		ModelRel rootModelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		ModelRel matchRel = rootModelRelType.createInstance(null, (actualParameters.size() == 2), ModelOrigin.CREATED, multiModel);
		matchRel.setName(MODELREL_NAME);

		// loop through selected models
		ModelEndpoint rootModelEndpointType = MultiModelTypeHierarchy.getRootModelEndpointType();
		HashMap<String, ArrayList<EObject>> modelObjNames = new HashMap<String, ArrayList<EObject>>();
		HashMap<EObject, ModelEndpointReference> modelObjTable = new HashMap<EObject, ModelEndpointReference>();
		for (Model model : actualParameters) {
			// create model endpoint
			ModelEndpointReference newModelEndpointRef = rootModelEndpointType.createInstanceAndReference(model, false, matchRel);
			// look for identical names in the models
			checkModelObjNames(MultiModelTypeIntrospection.getRoot(model), newModelEndpointRef, modelObjNames, modelObjTable);
		}

		// create model relationship structure
		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
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
					ModelElementReference matchModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
						modelEndpointRef,
						null,
						modelObj
					);
					// create model element endpoints
					MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
						null,
						matchModelElemRef,
						false,
						matchLinkRef
					);
				}
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(matchRel);
		return result;
	}

}
