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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOReasoningEngine;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOReasoningEngine.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;

public class MAVOMIDConstraintChecker {

	public static @NonNull IMAVOReasoningEngine getMAVOReasoner(@NonNull String constraintLanguage) throws MMINTException {

		//TODO MMINT[MAVO] Register reasoners as mavo reasoner
		return (IMAVOReasoningEngine) MIDConstraintChecker.getReasoner(constraintLanguage);
	}

	public static @NonNull MAVOTruthValue checkMAVOModelConstraint(@NonNull Model model, @Nullable ExtendibleElementConstraint constraint) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return MAVOTruthValue.TRUE;
		}
		IMAVOReasoningEngine reasoner;
		try {
			reasoner = getMAVOReasoner(constraint.getLanguage());
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

	//TODO MMINT[REFINE] Should really throw an exception with errors instead of returning null
	public static @Nullable Model refineModelByMayAlternative(@NonNull Model model, @NonNull MAVOCollection mayAlternative) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping refinement based on may alternative", e);
			return null;
		}

		return reasoner.refineModelByMayAlternative(model, mayAlternative);
	}

	//TODO MMINT[REFINE] Should really throw an exception with errors instead of returning null
	public static @Nullable Model refineModelByVarDomain(@NonNull Model model, @NonNull MAVOCollection varDomain, @NonNull MAVOElement mergedModelObj, @NonNull List<MAVOElement> varModelObjs) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping refinement based on var domain", e);
			return null;
		}

		return reasoner.refineModelByVarDomain(model, varDomain, mergedModelObj, varModelObjs);
	}

	//TODO MMINT[REFINE] Should really throw an exception with errors instead of returning null
	public static @Nullable Model refineModelByMayModelObjects(@NonNull Model model, @NonNull List<MAVOElement> mayModelObjs) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping refinement based on may model object", e);
			return null;
		}

		return reasoner.refineModelByMayModelObjects(model, mayModelObjs);
	}

	public static void highlightMAVODecision(@NonNull Diagram modelDiagram, @NonNull MAVODecision mavoDecision) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping MAVO decision highlighting", e);
			return;
		}

		reasoner.highlightMAVODecision(modelDiagram, mavoDecision);
	}

	public static void highlightMAVOCollection(@NonNull Diagram modelDiagram, @NonNull MAVOCollection mavoCollection) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping MAVO collection highlighting", e);
			return;
		}

		reasoner.highlightMAVOCollection(modelDiagram, mavoCollection);
	}

	public static void highlightMAVOElement(@NonNull Diagram modelDiagram, @NonNull MAVOElement mavoModelObj) {

		IMAVOReasoningEngine reasoner;
		try {
			reasoner = MAVOMIDConstraintChecker.getMAVOReasoner("smt");
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping MAVO element highlighting", e);
			return;
		}

		reasoner.highlightMAVOElement(modelDiagram, mavoModelObj);
	}

}
