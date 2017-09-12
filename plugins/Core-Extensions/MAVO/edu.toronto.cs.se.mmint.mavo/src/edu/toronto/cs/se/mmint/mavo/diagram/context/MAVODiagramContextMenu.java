/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.diagram.context;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
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
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.SetDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;

/**
 * The handler for the dynamic construction of a context menu for all
 * MAVO operations.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MAVODiagramContextMenu extends ContributionItem {

	private static final @NonNull String MAVO_CONTEXT_MENU_LABEL = "MAVO";
	private static final @NonNull String MAVO_CONTEXT_MENU_REFINEONE_LABEL = "Choose this element and refine";
	private static final @NonNull String MAVO_CONTEXT_MENU_REFINEMULTI_LABEL = "Choose these elements and refine";
	private static final @NonNull String MAVO_CONTEXT_MENU_MAYDECISION_LABEL = "May decision";
	private static final @NonNull String MAVO_CONTEXT_MENU_VARDECISION_LABEL = "Var decision";
	private static final @NonNull String MAVO_CONTEXT_MENU_SETDECISION_LABEL = "Set decision";
	private static final @NonNull String MAVO_CONTEXT_MENU_MAYDECISION_SUBMENU_ADDTOALTERNATIVE_LABEL = "Add to alternative";
	private static final @NonNull String MAVO_CONTEXT_MENU_VARDECISION_SUBMENU_ADDTODOMAIN_LABEL = "Add to domain";
	private static final @NonNull String MAVO_CONTEXT_MENU_SETDECISION_SUBMENU_ADDTOENTITY_LABEL = "Add to entity";
	private static final @NonNull String MAVO_CONTEXT_MENU_MAYDECISION_SUBMENU_REMOVEFROMALTERNATIVE_LABEL = "Remove from alternative";
	private static final @NonNull String MAVO_CONTEXT_MENU_VARDECISION_SUBMENU_REMOVEFROMDOMAIN_LABEL = "Remove from domain";
	private static final @NonNull String MAVO_CONTEXT_MENU_SETDECISION_SUBMENU_REMOVEFROMENTITY_LABEL = "Remove from entity";

	@Override
	public boolean isDynamic() {

		return true;
	}

	@Override
	public void fill(Menu menu, int index) {

		// check selection
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof StructuredSelection)) {
			return;
		}
		Object[] objects = ((StructuredSelection) selection).toArray();

		// get selection
		List<MAVOElement> mavoModelObjs = new ArrayList<>();
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
		MAVORoot mavoRootModelObj = (MAVORoot) EcoreUtil.getRootContainer(mavoModelObjs.get(0), true);
		if (mavoRootModelObj.getDecisions().size() == 0) {
			return;
		}

		// create menus
		MenuItem mavoItem = new MenuItem(menu, SWT.CASCADE, index);
		mavoItem.setText(MAVO_CONTEXT_MENU_LABEL);
		Menu mavoMenu = new Menu(menu);
		mavoItem.setMenu(mavoMenu);
		// refine
		if (mavoModelObjs.stream().anyMatch(mavoModelObj -> mavoModelObj.isMay())) {
			MenuItem refineItem = new MenuItem(mavoMenu, SWT.NONE);
			String refineText = (mavoModelObjs.size() == 1) ?
				MAVO_CONTEXT_MENU_REFINEONE_LABEL :
				MAVO_CONTEXT_MENU_REFINEMULTI_LABEL;
			refineItem.setText(refineText);
			refineItem.addSelectionListener(
				new MAVODiagramContextRefineListener(refineText, mavoModelObjs)
			);
		}
		// add/remove
		for (MAVODecision mavoDecision : mavoRootModelObj.getDecisions()) {
			MenuItem decisionItem = new MenuItem(mavoMenu, SWT.CASCADE);
			Menu decisionMenu = new Menu(mavoMenu);
			decisionItem.setMenu(decisionMenu);
			String decisionText = "", addLabel = "", removeLabel = "";
			List<MAVOCollection> mavoCollections = null;
			if (mavoDecision instanceof MayDecision) {
				decisionText = MAVO_CONTEXT_MENU_MAYDECISION_LABEL;
				addLabel = MAVO_CONTEXT_MENU_MAYDECISION_SUBMENU_ADDTOALTERNATIVE_LABEL;
				removeLabel = MAVO_CONTEXT_MENU_MAYDECISION_SUBMENU_REMOVEFROMALTERNATIVE_LABEL;
				mavoCollections = ((MayDecision) mavoDecision).getAlternatives();
			}
			else if (mavoDecision instanceof VarDecision) {
				decisionText = MAVO_CONTEXT_MENU_VARDECISION_LABEL;
				addLabel = MAVO_CONTEXT_MENU_VARDECISION_SUBMENU_ADDTODOMAIN_LABEL;
				removeLabel = MAVO_CONTEXT_MENU_VARDECISION_SUBMENU_REMOVEFROMDOMAIN_LABEL;
				mavoCollections = new ArrayList<MAVOCollection>();
				mavoCollections.add(((VarDecision) mavoDecision).getDomain());
			}
			else if (mavoDecision instanceof SetDecision) {
				decisionText = MAVO_CONTEXT_MENU_SETDECISION_LABEL;
				addLabel = MAVO_CONTEXT_MENU_SETDECISION_SUBMENU_ADDTOENTITY_LABEL;
				removeLabel = MAVO_CONTEXT_MENU_SETDECISION_SUBMENU_REMOVEFROMENTITY_LABEL;
				mavoCollections = new ArrayList<MAVOCollection>();
				mavoCollections.add(((SetDecision) mavoDecision).getEntity());
			}
			decisionText += " " + mavoDecision.getFormulaVariable();
			decisionItem.setText(decisionText);
			for (MAVOCollection mavoCollection : mavoCollections) {
				boolean add = mavoModelObjs.stream().allMatch(mavoModelObj -> !mavoModelObj.getCollections().contains(mavoCollection));
				boolean remove = false;
				if (!add) {
					remove = mavoModelObjs.stream().allMatch(mavoModelObj -> mavoModelObj.getCollections().contains(mavoCollection));
				}
				if (!add && !remove) {
					continue;
				}
				String addremoveText = "";
				MIDContextMenuListener addremoveListener = null;
				if (add) {
					addremoveText = addLabel + " " + mavoCollection.getFormulaVariable();
					addremoveListener = new MAVODiagramContextAddListener(addremoveText, mavoCollection, mavoModelObjs);
				}
				if (remove) {
					addremoveText = removeLabel + " " + mavoCollection.getFormulaVariable();
					addremoveListener = new MAVODiagramContextRemoveListener(addremoveText, mavoCollection, mavoModelObjs);
				}
				MenuItem addremoveItem = new MenuItem(decisionMenu, SWT.NONE);
				addremoveItem.setText(addremoveText);
				addremoveItem.addSelectionListener(addremoveListener);
			}
		}
	}

}
