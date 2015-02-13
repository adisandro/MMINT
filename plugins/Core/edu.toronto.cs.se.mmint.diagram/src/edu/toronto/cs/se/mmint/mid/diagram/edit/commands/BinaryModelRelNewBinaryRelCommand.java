/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.commands;

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
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;

/**
 * The command to create a binary model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class BinaryModelRelNewBinaryRelCommand extends BinaryModelRelCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model.
	 * @param target
	 *            The target model.
	 */
	public BinaryModelRelNewBinaryRelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doUndo(monitor, info);
		MultiModel multiModel = getContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
		}

		return status;
    }

    /**
     * Overrides superclass to re-initialize diagram type hierarchy.
     */
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IStatus status = super.doRedo(monitor, info);
		MultiModel multiModel = getContainer();
		if (!MultiModelConstraintChecker.isInstancesLevel(multiModel)) {
			MMINT.createTypeHierarchy(multiModel);
		}

		return status;
    }

	/**
	 * Checks if a binary model relationship can be created.
	 * 
	 * @return True if a binary model relationship can be created, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((MultiModel) getContainer()) || (
					!MultiModelTypeHierarchy.isRootType(getSource()) &&
					(getTarget() == null || !MultiModelTypeHierarchy.isRootType(getTarget()))
				)
			);
	}

	protected BinaryModelRel doExecuteInstancesLevel() throws MMINTException, MultiModelDialogCancellation {

		MultiModel multiModel = getContainer();
		ModelRel modelRelType = MultiModelDiagramUtils.selectModelRelTypeToCreate(getSource(), getTarget());
		BinaryModelRel newModelRel = (BinaryModelRel) modelRelType.createInstance(null, true, ModelOrigin.CREATED, multiModel);

		List<String> modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getSource());
		ModelEndpointReference modelTypeEndpointRef = MultiModelDiagramUtils.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "src ");
		modelTypeEndpointRef.getObject().createInstanceAndReference(getSource(), newModelRel);
		modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, null, getTarget());
		modelTypeEndpointRef = MultiModelDiagramUtils.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "tgt ");
		modelTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), newModelRel);

		return newModelRel;
	}

	protected BinaryModelRel doExecuteTypesLevel() throws MMINTException, MultiModelDialogCancellation {

		MultiModel multiModel = getContainer();
		Model srcModelType = getSource(), tgtModelType = getTarget();
		ModelRel modelRelType = MultiModelDiagramUtils.selectModelRelTypeToExtend(multiModel, srcModelType, tgtModelType);
		String newModelRelTypeName = MultiModelDiagramUtils.getStringInput("Create new light binary model relationship type", "Insert new binary model relationship type name", srcModelType.getName() + MMINT.BINARY_MODELREL_LINK_SEPARATOR + tgtModelType.getName());
		String[] constraint = MultiModelDiagramUtils.getConstraintInput("Create new light binary model relationship type", null);
		BinaryModelRel newModelRelType = (BinaryModelRel) modelRelType.createSubtype(newModelRelTypeName, true, constraint[0], constraint[1]);
		MMINT.createTypeHierarchy(multiModel);

		String newModelTypeEndpointName;
		ModelEndpoint modelTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(newModelRelType, srcModelType);
		if (modelTypeEndpoint == null) {
			newModelRelType.addModelType(srcModelType, true);
		}
		else {
			newModelTypeEndpointName = MultiModelDiagramUtils.getStringInput("Create new source model type endpoint", "Insert new source model type endpoint role", srcModelType.getName());
			modelTypeEndpoint.createSubtypeAndReference(newModelTypeEndpointName, srcModelType, true, newModelRelType);
		}

		modelTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelTypeEndpoint(newModelRelType, tgtModelType);
		if (modelTypeEndpoint == null) {
			newModelRelType.addModelType(tgtModelType, false);
		}
		else {
			newModelTypeEndpointName = MultiModelDiagramUtils.getStringInput("Create new target model type endpoint", "Insert new target model type endpoint role", tgtModelType.getName());
			modelTypeEndpoint.createSubtypeAndReference(newModelTypeEndpointName, tgtModelType, false, newModelRelType);
		}

		return newModelRelType;
	}

	/**
	 * Creates a new binary model relationship.
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
			BinaryModelRel newElement = (MultiModelConstraintChecker.isInstancesLevel(getContainer())) ?
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
			MMINTException.print(IStatus.ERROR, "No binary model relationship created", e);
			return CommandResult.newErrorCommandResult("No binary model relationship created");
		}
	}

}
