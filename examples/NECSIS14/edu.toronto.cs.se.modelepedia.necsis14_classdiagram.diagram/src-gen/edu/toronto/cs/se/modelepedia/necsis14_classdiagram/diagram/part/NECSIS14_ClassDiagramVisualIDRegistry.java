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
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part;

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
public class NECSIS14_ClassDiagramVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
					.equals(view.getType())) {
				return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
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
				edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramDiagramEditorPlugin
						.getInstance().logError(
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
		if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
				.getClassDiagram().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram) domainElement)) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
				.equals(containerModelID)
				&& !"necsis14_classdiagram".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getClass_().isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getAttribute().isSuperTypeOf(domainElement.eClass())) {
				return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getModelID(containerView);
		if (!edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
				.equals(containerModelID)
				&& !"necsis14_classdiagram".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.MODEL_ID
				.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassParentEditPart.VISUAL_ID:
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
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
		if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
				.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram element) {
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
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID:
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
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return false;
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
