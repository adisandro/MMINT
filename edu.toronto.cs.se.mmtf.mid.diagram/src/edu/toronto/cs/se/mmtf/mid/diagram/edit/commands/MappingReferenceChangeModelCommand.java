package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

public class MappingReferenceChangeModelCommand extends MappingReferenceModelsReorientCommand {

	public MappingReferenceChangeModelCommand(ReorientReferenceRelationshipRequest request) {

		super(request);
	}

	protected CommandResult reorientSource() throws ExecutionException {

		MappingReference oldMappingRef = (MappingReference) getOldSource();
		MappingReference newMappingRef = (MappingReference) getNewSource();
		ModelReference modelRef = (ModelReference) getOldTarget();

		for (ModelContainer modelContainer : oldMappingRef.getContainers()) {
			if (modelContainer.getModel() == modelRef) {
				oldMappingRef.getContainers().remove(modelContainer);
				for (ModelElementReference element : modelContainer.getElements()) {
					element.getMappings().clear();
				}
				break;
			}
		}

		ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
		container.setModel(modelRef);
		newMappingRef.getContainers().add(container);

		return super.reorientSource();
	}

	protected CommandResult reorientTarget() throws ExecutionException {

		MappingReference mappingRef = (MappingReference) getOldSource();
		ModelReference oldModelRef = (ModelReference) getOldTarget();
		ModelReference newModelRef = (ModelReference) getNewTarget();

		for (ModelContainer modelContainer : mappingRef.getContainers()) {
			if (modelContainer.getModel() == oldModelRef) {
				mappingRef.getContainers().remove(modelContainer);
				for (ModelElementReference element : modelContainer.getElements()) {
					element.getMappings().clear();
				}
				break;
			}
		}

		ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
		container.setModel(newModelRef);
		mappingRef.getContainers().add(container);

		return super.reorientTarget();
	}

}
