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
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class NECSIS14_ClassDiagramEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassParentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassParentEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.WrappingLabelEditPart(
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
