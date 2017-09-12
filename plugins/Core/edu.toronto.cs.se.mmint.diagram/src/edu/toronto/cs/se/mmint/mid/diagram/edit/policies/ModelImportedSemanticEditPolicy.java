/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelChangeModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.BinaryModelRelNewBinaryRelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelDelCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelAddModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelChangeModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

/**
 * The semantic edit policy for imported models.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelImportedSemanticEditPolicy extends Model2ItemSemanticEditPolicy {

	/**
	 * Gets the command to destroy a model.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpointEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == BinaryModelRelEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpoint2EditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == ModelEndpoint3EditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == BinaryModelRelEditPart.VISUAL_ID) {
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new ModelDelCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * Gets the command to start creating a new link originating from a model.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelNewBinaryRelCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to complete the creation of a new link originating from
	 * a model.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.ModelEndpoint_4002 == req.getElementType()) {
			return getGEFWrapper(new ModelRelAddModelEndpointCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryModelRel_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryModelRelNewBinaryRelCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EClass)
	 * originating from a model.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case ModelEndpointEditPart.VISUAL_ID:
				return getGEFWrapper(new ModelRelChangeModelEndpointCommand(req));
			case BinaryModelRelEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryModelRelChangeModelEndpointCommand(req));
	}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Gets the command to reorient a link (implemented with an EReference)
	 * originating from a model.
	 * 
	 * @param req
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
