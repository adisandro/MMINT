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
import org.eclipse.emf.ecore.EcorePackage;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

public class KleisliUtils {

	public static String getModelRelTypeExtendedUri(KleisliModelRel modelRelType) {

		return modelRelType.getName();
	}

	public static String getModelRelExtendedUri(KleisliModelRel modelRel) {

		String baseModelRelExtendedUri = MultiModelUtils.replaceLastSegmentInUri(MultiModelRegistry.getModelAndModelElementUris(modelRel, true)[0], modelRel.getMetatype().getName());
		int iModelRelExtendedUri = -1;
		do {
			iModelRelExtendedUri++;
		}
		while (MultiModelUtils.isFileOrDirectory(baseModelRelExtendedUri + iModelRelExtendedUri, true) != null);

		return baseModelRelExtendedUri + iModelRelExtendedUri;
	}

	public static String getModelTypeEndpointExtendedUri(Model modelType, KleisliModelRel containerModelRelType) {

		return containerModelRelType.getExtendedUri() + IPath.SEPARATOR + modelType.getName() + "." + EcorePackage.eNAME;
	}

	public static String getModelEndpointExtendedUri(KleisliModelEndpoint modelEndpoint) {

		return ((KleisliModelRel) modelEndpoint.eContainer()).getExtendedUri() + IPath.SEPARATOR + modelEndpoint.getTarget().getName() + "." + modelEndpoint.getTarget().getFileExtension();
	}

}
