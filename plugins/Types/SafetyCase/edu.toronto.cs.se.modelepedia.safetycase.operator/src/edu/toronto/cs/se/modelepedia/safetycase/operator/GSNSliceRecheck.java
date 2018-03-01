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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNSliceRecheck extends Slice {

	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

	    Set<EObject> impacted = new HashSet<>();
		// If input is a safety case, then the following are also impacted:
		// 1) Owned goals, strategies, solutions, contexts and ASILs.
		if (modelObj instanceof SafetyCase) {
			SafetyCase sc = (SafetyCase) modelObj;
			impacted.addAll(sc.getGoals());
			impacted.addAll(sc.getStrategies());
			impacted.addAll(sc.getSolutions());
			impacted.addAll(sc.getContexts());
			impacted.addAll(sc.getASILLevels());

		// If input is a core element (i.e. goal, strategy or solution), then the
		// SupportedBy relations that it supports are also impacted.
		} else if (modelObj instanceof CoreElement) {
			CoreElement c = (CoreElement) modelObj;
			impacted.addAll(c.getSupports());

		// If input is a contextual element, then its InContextOf relations
		// are also impacted.
		} else if (modelObj instanceof ContextualElement) {
			ContextualElement c = (ContextualElement) modelObj;
			impacted.addAll(c.getContextOf());

		// If input is a SupportedBy relation, then its conclusion is impacted.
		} else if (modelObj instanceof SupportedBy) {
			SupportedBy rel = (SupportedBy) modelObj;
			impacted.add(rel.getConclusion());

		// If input is a InContextOf relation, then the following are also impacted:
		// 1) The decomposable core element with this context.
		// 2) All contextual elements and core elements that inherit this context.
		} else if (modelObj instanceof InContextOf) {
			InContextOf rel = (InContextOf) modelObj;
			impacted.add(rel.getContextOf());
			impacted.addAll(getDescendants(rel.getContextOf()));
		}
		impacted.removeAll(alreadyImpacted);
		impacted.remove(null);

		return impacted;
	}

	// Returns all the descendants of the input decomposable core element
	// (including contextual elements).
	public Set<ArgumentElement> getDescendants(DecomposableCoreElement elem) {
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
