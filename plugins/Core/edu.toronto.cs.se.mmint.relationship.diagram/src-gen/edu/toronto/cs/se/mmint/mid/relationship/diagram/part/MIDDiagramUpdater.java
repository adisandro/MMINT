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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.part;

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

import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

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
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000SemanticChildren(view);
		case ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID:
			return getModelEndpointReferenceModelEndpointReferenceCompartment_7001SemanticChildren(view);
		case ModelEndpointReferenceModelEndpointReferenceSuperCompartmentEditPart.VISUAL_ID:
			return getModelEndpointReferenceModelEndpointReferenceSuperCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<MIDNodeDescriptor> getModelRel_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModelEndpointRefs().iterator(); it.hasNext();) {
			ModelEndpointReference childElement = (ModelEndpointReference) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ModelEndpointReferenceEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelEndpointReference2EditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getMappingRefs().iterator(); it.hasNext();) {
			MappingReference childElement = (MappingReference) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == MappingReferenceEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == MappingReference2EditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<MIDNodeDescriptor> getModelEndpointReferenceModelEndpointReferenceCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ModelEndpointReference modelElement = (ModelEndpointReference) containerView.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModelElemRefs().iterator(); it.hasNext();) {
			ModelElementReference childElement = (ModelElementReference) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ModelElementReferenceEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<MIDNodeDescriptor> getModelEndpointReferenceModelEndpointReferenceSuperCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ModelEndpointReference modelElement = (ModelEndpointReference) containerView.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModelElemRefs().iterator(); it.hasNext();) {
			ModelElementReference childElement = (ModelElementReference) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ModelElementReference2EditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelElementReference3EditPart.VISUAL_ID) {
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
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000ContainedLinks(view);
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getModelEndpointReference_2001ContainedLinks(view);
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2002ContainedLinks(view);
		case MappingReference2EditPart.VISUAL_ID:
			return getMappingReference_2003ContainedLinks(view);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getModelEndpointReference_2004ContainedLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001ContainedLinks(view);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getModelElementReference_3002ContainedLinks(view);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getModelElementReference_3003ContainedLinks(view);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getModelElementEndpointReference_4002ContainedLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4003ContainedLinks(view);
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return getBinaryMappingReference_4004ContainedLinks(view);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getModelElementEndpointReference_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getModelEndpointReference_2001IncomingLinks(view);
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2002IncomingLinks(view);
		case MappingReference2EditPart.VISUAL_ID:
			return getMappingReference_2003IncomingLinks(view);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getModelEndpointReference_2004IncomingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001IncomingLinks(view);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getModelElementReference_3002IncomingLinks(view);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getModelElementReference_3003IncomingLinks(view);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getModelElementEndpointReference_4002IncomingLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4003IncomingLinks(view);
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return getBinaryMappingReference_4004IncomingLinks(view);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getModelElementEndpointReference_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return getModelEndpointReference_2001OutgoingLinks(view);
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2002OutgoingLinks(view);
		case MappingReference2EditPart.VISUAL_ID:
			return getMappingReference_2003OutgoingLinks(view);
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return getModelEndpointReference_2004OutgoingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001OutgoingLinks(view);
		case ModelElementReference2EditPart.VISUAL_ID:
			return getModelElementReference_3002OutgoingLinks(view);
		case ModelElementReference3EditPart.VISUAL_ID:
			return getModelElementReference_3003OutgoingLinks(view);
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return getModelElementEndpointReference_4002OutgoingLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4003OutgoingLinks(view);
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return getBinaryMappingReference_4004OutgoingLinks(view);
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return getModelElementEndpointReference_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelRel_1000ContainedLinks(View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryMappingReference_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2001ContainedLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2002ContainedLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2003ContainedLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2004ContainedLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3001ContainedLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3002ContainedLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003ContainedLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4002ContainedLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4003ContainedLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004ContainedLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4005ContainedLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2001IncomingLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2002IncomingLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2003IncomingLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2004IncomingLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3001IncomingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3002IncomingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003IncomingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4002IncomingLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4003IncomingLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004IncomingLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4005IncomingLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2001OutgoingLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2002OutgoingLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2003OutgoingLinks(View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelEndpointReference_2004OutgoingLinks(View view) {
		ModelEndpointReference modelElement = (ModelEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3001OutgoingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3002OutgoingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003OutgoingLinks(View view) {
		ModelElementReference modelElement = (ModelElementReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4002OutgoingLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4003OutgoingLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004OutgoingLinks(View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementEndpointReference_4005OutgoingLinks(View view) {
		ModelElementEndpointReference modelElement = (ModelElementEndpointReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(modelElement));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelElementEndpointReference_4002(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getModelElemEndpointRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelElementEndpointReference) {
				continue;
			}
			ModelElementEndpointReference link = (ModelElementEndpointReference) linkObject;
			if (ModelElementEndpointReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getModelElemRef();
			result.add(new MIDLinkDescriptor(container, dst, link, MIDElementTypes.ModelElementEndpointReference_4002,
					ModelElementEndpointReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMappingReference_4003(
			ModelRel container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getTargetModelElemRef();
			ModelElementReference src = link.getSourceModelElemRef();
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryMappingReference_4003,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMappingReference_4004(
			ModelRel container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReference2EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getTargetModelElemRef();
			ModelElementReference src = link.getSourceModelElemRef();
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_ModelElementEndpointReference_4005(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getModelElemEndpointRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof ModelElementEndpointReference) {
				continue;
			}
			ModelElementEndpointReference link = (ModelElementEndpointReference) linkObject;
			if (ModelElementEndpointReference2EditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getModelElemRef();
			result.add(new MIDLinkDescriptor(container, dst, link, MIDElementTypes.ModelElementEndpointReference_4005,
					ModelElementEndpointReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(
			ExtendibleElementReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RelationshipPackage.eINSTANCE
					.getExtendibleElementReference_SupertypeRef()) {
				result.add(new MIDLinkDescriptor(setting.getEObject(), target,
						MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001,
						ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4002(
			ModelElementReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getModelElementEndpointReference_ModelElemRef()
					|| false == setting.getEObject() instanceof ModelElementEndpointReference) {
				continue;
			}
			ModelElementEndpointReference link = (ModelElementEndpointReference) setting.getEObject();
			if (ModelElementEndpointReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof MappingReference) {
				continue;
			}
			MappingReference container = (MappingReference) link.eContainer();
			result.add(
					new MIDLinkDescriptor(container, target, link, MIDElementTypes.ModelElementEndpointReference_4002,
							ModelElementEndpointReferenceEditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMappingReference_4003(
			ModelElementReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getBinaryMappingReference_TargetModelElemRef()
					|| false == setting.getEObject() instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) setting.getEObject();
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference src = link.getSourceModelElemRef();
			result.add(new MIDLinkDescriptor(src, target, link, MIDElementTypes.BinaryMappingReference_4003,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
			ModelElementReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getBinaryMappingReference_TargetModelElemRef()
					|| false == setting.getEObject() instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) setting.getEObject();
			if (BinaryMappingReference2EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference src = link.getSourceModelElemRef();
			result.add(new MIDLinkDescriptor(src, target, link, MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReference2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_ModelElementEndpointReference_4005(
			ModelElementReference target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getModelElementEndpointReference_ModelElemRef()
					|| false == setting.getEObject() instanceof ModelElementEndpointReference) {
				continue;
			}
			ModelElementEndpointReference link = (ModelElementEndpointReference) setting.getEObject();
			if (ModelElementEndpointReference2EditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			if (false == link.eContainer() instanceof MappingReference) {
				continue;
			}
			MappingReference container = (MappingReference) link.eContainer();
			result.add(
					new MIDLinkDescriptor(container, target, link, MIDElementTypes.ModelElementEndpointReference_4005,
							ModelElementEndpointReference2EditPart.VISUAL_ID));

		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElementReference_SupertypeRef_4001(
			ExtendibleElementReference source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		ExtendibleElementReference destination = source.getSupertypeRef();
		if (destination == null) {
			return result;
		}
		result.add(
				new MIDLinkDescriptor(source, destination, MIDElementTypes.ExtendibleElementReferenceSupertypeRef_4001,
						ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID));
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMappingReference_4003(
			ModelElementReference source) {
		ModelRel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof ModelRel) {
				container = (ModelRel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getTargetModelElemRef();
			ModelElementReference src = link.getSourceModelElemRef();
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryMappingReference_4003,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(
			ModelElementReference source) {
		ModelRel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof ModelRel) {
				container = (ModelRel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingRefs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReference2EditPart.VISUAL_ID != MIDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelElementReference dst = link.getTargetModelElemRef();
			ModelElementReference src = link.getSourceModelElemRef();
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link, MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReference2EditPart.VISUAL_ID));
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
