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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;

/**
 * The handler for the dynamic construction of a context menu to run operators.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RunOperatorAction extends ContributionItem {

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
		//TODO MMTF: rename to actualParameters
		EList<Model> models = new BasicEList<Model>();
		for (Object object : objects) {
			if (object instanceof ModelEditPart) {
				Model model = (Model) ((View) ((ModelEditPart) object).getModel()).getElement();
				models.add(model);
				continue;
			}
			if (object instanceof Model2EditPart) {
				Model model = (Model) ((View) ((Model2EditPart) object).getModel()).getElement();
				models.add(model);
				continue;
			}
			if (object instanceof ModelRelEditPart) {
				Model model = (Model) ((View) ((ModelRelEditPart) object).getModel()).getElement();
				models.add(model);
				continue;
			}
			if (object instanceof ModelRel2EditPart) {
				Model model = (Model) ((View) ((ModelRel2EditPart) object).getModel()).getElement();
				models.add(model);
				continue;
			}
			if (object instanceof BinaryModelRelEditPart) {
				Model model = (Model) ((View) ((BinaryModelRelEditPart) object).getModel()).getElement();
				models.add(model);
				continue;
			}
		}

		// create basic menu and get operators
		MenuItem cascadeItem = new MenuItem(menu, SWT.CASCADE, index);
		if (models.isEmpty()) {
			cascadeItem.setText("No Operator Available");
			return;
		}
		EList<Operator> operators = MMTFRegistry.getExecutableOperators(models);
		if (operators.isEmpty()) {
			cascadeItem.setText("No Operator Available");
			return;
		}

		// create dynamic menu
		cascadeItem.setText("Run Operator");
		Menu operatorsMenu = new Menu(menu);
		cascadeItem.setMenu(operatorsMenu);
		for (Operator operator : operators) {
			MenuItem operatorItem = new MenuItem(operatorsMenu, SWT.NONE);
			operatorItem.setText(operator.getName());
			operatorItem.addSelectionListener(
				new RunOperatorListener(operator, models)
			);
			//TODO MMTF: nice to show label of operator invocation with actual parameters
		}
	}

}
