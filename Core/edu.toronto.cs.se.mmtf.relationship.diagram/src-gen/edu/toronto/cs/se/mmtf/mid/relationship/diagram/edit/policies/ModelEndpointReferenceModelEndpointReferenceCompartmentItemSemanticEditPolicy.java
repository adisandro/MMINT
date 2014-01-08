/*
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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementReferenceCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class ModelEndpointReferenceModelEndpointReferenceCompartmentItemSemanticEditPolicy
		extends MidBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelEndpointReferenceModelEndpointReferenceCompartmentItemSemanticEditPolicy() {
		super(MidElementTypes.ModelEndpointReference_2007);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MidElementTypes.ModelElementReference_3005 == req.getElementType()) {
			return getGEFWrapper(new ModelElementReferenceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
