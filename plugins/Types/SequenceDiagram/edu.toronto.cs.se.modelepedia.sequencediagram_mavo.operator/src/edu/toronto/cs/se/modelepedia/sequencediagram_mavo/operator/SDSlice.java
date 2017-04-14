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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;
import edu.toronto.cs.se.modelepedia.operator.slice.Slice;

public class SDSlice extends Slice {

	private static final java.lang.Class<Lifeline> LIFELINE = Lifeline.class;
	private static final java.lang.Class<Class> CLASS = Class.class;
	private static final java.lang.Class<Attribute> ATTRIBUTE = Attribute.class;
	private static final java.lang.Class<Operation> OPERATION = Operation.class;
	private static final java.lang.Class<Message> MESSAGE = Message.class;

	// Checks whether the first input model element is potentially
	// impacted by the second second input model element.
	// Note: It is assumed that if the two input elements are equivalent,
	// then the function should return true.
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {
		if (elem instanceof Lifeline) {
			// If obj2 is a lifeline, then obj1 is potentially impacted if it
			// is a message connected to obj2.
			Lifeline l = (Lifeline) elem;
			for (SourceLifelineReference srcRef : l.getMessagesAsSource()) {
				EObject impactedElem = srcRef.getSource();
				if (impacted.contains(impactedElem)) {
					continue;
				}
				impacted.add(impactedElem);
				addImpactedModelElems(impactedElem, impacted);
			}
			for (TargetLifelineReference tarRef : l.getMessagesAsTarget()) {
				EObject impactedElem = tarRef.getSource();
				if (impacted.contains(impactedElem)) {
					continue;
				}
				impacted.add(impactedElem);
				addImpactedModelElems(impactedElem, impacted);
			}
		} else if (elem instanceof Class) {
			// It is assumed that if obj2 is a class, then obj1 is potentially
			// impacted only if it is equivalent to obj2.
		} else if (elem instanceof Attribute) {
			// If obj2 is an attribute, then obj1 is potentially impacted if
			// obj1 is a message that refers to obj2.
			Attribute a = (Attribute) elem;
			for (AttributeReference aRef : a.getMessages()) {
				EObject impactedElem = aRef.getSource();
				if (impacted.contains(impactedElem)) {
					continue;
				}
				impacted.add(impactedElem);
				addImpactedModelElems(impactedElem, impacted);
			}
		} else if (elem instanceof Operation) {
			// If obj2 is an operation, then obj1 is potentially impacted if
			// obj1 is a message that refers to obj2.
			Operation o = (Operation) elem;
			for (OperationReference oRef : o.getMessages()) {
				EObject impactedElem = oRef.getSource();
				if (impacted.contains(impactedElem)) {
					continue;
				}
				impacted.add(impactedElem);
				addImpactedModelElems(impactedElem, impacted);
			}
		} else if (elem instanceof Message) {
			// If obj2 is a message, then obj1 is potentially impacted
			// only if it is equivalent to obj2.
		}
	}

}
