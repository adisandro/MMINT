/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.reasoning;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;

public interface IMAVOReasoningEngine extends IReasoningEngine {

	public enum MAVOTruthValue {

		// tri-state MAVO logic
		TRUE, FALSE, MAYBE, ERROR;

		public boolean toBoolean() {

			switch (this) {
				case TRUE:
				case MAYBE:
					return true;
				case FALSE:
				case ERROR:
				default:
					return false;
			}
		}

		public static MAVOTruthValue toMAVOTruthValue(boolean truthValue) {

			return (truthValue) ? TRUE : FALSE;
		}

		public static @NonNull MAVOTruthValue toMAVOTruthValue(boolean constraintTruthValue, boolean notConstraintTruthValue) {
	
			if (constraintTruthValue == true && notConstraintTruthValue == false) {
				return TRUE;
			}
			if (constraintTruthValue == false && notConstraintTruthValue == true) {
				return FALSE;
			}
			if (constraintTruthValue == true && notConstraintTruthValue == true) {
				return MAYBE;
			}
			return ERROR;
		}
	}

	public @NonNull MAVOTruthValue checkMAVOModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel);

	public @Nullable Model refineModelByMayAlternative(@NonNull Model model, @NonNull MAVOCollection mayAlternative);

	public @Nullable Model refineModelByVarDomain(@NonNull Model model, @NonNull MAVOCollection varDomain, @NonNull MAVOElement mergedModelObj, @NonNull List<MAVOElement> varModelObjs);

	public @Nullable Model refineModelByMayModelObjects(@NonNull Model model, @NonNull List<MAVOElement> mayModelObjs);

	public void highlightMAVODecision(@NonNull Diagram modelDiagram, @NonNull MAVODecision mavoDecision);

	public void highlightMAVOCollection(@NonNull Diagram modelDiagram, @NonNull MAVOCollection mavoCollection);

	public void highlightMAVOElement(@NonNull Diagram modelDiagram, @NonNull MAVOElement mavoModelObj);

}
