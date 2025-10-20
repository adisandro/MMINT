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
package edu.toronto.cs.se.modelepedia.models15.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.OperatorGeneric;
import edu.toronto.cs.se.mmint.OperatorInput;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.operator.patch.ModelRelTypeTransformation;

public class CD2Java extends ConversionOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "cd";
	private final static @NonNull String OUT_MODEL = "java";
	// constants
	private final static @NonNull String MODELRELTYPETRANSFORMATION_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_ModelRelTypeTransformation";
	private final static @NonNull String CD2JAVA_MODELRELTYPE_URI = "http://se.cs.toronto.edu/modelepedia/CD2Java";

	private @NonNull Model convert(@NonNull Model cdModel, @Nullable MID instanceMID) throws Exception {

		Operator transformationOperatorType = MIDTypeRegistry.getType(CD2Java.MODELRELTYPETRANSFORMATION_OPERATOR_URI);
		EList<Model> inputModels = new BasicEList<>();
		inputModels.add(cdModel);
		EList<OperatorInput> inputs = transformationOperatorType.checkAllowedInputs(inputModels);
		Map<String, MID> outputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(transformationOperatorType, instanceMID);
		EList<OperatorGeneric> generics = new BasicEList<>();
    ModelRel cd2javaRelType = MIDTypeRegistry.getType(CD2Java.CD2JAVA_MODELRELTYPE_URI);
		OperatorGeneric generic = new OperatorGeneric(cd2javaRelType, transformationOperatorType.getGenerics().get(0));
		generics.add(generic);
		var transformationOperator = transformationOperatorType.startInstance(inputs, null, generics, outputMIDsByName, null);

		return transformationOperator.getOutputsByName().get(ModelRelTypeTransformation.OUT_MODEL);
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model cdModel = inputsByName.get(CD2Java.IN_MODEL);
		MID instanceMID = outputMIDsByName.get(CD2Java.OUT_MODEL);

		// run model rel type transformation
		Model javaModel = convert(cdModel, instanceMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(CD2Java.OUT_MODEL, javaModel);

		return outputsByName;
	}

}
