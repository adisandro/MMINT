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

import java.util.List;
import java.util.Properties;

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

	@NonNull private final static String OPERATOR_EMFMODELMATCH_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMatch";
	@NonNull private final static String OPERATOR_EMFMODELMERGE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMerge";

	private int numIterations;
	private String idAttribute;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		numIterations = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMITERATIONS);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
	}

	private Model copySliceAndChangeIds(Model sliceModel, String sliceIdSuffix) throws Exception {

		String newSliceName = MultiModelUtils.getFileNameFromUri(MultiModelUtils.getUniqueUri(sliceModel.getUri(), true, false));
		Model newSliceModel = sliceModel.getMetatype().copyMAVOInstance(sliceModel, newSliceName, null);
		EObject newSliceRoot = newSliceModel.getEMFInstanceRoot();
		newSliceRoot.eAllContents().forEachRemaining(sliceModelObj -> {
			String sliceId = null;
			try {
				sliceId = (String) MultiModelUtils.getModelObjFeature(sliceModelObj, idAttribute);
				if (sliceId != null) {//TODO and sliceId not in boundaries
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
		 * 1) Read 3 slices in memory
		 * 2) Loop: create matches, merge modifying the idAttribute
		 * 3) Handle csv
		 * 4) Don't update mid in between and deal with different file names
		 * 5) Add copyMAVOInstance() to MID apis
		 */
		Model model = actualParameters.get(0);
		for (Model sliceModel : actualParameters) {
			
		}

		EMFModelMatch matchOperator = (EMFModelMatch) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMATCH_URI);
		EMFModelMerge mergeOperator = (EMFModelMerge) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMERGE_URI);
		for (int i = 0; i < numIterations; i++) {
			for (int j = 1; j < actualParameters.size(); j++) {
				EList<Model> matchOperatorInputs = new BasicEList<>();
				matchOperatorInputs.add(actualParameters.get(j));
				matchOperatorInputs.add(actualParameters.get(j+1));
				matchOperator.execute(actualParameters);
			}
		}

		List<Model> results = new BasicEList<>();
		results.add(model);
		return null;
	}

}
