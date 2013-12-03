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
package edu.toronto.cs.se.modelepedia.kleisli.modelrel;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.ui.IModelRelType;

public class KleisliModelRel extends IModelRelType {

	private static String getExtendedModelTypeUriFragment(ModelEndpoint modelTypeEndpoint) {

		return ((ModelRel) modelTypeEndpoint.eContainer()).getName() + IPath.SEPARATOR + modelTypeEndpoint.getTarget().getName() + "." + EcorePackage.eNAME;
	}

	private static String getExtendedModelTypeUri(ModelEndpoint modelTypeEndpoint) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelTypeEndpoint.getTargetUri(),
			getExtendedModelTypeUriFragment(modelTypeEndpoint)
		);
	}

	private static String getExtendedModelUri(ModelEndpoint modelEndpoint) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelEndpoint.getTargetUri(),
			((ModelRel) modelEndpoint.eContainer()).getName() + IPath.SEPARATOR + modelEndpoint.getTarget().getName() + "." + modelEndpoint.getTarget().getFileExtension()
		);
	}

	@Override
	public void newModelType(Model newModelType) throws Exception {

		MultiModelUtils.createDirectoryInState(newModelType.getName());
	}

	@Override
	public void deleteModelType(Model modelType) {

		MultiModelUtils.deleteDirectoryInState(modelType.getName());
	}

	@Override
	public void addModelEndpointType(ModelEndpointReference newModelTypeEndpointRef) {

		ModelEndpoint newModelTypeEndpoint = newModelTypeEndpointRef.getObject();
		String newModelTypeUriFragment = getExtendedModelTypeUriFragment(newModelTypeEndpoint);
		boolean isExtendedMetamodel = false;
		if (MultiModelUtils.isFileInState(newModelTypeUriFragment) == null) {
			isExtendedMetamodel = MidDiagramUtils.getBooleanInput("Create new Kleisli model relationship type", "Extend " + newModelTypeEndpoint.getTarget().getName() + " metamodel?");
		}
		if (isExtendedMetamodel) {
			EPackage rootModelTypeObj = (EPackage) MultiModelTypeIntrospection.getRoot(newModelTypeEndpoint.getTarget());
			rootModelTypeObj.setNsURI(getExtendedModelTypeUri(newModelTypeEndpoint));
			try {
				MultiModelUtils.createModelFileInState(rootModelTypeObj, newModelTypeUriFragment);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended metamodel file, fallback to no extension", e);
			}
		}
	}

	@Override
	public void removeModelEndpointType(ModelEndpointReference modelTypeEndpointRef) {

		String modelTypeUri = getExtendedModelTypeUri(modelTypeEndpointRef.getObject());
		MultiModelUtils.deleteFileInState(modelTypeUri);
	}

	public void openEditorType(Editor editorType) {

		//TODO open metamodels for endpoints
		//TODO init outline with augmented ones
		//TODO what about the previous wizard dialog class thing?
	}

	@Override
	public void newModelInstance(Model newModel) throws Exception {

		MultiModelUtils.createDirectory(MultiModelUtils.replaceLastSegmentInUri(newModel.getUri(), newModel.getName()));
	}

	@Override
	public void deleteModelInstance(Model model) {

		MultiModelUtils.deleteDirectory(MultiModelUtils.replaceLastSegmentInUri(model.getUri(), model.getName()));
	}

	@Override
	public void addModelEndpoint(ModelEndpointReference newModelEndpointRef) {

		// do nothing
	}

	@Override
	public void removeModelEndpoint(ModelEndpointReference modelEndpointRef) {

		// do nothing
	}

	public void openEditor(ModelRel modelRel) {

		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			ModelEndpoint modelTypeEndpoint = modelEndpoint.getMetatype();
			if (MultiModelUtils.isFileInState(getExtendedModelTypeUri(modelTypeEndpoint)) != null) {
				String newModelUri = getExtendedModelUri(modelEndpoint);
				try {
					MultiModelUtils.copyTextFileAndReplaceText(modelEndpoint.getTargetUri(), newModelUri, modelEndpoint.getTarget().getMetatypeUri(), modelTypeEndpoint.getUri());
					EObject rootModelObj = MultiModelUtils.getModelFile(newModelUri, true);
					//TODO derive the augmented model
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Error creating extended model file, fallback to no extension", e);
				}
			}
		}
		//TODO init outline with augmented ones
	}

	//TODO MMTF[KLEISLI] Other actions to be made transparent, e.g. validation?

}
