/*
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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;

/**
 * The command to remove a model element reference from a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkReferenceRemoveModelElementEndpointReferenceCommand extends DestroyElementCommand {

	public LinkReferenceRemoveModelElementEndpointReferenceCommand(DestroyElementRequest request) {

		super(request);
	}

	@Override
	public boolean canExecute() {

		return
			super.canExecute() && (
				MultiModelConstraintChecker.isInstancesLevel((LinkReference) getElementToEdit()) ||
				!MultiModelConstraintChecker.isRootType((ModelElementEndpointReference) getElementToDestroy())
			);
	}

	protected void doExecuteInstancesLevel() {

		MultiModelInstanceFactory.removeModelElementEndpointAndModelElementEndpointReference((ModelElementEndpointReference) getElementToDestroy(), true);
	}

	protected void doExecuteTypesLevel() {

		MultiModelTypeFactory.removeModelElementTypeEndpointAndModelElementTypeEndpointReference((ModelElementEndpointReference) getElementToDestroy(), true);
		// no need to init type hierarchy, no need for undo/redo
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (MultiModelConstraintChecker.isInstancesLevel((LinkReference) getElementToEdit())) {
			doExecuteInstancesLevel();
		}
		else {
			doExecuteTypesLevel();
		}

		return super.doExecuteWithResult(monitor, info);
	}

}
