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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The command to remove a model element reference from a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkRemoveModelElementReferenceCommand extends DestroyReferenceCommand {

	public LinkRemoveModelElementReferenceCommand(DestroyReferenceRequest request) {

		super(request);
	}

	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((ModelRel) getContainer().eContainer()) ||
				MultiModelConstraintChecker.isAllowedModelElementTypeReference((Link) getContainer())
			);
	}

	protected CommandResult doExecuteInstancesLevel(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		return super.doExecuteWithResult(monitor, info);
	}

	protected CommandResult doExecuteTypesLevel(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		MultiModel multiModel = (MultiModel) getContainer().eContainer().eContainer();
		CommandResult result = super.doExecuteWithResult(monitor, info);
		MMTFRegistry.syncRepository(multiModel);

		return result;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		return (MultiModelConstraintChecker.isInstancesLevel((ModelRel) getContainer().eContainer())) ?
			doExecuteInstancesLevel(monitor, info) :
			doExecuteTypesLevel(monitor, info);
	}

}
