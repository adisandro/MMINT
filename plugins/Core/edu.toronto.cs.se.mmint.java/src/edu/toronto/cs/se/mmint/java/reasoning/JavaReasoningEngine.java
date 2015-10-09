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
package edu.toronto.cs.se.mmint.java.reasoning;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;

public class JavaReasoningEngine implements IReasoningEngine {

	@Override
	public boolean checkConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		String javaClassName = constraint.getImplementation();
		String modelTypeUri = (constraintLevel == MIDLevel.INSTANCES) ?
			((Model) constraint.eContainer()).getMetatypeUri() :
			((Model) constraint.eContainer()).getUri();
		try {
			IJavaModelConstraint javaConstraint = (IJavaModelConstraint)
				MultiModelTypeRegistry.getTypeBundle(modelTypeUri).
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
	public boolean checkConstraintConsistency(@NonNull Model modelType, String constraint) {

		return true;
	}

	@Override
	public @Nullable Model refineByConstraint(@NonNull Model model) {

		return null;
	}

}
