/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
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

		ModelElementEndpointReference modelElemEndpointRef = getLink();
		return super.canExecute() && (
			modelElemEndpointRef.isInstancesLevel() ||
			(modelElemEndpointRef.isTypesLevel() && !MIDTypeHierarchy.isRootType(getLink().getObject()))
		);
	}

	/**
	 * Checks if the source link can be changed.
	 * 
	 * @return True if the source link can be changed, false otherwise.
	 */
	@Override
	protected boolean canReorientSource() {

		ModelElementEndpointReference modelElemEndpointRef = getLink();
		return super.canReorientSource() && (
			modelElemEndpointRef.isTypesLevel() ||
			(modelElemEndpointRef.isInstancesLevel() && (modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(getNewSource(), null, getLink().getModelElemRef())) != null)
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

		ModelElementEndpointReference modelElemEndpointRef = getLink();
		return super.canReorientTarget() && (
			modelElemEndpointRef.isTypesLevel() ||
			(modelElemEndpointRef.isInstancesLevel() && (modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences((MappingReference) getLink().eContainer(), getLink(), getNewTarget())) != null)
		);
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

	protected void doExecuteInstancesLevel(MappingReference mappingRef, ModelElementReference modelElemRef, boolean isFullDelete) throws MMINTException, MIDDialogCancellation {

		ModelElementEndpointReference modelElemTypeEndpointRef = MIDDialogs.selectModelElementTypeEndpointToCreate(mappingRef, modelElemTypeEndpointUris);
		if (isFullDelete) {
			getLink().deleteInstanceAndReference(isFullDelete);
			modelElemTypeEndpointRef.getObject().createInstanceAndReference(modelElemRef, mappingRef);
		}
		else {
			modelElemTypeEndpointRef.getObject().replaceInstanceAndReference(getLink(), modelElemRef);
		}
	}

	@Override
	protected CommandResult reorientSource() throws ExecutionException {

		try {
			switch (getLink().getObject().getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(getNewSource(), getLink().getModelElemRef(), true);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(getNewSource(), getLink().getModelElemRef(), true);
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
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
			if (getLink().isInstancesLevel()) {
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
