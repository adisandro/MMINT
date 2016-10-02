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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class Union extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MIDS = "mids";
	private final static @NonNull String OUT_MID = "unionMid";
	// constants
	private final static @NonNull String UNION_SEPARATOR = "+";

	private @NonNull MID union(@NonNull List<Model> inputMIDModels) throws MMINTException {

		MID unionMID = MIDFactory.eINSTANCE.createMID();
		// models only at first pass
		for (Model inputMIDModel : inputMIDModels) {
			MID inputMID = (MID) inputMIDModel.getEMFInstanceRoot();
			for (Model model : inputMID.getModels()) {
				if (model instanceof ModelRel
						|| unionMID.getExtendibleElement(model.getUri()) != null) {
					continue;
				}
				model.getMetatype().createInstanceAndEditor(model.getUri(), unionMID);
			}
		}
		// model rels at second pass
		for (Model inputMIDModel : inputMIDModels) {
			MID inputMID = (MID) inputMIDModel.getEMFInstanceRoot();
			for (ModelRel rel : inputMID.getModelRels()) {
				rel.getMetatype().copyInstance(rel, rel.getName(), unionMID);
			}
		}

		return unionMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		List<Model> inputMIDModels = MIDOperatorIOUtils.getVarargs(inputsByName, IN_MIDS);
		MID instanceMID = outputMIDsByName.get(OUT_MID);

		// create union of input mids
		MID unionMID = union(inputMIDModels);

		// output
		String unionMIDModelName = inputMIDModels.stream()
			.map(Model::getName)
			.collect(Collectors.joining(UNION_SEPARATOR));
		String unionMIDModelUri = FileUtils.replaceFileNameInUri(
			MIDRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0],
			unionMIDModelName);
		FileUtils.writeModelFile(unionMID, unionMIDModelUri, true);
		Model midModelType = MIDTypeRegistry.getMIDModelType();
		Model unionMIDModel = midModelType.createInstanceAndEditor(unionMIDModelUri, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, unionMIDModel);

		return outputsByName;
	}

}
