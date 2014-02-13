/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The outline page drag listener.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramOutlineDragListener extends DragSourceAdapter {

	/** The outline tree viewer. */
	private Viewer viewer;
	private ModelRel modelRel;

	/**
	 * Constructor: initialises the viewer.
	 * 
	 * @param viewer
	 *            The outline tree viewer.
	 */
	public RelationshipDiagramOutlineDragListener(Viewer viewer, ModelRel modelRel) {

		this.viewer = viewer;
		this.modelRel = modelRel;
	}

	/**
	 * {@inheritDoc}<br />
	 * Starts the drag by copying the selected objects into the transfer data.
	 * 
	 * @param event
	 *            The drag event.
	 */
	@Override
	public void dragStart(DragSourceEvent event) {

		List<Object> transferData = new ArrayList<Object>();
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		boolean isInstancesLevel = MultiModelConstraintChecker.isInstancesLevel(modelRel);
		ModelElement modelElemType = null;

		// filtering
		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			Object selected = it.next();
			EObject modelObj;
			// filter unallowed objects
			if (isInstancesLevel) {
				if (!(selected instanceof EObject) && !(selected instanceof AttributeValueWrapperItemProvider)) {
					continue;
				}
				modelObj = (selected instanceof AttributeValueWrapperItemProvider) ?
					new PrimitiveEObjectWrapper((AttributeValueWrapperItemProvider) selected) :
					(EObject) selected;
			}
			else {
				if (
					!(selected instanceof EClass) && (
						!(selected instanceof EStructuralFeature) || (
							selected instanceof EReference &&
							!((EReference) selected).isContainment()
						)
					)
				) {
					continue;
				}
				modelObj = (EObject) selected;
			}
			// assign to container
			String modelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, isInstancesLevel)[1];
			for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
				try {
					if (isInstancesLevel) {
						modelElemType = modelEndpointRef.acceptModelElementInstance(modelObj);
						if (modelElemType == null) {
							continue;
						}
					}
					else {
						if (!modelEndpointRef.acceptModelElementType(modelObj)) {
							continue;
						}
					}
				}
				catch (MMTFException e) {
					continue;
				}
				RelationshipDiagramOutlineDropObject dropObject = new RelationshipDiagramOutlineDropObject(modelObj, isInstancesLevel, modelEndpointRef, modelElemType, modelElemUri);
				transferData.add(dropObject);
			}
		}

		// create drag transfer selection
		selection = new StructuredSelection(transferData);
		if (selection.isEmpty()) {
			event.doit = false;
		}
		else {
			LocalSelectionTransfer.getTransfer().setSelection(selection);
			event.doit = true;
		}
	}

	/**
	 * {@inheritDoc}<br />
	 * Moves the transfer data into the event.
	 * 
	 * @param event
	 *            The drag event.
	 */
	@Override
	public void dragSetData(DragSourceEvent event) {

		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();

		if (LocalSelectionTransfer.getTransfer().isSupportedType(event.dataType)) {
			event.data = selection;
		}
		else {
			event.doit = false;
		}
	}

	/**
	 * {@inheritDoc}<br />
	 * Clears the transfer data.
	 * 
	 * @param event
	 *            The drag event.
	 */
	@Override
	public void dragFinished(DragSourceEvent event) {

		LocalSelectionTransfer.getTransfer().setSelection(null);
	}

}
