/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.RelationshipDiagramUtils;

/**
 * The command to create a binary link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryLinkReferenceNewBinaryLinkCommand extends BinaryLinkReferenceCreateCommand {

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
	public BinaryLinkReferenceNewBinaryLinkCommand(CreateRelationshipRequest request,
			EObject source, EObject target) {

		super(request, source, target);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = (MultiModel) getContainer().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = (MultiModel) getContainer().eContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMTF.createTypeHierarchy(multiModel);
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

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel(getContainer()) ||
				!MultiModelTypeHierarchy.isRootType(getContainer())
			);
	}

	protected BinaryLinkReference doExecuteInstancesLevel() throws MMTFException {

		ModelRel modelRel = getContainer();
		LinkReference linkTypeRef = RelationshipDiagramUtils.selectLinkTypeReferenceToCreate(modelRel, getSource(), getTarget());
		BinaryLinkReference newLinkRef = (BinaryLinkReference) linkTypeRef.getObject().createInstanceAndReference(true, modelRel);

		List<String> modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, getSource());
		ModelElementEndpointReference modelElemTypeEndpointRef = RelationshipDiagramUtils.selectModelElementTypeEndpointToCreate(newLinkRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getSource(), false, newLinkRef);
		modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, getTarget());
		modelElemTypeEndpointRef = RelationshipDiagramUtils.selectModelElementTypeEndpointToCreate(newLinkRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), false, newLinkRef);

		return newLinkRef;
	}

	protected BinaryLinkReference doExecuteTypesLevel() throws MMTFException {

		ModelRel modelRelType = getContainer();
		LinkReference linkTypeRef = RelationshipDiagramUtils.selectLinkTypeReferenceToExtend(modelRelType, getSource(), getTarget());
		String newLinkTypeName = RelationshipDiagramUtils.getStringInput("Create new light link type", "Insert new link type name", null);
		BinaryLinkReference newLinkTypeRef = (BinaryLinkReference) linkTypeRef.getObject().createSubtypeAndReference(linkTypeRef, newLinkTypeName, true, modelRelType);
		MMTF.createTypeHierarchy(MultiModelRegistry.getMultiModel(modelRelType));

		String newModelElemTypeEndpointName = RelationshipDiagramUtils.getStringInput("Create new source model element type endpoint", "Insert new source model element type endpoint role", null);
		ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(newLinkTypeRef, getSource());
		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRef.getModelElemEndpointRefs());
		modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, newModelElemTypeEndpointName, getSource(), false, newLinkTypeRef);
		newModelElemTypeEndpointName = RelationshipDiagramUtils.getStringInput("Create new target model element type endpoint", "Insert new target model element type endpoint role", null);
		modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(newLinkTypeRef, getTarget());
		modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRef.getModelElemEndpointRefs());
		modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, newModelElemTypeEndpointName, getTarget(), false, newLinkTypeRef);

		return newLinkTypeRef;
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
			BinaryLinkReference newElement = MultiModelConstraintChecker.isInstancesLevel(getContainer()) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (MMTFException e) {
			MMTFException.print(MMTFException.Type.WARNING, "No binary link created", e);
			return CommandResult.newErrorCommandResult("No binary link created");
		}
	}

}
