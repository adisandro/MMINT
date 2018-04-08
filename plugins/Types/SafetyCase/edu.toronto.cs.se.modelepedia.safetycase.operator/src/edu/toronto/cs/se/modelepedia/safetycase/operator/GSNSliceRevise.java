/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.ASIL;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRevise extends Slice {

	// Get all model elements in a safety case that needs to be re-checked
	// given the input element that needs to be revised.
    @Override
	protected Map<EObject, Set<EObject>> getAllImpactedElements(EObject critModelObj, Set<EObject> alreadyImpacted) {

        Map<EObject, Set<EObject>> impacted = new HashMap<>();
        alreadyImpacted.add(critModelObj);

		// Iterate through the input set of revised elements to identify
		// all model elements that require re-checking.
        Set<EObject> impactedModelObjs = getDirectlyImpactedElements(critModelObj, alreadyImpacted);
        alreadyImpacted.addAll(impactedModelObjs);
        impactedModelObjs.add(critModelObj);
        impacted.put(critModelObj, impactedModelObjs);

		return impacted;
	}

	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

	    Set<EObject> impacted = new HashSet<>();
		// If input is a safety case, then the following are also impacted:
		// 1) Its goals, strategies, solutions, ASILs and contexts.
		if (modelObj instanceof SafetyCase) {
			SafetyCase sc = (SafetyCase) modelObj;
			impacted.addAll(sc.getGoals());
			impacted.addAll(sc.getStrategies());
			impacted.addAll(sc.getSolutions());
			impacted.addAll(sc.getContexts());
			impacted.addAll(sc.getASILLevels());

		// If input is a goal, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		} else if (modelObj instanceof Goal) {
			Goal g = (Goal) modelObj;
			impacted.addAll(g.getSupportedBy());
			impacted.addAll(g.getSupports());

		// If input is a strategy, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		} else if (modelObj instanceof Strategy) {
			Strategy s = (Strategy) modelObj;
			impacted.addAll(s.getSupportedBy());
			impacted.addAll(s.getSupports());

		// If input is a solution, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		} else if (modelObj instanceof Solution) {
			Solution s = (Solution) modelObj;
			impacted.addAll(s.getSupports());

		// If input is a context, then the following are also impacted:
		// 1) All InContextOf relations connected to it.
		} else if (modelObj instanceof Context) {
			Context c = (Context) modelObj;
			impacted.addAll(c.getContextOf());

		// If input is an ASIL, then the following are also impacted:
		// 1) All InContextOf relations connected to it.
		} else if (modelObj instanceof ASIL) {
			ASIL a = (ASIL) modelObj;
			impacted.addAll(a.getContextOf());

		// If input is a SupportedBy relation, then its source and
		// target model element is potentially impacted.
		} else if (modelObj instanceof SupportedBy) {
			SupportedBy rel = (SupportedBy) modelObj;
			if (rel.getConclusion() != null) {
				impacted.add(rel.getConclusion());
			}

			if (rel.getPremise() != null) {
				impacted.add(rel.getPremise());
			}

		// If input is a InContextOf relation, then its source and
		// target model element is potentially impacted.
		} else if (modelObj instanceof InContextOf) {
			InContextOf rel = (InContextOf) modelObj;
			if (rel.getContext() != null) {
				impacted.add(rel.getContext());
			}

			if (rel.getContextOf() != null) {
				impacted.add(rel.getContextOf());
			}
		}

		impacted.removeAll(alreadyImpacted);

		return impacted;
	}
}
