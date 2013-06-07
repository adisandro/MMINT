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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

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
import edu.toronto.cs.se.mmtf.MultiModelLightTypeFactory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

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
			MMTF.initTypeHierarchy(multiModel);
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
			MMTF.initTypeHierarchy(multiModel);
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
					!MultiModelConstraintChecker.isRootType(getSource()) &&
					!MultiModelConstraintChecker.isRootType(getTarget())
				)
			);
	}

	protected BinaryModelRel doExecuteInstancesLevel() throws Exception {

		MultiModel multiModel = getContainer();
		ModelRel modelRelType = MidDiagramUtils.selectModelRelTypeToCreate(getSource(), getTarget());
		BinaryModelRel newModelRel = (BinaryModelRel) MultiModelInstanceFactory.createModelRel(
			modelRelType,
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);

		List<String> modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, getSource());
		ModelEndpointReference modelTypeEndpointRef = MidDiagramUtils.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "src ");
		MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			modelTypeEndpointRef.getObject(),
			newModelRel,
			getSource(),
			false
		);
		modelTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelEndpoints(newModelRel, getTarget());
		modelTypeEndpointRef = MidDiagramUtils.selectModelTypeEndpointToCreate(newModelRel, modelTypeEndpointUris, "tgt ");
		MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			modelTypeEndpointRef.getObject(),
			newModelRel,
			getTarget(),
			false
		);

		return newModelRel;
	}

	protected BinaryModelRel doExecuteTypesLevel() throws MMTFException {

		MultiModel multiModel = getContainer();
		ModelRel modelRelType = MidDiagramUtils.selectModelRelTypeToExtend(multiModel, getSource(), getTarget());
		String newModelRelTypeName = MidDiagramUtils.getStringInput("Create new light binary model relationship type", "Insert new binary model relationship type name");
		String constraint = MidDiagramUtils.getBigStringInput("Create new light binary model relationship type", "Insert new binary model relationship type constraint");
		BinaryModelRel newModelRelType = (BinaryModelRel) MultiModelLightTypeFactory.createLightModelRelType(
			modelRelType,
			newModelRelTypeName,
			constraint,
			RelationshipPackage.eINSTANCE.getBinaryModelRel()
		);
		MMTF.initTypeHierarchy(multiModel);

		String newModelTypeEndpointName = MidDiagramUtils.getStringInput("Create new source model type endpoint", "Insert new source model type endpoint role");
		//TODO MMTF: search for override (only if we're not inheriting from a root type)
		ModelEndpointReference modelTypeEndpointRef = null;
		ModelEndpoint modelTypeEndpoint = (modelTypeEndpointRef == null) ? null : modelTypeEndpointRef.getObject();
		MultiModelLightTypeFactory.createLightModelTypeEndpointAndModelTypeEndpointReference(
			newModelRelType,
			modelTypeEndpoint,
			modelTypeEndpointRef,
			getSource(),
			newModelTypeEndpointName,
			false
		);
		newModelTypeEndpointName = MidDiagramUtils.getStringInput("Create new target model type endpoint", "Insert new target model type endpoint role");
		//TODO MMTF: search for override (only if we're not inheriting from a root type)
		modelTypeEndpointRef = null;
		modelTypeEndpoint = (modelTypeEndpointRef == null) ? null : modelTypeEndpointRef.getObject();
		MultiModelLightTypeFactory.createLightModelTypeEndpointAndModelTypeEndpointReference(
			newModelRelType,
			modelTypeEndpoint,
			modelTypeEndpointRef,
			getTarget(),
			newModelTypeEndpointName,
			false
		);

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
			BinaryModelRel newElement = (MultiModelConstraintChecker.isInstancesLevel((MultiModel) getContainer())) ?
				doExecuteInstancesLevel() :
				doExecuteTypesLevel();
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);
	
			return CommandResult.newOKCommandResult(newElement);
		}
		catch (ExecutionException ee) {
			throw ee;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No binary model relationship created", e);
			return CommandResult.newErrorCommandResult("No binary model relationship created");
		}
	}

}
