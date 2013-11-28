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

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.ui.ModelElementLabelProvider;

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
		contentOutlineViewer.setContentProvider(new RelationshipDiagramOutlineContentProvider(adapterFactory, MultiModelConstraintChecker.isInstancesLevel(modelRel)));
		contentOutlineViewer.setLabelProvider(new ModelElementLabelProvider(adapterFactory, MultiModelConstraintChecker.isInstancesLevel(modelRel)));

		// add drag support
		int ops = DND.DROP_LINK | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		contentOutlineViewer.addDragSupport(ops, transfers, new RelationshipDiagramOutlineDragListener(contentOutlineViewer, modelRel));

		// populate tree viewer
		loadOutlineModels();
	}

	/**
	 * Loads the resources (models) of this model relationship.
	 */
	public void loadOutlineModels() {

		ResourceSet resourceSet = new ResourceSetImpl();
		List<Resource> resources = resourceSet.getResources();
		for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
			Model model = modelEndpointRef.getObject().getTarget();
			do {
				resources.add(MultiModelTypeIntrospection.getRoot(model).eResource());
				model = model.getSupertype(); // types only
			}
			while (model != null && !model.isAbstract());
		}
		contentOutlineViewer.setInput(resourceSet);
	}

	/**
	 * Adds a new model to the outline tree viewer.
	 * 
	 * @param model
	 *            The model to be added.
	 */
	public void addInput(Model model) {

		ResourceSet resourceSet = (ResourceSet) contentOutlineViewer.getInput();
		resourceSet.getResources().add(MultiModelTypeIntrospection.getRoot(model).eResource());
	}

}
