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
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.xt.statechart.StatechartPackage;
import edu.toronto.cs.se.mmtf.xt.statechart.SuperState;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.State2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateName2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateNameEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState3EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateName2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateNameEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateSuperStateCompartment2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateSuperStateCompartmentEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.TransitionEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class StatechartVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.mmtf.xt.statechart.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (SuperStateEditPart.MODEL_ID.equals(view.getType())) {
				return SuperStateEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry
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
				StatechartDiagramEditorPlugin.getInstance().logError(
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
		if (StatechartPackage.eINSTANCE.getSuperState().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((SuperState) domainElement)) {
			return SuperStateEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry
				.getModelID(containerView);
		if (!SuperStateEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (SuperStateEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SuperStateEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case SuperStateEditPart.VISUAL_ID:
			if (StatechartPackage.eINSTANCE.getSuperState().isSuperTypeOf(
					domainElement.eClass())) {
				return SuperState2EditPart.VISUAL_ID;
			}
			if (StatechartPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			break;
		case SuperStateSuperStateCompartmentEditPart.VISUAL_ID:
			if (StatechartPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return State2EditPart.VISUAL_ID;
			}
			if (StatechartPackage.eINSTANCE.getSuperState().isSuperTypeOf(
					domainElement.eClass())) {
				return SuperState3EditPart.VISUAL_ID;
			}
			break;
		case SuperStateSuperStateCompartment2EditPart.VISUAL_ID:
			if (StatechartPackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return State2EditPart.VISUAL_ID;
			}
			if (StatechartPackage.eINSTANCE.getSuperState().isSuperTypeOf(
					domainElement.eClass())) {
				return SuperState3EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry
				.getModelID(containerView);
		if (!SuperStateEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (SuperStateEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = SuperStateEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case SuperStateEditPart.VISUAL_ID:
			if (SuperState2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SuperState2EditPart.VISUAL_ID:
			if (SuperStateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SuperStateSuperStateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (StateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SuperState3EditPart.VISUAL_ID:
			if (SuperStateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SuperStateSuperStateCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SuperStateSuperStateCompartmentEditPart.VISUAL_ID:
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SuperState3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SuperStateSuperStateCompartment2EditPart.VISUAL_ID:
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SuperState3EditPart.VISUAL_ID == nodeVisualID) {
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
		if (StatechartPackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(SuperState element) {
		return true;
	}

}
