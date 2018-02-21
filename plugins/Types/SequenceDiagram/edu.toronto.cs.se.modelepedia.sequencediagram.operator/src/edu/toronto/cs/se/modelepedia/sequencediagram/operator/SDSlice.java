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
package edu.toronto.cs.se.modelepedia.sequencediagram.operator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
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

public class SDSlice extends Slice {

	// Get impacted model elements directly reachable from the input element.
	@Override
	public Set<EObject> getDirectlyImpactedElements(EObject elem, Set<EObject> alreadyImpacted) {
		Set<EObject> impacted = new HashSet<>();

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

		// If input is a message, then the following are impacted:
		// 1) Its target and source lifeline references.
		// 2) Its operation and attribute references.
		} else if (elem instanceof Message) {
			Message m = (Message) elem;
			impacted.addAll(m.getSourceLifeline());
			impacted.addAll(m.getTargetLifeline());
			impacted.addAll(m.getOperation());
			impacted.addAll(m.getAttributes());

		// If input is an attribute, then its references are impacted.
		} else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
			impacted.addAll(a.getMessages());

		// If input is an operation, then its references are impacted.
		} else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
			impacted.addAll(o.getMessages());
		
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

		// If input is an attribute reference, then its message is impacted.
		} else if (elem instanceof AttributeReference) {
			AttributeReference r = (AttributeReference) elem;
			impacted.add(r.getSource());

		// If input is an operation reference, then its message is impacted.
		} else if (elem instanceof OperationReference) {
			OperationReference r = (OperationReference) elem;
			impacted.add(r.getSource());
		}
		
		return impacted;
	}	
}

