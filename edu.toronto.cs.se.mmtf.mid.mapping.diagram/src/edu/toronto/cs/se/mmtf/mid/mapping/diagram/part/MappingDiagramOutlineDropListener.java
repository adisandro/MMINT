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
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

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
 * The Mapping diagram drop listener.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingDiagramOutlineDropListener extends DiagramDropTargetListener {

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param viewer
	 *            The diagram viewer.
	 * @param xfer
	 *            The transfer object.
	 */
	public MappingDiagramOutlineDropListener(EditPartViewer viewer, Transfer xfer) {

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
