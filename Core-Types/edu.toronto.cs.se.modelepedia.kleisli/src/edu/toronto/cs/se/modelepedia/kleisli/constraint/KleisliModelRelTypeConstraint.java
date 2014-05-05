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
package edu.toronto.cs.se.modelepedia.kleisli.constraint;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.modelepedia.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.operator.patch.ModelRelTypeTransformationConstraint;

public class KleisliModelRelTypeConstraint implements IJavaModelConstraint {

	@Override
	public MAVOTruthValue validate(Model model) {

		KleisliModelRel kModelRelType = (KleisliModelRel) model;
		if (new ModelRelTypeTransformationConstraint().validate(kModelRelType) != MAVOTruthValue.TRUE) {
			return MAVOTruthValue.FALSE;
		}
		// must be homomorphism
		for (ModelElementReference modelElemTypeRef : kModelRelType.getModelEndpointRefs().get(0).getModelElemRefs()) {
			if (
				modelElemTypeRef.getModelElemEndpointRefs().size() != 1 ||
				((LinkReference) modelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().size() != 2
			) {
				return MAVOTruthValue.FALSE;
			}
		}
		for (ModelElementReference modelElemTypeRef : kModelRelType.getModelEndpointRefs().get(1).getModelElemRefs()) {
			if (modelElemTypeRef.getModelElemEndpointRefs().size() > 1) {
				return MAVOTruthValue.FALSE;
			}
		}

		return MAVOTruthValue.TRUE;
	}

}
