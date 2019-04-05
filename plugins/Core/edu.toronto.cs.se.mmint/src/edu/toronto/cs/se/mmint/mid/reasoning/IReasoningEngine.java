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
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public interface IReasoningEngine {

	public default boolean checkModelConstraint(@NonNull Model model, @NonNull ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		return true;
	}

	public default boolean checkOperatorGenericConstraint(@NonNull ExtendibleElementConstraint constraint, @NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

		return true;
	}

	public default boolean checkOperatorInputConstraint(@NonNull ExtendibleElementConstraint constraint, @NonNull Map<String, Model> inputsByName) {

		return true;
	}

	public default @NonNull Map<ModelRel, List<Model>> getOperatorOutputConstraints(@NonNull ExtendibleElementConstraint constraint, @NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

		return new HashMap<>();
	}

	public default boolean checkModelConstraintConsistency(@NonNull Model modelType, String constraint) {

		return true;
	}

	//TODO MMINT[REFINE] Is this really for all models? == Can I refine a model based on a false property, to make it true?
	public default @Nullable Model refineModelByConstraint(@NonNull Model model) {

		return null;
	}

  public default @Nullable Object evaluateQuery(@NonNull EObject context, @NonNull String queryFilePath) {
    return null;
  }

}
