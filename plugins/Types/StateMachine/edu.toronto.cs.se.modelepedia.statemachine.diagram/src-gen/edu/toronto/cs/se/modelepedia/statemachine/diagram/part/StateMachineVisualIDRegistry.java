/*
 * Copyright Text ->
 * 
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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

import edu.toronto.cs.se.modelepedia.statemachine.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionTriggerActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateNameEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateStateInternalActionsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionTriggerActionEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class StateMachineVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.statemachine.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StateMachineEditPart.MODEL_ID.equals(view.getType())) {
				return StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
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
				StateMachineDiagramEditorPlugin.getInstance().logError(
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
		if (StateMachinePackage.eINSTANCE.getStateMachine().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((StateMachine) domainElement)) {
			return StateMachineEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
				.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachine".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case StateMachineEditPart.VISUAL_ID:
			if (StateMachinePackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (StateMachinePackage.eINSTANCE.getInitialState().isSuperTypeOf(
					domainElement.eClass())) {
				return InitialStateEditPart.VISUAL_ID;
			}
			if (StateMachinePackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			break;
		case StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
			if (StateMachinePackage.eINSTANCE.getStateAction().isSuperTypeOf(
					domainElement.eClass())) {
				return StateActionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
				.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)
				&& !"statemachine".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case StateMachineEditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InitialStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateStateInternalActionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateActionEditPart.VISUAL_ID:
			if (StateActionTriggerActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
			if (StateActionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionTriggerActionEditPart.VISUAL_ID == nodeVisualID) {
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
		if (StateMachinePackage.eINSTANCE.getTransition().isSuperTypeOf(
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
	private static boolean isDiagram(StateMachine element) {
		return true;
	}

	/**
	 * @generated
	 */
	public static boolean checkNodeVisualID(View containerView,
			EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	 * @generated
	 */
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case StateMachineEditPart.VISUAL_ID:
			return false;
		case InitialStateEditPart.VISUAL_ID:
		case FinalStateEditPart.VISUAL_ID:
		case StateActionEditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
