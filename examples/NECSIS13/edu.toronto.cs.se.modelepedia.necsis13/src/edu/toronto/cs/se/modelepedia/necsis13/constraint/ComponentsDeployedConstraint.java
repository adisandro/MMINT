/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.necsis13.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ComponentsDeployedConstraint implements IJavaModelConstraint {

	@Override
	public boolean check(Model model) {

		var deplRel = (BinaryModelRel) model;
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
			var modelElemRef = MIDRegistry.getModelElementReference(deplRel.getModelEndpointRefs().get(0), umlModelObj);
			if (modelElemRef == null || modelElemRef.getModelElemEndpointRefs().isEmpty()) {
				return false;
			}
		}
		return true;
	}

}
