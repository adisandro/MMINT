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
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;

public class KleisliUtils {

	public static String getExtendedModelTypeUriFragment(Model modelType, KleisliModelRel containerModelRelType) {

		return containerModelRelType.getName() + IPath.SEPARATOR + modelType.getName() + "." + EcorePackage.eNAME;
	}

	public static String getExtendedModelTypeUri(Model modelType, KleisliModelRel containerModelRelType) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelType.getUri(),
			getExtendedModelTypeUriFragment(modelType, containerModelRelType)
		);
	}

	public static String getExtendedModelUri(KleisliModelEndpoint modelEndpoint) {

		return MultiModelUtils.replaceLastSegmentInUri(
			modelEndpoint.getTargetUri(),
			((ModelRel) modelEndpoint.eContainer()).getName() + IPath.SEPARATOR + modelEndpoint.getTarget().getName() + "." + modelEndpoint.getTarget().getFileExtension()
		);
	}

}
