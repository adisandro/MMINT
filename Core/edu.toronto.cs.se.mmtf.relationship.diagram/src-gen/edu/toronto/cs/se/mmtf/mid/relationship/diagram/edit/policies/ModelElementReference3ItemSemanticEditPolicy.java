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

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkReference2CreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkReference2ReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkReferenceCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkReferenceReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementReferenceSupertypeRefReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementEndpointReference2CreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementEndpointReference2ReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementEndpointReferenceCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementEndpointReferenceReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class ModelElementReference3ItemSemanticEditPolicy extends
		MidBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelElementReference3ItemSemanticEditPolicy() {
		super(MidElementTypes.ModelElementReference_3007);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(incomingLink) == ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(incomingLink) == ModelElementEndpointReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(incomingLink) == BinaryLinkReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(incomingLink) == BinaryLinkReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(incomingLink) == ModelElementEndpointReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == BinaryLinkReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == BinaryLinkReference2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
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
		if (MidElementTypes.ModelElementEndpointReference_4011 == req
				.getElementType()) {
			return null;
		}
		if (MidElementTypes.BinaryLinkReference_4012 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReferenceCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLinkReference_4013 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReference2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.ModelElementEndpointReference_4014 == req
				.getElementType()) {
			return null;
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
		if (MidElementTypes.ModelElementEndpointReference_4011 == req
				.getElementType()) {
			return getGEFWrapper(new ModelElementEndpointReferenceCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLinkReference_4012 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReferenceCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLinkReference_4013 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkReference2CreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.ModelElementEndpointReference_4014 == req
				.getElementType()) {
			return getGEFWrapper(new ModelElementEndpointReference2CreateCommand(
					req, req.getSource(), req.getTarget()));
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
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new ModelElementEndpointReferenceReorientCommand(
					req));
		case BinaryLinkReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(new BinaryLinkReferenceReorientCommand(req));
		case BinaryLinkReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new BinaryLinkReference2ReorientCommand(req));
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getGEFWrapper(new ModelElementEndpointReference2ReorientCommand(
					req));
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
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return getGEFWrapper(new ExtendibleElementReferenceSupertypeRefReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
