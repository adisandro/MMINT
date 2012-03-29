package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

public class MappingReferenceDelModelCommand extends DestroyReferenceCommand {

	public MappingReferenceDelModelCommand(DestroyReferenceRequest request) {

		super(request);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		MappingReference mappingRef = (MappingReference) getContainer();
		ModelReference modelRef = (ModelReference) getReferencedObject();
		for (ModelContainer modelContainer : mappingRef.getContainers()) {
			if (modelContainer.getModel() == modelRef) {
				mappingRef.getContainers().remove(modelContainer);
				for (ModelElementReference element : modelContainer.getElements()) {
					element.getMappings().clear();
				}
				break;
			}
		}

		return super.doExecuteWithResult(monitor, info);
	}

}
