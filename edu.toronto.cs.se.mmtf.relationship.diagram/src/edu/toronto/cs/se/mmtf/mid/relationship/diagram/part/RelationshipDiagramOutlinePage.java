/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
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
	/** The Relationship diagram. */
	protected Diagram diagram;

	/**
	 * Constructor: initialises superclass, diagram and creates the adapter
	 * factory.
	 * 
	 * @param diagram
	 *            The Relationship diagram.
	 */
	public RelationshipDiagramOutlinePage(Diagram diagram) {

		super();

		adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		this.diagram = diagram;
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
		contentOutlineViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
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

		ResourceSet resourceSet = new ResourceSetImpl();
		ModelRel root = (ModelRel) diagram.getElement();
		for (Model model : root.getModels()) {
			try {
				if (root.getLevel() == MidLevel.TYPES) {
					resourceSet.getResources().add(root.getRoot().eResource());
				}
				else {
					//TODO MMTF: easier by calling eResource on getRoot (but getRoot does exactly that)?
					resourceSet.getResource(URI.createPlatformResourceURI(model.getUri(), true), true);
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
