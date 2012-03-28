/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.expressions.MIDOCLFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class MIDVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.mmtf.mid.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (MultiModelEditPart.MODEL_ID.equals(view.getType())) {
				return MultiModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				MIDDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (MidPackage.eINSTANCE.getMultiModel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((MultiModel) domainElement)) {
			return MultiModelEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry
				.getModelID(containerView);
		if (!MultiModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"mid".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (MultiModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = MultiModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case MultiModelEditPart.VISUAL_ID:
			if (MappingPackage.eINSTANCE.getMappingReference().isSuperTypeOf(
					domainElement.eClass())) {
				return MappingReferenceEditPart.VISUAL_ID;
			}
			if (MidPackage.eINSTANCE.getModelReference().isSuperTypeOf(
					domainElement.eClass())
					&& isModelReference_2002((ModelReference) domainElement)) {
				return ModelReferenceEditPart.VISUAL_ID;
			}
			if (MidPackage.eINSTANCE.getModelReference().isSuperTypeOf(
					domainElement.eClass())
					&& isModelReference_2003((ModelReference) domainElement)) {
				return ModelReference2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry
				.getModelID(containerView);
		if (!MultiModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"mid".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (MultiModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = MultiModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case MultiModelEditPart.VISUAL_ID:
			if (MappingReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MappingReferenceEditPart.VISUAL_ID:
			if (MappingReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelReferenceEditPart.VISUAL_ID:
			if (ModelReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelReference2EditPart.VISUAL_ID:
			if (ModelReferenceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (MappingPackage.eINSTANCE.getBinaryMappingReference().isSuperTypeOf(
				domainElement.eClass())) {
			return BinaryMappingReferenceEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(MultiModel element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isModelReference_2002(ModelReference domainElement) {
		Object result = MIDOCLFactory.getExpression(0,
				MidPackage.eINSTANCE.getModelReference(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelReference_2003(ModelReference domainElement) {
		Object result = MIDOCLFactory.getExpression(1,
				MidPackage.eINSTANCE.getModelReference(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
