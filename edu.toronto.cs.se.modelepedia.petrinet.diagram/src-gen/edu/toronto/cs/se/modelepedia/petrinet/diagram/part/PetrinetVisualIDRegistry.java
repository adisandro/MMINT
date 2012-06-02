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
package edu.toronto.cs.se.modelepedia.petrinet.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.modelepedia.petrinet.PetriNet;
import edu.toronto.cs.se.modelepedia.petrinet.PetrinetPackage;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.ArcEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.ArcWeightEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PetriNetEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PlaceEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.PlaceNameTokensEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.petrinet.diagram.edit.parts.TransitionNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class PetrinetVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.petrinet.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (PetriNetEditPart.MODEL_ID.equals(view.getType())) {
				return PetriNetEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry
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
				PetrinetDiagramEditorPlugin.getInstance().logError(
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
		if (PetrinetPackage.eINSTANCE.getPetriNet().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((PetriNet) domainElement)) {
			return PetriNetEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry
				.getModelID(containerView);
		if (!PetriNetEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (PetriNetEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PetriNetEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case PetriNetEditPart.VISUAL_ID:
			if (PetrinetPackage.eINSTANCE.getTransition().isSuperTypeOf(
					domainElement.eClass())) {
				return TransitionEditPart.VISUAL_ID;
			}
			if (PetrinetPackage.eINSTANCE.getPlace().isSuperTypeOf(
					domainElement.eClass())) {
				return PlaceEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry
				.getModelID(containerView);
		if (!PetriNetEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (PetriNetEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.petrinet.diagram.part.PetrinetVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = PetriNetEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case PetriNetEditPart.VISUAL_ID:
			if (TransitionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PlaceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PlaceEditPart.VISUAL_ID:
			if (PlaceNameTokensEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ArcEditPart.VISUAL_ID:
			if (ArcWeightEditPart.VISUAL_ID == nodeVisualID) {
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
		if (PetrinetPackage.eINSTANCE.getArc().isSuperTypeOf(
				domainElement.eClass())) {
			return ArcEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(PetriNet element) {
		return true;
	}

}
