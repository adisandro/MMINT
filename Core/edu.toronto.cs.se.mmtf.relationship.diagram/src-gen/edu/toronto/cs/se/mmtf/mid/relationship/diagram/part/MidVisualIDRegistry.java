/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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

import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel16EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel17EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel18EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel19EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel20EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel21EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel22EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel23EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel24EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel25EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel26EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.WrappingLabel9EditPart;
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
			if (RelationshipPackage.eINSTANCE.getModelEndpointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isModelEndpointReference_2007((ModelEndpointReference) domainElement)) {
				return ModelEndpointReferenceEditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getLinkReference().isSuperTypeOf(
					domainElement.eClass())
					&& isLinkReference_2008((LinkReference) domainElement)) {
				return LinkReferenceEditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getLinkReference().isSuperTypeOf(
					domainElement.eClass())
					&& isLinkReference_2009((LinkReference) domainElement)) {
				return LinkReference2EditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getModelEndpointReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isModelEndpointReference_2010((ModelEndpointReference) domainElement)) {
				return ModelEndpointReference2EditPart.VISUAL_ID;
			}
			break;
		case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
			if (RelationshipPackage.eINSTANCE.getModelElementReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isModelElementReference_3005((ModelElementReference) domainElement)) {
				return ModelElementReferenceEditPart.VISUAL_ID;
			}
			break;
		case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
			if (RelationshipPackage.eINSTANCE.getModelElementReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isModelElementReference_3006((ModelElementReference) domainElement)) {
				return ModelElementReference2EditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getModelElementReference()
					.isSuperTypeOf(domainElement.eClass())
					&& isModelElementReference_3007((ModelElementReference) domainElement)) {
				return ModelElementReference3EditPart.VISUAL_ID;
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
			if (ModelEndpointReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LinkReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LinkReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelEndpointReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel16EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkReferenceEditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel17EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LinkReference2EditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel18EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEndpointReference2EditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel19EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementReferenceEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel20EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementReference2EditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel21EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementReference3EditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel22EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
			if (ModelElementReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
			if (ModelElementReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelElementReference3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel23EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BinaryLinkReferenceEditPart.VISUAL_ID:
			if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel24EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BinaryLinkReference2EditPart.VISUAL_ID:
			if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel25EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			if (WrappingLabel15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel26EditPart.VISUAL_ID == nodeVisualID) {
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
		if (RelationshipPackage.eINSTANCE.getModelElementEndpointReference()
				.isSuperTypeOf(domainElement.eClass())
				&& isModelElementEndpointReference_4011((ModelElementEndpointReference) domainElement)) {
			return ModelElementEndpointReferenceEditPart.VISUAL_ID;
		}
		if (RelationshipPackage.eINSTANCE.getBinaryLinkReference()
				.isSuperTypeOf(domainElement.eClass())
				&& isBinaryLinkReference_4012((BinaryLinkReference) domainElement)) {
			return BinaryLinkReferenceEditPart.VISUAL_ID;
		}
		if (RelationshipPackage.eINSTANCE.getBinaryLinkReference()
				.isSuperTypeOf(domainElement.eClass())
				&& isBinaryLinkReference_4013((BinaryLinkReference) domainElement)) {
			return BinaryLinkReference2EditPart.VISUAL_ID;
		}
		if (RelationshipPackage.eINSTANCE.getModelElementEndpointReference()
				.isSuperTypeOf(domainElement.eClass())
				&& isModelElementEndpointReference_4014((ModelElementEndpointReference) domainElement)) {
			return ModelElementEndpointReference2EditPart.VISUAL_ID;
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
	private static boolean isModelEndpointReference_2007(
			ModelEndpointReference domainElement) {
		Object result = MidOCLFactory
				.getExpression(
						0,
						RelationshipPackage.eINSTANCE
								.getModelEndpointReference(), null).evaluate(
						domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isLinkReference_2008(LinkReference domainElement) {
		Object result = MidOCLFactory.getExpression(2,
				RelationshipPackage.eINSTANCE.getLinkReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isLinkReference_2009(LinkReference domainElement) {
		Object result = MidOCLFactory.getExpression(3,
				RelationshipPackage.eINSTANCE.getLinkReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelEndpointReference_2010(
			ModelEndpointReference domainElement) {
		Object result = MidOCLFactory
				.getExpression(
						4,
						RelationshipPackage.eINSTANCE
								.getModelEndpointReference(), null).evaluate(
						domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelElementReference_3005(
			ModelElementReference domainElement) {
		Object result = MidOCLFactory.getExpression(1,
				RelationshipPackage.eINSTANCE.getModelElementReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelElementReference_3006(
			ModelElementReference domainElement) {
		Object result = MidOCLFactory.getExpression(5,
				RelationshipPackage.eINSTANCE.getModelElementReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelElementReference_3007(
			ModelElementReference domainElement) {
		Object result = MidOCLFactory.getExpression(6,
				RelationshipPackage.eINSTANCE.getModelElementReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelElementEndpointReference_4011(
			ModelElementEndpointReference domainElement) {
		return !(domainElement.eContainer() instanceof BinaryLinkReference)
				&& ((ExtendibleElementEndpointReference) domainElement)
						.isModifiable();
	}

	/**
	 * @generated
	 */
	private static boolean isBinaryLinkReference_4012(
			BinaryLinkReference domainElement) {
		Object result = MidOCLFactory.getExpression(9,
				RelationshipPackage.eINSTANCE.getBinaryLinkReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isBinaryLinkReference_4013(
			BinaryLinkReference domainElement) {
		Object result = MidOCLFactory.getExpression(10,
				RelationshipPackage.eINSTANCE.getBinaryLinkReference(), null)
				.evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelElementEndpointReference_4014(
			ModelElementEndpointReference domainElement) {
		return !(domainElement.eContainer() instanceof BinaryLinkReference)
				&& !((ExtendibleElementEndpointReference) domainElement)
						.isModifiable();
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
		case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
		case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
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
		case ModelRelEditPart.VISUAL_ID:
			return false;
		case LinkReferenceEditPart.VISUAL_ID:
		case LinkReference2EditPart.VISUAL_ID:
		case ModelElementReferenceEditPart.VISUAL_ID:
		case ModelElementReference2EditPart.VISUAL_ID:
		case ModelElementReference3EditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
