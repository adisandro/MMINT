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
package edu.toronto.cs.se.modelepedia.operator.diff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.trait.MultiModelMAVOInstanceFactory;
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
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class ModelDifference extends OperatorExecutableImpl {

	private final static String MODEL_REL_NAME = "diff";
	private final static String DELETED_ELEMENT_LINK_NAME = "del";
	private final static String ADDED_ELEMENT_LINK_NAME = "add";

	private HashMap<String, ModelElementReference> createModelElementReferenceTable(ModelEndpointReference modelEndpointRef) {

		HashMap<String, ModelElementReference> modelElemRefTable = new HashMap<String, ModelElementReference>();
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) {
			modelElemRefTable.put(modelElemRef.getUri(), modelElemRef);
		}

		return modelElemRefTable;
	}

	private List<EObject> getDiffModelElements(Model model, HashMap<String, ModelElementReference> modelElemRefTable) {

		List<EObject> diffModelEObjects = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(MultiModelTypeIntrospection.getRoot(model), true);
		while (iterator.hasNext()) {
			EObject modelEObject = iterator.next();
			String modelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
			if (modelElemRefTable.get(modelElemUri) == null) {
				diffModelEObjects.add(modelEObject);
			}
		}

		return diffModelEObjects;
	}

	private ModelEndpointReference createModelEndpointReference(ModelRel newModelRel, ModelEndpointReference modelEndpointReference, String linksName) throws MMTFException {

		Model model = modelEndpointReference.getObject().getTarget();
		HashMap<String, ModelElementReference> modelElemRefTable = createModelElementReferenceTable(modelEndpointReference);
		List<EObject> diffModelEObjects = getDiffModelElements(model, modelElemRefTable);
		ModelEndpointReference newModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			newModelRel,
			model,
			false
		);
		for (EObject modelEObject : diffModelEObjects) {
			// create model element
			ModelElementReference newModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
				newModelEndpointRef,
				null,
				modelEObject
			);
			// create link as property
			LinkReference newLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
				null,
				newModelRel,
				RelationshipPackage.eINSTANCE.getLink(),
				RelationshipPackage.eINSTANCE.getLinkReference()
			);
			newLinkRef.getObject().setName(linksName);
			// add model element endpoint to link
			ModelElementEndpointReference newModelElemEndpointRef = MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
				null,
				newLinkRef,
				newModelElemRef,
				false
			);
			newModelElemEndpointRef.getObject().setName(newModelElemRef.getObject().getName());
		}

		return newModelEndpointRef;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model srcModel = actualParameters.get(0);
		ModelRel matchRel = (ModelRel) actualParameters.get(1);
		Model tgtModel = actualParameters.get(2);

		// create output model relationship
		MultiModel multiModel = (MultiModel) srcModel.eContainer();
		ModelRel newModelRel = MultiModelInstanceFactory.createModelRel(
			null,
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);
		newModelRel.setName(MODEL_REL_NAME);

		// add src model endpoint with deleted elements
		ModelEndpointReference newSrcModelEndpointRef = createModelEndpointReference(newModelRel, matchRel.getModelEndpointRefs().get(0), DELETED_ELEMENT_LINK_NAME);
		newSrcModelEndpointRef.getObject().setName(srcModel.getName());
		// add tgt model endpoint with added elements
		ModelEndpointReference newTgtModelEndpointRef = createModelEndpointReference(newModelRel, matchRel.getModelEndpointRefs().get(1), ADDED_ELEMENT_LINK_NAME);
		newTgtModelEndpointRef.getObject().setName(tgtModel.getName());

		EList<Model> result = new BasicEList<Model>();
		result.add(newModelRel);
		return result;
	}

}
