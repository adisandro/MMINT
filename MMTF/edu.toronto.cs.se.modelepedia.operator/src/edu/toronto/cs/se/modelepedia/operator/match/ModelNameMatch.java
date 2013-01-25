/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmtf.mavo.trait.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class ModelNameMatch extends OperatorExecutableImpl {

	private final static String NAME_FEATURE = "name";
	private final static String MODEL_REL_NAME = "nameMatch";

	private void checkEObjectNames(EObject container, ModelEndpointReference modelEndpointRef, HashMap<String, ArrayList<EObject>> objectNames, HashMap<EObject, ModelEndpointReference> objectModels) {

		EStructuralFeature feature = container.eClass().getEStructuralFeature(NAME_FEATURE);
		if (feature != null && feature instanceof EAttribute && container.eGet(feature) instanceof String) {
			String objectName = (String) container.eGet(feature);
			ArrayList<EObject> objects = objectNames.get(objectName);
			if (objects == null) {
				objects = new ArrayList<EObject>();
				objectNames.put(objectName, objects);
			}
			objects.add(container);
			objectModels.put(container, modelEndpointRef);
		}
		for (EObject contained : container.eContents()) {
			checkEObjectNames(contained, modelEndpointRef, objectNames, objectModels);
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// create model relationship among models
		MultiModel multiModel = (MultiModel) actualParameters.get(0).eContainer();
		EClass modelRelClass = (actualParameters.size() == 2) ?
			RelationshipPackage.eINSTANCE.getBinaryModelRel() :
			RelationshipPackage.eINSTANCE.getModelRel();
		ModelRel newModelRel = MultiModelInstanceFactory.createModelRel(
			null,
			null,
			ModelOrigin.CREATED,
			modelRelClass,
			multiModel
		);
		newModelRel.setName(MODEL_REL_NAME);

		// loop through selected models
		HashMap<String, ArrayList<EObject>> eObjectNames = new HashMap<String, ArrayList<EObject>>();
		HashMap<EObject, ModelEndpointReference> eObjectModels = new HashMap<EObject, ModelEndpointReference>();
		for (Model model : actualParameters) {
			// add model endpoints to relationship
			ModelEndpointReference newModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
				null,
				newModelRel,
				model,
				false
			);
			newModelEndpointRef.getObject().setName(model.getName());
			// look for identical names in the models
			checkEObjectNames(MultiModelTypeIntrospection.getRoot(model), newModelEndpointRef, eObjectNames, eObjectModels);
		}

		// create model relationship structure
		for (Entry<String, ArrayList<EObject>> entry : eObjectNames.entrySet()) {
			String name = entry.getKey();
			ArrayList<EObject> eObjects = entry.getValue();
			if (eObjects.size() > 1) {
				EClass linkClass = (eObjects.size() == 2) ?
					RelationshipPackage.eINSTANCE.getBinaryLink() :
					RelationshipPackage.eINSTANCE.getLink();
				EClass linkRefClass = (eObjects.size() == 2) ?
					RelationshipPackage.eINSTANCE.getBinaryLinkReference() :
					RelationshipPackage.eINSTANCE.getLinkReference();
				// create link among model elements
				LinkReference newLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
					null,
					newModelRel,
					linkClass,
					linkRefClass
				);
				newLinkRef.getObject().setName(name);
				for (EObject eObject : eObjects) {
					ModelEndpointReference modelEndpointRef = eObjectModels.get(eObject);
					// create model element
					ModelElementReference newModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
						modelEndpointRef,
						null,
						eObject
					);
					// add model element endpoints to link
					ModelElementEndpointReference newModelElemEndpointRef = MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
						null,
						newLinkRef,
						newModelElemRef,
						false
					);
					newModelElemEndpointRef.getObject().setName(newModelElemRef.getObject().getName());
				}
			}
		}
		//TODO MMTF: this specialization is too rough
		List<ExtendibleElement> runtimeMetatypes = MultiModelTypeIntrospection.getRuntimeTypesOld(newModelRel);
		newModelRel.setMetatypeUri(((ModelRel) runtimeMetatypes.get(runtimeMetatypes.size()-1)).getUri());

		EList<Model> result = new BasicEList<Model>();
		result.add(newModelRel);
		return result;
	}

}
