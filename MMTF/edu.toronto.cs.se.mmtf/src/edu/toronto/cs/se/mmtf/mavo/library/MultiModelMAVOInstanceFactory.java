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
package edu.toronto.cs.se.mmtf.mavo.library;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;

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

}
