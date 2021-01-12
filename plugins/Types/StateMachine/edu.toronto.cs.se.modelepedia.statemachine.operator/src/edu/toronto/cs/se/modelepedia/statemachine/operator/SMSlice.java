/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.statemachine.FinalState;
import edu.toronto.cs.se.modelepedia.statemachine.InitialState;
import edu.toronto.cs.se.modelepedia.statemachine.State;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine.Transition;

public class SMSlice extends Slice {

  public static final String REL_TYPE_ID = "http://se.cs.toronto.edu/modelepedia/SMSliceRel";

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws MMINTException {
    basicInit(inputsByName, outputMIDsByName);
    var smSliceRelType = MIDTypeRegistry.<ModelRel>getType(SMSlice.REL_TYPE_ID);
    if (smSliceRelType == null) {
      throw new MMINTException("Missing SM slice rel type " + SMSlice.REL_TYPE_ID);
    }
    this.output.sliceRel = smSliceRelType.createInstanceAndEndpoints(null, Output.OUT_MODELREL,
                                                                     ECollections.asEList(this.input.model),
                                                                     this.output.mid);
  }

  @Override
  protected SliceStep getDirectlySlicedElements(EObject modelObj, SliceInfo info) {
    var slicedObjs = new HashSet<EObject>();

    // If input is a state machine, then the following are impacted:
    // 1) Owned states and transitions.
    if (modelObj instanceof StateMachine) {
      StateMachine m = (StateMachine) modelObj;
      slicedObjs.addAll(m.getStates());
      slicedObjs.addAll(m.getTransitions());
    }
    // If input is an (intermediate) state, then the following are impacted:
    // 1) Transitions originating or terminating at the state.
    // 2) Internal state actions.
    if (modelObj instanceof State) {
      State s = (State) modelObj;
      slicedObjs.addAll(s.getTransitionsAsSource());
      slicedObjs.addAll(s.getTransitionsAsTarget());
      slicedObjs.addAll(s.getInternalActions());
    }
    // If input is an initial state, then the following are impacted:
    // 1) Transitions originating or terminating at the state.
    if (modelObj instanceof InitialState) {
      InitialState s = (InitialState) modelObj;
      slicedObjs.addAll(s.getTransitionsAsSource());
      slicedObjs.addAll(s.getTransitionsAsTarget());
    }
    // If input is a final state, then the following are impacted:
    // 1) Transitions originating or terminating at the state.
    if (modelObj instanceof FinalState) {
      FinalState s = (FinalState) modelObj;
      slicedObjs.addAll(s.getTransitionsAsSource());
      slicedObjs.addAll(s.getTransitionsAsTarget());
    }
    // If input is a transition, then the following are impacted:
    // 1) The state the transition points to.
    if (modelObj instanceof Transition) {
      Transition t = (Transition) modelObj;
      slicedObjs.add(t.getTarget());
    }

    var newInfo = new SliceInfo(SliceType.RECHECK, modelObj, "sm");
    var sliced = slicedObjs.stream()
      .filter(s -> !this.allSliced.containsKey(s))
      .collect(Collectors.toMap(s -> s, s -> newInfo, this.typesOrder));
    return new SliceStep(sliced, sliced);
  }
}
