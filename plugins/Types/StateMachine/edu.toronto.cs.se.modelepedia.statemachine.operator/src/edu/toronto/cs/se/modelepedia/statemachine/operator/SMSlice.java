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
package edu.toronto.cs.se.modelepedia.statemachine.operator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.statemachine.FinalState;
import edu.toronto.cs.se.modelepedia.statemachine.InitialState;
import edu.toronto.cs.se.modelepedia.statemachine.State;
import edu.toronto.cs.se.modelepedia.statemachine.StateAction;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine.Transition;


public class SMSlice extends Slice {

	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {
	    Set<EObject> impacted = new HashSet<>();
	    
	    // If input is a state machine, then the following are impacted:
	    // 1) Owned states and transitions.
	    if (modelObj instanceof StateMachine) {
	    	StateMachine m = (StateMachine) modelObj;
	    	impacted.addAll(m.getStates());
	    	impacted.addAll(m.getTransitions());
	    	
	    // If input is an (intermediate) state, then the following are impacted:
	    // 1) Transitions originating or terminating at the state.
	    // 2) Internal state actions.
	    } else if (modelObj instanceof State) {
	    	State s = (State) modelObj;
	    	impacted.addAll(s.getTransitionsAsSource());
	    	impacted.addAll(s.getTransitionsAsTarget());
	    	impacted.addAll(s.getInternalActions());
	    	
	    // If input is an initial state, then the following are impacted:
	    // 1) Transitions originating or terminating at the state.
	    } else if (modelObj instanceof InitialState) {
	    	InitialState s = (InitialState) modelObj;
	    	impacted.addAll(s.getTransitionsAsSource());
	    	impacted.addAll(s.getTransitionsAsTarget());
	    	
	    // If input is a final state, then the following are impacted:
	    // 1) Transitions originating or terminating at the state.
	    } else if (modelObj instanceof FinalState) {
		    FinalState s = (FinalState) modelObj;
		    impacted.addAll(s.getTransitionsAsSource());
		    impacted.addAll(s.getTransitionsAsTarget());
		    	
		// If input is a transition, then the following are impacted:
		// 1) The state the transition points to.
	    } else if (modelObj instanceof Transition) {
	    	Transition t = (Transition) modelObj;
	    	impacted.add(t.getTarget());
	    	
	    // If input is a state action, then nothing else is impacted.
	    } else if (modelObj instanceof StateAction) {
	    	
	    }

		impacted.removeAll(alreadyImpacted);

		return impacted;
	}
	
}

