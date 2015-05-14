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
package edu.toronto.cs.se.modelepedia.models15.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.primitive.int_.Int;
import edu.toronto.cs.se.modelepedia.primitive.int_.IntFactory;
import edu.toronto.cs.se.modelepedia.primitive.int_.IntPackage;

public class CD2JavaCheck extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "rel";
	private final static @NonNull String OUT_INT = "check";
	// constants
	private final static @NonNull String CHECK_INT_SUFFIX = "_check";

	private @NonNull Int check(ModelRel modelRel) {

		// TODO Detect better
		Model cdModel = modelRel.getModelEndpoints().get(0).getTarget();
		Model javaModel = modelRel.getModelEndpoints().get(1).getTarget();
		// TODO Do actual check
		Int check = IntFactory.eINSTANCE.createInt();
		//TODO Add operator to plugin.xml

		return check;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		ModelRel modelRel = (ModelRel) inputsByName.get(IN_MODELREL);
		MultiModel instanceMID = outputMIDsByName.get(OUT_INT);

		// check classes connected by the rel
		Int check = check(modelRel);

		// output
		Model intModelType = MultiModelTypeRegistry.getType(IntPackage.eNS_URI);
		String checkModelUri = MultiModelUtils.replaceLastSegmentInUri(
			MultiModelRegistry.getModelAndModelElementUris(
				instanceMID,
				MIDLevel.INSTANCES)[0],
				modelRel.getName() + CHECK_INT_SUFFIX + MMINT.MODEL_FILEEXTENSION_SEPARATOR
						+ intModelType.getFileExtension());
		MultiModelUtils.createModelFile(check, checkModelUri, true);
		Model checkModel = intModelType.createInstanceAndEditor(checkModelUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_INT, checkModel);

		return outputsByName;
	}

}
