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
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Slice extends OperatorImpl {

	// input-output
	protected final static @NonNull String IN_MODELREL = "criterion";
	protected final static @NonNull String OUT_MODELREL = "slice";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel critRel = (ModelRel) inputsByName.get(IN_MODELREL);
			if (critRel.getModelEndpoints().size() > 1) {
				return false;
			}

			return true;
		}

		@Override
		public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			Input input = new Input(inputsByName);
			ModelRel sliceRel = (ModelRel) outputsByName.get(OUT_MODELREL);
			Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
			List<Model> endpointModels = new ArrayList<>();
			endpointModels.add(input.model);
			validOutputs.put(sliceRel, endpointModels);

			return validOutputs;
		}

	}

	private static class Input {

		private ModelRel critRel;
		private Model model;

		public Input(Map<String, Model> inputsByName) {

			this.critRel = (ModelRel) inputsByName.get(IN_MODELREL);
			this.model = critRel.getModelEndpoints().get(0).getTarget();
		}
	}

	protected ModelRel slice(ModelRel critRel, Model model, MID outputMID) throws MMINTException {

		ModelRel sliceRel = critRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);
		//TODO MMINT[MODELS17] The following is just an example of how to create a model element reference
		EObject modelRootObj = model.getEMFInstanceRoot();
		sliceRel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelRootObj, null);

		return sliceRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Input input = new Input(inputsByName);
		MID outputMID = outputMIDsByName.get(OUT_MODELREL);

		// create the slice from the initial criterion and the rules
		ModelRel sliceRel = this.slice(input.critRel, input.model, outputMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, sliceRel);

		return outputsByName;
	}

}
