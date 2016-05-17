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
package edu.toronto.cs.se.modelepedia.operator.diff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelDifference extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "match";
	private final static @NonNull String OUT_MODELREL = "diff";
	// constants
	private final static String MODELREL_NAME = "diff";
	private final static String DELETED_ELEMENT_LINK_NAME = "del";
	private final static String ADDED_ELEMENT_LINK_NAME = "add";

	private HashMap<String, ModelElementReference> createModelElementReferenceTable(ModelEndpointReference modelEndpointRef) {

		HashMap<String, ModelElementReference> modelElemRefTable = new HashMap<String, ModelElementReference>();
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) {
			String modelElemUri = modelElemRef.getUri().substring(0, modelElemRef.getUri().indexOf(MMINT.ROLE_SEPARATOR));
			modelElemRefTable.put(modelElemUri, modelElemRef);
		}

		return modelElemRefTable;
	}

	private List<EObject> getDiffModelObjects(Model model, HashMap<String, ModelElementReference> modelElemRefTable) throws MMINTException {

		List<EObject> diffModelEObjects = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = EcoreUtil.getAllContents(model.getEMFInstanceRoot(), true);
		while (iterator.hasNext()) {
			EObject modelObj = iterator.next();
			String modelElemUri = MIDRegistry.getModelAndModelElementUris(modelObj, MIDLevel.INSTANCES)[1];
			if (modelElemRefTable.get(modelElemUri) == null) {
				diffModelEObjects.add(modelObj);
			}
		}

		return diffModelEObjects;
	}

	private ModelEndpointReference createModelEndpointReference(ModelEndpoint rootModelTypeEndpoint, Mapping rootMappingType, ModelElementEndpoint rootModelElemTypeEndpoint, ModelRel diffModelRel, ModelEndpointReference modelEndpointRef, String linksName) throws MMINTException {

		Model model = modelEndpointRef.getObject().getTarget();
		HashMap<String, ModelElementReference> modelElemRefTable = createModelElementReferenceTable(modelEndpointRef);
		List<EObject> diffModelObjs = getDiffModelObjects(model, modelElemRefTable);
		ModelEndpointReference newModelEndpointRef = rootModelTypeEndpoint.createInstance(model, diffModelRel);
		for (EObject modelObj : diffModelObjs) {
			// create unary link
			MappingReference diffMappingRef = rootMappingType.createInstanceAndReference(false, diffModelRel);
			diffMappingRef.getObject().setName(linksName);
			// create model element
			ModelElementReference diffModelElemRef = newModelEndpointRef.createModelElementInstanceAndReference(modelObj, null);
			// create model element endpoint
			rootModelElemTypeEndpoint.createInstanceAndReference(diffModelElemRef, diffMappingRef);
		}

		return newModelEndpointRef;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		ModelRel matchRel = (ModelRel) inputsByName.get(IN_MODELREL);

		// create diff model relationship
		ModelRel rootModelRelType = MIDTypeHierarchy.getRootModelRelType();
		BinaryModelRel diffModelRel = rootModelRelType.createBinaryInstance(null, outputMIDsByName.get(OUT_MODELREL));
		diffModelRel.setName(MODELREL_NAME);

		ModelEndpoint rootModelTypeEndpoint = MIDTypeHierarchy.getRootModelTypeEndpoint();
		Mapping rootMappingType = MIDTypeHierarchy.getRootMappingType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MIDTypeHierarchy.getRootModelElementTypeEndpoint();
		// create src model endpoint with deleted elements
		createModelEndpointReference(rootModelTypeEndpoint, rootMappingType, rootModelElemTypeEndpoint, diffModelRel, matchRel.getModelEndpointRefs().get(0), DELETED_ELEMENT_LINK_NAME);
		// create tgt model endpoint with added elements
		createModelEndpointReference(rootModelTypeEndpoint, rootMappingType, rootModelElemTypeEndpoint, diffModelRel, matchRel.getModelEndpointRefs().get(1), ADDED_ELEMENT_LINK_NAME);

		// output
		Map<String, Model> outputs = new HashMap<>();
		outputs.put(OUT_MODELREL, diffModelRel);

		return outputs;
	}

}
