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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceModelReferenceCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceNameTypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.expressions.MidOCLFactory;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class MidVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.mmtf.relationship.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ModelRelEditPart.MODEL_ID.equals(view.getType())) {
				return ModelRelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
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
				MidDiagramEditorPlugin.getInstance().logError(
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
		if (RelationshipPackage.eINSTANCE.getModelRel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((ModelRel) domainElement)) {
			return ModelRelEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
				.getModelID(containerView);
		if (!ModelRelEditPart.MODEL_ID.equals(containerModelID)
				&& !"relationship".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ModelRelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelRelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ModelRelEditPart.VISUAL_ID:
			if (RelationshipPackage.eINSTANCE.getModelReference()
					.isSuperTypeOf(domainElement.eClass())) {
				return ModelReferenceEditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getLink().isSuperTypeOf(
					domainElement.eClass())
					&& isLink_2002((Link) domainElement)) {
				return LinkEditPart.VISUAL_ID;
			}
			break;
		case ModelReferenceModelReferenceCompartmentEditPart.VISUAL_ID:
			if (RelationshipPackage.eINSTANCE.getModelElementReference()
					.isSuperTypeOf(domainElement.eClass())) {
				return ModelElementReferenceEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
				.getModelID(containerView);
		if (!ModelRelEditPart.MODEL_ID.equals(containerModelID)
				&& !"relationship".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ModelRelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = ModelRelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ModelRelEditPart.VISUAL_ID:
			if (ModelReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LinkEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelReferenceEditPart.VISUAL_ID:
			if (ModelReferenceNameTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelReferenceModelReferenceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkEditPart.VISUAL_ID:
			if (LinkNameTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementReferenceEditPart.VISUAL_ID:
			if (ModelElementReferenceNameTypeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelReferenceModelReferenceCompartmentEditPart.VISUAL_ID:
			if (ModelElementReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkElementRefsEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BinaryLinkEditPart.VISUAL_ID:
			if (BinaryLinkNameTypeEditPart.VISUAL_ID == nodeVisualID) {
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
		if (RelationshipPackage.eINSTANCE.getBinaryLink().isSuperTypeOf(
				domainElement.eClass())) {
			return BinaryLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(ModelRel element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isLink_2002(Link domainElement) {
		Object result = MidOCLFactory.getExpression(0,
				RelationshipPackage.eINSTANCE.getLink(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

}
