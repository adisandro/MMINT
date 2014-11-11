/*
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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class StateMachine_MAVOEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateMachineEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateMachineEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabelEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel3EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel4EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalState2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalState2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel5EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.State2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.State2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateName2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateName2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel6EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateStateNestedStatesCompartmentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateStateNestedStatesCompartmentEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateStateNestedStatesCompartment2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateStateNestedStatesCompartment2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.WrappingLabel7EditPart(
						view);

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
