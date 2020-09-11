/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.Model;

public interface IReasoningEngine {

	public default boolean checkModelConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

	//TODO MMINT[REFINE] Is this really for all models? == Can I refine a model based on a false property, to make it true?
	public default @Nullable Model refineModelByConstraint(Model model) {

		return null;
	}

}
