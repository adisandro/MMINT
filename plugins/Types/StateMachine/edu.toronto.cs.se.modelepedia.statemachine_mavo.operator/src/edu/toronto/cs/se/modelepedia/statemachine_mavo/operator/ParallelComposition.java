/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine_mavo.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.State;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOFactory;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition;

public class ParallelComposition extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL1 = "sm1";
	private final static @NonNull String IN_MODEL2 = "sm2";
	private final static @NonNull String OUT_MODEL = "composed";

	private final static @NonNull String COMPOSITION_INFIX = "-";

	private void createComposedTransition(@NonNull StateMachine composedSM, @NonNull Transition transition, State composedStateSrc, State composedStateTgt) {

		//TODO Generate unique formula vars
		Transition composedTransition = StateMachine_MAVOFactory.eINSTANCE.createTransition();
		composedTransition.setTrigger(transition.getTrigger());
		composedTransition.setFormulaVariable(transition.getFormulaVariable() + "_" + composedStateSrc.getFormulaVariable() + "2" + composedStateTgt.getFormulaVariable());
		composedSM.getTransitions().add(composedTransition);
		composedTransition.setSource(composedStateSrc);
		composedTransition.setTarget(composedStateTgt);
	}

	private void createComposedTransitions(@NonNull StateMachine composedSM, @NonNull StateMachine smToCompose, @NonNull Transition transition, @NonNull Map<String, State> composedStates, boolean transitionFirst) {

		for (AbstractState stateToCompose : smToCompose.getStates()) {
			String composedStateNameSrc, composedStateNameTgt;
			if (transitionFirst) {
				composedStateNameSrc = transition.getSource().getName() + COMPOSITION_INFIX + stateToCompose.getName();
				composedStateNameTgt = transition.getTarget().getName() + COMPOSITION_INFIX + stateToCompose.getName();
			}
			else {
				composedStateNameSrc = stateToCompose.getName() + COMPOSITION_INFIX + transition.getSource().getName();
				composedStateNameTgt = stateToCompose.getName() + COMPOSITION_INFIX + transition.getTarget().getName();
			}
			createComposedTransition(composedSM, transition, composedStates.get(composedStateNameSrc), composedStates.get(composedStateNameTgt));
		}
	}

	private @NonNull Map<String, Set<Transition>> getTriggers(@NonNull StateMachine sm) {

		return sm.getTransitions().stream()
			.collect(Collectors.groupingBy(
				Transition::getTrigger,
				Collectors.toSet()));
	}

	private @NonNull StateMachine compose(StateMachine sm1, StateMachine sm2) {

		Map<String, Set<Transition>> triggers1 = getTriggers(sm1);
		Map<String, Set<Transition>> triggers2 = getTriggers(sm2);
		Map<String, State> composedStates = new HashMap<>();
		StateMachine composedSM = StateMachine_MAVOFactory.eINSTANCE.createStateMachine();
		// create all states first..
		for (AbstractState state1 : sm1.getStates()) {
			//TODO MMINT[STATEMACHINE] Fix initial and final state not having mavo annotations
			if (!(state1 instanceof State)) {
				continue;
			}
			for (AbstractState state2 : sm2.getStates()) {
				if (!(state2 instanceof State)) {
					continue;
				}
				State composedState = StateMachine_MAVOFactory.eINSTANCE.createState();
				String composedStateName = state1.getName() + COMPOSITION_INFIX + state2.getName();
				String composedStateFormulaVar = ((State) state1).getFormulaVariable() + COMPOSITION_INFIX + ((State) state2).getFormulaVariable();
				composedState.setName(composedStateName);
				composedState.setFormulaVariable(composedStateFormulaVar);
				composedStates.put(composedStateName, composedState);
				composedSM.getStates().add(composedState);
			}
		}
		// ..then create transitions
		for (Transition transition1 : sm1.getTransitions()) {
			Set<Transition> transitions2SameTrigger = triggers2.get(transition1.getTrigger());
			if (transitions2SameTrigger != null) { // sync
				for (Transition transition2 : transitions2SameTrigger) {
					String composedStateName = transition1.getSource().getName() + COMPOSITION_INFIX + transition2.getSource().getName();
					State composedStateSrc = composedStates.get(composedStateName);
					composedStateName = transition1.getTarget().getName() + COMPOSITION_INFIX + transition2.getTarget().getName();
					State composedStateTgt = composedStates.get(composedStateName);
					createComposedTransition(composedSM, transition1, composedStateSrc, composedStateTgt);
				}
			}
			else {
				createComposedTransitions(composedSM, sm2, transition1, composedStates, true);
			}
		}
		for (Transition transition2 : sm2.getTransitions()) {
			if (triggers1.get(transition2.getTrigger()) != null) { // sync already done
				continue;
			}
			createComposedTransitions(composedSM, sm1, transition2, composedStates, false);
		}

		return composedSM;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model smModel1 = inputsByName.get(IN_MODEL1);
		Model smModel2 = inputsByName.get(IN_MODEL2);
		MID instanceMID = outputMIDsByName.get(OUT_MODEL);

		// parallel composition
		StateMachine composedSM = compose((StateMachine) smModel1.getEMFInstanceRoot(), (StateMachine) smModel2.getEMFInstanceRoot());

		// output
		String composedModelPath = FileUtils.replaceFileNameInPath(smModel1.getUri(), smModel1.getName() + "+" + smModel2.getName());
		Model composedModel = smModel1.getMetatype().createInstanceAndEditor(composedSM, composedModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, composedModel);

		return outputsByName;
	}

}
