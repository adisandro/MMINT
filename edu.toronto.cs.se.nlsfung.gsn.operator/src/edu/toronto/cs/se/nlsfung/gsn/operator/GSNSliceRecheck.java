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
package edu.toronto.cs.se.nlsfung.gsn.operator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.operator.slice.Slice;
import edu.toronto.cs.se.nlsfung.gsn.ContextualElement;
import edu.toronto.cs.se.nlsfung.gsn.CoreElement;
import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

public class GSNSliceRecheck extends Slice {

	@Override
	// Get all model elements that are potentially impacted by the input set
	// (and therefore needs to be rechecked).
	public Set<EObject> getAllImpactedElements(Set<EObject> elemSet) {
		Set<EObject> impactedAll = new HashSet<>();
		Set<EObject> impactedCur = new HashSet<>();
		Set<EObject> impactedNext = new HashSet<>();
		
		// Iterate through the current set of newly added model elements 
		// to identify all others that may be potentially impacted. 
		impactedAll.addAll(elemSet);
		impactedCur.addAll(elemSet);
		while (!impactedCur.isEmpty()) {
			for (EObject elem : impactedCur) {
				// Get all model elements directly impacted by the current 
				// one in consideration and remove duplicates.
				for (EObject newElem : getDirectlyImpactedElements(elem)) {
					if (!impactedAll.contains(newElem)) {
						impactedAll.add(newElem);
						impactedNext.add(newElem);
					}
				}
			}
			
			// Prepare for next iteration.
			impactedCur.clear();
			impactedCur.addAll(impactedNext);
			impactedNext.clear();
		}
		
		return impactedAll;
	}
	
	// Get impacted model elements directly reachable from the input element.
	@Override
	public Set<EObject> getDirectlyImpactedElements(EObject elem) {
		Set<EObject> impacted = new HashSet<>();

		// The input element itself is always impacted.
		impacted.add(elem);

		// If input is a safety case, then the following are also impacted:
		// 1) Owned goals, strategies, solutions, contexts and ASILs.
		if (elem instanceof SafetyCase) {
			SafetyCase sc = (SafetyCase) elem;
			impacted.addAll(sc.getGoals());
			impacted.addAll(sc.getStrategies());
			impacted.addAll(sc.getSolutions());
			impacted.addAll(sc.getContexts());
			impacted.addAll(sc.getASILLevels());
			
		// If input is a core element (i.e. goal, strategy or solution), then the 
		// SupportedBy relations that it supports are also impacted.
		} else if (elem instanceof CoreElement) {
			CoreElement c = (CoreElement) elem;
			impacted.addAll(c.getSupports());
			
		// If input is a contextual element, then its InContextOf relations
		// are also impacted.
		} else if (elem instanceof ContextualElement) {
			ContextualElement c = (ContextualElement) elem;
			impacted.addAll(c.getContextOf());
		
		// If input is a SupportedBy relation, then its conclusion is impacted.	
		} else if (elem instanceof SupportedBy) {
			SupportedBy rel = (SupportedBy) elem;
			impacted.add(rel.getConclusion());
			
		// If input is a InContextOf relation, then the decomposable core 
		// elements with or inherit this context are also impacted.
		} else if (elem instanceof InContextOf) {
			InContextOf rel = (InContextOf) elem;
			impacted.addAll(getDescendants(rel.getContextOf()));
		}

		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}	
	
	// Adds all the descendants of the input decomposable core element (including 
	// itself and connecting relations) to the input result set.
	public Set<EObject> getDescendants(DecomposableCoreElement elem) {
		Set<EObject> descendantsAll = new HashSet<>();
		Set<EObject> descendantsCur = new HashSet<>();
		Set<EObject> descendantsNext = new HashSet<>();
		
		// Iterate through the current set of newly added descendants
		// to identify the next generation of descendants.
		descendantsAll.add(elem);
		descendantsCur.add(elem);
		while (!descendantsCur.isEmpty()) {
			for (EObject curElem : descendantsCur) {
				if (curElem instanceof DecomposableCoreElement) {
					DecomposableCoreElement d = (DecomposableCoreElement) curElem;
					descendantsNext.addAll(d.getSupportedBy());
				} else if (curElem instanceof SupportedBy) {
					SupportedBy s = (SupportedBy) curElem;
					descendantsNext.add(s.getPremise());
				}
			}
			
			descendantsCur.clear();
			for (EObject newElem : descendantsNext) {
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
