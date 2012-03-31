package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;

public class MappingContentOutlineDragListener extends ViewerDragAdapter {

	public MappingContentOutlineDragListener(Viewer viewer) {

		super(viewer);
	}

	@Override
	public void dragStart(DragSourceEvent event) {

		super.dragStart(event);

		for (TreePath path : ((TreeSelection) selection).getPaths()) {
			if (path.getLastSegment() instanceof XMIResourceImpl) {
				event.doit = false;
				break;
			}
		}
	}

}
