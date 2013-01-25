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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

/**
 * The Relationship diagram drop listener.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramOutlineDropListener extends DiagramDropTargetListener {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param viewer
	 *            The diagram viewer.
	 * @param xfer
	 *            The transfer object.
	 */
	public RelationshipDiagramOutlineDropListener(EditPartViewer viewer, Transfer xfer) {

		super(viewer, xfer);
	}

	/**
	 * Gets the objects being dropped.
	 * 
	 * @return The objects being dropped.
	 */
	@Override
	protected List<EObject> getObjectsBeingDropped() {

		TransferData data = getCurrentEvent().currentDataType;
		ArrayList<EObject> result = new ArrayList<EObject>();
		Object transferedObject = LocalSelectionTransfer.getTransfer().nativeToJava(data);

		if (transferedObject instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) transferedObject;
			for (Iterator<?> it = selection.iterator(); it.hasNext();) {
				Object nextSelectedObject = it.next();
				// allow only EObjects
				if (nextSelectedObject instanceof EObject) {
					result.add((EObject) nextSelectedObject);
				}
			}
		}

		return result;
	}

	/**
	 * Checks if the drop is enabled.
	 * 
	 * @return True.
	 */
	@Override
	public boolean isEnabled(DropTargetEvent event) {

		// drag and drop is always enabled on the drop side, but filtered on the drag side
		return true;
	}

}
