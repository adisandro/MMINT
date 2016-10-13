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
package edu.toronto.cs.se.mmint.mid.operator;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public abstract class ConditionalOperator extends OperatorImpl {

	// input-output
	protected final static @NonNull String GENERIC_MODELTYPE = "CONDITION";
	protected final static @NonNull String IN_MODEL = "conditionModel";

	//TODO MMINT[SCRIPTING] Make the condition flexible: (model + TYPE) + boolean comparators
	//TODO MMINT[SCRIPTING] Make an operator input being selectable twice
	protected boolean evaluateCondition(@NonNull Model conditionModel, @NonNull Model conditionModelType) {

		// check constraint only if types match (Model and Model, or ModelRel and ModelRel)
		if ((conditionModel instanceof ModelRel) != (conditionModelType instanceof ModelRel)) {
			return false;
		}
		// check constraint
		if (MIDTypeHierarchy.instanceOf(conditionModel, conditionModelType.getUri(), false) &&
			MIDConstraintChecker.checkModelConstraint(conditionModel, conditionModelType.getConstraint())) {
			return true;
		}

		return false;
	}

}
