/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.part;

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

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingLink;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingLink;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingLinkElementsEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerModelContainerCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDDiagramUpdater {

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
	public static List<MIDNodeDescriptor> getSemanticChildren(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_1000SemanticChildren(view);
		case ModelContainerModelContainerCompartmentEditPart.VISUAL_ID:
			return getModelContainerModelContainerCompartment_7003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getMappingReference_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContainers().iterator(); it
				.hasNext();) {
			ModelContainer childElement = (ModelContainer) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelContainerEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getMappingLinks().iterator(); it
				.hasNext();) {
			MappingLink childElement = (MappingLink) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MappingLinkEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getModelContainerModelContainerCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		ModelContainer modelElement = (ModelContainer) containerView
				.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it
				.hasNext();) {
			ModelElementReference childElement = (ModelElementReference) it
					.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
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
	public static List<MIDLinkDescriptor> getContainedLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_1000ContainedLinks(view);
		case ModelContainerEditPart.VISUAL_ID:
			return getModelContainer_2005ContainedLinks(view);
		case MappingLinkEditPart.VISUAL_ID:
			return getMappingLink_2006ContainedLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003ContainedLinks(view);
		case BinaryMappingLinkEditPart.VISUAL_ID:
			return getBinaryMappingLink_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelContainerEditPart.VISUAL_ID:
			return getModelContainer_2005IncomingLinks(view);
		case MappingLinkEditPart.VISUAL_ID:
			return getMappingLink_2006IncomingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003IncomingLinks(view);
		case BinaryMappingLinkEditPart.VISUAL_ID:
			return getBinaryMappingLink_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelContainerEditPart.VISUAL_ID:
			return getModelContainer_2005OutgoingLinks(view);
		case MappingLinkEditPart.VISUAL_ID:
			return getMappingLink_2006OutgoingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003OutgoingLinks(view);
		case BinaryMappingLinkEditPart.VISUAL_ID:
			return getBinaryMappingLink_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_1000ContainedLinks(
			View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryMappingLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingLink_2006ContainedLinks(
			View view) {
		MappingLink modelElement = (MappingLink) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingLink_4005ContainedLinks(
			View view) {
		BinaryMappingLink modelElement = (BinaryMappingLink) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingLink_2006IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003IncomingLinks(
			View view) {
		ModelElementReference modelElement = (ModelElementReference) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MappingLink_Elements_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingLink_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingLink_2006OutgoingLinks(
			View view) {
		MappingLink modelElement = (MappingLink) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelElementReference_3003OutgoingLinks(
			View view) {
		ModelElementReference modelElement = (ModelElementReference) view
				.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingLink_4005OutgoingLinks(
			View view) {
		BinaryMappingLink modelElement = (BinaryMappingLink) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMappingLink_4005Gen(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) linkObject;
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElements();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping link.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMappingLink_4005(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) linkObject;
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElements();
			Object theTarget = targets.size() == 2 ? targets.get(1) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElements();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_MappingLink_Elements_4004(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MappingPackage.eINSTANCE
					.getMappingLink_Elements()) {
				result.add(new MIDLinkDescriptor(setting.getEObject(), target,
						MIDElementTypes.MappingLinkElements_4004,
						MappingLinkElementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMappingLink_4005Gen(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MappingPackage.eINSTANCE
					.getMappingLink_Elements()
					|| false == setting.getEObject() instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) setting.getEObject();
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getElements();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MIDLinkDescriptor(src, target, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping link.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMappingLink_4005(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MappingPackage.eINSTANCE
					.getMappingLink_Elements()
					|| false == setting.getEObject() instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) setting.getEObject();
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getElements();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			result.add(new MIDLinkDescriptor(src, target, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004Gen(
			MappingLink source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> destinations = source.getElements().iterator(); destinations
				.hasNext();) {
			ModelElementReference destination = (ModelElementReference) destinations
					.next();
			result.add(new MIDLinkDescriptor(source, destination,
					MIDElementTypes.MappingLinkElements_4004,
					MappingLinkElementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Avoids element links to go out from a binary mapping link. 
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004(
			MappingLink source) {

		if (source instanceof BinaryMappingLink) {
			return new LinkedList<MIDLinkDescriptor>();
		}
		return getOutgoingFeatureModelFacetLinks_MappingLink_Elements_4004Gen(source);
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMappingLink_4005Gen(
			ModelElementReference source) {
		MappingReference container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MappingReference) {
				container = (MappingReference) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) linkObject;
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElements();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElements();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping link.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMappingLink_4005(
			ModelElementReference source) {
		MappingReference container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof MappingReference) {
				container = (MappingReference) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappingLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingLink) {
				continue;
			}
			BinaryMappingLink link = (BinaryMappingLink) linkObject;
			if (BinaryMappingLinkEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getElements();
			Object theTarget = targets.size() == 2 ? targets.get(1) : null;
			if (false == theTarget instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference dst = (ModelElementReference) theTarget;
			List sources = link.getElements();
			Object theSource = sources.size() == 2 ? sources.get(0) : null;
			if (false == theSource instanceof ModelElementReference) {
				continue;
			}
			ModelElementReference src = (ModelElementReference) theSource;
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingLink_4005,
					BinaryMappingLinkEditPart.VISUAL_ID));
		}
		return result;
	}

}
