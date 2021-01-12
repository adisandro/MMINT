/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;

public class BinaryModelRelInversion extends OperatorImpl {


	// input-output
	private final static @NonNull String IN_MODELREL = "rel";
	private final static @NonNull String OUT_MODELREL = "inverted";
	// constants
	private static final String INVERTED_MODELREL_SUFFIX = "_inv";

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		BinaryModelRel modelRel = (BinaryModelRel) inputsByName.get(IN_MODELREL);

		// create inverted model relationship
		BinaryModelRel invertedModelRel = (BinaryModelRel) modelRel.getMetatype().copyInstance(modelRel, modelRel.getName() + INVERTED_MODELREL_SUFFIX, outputMIDsByName.get(OUT_MODELREL));

		// invert all indexes
		invertedModelRel.getModelEndpoints().move(1, 0);
		Model targetModel = invertedModelRel.getSourceModel();
		invertedModelRel.setSourceModel(invertedModelRel.getTargetModel());
		invertedModelRel.setTargetModel(targetModel);
		invertedModelRel.getModelEndpointRefs().move(1, 0);
		for (Mapping mapping : invertedModelRel.getMappings()) {
			mapping.getModelElemEndpoints().move(1, 0);
			mapping.getModelElemEndpointRefs().move(1, 0);
		}
		for (MappingReference mappingRef : invertedModelRel.getMappingRefs()) {
			mappingRef.getModelElemEndpointRefs().move(1, 0);
			if (mappingRef instanceof BinaryMappingReference) {
				ModelElementReference targetModelElemRef = ((BinaryMappingReference) mappingRef).getSourceModelElemRef();
				((BinaryMappingReference) mappingRef).setSourceModelElemRef(((BinaryMappingReference) mappingRef).getTargetModelElemRef());
				((BinaryMappingReference) mappingRef).setTargetModelElemRef(targetModelElemRef);
			}
		}

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, invertedModelRel);

		return outputsByName;
	}

}