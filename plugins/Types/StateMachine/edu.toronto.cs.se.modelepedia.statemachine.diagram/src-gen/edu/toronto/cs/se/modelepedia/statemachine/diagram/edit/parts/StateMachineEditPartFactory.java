/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry;

/**
 * @generated
 */
public class StateMachineEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (StateMachineVisualIDRegistry.getVisualID(view)) {

			case StateMachineEditPart.VISUAL_ID:
				return new StateMachineEditPart(view);

			case StateEditPart.VISUAL_ID:
				return new StateEditPart(view);

			case StateNameEditPart.VISUAL_ID:
				return new StateNameEditPart(view);

			case InitialStateEditPart.VISUAL_ID:
				return new InitialStateEditPart(view);

			case FinalStateEditPart.VISUAL_ID:
				return new FinalStateEditPart(view);

			case StateActionEditPart.VISUAL_ID:
				return new StateActionEditPart(view);

			case StateActionTriggerActionEditPart.VISUAL_ID:
				return new StateActionTriggerActionEditPart(view);

			case StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
				return new StateStateInternalActionsCompartmentEditPart(view);

			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);

			case TransitionTriggerActionEditPart.VISUAL_ID:
				return new TransitionTriggerActionEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
