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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.trait.RelationshipDiagramTrait;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;

/**
 * The command to change a model element reference of a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkReferenceChangeModelElementEndpointReferenceCommand extends ModelElementEndpointReferenceReorientCommand {

	private EList<String> modelElemTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public LinkReferenceChangeModelElementEndpointReferenceCommand(ReorientRelationshipRequest request) {

		super(request);
		modelElemTypeEndpointUris = null;
	}

	/**
	 * Checks if a model element reference can be changed.
	 * 
	 * @return True if a model element reference can be changed, false
	 *         otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				!MultiModelConstraintChecker.isRootType(getLink())
			);
	}

	/**
	 * Checks if the source link can be changed.
	 * 
	 * @return True if the source link can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		return
			super.canReorientSource() && (
				!MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				(modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(getNewSource(), getOldTarget())) != null
			);
	}

	/**
	 * Checks if the target model element reference can be changed.
	 * 
	 * @return True if the target model element reference can be changed, false
	 *         otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		return
			super.canReorientTarget() && (
				!MultiModelConstraintChecker.isInstancesLevel(getLink()) ||
				(modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(getOldSource(), getNewTarget())) != null
			);
	}

	protected void doExecuteInstancesLevel(LinkReference linkRef, ModelElementReference modelElemRef) throws Exception {

		MultiModelInstanceFactory.removeModelElementEndpointAndModelElementEndpointReference(getLink(), false);
		ModelElementEndpointReference modelElemTypeEndpointRef = RelationshipDiagramTrait.selectModelElementTypeEndpointToCreate(linkRef, modelElemTypeEndpointUris);
		MultiModelInstanceFactory.replaceModelElementEndpointAndModelElementEndpointReference(
			getLink(),
			modelElemTypeEndpointRef.getObject(),
			linkRef,
			modelElemRef
		);
	}

	protected void doExecuteTypesLevel(LinkReference linkTypeRef, ModelElementReference modelElemTypeRef) throws MMTFException {

		MultiModelTypeFactory.removeModelElementTypeEndpointAndModelElementTypeEndpointReference(getLink(), false);
		String newModelElemTypeEndpointName = getLink().getObject().getName();
		//TODO MMTF: search for override (only if we're not inheriting from a root type)
		ModelElementEndpointReference modelElemTypeEndpointRef = null;
		ModelElementEndpoint modelElemTypeEndpoint = (modelElemTypeEndpointRef == null) ? null : modelElemTypeEndpointRef.getObject();
		MultiModelLightTypeFactory.replaceLightModelElementTypeEndpointAndModelElementTypeEndpointReference(
			getLink(),
			linkTypeRef,
			modelElemTypeEndpoint,
			modelElemTypeEndpointRef,
			modelElemTypeRef,
			newModelElemTypeEndpointName
		);
		// no need to init type hierarchy, no need for undo/redo
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getNewSource(), getLink().getModelElemRef());
			}
			else {
				doExecuteTypesLevel(getNewSource(), getLink().getModelElemRef());
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel((LinkReference) getLink().eContainer(), getNewTarget());
			}
			else {
				doExecuteTypesLevel((LinkReference) getLink().eContainer(), getNewTarget());
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

}
