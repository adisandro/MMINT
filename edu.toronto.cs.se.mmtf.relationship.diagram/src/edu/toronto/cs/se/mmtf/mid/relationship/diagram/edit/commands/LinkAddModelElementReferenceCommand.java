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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The command to add a model element reference to a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkAddModelElementReferenceCommand extends LinkElementRefsCreateCommand {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source link.
	 * @param target
	 *            The target model element reference.
	 */
	public LinkAddModelElementReferenceCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	/**
	 * Checks if a model element reference can be added.
	 * 
	 * @return True if a model element reference can be added, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel((ModelRel) getSource().eContainer());

		return
			super.canExecute() && (
				(instance && MultiModelConstraintChecker.isAllowedModelElementReference(getSource(), getTarget())) ||
				(!instance && MultiModelConstraintChecker.isAllowedModelElementTypeReference(getSource()))
			);
	}

	protected void doExecuteTypesLevel() {

		MMTFRegistry.updateRepository((MultiModel) getSource().eContainer().eContainer());
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		if (getSource() != null && getTarget() != null) {
			getSource().getElementRefs().add(getTarget());
			if (!MultiModelConstraintChecker.isInstancesLevel((ModelRel) getSource().eContainer())) {
				doExecuteTypesLevel();
			}
		}

		return CommandResult.newOKCommandResult();
	}

}
