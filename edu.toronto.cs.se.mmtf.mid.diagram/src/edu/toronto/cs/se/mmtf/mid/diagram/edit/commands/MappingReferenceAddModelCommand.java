package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;

public class MappingReferenceAddModelCommand extends MappingReferenceModelsCreateCommand {

	public MappingReferenceAddModelCommand(CreateRelationshipRequest request, EObject source, EObject target) {

		super(request, source, target);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}

		MappingReference source = getSource();
		ModelReference target = getTarget();
		if (source != null && target != null) {
			source.getModels().add(target);
			ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
			container.setName(target.getName());
			source.getContainers().add(container);
		}

		return CommandResult.newOKCommandResult();
	}

}
