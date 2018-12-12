/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
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
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.SetDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mavo.diagram.context.MAVODiagramContextAddListener;
import edu.toronto.cs.se.mmint.mavo.diagram.context.MAVODiagramContextRefineListener;
import edu.toronto.cs.se.mmint.mavo.diagram.context.MAVODiagramContextRemoveListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;

public class MAVODiagramOutlineContextMenu extends ContributionItem {

	private static final @NonNull String MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL = "Highlight this decision in the diagram";
	private static final @NonNull String MAVO_OUTLINE_MENU_HIGHLIGHTALTERNATIVE_LABEL = "Highlight this alternative in the diagram";
	private static final @NonNull String MAVO_OUTLINE_MENU_HIGHLIGHTDOMAIN_LABEL = "Highlight this domain in the diagram";
	private static final @NonNull String MAVO_OUTLINE_MENU_HIGHLIGHTENTITY_LABEL = "Highlight this entity in the diagram";
	private static final @NonNull String MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL = "Highlight this element in the diagram";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL = "Choose this alternative and refine";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEDOMAIN_LABEL = "Merge this domain and refine";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEMAYELEMENT_LABEL = "Choose this may element and refine";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTO_LABEL = "Into";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTONEW_LABEL = MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTO_LABEL + " a new object";
	private static final @NonNull String MAVO_OUTLINE_MENU_REFINEVARELEMENTS_LABEL = "Merge these var elements and refine";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDDECISION_LABEL = "Add new decision";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL = "May";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL = "Var";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_SET_LABEL = "Set";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL = "Add new alternative";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDDOMAIN_LABEL = "Add new domain";
	private static final @NonNull String MAVO_OUTLINE_MENU_ADDENTITY_LABEL = "Add new entity";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL = "Remove this decision";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEALTERNATIVE_LABEL = "Remove this alternative";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEDOMAIN_LABEL = "Remove this domain";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEENTITY_LABEL = "Remove this entity";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEALTERNATIVEELEMENT_LABEL = "Remove this element from the alternative";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEDOMAINELEMENT_LABEL = "Remove this element from the domain";
	private static final @NonNull String MAVO_OUTLINE_MENU_REMOVEENTITYELEMENT_LABEL = "Remove this element from the entity";

	private TreeViewer viewer;

	public MAVODiagramOutlineContextMenu(TreeViewer viewer) {

		this.viewer = viewer;
	}

	@Override
	public boolean isDynamic() {

		return true;
	}

	@Override
	public void fill(Menu menu, int index) {

		// check selection
		IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
		if (selection == null || selection.isEmpty() || !(selection instanceof TreeSelection)) {
			return;
		}
		Object[] objects = ((TreeSelection) selection).toArray();
		//TODO MMINT[MU-MMINT] Allow refine with multiple may model objects
		if (objects.length > 1) {
			MAVOCollection mavoCollection = null;
			for (Object object : objects) {
				if (!(object instanceof MAVOElement)) { // only model objects
					return;
				}
				//TODO MMINT[MAVO] Check when same element is in two open paths (e.g. a may alternative and a var domain)
				Object treeContainer = ((TreeSelection) selection).getPathsFor(object)[0].getParentPath().getLastSegment();
				if (
					!(treeContainer instanceof MAVOCollection) || // only in decisions
					!(((MAVOCollection) treeContainer).eContainer() instanceof VarDecision) // only var decision
				) {
					return;
				}
				if (mavoCollection == null) {
					mavoCollection = (MAVOCollection) treeContainer;
				}
				if (treeContainer != mavoCollection) { // only from the same var domain
					return;
				}
			}
		}

		// create menus
		Object object = objects[0];
		if (object instanceof MAVORoot) {
			MAVORoot mavoRootModelObj = (MAVORoot) object;
			// add
			Menu addMenu = addCascadeMenuItem(menu, MAVO_OUTLINE_MENU_ADDDECISION_LABEL);
			addMenuItem(
				addMenu,
				MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL,
				new MAVODiagramContextAddListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL + " " + MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_MAY_LABEL, mavoRootModelObj, MAVOPackage.eINSTANCE.getMayDecision())
			);
			addMenuItem(
				addMenu,
				MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL,
				new MAVODiagramContextAddListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL + " " + MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_VAR_LABEL, mavoRootModelObj, MAVOPackage.eINSTANCE.getVarDecision())
			);
			addMenuItem(
				addMenu,
				MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_SET_LABEL,
				new MAVODiagramContextAddListener(MAVO_OUTLINE_MENU_ADDDECISION_LABEL + " " + MAVO_OUTLINE_MENU_ADDDECISION_SUBMENU_SET_LABEL, mavoRootModelObj, MAVOPackage.eINSTANCE.getSetDecision())
			);
		}
		else if (object instanceof MAVODecision) {
			MAVODecision mavoDecision = (MAVODecision) object;
			// highlight
			addMenuItem(
				menu,
				MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL,
				new MAVODiagramOutlineContextHighlightListener(MAVO_OUTLINE_MENU_HIGHLIGHTDECISION_LABEL, mavoDecision)
			);
			// add
			if (
				mavoDecision instanceof MayDecision ||
				(mavoDecision instanceof VarDecision && ((VarDecision) mavoDecision).getDomain() == null) ||
				(mavoDecision instanceof SetDecision && ((SetDecision) mavoDecision).getEntity() == null)
			) {
				String addText = "";
				if (mavoDecision instanceof MayDecision) {
					addText = MAVO_OUTLINE_MENU_ADDALTERNATIVE_LABEL;
				}
				else if (mavoDecision instanceof VarDecision) {
					addText = MAVO_OUTLINE_MENU_ADDDOMAIN_LABEL;
				}
				else if (mavoDecision instanceof SetDecision) {
					addText = MAVO_OUTLINE_MENU_ADDENTITY_LABEL;
				}
				addMenuItem(
					menu,
					addText,
					new MAVODiagramContextAddListener(addText, mavoDecision)
				);
			}
			// remove
			addMenuItem(
				menu,
				MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL,
				new MAVODiagramContextRemoveListener(MAVO_OUTLINE_MENU_REMOVEDECISION_LABEL, mavoDecision)
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
			else if (mavoCollection.eContainer() instanceof SetDecision) {
				highlightText = MAVO_OUTLINE_MENU_HIGHLIGHTENTITY_LABEL;
				removeText = MAVO_OUTLINE_MENU_REMOVEENTITY_LABEL;
			}
			// highlight
			addMenuItem(
				menu,
				highlightText,
				new MAVODiagramOutlineContextHighlightListener(highlightText, mavoCollection)
			);
			// refine
			if (mavoCollection.eContainer() instanceof MayDecision) {
				addMenuItem(
					menu,
					MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL,
					new MAVODiagramContextRefineListener(MAVO_OUTLINE_MENU_REFINEALTERNATIVE_LABEL, mavoCollection)
				);
			}
			else if (mavoCollection.eContainer() instanceof VarDecision) {
				//TODO MMINT[VAR-MMINT] Unify with var refine for mavo elements
				Menu varRefineMenu = addCascadeMenuItem(menu, MAVO_OUTLINE_MENU_REFINEDOMAIN_LABEL);
				for (MAVOElement varModelObj : mavoCollection.getMavoElements()) {
					String mergeText = MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTO_LABEL + " " + varModelObj.getFormulaVariable();
					addMenuItem(
						varRefineMenu,
						mergeText,
						new MAVODiagramContextRefineListener(mergeText, mavoCollection, varModelObj, mavoCollection.getMavoElements())
					);
				}
				addMenuItem(
					varRefineMenu,
					MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTONEW_LABEL,
					new MAVODiagramContextRefineListener(MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTONEW_LABEL, mavoCollection, null, mavoCollection.getMavoElements())
				);
			}
			// remove
			addMenuItem(
				menu,
				removeText,
				new MAVODiagramContextRemoveListener(removeText, mavoCollection)
			);
		}
		else if (object instanceof MAVOElement) {
			@SuppressWarnings("unchecked")
			List<MAVOElement> mavoModelObjs = new ArrayList<MAVOElement>((List<? extends MAVOElement>) Arrays.asList(objects));
			Object treeContainer = ((TreeSelection) selection).getPathsFor(mavoModelObjs.get(0))[0].getParentPath().getLastSegment();
			// highlight
			addMenuItem(
				menu,
				MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL,
				new MAVODiagramOutlineContextHighlightListener(MAVO_OUTLINE_MENU_HIGHLIGHTELEMENT_LABEL, mavoModelObjs.get(0))
			);
			// refine
			if (
				!(treeContainer instanceof MAVOCollection) ||
				((MAVOCollection) treeContainer).eContainer() instanceof MayDecision
			) {
				addMenuItem(
					menu,
					MAVO_OUTLINE_MENU_REFINEMAYELEMENT_LABEL,
					new MAVODiagramContextRefineListener(MAVO_OUTLINE_MENU_REFINEMAYELEMENT_LABEL, mavoModelObjs)
				);
			}
			/*TODO MMINT[VAR-MMINT]
			 * 1) Merge (x+y elements in domain):
			 * 1a) Select x elements, merge contents, remove x elements, remove V from x+y, remove decision
			 * 1abis) Clicking on the domain itself means y is empty
			 * 1ater) Clicking a single element doesn't allow merge
			 * 1b) Submenu to select where to merge, one of the x elements or a new one
			 * 1c) Apply same listener to outline context and diagram context
			 * 1d) Assign new formula id to the merge result if a new element is created
			 * 2) Check highlighting:
			 * 2a) of contained objects not in compartments
			 * 2b) of contained objects in compartments when var
			 * 2c) of compartments only (non-square)
			 * 3) Add to domain should be constrained by mergeable function
			 */
			else if (
				(((MAVOCollection) treeContainer).eContainer() instanceof VarDecision) &&
				(mavoModelObjs.size() > 1)
			) {
				Menu varRefineMenu = addCascadeMenuItem(menu, MAVO_OUTLINE_MENU_REFINEVARELEMENTS_LABEL);
				MAVOCollection varDomain = (MAVOCollection) treeContainer;
				for (MAVOElement varModelObj : mavoModelObjs) {
					String mergeText = MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTO_LABEL + " " + varModelObj.getFormulaVariable();
					addMenuItem(
						varRefineMenu,
						mergeText,
						new MAVODiagramContextRefineListener(mergeText, varDomain, varModelObj, mavoModelObjs)
					);
				}
				addMenuItem(
					varRefineMenu,
					MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTONEW_LABEL,
					new MAVODiagramContextRefineListener(MAVO_OUTLINE_MENU_REFINEVAR_SUBMENU_INTONEW_LABEL, varDomain, null, mavoModelObjs)
				);
			}
			// remove
			if (treeContainer instanceof MAVOCollection) {
				MAVOCollection mavoCollection = (MAVOCollection) treeContainer;
				String removeText = "";
				if (mavoCollection.eContainer() instanceof MayDecision) {
					removeText = MAVO_OUTLINE_MENU_REMOVEALTERNATIVEELEMENT_LABEL;
				}
				else if (mavoCollection.eContainer() instanceof VarDecision) {
					removeText = MAVO_OUTLINE_MENU_REMOVEDOMAINELEMENT_LABEL;
				}
				else if (mavoCollection.eContainer() instanceof SetDecision) {
					removeText = MAVO_OUTLINE_MENU_REMOVEENTITYELEMENT_LABEL;
				}
				addMenuItem(
					menu,
					removeText,
					new MAVODiagramContextRemoveListener(removeText, mavoCollection, mavoModelObjs)
				);
			}
		}
	}

	//TODO MMINT[MISC] Move in some util class, use it everywhere
	private @NonNull MenuItem addMenuItem(@NonNull Menu menu, @NonNull String menuItemText, @NonNull MIDContextMenuListener menuItemListener) {

		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.setText(menuItemText);
		menuItem.addSelectionListener(menuItemListener);

		return menuItem;
	}

	//TODO MMINT[MISC] Move in some util class, use it everywhere
	private @NonNull Menu addCascadeMenuItem(@NonNull Menu menu, @NonNull String menuItemText) {

		MenuItem cascadeMenuItem = new MenuItem(menu, SWT.CASCADE);
		cascadeMenuItem.setText(menuItemText);
		Menu cascadeMenu = new Menu(menu);
		cascadeMenuItem.setMenu(cascadeMenu);

		return cascadeMenu;
	}

}
