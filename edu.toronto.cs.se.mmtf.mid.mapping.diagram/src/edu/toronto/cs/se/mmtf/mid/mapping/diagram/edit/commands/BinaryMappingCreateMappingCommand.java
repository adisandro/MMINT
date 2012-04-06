package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;

public class BinaryMappingCreateMappingCommand extends BinaryMappingCreateCommand {

	public BinaryMappingCreateMappingCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		BinaryMapping newElement = MappingFactory.eINSTANCE.createBinaryMapping();
		getContainer().getMappings().add(newElement);
		newElement.setElement0(getSource());
		newElement.getElements().add(getSource());
		newElement.setElement1(getTarget());
		newElement.getElements().add(getTarget());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
