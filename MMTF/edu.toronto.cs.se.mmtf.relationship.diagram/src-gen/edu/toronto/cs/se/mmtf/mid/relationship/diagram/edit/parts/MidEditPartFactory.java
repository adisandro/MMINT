/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (MidVisualIDRegistry.getVisualID(view)) {

			case ModelRelEditPart.VISUAL_ID:
				return new ModelRelEditPart(view);

			case ModelEndpointReferenceEditPart.VISUAL_ID:
				return new ModelEndpointReferenceEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case LinkReferenceEditPart.VISUAL_ID:
				return new LinkReferenceEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case LinkReference2EditPart.VISUAL_ID:
				return new LinkReference2EditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case ModelEndpointReference2EditPart.VISUAL_ID:
				return new ModelEndpointReference2EditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case ModelElementReferenceEditPart.VISUAL_ID:
				return new ModelElementReferenceEditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case ModelElementReference2EditPart.VISUAL_ID:
				return new ModelElementReference2EditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case ModelElementReference3EditPart.VISUAL_ID:
				return new ModelElementReference3EditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
				return new ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart(
						view);

			case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
				return new ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart(
						view);

			case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
				return new ExtendibleElementReferenceSupertypeRefEditPart(view);

			case ModelElementEndpointReferenceEditPart.VISUAL_ID:
				return new ModelElementEndpointReferenceEditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case BinaryLinkReferenceEditPart.VISUAL_ID:
				return new BinaryLinkReferenceEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			case WrappingLabel10EditPart.VISUAL_ID:
				return new WrappingLabel10EditPart(view);

			case WrappingLabel11EditPart.VISUAL_ID:
				return new WrappingLabel11EditPart(view);

			case BinaryLinkReference2EditPart.VISUAL_ID:
				return new BinaryLinkReference2EditPart(view);

			case WrappingLabel12EditPart.VISUAL_ID:
				return new WrappingLabel12EditPart(view);

			case WrappingLabel13EditPart.VISUAL_ID:
				return new WrappingLabel13EditPart(view);

			case WrappingLabel14EditPart.VISUAL_ID:
				return new WrappingLabel14EditPart(view);

			case ModelElementEndpointReference2EditPart.VISUAL_ID:
				return new ModelElementEndpointReference2EditPart(view);

			case WrappingLabel15EditPart.VISUAL_ID:
				return new WrappingLabel15EditPart(view);

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
