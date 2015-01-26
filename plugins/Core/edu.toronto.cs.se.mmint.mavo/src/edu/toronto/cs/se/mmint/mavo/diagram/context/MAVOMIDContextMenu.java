/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.diagram.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.mid.diagram.context.MIDContextMenu;

/**
 * The handler for the dynamic construction of a context menu for all
 * MAVO operations.
 * 
 * @author Alessio Di Sandro
 * 
 */

public class MAVOMIDContextMenu extends ContributionItem {

	private static final String MAVO_MENU_LABEL = "MAVO";
	private static final String MAVO_MENU_ADDTOALTERNATIVE_LABEL = "(M) Add to Alternative";
	private static final String MAVO_MENU_REMOVEFROMALTERNATIVE_LABEL = "(M) Remove from Alternative";

	@Override
	public boolean isDynamic() {

		return true;
	}

	@Override
	public void fill(Menu menu, int index) {

		// this is a hack to prevent this menu from being created twice
		if (menu.getItemCount() > MIDContextMenu.INVALID_MENU_ITEM_LIMIT) {
			return;
		}

		// check selection
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof StructuredSelection)) {
			return;
		}
		Object[] objects = ((StructuredSelection) selection).toArray();

		// get selection
		List<MAVOElement> mavoModelObjs = new ArrayList<MAVOElement>();
		for (Object object : objects) {
			GraphicalEditPart editPart = (GraphicalEditPart) object;
			EObject editPartElement = ((View) editPart.getModel()).getElement();
			if (!(editPartElement instanceof MAVOElement)) {
				continue;
			}
			mavoModelObjs.add((MAVOElement) editPartElement);
		}
		if (mavoModelObjs.isEmpty()) {
			return;
		}
		MAVOModel mavoModel = (MAVOModel) EcoreUtil.getRootContainer(mavoModelObjs.get(0), true);
		if (mavoModel.getDecisions().size() == 0) {
			return;
		}

		// create dynamic menus
		MenuItem mavoItem = new MenuItem(menu, SWT.CASCADE, index);
		mavoItem.setText(MAVO_MENU_LABEL);
		Menu mavoMenu = new Menu(menu);
		mavoItem.setMenu(mavoMenu);
		for (MAVODecision mavoDecision : mavoModel.getDecisions()) {
			if (mavoDecision instanceof MayDecision) {
				for (MAVOCollection mayAlternative : ((MayDecision) mavoDecision).getAlternatives()) {
					boolean add = false, remove = false;
					for (MAVOElement mavoModelObj : mavoModelObjs){
						if (mavoModelObj.getCollections().contains(mayAlternative)) {
							remove = true;
						}
						else {
							add = true;
						}
					}
					if (add) {
						MenuItem alternativeItem = new MenuItem(mavoMenu, SWT.NONE);
						alternativeItem.setText(MAVO_MENU_ADDTOALTERNATIVE_LABEL + " " + mayAlternative.getFormulaVariable());
						alternativeItem.addSelectionListener(
							new MAVOAlternativeAddRemoveListener(MAVO_MENU_ADDTOALTERNATIVE_LABEL, mavoModelObjs, mayAlternative, true)
						);
					}
					if (remove) {
						MenuItem alternativeItem = new MenuItem(mavoMenu, SWT.NONE);
						alternativeItem.setText(MAVO_MENU_REMOVEFROMALTERNATIVE_LABEL + " " + mayAlternative.getFormulaVariable());
						alternativeItem.addSelectionListener(
							new MAVOAlternativeAddRemoveListener(MAVO_MENU_REMOVEFROMALTERNATIVE_LABEL, mavoModelObjs, mayAlternative, false)
						);
					}
				}
			}
		}
	}

}
