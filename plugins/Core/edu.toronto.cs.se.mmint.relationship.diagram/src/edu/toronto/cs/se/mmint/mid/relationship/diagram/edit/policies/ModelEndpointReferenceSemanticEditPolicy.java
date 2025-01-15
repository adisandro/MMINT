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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelRemoveModelEndpointCommand;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelEndpointReferenceDelCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;

/**
 * The semantic edit policy for model references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelEndpointReferenceSemanticEditPolicy extends ModelEndpointReferenceItemSemanticEditPolicy {

	/**
	 * Gets the command to delete a model reference.
	 * 
	 * @param request
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		ModelEndpointReferenceEditPart editPart = (ModelEndpointReferenceEditPart) getHost();
		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) ((View) editPart.getModel()).getElement();
		ModelRel modelRel = (ModelRel) modelEndpointRef.eContainer();

		if (modelEndpointRef.getContainedObject() == null && modelRel instanceof BinaryModelRel) {
			// a binary model relationship which is not standalone can be only modified through the Mid diagram
			return null;
		}
		else {
			// this is equivalent to deleting a model of a model relationship in the Mid diagram
			// plus refreshing the outline
			CompoundCommand ccommand = new CompoundCommand("Delete model endpoint");
			DestroyElementRequest destroyElemReq = new DestroyElementRequest(editPart.getEditingDomain(), modelEndpointRef.getObject(), false);
			ccommand.add(
				getGEFWrapper(new ModelRelRemoveModelEndpointCommand(destroyElemReq))
			);
			DestroyElementRequest destroyElemReq2 = new DestroyElementRequest(editPart.getEditingDomain(), modelEndpointRef, false);
			ccommand.add(
				getGEFWrapper(new ModelEndpointReferenceDelCommand(destroyElemReq2))
			);

			return ccommand;
			//TODO MMINT[MID] add outline support for modelrelremovemodelcommand and undo operations (always refresh is the solution?)
		}
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		return null;
	}

	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		return null;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
