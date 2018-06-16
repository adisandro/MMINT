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
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.part.RelationalDatabaseVisualIDRegistry;

/**
 * @generated
 */
public class RelationalDatabaseEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (RelationalDatabaseVisualIDRegistry.getVisualID(view)) {

			case RelationalDatabaseEditPart.VISUAL_ID:
				return new RelationalDatabaseEditPart(view);

			case TableEditPart.VISUAL_ID:
				return new TableEditPart(view);

			case TableNameEditPart.VISUAL_ID:
				return new TableNameEditPart(view);

			case ColumnEditPart.VISUAL_ID:
				return new ColumnEditPart(view);

			case ColumnNameEditPart.VISUAL_ID:
				return new ColumnNameEditPart(view);

			case ForeignKeyEditPart.VISUAL_ID:
				return new ForeignKeyEditPart(view);

			case ForeignKeyNameEditPart.VISUAL_ID:
				return new ForeignKeyNameEditPart(view);

			case TableTableColumnsCompartmentEditPart.VISUAL_ID:
				return new TableTableColumnsCompartmentEditPart(view);

			case TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
				return new TableTableForeignKeysCompartmentEditPart(view);

			case ForeignKeyTableColumnEditPart.VISUAL_ID:
				return new ForeignKeyTableColumnEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case ForeignKeyForeignColumnEditPart.VISUAL_ID:
				return new ForeignKeyForeignColumnEditPart(view);

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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE
				.getTextCellEditorLocator(source);
	}

}
