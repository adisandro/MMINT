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

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ActivationBox;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ActivationBoxReference;
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
import edu.toronto.cs.se.modelepedia.operator.slice.WellFormedSlice;

public class SDWellFormedSlice extends WellFormedSlice {

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

		// If input is a sequence diagram, then nothing else is impacted.
		if (elem instanceof SequenceDiagram) {

		// If input is a class, then the sequence diagram is also impacted.
		} else if (elem instanceof Class) {
			Class c = (Class) elem;
			impacted.add(c.eContainer());

		// If input is a lifeline, then the sequence diagram is impacted
		// as well as its first class reference.
		} else if (elem instanceof Lifeline) {
			Lifeline l = (Lifeline) elem;
			impacted.add(l.eContainer());
			
			List<ClassReference> clsList = l.getClass_();
			if (clsList != null) {
				if (!clsList.isEmpty()) {
					impacted.add(clsList.get(0));
				}
			}

		// If input is a message, then the following are impacted:
		// 1) Reference to the first target lifeline (if one exists).
		// 2) Reference to the first source lifeline (if one exists).
		// 3) Reference to the first operation involved (if one exists).
		} else if (elem instanceof Message) {
			Message m = (Message) elem;
			impacted.add(m.eContainer());
			
			List<TargetLifelineReference> tarLine = m.getTargetLifeline();
			if (tarLine != null) {
				if (!tarLine.isEmpty()) {
					impacted.add(tarLine.get(0));
				}
			}
			
			List<SourceLifelineReference> srcLine = m.getSourceLifeline();
			if (srcLine != null) {
				if (!srcLine.isEmpty()) {
					impacted.add(srcLine.get(0));
				}
			}
			
			List<OperationReference> op = m.getOperation();
			if (op != null) {
				if (!op.isEmpty()) {
					impacted.add(op.get(0));
				}
			}

		// If input is an attribute, then its class is impacted.
		} else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
			impacted.add(a.eContainer());

		// If input is an operation, then its class is impacted.
		} else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
			impacted.add(o.eContainer());
		
		// If input is an activation box, then its lifeline is impacted.
		} else if (elem instanceof ActivationBox) {
			ActivationBox a = (ActivationBox) elem;
			impacted.add(a.eContainer());

		// If input is a class reference, then its lifeline and 
		// target class are impacted.
		} else if (elem instanceof ClassReference) {
			ClassReference r = (ClassReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());

		// If input is a source lifeline reference, then its message and 
		// lifeline are impacted.
		} else if (elem instanceof SourceLifelineReference) {
			SourceLifelineReference r = (SourceLifelineReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());

		// If input is a target lifeline reference, then its message and 
		// lifeline are  impacted.
		} else if (elem instanceof TargetLifelineReference) {
			TargetLifelineReference r = (TargetLifelineReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());

		// If input is an activation box reference, then its message and
		// activation box are impacted.
		} else if (elem instanceof ActivationBoxReference) {
			ActivationBoxReference r = (ActivationBoxReference) elem;
			impacted.add(r.getSource());
			impacted.add(r.getTarget());

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
		}

		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}	
}
