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

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

public class UMLDeploymentDiagramModelConstraint extends UMLModelConstraint {

	public UMLDeploymentDiagramModelConstraint(Model model) {

		super(model);
	}

	@Override
	public MAVOTruthValue validate() {

		return validate(UMLModelConstraint.UML_DEPLOYMENTDIAGRAM_TYPE);
	}

}
