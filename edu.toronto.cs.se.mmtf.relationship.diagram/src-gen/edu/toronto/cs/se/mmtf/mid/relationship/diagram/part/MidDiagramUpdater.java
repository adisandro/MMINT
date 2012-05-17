/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.part;

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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceModelReferenceCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

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
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000SemanticChildren(view);
		case ModelReferenceModelReferenceCompartmentEditPart.VISUAL_ID:
			return getModelReferenceModelReferenceCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getModelRel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidNodeDescriptor> result = new LinkedList<MidNodeDescriptor>();
		for (Iterator<?> it = modelElement.getModelRefs().iterator(); it
				.hasNext();) {
			ModelReference childElement = (ModelReference) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelReferenceEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getLinks().iterator(); it.hasNext();) {
			Link childElement = (Link) it.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == LinkEditPart.VISUAL_ID) {
				result.add(new MidNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidNodeDescriptor> getModelReferenceModelReferenceCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ModelReference modelElement = (ModelReference) containerView
				.getElement();
		LinkedList<MidNodeDescriptor> result = new LinkedList<MidNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElementRefs().iterator(); it
				.hasNext();) {
			ModelElementReference childElement = (ModelElementReference) it
					.next();
			int visualID = MidVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelElementReferenceEditPart.VISUAL_ID) {
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
		case ModelRelEditPart.VISUAL_ID:
			return getModelRel_1000ContainedLinks(view);
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2001ContainedLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_2002ContainedLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001ContainedLinks(view);
		case BinaryLinkEditPart.VISUAL_ID:
			return getBinaryLink_4003ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getIncomingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2001IncomingLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_2002IncomingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001IncomingLinks(view);
		case BinaryLinkEditPart.VISUAL_ID:
			return getBinaryLink_4003IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getOutgoingLinks(View view) {
		switch (MidVisualIDRegistry.getVisualID(view)) {
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2001OutgoingLinks(view);
		case LinkEditPart.VISUAL_ID:
			return getLink_2002OutgoingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3001OutgoingLinks(view);
		case BinaryLinkEditPart.VISUAL_ID:
			return getBinaryLink_4003OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelRel_1000ContainedLinks(
			View view) {
		ModelRel modelElement = (ModelRel) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_BinaryLink_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelReference_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getLink_2002ContainedLinks(View view) {
		Link modelElement = (Link) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelElementReference_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryLink_4003ContainedLinks(
			View view) {
		BinaryLink modelElement = (BinaryLink) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelReference_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getLink_2002IncomingLinks(View view) {
		Link modelElement = (Link) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelElementReference_3001IncomingLinks(
			View view) {
		ModelElementReference modelElement = (ModelElementReference) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Link_ElementRefs_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryLink_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryLink_4003IncomingLinks(
			View view) {
		BinaryLink modelElement = (BinaryLink) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelReference_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getLink_2002OutgoingLinks(View view) {
		Link modelElement = (Link) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getModelElementReference_3001OutgoingLinks(
			View view) {
		ModelElementReference modelElement = (ModelElementReference) view
				.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryLink_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MidLinkDescriptor> getBinaryLink_4003OutgoingLinks(
			View view) {
		BinaryLink modelElement = (BinaryLink) view.getElement();
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_BinaryLink_4003Gen(
			ModelRel container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) linkObject;
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElementRefs();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary link.
	 * 
	 * @generated NOT
	 */
	private static Collection<MidLinkDescriptor> getContainedTypeModelFacetLinks_BinaryLink_4003(
			ModelRel container) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) linkObject;
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElementRefs();
			Object theTarget = targets.size() == 2 ? targets.get(1) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MidPackage.eINSTANCE
					.getExtendibleElement_Supertype()) {
				result.add(new MidLinkDescriptor(setting.getEObject(), target,
						MidElementTypes.ExtendibleElementSupertype_4001,
						ExtendibleElementSupertypeEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingFeatureModelFacetLinks_Link_ElementRefs_4002(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == RelationshipPackage.eINSTANCE
					.getLink_ElementRefs()) {
				result.add(new MidLinkDescriptor(setting.getEObject(), target,
						MidElementTypes.LinkElementRefs_4002,
						LinkElementRefsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryLink_4003Gen(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getLink_ElementRefs()
					|| false == setting.getEObject() instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) setting.getEObject();
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MidLinkDescriptor(src, target, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary link.
	 * 
	 * @generated NOT
	 */
	private static Collection<MidLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryLink_4003(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != RelationshipPackage.eINSTANCE
					.getLink_ElementRefs()
					|| false == setting.getEObject() instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) setting.getEObject();
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MidLinkDescriptor(src, target, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_ExtendibleElement_Supertype_4001(
			ExtendibleElement source) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		ExtendibleElement destination = source.getSupertype();
		if (destination == null) {
			return result;
		}
		result.add(new MidLinkDescriptor(source, destination,
				MidElementTypes.ExtendibleElementSupertype_4001,
				ExtendibleElementSupertypeEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002Gen(
			Link source) {
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> destinations = source.getElementRefs().iterator(); destinations
				.hasNext();) {
			ModelElementReference destination = (ModelElementReference) destinations
					.next();
			result.add(new MidLinkDescriptor(source, destination,
					MidElementTypes.LinkElementRefs_4002,
					LinkElementRefsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Avoids element links to go out from a binary link. 
	 * 
	 * @generated NOT
	 */
	private static Collection<MidLinkDescriptor> getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002(
			Link source) {

		if (source instanceof BinaryLink) {
			return new LinkedList<MidLinkDescriptor>();
		}
		return getOutgoingFeatureModelFacetLinks_Link_ElementRefs_4002Gen(source);
	}

	/**
	 * @generated
	 */
	private static Collection<MidLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryLink_4003Gen(
			ModelElementReference source) {
		ModelRel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ModelRel) {
				container = (ModelRel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) linkObject;
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElementRefs();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			if (src != source) {
				continue;
			}
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary link.
	 * 
	 * @generated NOT
	 */
	private static Collection<MidLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryLink_4003(
			ModelElementReference source) {
		ModelRel container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof ModelRel) {
				container = (ModelRel) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MidLinkDescriptor> result = new LinkedList<MidLinkDescriptor>();
		for (Iterator<?> links = container.getLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryLink) {
				continue;
			}
			BinaryLink link = (BinaryLink) linkObject;
			if (BinaryLinkEditPart.VISUAL_ID != MidVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElementRefs();
			Object theTarget = targets.size() == 2 ? targets.get(1) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElementRefs();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			if (src != source) {
				continue;
			}
			result.add(new MidLinkDescriptor(src, dst, link,
					MidElementTypes.BinaryLink_4003,
					BinaryLinkEditPart.VISUAL_ID));
		}
		return result;
	}

}
