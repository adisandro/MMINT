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
package edu.toronto.cs.se.mmint.mid.diagram.library;

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
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.CastTypeListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.CheckCoherenceListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.CheckConstraintListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.CopyModelListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.EditModelepediaListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.OpenModelepediaListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.RefineByConstraintListener;
import edu.toronto.cs.se.mmint.mid.diagram.contextmenu.RunOperatorListener;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
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
	private static final String MMINT_MENU_MODELEPEDIA_SUBMENU_LABEL = "Wiki";
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
		EList<Model> models = new BasicEList<Model>();
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
				if (doCheckConstraint) {
					editParts.add(editPart);
				}
			}
			if (!doOperator && !doCast && !doCheckConstraint && !doCopy && !doAddConstraint && !doModelepedia && !doCoherence && !doRefineByConstraint) { // no action available
				return;
			}
		}
		if (instanceMID == null && models.isEmpty()) { // no relevant edit parts selected
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
		MenuItem mmintItem = new MenuItem(menu, SWT.CASCADE, index);
		mmintItem.setText(MMINT_MENU_LABEL);
		Menu mmintMenu = new Menu(menu);
		mmintItem.setMenu(mmintMenu);
		// operator
		if (doOperator) {
			if (instanceMID == null) {
				instanceMID = MultiModelRegistry.getMultiModel(models.get(0));
			}
			EList<Operator> operatorTypes = new BasicEList<Operator>();
			EList<Map<Integer, EList<ConversionOperator>>> conversions = new BasicEList<Map<Integer, EList<ConversionOperator>>>();
			EList<EList<Model>> generics = new BasicEList<EList<Model>>();
			for (Operator operatorType : MultiModelTypeRegistry.getOperatorTypes()) {
				try {
					operatorTypes.addAll(operatorType.getExecutables(models, runtimeModelTypes, conversions, generics));
				}
				catch (MMINTException e) {
					continue;
				}
			}
			if (!operatorTypes.isEmpty()) {
				MenuItem operatorItem = new MenuItem(mmintMenu, SWT.CASCADE);
				operatorItem.setText(MMINT_MENU_OPERATOR_LABEL);
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
					if (!conversion.isEmpty()) {
						text += " [coercion]";
					}
					MenuItem operatorSubitem = new MenuItem(operatorMenu, SWT.NONE);
					operatorSubitem.setText(text);
					operatorSubitem.addSelectionListener(
						new RunOperatorListener(MMINT_MENU_OPERATOR_LABEL, instanceMID, operatorType, actualParameters, conversion)
					);
					//TODO MMINT[OPERATOR] nice to show label of operator invocation with actual parameters
					//TODO MMINT[OPERATOR] traceability, could be nice to create an instance of operator, with name = actual parameters
				}
			}
		}
		// cast
		if (doCast) {
			if (runtimeModelTypes.get(0).size() > 1) {
				MenuItem castItem = new MenuItem(mmintMenu, SWT.CASCADE);
				castItem.setText(MMINT_MENU_CAST_LABEL);
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
						new CastTypeListener(MMINT_MENU_CAST_LABEL, models.get(0), runtimeModelType, label)
					);
				}
			}
		}
		// coherence
		if (doCoherence) {
			Map<Model, Set<List<ConversionOperator>>> multiplePathConversions = MultiModelTypeHierarchy.getMultiplePathConversions(models.get(0).getMetatypeUri());
			if (!multiplePathConversions.isEmpty()) {
				MenuItem coherenceItem = new MenuItem(mmintMenu, SWT.CASCADE);
				coherenceItem.setText(MMINT_MENU_COHERENCE_LABEL);
				Menu coherenceMenu = new Menu(menu);
				coherenceItem.setMenu(coherenceMenu);
				for (Map.Entry<Model, Set<List<ConversionOperator>>> conversionPathsEntry : multiplePathConversions.entrySet()) {
					MenuItem coherenceSubitem = new MenuItem(coherenceMenu, SWT.NONE);
					coherenceSubitem.setText("To " + conversionPathsEntry.getKey().getName());
					coherenceSubitem.addSelectionListener(
						new CheckCoherenceListener(MMINT_MENU_COHERENCE_LABEL, models.get(0), conversionPathsEntry.getValue())
					);
				}
			}
		}
		// add constraint
		if (doAddConstraint) {
			MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
			constraintItem.setText(MMINT_MENU_ADDCONSTRAINT_LABEL);
			constraintItem.addSelectionListener(
				new AddModifyConstraintListener(MMINT_MENU_ADDCONSTRAINT_LABEL, models.get(0))
			);
		}
		// check constraint
		if (doCheckConstraint) {
			MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
			constraintItem.setText(MMINT_MENU_CHECKCONSTRAINT_LABEL);
			constraintItem.addSelectionListener(
				new CheckConstraintListener(MMINT_MENU_CHECKCONSTRAINT_LABEL, models.get(0), editParts.get(0))
			);
		}
		// refine
		if (doRefineByConstraint) {
			MenuItem refineItem = new MenuItem(mmintMenu, SWT.NONE);
			refineItem.setText(MMINT_MENU_REFINEBYCONSTRAINT_LABEL);
			refineItem.addSelectionListener(
				new RefineByConstraintListener(MMINT_MENU_REFINEBYCONSTRAINT_LABEL, models.get(0))
			);
//			MenuItem mayItem = new MenuItem(mmintMenu, SWT.CASCADE);
//			mayItem.setText("May Models");
//			Menu mayMenu = new Menu(menu);
//			mayItem.setMenu(mayMenu);
//
//			MenuItem refinementItem = new MenuItem(mayMenu, SWT.CASCADE);
//			refinementItem.setText("Refinement");
//			Menu refinementMenu = new Menu(mayMenu);
//			refinementItem.setMenu(refinementMenu);
//
//			MenuItem previewItem = new MenuItem(refinementMenu, SWT.NONE);
//			previewItem.setText("Preview");
//			/*TODO MMINT[MU-MMINT] create a listener for preview that greys out elements that will be removed. 
//			 * Possibly have it similar/related to RefinementListener, since functionality for finding elements 
//			 * to grey out should be the same, and the calculation should only have to be made once if preview is 
//			 * called, and then make refinement follows.
//			 */
//			//previewItem.addSelectionListener(new RefinementListener(models.get(0), editParts.get(0), false));
//			MenuItem refineItem = new MenuItem(refinementMenu, SWT.NONE);
//			refineItem.setText(MMINT_MENU_REFINE_LABEL);
//			refineItem.addSelectionListener(
//				new RefinementListener(MMINT_MENU_REFINE_LABEL, models.get(0))
//			);
		}
		// copy
		if (doCopy) {
			MenuItem copyItem = new MenuItem(mmintMenu, SWT.NONE);
			copyItem.setText(MMINT_MENU_COPY_LABEL);
			copyItem.addSelectionListener(
				new CopyModelListener(MMINT_MENU_COPY_LABEL, models.get(0))
			);
		}
		// modelepedia
		if (doModelepedia) {
			Model model = models.get(0);
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				model = model.getMetatype();
			}
			MenuItem modelepediaItem = new MenuItem(mmintMenu, SWT.CASCADE);
			modelepediaItem.setText(MMINT_MENU_MODELEPEDIA_SUBMENU_LABEL);
			Menu modelepediaMenu = new Menu(menu);
			modelepediaItem.setMenu(modelepediaMenu);
			MenuItem openModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			openModelepediaItem.setText(MMINT_MENU_MODELEPEDIA_SUBMENU_OPEN_LABEL);
			openModelepediaItem.addSelectionListener(
				new OpenModelepediaListener(model)
			);
			MenuItem editModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
			editModelepediaItem.setText(MMINT_MENU_MODELEPEDIA_SUBMENU_EDIT_LABEL);
			editModelepediaItem.addSelectionListener(
				new EditModelepediaListener(model)
			);
		}
	}

}
