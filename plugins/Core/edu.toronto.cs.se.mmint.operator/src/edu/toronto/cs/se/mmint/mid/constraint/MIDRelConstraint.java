/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class MIDRelConstraint implements IJavaModelConstraint {

	@Override
	public boolean validate(Model model) {

		try {
		    EObject modelObjRoot = model.getEMFInstanceRoot();
		    if (!(modelObjRoot instanceof MID)) {
		        return false;
		    }
			MID instanceMID = (MID) modelObjRoot;
			if (instanceMID.getOperators().size() > 0) {
				return false;
			}
			if (instanceMID.getModelRels().size() == 0) {
				return false;
			}
			for (Model instanceMIDModel : instanceMID.getModels()) {
				if (!(instanceMIDModel instanceof ModelRel)) {
					return false;
				}
			}
			return true;
		}
		catch (MMINTException e) {
			return false;
		}
	}

}
