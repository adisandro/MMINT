/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;

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
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.Mapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

/**
 * A container for common functions of a mid/mapping model.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTrait {

	/**
	 * Adds a mapping reference to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param mappingRef
	 *            The mapping reference to add.
	 */
	private static void addMappingReference(MultiModel multiModel, MappingReference mappingRef) {

		multiModel.getElements().add(mappingRef);
		URI modelUri = EcoreUtil.getURI(mappingRef);
		mappingRef.setUri(modelUri.toPlatformString(true));
		mappingRef.setRoot(mappingRef);
	}

	/**
	 * Creates and adds a model reference to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add.
	 * @param origin
	 *            The origin of the model.
	 * @return The model reference just created.
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	public static ModelReference createModelReference(MultiModel multiModel, URI modelUri, ModelReferenceOrigin origin) throws Exception {

		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(modelUri, true);
		EObject root = resource.getContents().get(0);
		ModelReference modelRef = MidFactory.eINSTANCE.createModelReference();
		modelRef.setUri(modelUri.toPlatformString(true));
		modelRef.setName(modelUri.lastSegment());
		modelRef.setRoot(root);
		modelRef.setOrigin(origin);
		if (multiModel != null) {
			multiModel.getElements().add(modelRef);
		}

		return modelRef;
	}

	/**
	 * Creates and adds a mapping reference to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param origin
	 *            The origin of the mapping reference.
	 * @return The mapping reference just created.
	 */
	public static MappingReference createMappingReference(MultiModel multiModel, ModelReferenceOrigin origin) {

		MappingReference mappingRef = MappingFactory.eINSTANCE.createMappingReference();
		addMappingReference(multiModel, mappingRef);
		mappingRef.setOrigin(origin);

		return mappingRef;
	}

	/**
	 * Creates and adds a binary mapping reference to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param origin
	 *            The origin of the binary mapping reference.
	 * @return The binary mapping reference just created.
	 */
	public static BinaryMappingReference createBinaryMappingReference(MultiModel multiModel, ModelReferenceOrigin origin) {

		BinaryMappingReference mappingRef = MappingFactory.eINSTANCE.createBinaryMappingReference();
		addMappingReference(multiModel, mappingRef);
		mappingRef.setOrigin(origin);

		return mappingRef;
	}

	/**
	 * Removes a model container from a mapping reference.
	 * 
	 * @param mappingRef
	 *            The mapping reference.
	 * @param modelRef
	 *            The model reference to be removed.
	 */
	public static void removeMappingReferenceModelContainer(MappingReference mappingRef, ModelReference modelRef) {

		for (ModelContainer modelContainer : mappingRef.getContainers()) {
			if (modelContainer.getModel() == modelRef) {
				mappingRef.getContainers().remove(modelContainer);
				ArrayList<Mapping> delMappings = new ArrayList<Mapping>();
				for (ModelElementReference element : modelContainer.getElements()) {
					for (Mapping mapping : element.getMappings()) {
						// binary mappings have no longer sense, delete them later to avoid concurrent modification problems
						if (mapping instanceof BinaryMapping) {
							delMappings.add(mapping);
						}
					}
					element.getMappings().clear();
				}
				for (Mapping delMapping : delMappings) {
					delMapping.getElements().clear();
					mappingRef.getMappings().remove(delMapping);
				}
				break;
			}
		}
	}

	/**
	 * Adds a model container to a mapping reference.
	 * 
	 * @param mappingRef
	 *            The mapping reference.
	 * @param modelRef
	 *            The model reference that corresponds to the model container.
	 * @return The model container just created.
	 */
	public static ModelContainer addMappingReferenceModelContainer(MappingReference mappingRef, ModelReference modelRef) {

		ModelContainer container = MappingFactory.eINSTANCE.createModelContainer();
		mappingRef.getContainers().add(container);
		if (mappingRef.eContainer() == null) { // standalone mapping reference
			container.setContainedModel(modelRef);
		}
		else {
			container.setReferencedModel(modelRef);
		}

		return container;
	}

}
