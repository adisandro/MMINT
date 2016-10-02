/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

/**
 * The command to add a model to a model relationship.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelAddModelEndpointCommand extends ModelEndpointCreateCommand {

	private List<String> modelTypeEndpointUris;

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param request
	 *            The request.
	 * @param source
	 *            The source model relationship.
	 * @param target
	 *            The target model.
	 */
	public ModelRelAddModelEndpointCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
		modelTypeEndpointUris = null;
	}

	/**
	 * Checks if a model can be added.
	 * 
	 * @return True if a model can be added, false otherwise.
	 */
	@Override
	public boolean canExecute() {

		ModelRel modelRel = getSource();
		return super.canExecute() && (((
					modelRel.isInstancesLevel() ||
					(modelRel.isWorkflowsLevel() && modelRel.getMIDContainer().getOperators().isEmpty())
				) &&
				(modelTypeEndpointUris = MIDConstraintChecker.getAllowedModelEndpoints(getSource(), null, (Model) getTarget())) != null
			) || (
				modelRel.isTypesLevel() &&
				!MIDTypeHierarchy.isRootType(getSource()) &&
				(getTarget() == null || !MIDTypeHierarchy.isRootType(getTarget()))
			)
		);
	}

	protected ModelEndpoint doExecuteTypesLevel() throws MMINTException, MIDDialogCancellation {

		Model tgtModelType = (Model) getTarget();
		String newModelTypeEndpointName = MIDDialogs.getStringInput("Create new light model type endpoint", "Insert new model type endpoint role", tgtModelType.getName());
		ModelEndpoint modelTypeEndpoint = MIDTypeHierarchy.getOverriddenModelTypeEndpoint(getSource(), tgtModelType);
		ModelEndpointReference newModelTypeEndpointRef = modelTypeEndpoint.createSubtype(newModelTypeEndpointName, tgtModelType, false, getSource());
		// no need to init type hierarchy, no need for undo/redo

		return newModelTypeEndpointRef.getObject();
	}

	protected ModelEndpoint doExecuteInstancesLevel() throws MMINTException, MIDDialogCancellation {

		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(getSource(), modelTypeEndpointUris, "");
		ModelEndpointReference newModelEndpointRef = modelTypeEndpointRef.getObject().createInstance((Model) getTarget(), getSource());

		return newModelEndpointRef.getObject();
	}

	protected ModelEndpoint doExecuteWorkflowsLevel() throws MMINTException, MIDDialogCancellation {

		ModelEndpointReference modelTypeEndpointRef = MIDDialogs.selectModelTypeEndpointToCreate(getSource(), modelTypeEndpointUris, "");
		ModelEndpoint newModelEndpoint = modelTypeEndpointRef.getObject().createWorkflowInstance((Model) getTarget(), getSource());

		return newModelEndpoint;
	}

	/**
	 * Adds a model to a model relationship.
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

		try {
			if (!canExecute()) {
				throw new ExecutionException("Invalid arguments in create link command");
			}
			ModelEndpoint newElement;
			switch (getSource().getLevel()) {
				case TYPES:
					newElement = this.doExecuteTypesLevel();
					break;
				case INSTANCES:
					newElement = this.doExecuteInstancesLevel();
					break;
				case WORKFLOWS:
					newElement = this.doExecuteWorkflowsLevel();
					break;
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
			MMINTException.print(IStatus.ERROR, "No model endpoint created", e);
			return CommandResult.newErrorCommandResult("No model endpoint created");
		}
	}

}
