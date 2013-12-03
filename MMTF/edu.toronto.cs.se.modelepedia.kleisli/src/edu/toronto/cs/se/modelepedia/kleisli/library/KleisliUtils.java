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
package edu.toronto.cs.se.modelepedia.kleisli.library;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class KleisliUtils {

	public static String getExtendedModelTypeUriFragment(ModelEndpoint modelTypeEndpoint) {

		return ((ModelRel) modelTypeEndpoint.eContainer()).getName() + IPath.SEPARATOR + modelTypeEndpoint.getTarget().getName() + "." + EcorePackage.eNAME;
	}

	public static String getExtendedModelTypeUri(ModelEndpoint modelTypeEndpoint) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelTypeEndpoint.getTargetUri(),
			getExtendedModelTypeUriFragment(modelTypeEndpoint)
		);
	}

	public static String getExtendedModelUri(ModelEndpoint modelEndpoint) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelEndpoint.getTargetUri(),
			((ModelRel) modelEndpoint.eContainer()).getName() + IPath.SEPARATOR + modelEndpoint.getTarget().getName() + "." + modelEndpoint.getTarget().getFileExtension()
		);
	}

	public void openEditorType(Editor editorType) {

		//TODO open metamodels for endpoints
		//TODO init outline with augmented ones
		//TODO what about the previous wizard dialog class thing?
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
