/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Optional;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTConstants;
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
	public void init(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {

		super.init(inputProperties, inputsByName);
		this.modelMultiplier = MIDOperatorIOUtils.getIntProp(inputProperties, ICMT15.PROPERTY_IN_MODELMULTIPLIER, Optional.empty());
		this.variablesMultiplier = MIDOperatorIOUtils.getIntProp(inputProperties, ICMT15.PROPERTY_IN_VARIABLESMULTIPLIER, Optional.empty());
		this.idAttribute = MIDOperatorIOUtils.getStringProp(inputProperties, ICMT15.PROPERTY_IN_IDATTRIBUTE, Optional.empty());
		this.constraint = MIDOperatorIOUtils.getStringProp(inputProperties, ICMT15.PROPERTY_IN_CONSTRAINT, Optional.empty());
		this.variables = MIDOperatorIOUtils.getStringPropList(inputProperties, ICMT15.PROPERTY_IN_VARIABLES, Optional.empty());
		this.clausesToVariablesRatio = MIDOperatorIOUtils.getDoubleProp(inputProperties, ICMT15.PROPERTY_IN_CLAUSESTOVARIABLESRATIO, Optional.empty());
		this.presenceConditionsToModelSizeRatio = MIDOperatorIOUtils.getDoubleProp(inputProperties, ICMT15.PROPERTY_IN_PRESENCECONDITIONSTOMODELSIZERATIO, Optional.empty());
	}

	private void init() {

		// output
		this.outputConstraint = "";
		this.outputVariables = new ArrayList<>();
		for (var i = 0; i < Math.pow(2, this.variablesMultiplier-1); i++) {
			var tempConstraint = this.constraint;
			for (var j = 0; j < this.variables.size(); j++) {
				var variable = this.variables.get(j);
				var outputVariable = variable + "_" + i;
				this.outputVariables.add(outputVariable);
				tempConstraint = tempConstraint.replace(variable, outputVariable);
			}
			this.outputConstraint += tempConstraint;
		}
	}

	private String getModelObjectEncoding(@NonNull EObject modelObj) throws MMINTException {

		return
			modelObj.eClass().getName() +
			ICMT15.CSV_SEPARATOR +
			FileUtils.getModelObjectFeature(modelObj, this.idAttribute) +
			ICMT15.CSV_SEPARATOR;
	}

	private String getModelReferenceEncoding(@NonNull EObject srcModelObj, @NonNull EObject tgtModelObj, @NonNull EStructuralFeature reference) throws MMINTException {

		return
			reference.getName() +
			ICMT15.CSV_SEPARATOR +
			getModelObjectEncoding(srcModelObj) +
			getModelObjectEncoding(tgtModelObj);
	}

	private List<String> generateModelEncodings(@NonNull EObject inputRootModelObj) {

		List<String> modelEncodings = new ArrayList<>();
		var iter = inputRootModelObj.eAllContents();
		while (iter.hasNext()) {
			var modelObj = iter.next();
			try {
				modelEncodings.add(getModelObjectEncoding(modelObj));
				var crossIter = (EContentsEList.FeatureIterator<EObject>) modelObj.eCrossReferences().iterator();
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

		var numClauses = (this.clausesToVariablesRatio * this.outputVariables.size() - ICMT15.EASY_PRESENCECONDITION_PERCENTAGE) / ICMT15.HARD_PRESENCECONDITION_PERCENTAGE;

		return (int) Math.max(0, Math.round(numClauses));
	}

	private void changeCopyIds(@NonNull EObject rootModelObjCopy, @NonNull String sliceIdSuffix) throws Exception {

		var iter = rootModelObjCopy.eAllContents();
		while (iter.hasNext()) {
			var modelObjCopy = iter.next();
			String id = null, newId = null;
			try {
				id = (String) FileUtils.getModelObjectFeature(modelObjCopy, this.idAttribute);
				if (id != null) {
					newId = id + sliceIdSuffix;
					FileUtils.setModelObjectFeature(modelObjCopy, this.idAttribute, newId);
				}
			}
			catch (MMINTException e) {
				// ignore and continue
				continue;
			}
		}
	}

	private @NonNull String generatePresenceCondition(@NonNull List<String> outputModelEncodings, int numClauses) {

		var random = this.getState();
		var i = random.nextInt(outputModelEncodings.size());
		var outputModelEncoding = outputModelEncodings.remove(i);
		var presenceCondition = "";
		if (numClauses == 1) {
			i = random.nextInt(this.outputVariables.size());
			presenceCondition = this.outputVariables.get(i);
		}
		else {
			for (var j = 0; j < numClauses-1; j++) {
				List<String> clause = new ArrayList<>();
				for (var k = 0; k < ICMT15.VARIABLES_PER_CLAUSE; k++) {
					i = random.nextInt(this.outputVariables.size());
					var variable = this.outputVariables.get(i);
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
		var inputModel = inputsByName.get(ICMT15.IN_MODEL);
		var instanceMID = outputMIDsByName.get(ICMT15.OUT_MODEL);
		this.init();

		// generate output model
		var inputRootModelObj = inputModel.getEMFInstanceRoot();
		var outputRootModelObj = inputRootModelObj.eClass().getEPackage().getEFactoryInstance().create(inputRootModelObj.eClass());
		var presenceConditions = Z3Utils.or(this.outputConstraint) + "\n";
		for (var i = 0; i < Math.pow(2, this.modelMultiplier-1); i++) {
			var inputRootModelObjCopy = EcoreUtil.copy(inputRootModelObj);
			changeCopyIds(inputRootModelObjCopy, "_" + i);
			for (EReference containmentFeature : inputRootModelObjCopy.eClass().getEAllContainments()) {
				@SuppressWarnings("unchecked")
				var inputModelObjsCopy = (EList<EObject>) FileUtils.getModelObjectFeature(inputRootModelObjCopy, containmentFeature.getName());
				@SuppressWarnings("unchecked")
				var outputModelObjs = (EList<EObject>) FileUtils.getModelObjectFeature(outputRootModelObj, containmentFeature.getName());
				outputModelObjs.addAll(inputModelObjsCopy);
			}
		}
		// generate presence conditions
		var outputModelEncodings = generateModelEncodings(outputRootModelObj);
		var numPresenceConditions = (int) (outputModelEncodings.size() * this.presenceConditionsToModelSizeRatio);
		var numClauses = getNumClauses();
		for (var i = 0; i < (numPresenceConditions * ICMT15.EASY_PRESENCECONDITION_PERCENTAGE); i++) {
			presenceConditions += generatePresenceCondition(outputModelEncodings, 1) + "\n";
		}
		if (numClauses > 0) {
			for (var i = 0; i < (numPresenceConditions * ICMT15.HARD_PRESENCECONDITION_PERCENTAGE); i++) {
				presenceConditions += generatePresenceCondition(outputModelEncodings, numClauses) + "\n";
			}
		}
		for (String outputModelEncoding : outputModelEncodings) {
			presenceConditions += outputModelEncoding + Z3Utils.SMTLIB_TRUE.trim() + "\n";
		}

		// output
		var uri = (getWorkingPath() != null) ?
			FileUtils.replaceLastSegmentInPath(
				inputModel.getUri(),
				getWorkingPath() + MMINTConstants.URI_SEPARATOR + FileUtils.getLastSegmentFromPath(inputModel.getUri())
			) :
			inputModel.getUri();
		String outputModelPath = FileUtils.getUniquePath(FileUtils.addFileNameSuffixInPath(uri, ICMT15.MODEL_GENERATED_SUFFIX), true, false);
		var outputModel = inputModel.getMetatype().createInstanceAndEditor(outputRootModelObj, outputModelPath, instanceMID);
		FileUtils.createTextFile(FileUtils.replaceFileExtensionInPath(outputModelPath, "csv"), presenceConditions, true);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(ICMT15.OUT_MODEL, outputModel);

		return outputsByName;
	}

}
