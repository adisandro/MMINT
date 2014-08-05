package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import edu.toronto.cs.se.mavo.MAVOAlternative;

public class MAVOAlternativeHighlightContributionItem extends ContributionItem{

	private Viewer viewer;
	
	public MAVOAlternativeHighlightContributionItem(Viewer viewer){
		this.viewer = viewer;
	}
	
	@Override
	public void fill(Menu parent, int index) {
		// check selection
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		if (selection == null || selection.isEmpty()
				|| !(selection instanceof StructuredSelection)) {
			return;
		}
		Object[] objects = ((StructuredSelection) selection).toArray();

		// TODO MMINT[MU-MMINT] for now, do not show menu if more than one element is selected
		if (objects.length > 1) {
			return;
		}

		for (Object object : objects) {
			if (object instanceof MAVOAlternative) {
				MAVOAlternative alternative = (MAVOAlternative) object;
					MenuItem removeElementItem = new MenuItem(parent, SWT.NONE);
					removeElementItem.setText("Highlight alternative in diagram");
					removeElementItem
							.addSelectionListener(new MAVOAlternativeHighlightMenuListener(
									alternative));

			}

		}
	}
}
