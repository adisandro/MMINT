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
package edu.toronto.cs.se.mmtf.mavo.library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class MultiModelMAVOInstanceFactory extends MultiModelInstanceFactory {

	public static Model createModel(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = MultiModelInstanceFactory.createModel(modelType, newModelUri, origin, multiModel);
		MAVOUtils.initializeMAVOModel(MultiModelTypeIntrospection.getRoot(newModel), newModel);

		return newModel;
	}

	public static Model createModelAndEditor(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = MultiModelInstanceFactory.createModelAndEditor(modelType, newModelUri, origin, multiModel);
		MAVOUtils.initializeMAVOModel(MultiModelTypeIntrospection.getRoot(newModel), newModel);

		return newModel;
	}

	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, String newModelElemName, EObject modelEObject) throws MMTFException {

		ModelElementReference newModelElemRef = MultiModelInstanceFactory.createModelElementAndModelElementReference(modelEndpointRef, newModelElemName, modelEObject);
		MAVOUtils.initializeMAVOModelElementReference(modelEObject, newModelElemRef);

		return newModelElemRef;
	}

	public static Model copyModel(Model oldModel, String newModelName, MultiModel multiModel) throws Exception {

		//TODO MMTF: copy associated diagrams too
		File oldFile = new File(MultiModelRegistry.prependWorkspaceToUri(oldModel.getUri()));
		String newModelUri = MultiModelRegistry.replaceFileNameInUri(oldModel.getUri(), newModelName);
		File newFile = new File(MultiModelRegistry.prependWorkspaceToUri(newModelUri));
		BufferedReader oldBuffer = new BufferedReader(new FileReader(oldFile));
		BufferedWriter newBuffer = new BufferedWriter(new FileWriter(newFile));
		String oldLine;
		while ((oldLine = oldBuffer.readLine()) != null) {
			newBuffer.write(oldLine.replaceAll(oldModel.getName(), newModelName));
			newBuffer.newLine();
		}
		oldBuffer.close();
		newBuffer.close();
		Model newModel = createModelAndEditor(oldModel.getMetatype(), newModelUri, ModelOrigin.CREATED, multiModel);

		return newModel;
	}

	public static ModelRel copyModelRel(ModelRel oldModelRel, String newModelRelName, MultiModel multiModel) throws Exception {

		// create initial empty copy
		ModelRel newModelRel = createModelRel(
			oldModelRel.getMetatype(),
			null,
			ModelOrigin.CREATED,
			oldModelRel.eClass(),
			multiModel
		);
		newModelRel.setName(newModelRelName);

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		for (ModelEndpointReference oldModelEndpointRef : oldModelRel.getModelEndpointRefs()) {
			Model newModel = MultiModelRegistry.getExtendibleElement(multiModel, oldModelEndpointRef.getTargetUri());
			ModelEndpointReference newModelEndpointRef = createModelEndpointAndModelEndpointReference(oldModelEndpointRef.getObject().getMetatype(), newModelRel, newModel, false);
			// model elements
			for (ModelElementReference oldModelElemRef : oldModelEndpointRef.getModelElemRefs()) {
				EObject newModelObj = MultiModelTypeIntrospection.getPointer(oldModelElemRef.getObject());
				ModelElementReference newModelElemRef = createModelElementAndModelElementReference(newModelEndpointRef, oldModelElemRef.getObject().getName(), newModelObj);
				newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
			}
		}
		// links
		for (LinkReference oldLinkRef : oldModelRel.getLinkRefs()) {
			LinkReference newLinkRef = createLinkAndLinkReference(oldLinkRef.getObject().getMetatype(), newModelRel, oldLinkRef.getObject().eClass(), oldLinkRef.eClass());
			newLinkRef.getObject().setName(oldLinkRef.getObject().getName());
			for (ModelElementEndpointReference oldModelElemEndpointRef : oldLinkRef.getModelElemEndpointRefs()) {
				ModelElementReference newModelElemRef = newModelElemRefs.get(oldModelElemEndpointRef.getTargetUri());
				createModelElementEndpointAndModelElementEndpointReference(oldModelElemEndpointRef.getObject().getMetatype(), newLinkRef, newModelElemRef, false);
			}
		}

		return newModelRel;
	}

}
