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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelMatch;
import edu.toronto.cs.se.modelepedia.operator.merge.EMFModelMerge;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

public class ModelGenerator extends OperatorImpl {

	@NonNull private final static String PROPERTY_IN_NUMITERATIONS = "numIterations";
	@NonNull private static final String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	@NonNull private static final String PROPERTY_IN_BOUNDARIESIDS = "boundariesIds";
	@NonNull private static final String PROPERTY_IN_CONSTRAINT = "constraint";
	@NonNull private static final String PROPERTY_IN_FEATURES = "features";

	@NonNull private final static String OPERATOR_EMFMODELMATCH_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMatch";
	@NonNull private final static String OPERATOR_EMFMODELMERGE_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMerge";
	@NonNull private final static String MODEL_GENERATED_SUFFIX = "_generated";

	private int numIterations;
	private String idAttribute;
	private Set<String> boundariesIds;
	private String constraint;
	private List<String> features;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		numIterations = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMITERATIONS);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
		boundariesIds = MultiModelOperatorUtils.getStringPropertySet(inputProperties, PROPERTY_IN_BOUNDARIESIDS);
		constraint = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_CONSTRAINT);
		features = MultiModelOperatorUtils.getStringPropertyList(inputProperties, PROPERTY_IN_FEATURES);
	}

	private Model copySlice(Model sliceModel) throws MMINTException {

		String newSliceName = MultiModelUtils.getFileNameFromUri(MultiModelUtils.getUniqueUri(sliceModel.getUri(), true, false));
		Model newSliceModel = sliceModel.getMetatype().copyMAVOInstance(sliceModel, newSliceName, null);

		return newSliceModel;
	}

	private String changeSliceIds(Model newSliceModel, String sliceIdSuffix, String presenceConditions) throws Exception {

		EObject newSliceRoot = newSliceModel.getEMFInstanceRoot();
		TreeIterator<EObject> iter = newSliceRoot.eAllContents();
		while (iter.hasNext()) {
			EObject sliceModelObj = iter.next();
			String sliceId = null, newSliceId = null;
			try {
				sliceId = (String) MultiModelUtils.getModelObjFeature(sliceModelObj, idAttribute);
				if (sliceId != null && !boundariesIds.contains(sliceId)) {
					newSliceId = sliceId + sliceIdSuffix + "_" + UUID.randomUUID().toString();
					MultiModelUtils.setModelObjFeature(sliceModelObj, idAttribute, newSliceId);
					presenceConditions = presenceConditions.replace(";" + sliceId + ";", ";" + newSliceId + ";");
				}
			}
			catch (MMINTException e) {
				// ignore and continue
				continue;
			}
		}
		MultiModelUtils.createModelFile(newSliceRoot, newSliceModel.getUri(), true);

		return presenceConditions;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// inputs
		Model inputModel = actualParameters.get(0);
		EMFModelMatch matchOperator = (EMFModelMatch) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMATCH_URI);
		EMFModelMerge mergeOperator = (EMFModelMerge) MultiModelTypeRegistry.<Operator>getType(OPERATOR_EMFMODELMERGE_URI);
		if (matchOperator == null || mergeOperator == null) {
			throw new MMINTException("Can't find EMFModelMatch and/or EMFModelMerge operators");
		}
		String csvUri = MultiModelUtils.replaceFileExtensionInUri(inputModel.getUri(), "csv");
		byte[] cvsBytes = Files.readAllBytes(Paths.get(MultiModelUtils.prependWorkspaceToUri(csvUri)));
		String initialPresenceConditions = new String(cvsBytes);
		String presenceConditions = initialPresenceConditions;
		String globalConstraint = Z3Utils.SMTLIB_OR + constraint;

		// generate model and presence conditions
		Model generatedModel = inputModel;
		EList<Model> operatorInputs, operatorOutputs;
		for (int i = 0; i < numIterations; i++) {
			String iterationSuffix = "-" + i;
			String iterationPresenceConditions = initialPresenceConditions;
			String iterationConstraint = constraint;
			for (String feature : features) {
				iterationPresenceConditions = iterationPresenceConditions.replace(feature, feature + iterationSuffix);
				iterationConstraint = iterationConstraint.replace(feature, feature + iterationSuffix);
			}
			for (int j = 1; j < actualParameters.size(); j++) {
				Model newSliceModel = copySlice(actualParameters.get(j));
				iterationPresenceConditions = changeSliceIds(newSliceModel, "_" + (j-1) + iterationSuffix, iterationPresenceConditions);
				operatorInputs = new BasicEList<>();
				operatorInputs.add(generatedModel);
				operatorInputs.add(newSliceModel);
				operatorOutputs = matchOperator.execute(operatorInputs);
				operatorInputs = new BasicEList<>();
				operatorInputs.add(generatedModel);
				operatorInputs.add(operatorOutputs.get(0));
				operatorInputs.add(newSliceModel);
				operatorOutputs = mergeOperator.execute(operatorInputs);
				Model intermediateModel = generatedModel;
				generatedModel = operatorOutputs.get(0);
				MultiModelUtils.deleteFile(newSliceModel.getUri(), true);
				if (intermediateModel != inputModel) {
					MultiModelUtils.deleteFile(intermediateModel.getUri(), true);
				}
			}
			presenceConditions += "\n" + iterationPresenceConditions;
			globalConstraint += iterationConstraint;
		}
		globalConstraint += Z3Utils.SMTLIB_PREDICATE_END;
		presenceConditions = globalConstraint + "\n" + presenceConditions;

		// outputs
		EList<Model> outputs = new BasicEList<>();
		String outputModelUri = MultiModelUtils.addFileNameSuffixInUri(inputModel.getUri(), MODEL_GENERATED_SUFFIX);
		MultiModelUtils.createModelFile(generatedModel.getEMFInstanceRoot(), outputModelUri, true);
		MultiModelUtils.deleteFile(generatedModel.getUri(), true);
		MultiModel instanceMID = MultiModelRegistry.getMultiModel(inputModel);
		Model outputModel = (isUpdateMID()) ?
			generatedModel.getMetatype().createInstanceAndEditor(outputModelUri, ModelOrigin.CREATED, instanceMID) :
			generatedModel.getMetatype().createInstance(outputModelUri, ModelOrigin.CREATED, null);
		outputs.add(outputModel);
		MultiModelUtils.createTextFile(MultiModelUtils.addFileNameSuffixInUri(csvUri, MODEL_GENERATED_SUFFIX), presenceConditions, true);

		return outputs;
	}

}
