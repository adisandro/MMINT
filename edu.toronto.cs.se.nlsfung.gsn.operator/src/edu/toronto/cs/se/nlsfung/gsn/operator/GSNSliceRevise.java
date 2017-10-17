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
import edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;
import edu.toronto.cs.se.nlsfung.gsn.Solution;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;

public class GSNSliceRevise extends Slice {
	
	@Override
	// Get all model elements in a safety case that needs to be re-checked 
	// given the input set of elements that needs to be revised.
	public Set<EObject> getAllImpactedElements(Set<EObject> elemSet) {
		Set<EObject> impactedAll = new HashSet<>();
		
		// Iterate through the input set of revised elements to identify 
		// all model elements that require re-checking.
		for (EObject elem : elemSet) {
			impactedAll.add(elem);
			impactedAll.addAll(getDirectlyImpactedElements(elem));
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
		// 1) Everything in the safety case.
		if (elem instanceof SafetyCase) {
			SafetyCase sc = (SafetyCase) elem;
			impacted.addAll(sc.getSolutions());
			impacted.addAll(sc.getContexts());
			impacted.addAll(sc.getASILLevels());
			
			Set<DecomposableCoreElement> decompElemSet = new HashSet<>();
			decompElemSet.addAll(sc.getGoals());
			decompElemSet.addAll(sc.getStrategies());
			
			impacted.addAll(decompElemSet);
			
			for (DecomposableCoreElement decompElem : decompElemSet) {
				impacted.addAll(decompElem.getInContextOf());
				impacted.addAll(decompElem.getSupportedBy());
			}
			
		// If input is a goal, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		// 2) All model elements supporting or supported by the input goal.
		} else if (elem instanceof Goal) {
			Goal g = (Goal) elem;
			
			for (SupportedBy rel : g.getSupportedBy()) {
				impacted.add(rel);
				impacted.add(rel.getPremise());
			}
			
			for (SupportedBy rel : g.getSupports()) {
				impacted.add(rel);
				impacted.add(rel.getConclusion());
			}
		
		// If input is a strategy, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		// 2) All model elements supporting or supported by the input strategy.
		} else if (elem instanceof Strategy) {
			Strategy s = (Strategy) elem;
			
			for (SupportedBy rel : s.getSupportedBy()) {
				impacted.add(rel);
				impacted.add(rel.getPremise());
			}
			
			for (SupportedBy rel : s.getSupports()) {
				impacted.add(rel);
				impacted.add(rel.getConclusion());
			}
			
		// If input is a contextual element (Context or ASIL), 
		// then the following are also impacted:
		// 1) All InContextOf relations connected to it.
		// 2) All model elements that introduce C as the context.
		// 3) All model elements that inherit C as the context 
		//    (and connecting relations).
		} else if (elem instanceof ContextualElement) {
			ContextualElement c = (ContextualElement) elem;
			Set<InContextOf> impactedRelSet = new HashSet<>();
			impactedRelSet.addAll(c.getContextOf());
			
			impacted.addAll(impactedRelSet);
			for (InContextOf rel : impactedRelSet) {
				impacted.addAll(getDescendants(rel.getContextOf()));
			}
			
		// If input is a solution, then the following are also impacted:
		// 1) All SupportedBy relations connected to it.
		// 2) All goals connected to the solution via the sliced relations.
		} else if (elem instanceof Solution) {
			Solution s = (Solution) elem;
			Set<SupportedBy> impactedRelSet = new HashSet<>();
			impactedRelSet.addAll(s.getSupports());
			
			impacted.addAll(impactedRelSet);
			for (SupportedBy rel : impactedRelSet) {
				impacted.add(rel.getConclusion());
				impacted.add(rel.getPremise());
			}
			
		// If input is a SupportedBy relation, then its source and 
		// target model element is potentially impacted.
		} else if (elem instanceof SupportedBy) {
			SupportedBy rel = (SupportedBy) elem;
			impacted.add(rel.getConclusion());
			impacted.add(rel.getPremise());
			
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