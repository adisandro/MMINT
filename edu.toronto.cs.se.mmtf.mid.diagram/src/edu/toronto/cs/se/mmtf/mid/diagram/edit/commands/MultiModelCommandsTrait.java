package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

public class MultiModelCommandsTrait {

	private static ModelReference addModelReference(MultiModel multiModel, URI modelUri) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(modelUri, true);
		EObject root = resource.getContents().get(0);
		ModelReference modelRef = MidFactory.eINSTANCE.createModelReference();
		multiModel.getElements().add(modelRef);
		modelRef.setUri(modelUri.toPlatformString(true));
		modelRef.setName(modelUri.lastSegment());
		modelRef.setRoot(root);

		return modelRef;
	}

	private static void addMappingReference(MultiModel multiModel, MappingReference mappingRef) {

		multiModel.getElements().add(mappingRef);
		URI modelUri = EcoreUtil.getURI(mappingRef);
		mappingRef.setUri(modelUri.toPlatformString(true));
		mappingRef.setRoot(mappingRef);
	}

	private static MappingReference addMappingReference(MultiModel multiModel) {

		MappingReference mappingRef = MappingFactory.eINSTANCE.createMappingReference();
		addMappingReference(multiModel, mappingRef);

		return mappingRef;
	}

	private static BinaryMappingReference addBinaryMappingReference(MultiModel multiModel) {

		BinaryMappingReference mappingRef = MappingFactory.eINSTANCE.createBinaryMappingReference();
		addMappingReference(multiModel, mappingRef);

		return mappingRef;
	}

	public static ModelReference createModelReference(MultiModel multiModel, URI modelUri) throws Exception {

		ModelReference modelRef = addModelReference(multiModel, modelUri);
		modelRef.setOrigin(ModelReferenceOrigin.CREATED);

		return modelRef;
	}

	public static ModelReference importModelReference(MultiModel multiModel, URI modelUri) throws Exception {

		ModelReference modelRef = addModelReference(multiModel, modelUri);
		modelRef.setOrigin(ModelReferenceOrigin.IMPORTED);

		return modelRef;
	}

	public static MappingReference createMappingReference(MultiModel multiModel) {

		MappingReference mappingRef = addMappingReference(multiModel);
		mappingRef.setOrigin(ModelReferenceOrigin.CREATED);

		return mappingRef;
	}

	public static MappingReference importMappingReference(MultiModel multiModel) {

		MappingReference mappingRef = addMappingReference(multiModel);
		mappingRef.setOrigin(ModelReferenceOrigin.IMPORTED);

		return mappingRef;
	}

	public static BinaryMappingReference createBinaryMappingReference(MultiModel multiModel) {

		BinaryMappingReference mappingRef = addBinaryMappingReference(multiModel);
		mappingRef.setOrigin(ModelReferenceOrigin.CREATED);

		return mappingRef;
	}

	public static BinaryMappingReference importBinaryMappingReference(MultiModel multiModel) {

		BinaryMappingReference mappingRef = addBinaryMappingReference(multiModel);
		mappingRef.setOrigin(ModelReferenceOrigin.IMPORTED);

		return mappingRef;
	}

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
