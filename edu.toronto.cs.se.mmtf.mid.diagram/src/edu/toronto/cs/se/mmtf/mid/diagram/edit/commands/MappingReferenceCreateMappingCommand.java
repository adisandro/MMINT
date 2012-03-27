package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;

public class MappingReferenceCreateMappingCommand extends MappingReferenceCreateCommand {

	private URI createMapping() throws Exception {

		//TODO get and call wizard
		return null;
	}

	public MappingReferenceCreateMappingCommand(CreateElementRequest req) {

		super(req);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		URI modelUri;
		EObject root;
		try {
			modelUri = createMapping();
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}

		MappingReference newElement = MappingFactory.eINSTANCE.createMappingReference();
		newElement.setUri(modelUri.toPlatformString(true));
		newElement.setName(modelUri.lastSegment());
		newElement.setRoot(root);
		newElement.setOrigin(ModelReferenceOrigin.CREATED);
		newElement.setContainer(MappingFactory.eINSTANCE.createModelContainer());
		MultiModel owner = (MultiModel) getElementToEdit();
		owner.getElements().add(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
