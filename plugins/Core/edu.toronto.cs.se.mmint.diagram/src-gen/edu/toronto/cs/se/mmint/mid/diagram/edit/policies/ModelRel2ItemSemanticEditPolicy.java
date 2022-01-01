/*
* Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

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

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelReorientCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ExtendibleElementSupertypeCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ExtendibleElementSupertypeReorientCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpoint2CreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpoint2ReorientCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpoint3CreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpoint3ReorientCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpointCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelEndpointReorientCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class ModelRel2ItemSemanticEditPolicy extends MIDBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ModelRel2ItemSemanticEditPolicy() {
		super(MIDElementTypes.ModelRel_2004);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					incomingLink.getSource().getElement(),
					null,
					incomingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpointEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == BinaryModelRelEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpoint2EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpoint3EditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					outgoingLink.getSource().getElement(),
					null,
					outgoingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == ModelEndpointEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == BinaryModelRelEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
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
		}
		else {
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
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MIDElementTypes.ExtendibleElementSupertype_4001 == req.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelEndpoint_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelEndpoint_4004 == req.getElementType()) {
			return null;
		}
		if (MIDElementTypes.ModelEndpoint_4005 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (MIDElementTypes.ExtendibleElementSupertype_4001 == req.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelEndpoint_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelEndpoint_4004 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpoint2CreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.ModelEndpoint_4005 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpoint3CreateCommand(req, req.getSource(), req.getTarget()));
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
			case ModelEndpointEditPart.VISUAL_ID:
				return getGEFWrapper(new ModelEndpointReorientCommand(req));
			case BinaryModelRelEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryModelRelReorientCommand(req));
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getGEFWrapper(new ModelEndpoint2ReorientCommand(req));
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getGEFWrapper(new ModelEndpoint3ReorientCommand(req));
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
			case ExtendibleElementSupertypeEditPart.VISUAL_ID:
				return getGEFWrapper(new ExtendibleElementSupertypeReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
