/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.contextmenu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

/**
 * The handler for the dynamic construction of a context menu for all
 * type-related operations (run operator, cast type, validate type).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class TypeActions extends ContributionItem {

	private static final String DOWNCAST_LABEL = " (downcast)";

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
		boolean doOperator = true, doCast = true, doValidate = true;
		if (objects.length > 1) { // cast doesn't work on multiple objects
			doCast = false;
		}

		// get selection
		EList<Model> actualParameters = new BasicEList<Model>();
		ITextAwareEditPart label = null;
		List<GraphicalEditPart> editParts = new ArrayList<GraphicalEditPart>();
		for (int i = 0; i < objects.length; i++) {
			if (
				objects[i] instanceof ModelEditPart ||
				objects[i] instanceof Model2EditPart ||
				objects[i] instanceof ModelRelEditPart ||
				objects[i] instanceof ModelRel2EditPart ||
				objects[i] instanceof BinaryModelRelEditPart
			) {
				GraphicalEditPart editPart = (GraphicalEditPart) objects[i];
				Model model = (Model) ((View) editPart.getModel()).getElement();
				if (doOperator) {
					actualParameters.add(model);
				}
				if (doCast) {
					for (Object child : editPart.getChildren()) {
						if (child instanceof ITextAwareEditPart) {
							label = (ITextAwareEditPart) child;
							break;
						}
					}
				}
				if (doValidate) {
					editParts.add(editPart);
				}
				if (MultiModelConstraintChecker.isInstancesLevel(model)) { // actions don't work on types
					doOperator = false;
					doCast = false;
					doValidate = false;
				}
			}
			if (!doOperator && !doCast && !doValidate) { // no action available
				return;
			}
		}
		if (actualParameters.isEmpty()) { // no relevant edit parts selected
			return;
		}

		//TODO MMTF: evaluate additional constraints
		// polymorphism
		List<List<Model>> runtimeTypes = null;
		if (doOperator || doCast) {
			runtimeTypes = new ArrayList<List<Model>>();
			for (Model actualParameter : actualParameters) {
				runtimeTypes.add(MultiModelTypeIntrospection.getRuntimeTypes(actualParameter));
			}
		}
		//TODO MMTF: use runtime types everywhere they're needed

		// create dynamic menus
		// run operator
		if (doOperator) {
			MenuItem operatorItem = new MenuItem(menu, SWT.CASCADE, index);
			operatorItem.setText("Run Operator");
			Menu operatorsMenu = new Menu(menu);
			operatorItem.setMenu(operatorsMenu);
		}
		// cast type
		if (doCast) {
			MenuItem castItem = new MenuItem(menu, SWT.CASCADE, index);
			castItem.setText("Cast Type");
			Menu castMenu = new Menu(menu);
			castItem.setMenu(castMenu);
		}
		// validate type
		if (doValidate) {
			MenuItem validateItem = new MenuItem(menu, SWT.NONE, index);
			validateItem.setText("Validate Type");
		}
	}

}
