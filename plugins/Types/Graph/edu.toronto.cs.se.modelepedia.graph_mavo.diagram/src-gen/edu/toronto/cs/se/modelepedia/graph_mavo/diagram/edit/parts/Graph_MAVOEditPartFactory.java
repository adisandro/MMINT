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
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class Graph_MAVOEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabelEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeNameEditPart(view);

			case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.WrappingLabel2EditPart(view);

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
