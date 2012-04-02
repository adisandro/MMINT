package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;

public class BinaryMappingReferenceCreateMappingCommand extends BinaryMappingReferenceCreateCommand {

	public BinaryMappingReferenceCreateMappingCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		BinaryMappingReference newElement = MultiModelCommandsTrait.createBinaryMappingReference(getContainer());
		newElement.getModels().add(getSource());
		newElement.setModel0(getSource());
		newElement.getModels().add(getTarget());
		newElement.setModel1(getTarget());
		MultiModelCommandsTrait.addMappingReferenceModel(newElement, getSource());
		MultiModelCommandsTrait.addMappingReferenceModel(newElement, getTarget());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
