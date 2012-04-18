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
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

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
	 * Adds a model reference to a multimodel.
	 * 
	 * @param modelRef
	 *            The model reference to add.
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add (possibly null).
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	private static void addModelReference(ModelReference modelRef, ModelReferenceOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		// possibly raise exception as first thing
		EObject root;
		if (modelUri == null) { // mapping reference
			root = modelRef;
		}
		else { // model reference or standalone mapping reference
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
			modelRef.setName(modelUri.lastSegment());
		}

		// add to multimodel container
		if (multiModel != null) {
			multiModel.getElements().add(modelRef);
		}
		// point to uri and root
		if (modelUri == null) {
			modelUri = EcoreUtil.getURI(modelRef);
		}
		modelRef.setRoot(root);
		modelRef.setUri(modelUri.toPlatformString(true));
		// set origin
		modelRef.setOrigin(origin);
	}

	/**
	 * Creates and adds a model reference to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the model.
	 * @param multiModel
	 *            The root multimodel (possibly null).
	 * @param modelUri
	 *            The uri of the model to add.
	 * @return The model reference just created.
	 * @throws Exception
	 *             If the resource pointed by the model uri could not be get.
	 */
	public static ModelReference createModelReference(ModelReferenceOrigin origin, MultiModel multiModel, URI modelUri) throws Exception {

		ModelReference modelRef = MidFactory.eINSTANCE.createModelReference();
		addModelReference(modelRef, origin, multiModel, modelUri);

		return modelRef;
	}

	/**
	 * Creates and adds a mapping reference to a multimodel.
	 * 
	 * @param origin
	 *            The origin of the mapping reference.
	 * @param multiModel
	 *            The root multimodel.
	 * @param mappingUri
	 *            The uri of the mapping to add, null if not imported.
	 * @param mappingRefType
	 *            The specific mapping reference class type.
	 * @return The mapping reference just created.
	 * @throws Exception
	 *             If the resource pointed by the mapping uri could not be get.
	 */
	public static MappingReference createMappingReference(ModelReferenceOrigin origin, MultiModel multiModel, URI mappingUri, EClass mappingRefType) throws Exception {

		MappingReference mappingRef = (MappingReference) MappingFactory.eINSTANCE.create(mappingRefType);
		addModelReference(mappingRef, origin, multiModel, mappingUri);

		return mappingRef;
	}

	/**
	 * Creates and adds a model container to a mapping reference.
	 * 
	 * @param mappingRef
	 *            The mapping reference.
	 * @param modelRef
	 *            The model reference that corresponds to the model container.
	 * @return The model container just created.
	 */
	public static ModelContainer createMappingReferenceModelContainer(MappingReference mappingRef, ModelReference modelRef) {

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

	/**
	 * Creates and adds a model element reference to a model container.
	 * 
	 * @param container
	 *            The model container
	 * @param modelElement
	 *            The model element pointed by the model element reference.
	 * @return The model element reference just created.
	 */
	public static ModelElementReference createModelElementReference(ModelContainer container, EObject modelElement) {

		ModelElementReference elementRef = MappingFactory.eINSTANCE.createModelElementReference();
		elementRef.setPointer(modelElement);
		String name = "";
		if (!modelElement.eAdapters().isEmpty()) {
			ItemProviderAdapter adapter = (ItemProviderAdapter) modelElement.eAdapters().get(0);
			name = adapter.getText(modelElement);
		}
		elementRef.setName(name);
		container.getElements().add(elementRef);

		return elementRef;
	}

	/**
	 * Creates and adds a copy of a mapping reference to a multimodel.
	 * 
	 * @param multiModel
	 *            The root multimodel.
	 * @param mappingUri
	 *            The uri of the original mapping reference.
	 * @return The mapping reference just created.
	 * @throws Exception
	 *             If the resources pointed by the various uris could not be
	 *             get.
	 */
	public static MappingReference copyMappingReference(MultiModel multiModel, URI mappingUri) throws Exception {

		// this duplicate code is needed to infer the mapping reference type
		ResourceSet set = new ResourceSetImpl();
		Resource resource = set.getResource(mappingUri, true);
		EObject root = resource.getContents().get(0);
		MappingReference mappingRef = createMappingReference(
			ModelReferenceOrigin.IMPORTED,
			multiModel,
			mappingUri,
			root.eClass()
		);

		// copy mapping structure
		MappingReference origMappingRef = (MappingReference) mappingRef.getRoot();
		HashMap<EObject, ModelElementReference> modelElements = new HashMap<EObject, ModelElementReference>();
		for (ModelContainer origContainer : origMappingRef.getContainers()) {
			URI modelUri = URI.createPlatformResourceURI(origContainer.getContainedModel().getUri(), true);
			// TODO cercare modelli già esistenti
			ModelReference modelRef = createModelReference(ModelReferenceOrigin.IMPORTED, multiModel, modelUri);
			mappingRef.getModels().add(modelRef);
			ModelContainer container = createMappingReferenceModelContainer(mappingRef, modelRef);
			for (ModelElementReference origElementRef : origContainer.getElements()) {
				ModelElementReference elementRef = createModelElementReference(container, origElementRef.getPointer());//TODO perchè il nome non funziona?
				modelElements.put(elementRef.getPointer(), elementRef);//TODO e più container che puntano allo stesso modello?
			}
		}
		if (mappingRef instanceof BinaryMappingReference) {
			((BinaryMappingReference) mappingRef).setModel0(mappingRef.getModels().get(0));
			((BinaryMappingReference) mappingRef).setModel1(mappingRef.getModels().get(1));
		}
		for (Mapping origMapping : origMappingRef.getMappings()) {
			Mapping mapping = (Mapping) MappingFactory.eINSTANCE.create(origMapping.eClass());
			mapping.setName(origMapping.getName());
			mappingRef.getMappings().add(mapping);
			for (ModelElementReference origElementRef : origMapping.getElements()) {
				mapping.getElements().add(modelElements.get(origElementRef.getPointer()));
			}
			if (mapping instanceof BinaryMapping) {
				((BinaryMapping) mapping).setElement0(mapping.getElements().get(0));
				((BinaryMapping) mapping).setElement1(mapping.getElements().get(1));
			}
		}

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

}
