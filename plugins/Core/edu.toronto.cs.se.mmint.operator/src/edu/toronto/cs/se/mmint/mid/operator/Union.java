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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Union extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MIDS = "mids";
	private final static @NonNull String OUT_MID = "unionMid";
	// constants
	private final static @NonNull String UNION_SEPARATOR = "+";

	private @NonNull MultiModel union(@NonNull List<Model> inputMIDModels) throws MMINTException {

		MultiModel unionMID = MIDFactory.eINSTANCE.createMultiModel();
		// models only at first pass
		for (Model inputMIDModel : inputMIDModels) {
			MultiModel inputMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
			for (Model model : MultiModelRegistry.getModels(inputMID)) {
				if (model instanceof ModelRel
						|| MultiModelRegistry.getExtendibleElement(model.getUri(), unionMID) != null) {
					continue;
				}
				model.getMetatype().createInstanceAndEditor(model.getUri(), model.getOrigin(), unionMID);
			}
		}
		// model rels at second pass
		for (Model inputMIDModel : inputMIDModels) {
			MultiModel inputMID = (MultiModel) inputMIDModel.getEMFInstanceRoot();
			for (ModelRel rel : MultiModelRegistry.getModelRels(inputMID)) {
				rel.getMetatype().copyMAVOInstance(rel, unionMID);
			}
		}

		return unionMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		List<Model> inputMIDModels = MultiModelOperatorUtils.getVarargs(inputsByName, IN_MIDS);
		MultiModel instanceMID = outputMIDsByName.get(OUT_MID);

		// create union of input mids
		MultiModel unionMID = union(inputMIDModels);

		// output
		String unionMIDModelName = inputMIDModels.stream()
			.map(Model::getName)
			.collect(Collectors.joining(UNION_SEPARATOR));
		String unionMIDModelUri = MultiModelUtils.replaceFileNameInUri(
			MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0],
			unionMIDModelName);
		MultiModelUtils.createModelFile(unionMID, unionMIDModelUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model unionMIDModel = midModelType.createInstanceAndEditor(unionMIDModelUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, unionMIDModel);

		return outputsByName;
	}

}
