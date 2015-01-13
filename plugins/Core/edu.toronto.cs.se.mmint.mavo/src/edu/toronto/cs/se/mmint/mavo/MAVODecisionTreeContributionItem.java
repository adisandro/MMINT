/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
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


		if (objects.length > 1) {
			return;
		}
		else {
			for (Object object : objects) {
				if (object instanceof MAVOModel) {
					MAVOModel model = (MAVOModel) object;
					createModelMenuItems(model, parent);
				} else if (object instanceof MayDecision) {
					MayDecision decision = (MayDecision) object;
					createDecisionMenuItems(decision, parent);
				} else if (object instanceof MAVOAlternative) {
					createRefinementMenuItems(objects, parent);
				}
			}
		}
	}
	
	private void createRefinementMenuItems(Object[] objects, Menu parent) {
		MenuItem makeRefinementItem = new MenuItem(parent, SWT.NONE);
		makeRefinementItem.setText("Choose this and refine");
		makeRefinementItem.addSelectionListener(new MAVODecisionTreeRefinementMenuListener(
				"Choose this and refine", objects));
		
	}

	private void createModelMenuItems(MAVOModel model, Menu parent) {
		// Add new decision
		MenuItem addDecisionItem = new MenuItem(parent, SWT.NONE);
		addDecisionItem.setText("Add a new decision");
		addDecisionItem.addSelectionListener(new MAVODecisionTreeMenuListener("Add a new decision", model));

		// Remove existing decisions
		for (MAVODecision decision : model.getDecisions()) {
			MenuItem removeDecisionItem = new MenuItem(parent, SWT.NONE);
			removeDecisionItem.setText("Remove decision "
					+ decision.getFormulaVariable());
			removeDecisionItem
					.addSelectionListener(new MAVODecisionTreeMenuListener("Remove decision ", model, decision, false));
		}
	}

	private void createDecisionMenuItems(MayDecision decision, Menu parent) {
		// Add new alternative
		MenuItem addAlternativeItem = new MenuItem(parent, SWT.NONE);
		addAlternativeItem.setText("Add new alternative");
		addAlternativeItem
				.addSelectionListener(new MAVODecisionTreeMenuListener("Add new alternative", decision));

		// Remove existing alternatives
		for (MAVOAlternative alternative : decision.getAlternatives()) {
			MenuItem removeAlternativeItem = new MenuItem(parent, SWT.NONE);
			removeAlternativeItem.setText("Remove alternative "
					+ alternative.getFormulaVariable());
			removeAlternativeItem
					.addSelectionListener(new MAVODecisionTreeMenuListener("Remove alternative ", decision, alternative, false));
		}
	}
}
