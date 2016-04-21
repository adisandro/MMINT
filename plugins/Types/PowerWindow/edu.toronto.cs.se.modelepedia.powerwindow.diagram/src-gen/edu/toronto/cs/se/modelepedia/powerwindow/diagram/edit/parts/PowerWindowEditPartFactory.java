/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry;

/**
 * @generated
 */
public class PowerWindowEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (PowerWindowVisualIDRegistry.getVisualID(view)) {

			case WindowEditPart.VISUAL_ID:
				return new WindowEditPart(view);

			case PushPullEditPart.VISUAL_ID:
				return new PushPullEditPart(view);

			case PushPullNameEditPart.VISUAL_ID:
				return new PushPullNameEditPart(view);

			case RockerEditPart.VISUAL_ID:
				return new RockerEditPart(view);

			case RockerNameEditPart.VISUAL_ID:
				return new RockerNameEditPart(view);

			case InfraredEditPart.VISUAL_ID:
				return new InfraredEditPart(view);

			case InfraredDelayEditPart.VISUAL_ID:
				return new InfraredDelayEditPart(view);

			case LockOutEditPart.VISUAL_ID:
				return new LockOutEditPart(view);

			case LockOutNameEditPart.VISUAL_ID:
				return new LockOutNameEditPart(view);

			case ForceDetectingEditPart.VISUAL_ID:
				return new ForceDetectingEditPart(view);

			case ForceDetectingDelayEditPart.VISUAL_ID:
				return new ForceDetectingDelayEditPart(view);
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
