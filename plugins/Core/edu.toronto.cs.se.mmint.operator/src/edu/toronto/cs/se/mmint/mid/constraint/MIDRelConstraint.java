/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.constraint;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class MIDRelConstraint implements IJavaModelConstraint {

	@Override
	public MAVOTruthValue validate(Model model) {

		try {
			MultiModel instanceMID = (MultiModel) model.getEMFInstanceRoot();
			if (MultiModelRegistry.getOperators(instanceMID).size() > 0) {
				return MAVOTruthValue.FALSE;
			}
			if (MultiModelRegistry.getModelRels(instanceMID).size() == 0) {
				return MAVOTruthValue.FALSE;
			}
			for (Model instanceMIDModel : MultiModelRegistry.getModels(instanceMID)) {
				if (!(instanceMIDModel instanceof ModelRel)) {
					return MAVOTruthValue.FALSE;
				}
			}
			return MAVOTruthValue.TRUE;
		}
		catch (MMINTException e) {
			return MAVOTruthValue.FALSE;
		}
	}

}
