/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import edu.toronto.cs.se.modelepedia.powerwindow.PowerWindowPackage;
import edu.toronto.cs.se.modelepedia.powerwindow.Window;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredDelayEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerNameEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.WindowEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class PowerWindowVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.powerwindow.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (WindowEditPart.MODEL_ID.equals(view.getType())) {
				return WindowEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
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
				PowerWindowDiagramEditorPlugin.getInstance().logError(
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
		if (PowerWindowPackage.eINSTANCE.getWindow().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Window) domainElement)) {
			return WindowEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
				.getModelID(containerView);
		if (!WindowEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (WindowEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WindowEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case WindowEditPart.VISUAL_ID:
			if (PowerWindowPackage.eINSTANCE.getPushPull().isSuperTypeOf(
					domainElement.eClass())) {
				return PushPullEditPart.VISUAL_ID;
			}
			if (PowerWindowPackage.eINSTANCE.getRocker().isSuperTypeOf(
					domainElement.eClass())) {
				return RockerEditPart.VISUAL_ID;
			}
			if (PowerWindowPackage.eINSTANCE.getInfrared().isSuperTypeOf(
					domainElement.eClass())) {
				return InfraredEditPart.VISUAL_ID;
			}
			if (PowerWindowPackage.eINSTANCE.getLockOut().isSuperTypeOf(
					domainElement.eClass())) {
				return LockOutEditPart.VISUAL_ID;
			}
			if (PowerWindowPackage.eINSTANCE.getForceDetecting().isSuperTypeOf(
					domainElement.eClass())) {
				return ForceDetectingEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
				.getModelID(containerView);
		if (!WindowEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (WindowEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = WindowEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case WindowEditPart.VISUAL_ID:
			if (PushPullEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RockerEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (InfraredEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LockOutEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ForceDetectingEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PushPullEditPart.VISUAL_ID:
			if (PushPullNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RockerEditPart.VISUAL_ID:
			if (RockerNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case InfraredEditPart.VISUAL_ID:
			if (InfraredDelayEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LockOutEditPart.VISUAL_ID:
			if (LockOutNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ForceDetectingEditPart.VISUAL_ID:
			if (ForceDetectingDelayEditPart.VISUAL_ID == nodeVisualID) {
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
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Window element) {
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
		return false;
	}

	/**
	 * @generated
	 */
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case WindowEditPart.VISUAL_ID:
			return false;
		case PushPullEditPart.VISUAL_ID:
		case RockerEditPart.VISUAL_ID:
		case InfraredEditPart.VISUAL_ID:
		case LockOutEditPart.VISUAL_ID:
		case ForceDetectingEditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerWindowVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
