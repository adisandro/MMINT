/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class Filter extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MID = "mid";
	private final static @NonNull String OUT_MID = "filteredMid";
	private final static @NonNull String GENERIC_MODELTYPE = "TYPE";
	// constants
	private final static @NonNull String FILTERED_MID_SUFFIX = "_filter";

	@Override
	public boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType, EList<OperatorInput> inputs) throws MMINTException {

		boolean allowed = super.isAllowedGeneric(genericTypeEndpoint, genericType, inputs);
		if (!allowed) {
			return false;
		}
		if (genericType.getName().equals("Filter") || genericType.getName().equals("Map") || genericType.getName().equals("Reduce")) {
			return false;
		}

		return true;
	}

	private @NonNull MID filter(@NonNull Model inputMIDModel, @NonNull Model filterModelType)
			throws MMINTException {

		MID filteredMID = (MID) inputMIDModel.getEMFInstanceRoot();
		Set<Model> modelsToDelete = new HashSet<>();
		for (Model model : filteredMID.getModels()) {
			// check constraint only if types match (Model and Model, or ModelRel and ModelRel)
			if ((model instanceof ModelRel) != (filterModelType instanceof ModelRel)) {
				continue;
			}
			// check constraint
			if (MIDTypeHierarchy.instanceOf(model, filterModelType.getUri(), false) && MIDConstraintChecker.checkModelConstraint(model, filterModelType.getConstraint())) {
				continue;
			}
			modelsToDelete.add(model);
		}
		for (Model modelToDelete : modelsToDelete) {
			if (modelToDelete.getMIDContainer() == null) {
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
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model inputMIDModel = inputsByName.get(IN_MID);
		Model filterModelType = (Model) genericsByName.get(GENERIC_MODELTYPE);
		MID instanceMID = outputMIDsByName.get(OUT_MID);

		// filter mid models based on property attached to type
		MID filteredMID = filter(inputMIDModel, filterModelType);

		// output
		String filteredMIDModelUri = FileUtils.getUniqueUri(
			FileUtils.addFileNameSuffixInUri(inputMIDModel.getUri(), FILTERED_MID_SUFFIX),
			true,
			false);
		FileUtils.writeModelFile(filteredMID, filteredMIDModelUri, true);
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		Model filteredMIDModel = midModelType.createInstanceAndEditor(filteredMIDModelUri, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, filteredMIDModel);

		return outputsByName;
	}

}
