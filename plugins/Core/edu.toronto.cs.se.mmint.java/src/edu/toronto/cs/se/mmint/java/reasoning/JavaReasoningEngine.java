/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraint;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;

public class JavaReasoningEngine implements IReasoningEngine {

	@Override
	public boolean checkModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		String javaClassName = constraint.getImplementation();
		String modelTypeUri = (constraintLevel == MIDLevel.INSTANCES) ?
			((Model) constraint.eContainer()).getMetatypeUri() :
			((Model) constraint.eContainer()).getUri();
		try {
			IJavaModelConstraint javaConstraint = (IJavaModelConstraint)
				MIDTypeRegistry.getTypeBundle(modelTypeUri).
				loadClass(javaClassName).
				getConstructor().
				newInstance();

			return javaConstraint.validate(model);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Java constraint error, evaluating to false: " + javaClassName, e);
			return false;
		}
	}

	@Override
	public boolean checkOperatorInputConstraint(@NonNull Map<String, Model> inputsByName, @NonNull OperatorConstraint constraint) {

		String javaClassName = constraint.getImplementation();
		String operatorTypeUri = ((Operator) constraint.eContainer()).getUri();
		try {
			IJavaOperatorInputConstraint javaConstraint = (IJavaOperatorInputConstraint)
				MIDTypeRegistry.getTypeBundle(operatorTypeUri).
				loadClass(javaClassName).
				getConstructor().
				newInstance();

			return javaConstraint.isAllowedInput(inputsByName);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Java constraint error, evaluating to false: " + javaClassName, e);
			return false;
		}
	}

	@Override
	public boolean checkModelConstraintConsistency(@NonNull Model modelType, String constraint) {

		return true;
	}

	@Override
	public @Nullable Model refineModelByConstraint(@NonNull Model model) {

		return null;
	}

}
