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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryModelRelCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryModelRelReorientCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ExtendibleElementSupertypeCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ExtendibleElementSupertypeReorientCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelEndpointCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelEndpointReorientCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.Parameter2CreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.Parameter2ReorientCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ParameterCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ParameterReorientCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Parameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class BinaryModelRelItemSemanticEditPolicy extends
		MidBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public BinaryModelRelItemSemanticEditPolicy() {
		super(MidElementTypes.BinaryModelRel_4015);
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
		if (MidElementTypes.ExtendibleElementSupertype_4013 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.ModelEndpoint_4014 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryModelRel_4015 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.Parameter_4016 == req.getElementType()) {
			return null;
		}
		if (MidElementTypes.Parameter_4017 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (MidElementTypes.ExtendibleElementSupertype_4013 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.ModelEndpoint_4014 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryModelRel_4015 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.Parameter_4016 == req.getElementType()) {
			return getGEFWrapper(new ParameterCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.Parameter_4017 == req.getElementType()) {
			return getGEFWrapper(new Parameter2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ModelEndpointEditPart.VISUAL_ID:
			return getGEFWrapper(new ModelEndpointReorientCommand(req));
		case BinaryModelRelEditPart.VISUAL_ID:
			return getGEFWrapper(new BinaryModelRelReorientCommand(req));
		case ParameterEditPart.VISUAL_ID:
			return getGEFWrapper(new ParameterReorientCommand(req));
		case Parameter2EditPart.VISUAL_ID:
			return getGEFWrapper(new Parameter2ReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
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
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return getGEFWrapper(new ExtendibleElementSupertypeReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
