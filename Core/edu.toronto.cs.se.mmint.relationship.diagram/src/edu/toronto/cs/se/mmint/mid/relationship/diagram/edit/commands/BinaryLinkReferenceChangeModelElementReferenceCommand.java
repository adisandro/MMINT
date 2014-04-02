/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.library.MidDialogCancellation;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.BinaryLinkReferenceReorientCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.library.RelationshipDiagramUtils;

/**
 * The command to change a model element reference of a binary mapping link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryLinkReferenceChangeModelElementReferenceCommand extends BinaryLinkReferenceReorientCommand {

	private List<String> modelElemTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryLinkReferenceChangeModelElementReferenceCommand(ReorientRelationshipRequest request) {

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
				!MultiModelTypeHierarchy.isRootType(getLink().getObject())
			);
	}

	/**
	 * Checks if the source model element reference can be reoriented.
	 * 
	 * @return True if the source model element reference can be reoriented,
	 *         false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getLink());

		return
			super.canReorientSource() && ((
				instance &&
				(modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(getLink(), getNewSource())) != null
			) || (
				!instance &&
				MultiModelConstraintChecker.isAllowedModelElementTypeEndpointReference(getLink(), getNewSource(), null)
			));
	}

	/**
	 * Checks if the target model element reference can be reoriented.
	 * 
	 * @return True if the target model element reference can be reoriented,
	 *         false otherwise.
	 */
	@Override
	protected boolean canReorientTarget() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getLink());

		return
			super.canReorientTarget() && ((
				instance &&
				(modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(getLink(), getNewTarget())) != null
			) || (
				!instance &&
				MultiModelConstraintChecker.isAllowedModelElementTypeEndpointReference(getLink(), null, getNewTarget())
			));
	}

	protected void doExecuteInstancesLevel(BinaryLinkReference linkRef, ModelElementReference modelElemRef, boolean isBinarySrc) throws MMINTException, MidDialogCancellation {

		ModelElementEndpointReference oldModelElemEndpointRef = (isBinarySrc) ?
			linkRef.getModelElemEndpointRefs().get(0) :
			linkRef.getModelElemEndpointRefs().get(1);
		ModelElementEndpointReference modelElemTypeEndpointRef = RelationshipDiagramUtils.selectModelElementTypeEndpointToCreate(linkRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().replaceInstanceAndReference(oldModelElemEndpointRef, modelElemRef);
	}

	protected void doExecuteTypesLevel(BinaryLinkReference linkTypeRef, ModelElementReference modelElemTypeRef, boolean isBinarySrc) throws MMINTException {

		ModelElementEndpointReference oldModelElemTypeEndpointRef = (isBinarySrc) ?
			linkTypeRef.getModelElemEndpointRefs().get(0) :
			linkTypeRef.getModelElemEndpointRefs().get(1);
		ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(linkTypeRef, modelElemTypeRef);
		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), linkTypeRef.getModelElemEndpointRefs());
		modelElemTypeEndpoint.replaceSubtypeAndReference(oldModelElemTypeEndpointRef, modelElemTypeEndpointRef, oldModelElemTypeEndpointRef.getObject().getName(), modelElemTypeRef, linkTypeRef);
		// no need to init type hierarchy, no need for undo/redo
	}

	/**
	 * Changes the source model element reference of a binary link.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getLink(), getNewSource(), true);
			}
			else {
				doExecuteTypesLevel(getLink(), getNewSource(), true);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MidDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(Type.ERROR, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

	/**
	 * Changes the target model element reference of a binary link.
	 * 
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			if (MultiModelConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getLink(), getNewTarget(), false);
			}
			else {
				doExecuteTypesLevel(getLink(), getNewTarget(), false);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MidDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(Type.ERROR, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

}
