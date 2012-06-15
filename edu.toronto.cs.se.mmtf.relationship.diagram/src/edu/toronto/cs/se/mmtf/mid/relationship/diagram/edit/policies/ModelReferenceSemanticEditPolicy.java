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

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelRelRemoveModelCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelReferenceDelCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceEditPart;

/**
 * The semantic edit policy for model references.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelReferenceSemanticEditPolicy extends ModelReferenceItemSemanticEditPolicy {

	/**
	 * Gets the command to delete a model reference.
	 * 
	 * @param request
	 *            The request.
	 * @return The executable command.
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		ModelReferenceEditPart editPart = (ModelReferenceEditPart) getHost();
		ModelReference modelRef = (ModelReference) ((View) editPart.getModel()).getElement();
		ModelRel modelRel = (ModelRel) modelRef.eContainer();

		if (modelRef.getContainedObject() == null && modelRel instanceof BinaryModelRel) {
			// a binary model relationship which is not standalone can be only modified through the Mid diagram
			return UnexecutableCommand.INSTANCE;
		}
		else {
			// this is equivalent to deleting a model of a model relationship in the Mid diagram
			// plus refreshing the outline
			CompoundCommand ccommand = new CompoundCommand("Delete model");
			EReference containing = (EReference) modelRel.eClass().getEStructuralFeature(RelationshipPackage.MODEL_REL__MODELS);
			DestroyReferenceRequest destroyRefReq = new DestroyReferenceRequest(editPart.getEditingDomain(), modelRel, containing, modelRef.getObject(), false);
			ccommand.add(
				getGEFWrapper(new ModelRelRemoveModelCommand(destroyRefReq))
			);
			DestroyElementRequest destroyElemReq = new DestroyElementRequest(editPart.getEditingDomain(), modelRef, false);
			ccommand.add(
				getGEFWrapper(new ModelReferenceDelCommand(destroyElemReq))
			);

			return ccommand;
			//TODO MMTF: add outline support for modelrelremovemodelcommand and undo operations (always refresh is the solution?)
		}
	}

}
