/*
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.SimpleAnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementReferenceDropCommand;

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
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRel);
		ModelElement modelElementType = null;
		String[] uris;

		// filter current selection
		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			Object modelObj = it.next();
			if (isInstancesLevel) {
				if (!(modelObj instanceof EObject) && !(modelObj instanceof AttributeValueWrapperItemProvider)) {
					continue;
				}
				uris = (modelObj instanceof AttributeValueWrapperItemProvider) ?
					MultiModelRegistry.getModelAndModelElementUris((AttributeValueWrapperItemProvider) modelObj) :
					MultiModelRegistry.getModelAndModelElementUris((EObject) modelObj, isInstancesLevel);
			}
			else {
				if (!(modelObj instanceof EClass) && !(modelObj instanceof EAttribute)) {
					continue;
				}
				uris = MultiModelRegistry.getModelAndModelElementUris((EObject) modelObj, isInstancesLevel);
			}
			String modelUri = uris[0], modelElemUri = uris[1];

			//TODO MMTF: continue from here
modelEndpointRef:
			for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
				if (
					modelUri.equals(modelEndpointRef.getTargetUri()) || (
						!isInstancesLevel &&
						MultiModelTypeHierarchy.isSubtypeOf(modelEndpointRef.getTargetUri(), modelUri, multiModel) // for light types
					)
				) {
					if (!isInstancesLevel) {
						for (ModelElementReference elementRef : modelEndpointRef.getModelElemRefs()) { // avoid duplicates
							//TODO MMTF: why? check this, looks wrong
							if (EcoreUtil.equals(MultiModelTypeIntrospection.getPointer(elementRef.getObject()), (EObject) modelObj)) {
								continue modelEndpointRef;
							}
						}
					}
					//TODO MMTF: do filtering based on allowed model types
					RelationshipDiagramOutlineDropObject dropObject = new RelationshipDiagramOutlineDropObject(modelObj, isInstancesLevel, modelElementType, modelEndpointRef);
//					transferData.add(dropObject);
				}
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
