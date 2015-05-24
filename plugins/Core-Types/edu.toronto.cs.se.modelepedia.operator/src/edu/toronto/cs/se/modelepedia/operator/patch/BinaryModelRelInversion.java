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
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;

public class BinaryModelRelInversion extends OperatorImpl {


	// input-output
	private final static @NonNull String IN_MODELREL = "rel";
	private final static @NonNull String OUT_MODELREL = "inverted";
	// constants
	private static final String INVERTED_MODELREL_SUFFIX = "_inv";

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		BinaryModelRel modelRel = (BinaryModelRel) inputsByName.get(IN_MODELREL);

		// create inverted model relationship
		BinaryModelRel invertedModelRel = (BinaryModelRel) modelRel.getMetatype().copyMAVOInstance(modelRel, outputMIDsByName.get(OUT_MODELREL));
		invertedModelRel.setName(modelRel.getName() + INVERTED_MODELREL_SUFFIX);

		// invert all indexes
		invertedModelRel.getModelEndpoints().move(1, 0);
		invertedModelRel.getModelEndpointRefs().move(1, 0);
		for (Link link : invertedModelRel.getLinks()) {
			link.getModelElemEndpoints().move(1, 0);
			link.getModelElemEndpointRefs().move(1, 0);
		}
		for (LinkReference linkRef : invertedModelRel.getLinkRefs()) {
			linkRef.getModelElemEndpointRefs().move(1, 0);
		}

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, invertedModelRel);

		return outputsByName;
	}

}