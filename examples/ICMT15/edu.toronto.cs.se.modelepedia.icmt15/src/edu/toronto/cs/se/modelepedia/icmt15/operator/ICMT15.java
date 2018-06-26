/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

//TODO MMINT[OPERATOR] Move other paper experiments to examples
public class ICMT15 extends RandomOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "model";
	private final static @NonNull String OUT_MODEL = "biggerModel";
	private final static @NonNull String PROPERTY_IN_MODELMULTIPLIER = "modelMultiplier";
	private final static @NonNull String PROPERTY_IN_VARIABLESMULTIPLIER = "variablesMultiplier";
	private static final @NonNull String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	private static final @NonNull String PROPERTY_IN_CONSTRAINT = "constraint";
	private static final @NonNull String PROPERTY_IN_VARIABLES = "variables";
	private static final @NonNull String PROPERTY_IN_CLAUSESTOVARIABLESRATIO = "clausesToVariablesRatio";
	private static final @NonNull String PROPERTY_IN_PRESENCECONDITIONSTOMODELSIZERATIO = "presenceConditionsToModelSizeRatio";
	// constants
	private final static @NonNull String CSV_SEPARATOR = ";";
	private final static @NonNull String MODEL_GENERATED_SUFFIX = "_generated";
	private final static double EASY_PRESENCECONDITION_PERCENTAGE = 0.8;
	private final static double HARD_PRESENCECONDITION_PERCENTAGE = 0.2;
	private final static int VARIABLES_PER_CLAUSE = 2;

	// input
	private int modelMultiplier;
	private int variablesMultiplier;
	private String idAttribute;
	private String constraint;
	private List<String> variables;
	private double clausesToVariablesRatio;
	private double presenceConditionsToModelSizeRatio;
	// output
	private List<String> outputVariables;
	private String outputConstraint;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		modelMultiplier = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MODELMULTIPLIER);
		variablesMultiplier = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_VARIABLESMULTIPLIER);
		idAttribute = MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
		constraint = MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_CONSTRAINT);
		variables = MIDOperatorIOUtils.getStringPropertyList(inputProperties, PROPERTY_IN_VARIABLES);
		clausesToVariablesRatio = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_CLAUSESTOVARIABLESRATIO);
		presenceConditionsToModelSizeRatio = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PRESENCECONDITIONSTOMODELSIZERATIO);
	}

	private void init() {

		// output
		outputConstraint = "";
		outputVariables = new ArrayList<>();
		for (int i = 0; i < Math.pow(2, variablesMultiplier-1); i++) {
			String tempConstraint = constraint;
			for (int j = 0; j < variables.size(); j++) {
				String variable = variables.get(j);
				String outputVariable = variable + "_" + i;
				outputVariables.add(outputVariable);
				tempConstraint = tempConstraint.replace(variable, outputVariable);
			}
			outputConstraint += tempConstraint;
		}
	}

	private String getModelObjectEncoding(@NonNull EObject modelObj) throws MMINTException {

		return
			modelObj.eClass().getName() +
			CSV_SEPARATOR +
			FileUtils.getModelObjectFeature(modelObj, idAttribute) +
			CSV_SEPARATOR;
	}

	private String getModelReferenceEncoding(@NonNull EObject srcModelObj, @NonNull EObject tgtModelObj, @NonNull EStructuralFeature reference) throws MMINTException {

		return
			reference.getName() +
			CSV_SEPARATOR +
			getModelObjectEncoding(srcModelObj) +
			getModelObjectEncoding(tgtModelObj);
	}

	private List<String> generateModelEncodings(@NonNull EObject inputRootModelObj) {

		List<String> modelEncodings = new ArrayList<>();
		TreeIterator<EObject> iter = inputRootModelObj.eAllContents();
		while (iter.hasNext()) {
			EObject modelObj = iter.next();
			try {
				modelEncodings.add(getModelObjectEncoding(modelObj));
				EContentsEList.FeatureIterator<EObject> crossIter = (EContentsEList.FeatureIterator<EObject>) modelObj.eCrossReferences().iterator();
				while (crossIter.hasNext()) {
					modelEncodings.add(getModelReferenceEncoding(modelObj, crossIter.next(), crossIter.feature()));
				}
			}
			catch (MMINTException e) {
				continue;
			}
		}

		return modelEncodings;
	}

	private int getNumClauses() {

		double numClauses = (clausesToVariablesRatio * (double) outputVariables.size() - EASY_PRESENCECONDITION_PERCENTAGE) / HARD_PRESENCECONDITION_PERCENTAGE;

		return (int) Math.max(0, Math.round(numClauses));
	}

	private void changeCopyIds(@NonNull EObject rootModelObjCopy, @NonNull String sliceIdSuffix) throws Exception {

		TreeIterator<EObject> iter = rootModelObjCopy.eAllContents();
		while (iter.hasNext()) {
			EObject modelObjCopy = iter.next();
			String id = null, newId = null;
			try {
				id = (String) FileUtils.getModelObjectFeature(modelObjCopy, idAttribute);
				if (id != null) {
					newId = id + sliceIdSuffix;
					FileUtils.setModelObjectFeature(modelObjCopy, idAttribute, newId);
				}
			}
			catch (MMINTException e) {
				// ignore and continue
				continue;
			}
		}
	}

	private @NonNull String generatePresenceCondition(@NonNull List<String> outputModelEncodings, int numClauses) {

		Random random = this.getState();
		int i = random.nextInt(outputModelEncodings.size());
		String outputModelEncoding = outputModelEncodings.remove(i);
		String presenceCondition = "";
		if (numClauses == 1) {
			i = random.nextInt(outputVariables.size());
			presenceCondition = outputVariables.get(i);
		}
		else {
			for (int j = 0; j < numClauses-1; j++) {
				List<String> clause = new ArrayList<>();
				for (int k = 0; k < VARIABLES_PER_CLAUSE; k++) {
					i = random.nextInt(outputVariables.size());
					String variable = outputVariables.get(i);
					if (clause.contains(variable)) {
						k--;
						continue;
					}
					clause.add(variable);
				}
				presenceCondition += Z3Utils.or(String.join(" ", clause));
			}
			presenceCondition = Z3Utils.and(presenceCondition);
		}

		return outputModelEncoding + presenceCondition;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model inputModel = inputsByName.get(IN_MODEL);
		MID instanceMID = outputMIDsByName.get(OUT_MODEL);
		this.init();

		// generate output model
		EObject inputRootModelObj = inputModel.getEMFInstanceRoot();
		EObject outputRootModelObj = inputRootModelObj.eClass().getEPackage().getEFactoryInstance().create(inputRootModelObj.eClass());
		String presenceConditions = Z3Utils.or(outputConstraint) + "\n";
		for (int i = 0; i < Math.pow(2, modelMultiplier-1); i++) {
			EObject inputRootModelObjCopy = EcoreUtil.copy(inputRootModelObj);
			changeCopyIds(inputRootModelObjCopy, "_" + i);
			for (EReference containmentFeature : inputRootModelObjCopy.eClass().getEAllContainments()) {
				@SuppressWarnings("unchecked")
				EList<EObject> inputModelObjsCopy = (EList<EObject>) FileUtils.getModelObjectFeature(inputRootModelObjCopy, containmentFeature.getName());
				@SuppressWarnings("unchecked")
				EList<EObject> outputModelObjs = (EList<EObject>) FileUtils.getModelObjectFeature(outputRootModelObj, containmentFeature.getName());
				outputModelObjs.addAll(inputModelObjsCopy);
			}
		}
		// generate presence conditions
		List<String> outputModelEncodings = generateModelEncodings(outputRootModelObj);
		int numPresenceConditions = (int) (outputModelEncodings.size() * presenceConditionsToModelSizeRatio);
		int numClauses = getNumClauses();
		for (int i = 0; i < (numPresenceConditions * EASY_PRESENCECONDITION_PERCENTAGE); i++) {
			presenceConditions += generatePresenceCondition(outputModelEncodings, 1) + "\n";
		}
		if (numClauses > 0) {
			for (int i = 0; i < (numPresenceConditions * HARD_PRESENCECONDITION_PERCENTAGE); i++) {
				presenceConditions += generatePresenceCondition(outputModelEncodings, numClauses) + "\n";
			}
		}
		for (String outputModelEncoding : outputModelEncodings) {
			presenceConditions += outputModelEncoding + Z3Utils.SMTLIB_TRUE.trim() + "\n";
		}

		// output
		String uri = (getInputSubdir() != null) ?
			FileUtils.replaceLastSegmentInPath(
				inputModel.getUri(),
				getInputSubdir() + MMINT.URI_SEPARATOR + FileUtils.getLastSegmentFromPath(inputModel.getUri())
			) :
			inputModel.getUri();
		String outputModelPath = FileUtils.getUniquePath(FileUtils.addFileNameSuffixInPath(uri, MODEL_GENERATED_SUFFIX), true, false);
		Model outputModel = inputModel.getMetatype().createInstanceAndEditor(outputRootModelObj, outputModelPath, instanceMID);
		FileUtils.createTextFile(FileUtils.replaceFileExtensionInPath(outputModelPath, "csv"), presenceConditions, true);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, outputModel);

		return outputsByName;
	}

}
