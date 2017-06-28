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
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.structure.DiagramStructure;

import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedAttributesCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedOperationsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassDiagramEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNestedInEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassSuperclassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.DependencyEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationNameEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class ClassDiagramVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "edu.toronto.cs.se.modelepedia.classdiagram.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (ClassDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return ClassDiagramEditPart.VISUAL_ID;
			}
			else {
				return -1;
			}
		}
		return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
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
		}
		catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				ClassDiagramDiagramEditorPlugin
					.getInstance()
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
		if (ClassDiagramPackage.eINSTANCE.getClassDiagram().isSuperTypeOf(domainElement.eClass())
				&& isDiagram((ClassDiagram) domainElement)) {
			return ClassDiagramEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
			.getModelID(containerView);
		if (!ClassDiagramEditPart.MODEL_ID.equals(containerModelID) && !"classdiagram".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (ClassDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.getVisualID(containerView);
		}
		else {
			if (containerView instanceof Diagram) {
				containerVisualID = ClassDiagramEditPart.VISUAL_ID;
			}
			else {
				return -1;
			}
		}
		switch (containerVisualID) {
			case ClassDiagramEditPart.VISUAL_ID:
				if (ClassDiagramPackage.eINSTANCE.getClass_().isSuperTypeOf(domainElement.eClass())) {
					return ClassEditPart.VISUAL_ID;
				}
				break;
			case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
				if (ClassDiagramPackage.eINSTANCE.getAttribute().isSuperTypeOf(domainElement.eClass())) {
					return AttributeEditPart.VISUAL_ID;
				}
				break;
			case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
				if (ClassDiagramPackage.eINSTANCE.getOperation().isSuperTypeOf(domainElement.eClass())) {
					return OperationEditPart.VISUAL_ID;
				}
				break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
			.getModelID(containerView);
		if (!ClassDiagramEditPart.MODEL_ID.equals(containerModelID) && !"classdiagram".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (ClassDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.getVisualID(containerView);
		}
		else {
			if (containerView instanceof Diagram) {
				containerVisualID = ClassDiagramEditPart.VISUAL_ID;
			}
			else {
				return false;
			}
		}
		switch (containerVisualID) {
			case ClassDiagramEditPart.VISUAL_ID:
				if (ClassEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case ClassEditPart.VISUAL_ID:
				if (ClassNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				if (ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				if (ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case AttributeEditPart.VISUAL_ID:
				if (AttributeNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case OperationEditPart.VISUAL_ID:
				if (OperationNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
				if (AttributeEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
				if (OperationEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case AssociationEditPart.VISUAL_ID:
				if (AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case ClassNestedInEditPart.VISUAL_ID:
				if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
					return true;
				}
				break;
			case ClassSuperclassEditPart.VISUAL_ID:
				if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
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
		if (ClassDiagramPackage.eINSTANCE.getAssociation().isSuperTypeOf(domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		if (ClassDiagramPackage.eINSTANCE.getDependency().isSuperTypeOf(domainElement.eClass())) {
			return DependencyEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(ClassDiagram element) {
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
			case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
			case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
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
			case ClassDiagramEditPart.VISUAL_ID:
				return false;
			case AttributeEditPart.VISUAL_ID:
			case OperationEditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.getVisualID(view);
		}

		/**
		* @generated
		*/
		@Override

		public String getModelID(View view) {
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.getModelID(view);
		}

		/**
		* @generated
		*/
		@Override

		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.getNodeVisualID(containerView, domainElement);
		}

		/**
		* @generated
		*/
		@Override

		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.isCompartmentVisualID(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry
				.isSemanticLeafVisualID(visualID);
		}
	};

}
