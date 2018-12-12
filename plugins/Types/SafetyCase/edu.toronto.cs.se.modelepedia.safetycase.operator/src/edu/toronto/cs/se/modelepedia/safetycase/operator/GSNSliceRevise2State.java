/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRevise2State extends GSNSliceRevise {

	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

	    Set<EObject> impacted = new HashSet<>();

		// If input is a strategy, then the state validity should be rechecked for:
		// 1) All ancestor goals.
		if (modelObj instanceof Strategy) {
			Strategy s = (Strategy) modelObj;

			for (Goal g : getAncestorGoals(s)) {
				impacted.add(g);
			}
		}

		impacted.removeAll(alreadyImpacted);

		return impacted;
	}

	// Returns all ancestor goals of the input strategy.
	public Set<Goal> getAncestorGoals(Strategy elem) {
		Set<DecomposableCoreElement> ancestorsAll = new HashSet<>();
		Set<DecomposableCoreElement> ancestorsCur = new HashSet<>();
		Set<DecomposableCoreElement> ancestorsNext = new HashSet<>();

		// Iterate through the current set of newly added ancestors
		// to identify the next generation of ancestors.
		for (SupportedBy rel : elem.getSupports()) {
			ancestorsNext.add(rel.getConclusion());
		}

		ancestorsAll.addAll(ancestorsNext);
		ancestorsCur.addAll(ancestorsNext);
		ancestorsNext.clear();

		while (!ancestorsCur.isEmpty()) {
			for (DecomposableCoreElement curElem : ancestorsCur) {
				for (SupportedBy rel : curElem.getSupports()) {
					ancestorsNext.add(rel.getConclusion());
				}
			}

			ancestorsCur.clear();
			for (DecomposableCoreElement newElem : ancestorsNext) {
				if (!ancestorsAll.contains(newElem)) {
					ancestorsAll.add(newElem);
					ancestorsCur.add(newElem);
				}
			}

			ancestorsNext.clear();
		}

		// Return the ancestors that are goals.
		Set<Goal> goalAncestors = new HashSet<>();
		for (DecomposableCoreElement newElem : ancestorsAll) {
			if (newElem instanceof Goal) {
				goalAncestors.add((Goal) newElem);
			}
		}

		return goalAncestors;
	}
}
