/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.patch;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

public class BinaryModelRelInversion extends OperatorExecutableImpl {

	private static final String MODELREL_SUFFIX = "_inv";

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		BinaryModelRel modelRel = (BinaryModelRel) actualParameters.get(0);

		// create inverted model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRel);
		BinaryModelRel invertedModelRel = (BinaryModelRel) MultiModelInstanceFactory.createModelRel(
			modelRel.getMetatype(),
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);
		invertedModelRel.setName(modelRel.getName() + MODELREL_SUFFIX);
		MultiModelMAVOInstanceFactory.copyModelRel(modelRel, invertedModelRel);

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

		EList<Model> result = new BasicEList<Model>();
		result.add(invertedModelRel);
		return result;
	}

}