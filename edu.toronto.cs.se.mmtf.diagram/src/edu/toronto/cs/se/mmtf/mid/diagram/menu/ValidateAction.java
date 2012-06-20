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

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The handler for the dynamic construction of a context menu to cast to a
 * specialized type.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ValidateAction extends ContributionItem {

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
		GraphicalEditPart editPart = null;
		if (
			objects[0] instanceof ModelEditPart ||
			objects[0] instanceof Model2EditPart ||
			objects[0] instanceof ModelRelEditPart ||
			objects[0] instanceof ModelRel2EditPart
		) {
			editPart = (GraphicalEditPart) objects[0];
			model = (Model) ((View) ((ShapeNodeEditPart) objects[0]).getModel()).getElement();
		}
		else if (objects[0] instanceof BinaryModelRelEditPart) {
			editPart = (GraphicalEditPart) objects[0];
			model = (Model) ((View) ((ConnectionNodeEditPart) objects[0]).getModel()).getElement();
		}
		if (
			model == null ||
			((Model) model.getMetatype()).getConstraint() == null ||
			!MultiModelConstraintChecker.isInstancesLevel((MultiModel) model.eContainer())
		) {
			return;
		}

		// get OCL constraint
		String oclConstraint = ((Model) model.getMetatype()).getConstraint().getBody();

		// create dynamic menu
		MenuItem validateItem = new MenuItem(menu, SWT.NONE, index);
		validateItem.setText("Validate");
		validateItem.addSelectionListener(
			new ValidateListener(model, editPart, oclConstraint)
		);
	}

}
