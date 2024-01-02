/*
* Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefCreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefReorientCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementEndpointReference2CreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementEndpointReference2ReorientCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementEndpointReferenceCreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementEndpointReferenceReorientCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class BinaryMappingReference2ItemSemanticEditPolicy extends MIDBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public BinaryMappingReference2ItemSemanticEditPolicy() {
		super(MIDElementTypes.BinaryMappingReference_4004);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001 == req.getElementType()) {
			return getGEFWrapper(
					new ExtendibleElementReferenceSupertypeRefCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelElementEndpointReference_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelElementEndpointReferenceCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelElementEndpointReference_4005 == req.getElementType()) {
			return getGEFWrapper(
					new ModelElementEndpointReference2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001 == req.getElementType()) {
			return getGEFWrapper(
					new ExtendibleElementReferenceSupertypeRefCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelElementEndpointReference_4002 == req.getElementType()) {
			return null;
		}
		if (MIDElementTypes.ModelElementEndpointReference_4005 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new ModelElementEndpointReferenceReorientCommand(req));
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new ModelElementEndpointReference2ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getGEFWrapper(new ExtendibleElementReferenceSupertypeRefReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
