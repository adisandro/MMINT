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
package edu.toronto.cs.se.mmint.mavo.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;

public class MAVOMIDConstraintChecker {

  /** TODO
   *  1) Finish refactoring operator constraints
   *  2) Address remaining apis in IReasoningEngine and get rid of it together with the methods below (remove consistency, review refinement)
   *  3) Address mavo and kleisli reasoner apis too.
   *  X) AbstractReasoner as superclass + change all methods to not return simply Object? (id in ext point + abstract getName in class + getReasoner utility)
   */
	public static @NonNull IMAVOTrait getMAVOReasoner(@NonNull String constraintLanguage) throws MMINTException {

		//TODO MMINT[MAVO] Register reasoners as mavo reasoner
    var reasoner = MMINT.getReasoner(constraintLanguage);
    if (reasoner == null) {
      throw new MMINTException("Can't find a reasoner for language " + constraintLanguage);
    }
    return (IMAVOTrait) reasoner;
	}

	public static @NonNull MAVOTruthValue checkMAVOModelConstraint(@NonNull Model model, @Nullable ExtendibleElementConstraint constraint) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return MAVOTruthValue.TRUE;
		}
		IMAVOTrait reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner(constraint.getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping MAVO constraint check", e);
			return MAVOTruthValue.FALSE;
		}
		MIDLevel constraintLevel;
		if (!model.getUri().equals(((ExtendibleElement) constraint.eContainer()).getUri())) {
			constraintLevel = MIDLevel.TYPES;
		}
		else {
			constraintLevel = MIDLevel.INSTANCES;
		}

		return reasoner.checkMAVOModelConstraint(model, constraint, constraintLevel);
	}
}
