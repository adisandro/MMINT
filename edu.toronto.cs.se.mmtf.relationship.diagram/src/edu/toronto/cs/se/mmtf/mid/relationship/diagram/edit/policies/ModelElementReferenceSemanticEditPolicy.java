/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.BinaryLinkNewBinaryLinkCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkAddModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkRemoveModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementReferenceDelCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * The semantic edit policy for model element references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelElementReferenceSemanticEditPolicy extends ModelElementReferenceItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(incomingLink) == LinkElementRefsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new LinkRemoveModelElementReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(incomingLink) == BinaryLinkEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == BinaryLinkEditPart.VISUAL_ID) {
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
			cmd.add(new ModelElementReferenceDelCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * Gets the command to start creating a new link originating from a model
	 * element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return null;
		}
		if (MidElementTypes.BinaryLink_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkNewBinaryLinkCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to complete the creation of a new link originating from
	 * a model element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return getGEFWrapper(new LinkAddModelElementReferenceCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.BinaryLink_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryLinkNewBinaryLinkCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EClass)
	 * originating from a model element reference.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case BinaryLinkEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryLinkChangeModelElementReferenceCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		switch (getVisualID(req)) {
			case LinkElementRefsEditPart.VISUAL_ID:
				return getGEFWrapper(new LinkChangeModelElementReferenceCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
