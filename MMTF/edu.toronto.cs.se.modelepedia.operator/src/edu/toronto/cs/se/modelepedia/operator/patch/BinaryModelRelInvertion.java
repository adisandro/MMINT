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
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

public class BinaryModelRelInvertion extends OperatorExecutableImpl {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		BinaryModelRel modelRel = (BinaryModelRel) actualParameters.get(1);

		// create inverted model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRel);
		BinaryModelRel invertedModelRel = (BinaryModelRel) MultiModelInstanceFactory.createModelRel(
			modelRel.getMetatype(),
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);
		MultiModelMAVOInstanceFactory.copyModelRel(modelRel, invertedModelRel);

		EList<Model> result = new BasicEList<Model>();
		result.add(invertedModelRel);
		return result;
	}

}
