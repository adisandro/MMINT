/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.part;

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

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

/**
 * @generated
 */
public class MIDDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getSemanticChildren(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getMultiModel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModels().iterator(); it.hasNext();) {
			Model childElement = (Model) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ModelEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Model2EditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRelEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelRel2EditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOperators().iterator(); it.hasNext();) {
			Operator childElement = (Operator) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperatorEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getContainedLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
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
		case ModelEndpoint2EditPart.VISUAL_ID:
			return getModelEndpoint_4018ContainedLinks(view);
		case ModelEndpoint3EditPart.VISUAL_ID:
			return getModelEndpoint_4019ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
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
		case ModelEndpoint2EditPart.VISUAL_ID:
			return getModelEndpoint_4018IncomingLinks(view);
		case ModelEndpoint3EditPart.VISUAL_ID:
			return getModelEndpoint_4019IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
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
		case ModelEndpoint2EditPart.VISUAL_ID:
			return getModelEndpoint_4018OutgoingLinks(view);
		case ModelEndpoint3EditPart.VISUAL_ID:
			return getModelEndpoint_4019OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMultiModel_1000ContainedLinks(View view) {
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2011ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2012ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2013ContainedLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2014ContainedLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2015ContainedLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4014ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4015ContainedLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4018ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4019ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2011IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2012IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2013IncomingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2014IncomingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2015IncomingLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4014IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4015IncomingLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4015(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4018IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4019IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
				.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4014(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4018(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4019(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2011OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2012OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2013OutgoingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2014OutgoingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2015OutgoingLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4018(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4019(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4014OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4015OutgoingLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4018OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4019OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4014(ModelRel container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getModelEndpoints().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) linkObject;
			if (ModelEndpointEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExtendibleElement dst = link.getTarget();
			result.add(new MIDLinkDescriptor(container, dst, link, MIDElementTypes.ModelEndpoint_4014,
					ModelEndpointEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryModelRel_4015(
			MultiModel container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getTargetModel();
			Model src = link.getSourceModel();
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryModelRel_4015,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4018(Operator container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getInputs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) linkObject;
			if (ModelEndpoint2EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExtendibleElement dst = link.getTarget();
			result.add(new MIDLinkDescriptor(container, dst, link, MIDElementTypes.ModelEndpoint_4018,
					ModelEndpoint2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4019(Operator container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getOutputs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) linkObject;
			if (ModelEndpoint3EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ExtendibleElement dst = link.getTarget();
			result.add(new MIDLinkDescriptor(container, dst, link, MIDElementTypes.ModelEndpoint_4019,
					ModelEndpoint3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
			ExtendibleElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MIDPackage.eINSTANCE.getExtendibleElement_Supertype()) {
				result.add(new MIDLinkDescriptor(setting.getEObject(), target,
						MIDElementTypes.ExtendibleElementSupertype_4013, ExtendibleElementSupertypeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4014(
			ExtendibleElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MIDPackage.eINSTANCE.getExtendibleElementEndpoint_Target()
					|| false == setting.getEObject() instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) setting.getEObject();
			if (ModelEndpointEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof ModelRel) {
				continue;
			}
			ModelRel container = (ModelRel) link.eContainer();
			result.add(new MIDLinkDescriptor(container, target, link, MIDElementTypes.ModelEndpoint_4014,
					ModelEndpointEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryModelRel_4015(Model target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE.getBinaryModelRel_TargetModel()
					|| false == setting.getEObject() instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) setting.getEObject();
			if (BinaryModelRelEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model src = link.getSourceModel();
			result.add(new MIDLinkDescriptor(src, target, link, MIDElementTypes.BinaryModelRel_4015,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4018(
			ExtendibleElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MIDPackage.eINSTANCE.getExtendibleElementEndpoint_Target()
					|| false == setting.getEObject() instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) setting.getEObject();
			if (ModelEndpoint2EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MIDLinkDescriptor(container, target, link, MIDElementTypes.ModelEndpoint_4018,
					ModelEndpoint2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4019(
			ExtendibleElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MIDPackage.eINSTANCE.getExtendibleElementEndpoint_Target()
					|| false == setting.getEObject() instanceof ModelEndpoint) {
				continue;
			}
			ModelEndpoint link = (ModelEndpoint) setting.getEObject();
			if (ModelEndpoint3EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof Operator) {
				continue;
			}
			Operator container = (Operator) link.eContainer();
			result.add(new MIDLinkDescriptor(container, target, link, MIDElementTypes.ModelEndpoint_4019,
					ModelEndpoint3EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4013(
			ExtendibleElement source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		ExtendibleElement destination = source.getSupertype();
		if (destination == null) {
			return result;
		}
		result.add(new MIDLinkDescriptor(source, destination, MIDElementTypes.ExtendibleElementSupertype_4013,
				ExtendibleElementSupertypeEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryModelRel_4015(Model source) {
		MultiModel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof MultiModel) {
				container = (MultiModel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getModels().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryModelRel) {
				continue;
			}
			BinaryModelRel link = (BinaryModelRel) linkObject;
			if (BinaryModelRelEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Model dst = link.getTargetModel();
			Model src = link.getSourceModel();
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryModelRel_4015,
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
		public List<MIDNodeDescriptor> getSemanticChildren(View view) {
			return MIDDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MIDLinkDescriptor> getContainedLinks(View view) {
			return MIDDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MIDLinkDescriptor> getIncomingLinks(View view) {
			return MIDDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<MIDLinkDescriptor> getOutgoingLinks(View view) {
			return MIDDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
