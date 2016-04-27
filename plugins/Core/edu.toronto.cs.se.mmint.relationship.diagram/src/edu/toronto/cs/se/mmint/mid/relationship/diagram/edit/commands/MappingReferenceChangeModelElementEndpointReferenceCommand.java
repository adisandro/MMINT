/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to change a model element reference of a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingReferenceChangeModelElementEndpointReferenceCommand extends ModelElementEndpointReferenceReorientCommand {

	private List<String> modelElemTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public MappingReferenceChangeModelElementEndpointReferenceCommand(ReorientRelationshipRequest request) {

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
				MIDConstraintChecker.isInstancesLevel(getLink()) ||
				!MIDTypeHierarchy.isRootType(getLink().getObject())
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
				!MIDConstraintChecker.isInstancesLevel(getLink()) ||
				(modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(getNewSource(), null, getLink().getModelElemRef())) != null
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
				!MIDConstraintChecker.isInstancesLevel(getLink()) ||
				(modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences((MappingReference) getLink().eContainer(), getLink(), getNewTarget())) != null
			);
	}

	protected void doExecuteInstancesLevel(MappingReference mappingRef, ModelElementReference modelElemRef, boolean isFullDelete) throws MMINTException, MIDDialogCancellation {

		ModelElementEndpointReference modelElemTypeEndpointRef = MIDDialogUtils.selectModelElementTypeEndpointToCreate(mappingRef, modelElemTypeEndpointUris);
		if (isFullDelete) {
			getLink().deleteInstanceAndReference(isFullDelete);
			modelElemTypeEndpointRef.getObject().createInstanceAndReference(modelElemRef, mappingRef);
		}
		else {
			modelElemTypeEndpointRef.getObject().replaceInstanceAndReference(getLink(), modelElemRef);
		}
	}

	protected void doExecuteTypesLevel(MappingReference mappingTypeRef, ModelElementReference modelElemTypeRef, boolean isFullDelete) throws MMINTException {

		ModelElementEndpoint modelElemTypeEndpoint = MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(mappingTypeRef, modelElemTypeRef);
		if (isFullDelete) {
			getLink().deleteTypeAndReference(isFullDelete);
			modelElemTypeEndpoint.createSubtypeAndReference(getLink().getObject().getName(), modelElemTypeRef, false, mappingTypeRef);
		}
		else {
			modelElemTypeEndpoint.replaceSubtypeAndReference(getLink(), getLink().getObject().getName(), modelElemTypeRef);
		}
		// no need to init type hierarchy, no need for undo/redo
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			if (MIDConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel(getNewSource(), getLink().getModelElemRef(), true);
			}
			else {
				doExecuteTypesLevel(getNewSource(), getLink().getModelElemRef(), true);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {

		try {
			if (MIDConstraintChecker.isInstancesLevel(getLink())) {
				doExecuteInstancesLevel((MappingReference) getLink().eContainer(), getNewTarget(), false);
			}
			else {
				doExecuteTypesLevel((MappingReference) getLink().eContainer(), getNewTarget(), false);
			}

			return CommandResult.newOKCommandResult(getLink());
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No model element endpoint changed", e);
			return CommandResult.newErrorCommandResult("No model element endpoint changed");
		}
	}

}