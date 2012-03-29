package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;

public class MappingReferenceCreateMappingCommand extends MappingReferenceCreateCommand {

	public MappingReferenceCreateMappingCommand(CreateElementRequest req) {

		super(req);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		MappingReference newElement = MappingFactory.eINSTANCE.createMappingReference();
		MultiModel owner = (MultiModel) getElementToEdit();
		owner.getElements().add(newElement);

		URI modelUri = EcoreUtil.getURI(newElement);
		newElement.setUri(modelUri.toPlatformString(true));
		newElement.setRoot(newElement);
		newElement.setOrigin(ModelReferenceOrigin.CREATED);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
