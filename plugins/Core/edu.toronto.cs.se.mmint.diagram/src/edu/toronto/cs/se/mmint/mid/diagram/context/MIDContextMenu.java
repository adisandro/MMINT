/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.library.AddModifyConstraintListener;
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

  public static final String MMINT_MENU_LABEL = "MMINT";
  private static final String MMINT_MENU_OPERATOR_LABEL_INSTANCES = "Run Operator";
  private static final String MMINT_MENU_OPERATOR_LABEL_WORKFLOWS = "Add Operator";
  private static final String MMINT_MENU_CAST_LABEL = "Cast Type";
  private static final String MMINT_MENU_ADDCONSTRAINT_LABEL = "Add/Modify Constraint";
  private static final String MMINT_MENU_CHECKCONSTRAINT_LABEL = "Check Constraint";
  public static final String MMINT_MENU_EVALUATEQUERY_LABEL = "Evaluate Query";
  private static final String MMINT_MENU_COPY_LABEL = "Copy Model";
  private static final String MMINT_MENU_MODELEPEDIA_LABEL = "Wiki";
  private static final String MMINT_MENU_MODELEPEDIA_SUBMENU_OPEN_LABEL = "Open Wiki Page";
  private static final String MMINT_MENU_MODELEPEDIA_SUBMENU_EDIT_LABEL = "Edit Wiki Page";
  private static final String DOWNCAST_LABEL = " (downcast)";

  private class ExecutableOperator {
    public Operator operatorType;
    public EList<OperatorInput> operatorInputs;
    public ExecutableOperator(Operator operatorType, EList<OperatorInput> operatorInputs) {
      this.operatorType = operatorType;
      this.operatorInputs = operatorInputs;
    }
  }

  @Override
  public boolean isDynamic() {
    return true;
  }

  @Override
  public void fill(Menu menu, int index) {

    // check selection
    var selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getSelection();
    if (selection == null || selection.isEmpty() || !(selection instanceof StructuredSelection)) {
      return;
    }
    var objects = ((StructuredSelection) selection).toArray();
    boolean doAddConstraint = true, doCast = true, doCheckConstraint = true, doCopy = true, doModelepedia = true,
            doOperator = true, doQuery = true;
    if (objects.length > 1) { // actions that don't work on multiple objects
      doAddConstraint = false;
      doCast = false;
      doCheckConstraint = false;
      doModelepedia = false;
    }

    // get model selection
    MID mid = null;
    var selectedModels = ECollections.<Model>newBasicEList();
    ITextAwareEditPart editPartLabel = null;
    var editParts = new ArrayList<GraphicalEditPart>();
    for (var object : objects) {
      if (!(
        object instanceof MIDEditPart ||
        object instanceof ModelEditPart ||
        object instanceof Model2EditPart ||
        object instanceof ModelRelEditPart ||
        object instanceof ModelRel2EditPart ||
        object instanceof BinaryModelRelEditPart
      )) {
        continue;
      }
      var editPart = (GraphicalEditPart) object;
      var editPartElement = ((View) editPart.getModel()).getElement();
      if (editPartElement instanceof MID) {
        doAddConstraint = false;
        doCast = false;
        doCheckConstraint = false;
        doCopy = false;
        doModelepedia = false;
        if (((MID) editPartElement).isInstancesLevel() || ((MID) editPartElement).isWorkflowsLevel()) {
          mid = (MID) editPartElement;
        }
      }
      else {
        var model = (Model) editPartElement;
        // filter actions based on the MID level
        if (model.isTypesLevel() || model.isWorkflowsLevel()) {
          doCast = false;
          doCheckConstraint = false;
          doCopy = false;
        }
        if (model.isTypesLevel()) {
          doOperator = false;
        }
        if (model.isWorkflowsLevel()) {
          doAddConstraint = false;
        }
        if (model instanceof ModelRel) { // actions that don't work on model relationships
          doCopy = false;
        }
        if (doAddConstraint || doCast || doCheckConstraint || doCopy || doModelepedia || doOperator ||
            doQuery) {
          selectedModels.add(model);
        }
        if (doCast) {
          for (var child : editPart.getChildren()) {
            if (child instanceof ITextAwareEditPart) {
              editPartLabel = (ITextAwareEditPart) child;
              break;
            }
          }
        }
        if (doCheckConstraint) {
          editParts.add(editPart);
        }
      }
      if (!doOperator && !doCast && !doCheckConstraint && !doCopy && !doAddConstraint && !doModelepedia && !doQuery) {
        // no action available
        return;
      }
    }
    if (mid == null && selectedModels.isEmpty()) { // no relevant edit parts selected
      return;
    }

    // create dynamic menus
    var mmintItem = new MenuItem(menu, SWT.CASCADE, index);
    mmintItem.setText(MIDContextMenu.MMINT_MENU_LABEL);
    var mmintMenu = new Menu(menu);
    mmintItem.setMenu(mmintMenu);
    MMINT.stashActiveInstanceMIDFile();
    // operator
    if (doOperator) {
      if (mid == null) {
        mid = selectedModels.get(0).getMIDContainer();
      }
      MIDTypeHierarchy.clearCachedRuntimeTypes();
      String prevPreference = null;
      if (mid.isWorkflowsLevel()) { // disable runtime typing at the workflow level, since there is no runtime
        prevPreference = MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED, "false");
      }
      List<ExecutableOperator> executableOperators = new ArrayList<>();
      for (Operator operatorType : MIDTypeRegistry.getOperatorTypes()) {
        try {
          if (operatorType.isAbstract()) {
            continue;
          }
          var operatorInputs = operatorType.checkAllowedInputs(selectedModels);
          if (operatorInputs == null) {
            continue;
          }
          executableOperators.add(new ExecutableOperator(operatorType, operatorInputs));
        }
        catch (MMINTException e) {
          continue;
        }
      }
      if (prevPreference != null) { // restore runtime typing preference
        MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED, prevPreference);
      }
      if (!doCast) { // reuse for casting
        MIDTypeHierarchy.clearCachedRuntimeTypes();
      }
      if (!executableOperators.isEmpty()) {
        Collections.sort(executableOperators, new Comparator<ExecutableOperator>() { // alphabetical order
          @Override
          public int compare(ExecutableOperator o1, ExecutableOperator o2) {
            return o1.operatorType.getName().compareTo(o2.operatorType.getName());
          }
        });
        MenuItem operatorItem = new MenuItem(mmintMenu, SWT.CASCADE);
        var menuLabel = (mid.isInstancesLevel()) ?
          MIDContextMenu.MMINT_MENU_OPERATOR_LABEL_INSTANCES :
          MIDContextMenu.MMINT_MENU_OPERATOR_LABEL_WORKFLOWS;
        operatorItem.setText(menuLabel);
        Menu operatorMenu = new Menu(mmintMenu);
        operatorItem.setMenu(operatorMenu);
        for (ExecutableOperator executableOperator : executableOperators) {
          String text;
          try {
            text = executableOperator.operatorType.getTypeSignature(executableOperator.operatorInputs);
          }
          catch (MMINTException e) {
            text = executableOperator.toString();
          }
          MenuItem operatorSubitem = new MenuItem(operatorMenu, SWT.NONE);
          operatorSubitem.setText(text);
          operatorSubitem.addSelectionListener(
            new MIDContextRunOperatorListener(
              menuLabel,
              executableOperator.operatorType,
              executableOperator.operatorInputs,
              mid
            )
          );
        }
      }
    }
    // cast
    if (doCast) {
      // polymorphism
      if (!doOperator) { // reuse from operators
        MIDTypeHierarchy.clearCachedRuntimeTypes();
      }
      EList<Model> runtimeModelTypes = new BasicEList<>();
      try {
        runtimeModelTypes.addAll(selectedModels.get(0).getRuntimeTypes());
      }
      catch (MMINTException e) {
        // do nothing
      }
      MIDTypeHierarchy.clearCachedRuntimeTypes();
      if (runtimeModelTypes.size() > 1) {
        MenuItem castItem = new MenuItem(mmintMenu, SWT.CASCADE);
        castItem.setText(MIDContextMenu.MMINT_MENU_CAST_LABEL);
        Menu castMenu = new Menu(mmintMenu);
        castItem.setMenu(castMenu);
        var isDowncast = false;
        for (Model runtimeModelType : runtimeModelTypes) {
          if (runtimeModelType.getUri().equals(selectedModels.get(0).getMetatypeUri())) {
            isDowncast = true;
            continue;
          }
          MenuItem castSubitem = new MenuItem(castMenu, SWT.NONE);
          var text = (isDowncast) ? runtimeModelType.getName() + MIDContextMenu.DOWNCAST_LABEL : runtimeModelType.getName();
          castSubitem.setText(text);
          castSubitem.addSelectionListener(
            new MIDContextCastTypeListener(MIDContextMenu.MMINT_MENU_CAST_LABEL, selectedModels.get(0), runtimeModelType, editPartLabel)
          );
        }
      }
    }
    // add constraint
    if (doAddConstraint) {
      MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
      constraintItem.setText(MIDContextMenu.MMINT_MENU_ADDCONSTRAINT_LABEL);
      constraintItem.addSelectionListener(
        new AddModifyConstraintListener(MIDContextMenu.MMINT_MENU_ADDCONSTRAINT_LABEL, selectedModels.get(0))
      );
    }
    // check constraint
    if (doCheckConstraint) {
      MenuItem constraintItem = new MenuItem(mmintMenu, SWT.NONE);
      constraintItem.setText(MIDContextMenu.MMINT_MENU_CHECKCONSTRAINT_LABEL);
      constraintItem.addSelectionListener(
        new MIDContextCheckConstraintListener(MIDContextMenu.MMINT_MENU_CHECKCONSTRAINT_LABEL, selectedModels.get(0), editParts.get(0))
      );
    }
    // evaluate query
    if (doQuery) {
      var queryItem = new MenuItem(mmintMenu, SWT.NONE);
      queryItem.setText(MIDContextMenu.MMINT_MENU_EVALUATEQUERY_LABEL);
      if (mid == null) {
        mid = selectedModels.get(0).getMIDContainer();
      }
      queryItem.addSelectionListener(
        new MIDContextEvaluateQueryListener(MIDContextMenu.MMINT_MENU_EVALUATEQUERY_LABEL, mid, selectedModels)
      );
    }
    // copy
    if (doCopy) {
      MenuItem copyItem = new MenuItem(mmintMenu, SWT.NONE);
      var label = MIDContextMenu.MMINT_MENU_COPY_LABEL;
      if (selectedModels.size() > 1) {
        label += "s";
      }
      copyItem.setText(label);
      copyItem.addSelectionListener(
        new MIDContextCopyModelListener(MIDContextMenu.MMINT_MENU_COPY_LABEL, selectedModels)
      );
    }
    // modelepedia
    if (doModelepedia) {
      var model = selectedModels.get(0);
      if (model.isInstancesLevel()) {
        model = model.getMetatype();
      }
      MenuItem modelepediaItem = new MenuItem(mmintMenu, SWT.CASCADE);
      modelepediaItem.setText(MIDContextMenu.MMINT_MENU_MODELEPEDIA_LABEL);
      Menu modelepediaMenu = new Menu(mmintMenu);
      modelepediaItem.setMenu(modelepediaMenu);
      MenuItem openModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
      openModelepediaItem.setText(MIDContextMenu.MMINT_MENU_MODELEPEDIA_SUBMENU_OPEN_LABEL);
      openModelepediaItem.addSelectionListener(
        new MIDContextOpenModelepediaListener(model)
      );
      MenuItem editModelepediaItem = new MenuItem(modelepediaMenu, SWT.NONE);
      editModelepediaItem.setText(MIDContextMenu.MMINT_MENU_MODELEPEDIA_SUBMENU_EDIT_LABEL);
      editModelepediaItem.addSelectionListener(
        new MIDContextEditModelepediaListener(model)
      );
    }
  }

}
