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
package edu.toronto.cs.se.modelepedia.operator.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Map extends OperatorImpl {

	private class InputModel {
		private Model model;
		private List<ConversionOperator> conversions;
		public InputModel(@NonNull Model model, @NonNull List<ConversionOperator> conversions) {
			this.model = model;
			this.conversions = conversions;
		}
		public @NonNull Model getModel() {
			return model;
		}
		public @NonNull List<ConversionOperator> getConversions() {
			return conversions;
		}
	}

	@NonNull private final static String MAP_MID_SUFFIX = "_map";

	private List<Set<InputModel>> x(Operator operatorType, MultiModel mid) {

		//TODO MMINT[MAP] Add support for upper bound = -1
		//TODO MMINT[MAP] Need something more in the operators themselves to validate proper input in case of model rels
		List<Set<InputModel>> y = new ArrayList<>();
		for (ModelEndpoint inputModelTypeEndpoint : operatorType.getInputs()) {
			Model inputModelType = inputModelTypeEndpoint.getTarget();
			Set<InputModel> yy = new HashSet<>();
			y.add(yy);
			for (Model inputModel : mid.getModels()) {
				List<ConversionOperator> conversionOperatorTypes = MultiModelTypeHierarchy.instanceOf(inputModel, inputModelType.getUri());
				if (conversionOperatorTypes == null) {
					continue;
				}
				yy.add(new InputModel(inputModel, conversionOperatorTypes));
			}
		}

		return y;
	}

	private void in(List<Set<InputModel>> midInputs, List<InputModel> accumulator, int index, Set<List<InputModel>> result) {

		if (midInputs.size() == index) {
			result.add(accumulator);
		}
		else {
			for (InputModel input : midInputs.get(index)) {
				List<InputModel> newAccumulator = new ArrayList<>(accumulator);
				newAccumulator.add(input);
				in(midInputs, newAccumulator, index + 1, result);
			}
		}
	}

	private void out(Operator operatorType, MultiModel mid, List<Set<InputModel>> midInputs) {

		Set<List<InputModel>> result = new HashSet<>();
		in(midInputs, new ArrayList<>(), 0, result);
		for (List<InputModel> res : result) {
			EList<Model> inputModels = new BasicEList<>();
			java.util.Map<Integer, EList<ConversionOperator>> conversions = new HashMap<>();
			for (int i = 0; i < res.size(); i++) {
				InputModel im = res.get(i);
				inputModels.add(im.getModel());
				List<ConversionOperator> c = im.getConversions();
				if (!c.isEmpty()) {
					conversions.put(new Integer(i), new BasicEList<>(c));
				}
			}
			try {
				//TODO MMINT[OPERATOR] An operator instance should be created here
				operatorType.run(inputModels, conversions, mid);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Operator " + operatorType + " execution error, skipping it", e);
			}
		}
	}

	public EList<Model> execute(EList<Model> inputModels) throws Exception {

		Model midModel = inputModels.get(0);
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(midModel);
		Operator operatorType = (Operator) ((GenericEndpoint) getGenerics().get(0)).getTarget();
		MultiModel mapMid = (MultiModel) midModel.getEMFInstanceRoot();

		// find all possible combinations of inputs for operatorType and execute them
		List<Set<InputModel>> midInputs = x(operatorType, mapMid);
		out(operatorType, mapMid, midInputs);
		/* TODO
		 * - Make it recursive and add option for shallow/deep
		 * - Think about the alternative invocation, with a mid for every parameter of operatorType (no need to find matches?)
		 */

		String mapMidUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(midModel.getUri(), MAP_MID_SUFFIX),
			true,
			false
		);
		MultiModelUtils.createModelFile(mapMid, mapMidUri, true);
		Model mapMidModel = midModel.getMetatype().createInstanceAndEditor(mapMidUri, ModelOrigin.CREATED, instanceMID);
		EList<Model> operatorOutputs = new BasicEList<>();
		operatorOutputs.add(mapMidModel);

		return operatorOutputs;
	}

}
