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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;

public class SDSlice extends Slice {

    // Adds impacted model elements reachable from a single model element
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

	    if (elem instanceof Lifeline) {
			Lifeline l = (Lifeline) elem;
            // Impacted:
            // 1) connected messages
			for (Message m : l.getMessagesAsSource()) {
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				this.addImpactedModelElems(m, impacted);
			}
			for (Message m : l.getMessagesAsTarget()) {
				if (impacted.contains(m)) {
					continue;
				}
				impacted.add(m);
				this.addImpactedModelElems(m, impacted);
			}
		}
        else if (elem instanceof Object) {
            // no impacted elements
        }
		else if (elem instanceof Message) {
            // no impacted elements
		}
	}

}
