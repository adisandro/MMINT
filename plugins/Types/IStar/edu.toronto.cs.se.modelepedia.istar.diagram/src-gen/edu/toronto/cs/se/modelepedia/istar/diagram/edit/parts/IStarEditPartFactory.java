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
package edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry;

/**
 * @generated
 */
public class IStarEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (IStarVisualIDRegistry.getVisualID(view)) {

			case IStarEditPart.VISUAL_ID:
				return new IStarEditPart(view);

			case SoftGoalEditPart.VISUAL_ID:
				return new SoftGoalEditPart(view);

			case SoftGoalNameEditPart.VISUAL_ID:
				return new SoftGoalNameEditPart(view);

			case TaskEditPart.VISUAL_ID:
				return new TaskEditPart(view);

			case TaskNameEditPart.VISUAL_ID:
				return new TaskNameEditPart(view);

			case ResourceEditPart.VISUAL_ID:
				return new ResourceEditPart(view);

			case ResourceNameEditPart.VISUAL_ID:
				return new ResourceNameEditPart(view);

			case GoalEditPart.VISUAL_ID:
				return new GoalEditPart(view);

			case GoalNameEditPart.VISUAL_ID:
				return new GoalNameEditPart(view);

			case ActorEditPart.VISUAL_ID:
				return new ActorEditPart(view);

			case ActorNameEditPart.VISUAL_ID:
				return new ActorNameEditPart(view);

			case SoftGoal2EditPart.VISUAL_ID:
				return new SoftGoal2EditPart(view);

			case SoftGoalName2EditPart.VISUAL_ID:
				return new SoftGoalName2EditPart(view);

			case Task2EditPart.VISUAL_ID:
				return new Task2EditPart(view);

			case TaskName2EditPart.VISUAL_ID:
				return new TaskName2EditPart(view);

			case Resource2EditPart.VISUAL_ID:
				return new Resource2EditPart(view);

			case ResourceName2EditPart.VISUAL_ID:
				return new ResourceName2EditPart(view);

			case Goal2EditPart.VISUAL_ID:
				return new Goal2EditPart(view);

			case GoalName2EditPart.VISUAL_ID:
				return new GoalName2EditPart(view);

			case ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
				return new ActorActorIntentionsCompartmentEditPart(view);

			case MeansEndEditPart.VISUAL_ID:
				return new MeansEndEditPart(view);

			case DecompositionEditPart.VISUAL_ID:
				return new DecompositionEditPart(view);

			case ContributionEditPart.VISUAL_ID:
				return new ContributionEditPart(view);

			case DependerLinkEditPart.VISUAL_ID:
				return new DependerLinkEditPart(view);

			case DependeeLinkEditPart.VISUAL_ID:
				return new DependeeLinkEditPart(view);

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
