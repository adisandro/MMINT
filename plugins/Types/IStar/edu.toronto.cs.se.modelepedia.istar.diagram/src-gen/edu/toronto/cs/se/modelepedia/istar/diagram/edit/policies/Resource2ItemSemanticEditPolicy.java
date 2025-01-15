/*
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.ContributionCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.ContributionReorientCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DecompositionCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DecompositionReorientCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DependeeLinkCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DependeeLinkReorientCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DependerLinkCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.DependerLinkReorientCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.MeansEndCreateCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.commands.MeansEndReorientCommand;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ContributionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DecompositionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependeeLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependerLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.MeansEndEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;

/**
 * @generated
 */
public class Resource2ItemSemanticEditPolicy extends
		IStarBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public Resource2ItemSemanticEditPolicy() {
		super(IStarElementTypes.Resource_3003);
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
			if (IStarVisualIDRegistry.getVisualID(incomingLink) == MeansEndEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(incomingLink) == DecompositionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(incomingLink) == ContributionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(incomingLink) == DependerLinkEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(incomingLink) == DependeeLinkEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (IStarVisualIDRegistry.getVisualID(outgoingLink) == MeansEndEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(outgoingLink) == DecompositionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(outgoingLink) == ContributionEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(outgoingLink) == DependerLinkEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (IStarVisualIDRegistry.getVisualID(outgoingLink) == DependeeLinkEditPart.VISUAL_ID) {
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
		if (IStarElementTypes.MeansEnd_4001 == req.getElementType()) {
			return getGEFWrapper(new MeansEndCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.Decomposition_4002 == req.getElementType()) {
			return getGEFWrapper(new DecompositionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.Contribution_4003 == req.getElementType()) {
			return getGEFWrapper(new ContributionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.DependerLink_4004 == req.getElementType()) {
			return getGEFWrapper(new DependerLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.DependeeLink_4005 == req.getElementType()) {
			return getGEFWrapper(new DependeeLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (IStarElementTypes.MeansEnd_4001 == req.getElementType()) {
			return getGEFWrapper(new MeansEndCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.Decomposition_4002 == req.getElementType()) {
			return getGEFWrapper(new DecompositionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.Contribution_4003 == req.getElementType()) {
			return getGEFWrapper(new ContributionCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.DependerLink_4004 == req.getElementType()) {
			return getGEFWrapper(new DependerLinkCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (IStarElementTypes.DependeeLink_4005 == req.getElementType()) {
			return getGEFWrapper(new DependeeLinkCreateCommand(req,
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
		case MeansEndEditPart.VISUAL_ID:
			return getGEFWrapper(new MeansEndReorientCommand(req));
		case DecompositionEditPart.VISUAL_ID:
			return getGEFWrapper(new DecompositionReorientCommand(req));
		case ContributionEditPart.VISUAL_ID:
			return getGEFWrapper(new ContributionReorientCommand(req));
		case DependerLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new DependerLinkReorientCommand(req));
		case DependeeLinkEditPart.VISUAL_ID:
			return getGEFWrapper(new DependeeLinkReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
