/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.PackageableElement;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.JavaModelConstraint;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

public class ComponentsDeployedConstraint extends JavaModelConstraint {

	public ComponentsDeployedConstraint(Model model) {

		super(model);
	}

	@Override
	public MAVOTruthValue validate() {

		BinaryModelRel deplRel = (BinaryModelRel) model;
		org.eclipse.uml2.uml.Model srcUmlModel;
		try {
			srcUmlModel = (org.eclipse.uml2.uml.Model) deplRel.getSourceModel().getEMFRoot();
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Can't get model root, skipping validation",  e);
			return MAVOTruthValue.FALSE;
		}
		for (PackageableElement umlModelObj : srcUmlModel.getPackagedElements()) {
			if (!(umlModelObj instanceof Component)) {
				continue;
			}
			ModelElementReference modelElemRef = MultiModelRegistry.getModelElementReference(deplRel.getModelEndpointRefs().get(0), umlModelObj);
			if (modelElemRef == null || modelElemRef.getModelElemEndpointRefs().isEmpty()) {
				return MAVOTruthValue.FALSE;
			}
		}
		return MAVOTruthValue.TRUE;
	}

}
