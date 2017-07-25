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
import edu.toronto.cs.se.modelepedia.operator.slice.Slice;

public class SDSlice extends Slice {

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

		// If input is a sequence diagram, then the following are impacted:
		// 1) Owned classes, lifelines and messages.
		if (elem instanceof SequenceDiagram) {
			SequenceDiagram d = (SequenceDiagram) elem;
			impacted.addAll(d.getClasses());
			impacted.addAll(d.getLifelines());
			impacted.addAll(d.getMessages());

		// If input is a class, then the following are impacted:
		// 1) Owned attributes and operations.
		// 2) References to the input.
		} else if (elem instanceof Class) {
			Class c = (Class) elem;
			impacted.addAll(c.getOperations());
			impacted.addAll(c.getAttributes());
			impacted.addAll(c.getLifelines());

		// If input is a lifeline, then the following are impacted:
		// 1) Owned class references.
		// 2) References to the input.
		// 3) Owned activation boxes.
		} else if (elem instanceof Lifeline) {
			Lifeline l = (Lifeline) elem;
			impacted.addAll(l.getClass_());
			impacted.addAll(l.getMessagesAsSource());
			impacted.addAll(l.getMessagesAsTarget());
			impacted.addAll(l.getActivationBoxes());

		// If input is a message, then the following are impacted:
		// 1) The activation box references relating to the subsequent
		//    messages (if any) that are connected to the input's boxes.
		} else if (elem instanceof Message) {
			Message m = (Message) elem;

			ActivationBoxReference srcRef;
			ActivationBox srcBox;
			List<ActivationBoxReference> srcMessages;
			int srcIndex;
			
			srcRef = m.getSourceActivationBox();
			if (srcRef != null) {
				srcBox = srcRef.getTarget();
				if (srcBox != null) {
					srcMessages = srcBox.getMessages();
					if (srcMessages != null) {
						srcIndex = srcMessages.indexOf(srcRef);
						if (srcIndex > -1 && srcIndex < srcMessages.size()-1) {
							impacted.add(srcMessages.get(srcIndex + 1));
						}
					}
				}
			}
			
			ActivationBoxReference tarRef;
			ActivationBox tarBox;
			List<ActivationBoxReference> tarMessages;
			int tarIndex;
			
			tarRef = m.getTargetActivationBox();
			if (tarRef != null) {
				tarBox = tarRef.getTarget();
				if (tarBox != null) {
					tarMessages = tarBox.getMessages();
					if (tarMessages != null) {
						tarIndex = tarMessages.indexOf(tarRef);
						if (tarIndex > -1 && tarIndex < tarMessages.size()-1) {
							impacted.add(tarMessages.get(tarIndex + 1));
						}
					}
				}
			}

		// If input is an attribute, then its references are impacted.
		} else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
			impacted.addAll(a.getMessages());

		// If input is an operation, then its references are impacted.
		} else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
			impacted.addAll(o.getMessages());
		
		// If input is an activation box, then its references are impacted.
		} else if (elem instanceof ActivationBox) {
			ActivationBox a = (ActivationBox) elem;
			impacted.addAll(a.getMessages());

		// If input is a class reference, then its lifeline is impacted.
		} else if (elem instanceof ClassReference) {
			ClassReference r = (ClassReference) elem;
			impacted.add(r.getSource());

		// If input is a source lifeline reference, then its message is impacted.
		} else if (elem instanceof SourceLifelineReference) {
			SourceLifelineReference r = (SourceLifelineReference) elem;
			impacted.add(r.getSource());

		// If input is a target lifeline reference, then its message is impacted.
		} else if (elem instanceof TargetLifelineReference) {
			TargetLifelineReference r = (TargetLifelineReference) elem;
			impacted.add(r.getSource());

		// If input is an activation box reference, then its message is impacted.
		} else if (elem instanceof ActivationBoxReference) {
			ActivationBoxReference r = (ActivationBoxReference) elem;
			impacted.add(r.getSource());

		// If input is an attribute reference, then its message is impacted.
		} else if (elem instanceof AttributeReference) {
			AttributeReference r = (AttributeReference) elem;
			impacted.add(r.getSource());

		// If input is an operation reference, then its message is impacted.
		} else if (elem instanceof OperationReference) {
			OperationReference r = (OperationReference) elem;
			impacted.add(r.getSource());
		}

		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}	
}
