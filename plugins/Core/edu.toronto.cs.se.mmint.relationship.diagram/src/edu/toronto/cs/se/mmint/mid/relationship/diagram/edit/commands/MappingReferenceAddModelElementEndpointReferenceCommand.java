/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to add a model element reference to a link.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingReferenceAddModelElementEndpointReferenceCommand extends ModelElementEndpointReferenceCreateCommand {

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
	public MappingReferenceAddModelElementEndpointReferenceCommand(CreateRelationshipRequest request, EObject source, EObject target) {

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

		MappingReference mappingRef = getSource();
		return super.canExecute() && ((
			mappingRef.isInstancesLevel() &&
			(modelElemTypeEndpointUris = MIDConstraintChecker.getAllowedModelElementEndpointReferences(getSource(), null, getTarget())) != null
		) || (
			mappingRef.isTypesLevel() &&
			!MIDTypeHierarchy.isRootType(getSource().getObject()) &&
			(getTarget() == null || !MIDTypeHierarchy.isRootType(getTarget().getObject()))
		));
	}

	protected ModelElementEndpointReference doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		ModelElementReference tgtModelElemTypeRef = getTarget();
		String newModelElemTypeEndpointName = MIDDialogs.getStringInput("Create new light model element type endpoint", "Insert new model element type endpoint role", tgtModelElemTypeRef.getObject().getName());
		ModelElementEndpoint modelElemTypeEndpoint = MIDTypeHierarchy.getOverriddenModelElementTypeEndpoint(getSource(), tgtModelElemTypeRef);
		ModelElementEndpointReference newModelElemTypeEndpointRef = modelElemTypeEndpoint.createSubtypeAndReference(newModelElemTypeEndpointName, tgtModelElemTypeRef, false, getSource());
		// no need to init type hierarchy, no need for undo/redo

		return newModelElemTypeEndpointRef;
	}

	protected ModelElementEndpointReference doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		ModelElementEndpointReference modelElemTypeEndpointRef = MIDDialogs.selectModelElementTypeEndpointToCreate(getSource(), modelElemTypeEndpointUris);
		ModelElementEndpointReference newModelElemEndpointRef = modelElemTypeEndpointRef.getObject().createInstanceAndReference(getTarget(), getSource());

		return newModelElemEndpointRef;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			if (!canExecute()) {
				throw new ExecutionException("Invalid arguments in create link command");
			}
			ModelElementEndpointReference newElement;
			switch (getSource().getObject().getLevel()) {
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
			MMINTException.print(IStatus.ERROR, "No model element endpoint created", e);
			return CommandResult.newErrorCommandResult("No model element endpoint created");
		}
	}

}
