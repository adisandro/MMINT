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
import java.util.Map;

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

import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;

/**
 * The handler for the dynamic construction of a context menu for all
 * type-related operations (run operator, cast type, validate type).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class TypeActions extends ContributionItem {

	private static final int INVALID_MENU_ITEM_LIMIT = 20;
	private static final String DOWNCAST_LABEL = " (downcast)";

	@Override
	public boolean isDynamic() {

		return true;
	}

	@Override
	public void fill(Menu menu, int index) {

		// this is a hack to prevent this menu from being created twice
		if (menu.getItemCount() > INVALID_MENU_ITEM_LIMIT) {
			return;
		}

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
		for (Object object : objects) {
			if (
				object instanceof ModelEditPart ||
				object instanceof Model2EditPart ||
				object instanceof ModelRelEditPart ||
				object instanceof ModelRel2EditPart ||
				object instanceof BinaryModelRelEditPart
			) {
				GraphicalEditPart editPart = (GraphicalEditPart) object;
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
				if (!MultiModelConstraintChecker.isInstancesLevel(model)) { // actions don't work on types
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

		// polymorphism
		List<List<Model>> runtimeModelTypes = null;
		if (doOperator || doCast) {
			runtimeModelTypes = new ArrayList<List<Model>>();
			for (Model actualParameter : actualParameters) {
				runtimeModelTypes.add(MultiModelTypeIntrospection.getRuntimeTypes(actualParameter));
			}
		}
		// create dynamic menus
		// run operator
		if (doOperator) {
			List<Map<Integer, List<ConversionOperator>>> conversions = new ArrayList<Map<Integer, List<ConversionOperator>>>();
			List<Operator> operators = MultiModelTypeHierarchy.getExecutableOperators(actualParameters, runtimeModelTypes, conversions);
			if (!operators.isEmpty()) {
				MenuItem operatorItem = new MenuItem(menu, SWT.CASCADE, index);
				operatorItem.setText("Run Operator");
				Menu operatorMenu = new Menu(menu);
				operatorItem.setMenu(operatorMenu);
				for (int i = 0; i < operators.size(); i++) {
					Operator operator = operators.get(i);
					Map<Integer, List<ConversionOperator>> conversionMap = conversions.get(i);
					MenuItem operatorSubitem = new MenuItem(operatorMenu, SWT.NONE);
					String text = operator.getName();
					if (operator instanceof ConversionOperator) {
						text += " [converter]";
					}
					if (!conversionMap.isEmpty()) {
						text += " [inferred]";
					}
					operatorSubitem.setText(text);
					operatorSubitem.addSelectionListener(
						new RunOperatorListener(operator, actualParameters, conversionMap)
					);
					//TODO MMTF: nice to show label of operator invocation with actual parameters
					//TODO MMTF: traceability, could be nice to create an instance of operator, with name = actual parameters
				}
			}
		}
		// cast type
		if (doCast) {
			if (runtimeModelTypes.get(0).size() > 1) {
				MenuItem castItem = new MenuItem(menu, SWT.CASCADE, index);
				castItem.setText("Cast Type");
				Menu castMenu = new Menu(menu);
				castItem.setMenu(castMenu);
				boolean isDowncast = true;
				for (Model runtimeModelType : runtimeModelTypes.get(0)) {
					if (runtimeModelType.getUri().equals(actualParameters.get(0).getMetatypeUri())) {
						isDowncast = false;
						continue;
					}
					MenuItem castSubitem = new MenuItem(castMenu, SWT.NONE);
					String text = (isDowncast) ? runtimeModelType.getName() + DOWNCAST_LABEL : runtimeModelType.getName();
					castSubitem.setText(text);
					castSubitem.addSelectionListener(
						new CastTypeListener(actualParameters.get(0), runtimeModelType, label)
					);
				}
			}
		}
		// validate type
		if (doValidate) {
			MenuItem validateItem = new MenuItem(menu, SWT.NONE, index);
			String text = (actualParameters.size() > 1) ? "Validate Types" : "ValidateType";
			validateItem.setText(text);
			validateItem.addSelectionListener(
				new ValidateTypeListener(actualParameters, runtimeModelTypes, editParts)
			);
		}
	}

}
