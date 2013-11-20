/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory.Descriptor;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The outline page of the Mapping diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramOutlinePage extends ContentOutlinePage {

	/** The tree viewer of the outline. */
	protected TreeViewer contentOutlineViewer;
	/** The adapter factory for content and labels of the tree viewer. */
	protected ComposedAdapterFactory adapterFactory;
	/** The model relationship root of the Relationship diagram. */
	protected ModelRel modelRel;

	/**
	 * Constructor: initialises superclass, diagram and creates the adapter
	 * factory.
	 * 
	 * @param diagram
	 *            The Relationship diagram.
	 */
	public RelationshipDiagramOutlinePage(Diagram diagram) {

		super();
		modelRel = (ModelRel) diagram.getElement();
		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

		for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
			EPackage modelTypePackage = (EPackage) MultiModelTypeIntrospection.getRoot(modelEndpointRef.getObject().getTarget().getMetatype());
			List<Object> descriptorKey = new ArrayList<Object>();
			descriptorKey.add(modelTypePackage);
			descriptorKey.add(ITreeItemContentProvider.class);
			Descriptor descriptor = ComposedAdapterFactory.Descriptor.Registry.INSTANCE.getDescriptor(descriptorKey);
			if (descriptor != null) {
				AdapterFactory editFactory = descriptor.createAdapterFactory();
				adapterFactory.addAdapterFactory(editFactory);
				//TODO MMTF: then review all support for dropping attributes and references
				//TODO MMTF: especially since I need to get info about model and model element types already here
			}
		}
		//TODO MMTF: subclass the reflective one too to support same things for extended metamodels
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * {@inheritDoc}<br />
	 * Initialises the tree viewer with a content and label provider, enables
	 * drag and drop, sets the input of the tree viewer.
	 * 
	 * @param parent
	 *            The parent.
	 */
	@Override
	public void createControl(Composite parent) {

		super.createControl(parent);

		contentOutlineViewer = getTreeViewer();
		contentOutlineViewer.addSelectionChangedListener(this);
		//TODO MMTF: modelRel is useless?
		contentOutlineViewer.setContentProvider(new RelationshipDiagramOutlineContentProvider(adapterFactory, modelRel));
		contentOutlineViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		// add drag support
		int ops = DND.DROP_LINK | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		contentOutlineViewer.addDragSupport(ops, transfers, new RelationshipDiagramOutlineDragListener(contentOutlineViewer));

		// populate tree viewer
		loadOutlineModels();
	}

	/**
	 * Loads the resources (models) of this model relationship.
	 */
	public void loadOutlineModels() {

		//TODO MMTF: review
		ResourceSet resourceSet = new ResourceSetImpl();
		for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
			Model model = modelEndpointRef.getObject().getTarget();
			try {
				if (MultiModelConstraintChecker.isInstancesLevel(modelRel)) {
					//TODO MMTF: easier by calling eResource on getRoot (but getRoot does exactly that)?
					resourceSet.getResource(URI.createPlatformResourceURI(model.getUri(), true), true);
				}
				else {
					//TODO MMTF: What if two models in the reldiag share the same root?
					resourceSet.getResources().add(MultiModelTypeIntrospection.getRoot(model).eResource());
				}
			}
			catch (Exception e) {
				MMTFException.print(MMTFException.Type.WARNING, "Model " + model.getUri() + " unavailable", e);
			}
		}

		contentOutlineViewer.setInput(resourceSet);
	}

	/**
	 * Adds a new model to the outline tree viewer.
	 * 
	 * @param modelUri
	 *            The uri of the model to add.
	 */
	public void addInput(URI modelUri) {

		ResourceSet resourceSet = (ResourceSet) contentOutlineViewer.getInput();
		try {
			resourceSet.getResource(modelUri, true);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Model " + modelUri + " unavailable", e);
		}
	}

}
