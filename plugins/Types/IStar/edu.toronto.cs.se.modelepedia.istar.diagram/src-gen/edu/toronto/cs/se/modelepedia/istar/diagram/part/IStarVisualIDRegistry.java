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
package edu.toronto.cs.se.modelepedia.istar.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

import edu.toronto.cs.se.modelepedia.istar.IStar;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ContributionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DecompositionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependeeLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependerLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Goal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.IStarEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.MeansEndEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Resource2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalNameEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Task2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskName2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class IStarVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.istar.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (IStarEditPart.MODEL_ID.equals(view.getType())) {
				return IStarEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
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
				IStarDiagramEditorPlugin.getInstance().logError(
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
		if (IStarPackage.eINSTANCE.getIStar().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((IStar) domainElement)) {
			return IStarEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
				.getModelID(containerView);
		if (!IStarEditPart.MODEL_ID.equals(containerModelID)
				&& !"istar".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (IStarEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = IStarEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case IStarEditPart.VISUAL_ID:
			if (IStarPackage.eINSTANCE.getSoftGoal().isSuperTypeOf(
					domainElement.eClass())) {
				return SoftGoalEditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getTask().isSuperTypeOf(
					domainElement.eClass())) {
				return TaskEditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getResource().isSuperTypeOf(
					domainElement.eClass())) {
				return ResourceEditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getGoal().isSuperTypeOf(
					domainElement.eClass())) {
				return GoalEditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getActor().isSuperTypeOf(
					domainElement.eClass())) {
				return ActorEditPart.VISUAL_ID;
			}
			break;
		case ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			if (IStarPackage.eINSTANCE.getSoftGoal().isSuperTypeOf(
					domainElement.eClass())) {
				return SoftGoal2EditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getTask().isSuperTypeOf(
					domainElement.eClass())) {
				return Task2EditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getResource().isSuperTypeOf(
					domainElement.eClass())) {
				return Resource2EditPart.VISUAL_ID;
			}
			if (IStarPackage.eINSTANCE.getGoal().isSuperTypeOf(
					domainElement.eClass())) {
				return Goal2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
				.getModelID(containerView);
		if (!IStarEditPart.MODEL_ID.equals(containerModelID)
				&& !"istar".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (IStarEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = IStarEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case IStarEditPart.VISUAL_ID:
			if (SoftGoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ResourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SoftGoalEditPart.VISUAL_ID:
			if (SoftGoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TaskEditPart.VISUAL_ID:
			if (TaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ResourceEditPart.VISUAL_ID:
			if (ResourceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GoalEditPart.VISUAL_ID:
			if (GoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorEditPart.VISUAL_ID:
			if (ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActorActorIntentionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SoftGoal2EditPart.VISUAL_ID:
			if (SoftGoalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Task2EditPart.VISUAL_ID:
			if (TaskName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Resource2EditPart.VISUAL_ID:
			if (ResourceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Goal2EditPart.VISUAL_ID:
			if (GoalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			if (SoftGoal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Task2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Resource2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Goal2EditPart.VISUAL_ID == nodeVisualID) {
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
		if (IStarPackage.eINSTANCE.getMeansEnd().isSuperTypeOf(
				domainElement.eClass())) {
			return MeansEndEditPart.VISUAL_ID;
		}
		if (IStarPackage.eINSTANCE.getDecomposition().isSuperTypeOf(
				domainElement.eClass())) {
			return DecompositionEditPart.VISUAL_ID;
		}
		if (IStarPackage.eINSTANCE.getContribution().isSuperTypeOf(
				domainElement.eClass())) {
			return ContributionEditPart.VISUAL_ID;
		}
		if (IStarPackage.eINSTANCE.getDependerLink().isSuperTypeOf(
				domainElement.eClass())) {
			return DependerLinkEditPart.VISUAL_ID;
		}
		if (IStarPackage.eINSTANCE.getDependeeLink().isSuperTypeOf(
				domainElement.eClass())) {
			return DependeeLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(IStar element) {
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
		case ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
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
		case IStarEditPart.VISUAL_ID:
			return false;
		case SoftGoalEditPart.VISUAL_ID:
		case TaskEditPart.VISUAL_ID:
		case ResourceEditPart.VISUAL_ID:
		case GoalEditPart.VISUAL_ID:
		case SoftGoal2EditPart.VISUAL_ID:
		case Task2EditPart.VISUAL_ID:
		case Resource2EditPart.VISUAL_ID:
		case Goal2EditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
