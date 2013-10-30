/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.constraint;

import edu.toronto.cs.se.mmtf.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.JavaModelConstraint;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

public class MAVOModelConstraint extends JavaModelConstraint {

	public MAVOModelConstraint(Model model) {

		super(model);
	}

	@Override
	public MAVOTruthValue validate() {

		if (MAVOUtils.isMAVOModel(model)) {
			return MAVOTruthValue.TRUE;
		}
		return MAVOTruthValue.FALSE;
	}

}
