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
package edu.toronto.cs.se.mmint.mid.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (MIDVisualIDRegistry.getVisualID(view)) {

				case MIDEditPart.VISUAL_ID:
					return new MIDEditPart(view);

				case ModelEditPart.VISUAL_ID:
					return new ModelEditPart(view);

				case WrappingLabelEditPart.VISUAL_ID:
					return new WrappingLabelEditPart(view);

				case WrappingLabel2EditPart.VISUAL_ID:
					return new WrappingLabel2EditPart(view);

				case Model2EditPart.VISUAL_ID:
					return new Model2EditPart(view);

				case WrappingLabel3EditPart.VISUAL_ID:
					return new WrappingLabel3EditPart(view);

				case WrappingLabel4EditPart.VISUAL_ID:
					return new WrappingLabel4EditPart(view);

				case ModelRelEditPart.VISUAL_ID:
					return new ModelRelEditPart(view);

				case WrappingLabel5EditPart.VISUAL_ID:
					return new WrappingLabel5EditPart(view);

				case WrappingLabel6EditPart.VISUAL_ID:
					return new WrappingLabel6EditPart(view);

				case ModelRel2EditPart.VISUAL_ID:
					return new ModelRel2EditPart(view);

				case WrappingLabel7EditPart.VISUAL_ID:
					return new WrappingLabel7EditPart(view);

				case WrappingLabel8EditPart.VISUAL_ID:
					return new WrappingLabel8EditPart(view);

				case OperatorEditPart.VISUAL_ID:
					return new OperatorEditPart(view);

				case WrappingLabel9EditPart.VISUAL_ID:
					return new WrappingLabel9EditPart(view);

				case ExtendibleElementSupertypeEditPart.VISUAL_ID:
					return new ExtendibleElementSupertypeEditPart(view);

				case ModelEndpointEditPart.VISUAL_ID:
					return new ModelEndpointEditPart(view);

				case WrappingLabel10EditPart.VISUAL_ID:
					return new WrappingLabel10EditPart(view);

				case WrappingLabel11EditPart.VISUAL_ID:
					return new WrappingLabel11EditPart(view);

				case BinaryModelRelEditPart.VISUAL_ID:
					return new BinaryModelRelEditPart(view);

				case WrappingLabel12EditPart.VISUAL_ID:
					return new WrappingLabel12EditPart(view);

				case WrappingLabel13EditPart.VISUAL_ID:
					return new WrappingLabel13EditPart(view);

				case WrappingLabel14EditPart.VISUAL_ID:
					return new WrappingLabel14EditPart(view);

				case WrappingLabel15EditPart.VISUAL_ID:
					return new WrappingLabel15EditPart(view);

				case ModelEndpoint2EditPart.VISUAL_ID:
					return new ModelEndpoint2EditPart(view);

				case ModelEndpointNameEditPart.VISUAL_ID:
					return new ModelEndpointNameEditPart(view);

				case ModelEndpoint3EditPart.VISUAL_ID:
					return new ModelEndpoint3EditPart(view);

				case ModelEndpointName2EditPart.VISUAL_ID:
					return new ModelEndpointName2EditPart(view);

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
