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
package edu.toronto.cs.se.modelepedia.kleisli.transformation;

import java.util.Map;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.modelepedia.kleisli.BinaryKleisliModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;
import edu.toronto.cs.se.modelepedia.operator.patch.ModelRelTypeTransformation;

public class KleisliModelRelTypeTransformation extends ModelRelTypeTransformation {

	@Override
	protected void transform(BinaryModelRel traceModelRel, Model srcModel, int srcIndex, int tgtIndex) throws Exception {

		ModelEndpoint srcModelEndpoint = traceModelRel.getModelEndpoints().get(0);
		if (srcModelEndpoint instanceof KleisliModelEndpoint) {
			traceModelRel.openInstance();
			srcModel = ((KleisliModelEndpoint) srcModelEndpoint).getExtendedTarget();
		}
		super.transform(traceModelRel, srcModel, srcIndex, tgtIndex);
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName,
		java.util.Map<String, GenericElement> genericsByName, Map<String, MID> outputMIDsByName)
		throws Exception {

		Map<String, Model> outputsByName = super.run(inputsByName, genericsByName, outputMIDsByName);
		BinaryKleisliModelRel kTraceModelRel = (BinaryKleisliModelRel) outputsByName.get(OUT_MODELREL);
		Model modelPivot = kTraceModelRel.getSourceModel();
		kTraceModelRel.setSourceModel(kTraceModelRel.getTargetModel());
		kTraceModelRel.setTargetModel(modelPivot);
		kTraceModelRel.getModelEndpoints().move(1, 0);
		kTraceModelRel.getModelEndpointRefs().move(1, 0);
		for (Mapping kMapping : kTraceModelRel.getMappings()) {
			kMapping.getModelElemEndpoints().move(1, 0);
			kMapping.getModelElemEndpointRefs().move(1, 0);
		}
		for (MappingReference kMappingRef : kTraceModelRel.getMappingRefs()) {
			kMappingRef.getModelElemEndpointRefs().move(1, 0);
			ModelElementReference modelElemRefPivot = ((BinaryMappingReference) kMappingRef).getSourceModelElemRef();
			((BinaryMappingReference) kMappingRef).setSourceModelElemRef(((BinaryMappingReference) kMappingRef).getTargetModelElemRef());
			((BinaryMappingReference) kMappingRef).setTargetModelElemRef(modelElemRefPivot);
		}

		return outputsByName;
	}

}
