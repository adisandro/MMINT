/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.Object;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;

public class SDSlice extends Slice {

    // Get impacted model elements directly reachable from the input element.
    @Override
    protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

        Set<EObject> impacted = new HashSet<>();
        // If input is a sequence diagram, then the following are impacted:
        // 1) Owned objects, and messages.
        if (modelObj instanceof SequenceDiagram) {
            SequenceDiagram sd = (SequenceDiagram) modelObj;
            impacted.addAll(sd.getObjects());
            impacted.addAll(sd.getMessages());
        }

        // If input is an object, then the following are impacted:
        // 1) Owned lifeline.
        else if (modelObj instanceof Object) {
            Object o = (Object) modelObj;
            impacted.add(o.getLifeline());
        }

        // If input is a lifeline, then the following are impacted:
        // 1) Referenced object.
        // 2) Referenced messages.
        else if (modelObj instanceof Lifeline) {
            Lifeline l = (Lifeline) modelObj;
            impacted.add(l.getObject());
            impacted.addAll(l.getMessagesAsSource());
            impacted.addAll(l.getMessagesAsTarget());
        }

        // If input is a message, then the following are impacted:
        // 1) Its target and source lifelines.
        else if (modelObj instanceof Message) {
            Message m = (Message) modelObj;
            impacted.add(m.getSourceLifeline());
            impacted.add(m.getTargetLifeline());
        }

        impacted.removeAll(alreadyImpacted);

        return impacted;
    }
}
