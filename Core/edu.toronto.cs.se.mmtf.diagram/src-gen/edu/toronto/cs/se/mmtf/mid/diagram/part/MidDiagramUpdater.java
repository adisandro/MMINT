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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Parameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

/**
 * @generated
 */
public class MidDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getSemanticChildren(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getMultiModel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MidNodeDescriptor> result = new LinkedList<MidNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModels().iterator(); it.hasNext();) {
			Model childElement = (Model) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Model2EditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRelEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRel2EditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOperators().iterator(); it
				.hasNext();) {
			Operator childElement = (Operator) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == OperatorEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getContainedLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000ContainedLinks(view);
		case ModelEditPart.VISUAL_ID:
			return getModel_2011ContainedLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2012ContainedLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2013ContainedLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2014ContainedLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2015ContainedLinks(view);
		case ModelEndpointEditPart.VISUAL_ID:
			return getModelEndpoint_4014ContainedLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4015ContainedLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_4016ContainedLinks(view);
		case Parameter2EditPart.VISUAL_ID:
			return getParameter_4017ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getIncomingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_2011IncomingLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2012IncomingLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2013IncomingLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2014IncomingLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2015IncomingLinks(view);
		case ModelEndpointEditPart.VISUAL_ID:
			return getModelEndpoint_4014IncomingLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4015IncomingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_4016IncomingLinks(view);
		case Parameter2EditPart.VISUAL_ID:
			return getParameter_4017IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOutgoingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_2011OutgoingLinks(view);
		case Model2EditPart.VISUAL_ID:
			return getModel_2012OutgoingLinks(view);
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_2013OutgoingLinks(view);
		case ModelRel2EditPart.VISUAL_ID:
			return getModelRel_2014OutgoingLinks(view);
		case OperatorEditPart.VISUAL_ID:
			return getOperator_2015OutgoingLinks(view);
		case ModelEndpointEditPart.VISUAL_ID:
			return getModelEndpoint_4014OutgoingLinks(view);
		case BinaryModelRelEditPart.VISUAL_ID:
			return getBinaryModelRel_4015OutgoingLinks(view);
		case ParameterEditPart.VISUAL_ID:
			return getParameter_4016OutgoingLinks(view);
		case Parameter2EditPart.VISUAL_ID:
			return getParameter_4017OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getMultiModel_1000ContainedLinks(
			View view) {
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2011ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2012ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2013ContainedLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2014ContainedLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2015ContainedLinks(
			View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Parameter_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Parameter_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelEndpoint_4014ContainedLinks(
			View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4015ContainedLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4016ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4017ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2011IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2012IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2013IncomingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2014IncomingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2015IncomingLinks(
			View view) {
		Operator modelElement = (Operator) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelEndpoint_4014IncomingLinks(
			View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4015IncomingLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4016(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Parameter_4017(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4016IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4017IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2011OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModel_2012OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2013OutgoingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_2014OutgoingLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOperator_2015OutgoingLinks(
			View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Parameter_4016(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Parameter_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelEndpoint_4014OutgoingLinks(
			View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryModelRel_4015OutgoingLinks(
			View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4016OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getParameter_4017OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4014(
			ModelRel container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getModelEndpoints().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) linkObject;
			if (ModelEndpointEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExtendibleElement dst = link.getTarget();
			result.add(new MidLinkDescriptor(container, dst, link,
					MidElementTypes.ModelEndpoint_4014,
					ModelEndpointEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_BinaryModelRel_4015(
			MultiModel container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getTargetModel();
			Model src = link.getSourceModel();
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryModelRel_4015,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_Parameter_4016(
			Operator container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getInputs().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Parameter) {
				continue;
			}
			Parameter link = (Parameter) linkObject;
			if (ParameterEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getModel();
			result.add(new MidLinkDescriptor(container, dst, link,
					MidElementTypes.Parameter_4016, ParameterEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_Parameter_4017(
			Operator container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getOutputs().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Parameter) {
				continue;
			}
			Parameter link = (Parameter) linkObject;
			if (Parameter2EditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getModel();
			result.add(new MidLinkDescriptor(container, dst, link,
					MidElementTypes.Parameter_4017,
					Parameter2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
			ExtendibleElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MidPackage.eINSTANCE
					.getExtendibleElement_Supertype()) {
				result.add(new MidLinkDescriptor(setting.getEObject(), target,
						MidElementTypes.ExtendibleElementSupertype_4013,
						ExtendibleElementSupertypeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
			ExtendibleElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MidPackage.eINSTANCE
					.getExtendibleElementEndpoint_Target()
					|| false == setting.getEObject() instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) setting.getEObject();
			if (ModelEndpointEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof ModelRel) {
				continue;
			}
			ModelRel container = (ModelRel) link.eContainer();
			result.add(new MidLinkDescriptor(container, target, link,
					MidElementTypes.ModelEndpoint_4014,
					ModelEndpointEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryModelRel_4015(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getBinaryModelRel_TargetModel()
					|| false == setting.getEObject() instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) setting.getEObject();
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model src = link.getSourceModel();
			result.add(new MidLinkDescriptor(src, target, link,
					MidElementTypes.BinaryModelRel_4015,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_Parameter_4016(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != OperatorPackage.eINSTANCE
					.getParameter_Model()
					|| false == setting.getEObject() instanceof Parameter) {
				continue;
			}
			Parameter link = (Parameter) setting.getEObject();
			if (ParameterEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MidLinkDescriptor(container, target, link,
					MidElementTypes.Parameter_4016, ParameterEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_Parameter_4017(
			Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != OperatorPackage.eINSTANCE
					.getParameter_Model()
					|| false == setting.getEObject() instanceof Parameter) {
				continue;
			}
			Parameter link = (Parameter) setting.getEObject();
			if (Parameter2EditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MidLinkDescriptor(container, target, link,
					MidElementTypes.Parameter_4017,
					Parameter2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
			ExtendibleElement source) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		ExtendibleElement destination = source.getSupertype();
		if (destination == null) {
			return result;
		}
		result.add(new MidLinkDescriptor(source, destination,
				MidElementTypes.ExtendibleElementSupertype_4013,
				ExtendibleElementSupertypeEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(
			Model source) {
		MultiModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MultiModel) {
				container = (MultiModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getTargetModel();
			Model src = link.getSourceModel();
			if (src != source) {
				continue;
			}
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryModelRel_4015,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<MidNodeDescriptor> getSemanticChildren(View view) {
			return MidDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MidLinkDescriptor> getContainedLinks(View view) {
			return MidDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MidLinkDescriptor> getIncomingLinks(View view) {
			return MidDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MidLinkDescriptor> getOutgoingLinks(View view) {
			return MidDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
