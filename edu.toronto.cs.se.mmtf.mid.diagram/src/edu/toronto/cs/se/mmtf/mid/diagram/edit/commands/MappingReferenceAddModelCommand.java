package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

public class MappingReferenceAddModelCommand extends MappingReferenceModelsCreateCommand {

	public MappingReferenceAddModelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		if (getSource() != null && getTarget() != null) {
			getSource().getModels().add(getTarget());
			MultiModelCommandsTrait.addMappingReferenceModel(getSource(), getTarget());
		}

		return CommandResult.newOKCommandResult();
	}

}
