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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to create a binary link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryMappingReferenceNewBinaryMappingCommand extends BinaryMappingReferenceCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param req
	 *            The request.
	 * @param source
	 *            The source model element reference.
	 * @param target
	 *            The target model element reference.
	 */
	public BinaryMappingReferenceNewBinaryMappingCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {

		super(request, source, target);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MID mid = ((ModelRel) getContainer()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MID mid = ((ModelRel) getContainer()).getMIDContainer();
		if (mid.isTypesLevel()) {
			MMINT.createTypeHierarchy(mid);
		}

		return status;
    }

	/**
	 * Checks if a binary link can be created.
	 * 
	 * @return True if a binary link can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelRel modelRel = getContainer();
		return super.canExecute() && (
			modelRel.isInstancesLevel() ||
			(modelRel.isTypesLevel() && !MIDTypeHierarchy.isRootType(getContainer()))
		);
	}

	protected BinaryMappingReference doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		ModelRel modelRelType = getContainer();
		ModelElementReference srcModelElemTypeRef = getSource(), tgtModelElemTypeRef = getTarget();
		MappingReference mappingTypeRef = MIDDialogs.selectMappingTypeReferenceToExtend(modelRelType, srcModelElemTypeRef, tgtModelElemTypeRef);
		String newMappingTypeName = MIDDialogs.getStringInput("Create new light mapping type", "Insert new mapping type name", srcModelElemTypeRef.getObject().getName() + MMINT.BINARY_MODELREL_MAPPING_SEPARATOR + tgtModelElemTypeRef.getObject().getName());
		BinaryMappingReference newMappingTypeRef = (BinaryMappingReference) mappingTypeRef.getObject().createSubtypeAndReference(mappingTypeRef, newMappingTypeName, true, modelRelType);
		MMINT.createTypeHierarchy(modelRelType.getMIDContainer());

		String newModelElemTypeEndpointName;
		ModelElementEndpoint modelElemTypeEndpoint = MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(newMappingTypeRef, srcModelElemTypeRef);
		if (modelElemTypeEndpoint == null) {
			newMappingTypeRef.addModelElementTypeReference(srcModelElemTypeRef, true);
		}
		else {
			newModelElemTypeEndpointName = MIDDialogs.getStringInput("Create new source model element type endpoint", "Insert new source model element type endpoint role", srcModelElemTypeRef.getObject().getName());
			modelElemTypeEndpoint.createSubtypeAndReference(newModelElemTypeEndpointName, srcModelElemTypeRef, true, newMappingTypeRef);
		}

		modelElemTypeEndpoint = MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(newMappingTypeRef, tgtModelElemTypeRef);
		if (modelElemTypeEndpoint == null) {
			newMappingTypeRef.addModelElementTypeReference(tgtModelElemTypeRef, false);
		}
		else {
			newModelElemTypeEndpointName = MIDDialogs.getStringInput("Create new target model element type endpoint", "Insert new target model element type endpoint role", tgtModelElemTypeRef.getObject().getName());
			modelElemTypeEndpoint.createSubtypeAndReference(newModelElemTypeEndpointName, tgtModelElemTypeRef, false, newMappingTypeRef);
		}

		return newMappingTypeRef;
	}

	protected BinaryMappingReference doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		ModelRel modelRel = getContainer();
		MappingReference mappingTypeRef = MIDDialogs.selectMappingTypeReferenceToCreate(modelRel, getSource(), getTarget());
		BinaryMappingReference newMappingRef = (BinaryMappingReference) mappingTypeRef.getObject().createInstanceAndReference(true, modelRel);

		List<String> modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(newMappingRef, null, getSource());
		ModelElementEndpointReference modelElemTypeEndpointRef = MIDDialogs.selectModelElementTypeEndpointToCreate(newMappingRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getSource(), newMappingRef);
		modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(newMappingRef, null, getTarget());
		modelElemTypeEndpointRef = MIDDialogs.selectModelElementTypeEndpointToCreate(newMappingRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), newMappingRef);

		return newMappingRef;
	}

	/**
	 * Creates a new binary link.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             If this command can't be executed.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		try {
			BinaryMappingReference newElement;
			switch (getContainer().getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					newElement = this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
			}
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (MIDDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "No binary link created", e);
			return CommandResult.newErrorCommandResult("No binary link created");
		}
	}

}
