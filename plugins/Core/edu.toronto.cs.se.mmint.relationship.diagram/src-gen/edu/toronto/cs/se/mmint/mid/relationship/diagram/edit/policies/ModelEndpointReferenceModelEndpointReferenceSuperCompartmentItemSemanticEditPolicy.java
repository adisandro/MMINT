/*
* Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementReference2CreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementReference3CreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class ModelEndpointReferenceModelEndpointReferenceSuperCompartmentItemSemanticEditPolicy
		extends MIDBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ModelEndpointReferenceModelEndpointReferenceSuperCompartmentItemSemanticEditPolicy() {
		super(MIDElementTypes.ModelEndpointReference_2004);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MIDElementTypes.ModelElementReference_3002 == req.getElementType()) {
			return getGEFWrapper(new ModelElementReference2CreateCommand(req));
		}
		if (MIDElementTypes.ModelElementReference_3003 == req.getElementType()) {
			return getGEFWrapper(new ModelElementReference3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
