/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.uml.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ComponentsDeployedConstraint implements IJavaModelConstraint {

	@Override
	public boolean validate(Model model) {

		BinaryModelRel deplRel = (BinaryModelRel) model;
		org.eclipse.uml2.uml.Model srcUmlModel;
		srcUmlModel = (org.eclipse.uml2.uml.Model) deplRel.getSourceModel().getEMFInstanceRoot();
		if (srcUmlModel == null) {
			MMINTException.print(IStatus.ERROR, "Can't get model root, skipping validation", null);
			return false;
		}
		for (PackageableElement umlModelObj : srcUmlModel.getPackagedElements()) {
			if (!(umlModelObj instanceof Component)) {
				continue;
			}
			ModelElementReference modelElemRef = MIDRegistry.getModelElementReference(deplRel.getModelEndpointRefs().get(0), umlModelObj);
			if (modelElemRef == null || modelElemRef.getModelElemEndpointRefs().isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
