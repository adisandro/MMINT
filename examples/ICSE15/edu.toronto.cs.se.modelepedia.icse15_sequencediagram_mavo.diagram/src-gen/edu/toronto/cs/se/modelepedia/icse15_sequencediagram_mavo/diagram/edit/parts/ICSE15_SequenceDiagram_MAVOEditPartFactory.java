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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.directedit.locator.CellEditorLocatorAccess;

/**
 * @generated
 */
public class ICSE15_SequenceDiagram_MAVOEditPartFactory implements EditPartFactory {

	/**
	* @generated
	*/
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getVisualID(view)) {

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabelEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel2EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel3EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationNameEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationNameEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel4EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassClassOperationsCompartmentEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassClassOperationsCompartmentEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel5EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel6EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel7EditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart(
						view);

			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel8EditPart.VISUAL_ID:
				return new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.WrappingLabel8EditPart(
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
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}

}
