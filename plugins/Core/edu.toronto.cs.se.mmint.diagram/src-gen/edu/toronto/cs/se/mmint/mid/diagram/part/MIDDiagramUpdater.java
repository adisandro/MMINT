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
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.update.DiagramUpdater;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
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
			case MIDEditPart.VISUAL_ID:
				return getMID_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getMID_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.mmint.mid.MID modelElement = (edu.toronto.cs.se.mmint.mid.MID) view.getElement();
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
			case MIDEditPart.VISUAL_ID:
				return getMID_1000ContainedLinks(view);
			case ModelEditPart.VISUAL_ID:
				return getModel_2001ContainedLinks(view);
			case Model2EditPart.VISUAL_ID:
				return getModel_2002ContainedLinks(view);
			case ModelRelEditPart.VISUAL_ID:
				return getModelRel_2003ContainedLinks(view);
			case ModelRel2EditPart.VISUAL_ID:
				return getModelRel_2004ContainedLinks(view);
			case OperatorEditPart.VISUAL_ID:
				return getOperator_2005ContainedLinks(view);
			case ModelEndpointEditPart.VISUAL_ID:
				return getModelEndpoint_4002ContainedLinks(view);
			case BinaryModelRelEditPart.VISUAL_ID:
				return getBinaryModelRel_4003ContainedLinks(view);
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getModelEndpoint_4004ContainedLinks(view);
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getModelEndpoint_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
			case ModelEditPart.VISUAL_ID:
				return getModel_2001IncomingLinks(view);
			case Model2EditPart.VISUAL_ID:
				return getModel_2002IncomingLinks(view);
			case ModelRelEditPart.VISUAL_ID:
				return getModelRel_2003IncomingLinks(view);
			case ModelRel2EditPart.VISUAL_ID:
				return getModelRel_2004IncomingLinks(view);
			case OperatorEditPart.VISUAL_ID:
				return getOperator_2005IncomingLinks(view);
			case ModelEndpointEditPart.VISUAL_ID:
				return getModelEndpoint_4002IncomingLinks(view);
			case BinaryModelRelEditPart.VISUAL_ID:
				return getBinaryModelRel_4003IncomingLinks(view);
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getModelEndpoint_4004IncomingLinks(view);
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getModelEndpoint_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
			case ModelEditPart.VISUAL_ID:
				return getModel_2001OutgoingLinks(view);
			case Model2EditPart.VISUAL_ID:
				return getModel_2002OutgoingLinks(view);
			case ModelRelEditPart.VISUAL_ID:
				return getModelRel_2003OutgoingLinks(view);
			case ModelRel2EditPart.VISUAL_ID:
				return getModelRel_2004OutgoingLinks(view);
			case OperatorEditPart.VISUAL_ID:
				return getOperator_2005OutgoingLinks(view);
			case ModelEndpointEditPart.VISUAL_ID:
				return getModelEndpoint_4002OutgoingLinks(view);
			case BinaryModelRelEditPart.VISUAL_ID:
				return getBinaryModelRel_4003OutgoingLinks(view);
			case ModelEndpoint2EditPart.VISUAL_ID:
				return getModelEndpoint_4004OutgoingLinks(view);
			case ModelEndpoint3EditPart.VISUAL_ID:
				return getModelEndpoint_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMID_1000ContainedLinks(View view) {
		edu.toronto.cs.se.mmint.mid.MID modelElement = (edu.toronto.cs.se.mmint.mid.MID) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2001ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2002ContainedLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2003ContainedLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2004ContainedLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2005ContainedLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4002ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4003ContainedLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4004ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4005ContainedLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2001IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2002IncomingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2003IncomingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2004IncomingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2005IncomingLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4002IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4003IncomingLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryModelRel_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4004IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4005IncomingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
			.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result
			.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelEndpoint_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2001OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModel_2002OutgoingLinks(View view) {
		Model modelElement = (Model) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2003OutgoingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_2004OutgoingLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOperator_2005OutgoingLinks(View view) {
		Operator modelElement = (Operator) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4002OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryModelRel_4003OutgoingLinks(View view) {
		BinaryModelRel modelElement = (BinaryModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelEndpoint_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4004OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpoint_4005OutgoingLinks(View view) {
		ModelEndpoint modelElement = (ModelEndpoint) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4002(
			ModelRel container) {
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
			result.add(
				new MIDLinkDescriptor(
					container,
					dst,
					link,
					MIDElementTypes.ModelEndpoint_4002,
					ModelEndpointEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryModelRel_4003(
			edu.toronto.cs.se.mmint.mid.MID container) {
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
			result.add(
				new MIDLinkDescriptor(
					src,
					dst,
					link,
					MIDElementTypes.BinaryModelRel_4003,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4004(
			Operator container) {
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
			result.add(
				new MIDLinkDescriptor(
					container,
					dst,
					link,
					MIDElementTypes.ModelEndpoint_4004,
					ModelEndpoint2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelEndpoint_4005(
			Operator container) {
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
			result.add(
				new MIDLinkDescriptor(
					container,
					dst,
					link,
					MIDElementTypes.ModelEndpoint_4005,
					ModelEndpoint3EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MIDPackage.eINSTANCE.getExtendibleElement_Supertype()) {
				result.add(
					new MIDLinkDescriptor(
						setting.getEObject(),
						target,
						MIDElementTypes.ExtendibleElementSupertype_4001,
						ExtendibleElementSupertypeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4002(
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
			result.add(
				new MIDLinkDescriptor(
					container,
					target,
					link,
					MIDElementTypes.ModelEndpoint_4002,
					ModelEndpointEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryModelRel_4003(
			Model target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
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
			result.add(
				new MIDLinkDescriptor(
					src,
					target,
					link,
					MIDElementTypes.BinaryModelRel_4003,
					BinaryModelRelEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4004(
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
			result.add(
				new MIDLinkDescriptor(
					container,
					target,
					link,
					MIDElementTypes.ModelEndpoint_4004,
					ModelEndpoint2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelEndpoint_4005(
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
			result.add(
				new MIDLinkDescriptor(
					container,
					target,
					link,
					MIDElementTypes.ModelEndpoint_4005,
					ModelEndpoint3EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		ExtendibleElement destination = source.getSupertype();
		if (destination == null) {
			return result;
		}
		result.add(
			new MIDLinkDescriptor(
				source,
				destination,
				MIDElementTypes.ExtendibleElementSupertype_4001,
				ExtendibleElementSupertypeEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryModelRel_4003(Model source) {
		edu.toronto.cs.se.mmint.mid.MID container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.mmint.mid.MID) {
				container = (edu.toronto.cs.se.mmint.mid.MID) element;
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
			result.add(
				new MIDLinkDescriptor(
					src,
					dst,
					link,
					MIDElementTypes.BinaryModelRel_4003,
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
