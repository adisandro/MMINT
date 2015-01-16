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
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;

public class MAVODiagramOutlineContextMenu extends ContributionItem {

	private static final String MAVO_OUTLINE_MENU_ADDDECISION_LABEL = "Add new decision";
	private static final String MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL = "Add new alternative";
	private static final String MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL = "Remove this decision";
	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL = "Highlight alternative in diagram";
	private static final String MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL = "Choose this alternative and refine";
	private static final String MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL = "Remove this alternative";

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
			MAVOModel mavoRootModelObj = (MAVOModel) object;
			// add
			MenuItem addItem = new MenuItem(menu, SWT.NONE);
			addItem.setText(MAVO_OUTLINE_MENU_ADDDECISION_LABEL);
			addItem.addSelectionListener(
				new MAVODecisionTreeMenuListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL, mavoRootModelObj)
			);
		}
		else if (object instanceof MayDecision) {
			MayDecision decision = (MayDecision) object;
			// highlight
			//TODO MMINT[MU-MMINT] Implement and decouple from May only
			// add
			MenuItem addItem = new MenuItem(menu, SWT.NONE);
			addItem.setText(MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL);
			addItem.addSelectionListener(
				new MAVODecisionTreeMenuListener(MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL, decision)
			);
			// remove
			MenuItem removeItem = new MenuItem(menu, SWT.NONE);
			removeItem.setText(MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL);
			removeItem.addSelectionListener(
				new MAVODecisionTreeMenuListener(MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL, decision.eContainer(), decision, false)
			);
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
			// highlight
			// refine
			//TODO MMINT[MU-MMINT] Implement
		}
	}

}
