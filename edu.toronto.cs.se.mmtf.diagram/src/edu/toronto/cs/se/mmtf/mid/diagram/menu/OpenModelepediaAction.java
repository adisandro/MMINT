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
package edu.toronto.cs.se.mmtf.mid.diagram.menu;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;

public class OpenModelepediaAction extends ContributionItem {

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
		if (objects.length > 1) {
			return;
		}
		Model model = null;
		if (objects[0] instanceof ModelEditPart) {
			model = (Model) ((View) ((ModelEditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof Model2EditPart) {
			model = (Model) ((View) ((Model2EditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof ModelRelEditPart) {
			model = (Model) ((View) ((ModelRelEditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof ModelRel2EditPart) {
			model = (Model) ((View) ((ModelRel2EditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof BinaryModelRelEditPart) {
			model = (Model) ((View) ((BinaryModelRelEditPart) objects[0]).getModel()).getElement();
		}
		if (model == null) {
			return;
		}

		// get model type
		String modelTypeName;
		if (model.getLevel() == MidLevel.TYPES) {
			modelTypeName = model.getName();
		}
		else {
			Model modelType = (Model) model.getMetatype();
			if (modelType == null) {
				return;
			}
			modelTypeName = model.getMetatype().getName();
		}

		// create dynamic menu
		MenuItem cascadeItem = new MenuItem(menu, SWT.CASCADE, index);
		cascadeItem.setText("Modelepedia");
		// just one sub item for now
		Menu modelepediaMenu = new Menu(menu);
		cascadeItem.setMenu(modelepediaMenu);
		MenuItem modelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
		modelepediaItem.setText("Open Modelepedia page");
		modelepediaItem.addSelectionListener(
			new OpenModelepediaListener(modelTypeName)
		);
	}

}
