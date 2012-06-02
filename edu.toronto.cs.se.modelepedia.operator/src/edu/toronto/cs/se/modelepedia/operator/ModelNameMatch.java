/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;

public class ModelNameMatch extends OperatorExecutableImpl {

	private final static String NAME_FEATURE = "name";
	private final static String MODEL_REL_NAME = "nameMatch";

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// create model relationship among models
		MultiModel multiModel = (MultiModel) actualParameters.get(0).eContainer();
		EClass modelRelClass = (actualParameters.size() == 2) ?
			RelationshipPackage.eINSTANCE.getBinaryModelRel() :
			RelationshipPackage.eINSTANCE.getModelRel();
		ModelRel modelRel = MultiModelFactoryUtils.createModelRel(ModelOrigin.CREATED, multiModel, null, modelRelClass);
		modelRel.setName(MODEL_REL_NAME);

		// loop through selected models
		HashMap<String, ArrayList<EObject>> objectNames = new HashMap<String, ArrayList<EObject>>();
		HashMap<EObject, ModelReference> objectModels = new HashMap<EObject, ModelReference>();
		for (Model model : actualParameters) {

			// add models to relationship
			modelRel.getModels().add(model);
			ModelReference modelRef = MultiModelFactoryUtils.createModelReference(modelRel, model);

			// look for identical names in the models
			for (EObject object : model.getRoot().eContents()) {
				EStructuralFeature feature = object.eClass().getEStructuralFeature(NAME_FEATURE);
				if (feature != null && feature instanceof EAttribute && object.eGet(feature) instanceof String) {
					String objectName = (String) object.eGet(feature);
					ArrayList<EObject> objects = objectNames.get(objectName);
					if (objects == null) {
						objects = new ArrayList<EObject>();
						objectNames.put(objectName, objects);
					}
					objects.add(object);
					objectModels.put(object, modelRef);
				}
			}
		}

		// create model relationship structure
		for (Entry<String, ArrayList<EObject>> entry : objectNames.entrySet()) {
			String name = entry.getKey();
			ArrayList<EObject> objects = entry.getValue();
			if (objects.size() > 1) {
				EClass linkClass = (objects.size() == 2) ?
					RelationshipPackage.eINSTANCE.getBinaryLink() :
					RelationshipPackage.eINSTANCE.getLink();
				Link link = MultiModelFactoryUtils.createLink(modelRel, linkClass);
				link.setName(name);
				modelRel.getLinks().add(link);
				for (EObject object : objects) {
					ModelReference modelRef = objectModels.get(object);
					ModelElementReference elementRef = MultiModelFactoryUtils.createModelElementReference(modelRef, object);
					link.getElementRefs().add(elementRef);
				}
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(modelRel);
		return result;
	}

}
