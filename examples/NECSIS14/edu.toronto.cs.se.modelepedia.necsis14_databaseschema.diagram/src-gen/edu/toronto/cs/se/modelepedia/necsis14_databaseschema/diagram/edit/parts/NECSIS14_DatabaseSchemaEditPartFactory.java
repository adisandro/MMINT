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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class NECSIS14_DatabaseSchemaEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.ColumnNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.TableTableColumnsCompartmentEditPart(
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
