/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class ModelElementEndpointReferenceItemSemanticEditPolicy extends
		MidBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelElementEndpointReferenceItemSemanticEditPolicy() {
		super(MidElementTypes.ModelElementEndpointReference_4011);
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
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementReferenceSupertypeRefCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementReferenceSupertypeRefCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getGEFWrapper(new ExtendibleElementReferenceSupertypeRefReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
