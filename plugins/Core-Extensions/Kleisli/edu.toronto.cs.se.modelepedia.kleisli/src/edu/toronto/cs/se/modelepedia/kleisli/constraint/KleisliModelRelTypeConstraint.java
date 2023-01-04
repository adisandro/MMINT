/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelRel;
import edu.toronto.cs.se.modelepedia.operator.patch.ModelRelTypeTransformationConstraint;

public class KleisliModelRelTypeConstraint implements IJavaModelConstraint {

	@Override
	public boolean check(Model model) {

		//TODO MMINT[OO] There should be an api to do type cast with a metamodel extension like this
		if (!(model instanceof KleisliModelRel)) {
			return false;
		}
		KleisliModelRel kModelRelType = (KleisliModelRel) model;
		if (!(new ModelRelTypeTransformationConstraint().check(kModelRelType))) {
			return false;
		}
		// must be homomorphism
		for (ModelElementReference modelElemTypeRef : kModelRelType.getModelEndpointRefs().get(0).getModelElemRefs()) {
			if (
				modelElemTypeRef.getModelElemEndpointRefs().size() != 1 ||
				((MappingReference) modelElemTypeRef.getModelElemEndpointRefs().get(0).eContainer()).getModelElemEndpointRefs().size() != 2
			) {
				return false;
			}
		}
		for (ModelElementReference modelElemTypeRef : kModelRelType.getModelEndpointRefs().get(1).getModelElemRefs()) {
			if (modelElemTypeRef.getModelElemEndpointRefs().size() > 1) {
				return false;
			}
		}

		return true;
	}

}
