/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.library.AddModifyConstraintListener;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

/**
 * The handler for the dynamic construction of a context menu for all
 * type-related operations (run operator, cast type, validate type).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MidDiagramActions extends ContributionItem {

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
		boolean doOperator = true, doCast = true, doValidate = true, doCopy = true, doProperty = true, doModelepedia = true;
		if (objects.length > 1) { // actions that don't work on multiple objects
			doCast = false;
			doValidate = false;
			doCopy = false;
			doProperty = false;
			doModelepedia = false;
		}

		// get selection
		EList<Model> models = new BasicEList<Model>();
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
				if (!MultiModelConstraintChecker.isInstancesLevel(model)) { // actions that don't work on types
					doOperator = false;
					doCast = false;
					doValidate = false;
					doCopy = false;
				}
				if (model instanceof ModelRel) { // actions that don't work on model relationships
					doCopy = false;
				}
				if (doOperator || doCast || doValidate || doCopy || doProperty || doModelepedia) {
					models.add(model);
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
			}
			if (!doOperator && !doCast && !doValidate && !doCopy && !doProperty && !doModelepedia) { // no action available
				return;
			}
		}
		if (models.isEmpty()) { // no relevant edit parts selected
			return;
		}

		// polymorphism
		EList<EList<Model>> runtimeModelTypes = null;
		if (doOperator || doCast) {
			runtimeModelTypes = new BasicEList<EList<Model>>();
			for (Model model : models) {
				runtimeModelTypes.add(new BasicEList<Model>(MultiModelTypeIntrospection.getRuntimeTypes(model)));
			}
		}
		// create dynamic menus
		MenuItem mmtfItem = new MenuItem(menu, SWT.CASCADE, index);
		mmtfItem.setText("MMTF");
		Menu mmtfMenu = new Menu(menu);
		mmtfItem.setMenu(mmtfMenu);
		// operator
		if (doOperator) {
			EList<Operator> operatorTypes = new BasicEList<Operator>();
			EList<Map<Integer, EList<ConversionOperator>>> conversions = new BasicEList<Map<Integer, EList<ConversionOperator>>>();
			EList<EList<Model>> generics = new BasicEList<EList<Model>>();
			for (Operator operatorType : MultiModelTypeRegistry.getOperatorTypes()) {
				try {
					operatorTypes.addAll(operatorType.getExecutables(models, runtimeModelTypes, conversions, generics));
				}
				catch (MMTFException e) {
					continue;
				}
			}
			if (!operatorTypes.isEmpty()) {
				MenuItem operatorItem = new MenuItem(mmtfMenu, SWT.CASCADE);
				operatorItem.setText("Run Operator");
				Menu operatorMenu = new Menu(menu);
				operatorItem.setMenu(operatorMenu);
				for (int i = 0; i < operatorTypes.size(); i++) {
					Operator operatorType = operatorTypes.get(i);
					Map<Integer, EList<ConversionOperator>> conversion = conversions.get(i);
					EList<Model> generic = generics.get(i);
					String text = operatorType.getName();
					EList<Model> actualParameters = new BasicEList<Model>();
					actualParameters.addAll(generic);
					actualParameters.addAll(models);
					if (!generic.isEmpty()) {
						text += "<";
						boolean separator = false;
						for (Model genericModel : generic) {
							if (separator) {
								text += ",";
							}
							text += genericModel.getName();
							if (!separator) {
								separator = true;
							}
						}
						text += ">";
					}
					if (operatorType instanceof ConversionOperator) {
						text += " [converter]";
					}
					if (!conversion.isEmpty()) {
						text += " [inferred]";
					}
					MenuItem operatorSubitem = new MenuItem(operatorMenu, SWT.NONE);
					operatorSubitem.setText(text);
					operatorSubitem.addSelectionListener(
						new RunOperatorListener(operatorType, actualParameters, conversion)
					);
					//TODO MMTF[OPERATOR] nice to show label of operator invocation with actual parameters
					//TODO MMTF[OPERATOR] traceability, could be nice to create an instance of operator, with name = actual parameters
				}
			}
		}
		// cast
		if (doCast) {
			if (runtimeModelTypes.get(0).size() > 1) {
				MenuItem castItem = new MenuItem(mmtfMenu, SWT.CASCADE);
				castItem.setText("Cast Type");
				Menu castMenu = new Menu(menu);
				castItem.setMenu(castMenu);
				boolean isDowncast = false;
				for (Model runtimeModelType : runtimeModelTypes.get(0)) {
					if (runtimeModelType.getUri().equals(models.get(0).getMetatypeUri())) {
						isDowncast = true;
						continue;
					}
					MenuItem castSubitem = new MenuItem(castMenu, SWT.NONE);
					String text = (isDowncast) ? runtimeModelType.getName() + DOWNCAST_LABEL : runtimeModelType.getName();
					castSubitem.setText(text);
					castSubitem.addSelectionListener(
						new CastTypeListener(models.get(0), runtimeModelType, label)
					);
				}
			}
		}
		// validate
		if (doValidate) {
			MenuItem validateItem = new MenuItem(mmtfMenu, SWT.NONE);
			validateItem.setText("Validate");
			validateItem.addSelectionListener(
				new ValidateListener(models.get(0), editParts.get(0))
			);
		}
		// copy
		if (doCopy) {
			MenuItem copyItem = new MenuItem(mmtfMenu, SWT.NONE);
			copyItem.setText("Copy Model");
			copyItem.addSelectionListener(
				new CopyModelListener(models.get(0))
			);
		}
		// constraint
		if (doProperty) {
			MenuItem propertyItem = new MenuItem(mmtfMenu, SWT.NONE);
			propertyItem.setText("Add/Modify Property");
			propertyItem.addSelectionListener(
				new AddModifyConstraintListener(models.get(0))
			);
		}
		// modelepedia
		if (doModelepedia) {
			Model model = models.get(0);
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				model = model.getMetatype();
			}
			MenuItem modelepediaItem = new MenuItem(mmtfMenu, SWT.CASCADE);
			modelepediaItem.setText("Wiki");
			Menu modelepediaMenu = new Menu(menu);
			modelepediaItem.setMenu(modelepediaMenu);
			MenuItem openModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			openModelepediaItem.setText("Open Wiki Page");
			openModelepediaItem.addSelectionListener(
				new OpenModelepediaListener(model)
			);
			MenuItem editModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			editModelepediaItem.setText("Edit Wiki Page");
			editModelepediaItem.addSelectionListener(
				new EditModelepediaListener(model)
			);
		}
	}

}
