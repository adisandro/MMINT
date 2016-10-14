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

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public abstract class ConditionalOperator extends OperatorImpl {

	// input-output
	protected final static @NonNull String GENERIC_MODELTYPE = "CONDITION";
	protected final static @NonNull String IN_MODEL = "conditionModel";

	//TODO MMINT[SCRIPTING] Make an operator input being selectable twice
	protected boolean evaluateCondition(@NonNull Model conditionModel, @NonNull Operator conditionExpression) {

		//TODO MMINT[SCRIPTING] run or start conditionExpression? i.e. store the byproduct or not?
		return false;
	}

}
