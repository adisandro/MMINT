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
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public interface IReasoningEngine {

	public boolean checkModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel);

	public boolean checkOperatorInputConstraint(@NonNull Map<String, Model> inputsByName, @NonNull ExtendibleElementConstraint constraint);

	public Map<ModelRel, List<Model>> getOperatorOutputConstraints(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName, @NonNull ExtendibleElementConstraint constraint);

	public boolean checkModelConstraintConsistency(@NonNull Model modelType, String constraint);

	//TODO MMINT[REFINE] Is this really for all models? == Can I refine a model based on a false property, to make it true?
	public @Nullable Model refineModelByConstraint(@NonNull Model model);

}
