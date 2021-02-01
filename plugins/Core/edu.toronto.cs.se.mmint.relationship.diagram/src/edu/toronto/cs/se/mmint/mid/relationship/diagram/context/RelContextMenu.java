/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.context;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.diagram.context.MIDContextEvaluateQueryListener;
import edu.toronto.cs.se.mmint.mid.diagram.context.MIDContextMenu;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;

/**
 * The handler for the dynamic construction of a context menu within a relationship diagram.
 *
 * @author Alessio Di Sandro
 *
 */
public class RelContextMenu extends ContributionItem {

  private static final String HIGHLIGHTENDPOINT_LABEL = "Highlight Model Elements";
  private static final String HIGHLIGHTENDPOINT_RED_LABEL = "Red";
  private static final String HIGHLIGHTENDPOINT_GREEN_LABEL = "Green";
  private static final String HIGHLIGHTENDPOINT_BLUE_LABEL = "Blue";

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
    boolean doQuery = true, doHighlight = true;

    // get model selection
    ModelRel rel = null;
    ModelEndpointReference modelEndpointRef = null;
    var modelElemRefs = new ArrayList<ExtendibleElementReference>();
    for (var object : objects) {
      if (!(
        object instanceof ModelRelEditPart ||
        object instanceof ModelElementReferenceEditPart ||
        object instanceof ModelEndpointReferenceEditPart
      )) {
        continue;
      }
      var editPart = (GraphicalEditPart) object;
      var editPartElement = ((View) editPart.getModel()).getElement();
      if (editPartElement instanceof ModelRel) {
        rel = (ModelRel) editPartElement;
        doHighlight = false;
      }
      else if (editPartElement instanceof ModelEndpointReference) {
        modelEndpointRef = (ModelEndpointReference) editPartElement;
        doQuery = false;
      }
      else {
        modelElemRefs.add((ExtendibleElementReference) editPartElement);
        doHighlight = false;
      }
      if (!doQuery && !doHighlight) { // no action available
        return;
      }
    }
    if (rel == null && modelEndpointRef == null && modelElemRefs.isEmpty()) { // no relevant edit parts selected
      return;
    }

    // create dynamic menus
    var mmintItem = new MenuItem(menu, SWT.CASCADE, index);
    mmintItem.setText(MIDContextMenu.MMINT_MENU_LABEL);
    var mmintMenu = new Menu(menu);
    mmintItem.setMenu(mmintMenu);
    MMINT.stashActiveInstanceMIDFile();
    // evaluate query
    if (doQuery) {
      var mid = (rel == null) ? modelElemRefs.get(0).getMIDContainer() : rel.getMIDContainer();
      var selectedElems = modelElemRefs.stream()
        .map(ExtendibleElementReference::getObject)
        .collect(Collectors.toList());
      var queryItem = new MenuItem(mmintMenu, SWT.NONE);
      queryItem.setText(MIDContextMenu.MMINT_MENU_EVALUATEQUERY_LABEL);
      queryItem.addSelectionListener(
        new MIDContextEvaluateQueryListener(MIDContextMenu.MMINT_MENU_EVALUATEQUERY_LABEL, mid, selectedElems)
      );
    }
    // highlight model elements
    if (doHighlight) {
      var highlightItem = new MenuItem(mmintMenu, SWT.CASCADE);
      highlightItem.setText(RelContextMenu.HIGHLIGHTENDPOINT_LABEL);
      var colorMenu = new Menu(mmintMenu);
      highlightItem.setMenu(colorMenu);
      var redItem = new MenuItem(colorMenu, SWT.NONE);
      redItem.setText(RelContextMenu.HIGHLIGHTENDPOINT_RED_LABEL);
      redItem.addSelectionListener(new RelContextHighlightModelEndpointListener(
        RelContextMenu.HIGHLIGHTENDPOINT_LABEL, modelEndpointRef, RGBValues.create(255, 0, 0))
      );
      var greenItem = new MenuItem(colorMenu, SWT.NONE);
      greenItem.setText(RelContextMenu.HIGHLIGHTENDPOINT_GREEN_LABEL);
      greenItem.addSelectionListener(new RelContextHighlightModelEndpointListener(
        RelContextMenu.HIGHLIGHTENDPOINT_LABEL, modelEndpointRef, RGBValues.create(0, 255, 0))
      );
      var blueItem = new MenuItem(colorMenu, SWT.NONE);
      blueItem.setText(RelContextMenu.HIGHLIGHTENDPOINT_BLUE_LABEL);
      blueItem.addSelectionListener(new RelContextHighlightModelEndpointListener(
        RelContextMenu.HIGHLIGHTENDPOINT_LABEL, modelEndpointRef, RGBValues.create(0, 0, 255))
      );
    }
  }

}