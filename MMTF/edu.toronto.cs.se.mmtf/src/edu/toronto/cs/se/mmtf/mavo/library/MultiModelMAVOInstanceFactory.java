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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
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

		ModelElementReference newModelElemRef = MultiModelInstanceFactory.createModelElementAndModelElementReference(newModelElemName, modelEObject, modelEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelEObject, newModelElemRef);

		return newModelElemRef;
	}

	public static Model copyModelAndEditor(Model oldModel, String newModelName, MultiModel multiModel, boolean copyDiagramEditor) throws Exception {

		// copy model
		String oldUri = MultiModelUtils.prependWorkspaceToUri(oldModel.getUri());
		String newModelUri = MultiModelUtils.replaceFileNameInUri(oldModel.getUri(), newModelName);
		String newUri = MultiModelUtils.prependWorkspaceToUri(newModelUri);
		MultiModelUtils.copyFileAndReplaceText(oldUri, newUri, oldModel.getName(), newModelName);

		// copy diagram editors
		if (copyDiagramEditor) {
			for (Editor oldEditor : oldModel.getEditors()) {
				if (oldEditor.getUri().equals(oldModel.getUri())) {
					continue;
				}
				oldUri = MultiModelUtils.prependWorkspaceToUri(oldEditor.getUri());
				newUri = MultiModelUtils.prependWorkspaceToUri(MultiModelUtils.replaceFileNameInUri(oldEditor.getUri(), newModelName));
				MultiModelUtils.copyFileAndReplaceText(oldUri, newUri, oldModel.getName(), newModelName);
				//TODO MMTF: add support for notation extra file (e.g. in UML)
			}
		}
		Model newModel = createModelAndEditor(oldModel.getMetatype(), newModelUri, ModelOrigin.CREATED, multiModel);

		return newModel;
	}

	public static ModelRel copyModelRel(ModelRel oldModelRel, String newModelRelName, MultiModel multiModel) throws Exception {

		// create initial empty copy
		ModelRel newModelRel = createModelRel(
			oldModelRel.getMetatype(),
			null,
			oldModelRel.eClass(),
			ModelOrigin.CREATED,
			multiModel
		);
		newModelRel.setName(newModelRelName);

		// models
		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		for (ModelEndpointReference oldModelEndpointRef : oldModelRel.getModelEndpointRefs()) {
			Model newModel = MultiModelRegistry.getExtendibleElement(oldModelEndpointRef.getTargetUri(), multiModel);
			ModelEndpointReference newModelEndpointRef = createModelEndpointAndModelEndpointReference(oldModelEndpointRef.getObject().getMetatype(), newModel, false, newModelRel);
			// model elements
			for (ModelElementReference oldModelElemRef : oldModelEndpointRef.getModelElemRefs()) {
				EObject newModelObj = MultiModelTypeIntrospection.getPointer(oldModelElemRef.getObject());
				ModelElementReference newModelElemRef = createModelElementAndModelElementReference(newModelEndpointRef, oldModelElemRef.getObject().getName(), newModelObj);
				newModelElemRefs.put(newModelElemRef.getUri(), newModelElemRef);
			}
		}
		// links
		for (LinkReference oldLinkRef : oldModelRel.getLinkRefs()) {
			LinkReference newLinkRef = createLinkAndLinkReference(oldLinkRef.getObject().getMetatype(), oldLinkRef.getObject().eClass(), oldLinkRef.eClass(), newModelRel);
			MAVOUtils.copyMAVOElement(oldLinkRef.getObject(), newLinkRef.getObject());
			newLinkRef.getObject().setName(oldLinkRef.getObject().getName());
			for (ModelElementEndpointReference oldModelElemEndpointRef : oldLinkRef.getModelElemEndpointRefs()) {
				ModelElementReference newModelElemRef = newModelElemRefs.get(oldModelElemEndpointRef.getTargetUri());
				createModelElementEndpointAndModelElementEndpointReference(oldModelElemEndpointRef.getObject().getMetatype(), newModelElemRef, false, newLinkRef);
			}
		}

		return newModelRel;
	}

}
