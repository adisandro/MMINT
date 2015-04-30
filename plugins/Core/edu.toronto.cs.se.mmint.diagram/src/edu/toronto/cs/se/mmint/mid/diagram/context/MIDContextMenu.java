/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.library.AddModifyConstraintListener;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The handler for the dynamic construction of a context menu for all
 * type-related operations (run operator, cast type, validate type).
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDContextMenu extends ContributionItem {

	public static final int INVALID_MENU_ITEM_LIMIT = 20;
	public static final String MMINT_MENU_LABEL = "MMINT";
	private static final String MMINT_MENU_OPERATOR_LABEL = "Run Operator";
	private static final String MMINT_MENU_CAST_LABEL = "Cast Type";
	private static final String MMINT_MENU_COHERENCE_LABEL = "Check Runtime Coherence";
	private static final String MMINT_MENU_ADDCONSTRAINT_LABEL = "Add/Modify Constraint";
	private static final String MMINT_MENU_CHECKCONSTRAINT_LABEL = "Check Constraint";
	private static final String MMINT_MENU_REFINEBYCONSTRAINT_LABEL = "Refine by Constraint";
	private static final String MMINT_MENU_COPY_LABEL = "Copy Model";
	private static final String MMINT_MENU_MODELEPEDIA_LABEL = "Wiki";
	private static final String MMINT_MENU_MODELEPEDIA_SUBMENU_OPEN_LABEL = "Open Wiki Page";
	private static final String MMINT_MENU_MODELEPEDIA_SUBMENU_EDIT_LABEL = "Edit Wiki Page";
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
		boolean doOperator = true, doCast = true, doAddConstraint = true, doCheckConstraint = true, doRefineByConstraint = true, doCopy = true, doModelepedia = true, doCoherence = true;
		if (objects.length > 1) { // actions that don't work on multiple objects
			doCast = false;
			doCheckConstraint = false;
			doCopy = false;
			doAddConstraint = false;
			doModelepedia = false;
			doCoherence = false;
			doRefineByConstraint = false;
		}

		// get model selection
		MultiModel instanceMID = null;
		EList<Model> selectedModels = new BasicEList<Model>();
		ITextAwareEditPart label = null;
		List<GraphicalEditPart> editParts = new ArrayList<GraphicalEditPart>();
		for (Object object : objects) {
			if (!(
				object instanceof MultiModelEditPart ||
				object instanceof ModelEditPart ||
				object instanceof Model2EditPart ||
				object instanceof ModelRelEditPart ||
				object instanceof ModelRel2EditPart ||
				object instanceof BinaryModelRelEditPart
			)) {
				continue;
			}
			GraphicalEditPart editPart = (GraphicalEditPart) object;
			EObject editPartElement = ((View) editPart.getModel()).getElement();
			if (editPartElement instanceof MultiModel) {
				doCast = false;
				doCheckConstraint = false;
				doCopy = false;
				doAddConstraint = false;
				doModelepedia = false;
				doCoherence = false;
				doRefineByConstraint = false;
				if (MultiModelConstraintChecker.isInstancesLevel((MultiModel) editPartElement)) { // instances only
					instanceMID = (MultiModel) editPartElement;
				}
			}
			else {
				Model model = (Model) editPartElement;
				if (!MultiModelConstraintChecker.isInstancesLevel(model)) { // instances only
					doOperator = false;
					doCast = false;
					doCheckConstraint = false;
					doCopy = false;
					doCoherence = false;
					doRefineByConstraint = false;
				}
				if (model instanceof ModelRel) { // actions that don't work on model relationships
					doCopy = false;
				}
				if (doOperator || doCast || doCheckConstraint || doCopy || doAddConstraint || doModelepedia || doCoherence || doRefineByConstraint) {
					selectedModels.add(model);
				}
				if (doCast) {
					for (Object child : editPart.getChildren()) {
						if (child instanceof ITextAwareEditPart) {
							label = (ITextAwareEditPart) child;
							break;
						}
					}
				}
				if (doCheckConstraint) {
					editParts.add(editPart);
				}
			}
			if (!doOperator && !doCast && !doCheckConstraint && !doCopy && !doAddConstraint && !doModelepedia && !doCoherence && !doRefineByConstraint) { // no action available
				return;
			}
		}
		if (instanceMID == null && selectedModels.isEmpty()) { // no relevant edit parts selected
			return;
		}

		// create dynamic menus
		MenuItem mmintItem = new MenuItem(menu, SWT.CASCADE, index);
		mmintItem.setText(MMINT_MENU_LABEL);
		Menu mmintMenu = new Menu(menu);
		mmintItem.setMenu(mmintMenu);
		// operator
		if (doOperator) {
			if (instanceMID == null) {
				instanceMID = MultiModelRegistry.getMultiModel(selectedModels.get(0));
			}
			List<Operator> executableOperators = new ArrayList<>();
			List<EList<OperatorInput>> executableOperatorsInputs = new ArrayList<>();
			for (Operator operatorType : MultiModelTypeRegistry.getOperatorTypes()) {
				try {
					EList<OperatorInput> executableOperatorInputs = operatorType.checkAllowedInputs(selectedModels);
					if (executableOperatorInputs == null) {
						continue;
					}
					executableOperators.add(operatorType);
					executableOperatorsInputs.add(executableOperatorInputs);
				}
				catch (MMINTException e) {
					continue;
				}
			}
			if (!executableOperators.isEmpty()) {
				MenuItem operatorItem = new MenuItem(mmintMenu, SWT.CASCADE);
				operatorItem.setText(MMINT_MENU_OPERATOR_LABEL);
				Menu operatorMenu = new Menu(mmintMenu);
				operatorItem.setMenu(operatorMenu);
				for (int i = 0; i < executableOperators.size(); i++) {
					Operator executableOperator = executableOperators.get(i);
					EList<Model> inputModels = new BasicEList<Model>(selectedModels);
					//TODO MMINT[OPERATOR] There should be a visual match between formal and actual parameter, with indication of coercion
					String text = executableOperator.toString();
					MenuItem operatorSubitem = new MenuItem(operatorMenu, SWT.NONE);
					operatorSubitem.setText(text);
					operatorSubitem.addSelectionListener(
						new MIDContextRunOperatorListener(
							MMINT_MENU_OPERATOR_LABEL,
							executableOperator,
							executableOperatorsInputs.get(i),
							instanceMID
						)
					);
				}
			}
		}
		// cast
		if (doCast) {
			// polymorphism
			EList<EList<Model>> runtimeModelTypes = new BasicEList<EList<Model>>();
			for (Model model : selectedModels) {
				runtimeModelTypes.add(new BasicEList<Model>(MultiModelTypeIntrospection.getRuntimeTypes(model)));
			}
			if (runtimeModelTypes.get(0).size() > 1) {
				MenuItem castItem = new MenuItem(mmintMenu, SWT.CASCADE);
				castItem.setText(MMINT_MENU_CAST_LABEL);
				Menu castMenu = new Menu(mmintMenu);
				castItem.setMenu(castMenu);
				boolean isDowncast = false;
				for (Model runtimeModelType : runtimeModelTypes.get(0)) {
					if (runtimeModelType.getUri().equals(selectedModels.get(0).getMetatypeUri())) {
						isDowncast = true;
						continue;
					}
					MenuItem castSubitem = new MenuItem(castMenu, SWT.NONE);
					String text = (isDowncast) ? runtimeModelType.getName() + DOWNCAST_LABEL : runtimeModelType.getName();
					castSubitem.setText(text);
					castSubitem.addSelectionListener(
						new MIDContextCastTypeListener(MMINT_MENU_CAST_LABEL, selectedModels.get(0), runtimeModelType, label)
					);
				}
			}
		}
		// coherence
		if (doCoherence) {
			Map<Model, Set<List<ConversionOperator>>> multiplePathConversions = MultiModelTypeHierarchy.getMultiplePathConversions(selectedModels.get(0).getMetatypeUri());
			if (!multiplePathConversions.isEmpty()) {
				MenuItem coherenceItem = new MenuItem(mmintMenu, SWT.CASCADE);
				coherenceItem.setText(MMINT_MENU_COHERENCE_LABEL);
				Menu coherenceMenu = new Menu(mmintMenu);
				coherenceItem.setMenu(coherenceMenu);
				for (Map.Entry<Model, Set<List<ConversionOperator>>> conversionPathsEntry : multiplePathConversions.entrySet()) {
					MenuItem coherenceSubitem = new MenuItem(coherenceMenu, SWT.NONE);
					coherenceSubitem.setText("To " + conversionPathsEntry.getKey().getName());
					coherenceSubitem.addSelectionListener(
						new MIDContextCheckCoherenceListener(MMINT_MENU_COHERENCE_LABEL, selectedModels.get(0), conversionPathsEntry.getValue())
					);
				}
			}
		}
		// add constraint
		if (doAddConstraint) {
			MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
			constraintItem.setText(MMINT_MENU_ADDCONSTRAINT_LABEL);
			constraintItem.addSelectionListener(
				new AddModifyConstraintListener(MMINT_MENU_ADDCONSTRAINT_LABEL, selectedModels.get(0))
			);
		}
		// check constraint
		if (doCheckConstraint) {
			MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
			constraintItem.setText(MMINT_MENU_CHECKCONSTRAINT_LABEL);
			constraintItem.addSelectionListener(
				new MIDContextCheckConstraintListener(MMINT_MENU_CHECKCONSTRAINT_LABEL, selectedModels.get(0), editParts.get(0))
			);
		}
		// refine
		if (doRefineByConstraint) {
			MenuItem refineItem = new MenuItem(mmintMenu, SWT.NONE);
			refineItem.setText(MMINT_MENU_REFINEBYCONSTRAINT_LABEL);
			refineItem.addSelectionListener(
				new MIDContextRefineByConstraintListener(MMINT_MENU_REFINEBYCONSTRAINT_LABEL, selectedModels.get(0))
			);
		}
		// copy
		if (doCopy) {
			MenuItem copyItem = new MenuItem(mmintMenu, SWT.NONE);
			copyItem.setText(MMINT_MENU_COPY_LABEL);
			copyItem.addSelectionListener(
				new MIDContextCopyModelListener(MMINT_MENU_COPY_LABEL, selectedModels.get(0))
			);
		}
		// modelepedia
		if (doModelepedia) {
			Model model = selectedModels.get(0);
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				model = model.getMetatype();
			}
			MenuItem modelepediaItem = new MenuItem(mmintMenu, SWT.CASCADE);
			modelepediaItem.setText(MMINT_MENU_MODELEPEDIA_LABEL);
			Menu modelepediaMenu = new Menu(mmintMenu);
			modelepediaItem.setMenu(modelepediaMenu);
			MenuItem openModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			openModelepediaItem.setText(MMINT_MENU_MODELEPEDIA_SUBMENU_OPEN_LABEL);
			openModelepediaItem.addSelectionListener(
				new MIDContextOpenModelepediaListener(model)
			);
			MenuItem editModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			editModelepediaItem.setText(MMINT_MENU_MODELEPEDIA_SUBMENU_EDIT_LABEL);
			editModelepediaItem.addSelectionListener(
				new MIDContextEditModelepediaListener(model)
			);
		}
	}

}
