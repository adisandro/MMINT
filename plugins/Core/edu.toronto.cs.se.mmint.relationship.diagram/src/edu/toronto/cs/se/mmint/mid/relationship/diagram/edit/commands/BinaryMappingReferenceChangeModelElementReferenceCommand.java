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
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogUtils;
import edu.toronto.cs.se.mmint.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to change a model element reference of a binary mapping link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingReferenceChangeModelElementReferenceCommand extends BinaryMappingReferenceReorientCommand {

	private List<String> modelElemTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public BinaryMappingReferenceChangeModelElementReferenceCommand(ReorientRelationshipRequest request) {

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

		BinaryMappingReference mappingRef = getLink();
		return super.canExecute() && (
			mappingRef.isInstancesLevel() ||
			(mappingRef.isTypesLevel() && !MIDTypeHierarchy.isRootType(mappingRef.getObject()))
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

		BinaryMappingReference mappingRef = getLink();
		return
			super.canReorientSource() && ((
				mappingRef.isInstancesLevel() &&
				(modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(mappingRef, mappingRef.getModelElemEndpointRefs().get(0), getNewSource())) != null
			) || (
				mappingRef.isTypesLevel() &&
				MIDConstraintChecker.isAllowedModelElementTypeEndpointReference(mappingRef, getNewSource(), null)
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

		BinaryMappingReference mappingRef = getLink();
		return
			super.canReorientTarget() && ((
				mappingRef.isInstancesLevel() &&
				(modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(mappingRef, mappingRef.getModelElemEndpointRefs().get(1), getNewTarget())) != null
			) || (
				mappingRef.isTypesLevel() &&
				MIDConstraintChecker.isAllowedModelElementTypeEndpointReference(mappingRef, null, getNewTarget())
			));
	}

	protected void doExecuteTypesLevel(BinaryMappingReference containerMappingTypeRef, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc) throws MMINTException, MIDDialogCancellation {

		boolean wasOverriding = false;
		ModelElementEndpointReference oldModelElemTypeEndpointRef = null;
		if (containerMappingTypeRef.getModelElemEndpointRefs().size() == 2) {
			oldModelElemTypeEndpointRef = (isBinarySrc) ?
				containerMappingTypeRef.getModelElemEndpointRefs().get(0) :
				containerMappingTypeRef.getModelElemEndpointRefs().get(1);
			wasOverriding = true;
		}
		else if (containerMappingTypeRef.getModelElemEndpointRefs().size() == 1) {
			ModelElementEndpointReference singleModelElemTypeEndpointRef = containerMappingTypeRef.getModelElemEndpointRefs().get(0);
			wasOverriding = (isBinarySrc) ?
				(containerMappingTypeRef.getSourceModelElemRef() == singleModelElemTypeEndpointRef.getModelElemRef()) :
				(containerMappingTypeRef.getTargetModelElemRef() == singleModelElemTypeEndpointRef.getModelElemRef());
			if (wasOverriding) {
				oldModelElemTypeEndpointRef = singleModelElemTypeEndpointRef;
			}
		}

		ModelElementEndpoint modelElemTypeEndpoint = MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(containerMappingTypeRef, targetModelElemTypeRef);
		if (modelElemTypeEndpoint == null) {
			if (wasOverriding) { // was overriding, becomes non-overriding
				oldModelElemTypeEndpointRef.deleteTypeAndReference(true);
			}
			// was overriding, becomes non-overriding
			// was non-overriding, remains non-overriding
			containerMappingTypeRef.addModelElementTypeReference(targetModelElemTypeRef, isBinarySrc);
		}
		else {
			if (wasOverriding) { // was overriding, remains overriding
				modelElemTypeEndpoint.replaceSubtypeAndReference(oldModelElemTypeEndpointRef, oldModelElemTypeEndpointRef.getObject().getName(), targetModelElemTypeRef);
			}
			else { // was non-overriding, becomes overriding
				String detail = (isBinarySrc) ? "source" : "target";
				String newModelElemTypeEndpointName = MIDDialogUtils.getStringInput("Create new " + detail + " model element type endpoint", "Insert new " + detail + " model element type endpoint role", targetModelElemTypeRef.getObject().getName());
				if (isBinarySrc && containerMappingTypeRef.getModelElemEndpointRefs().size() == 1) { // guarantee that src endpoint comes before tgt endpoint
					ModelElementEndpointReference tgtModelElemTypeEndpointRef = containerMappingTypeRef.getModelElemEndpointRefs().get(0);
					tgtModelElemTypeEndpointRef.deleteTypeAndReference(true);
					modelElemTypeEndpoint.createSubtypeAndReference(newModelElemTypeEndpointName, targetModelElemTypeRef, true, containerMappingTypeRef);
					tgtModelElemTypeEndpointRef.getObject().getSupertype().createSubtypeAndReference(tgtModelElemTypeEndpointRef.getObject().getName(), tgtModelElemTypeEndpointRef.getModelElemRef(), false, containerMappingTypeRef);
				}
				else {
					modelElemTypeEndpoint.createSubtypeAndReference(newModelElemTypeEndpointName, targetModelElemTypeRef, isBinarySrc, containerMappingTypeRef);
				}
			}
		}
		// no need to init type hierarchy, no need for undo/redo
	}

	protected void doExecuteInstancesLevel(BinaryMappingReference containerMappingRef, ModelElementReference targetModelElemRef, boolean isBinarySrc) throws MMINTException, MIDDialogCancellation {

		ModelElementEndpointReference oldModelElemEndpointRef = (isBinarySrc) ?
			containerMappingRef.getModelElemEndpointRefs().get(0) :
			containerMappingRef.getModelElemEndpointRefs().get(1);
		ModelElementEndpointReference modelElemTypeEndpointRef = MIDDialogUtils.selectModelElementTypeEndpointToCreate(containerMappingRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().replaceInstanceAndReference(oldModelElemEndpointRef, targetModelElemRef);
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
			switch (getLink().getObject().getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(getLink(), getNewSource(), true);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(getLink(), getNewSource(), true);
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
			switch (getLink().getObject().getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(getLink(), getNewTarget(), false);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(getLink(), getNewTarget(), false);
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

}
