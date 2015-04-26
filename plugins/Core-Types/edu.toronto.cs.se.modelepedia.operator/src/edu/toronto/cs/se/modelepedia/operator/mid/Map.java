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
import java.util.List;

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

	@NonNull private final static String MAP_MID_SUFFIX = "_map";

	private List<List<Model>> x(Operator operatorType, MultiModel mid, List<List<List<ConversionOperator>>> conversions) {

		//TODO MMINT[MAP] Add support for upper bound = -1
		//TODO MMINT[MAP] Need something more in the operators themselves to validate proper input in case of model rels
		List<List<Model>> y = new ArrayList<>();
		for (ModelEndpoint inputModelTypeEndpoint : operatorType.getInputs()) {
			Model inputModelType = inputModelTypeEndpoint.getTarget();
			List<Model> yy = new ArrayList<>();
			y.add(yy);
			List<List<ConversionOperator>> zz = new ArrayList<>();
			conversions.add(zz);
			for (Model inputModel : mid.getModels()) {
				List<ConversionOperator> conversionOperatorTypes = MultiModelTypeHierarchy.instanceOf(inputModel, inputModelType.getUri());
				if (conversionOperatorTypes == null) {
					continue;
				}
				zz.add(conversionOperatorTypes);
				yy.add(inputModel);
			}
		}

		return y;
	}

	private void y(Operator operatorType, MultiModel mid, List<List<Model>> midInputs, List<List<List<ConversionOperator>>> midConversions) {

		EList<Model> inputModels = new BasicEList<>();
		java.util.Map<Integer, EList<ConversionOperator>> conversions = new HashMap<>();
		for (int i = 0; i < midInputs.size(); i++) {
			int cartesianIndex = 0;//TODO MMINT[MAP] Select by cartesian product
			List<Model> a = midInputs.get(i);
			inputModels.add(a.get(cartesianIndex));
			List<List<ConversionOperator>> b = midConversions.get(i);
			List<ConversionOperator> bb = b.get(cartesianIndex);
			if (!bb.isEmpty()) {
				conversions.put(new Integer(i), new BasicEList<>(bb));
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

	public EList<Model> execute(EList<Model> inputModels) throws Exception {

		Model midModel = inputModels.get(0);
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(midModel);
		Operator operatorType = (Operator) ((GenericEndpoint) getGenerics().get(0)).getTarget();
		MultiModel mapMid = (MultiModel) midModel.getEMFInstanceRoot();

		// find all possible combinations of inputs for operatorType and execute them
		List<List<List<ConversionOperator>>> conversions = new ArrayList<>();
		List<List<Model>> midInputs = x(operatorType, mapMid, conversions);
		y(operatorType, mapMid, midInputs, conversions);

		// 
		/* TODO
		 * 2) Apply operatorType to the mid
		 * 2a) find all possible combinations of the input of operatorType
		 *     (== matches, list of lists of actual parameters List<EList<Model>>)
		 *     use some heuristics to have groups of actual parameters, then invoke getExecutables() to check
		 * 2b) execute the operatorType on the matches and store the output mid
		 * 3) Make it recursive and add option for shallow/deep
		 * 4) Traceability: create Map<OperatorType>, but what about the individual applications of OperatorType?
		 * 5) Think about the alternative invocation, with a mid for every parameter of operatorType (no need to find matches?)
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
