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
package edu.toronto.cs.se.modelepedia.icmt15.operator;

import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelMatch;
import edu.toronto.cs.se.modelepedia.operator.merge.EMFModelMerge;

public class ModelGenerator extends OperatorImpl {

	@NonNull private final static String PROPERTY_IN_NUMITERATIONS = "numIterations";
	@NonNull private static final String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	@NonNull private static final String PROPERTY_IN_BOUNDARIESIDS = "boundariesIds";

	@NonNull private final static String OPERATOR_EMFMODELMATCH_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMatch";
	@NonNull private final static String OPERATOR_EMFMODELMERGE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMerge";
	@NonNull private final static String SLICE_IDATTRIBUTE_SUFFIX = "_slice_";

	private int numIterations;
	private String idAttribute;
	private Set<String> boundariesIds;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		numIterations = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMITERATIONS);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
		boundariesIds = MultiModelOperatorUtils.getStringPropertySet(inputProperties, PROPERTY_IN_BOUNDARIESIDS);
	}

	private Model copySliceAndChangeIds(Model sliceModel, String sliceIdSuffix) throws Exception {

		String newSliceName = MultiModelUtils.getFileNameFromUri(MultiModelUtils.getUniqueUri(sliceModel.getUri(), true, false));
		Model newSliceModel = sliceModel.getMetatype().copyMAVOInstance(sliceModel, newSliceName, null);
		EObject newSliceRoot = newSliceModel.getEMFInstanceRoot();
		newSliceRoot.eAllContents().forEachRemaining(sliceModelObj -> {
			String sliceId = null;
			try {
				sliceId = (String) MultiModelUtils.getModelObjFeature(sliceModelObj, idAttribute);
				if (sliceId != null && !boundariesIds.contains(sliceId)) {
					sliceId += sliceIdSuffix;
					MultiModelUtils.setModelObjFeature(sliceModelObj, idAttribute, sliceId);
				}
			}
			catch (MMINTException e) {
				// ignore and continue
			}
		});
		MultiModelUtils.createModelFile(newSliceRoot, newSliceModel.getUri(), true);

		return newSliceModel;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		/**
		 * TODO:
		 * 3) Handle csv
		 */
		EMFModelMatch matchOperator = (EMFModelMatch) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMATCH_URI);
		EMFModelMerge mergeOperator = (EMFModelMerge) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMERGE_URI);
		if (matchOperator == null || mergeOperator == null) {
			throw new MMINTException("Can't find EMFModelMatch and/or EMFModelMerge operators");
		}
		Model model = actualParameters.get(0);
		EList<Model> operatorInputs, operatorOutputs;
		for (int i = 0; i < numIterations; i++) {
			for (int j = 1; j < actualParameters.size(); j++) {
				Model sliceModel = copySliceAndChangeIds(actualParameters.get(j), SLICE_IDATTRIBUTE_SUFFIX + i + "-" + j);
				operatorInputs = new BasicEList<>();
				operatorInputs.add(model);
				operatorInputs.add(sliceModel);
				operatorOutputs = matchOperator.execute(operatorInputs);
				operatorInputs = new BasicEList<>();
				operatorInputs.add(model);
				operatorInputs.add(operatorOutputs.get(0));
				operatorInputs.add(sliceModel);
				operatorOutputs = mergeOperator.execute(operatorInputs);
				model = operatorOutputs.get(0);
			}
		}

		EList<Model> outputs = new BasicEList<>();
		outputs.add(model);
		return outputs;
	}

}
