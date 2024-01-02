/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.patch;

import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelRelTypeTransformationConstraint implements IJavaModelConstraint {

	@Override
	public boolean check(Model model) {

		var modelRelType = (ModelRel) model;
		// remove overridden endpoints from the count
		var effectiveEndpointRefs = modelRelType.getModelEndpointRefs().stream()
		  .filter(e1 -> modelRelType.getModelEndpointRefs().stream().noneMatch(e2 -> e2.getSupertypeRef() == e1))
		  .count();
		if (effectiveEndpointRefs != 2) {
			return false;
		}

		return true;
	}

}
