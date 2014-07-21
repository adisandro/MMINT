package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;

public class MAVODecisionTreeContributionItem extends ContributionItem {
	private TreeViewer viewer;

	public MAVODecisionTreeContributionItem(TreeViewer viewer) {
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
			if (object instanceof MAVOModel) {
				MAVOModel model = (MAVOModel) object;
				createModelMenuItems(model, parent);
			} else if (object instanceof MayDecision) {
				MayDecision decision = (MayDecision) object;
				createDecisionMenuItems(decision, parent);
			} else if (object instanceof MAVOAlternative) {
				MAVOAlternative alternative = (MAVOAlternative) object;
				// Remove element from alternative
				for (MAVOElement element : alternative.getMavoElements()) {
					MenuItem removeElementItem = new MenuItem(parent, SWT.NONE);
					removeElementItem.setText("Remove element "
							+ element.getFormulaVariable());
					removeElementItem
							.addSelectionListener(new MAVODecisionTreeMenuListener(
									alternative, element));

				}
			}

		}
	}

	private void createModelMenuItems(MAVOModel model, Menu parent) {
		// Add new decision
		MenuItem addDecisionItem = new MenuItem(parent, SWT.NONE);
		addDecisionItem.setText("Add a new decision");
		addDecisionItem.addSelectionListener(new MAVODecisionTreeMenuListener(
				model));

		// Remove existing decisions
		for (MAVODecision decision : model.getDecisions()) {
			MenuItem removeDecisionItem = new MenuItem(parent, SWT.NONE);
			removeDecisionItem.setText("Remove decision "
					+ decision.getFormulaVariable());
			removeDecisionItem
					.addSelectionListener(new MAVODecisionTreeMenuListener(
							model, decision));
		}
	}

	private void createDecisionMenuItems(MayDecision decision, Menu parent) {
		// Add new alternative
		MenuItem addAlternativeItem = new MenuItem(parent, SWT.NONE);
		addAlternativeItem.setText("Add new alternative");
		addAlternativeItem
				.addSelectionListener(new MAVODecisionTreeMenuListener(decision));

		// Remove existing alternatives
		for (MAVOAlternative alternative : decision.getAlternatives()) {
			MenuItem removeAlternativeItem = new MenuItem(parent, SWT.NONE);
			removeAlternativeItem.setText("Remove alternative "
					+ alternative.getFormulaVariable());
			removeAlternativeItem
					.addSelectionListener(new MAVODecisionTreeMenuListener(
							decision, alternative));
		}
	}
}
