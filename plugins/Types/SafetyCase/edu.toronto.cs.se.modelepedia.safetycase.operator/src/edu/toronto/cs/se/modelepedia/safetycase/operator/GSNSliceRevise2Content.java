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

public class GSNSliceRevise2Content extends Slice {

	// Get all model elements in a safety case that needs to be re-checked for content
	// validity given the input element that contains contents requiring revision.
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

		// If input is a goal, then the content validity should be rechecked for:
		// 1) Any parent argument element
		// 2) Any child argument element
		if (modelObj instanceof Goal) {
			Goal g = (Goal) modelObj;
			
			for (SupportedBy rel : g.getSupports()) {
				impacted.add(rel.getConclusion());
			}
			
			for (SupportedBy rel : g.getSupportedBy()) {
				impacted.add(rel.getPremise());
			}

		// If input is a strategy, then the content validity should be rechecked for:
		// 2) Any child argument element.
		// 3) Any contexts and justifications connected to it.
		} else if (modelObj instanceof Strategy) {
			Strategy s = (Strategy) modelObj;
			
			for (SupportedBy rel : s.getSupportedBy()) {
				impacted.add(rel.getPremise());
			}
			
			for (InContextOf rel : s.getInContextOf()) {
				impacted.add(rel.getContext());
			}

		// If input is a solution, then the content validity should be rechecked for:
		// 1) Any parent argument element.
		} else if (modelObj instanceof Solution) {
			Solution s = (Solution) modelObj;
			
			for (SupportedBy rel : s.getSupports()) {
				impacted.add(rel.getConclusion());
			}
			
		// If input is a context, then the content validity should be rechecked for:
		// 1) All argument elements that uses or inherits input context.
		} else if (modelObj instanceof Context) {
			Context c = (Context) modelObj;
			
			for (InContextOf rel : c.getContextOf()) {
				for (ArgumentElement elem : getDescendantElements(rel.getContextOf())) {
					impacted.add(elem);
				}
			}
		
		// If input is a justification, then nothing else requires rechecking.
		} else if (modelObj instanceof Justification) {

		}

		impacted.removeAll(alreadyImpacted);

		return impacted;
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
