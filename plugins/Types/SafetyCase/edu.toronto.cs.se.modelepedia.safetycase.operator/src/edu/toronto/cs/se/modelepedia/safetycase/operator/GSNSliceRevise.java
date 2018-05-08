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
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRevise extends Slice {

	// Get all model elements in a safety case that needs to be re-checked
	// given the input element that contains contents requiring revision.
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
	    EObject modelParent = modelObj.eContainer();

		// If input is a goal, then the following should be rechecked:
		// 1) The content validity of any parent argument element
		// 2) The content validity of any child argument element
		// 3) The state validity of the input goal.
		if (modelParent instanceof Goal) {
			Goal g = (Goal) modelParent;
			
			for (SupportedBy rel : g.getSupports()) {
				impacted.add(rel.getConclusion().getContentValidity());
			}
			
			for (SupportedBy rel : g.getSupportedBy()) {
				impacted.add(rel.getPremise().getContentValidity());
			}
			
			impacted.add(g.getStateValidity());

		// If input is a strategy, then the following should be rechecked:
		// 1) The state validity of all ancestor goals.
		// 2) The content validity of any child argument element.
		// 3) The content validity of any contexts and justifications connected to it.
		} else if (modelParent instanceof Strategy) {
			Strategy s = (Strategy) modelParent;
			
			for (Goal g : getAncestorGoals(s)) {
				impacted.add(g.getStateValidity());
			}
			
			for (SupportedBy rel : s.getSupportedBy()) {
				impacted.add(rel.getPremise().getContentValidity());
			}
			
			for (InContextOf rel : s.getInContextOf()) {
				impacted.add(rel.getContext().getContentValidity());
			}

		// If input is a solution, then the following should be rechecked:
		// 1) The content validity of any parent argument element.
		// 2) The state validity of the input solution
		} else if (modelParent instanceof Solution) {
			Solution s = (Solution) modelParent;
			
			for (SupportedBy rel : s.getSupports()) {
				impacted.add(rel.getConclusion().getContentValidity());
			}
			
			impacted.add(s.getStateValidity());
			
		// If input is a context, then the following should be rechecked:
		// 1) The content validity of all argument elements that uses or inherits input context.
		} else if (modelParent instanceof Context) {
			Context c = (Context) modelParent;
			
			for (InContextOf rel : c.getContextOf()) {
				for (ArgumentElement elem : getDescendantElements(rel.getContextOf())) {
					impacted.add(elem.getContentValidity());
				}
			}
		
		// If input is a justification, then nothing else requires rechecking.
		} else if (modelParent instanceof Justification) {

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
	
	// Returns all the descendants of the input decomposable core element
	// (including contextual elements).
	public Set<ArgumentElement> getDescendantElements(DecomposableCoreElement elem) {
		Set<ArgumentElement> descendantsAll = new HashSet<>();
		Set<ArgumentElement> descendantsCur = new HashSet<>();
		Set<ArgumentElement> descendantsNext = new HashSet<>();

		// Iterate through the current set of newly added descendants
		// to identify the next generation of descendants.
		descendantsAll.add(elem);
		descendantsCur.add(elem);
		while (!descendantsCur.isEmpty()) {
			for (ArgumentElement curElem : descendantsCur) {
				if (curElem instanceof DecomposableCoreElement) {
					DecomposableCoreElement d = (DecomposableCoreElement) curElem;
					if (d.getSupportedBy() != null) {
						for (SupportedBy rel : d.getSupportedBy()) {
							descendantsNext.add(rel.getPremise());
						}
					}

					if (d.getInContextOf() != null) {
						for (InContextOf rel: d.getInContextOf()) {
							descendantsNext.add(rel.getContext());
						}
					}
				}
			}

			descendantsCur.clear();
			for (ArgumentElement newElem : descendantsNext) {
				if (!descendantsAll.contains(newElem)) {
					descendantsAll.add(newElem);
					descendantsCur.add(newElem);
				}
			}

			descendantsNext.clear();
		}

		return descendantsAll;
	}
}
