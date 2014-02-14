/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.transformation.ModelRelTypeTransformation;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliBinaryModelRel;
import edu.toronto.cs.se.modelepedia.kleisli.KleisliModelEndpoint;

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
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		EList<Model> result = super.execute(actualParameters);
		KleisliBinaryModelRel kTraceModelRel = (KleisliBinaryModelRel) result.get(1);
		kTraceModelRel.getModelEndpoints().move(1, 0);
		kTraceModelRel.getModelEndpointRefs().move(1, 0);
		for (Link kLink : kTraceModelRel.getLinks()) {
			kLink.getModelElemEndpoints().move(1, 0);
			kLink.getModelElemEndpointRefs().move(1, 0);
		}
		for (LinkReference kLinkRef : kTraceModelRel.getLinkRefs()) {
			kLinkRef.getModelElemEndpointRefs().move(1, 0);
		}

		return result;
	}

}
