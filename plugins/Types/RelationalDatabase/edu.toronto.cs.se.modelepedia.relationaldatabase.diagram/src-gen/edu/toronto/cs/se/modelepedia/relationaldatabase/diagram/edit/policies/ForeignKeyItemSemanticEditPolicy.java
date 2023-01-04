/*
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.policies;

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
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.commands.ForeignKeyForeignColumnCreateCommand;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.commands.ForeignKeyForeignColumnReorientCommand;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.commands.ForeignKeyTableColumnCreateCommand;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.commands.ForeignKeyTableColumnReorientCommand;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyForeignColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts.ForeignKeyTableColumnEditPart;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseElementTypes;

/**
 * @generated
 */
public class ForeignKeyItemSemanticEditPolicy extends
		RelationalDatabaseBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ForeignKeyItemSemanticEditPolicy() {
		super(RelationalDatabaseElementTypes.ForeignKey_3002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (RelationalDatabaseVisualIDRegistry.getVisualID(outgoingLink) == ForeignKeyTableColumnEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (RelationalDatabaseVisualIDRegistry.getVisualID(outgoingLink) == ForeignKeyForeignColumnEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
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
		if (RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001 == req
				.getElementType()) {
			return getGEFWrapper(new ForeignKeyTableColumnCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002 == req
				.getElementType()) {
			return getGEFWrapper(new ForeignKeyForeignColumnCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (RelationalDatabaseElementTypes.ForeignKeyTableColumn_4001 == req
				.getElementType()) {
			return null;
		}
		if (RelationalDatabaseElementTypes.ForeignKeyForeignColumn_4002 == req
				.getElementType()) {
			return null;
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
		case ForeignKeyTableColumnEditPart.VISUAL_ID:
			return getGEFWrapper(new ForeignKeyTableColumnReorientCommand(req));
		case ForeignKeyForeignColumnEditPart.VISUAL_ID:
			return getGEFWrapper(new ForeignKeyForeignColumnReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
