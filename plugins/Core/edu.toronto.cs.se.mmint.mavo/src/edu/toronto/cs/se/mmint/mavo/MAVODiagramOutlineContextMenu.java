/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Initial implementation.
 *    Alessio Di Sandro - Refactoring and fixes.
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
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;

public class MAVODiagramOutlineContextMenu extends ContributionItem {

	private static final String MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL = "Remove this alternative";
	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL = "Highlight alternative in diagram";
	private static final String MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL = "Choose this alternative and refine";

	private TreeViewer viewer;

	public MAVODiagramOutlineContextMenu(TreeViewer viewer) {

		this.viewer = viewer;
	}

	@Override
	public void fill(Menu menu, int index) {

		// check selection
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof StructuredSelection)) {
			return;
		}
		Object[] objects = ((StructuredSelection) selection).toArray();
		if (objects.length > 1) {
			return;
		}

		// get selection
		Object object = objects[0];
		if (object instanceof MAVOModel) {
			MAVOModel model = (MAVOModel) object;
			createModelMenuItems(model, menu);
		}
		else if (object instanceof MayDecision) {
			MayDecision decision = (MayDecision) object;
			createDecisionMenuItems(decision, menu);
		}
		else if (object instanceof MAVOAlternative) {
			MAVOAlternative mavoAlternative = (MAVOAlternative) object;
			// highlight
			MenuItem highlightItem = new MenuItem(menu, SWT.NONE);
			highlightItem.setText(MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL);
			highlightItem.addSelectionListener(
				new HighlightListener(MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL, mavoAlternative)
			);
			// refine
			MenuItem refineItem = new MenuItem(menu, SWT.NONE);
			refineItem.setText(MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL);
			refineItem.addSelectionListener(
				new RefineListener(MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL, objects)
			);
			// remove
			MenuItem removeItem = new MenuItem(menu, SWT.NONE);
			removeItem.setText(MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL);
			removeItem.addSelectionListener(
				new MAVODecisionTreeMenuListener(MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL, mavoAlternative.eContainer(), mavoAlternative, false)
			);
		}
		else if (object instanceof MAVOElement) {
			
		}
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
