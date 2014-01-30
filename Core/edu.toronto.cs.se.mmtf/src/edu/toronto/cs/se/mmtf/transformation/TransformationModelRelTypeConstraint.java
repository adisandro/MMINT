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
package edu.toronto.cs.se.mmtf.transformation;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.JavaModelConstraint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

public class TransformationModelRelTypeConstraint extends JavaModelConstraint {

	public TransformationModelRelTypeConstraint(Model model) {

		super(model);
	}

	@Override
	public MAVOTruthValue validate() {

		ModelRel modelRelType = (ModelRel) model;
		if (modelRelType.getModelEndpointRefs().size() != 2) {
			return MAVOTruthValue.FALSE;
		}

		return MAVOTruthValue.TRUE;
	}

}
