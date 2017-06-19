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

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;

public class SDSlice extends Slice {

    // Adds impacted model elements reachable from a single model element
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

	    if (elem instanceof Lifeline) {
			Lifeline l = (Lifeline) elem;
            // Impacted:
            // 1) connected messages
			for (SourceLifelineReference srcRef : l.getMessagesAsSource()) {
				Message m = srcRef.getSource();
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				addImpactedModelElems(m, impacted);
			}
			for (TargetLifelineReference tgtRef : l.getMessagesAsTarget()) {
			    Message m = tgtRef.getSource();
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				addImpactedModelElems(m, impacted);
			}
		}
	    else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
            // Impacted:
            // 1) messages that refer to a
			for (AttributeReference aRef : a.getMessages()) {
				Message m = aRef.getSource();
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				addImpactedModelElems(m, impacted);
			}
		}
	    else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
            // Impacted:
            // 1) messages that refer to o
			for (OperationReference oRef : o.getMessages()) {
				Message m = oRef.getSource();
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				addImpactedModelElems(m, impacted);
			}
		}
        else if (elem instanceof Class) {
            // no impacted elements
        }
		else if (elem instanceof Message) {
            // no impacted elements
		}
	}

}
