/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
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

	private void x(StateMachine composedSM, StateMachine toCompose, Transition t, Map<String, State> compositionMap) {

		boolean transitionFirst = true;
		for (AbstractState s : toCompose.getStates()) {
			Transition composedT = StateMachine_MAVOFactory.eINSTANCE.createTransition();
			composedSM.getTransitions().add(composedT);
			State composedStateSrc = null;
			if (transitionFirst) {
				String name = t.getSource().getName() + "_" + s.getName();
				composedStateSrc = compositionMap.get(name);
				if (composedStateSrc == null) {
					transitionFirst = !transitionFirst;
				}
			}
			if (!transitionFirst) {
				String name = s.getName() + "_" + t.getSource().getName();
				composedStateSrc = compositionMap.get(name);
			}
			State composedStateTgt = null;
			if (transitionFirst) {
				String name = t.getTarget().getName() + "_" + s.getName();
				composedStateTgt = compositionMap.get(name);
				if (composedStateTgt == null) {
					transitionFirst = !transitionFirst;
				}
			}
			if (!transitionFirst) {
				String name = s.getName() + "_" + t.getTarget().getName();
				composedStateTgt = compositionMap.get(name);
			}
			composedT.setSource(composedStateSrc);
			composedT.setTarget(composedStateTgt);
		}
	}

	private @NonNull StateMachine compose(StateMachine sm1, StateMachine sm2) {

		Map<String, State> compositionMap = new HashMap<>();
		StateMachine composedSM = StateMachine_MAVOFactory.eINSTANCE.createStateMachine();
		// create all states first
		for (AbstractState s1 : sm1.getStates()) {
			for (AbstractState s2 : sm2.getStates()) {
				State c = StateMachine_MAVOFactory.eINSTANCE.createState();
				String name = s1.getName() + "_" + s2.getName();
				String formula = ((State) s1).getFormulaVariable() + "_" + ((State) s2).getFormulaVariable();
				c.setName(name);
				c.setFormulaVariable(formula);
				compositionMap.put(name, c);
				composedSM.getStates().add(c);
			}
		}
		// create transitions
		for (Transition t1 : sm1.getTransitions()) {
			x(composedSM, sm2, t1, compositionMap);
		}
		for (Transition t2 : sm2.getTransitions()) {
			x(composedSM, sm1, t2, compositionMap);
		}

		return composedSM;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		Model smModel1 = inputsByName.get(IN_MODEL1);
		Model smModel2 = inputsByName.get(IN_MODEL2);
		MultiModel instanceMID = outputMIDsByName.get(OUT_MODEL);

		// parallel composition
		StateMachine composedSM = compose((StateMachine) smModel1.getEMFInstanceRoot(), (StateMachine) smModel2.getEMFInstanceRoot());

		// output
		String composedModelUri = MultiModelUtils.replaceFileNameInUri(smModel1.getUri(), smModel1.getName() + "||" + smModel2.getName());
		MultiModelUtils.createModelFile(composedSM, composedModelUri, true);
		Model composedModel = smModel1.getMetatype().createInstanceAndEditor(composedModelUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, composedModel);

		return outputsByName;
	}

}
