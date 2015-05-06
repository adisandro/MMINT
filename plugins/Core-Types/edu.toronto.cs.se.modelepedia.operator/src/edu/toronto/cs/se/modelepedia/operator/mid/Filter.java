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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Filter extends OperatorImpl {

	@NonNull
	private final static String INPUT_MID = "mid";
	@NonNull
	private final static String OUTPUT_MID = "filteredMid";
	@NonNull
	private final static String GENERIC_MODELTYPE = "TYPE";

	@NonNull
	private final static String FILTERED_MID_SUFFIX = "_filtered";

	private @NonNull MultiModel filter(@NonNull Model inputMIDModel, @NonNull Model filterModelType)
			throws MMINTException {

		MultiModel filteredMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
		Set<Model> modelsToDelete = new HashSet<>();
		for (Model model : MultiModelRegistry.getModels(filteredMID)) {
			boolean isModelRel = model instanceof ModelRel;
			boolean isFilterModelRelType = filterModelType instanceof ModelRel;
			// check constraint only if types match (Model and Model, or ModelRel and ModelRel
			if (isModelRel ^ isFilterModelRelType
					|| MultiModelConstraintChecker.checkConstraint(model, filterModelType.getConstraint()).toBoolean()) {
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
		Model inputMIDModel = inputsByName.get(INPUT_MID);
		Model filterModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
		MultiModel instanceMID = outputMIDsByName.get(OUTPUT_MID);

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
		outputsByName.put(OUTPUT_MID, filteredMIDModel);

		return outputsByName;
	}

}
