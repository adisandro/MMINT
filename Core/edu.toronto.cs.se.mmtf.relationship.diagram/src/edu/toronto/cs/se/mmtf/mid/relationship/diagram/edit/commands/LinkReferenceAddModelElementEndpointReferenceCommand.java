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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.library.RelationshipDiagramUtils;

/**
 * The command to add a model element reference to a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class LinkReferenceAddModelElementEndpointReferenceCommand extends ModelElementEndpointReferenceCreateCommand {

	private List<String> modelElemTypeEndpointUris;

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
	public LinkReferenceAddModelElementEndpointReferenceCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
		modelElemTypeEndpointUris = null;
	}

	/**
	 * Checks if a model element reference can be added.
	 * 
	 * @return True if a model element reference can be added, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		boolean instance = MultiModelConstraintChecker.isInstancesLevel(getSource());

		return
			super.canExecute() && ((
				instance &&
				(modelElemTypeEndpointUris = MultiModelConstraintChecker.getAllowedModelElementEndpointReferences(getSource(), getTarget())) != null
			) || (
				!instance &&
				!MultiModelTypeHierarchy.isRootType(getSource().getObject()) &&
				(getTarget() == null || !MultiModelTypeHierarchy.isRootType(getTarget().getObject()))
			));
	}

	protected ModelElementEndpointReference doExecuteInstancesLevel() throws MMTFException {

		ModelElementEndpointReference modelElemTypeEndpointRef = RelationshipDiagramUtils.selectModelElementTypeEndpointToCreate(getSource(), modelElemTypeEndpointUris);
		ModelElementEndpointReference newModelElemEndpointRef = modelElemTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), false, getSource());

		return newModelElemEndpointRef;
	}

	protected ModelElementEndpointReference doExecuteTypesLevel() throws MMTFException {

		String newModelElemTypeEndpointName = RelationshipDiagramUtils.getStringInput("Create new light model element type endpoint", "Insert new model element type endpoint role", null);
		ModelElementEndpoint modelElemTypeEndpoint = MultiModelTypeHierarchy.getOverriddenModelElementTypeEndpoint(getSource(), getTarget());
		ModelElementEndpointReference modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), getSource().getModelElemEndpointRefs());
		ModelElementEndpointReference newModelElemTypeEndpointRef = modelElemTypeEndpoint.createSubtypeAndReference(modelElemTypeEndpointRef, newModelElemTypeEndpointName, getTarget(), false, getSource());
		// no need to init type hierarchy, no need for undo/redo

		return newModelElemTypeEndpointRef;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			if (!canExecute()) {
				throw new ExecutionException("Invalid arguments in create link command");
			}
			ModelElementEndpointReference newElement = (MultiModelConstraintChecker.isInstancesLevel(getSource())) ?
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
			MMTFException.print(MMTFException.Type.WARNING, "No model element endpoint created", e);
			return CommandResult.newErrorCommandResult("No model element endpoint created");
		}
	}

}
