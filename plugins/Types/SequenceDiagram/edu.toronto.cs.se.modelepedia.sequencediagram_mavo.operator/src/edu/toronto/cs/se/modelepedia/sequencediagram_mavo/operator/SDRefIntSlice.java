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
package edu.toronto.cs.se.modelepedia.sequencediagram_mavo.operator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;
import edu.toronto.cs.se.modelepedia.operator.slice.RefIntSlice;

public class SDRefIntSlice extends RefIntSlice {

	@Override
	// Get all model elements that are potentially impacted by the input set.
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
		
		// If input is a message, then the following are impacted:
		// 1) References to all associated operations.
		// 2) References to all associated attributes
		if (elem instanceof Message) {
			Message m = (Message) elem;
			impacted.addAll(m.getOperation());
			impacted.addAll(m.getAttributes());
			
		// If input is an attribute reference, then its message and
		// attribute are impacted.
		} else if (elem instanceof AttributeReference) {
			AttributeReference r = (AttributeReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());

		// If input is an operation reference, then its message and 
		// operation are impacted.
		} else if (elem instanceof OperationReference) {
			OperationReference r = (OperationReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());
		}


		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}	
}
