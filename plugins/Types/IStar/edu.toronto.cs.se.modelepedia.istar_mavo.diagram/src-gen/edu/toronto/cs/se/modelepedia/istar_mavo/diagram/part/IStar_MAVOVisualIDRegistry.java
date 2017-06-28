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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class IStar_MAVOVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.istar_mavo.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID
					.equals(view.getType())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
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
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVODiagramEditorPlugin.getInstance()
						.logError("Unable to parse view type as a visualID number: " + type);
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
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getIStar().isSuperTypeOf(
				domainElement.eClass()) && isDiagram((edu.toronto.cs.se.modelepedia.istar_mavo.IStar) domainElement)) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID.equals(containerModelID)
				&& !"istar_mavo".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getSoftGoal()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getTask()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getResource()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getGoal()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getActor()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getSoftGoal()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getTask()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getResource()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getGoal()
					.isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID.equals(containerModelID)
				&& !"istar_mavo".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
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
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getMeansEnd()
				.isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID;
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDecomposition()
				.isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID;
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getContribution()
				.isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID;
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDependerLink()
				.isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID;
		}
		if (edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE.getDependeeLink()
				.isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(edu.toronto.cs.se.modelepedia.istar_mavo.IStar element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
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
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
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
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return false;
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
