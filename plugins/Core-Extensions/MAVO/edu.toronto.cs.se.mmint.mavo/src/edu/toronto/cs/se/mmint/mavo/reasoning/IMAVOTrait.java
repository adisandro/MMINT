/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;

//TODO MMINT[MAVO] All the apis should really throw an exception with errors instead of returning null
public interface IMAVOTrait extends IReasoner {

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

		public static MAVOTruthValue toMAVOTruthValue(boolean constraintTruthValue, boolean notConstraintTruthValue) {
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

	//TODO MMINT[MAVO] Can this be extended to normal models, i.e. based on a false property make it satisfied?
  //TODO MMINT[MAVO] Should copy the model constraint to the new model? option to do it or not?
  @Nullable Model refineModelByConstraint(Model model);

	MAVOTruthValue checkMAVOModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel);

	@Nullable Model refineModelByMayAlternative(Model model, MAVOCollection mayAlternative);

	@Nullable Model refineModelByVarDomain(Model model, MAVOCollection varDomain, MAVOElement mergedModelObj, List<MAVOElement> varModelObjs);

	@Nullable Model refineModelByMayModelObjects(Model model, List<MAVOElement> mayModelObjs);

	void highlightMAVODecision(Diagram modelDiagram, MAVODecision mavoDecision);

	void highlightMAVOCollection(Diagram modelDiagram, MAVOCollection mavoCollection);

	void highlightMAVOElement(Diagram modelDiagram, MAVOElement mavoModelObj);
}
