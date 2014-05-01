/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.reasoning;

import java.util.Set;

import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;

public interface ReasoningEngine {

	/*TODO:
	 * 1) Define interface to check constraint
	 * 2) Define extension point to plug in reasoners
	 * 3) Read extension point in MMINT and instantiate reasoners
	 * 4) Dispatch to the appropriate reasoner in MultiModelConstraintChecker.checkConstraint()
	 * 5) Remove ExtendibleElementConstraintLanguage enum and use engine id
	 * 6) Isolate all reasoners (OCL, JAVA, SMTLIB, EMFtoCSP) in their own projects
	 */
	public MAVOTruthValue checkConstraint(Model model, String constraint, MidLevel constraintLevel);

	public boolean checkConstraintConsistency(Model modelType, String constraint);

	public Set<String> getEngineLanguages();

}
