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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;

/**
 * The command to remove a model from a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelRemoveModelCommand extends DestroyReferenceCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 */
	public ModelRelRemoveModelCommand(DestroyReferenceRequest request) {

		super(request);
	}

	/**
	 * Checks if a model can be removed.
	 * 
	 * @return True if a model can be removed, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((ModelRel) getContainer()) ||
				//TODO MMTF: What are the semantics of subtypes here?
				//TODO MMTF: This is causing n-ary modelrels with subtypes to not delete properly
				MultiModelConstraintChecker.isAllowedModelType((ModelRel) getContainer())
			);
	}

	protected CommandResult doExecuteInstancesLevel(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		MultiModelInstanceFactory.removeModelReference((ModelRel) getContainer(), (Model) getReferencedObject());

		return super.doExecuteWithResult(monitor, info);
	}

	protected CommandResult doExecuteTypesLevel(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		MultiModelTypeFactory.removeLightModelTypeRef((ModelRel) getContainer(), (Model) getReferencedObject());
		CommandResult result = super.doExecuteWithResult(monitor, info);

		return result;
	}

	/**
	 * Removes a model from a model relationship.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		return (MultiModelConstraintChecker.isInstancesLevel((ModelRel) getContainer())) ?
			doExecuteInstancesLevel(monitor, info) :
			doExecuteTypesLevel(monitor, info);
	}

}
