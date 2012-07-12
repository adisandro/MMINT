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

public class ModelepediaAction extends ContributionItem {

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
		Model modelType = null;
		if (objects[0] instanceof ModelEditPart) {
			modelType = (Model) ((View) ((ModelEditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof Model2EditPart) {
			modelType = (Model) ((View) ((Model2EditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof ModelRelEditPart) {
			modelType = (Model) ((View) ((ModelRelEditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof ModelRel2EditPart) {
			modelType = (Model) ((View) ((ModelRel2EditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof BinaryModelRelEditPart) {
			modelType = (Model) ((View) ((BinaryModelRelEditPart) objects[0]).getModel()).getElement();
		}
		if (modelType == null) {
			return;
		}

		// get model type
		if (modelType.getLevel() == MidLevel.INSTANCES) {
			modelType = modelType.getMetatype();
			if (modelType == null) {
				return;
			}
		}

		// create dynamic menu
		MenuItem cascadeItem = new MenuItem(menu, SWT.CASCADE, index);
		cascadeItem.setText("MMTF Wiki");
		// just one sub item for now
		Menu modelepediaMenu = new Menu(menu);
		cascadeItem.setMenu(modelepediaMenu);
		MenuItem openModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
		openModelepediaItem.setText("Open wiki page");
		openModelepediaItem.addSelectionListener(
			new OpenModelepediaListener(modelType)
		);
		MenuItem editModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
		editModelepediaItem.setText("Edit wiki page");
		editModelepediaItem.addSelectionListener(
			new EditModelepediaListener(modelType)
		);
	}

}
