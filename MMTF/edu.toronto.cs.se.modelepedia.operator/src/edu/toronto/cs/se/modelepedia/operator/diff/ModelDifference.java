/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
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

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

public class ModelDifference extends OperatorExecutableImpl {

	private final static String MODELREL_NAME = "diff";
	private final static String DELETED_ELEMENT_LINK_NAME = "del";
	private final static String ADDED_ELEMENT_LINK_NAME = "add";

	private HashMap<String, ModelElementReference> createModelElementReferenceTable(ModelEndpointReference modelEndpointRef) {

		HashMap<String, ModelElementReference> modelElemRefTable = new HashMap<String, ModelElementReference>();
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) {
			String modelElemUri = modelElemRef.getUri().substring(0, modelElemRef.getUri().indexOf(MMTF.ROLE_SEPARATOR));
			modelElemRefTable.put(modelElemUri, modelElemRef);
		}

		return modelElemRefTable;
	}

	private List<EObject> getDiffModelObjects(Model model, HashMap<String, ModelElementReference> modelElemRefTable) {

		List<EObject> diffModelEObjects = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(MultiModelTypeIntrospection.getRoot(model), true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			String modelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[1];
			if (modelElemRefTable.get(modelElemUri) == null) {
				diffModelEObjects.add(modelObj);
			}
		}

		return diffModelEObjects;
	}

	private ModelEndpointReference createModelEndpointReference(ModelRel diffModelRel, ModelEndpointReference modelEndpointRef, String linksName) throws MMTFException {

		Model model = modelEndpointRef.getObject().getTarget();
		HashMap<String, ModelElementReference> modelElemRefTable = createModelElementReferenceTable(modelEndpointRef);
		List<EObject> diffModelObjs = getDiffModelObjects(model, modelElemRefTable);
		ModelEndpointReference newModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			model,
			false,
			diffModelRel
		);
		for (EObject modelObj : diffModelObjs) {
			// create unary link
			LinkReference diffLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
				null,
				RelationshipPackage.eINSTANCE.getLink(),
				RelationshipPackage.eINSTANCE.getLinkReference(),
				diffModelRel
			);
			diffLinkRef.getObject().setName(linksName);
			// create model element
			ModelElementReference diffModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
				newModelEndpointRef,
				null,
				modelObj
			);
			// create model element endpoint
			MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
				null,
				diffModelElemRef,
				false,
				diffLinkRef
			);
		}

		return newModelEndpointRef;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		ModelRel matchRel = (ModelRel) actualParameters.get(1);

		// create diff model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(matchRel);
		ModelRel diffModelRel = MultiModelInstanceFactory.createModelRel(
			null,
			null,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			ModelOrigin.CREATED,
			multiModel
		);
		diffModelRel.setName(MODELREL_NAME);

		// create src model endpoint with deleted elements
		createModelEndpointReference(diffModelRel, matchRel.getModelEndpointRefs().get(0), DELETED_ELEMENT_LINK_NAME);
		// create tgt model endpoint with added elements
		createModelEndpointReference(diffModelRel, matchRel.getModelEndpointRefs().get(1), ADDED_ELEMENT_LINK_NAME);

		EList<Model> result = new BasicEList<Model>();
		result.add(diffModelRel);
		return result;
	}

}
