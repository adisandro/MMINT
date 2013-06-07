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
		MAVOUtils.annotateMAVOModel(MultiModelTypeIntrospection.getRoot(newModel), newModel);

		return newModel;
	}

	public static Model createModelAndEditor(Model modelType, String newModelUri, ModelOrigin origin, MultiModel multiModel) throws MMTFException {

		Model newModel = MultiModelInstanceFactory.createModelAndEditor(modelType, newModelUri, origin, multiModel);
		MAVOUtils.annotateMAVOModel(MultiModelTypeIntrospection.getRoot(newModel), newModel);

		return newModel;
	}

	public static ModelElementReference createModelElementAndModelElementReference(ModelEndpointReference modelEndpointRef, String newModelElemName, EObject modelEObject) throws MMTFException {

		ModelElementReference newModelElemRef = MultiModelInstanceFactory.createModelElementAndModelElementReference(modelEndpointRef, newModelElemName, modelEObject);
		MAVOUtils.annotateMAVOModelElementReference(modelEObject, newModelElemRef);

		return newModelElemRef;
	}

	public static void copyModelRel(ModelRel oldModelRel, ModelRel newModelRel) throws Exception {

		Map<String, ModelElementReference> newModelElemRefs = new HashMap<String, ModelElementReference>();
		// models
		MultiModel multiModel = MultiModelRegistry.getMultiModel(newModelRel);
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
			for (ModelElementEndpointReference oldModelElemEndpointRef : oldLinkRef.getModelElemEndpointRefs()) {
				ModelElementReference newModelElemRef = newModelElemRefs.get(oldModelElemEndpointRef.getTargetUri());
				createModelElementEndpointAndModelElementEndpointReference(oldModelElemEndpointRef.getObject().getMetatype(), newLinkRef, newModelElemRef, false);
			}
		}
	}

}
