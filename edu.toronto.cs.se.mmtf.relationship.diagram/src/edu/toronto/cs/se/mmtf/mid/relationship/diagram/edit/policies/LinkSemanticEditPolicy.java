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
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementSupertypeCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementSupertypeReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkAddModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkDelCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkRemoveModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

public class LinkSemanticEditPolicy extends LinkItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(incomingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MidVisualIDRegistry.getVisualID(outgoingLink) == LinkElementRefsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new LinkRemoveModelElementReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new LinkDelCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.ExtendibleElementSupertype_4001 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return getGEFWrapper(new LinkAddModelElementReferenceCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		switch (getVisualID(req)) {
			case ExtendibleElementSupertypeEditPart.VISUAL_ID:
				return getGEFWrapper(new ExtendibleElementSupertypeReorientCommand(req));
			case LinkElementRefsEditPart.VISUAL_ID:
				return getGEFWrapper(new LinkChangeModelElementReferenceCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
