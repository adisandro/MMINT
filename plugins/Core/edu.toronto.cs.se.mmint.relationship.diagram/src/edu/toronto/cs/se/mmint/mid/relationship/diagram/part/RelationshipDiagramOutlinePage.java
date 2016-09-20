/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.ModelElementLabelProvider;

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
		adapterFactory = GMFUtils.getAdapterFactory();
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
		contentOutlineViewer.setContentProvider(new RelationshipDiagramOutlineContentProvider(adapterFactory, modelRel.getLevel()));
		contentOutlineViewer.setLabelProvider(new ModelElementLabelProvider(adapterFactory, modelRel.getLevel()));

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

		//TODO MMINT[MODELREL] with two rel types open on the same metamodels, only one will show them
		ResourceSet resourceSet;
		try {
			switch (modelRel.getLevel()) {
				case TYPES:
					resourceSet = modelRel.getOutlineResourceTypes();
					break;
				case INSTANCES:
					resourceSet = modelRel.getOutlineResourceInstances();
					break;
				case WORKFLOWS:
					throw new MMINTException("The WORKFLOWS level is not allowed");
				default:
					throw new MMINTException("The MID level is missing");
			}
		}
		catch (MMINTException e) {
			resourceSet = new ResourceSetImpl();
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
		try {
			resourceSet.getResources().add(model.getEMFInstanceRoot().eResource());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't get model root, skipping addition to outline", e);;
		}
	}

}
