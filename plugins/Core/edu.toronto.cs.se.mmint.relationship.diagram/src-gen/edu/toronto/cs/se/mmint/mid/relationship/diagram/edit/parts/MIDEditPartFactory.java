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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;

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

			case ModelRelEditPart.VISUAL_ID:
				return new ModelRelEditPart(view);

			case ModelEndpointReferenceEditPart.VISUAL_ID:
				return new ModelEndpointReferenceEditPart(view);

			case WrappingLabelEditPart.VISUAL_ID:
				return new WrappingLabelEditPart(view);

			case WrappingLabel2EditPart.VISUAL_ID:
				return new WrappingLabel2EditPart(view);

			case MappingReferenceEditPart.VISUAL_ID:
				return new MappingReferenceEditPart(view);

			case WrappingLabel3EditPart.VISUAL_ID:
				return new WrappingLabel3EditPart(view);

			case WrappingLabel4EditPart.VISUAL_ID:
				return new WrappingLabel4EditPart(view);

			case MappingReference2EditPart.VISUAL_ID:
				return new MappingReference2EditPart(view);

			case WrappingLabel5EditPart.VISUAL_ID:
				return new WrappingLabel5EditPart(view);

			case WrappingLabel6EditPart.VISUAL_ID:
				return new WrappingLabel6EditPart(view);

			case ModelEndpointReference2EditPart.VISUAL_ID:
				return new ModelEndpointReference2EditPart(view);

			case WrappingLabel7EditPart.VISUAL_ID:
				return new WrappingLabel7EditPart(view);

			case WrappingLabel8EditPart.VISUAL_ID:
				return new WrappingLabel8EditPart(view);

			case ModelElementReferenceEditPart.VISUAL_ID:
				return new ModelElementReferenceEditPart(view);

			case WrappingLabel9EditPart.VISUAL_ID:
				return new WrappingLabel9EditPart(view);

			case WrappingLabel10EditPart.VISUAL_ID:
				return new WrappingLabel10EditPart(view);

			case ModelElementReference2EditPart.VISUAL_ID:
				return new ModelElementReference2EditPart(view);

			case WrappingLabel11EditPart.VISUAL_ID:
				return new WrappingLabel11EditPart(view);

			case WrappingLabel12EditPart.VISUAL_ID:
				return new WrappingLabel12EditPart(view);

			case ModelElementReference3EditPart.VISUAL_ID:
				return new ModelElementReference3EditPart(view);

			case WrappingLabel13EditPart.VISUAL_ID:
				return new WrappingLabel13EditPart(view);

			case WrappingLabel14EditPart.VISUAL_ID:
				return new WrappingLabel14EditPart(view);

			case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
				return new ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart(view);

			case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
				return new ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart(view);

			case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
				return new ExtendibleElementReferenceSupertypeRefEditPart(view);

			case ModelElementEndpointReferenceEditPart.VISUAL_ID:
				return new ModelElementEndpointReferenceEditPart(view);

			case WrappingLabel15EditPart.VISUAL_ID:
				return new WrappingLabel15EditPart(view);

			case WrappingLabel16EditPart.VISUAL_ID:
				return new WrappingLabel16EditPart(view);

			case BinaryMappingReferenceEditPart.VISUAL_ID:
				return new BinaryMappingReferenceEditPart(view);

			case WrappingLabel17EditPart.VISUAL_ID:
				return new WrappingLabel17EditPart(view);

			case WrappingLabel18EditPart.VISUAL_ID:
				return new WrappingLabel18EditPart(view);

			case WrappingLabel19EditPart.VISUAL_ID:
				return new WrappingLabel19EditPart(view);

			case WrappingLabel20EditPart.VISUAL_ID:
				return new WrappingLabel20EditPart(view);

			case BinaryMappingReference2EditPart.VISUAL_ID:
				return new BinaryMappingReference2EditPart(view);

			case WrappingLabel21EditPart.VISUAL_ID:
				return new WrappingLabel21EditPart(view);

			case WrappingLabel22EditPart.VISUAL_ID:
				return new WrappingLabel22EditPart(view);

			case WrappingLabel23EditPart.VISUAL_ID:
				return new WrappingLabel23EditPart(view);

			case WrappingLabel24EditPart.VISUAL_ID:
				return new WrappingLabel24EditPart(view);

			case ModelElementEndpointReference2EditPart.VISUAL_ID:
				return new ModelElementEndpointReference2EditPart(view);

			case WrappingLabel25EditPart.VISUAL_ID:
				return new WrappingLabel25EditPart(view);

			case WrappingLabel26EditPart.VISUAL_ID:
				return new WrappingLabel26EditPart(view);

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
