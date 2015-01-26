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
package edu.toronto.cs.se.mmint.mavo.diagram.outline.context;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;

public class MAVODiagramOutlineContextMenu extends ContributionItem {

	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL = "Highlight this decision in the diagram";
	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL = "Highlight this alternative in the diagram";
	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTDOMAIN_LABEL = "Highlight this domain in the diagram";
	private static final String MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL = "Highlight this element in diagram";
	private static final String MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL = "Choose this alternative and refine";
	private static final String MAVO_OUTLINE_MENU_REFINEELEMENT_LABEL = "Choose this element and refine";
	private static final String MAVO_OUTLINE_MENU_ADDDECISION_LABEL = "Add new decision";
	private static final String MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL = "May";
	private static final String MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL = "Var";
	private static final String MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL = "Add new alternative";
	private static final String MAVO_OUTLINE_MENU_ADDDOMAIN_LABEL = "Add new domain";
	private static final String MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL = "Remove this decision";
	private static final String MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL = "Remove this alternative";
	private static final String MAVO_OUTLINE_MENU_REMOVEDOMAIN_LABEL = "Remove this domain";
	private static final String MAVO_OUTLINE_MENU_REMOVEALTERNATIVEELEMENT_LABEL = "Remove this element from the alternative";
	private static final String MAVO_OUTLINE_MENU_REMOVEDOMAINELEMENT_LABEL = "Remove this element from the domain";

	private TreeViewer viewer;

	public MAVODiagramOutlineContextMenu(TreeViewer viewer) {

		this.viewer = viewer;
	}

	@Override
	public void fill(Menu menu, int index) {

		// check selection
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof TreeSelection)) {
			return;
		}
		Object[] objects = ((TreeSelection) selection).toArray();
		//TODO MMINT[MU-MMINT] Implementing var merge refinement requires multiple mavo elements selected from the same domain
		if (objects.length > 1) {
			return;
		}

		// get selection
		Object object = objects[0];
		if (object instanceof MAVOModel) {
			MAVOModel mavoRootModelObj = (MAVOModel) object;
			// add
			MenuItem addItem = new MenuItem(menu, SWT.CASCADE);
			addItem.setText(MAVO_OUTLINE_MENU_ADDDECISION_LABEL);
			Menu addMenu = new Menu(menu);
			addItem.setMenu(addMenu);
			MenuItem addMayItem = new MenuItem(addMenu, SWT.NONE);
			addMayItem.setText(MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL);
			addMayItem.addSelectionListener(
				new MAVODiagramOutlineContextAddListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL + " " + MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL, mavoRootModelObj, MAVOPackage.eINSTANCE.getMayDecision())
			);
			MenuItem addVarItem = new MenuItem(addMenu, SWT.NONE);
			addVarItem.setText(MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL);
			addVarItem.addSelectionListener(
				new MAVODiagramOutlineContextAddListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL + " " + MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL, mavoRootModelObj, MAVOPackage.eINSTANCE.getVarDecision())
			);
		}
		else if (object instanceof MAVODecision) {
			MAVODecision mavoDecision = (MAVODecision) object;
			// highlight
			MenuItem highlightItem = new MenuItem(menu, SWT.NONE);
			highlightItem.setText(MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL);
			highlightItem.addSelectionListener(
				new MAVODiagramOutlineContextHighlightListener(MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL, mavoDecision)
			);
			// add
			if (!(mavoDecision instanceof VarDecision) || ((VarDecision) mavoDecision).getDomain() == null) {
				MenuItem addItem = new MenuItem(menu, SWT.NONE);
				String addText = "";
				if (mavoDecision instanceof MayDecision) {
					addText = MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL;
				}
				else if (mavoDecision instanceof VarDecision) {
					addText = MAVO_OUTLINE_MENU_ADDDOMAIN_LABEL;
				}
				addItem.setText(addText);
				addItem.addSelectionListener(
					new MAVODiagramOutlineContextAddListener(addText, mavoDecision)
				);
			}
			// remove
			MenuItem removeItem = new MenuItem(menu, SWT.NONE);
			removeItem.setText(MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL);
			removeItem.addSelectionListener(
				new MAVODiagramOutlineContextRemoveListener(MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL, mavoDecision)
			);
		}
		else if (object instanceof MAVOCollection) {
			MAVOCollection mavoCollection = (MAVOCollection) object;
			String highlightText = "", removeText = "";
			if (mavoCollection.eContainer() instanceof MayDecision) {
				highlightText = MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL;
				removeText = MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL;
			}
			else if (mavoCollection.eContainer() instanceof VarDecision) {
				highlightText = MAVO_OUTLINE_MENU_HIGHLIGHTDOMAIN_LABEL;
				removeText = MAVO_OUTLINE_MENU_REMOVEDOMAIN_LABEL;
			}
			// highlight
			MenuItem highlightItem = new MenuItem(menu, SWT.NONE);
			highlightItem.setText(highlightText);
			highlightItem.addSelectionListener(
				new MAVODiagramOutlineContextHighlightListener(highlightText, mavoCollection)
			);
			// refine
			if (mavoCollection.eContainer() instanceof MayDecision) {
				MenuItem refineItem = new MenuItem(menu, SWT.NONE);
				refineItem.setText(MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL);
				refineItem.addSelectionListener(
					new MAVODiagramOutlineContextRefineListener(MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL, mavoCollection)
				);
			}
			// remove
			MenuItem removeItem = new MenuItem(menu, SWT.NONE);
			removeItem.setText(removeText);
			removeItem.addSelectionListener(
				new MAVODiagramOutlineContextRemoveListener(removeText, mavoCollection)
			);
		}
		else if (object instanceof MAVOElement) {
			MAVOElement mavoModelObj = (MAVOElement) object;
			MAVOCollection mavoCollection = (MAVOCollection) ((TreeSelection) selection).getPathsFor(mavoModelObj)[0].getParentPath().getLastSegment();
			String removeText = "";
			if (mavoCollection.eContainer() instanceof MayDecision) {
				removeText = MAVO_OUTLINE_MENU_REMOVEALTERNATIVEELEMENT_LABEL;
			}
			else if (mavoCollection.eContainer() instanceof VarDecision) {
				removeText = MAVO_OUTLINE_MENU_REMOVEDOMAINELEMENT_LABEL;
			}
			// highlight
			MenuItem highlightItem = new MenuItem(menu, SWT.NONE);
			highlightItem.setText(MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL);
			highlightItem.addSelectionListener(
				new MAVODiagramOutlineContextHighlightListener(MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL, mavoModelObj)
			);
			// refine
			if (mavoCollection.eContainer() instanceof MayDecision) {
				MenuItem refineItem = new MenuItem(menu, SWT.NONE);
				refineItem.setText(MAVO_OUTLINE_MENU_REFINEELEMENT_LABEL);
				refineItem.addSelectionListener(
					new MAVODiagramOutlineContextRefineListener(MAVO_OUTLINE_MENU_REFINEELEMENT_LABEL, mavoModelObj)
				);
			}
			// remove
			MenuItem removeItem = new MenuItem(menu, SWT.NONE);
			removeItem.setText(removeText);
			removeItem.addSelectionListener(
				new MAVODiagramOutlineContextRemoveListener(removeText, mavoCollection, mavoModelObj)
			);
		}
	}

}