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
package edu.toronto.cs.se.mmint.java.reasoning;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.mid.Model;

public interface IJavaOperatorInputConstraint {

	/**
	 * Checks if the input models, already individually validated as actual parameters, are allowed by an operator type.
	 * This is meant to check that the input models as a whole are valid, if there are cases when formal parameter
	 * compliance alone ({@link edu.toronto.cs.se.mmint.mid.operator.Operator#checkAllowedInputs(EList)}) is not enough.
	 * 
	 * @param inputsByName
	 *            The input model instances, identified by their formal parameter name.
	 * @return True if the input models are allowed, false otherwise.
	 */
	public boolean isAllowedInput(Map<String, Model> inputsByName);

}
