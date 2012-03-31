package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

public class MultiModelCommandsTrait {

	public static void removeMappingReferenceModel(MappingReference mappingRef, ModelReference modelRef) {

		for (ModelContainer modelContainer : mappingRef.getContainers()) {
			if (modelContainer.getModel() == modelRef) {
				mappingRef.getContainers().remove(modelContainer);
				for (ModelElementReference element : modelContainer.getElements()) {
					element.getMappings().clear();
				}
				break;
			}
		}
	}

	public static void addMappingReferenceModel(MappingReference mappingRef, ModelReference modelRef) {

		ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
		container.setModel(modelRef);
		mappingRef.getContainers().add(container);
	}

}
