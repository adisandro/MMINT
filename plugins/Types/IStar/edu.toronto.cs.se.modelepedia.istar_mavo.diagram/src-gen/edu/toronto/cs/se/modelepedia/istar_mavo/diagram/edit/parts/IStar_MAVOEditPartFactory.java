/*
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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class IStar_MAVOEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabelEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel3EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel4EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel5EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalName2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalName2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel6EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskName2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskName2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel7EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceName2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceName2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel8EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel8EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalName2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalName2EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel9EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel9EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel10EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel10EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel11EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel11EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel12EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel12EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel13EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel13EditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart(view);

			case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel14EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel14EditPart(view);

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
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
