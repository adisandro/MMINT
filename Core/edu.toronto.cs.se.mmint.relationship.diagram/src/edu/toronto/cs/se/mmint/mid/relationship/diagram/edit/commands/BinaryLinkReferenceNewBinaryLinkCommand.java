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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.BinaryLinkReferenceCreateCommand;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;

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
			MMINT.createTypeHierarchy(multiModel);
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
			MMINT.createTypeHierarchy(multiModel);
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

	protected BinaryLinkReference doExecuteInstancesLevel() throws MMINTException, MultiModelDialogCancellation {

		ModelRel modelRel = getContainer();
		LinkReference linkTypeRef = MultiModelDiagramUtils.selectLinkTypeReferenceToCreate(modelRel, getSource(), getTarget());
		BinaryLinkReference newLinkRef = (BinaryLinkReference) linkTypeRef.getObject().createInstanceAndReference(true, modelRel);

		List<String> modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, getSource());
		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelDiagramUtils.selectModelElementTypeEndpointToCreate(newLinkRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getSource(), false, newLinkRef);
		modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(newLinkRef, getTarget());
		modelElemTypeEndpointRef = MultiModelDiagramUtils.selectModelElementTypeEndpointToCreate(newLinkRef, modelElemTypeEndpointUris);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), false, newLinkRef);

		return newLinkRef;
	}

	protected BinaryLinkReference doExecuteTypesLevel() throws MMINTException, MultiModelDialogCancellation {

		ModelRel modelRelType = getContainer();
		ModelElementReference srcModelElemTypeRef = getSource(), tgtModelElemTypeRef = getTarget();
		LinkReference linkTypeRef = MultiModelDiagramUtils.selectLinkTypeReferenceToExtend(modelRelType, srcModelElemTypeRef, tgtModelElemTypeRef);
		String newLinkTypeName = MultiModelDiagramUtils.getStringInput("Create new light link type", "Insert new link type name", srcModelElemTypeRef.getObject().getName() + MMINT.BINARY_MODELREL_LINK_SEPARATOR + tgtModelElemTypeRef.getObject().getName());
		BinaryLinkReference newLinkTypeRef = (BinaryLinkReference) linkTypeRef.getObject().createSubtypeAndReference(linkTypeRef, newLinkTypeName, true, modelRelType);
		MMINT.createTypeHierarchy(MultiModelRegistry.getMultiModel(modelRelType));

		String newModelElemTypeEndpointName = MultiModelDiagramUtils.getStringInput("Create new source model element type endpoint", "Insert new source model element type endpoint role", srcModelElemTypeRef.getObject().getName());
		ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(newLinkTypeRef, srcModelElemTypeRef);
		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRef.getModelElemEndpointRefs());
		modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, newModelElemTypeEndpointName, srcModelElemTypeRef, false, newLinkTypeRef);
		newModelElemTypeEndpointName = MultiModelDiagramUtils.getStringInput("Create new target model element type endpoint", "Insert new target model element type endpoint role", tgtModelElemTypeRef.getObject().getName());
		modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(newLinkTypeRef, tgtModelElemTypeRef);
		modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRef.getModelElemEndpointRefs());
		modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, newModelElemTypeEndpointName, tgtModelElemTypeRef, false, newLinkTypeRef);

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
		catch (MultiModelDialogCancellation e) {
			return CommandResult.newCancelledCommandResult();
		}
		catch (MMINTException e) {
			MMINTException.print(Type.ERROR, "No binary link created", e);
			return CommandResult.newErrorCommandResult("No binary link created");
		}
	}

}
