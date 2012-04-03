package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;

public class MappingDiagramOutlineDragListener extends DragSourceAdapter {

	private Viewer viewer;

	public MappingDiagramOutlineDragListener(Viewer viewer) {

		this.viewer = viewer;
	}

	@Override
	public void dragStart(DragSourceEvent event) {

		List<Object> transferData = new ArrayList<Object>();
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();

		// filter current selection to only EObjects
		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			Object sel = it.next();
			if (sel instanceof EObject) {
				transferData.add(sel);
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

	@Override
	public void dragFinished(DragSourceEvent event) {

		LocalSelectionTransfer.getTransfer().setSelection(null);
	}

}
