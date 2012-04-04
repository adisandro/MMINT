package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

public class ModelElementReferenceDropCommand extends ModelElementReferenceCreateCommand {

	EObject droppedElement;

	public ModelElementReferenceDropCommand(CreateElementRequest req, EObject droppedElement) {

		super(req);
		this.droppedElement = droppedElement;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelElementReference newElement = MappingFactory.eINSTANCE.createModelElementReference();
		newElement.setPointer(droppedElement);
		String name = "";
		if (!droppedElement.eAdapters().isEmpty()) {
			ItemProviderAdapter adapter = (ItemProviderAdapter) droppedElement.eAdapters().get(0);
			name = adapter.getText(droppedElement);
		}
		newElement.setName(name);
		ModelContainer owner = (ModelContainer) getElementToEdit();
		owner.getElements().add(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
