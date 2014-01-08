/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Parameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterName2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterNameEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel10EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel11EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel12EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel13EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel14EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel15EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel3EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel4EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel5EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel6EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel7EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel8EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabel9EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.WrappingLabelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.expressions.MidOCLFactory;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

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
	private static final String DEBUG_KEY = "edu.toronto.cs.se.mmtf.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (MultiModelEditPart.MODEL_ID.equals(view.getType())) {
				return MultiModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
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
		if (MidPackage.eINSTANCE.getMultiModel().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((MultiModel) domainElement)) {
			return MultiModelEditPart.VISUAL_ID;
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
		String containerModelID = edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
				.getModelID(containerView);
		if (!MultiModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"mid".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (MultiModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = MultiModelEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case MultiModelEditPart.VISUAL_ID:
			if (MidPackage.eINSTANCE.getModel().isSuperTypeOf(
					domainElement.eClass())
					&& isModel_2011((Model) domainElement)) {
				return ModelEditPart.VISUAL_ID;
			}
			if (MidPackage.eINSTANCE.getModel().isSuperTypeOf(
					domainElement.eClass())
					&& isModel_2012((Model) domainElement)) {
				return Model2EditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getModelRel().isSuperTypeOf(
					domainElement.eClass())
					&& isModelRel_2013((ModelRel) domainElement)) {
				return ModelRelEditPart.VISUAL_ID;
			}
			if (RelationshipPackage.eINSTANCE.getModelRel().isSuperTypeOf(
					domainElement.eClass())
					&& isModelRel_2014((ModelRel) domainElement)) {
				return ModelRel2EditPart.VISUAL_ID;
			}
			if (OperatorPackage.eINSTANCE.getOperator().isSuperTypeOf(
					domainElement.eClass())) {
				return OperatorEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
				.getModelID(containerView);
		if (!MultiModelEditPart.MODEL_ID.equals(containerModelID)
				&& !"mid".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (MultiModelEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = MultiModelEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case MultiModelEditPart.VISUAL_ID:
			if (ModelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Model2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelRelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ModelRel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OperatorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Model2EditPart.VISUAL_ID:
			if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel11EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelRelEditPart.VISUAL_ID:
			if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel12EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelRel2EditPart.VISUAL_ID:
			if (WrappingLabel4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel13EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OperatorEditPart.VISUAL_ID:
			if (WrappingLabel5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ModelEndpointEditPart.VISUAL_ID:
			if (WrappingLabel6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel14EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BinaryModelRelEditPart.VISUAL_ID:
			if (WrappingLabel7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (WrappingLabel15EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ParameterEditPart.VISUAL_ID:
			if (ParameterNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Parameter2EditPart.VISUAL_ID:
			if (ParameterName2EditPart.VISUAL_ID == nodeVisualID) {
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
		if (MidPackage.eINSTANCE.getModelEndpoint().isSuperTypeOf(
				domainElement.eClass())
				&& isModelEndpoint_4014((ModelEndpoint) domainElement)) {
			return ModelEndpointEditPart.VISUAL_ID;
		}
		if (RelationshipPackage.eINSTANCE.getBinaryModelRel().isSuperTypeOf(
				domainElement.eClass())) {
			return BinaryModelRelEditPart.VISUAL_ID;
		}
		if (OperatorPackage.eINSTANCE.getParameter().isSuperTypeOf(
				domainElement.eClass())
				&& isParameter_4016((Parameter) domainElement)) {
			return ParameterEditPart.VISUAL_ID;
		}
		if (OperatorPackage.eINSTANCE.getParameter().isSuperTypeOf(
				domainElement.eClass())
				&& isParameter_4017((Parameter) domainElement)) {
			return Parameter2EditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(MultiModel element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean isModel_2011(Model domainElement) {
		Object result = MidOCLFactory.getExpression(0,
				MidPackage.eINSTANCE.getModel(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModel_2012(Model domainElement) {
		Object result = MidOCLFactory.getExpression(1,
				MidPackage.eINSTANCE.getModel(), null).evaluate(domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelRel_2013(ModelRel domainElement) {
		Object result = MidOCLFactory.getExpression(2,
				RelationshipPackage.eINSTANCE.getModelRel(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelRel_2014(ModelRel domainElement) {
		Object result = MidOCLFactory.getExpression(3,
				RelationshipPackage.eINSTANCE.getModelRel(), null).evaluate(
				domainElement);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static boolean isModelEndpoint_4014(ModelEndpoint domainElement) {
		return !(domainElement.eContainer() instanceof BinaryModelRel);
	}

	/**
	 * @generated
	 */
	private static boolean isParameter_4016(Parameter domainElement) {
		return domainElement.eContainmentFeature().getName().equals("inputs");
	}

	/**
	 * @generated
	 */
	private static boolean isParameter_4017(Parameter domainElement) {
		return domainElement.eContainmentFeature().getName().equals("outputs");
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
		case MultiModelEditPart.VISUAL_ID:
			return false;
		case ModelEditPart.VISUAL_ID:
		case Model2EditPart.VISUAL_ID:
		case ModelRelEditPart.VISUAL_ID:
		case ModelRel2EditPart.VISUAL_ID:
		case OperatorEditPart.VISUAL_ID:
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
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView,
				EObject domainElement, int candidate) {
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry
					.isSemanticLeafVisualID(visualID);
		}
	};

}
