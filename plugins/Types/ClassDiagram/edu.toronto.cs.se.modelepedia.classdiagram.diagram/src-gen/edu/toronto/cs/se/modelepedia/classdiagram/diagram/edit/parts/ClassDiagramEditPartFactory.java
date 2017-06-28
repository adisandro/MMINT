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
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry;

/**
 * @generated
 */
public class ClassDiagramEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ClassDiagramVisualIDRegistry.getVisualID(view)) {

				case ClassDiagramEditPart.VISUAL_ID:
					return new ClassDiagramEditPart(view);

				case ClassEditPart.VISUAL_ID:
					return new ClassEditPart(view);

				case ClassNameEditPart.VISUAL_ID:
					return new ClassNameEditPart(view);

				case AttributeEditPart.VISUAL_ID:
					return new AttributeEditPart(view);

				case AttributeNameEditPart.VISUAL_ID:
					return new AttributeNameEditPart(view);

				case OperationEditPart.VISUAL_ID:
					return new OperationEditPart(view);

				case OperationNameEditPart.VISUAL_ID:
					return new OperationNameEditPart(view);

				case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
					return new ClassClassOwnedAttributesCompartmentEditPart(view);

				case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
					return new ClassClassOwnedOperationsCompartmentEditPart(view);

				case AssociationEditPart.VISUAL_ID:
					return new AssociationEditPart(view);

				case AssociationNameEditPart.VISUAL_ID:
					return new AssociationNameEditPart(view);

				case DependencyEditPart.VISUAL_ID:
					return new DependencyEditPart(view);

				case ClassNestedInEditPart.VISUAL_ID:
					return new ClassNestedInEditPart(view);

				case WrappingLabelEditPart.VISUAL_ID:
					return new WrappingLabelEditPart(view);

				case ClassSuperclassEditPart.VISUAL_ID:
					return new ClassSuperclassEditPart(view);

				case WrappingLabel2EditPart.VISUAL_ID:
					return new WrappingLabel2EditPart(view);

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
