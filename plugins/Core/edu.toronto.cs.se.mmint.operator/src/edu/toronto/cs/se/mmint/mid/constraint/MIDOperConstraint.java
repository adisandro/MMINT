/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;

public class MIDOperConstraint implements IJavaModelConstraint {

	@Override
	public boolean validate(Model model) {

		try {
			MID instanceMID = (MID) model.getEMFInstanceRoot();
			if (MultiModelRegistry.getModels(instanceMID).size() > 0) {
				return false;
			}
			if (MultiModelRegistry.getOperators(instanceMID).size() == 0) {
				return false;
			}
			return true;
		}
		catch (MMINTException e) {
			return false;
		}
	}

}
