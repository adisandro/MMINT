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

import java.util.HashMap;

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

import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeRegistry;

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
		EList<Model> actualParameters = new BasicEList<Model>();
		for (Object object : objects) {
			if (object instanceof ModelEditPart) {
				Model model = (Model) ((View) ((ModelEditPart) object).getModel()).getElement();
				actualParameters.add(model);
				continue;
			}
			if (object instanceof Model2EditPart) {
				Model model = (Model) ((View) ((Model2EditPart) object).getModel()).getElement();
				actualParameters.add(model);
				continue;
			}
			if (object instanceof ModelRelEditPart) {
				Model model = (Model) ((View) ((ModelRelEditPart) object).getModel()).getElement();
				actualParameters.add(model);
				continue;
			}
			if (object instanceof ModelRel2EditPart) {
				Model model = (Model) ((View) ((ModelRel2EditPart) object).getModel()).getElement();
				actualParameters.add(model);
				continue;
			}
			if (object instanceof BinaryModelRelEditPart) {
				Model model = (Model) ((View) ((BinaryModelRelEditPart) object).getModel()).getElement();
				actualParameters.add(model);
				continue;
			}
		}

		// get operators
		if (actualParameters.isEmpty() || actualParameters.get(0).getLevel() == MidLevel.TYPES) {
			return;
		}
		EList<HashMap<Integer, EList<ConversionOperator>>> conversions = new BasicEList<HashMap<Integer, EList<ConversionOperator>>>();
		EList<Operator> operators = MultiModelTypeRegistry.getExecutableOperators(actualParameters, conversions);
		if (operators.isEmpty()) {
			return;
		}

		// create dynamic menu
		MenuItem cascadeItem = new MenuItem(menu, SWT.CASCADE, index);
		cascadeItem.setText("Run Operator");
		Menu operatorsMenu = new Menu(menu);
		cascadeItem.setMenu(operatorsMenu);
		for (int i = 0; i < operators.size(); i++) {
			Operator operator = operators.get(i);
			HashMap<Integer, EList<ConversionOperator>> conversionMap = conversions.get(i);
			MenuItem operatorItem = new MenuItem(operatorsMenu, SWT.NONE);
			String itemText = operator.getName();
			if (operator instanceof ConversionOperator) {
				itemText += " [converter]";
			}
			if (!conversionMap.isEmpty()) {
				itemText += " [inferred]";
			}
			operatorItem.setText(itemText);
			operatorItem.addSelectionListener(
				new RunOperatorListener(operator, actualParameters, conversionMap)
			);
			//TODO MMTF: nice to show label of operator invocation with actual parameters
			//TODO MMTF: traceability, could be nice to create an instance of operator, with name = actual parameters
		}
	}

}
