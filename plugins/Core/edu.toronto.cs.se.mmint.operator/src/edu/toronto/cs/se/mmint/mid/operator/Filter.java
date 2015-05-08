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
package edu.toronto.cs.se.mmint.mid.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Filter extends OperatorImpl {

	private enum Polarity {
		POSITIVE, NEGATIVE;
		public boolean toBoolean() {
			return this == POSITIVE;
		}
	};

	// input-output
	private final static @NonNull String IN_MID = "mid";
	private final static @NonNull String OUT_MID = "filteredMid";
	private final static @NonNull String GENERIC_MODELTYPE = "TYPE";
	private final static @NonNull String PROPERTY_IN_POLARITY = "polarity";
	private final static @NonNull Polarity PROPERTY_IN_POLARITY_DEFAULT = Polarity.POSITIVE;
	// constants
	private final static @NonNull String FILTERED_MID_SUFFIX = "_filtered";

	// input
	private Polarity polarity;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		polarity = MultiModelOperatorUtils.getOptionalEnumProperty(
			inputProperties,
			PROPERTY_IN_POLARITY,
			PROPERTY_IN_POLARITY_DEFAULT,
			Polarity.class);
	}

	private @NonNull MultiModel filter(@NonNull Model inputMIDModel, @NonNull Model filterModelType)
			throws MMINTException {

		MultiModel filteredMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		Set<Model> modelsToDelete = new HashSet<>();
		for (Model model : MultiModelRegistry.getModels(filteredMID)) {
			// check constraint only if types match (Model and Model, or ModelRel and ModelRel)
			if ((model instanceof ModelRel) != (filterModelType instanceof ModelRel)) {
				continue;
			}
			// check constraint according to polarity
			if (MultiModelConstraintChecker.checkConstraint(model, filterModelType.getConstraint()).toBoolean() ==
					polarity.toBoolean()) {
				continue;
			}
			modelsToDelete.add(model);
		}
		for (Model modelToDelete : modelsToDelete) {
			if (MultiModelRegistry.getMultiModel(modelToDelete) == null) {
				// already deleted as side effect of another deletion e.g. model delete that triggers model rel delete
				continue;
			}
			modelToDelete.deleteInstance();
		}

		return filteredMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		Model inputMIDModel = inputsByName.get(IN_MID);
		Model filterModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUT_MID);

		// filter mid models based on property attached to type
		MultiModel filteredMID = filter(inputMIDModel, filterModelType);

		// output
		String filteredMIDModelUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), FILTERED_MID_SUFFIX),
			true,
			false);
		MultiModelUtils.createModelFile(filteredMID, filteredMIDModelUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model filteredMIDModel = midModelType.createInstanceAndEditor(
			filteredMIDModelUri,
			ModelOrigin.CREATED,
			instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, filteredMIDModel);

		return outputsByName;
	}

}
