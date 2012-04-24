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

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMapping;
import edu.toronto.cs.se.mmtf.mid.mapping.Mapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingElementsEditPart;
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
		for (Iterator<?> it = modelElement.getMappings().iterator(); it
				.hasNext();) {
			Mapping childElement = (Mapping) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MappingEditPart.VISUAL_ID) {
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
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004ContainedLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003ContainedLinks(view);
		case BinaryMappingEditPart.VISUAL_ID:
			return getBinaryMapping_4003ContainedLinks(view);
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
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004IncomingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003IncomingLinks(view);
		case BinaryMappingEditPart.VISUAL_ID:
			return getBinaryMapping_4003IncomingLinks(view);
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
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004OutgoingLinks(view);
		case ModelElementReferenceEditPart.VISUAL_ID:
			return getModelElementReference_3003OutgoingLinks(view);
		case BinaryMappingEditPart.VISUAL_ID:
			return getBinaryMapping_4003OutgoingLinks(view);
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
		result.addAll(getContainedTypeModelFacetLinks_BinaryMapping_4003(modelElement));
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
	public static List<MIDLinkDescriptor> getMapping_2004ContainedLinks(
			View view) {
		Mapping modelElement = (Mapping) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(modelElement));
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
	public static List<MIDLinkDescriptor> getBinaryMapping_4003ContainedLinks(
			View view) {
		BinaryMapping modelElement = (BinaryMapping) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(modelElement));
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
	public static List<MIDLinkDescriptor> getMapping_2004IncomingLinks(View view) {
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
		result.addAll(getIncomingFeatureModelFacetLinks_Mapping_Elements_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMapping_4003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMapping_4003IncomingLinks(
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
	public static List<MIDLinkDescriptor> getMapping_2004OutgoingLinks(View view) {
		Mapping modelElement = (Mapping) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(modelElement));
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
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMapping_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMapping_4003OutgoingLinks(
			View view) {
		BinaryMapping modelElement = (BinaryMapping) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMapping_4003Gen(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) linkObject;
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMapping_4003(
			MappingReference container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getMappings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) linkObject;
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_Mapping_Elements_4002(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MappingPackage.eINSTANCE
					.getMapping_Elements()) {
				result.add(new MIDLinkDescriptor(setting.getEObject(), target,
						MIDElementTypes.MappingElements_4002,
						MappingElementsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMapping_4003Gen(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MappingPackage.eINSTANCE
					.getMapping_Elements()
					|| false == setting.getEObject() instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) setting.getEObject();
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMapping_4003(
			ModelElementReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MappingPackage.eINSTANCE
					.getMapping_Elements()
					|| false == setting.getEObject() instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) setting.getEObject();
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002Gen(
			Mapping source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> destinations = source.getElements().iterator(); destinations
				.hasNext();) {
			ModelElementReference destination = (ModelElementReference) destinations
					.next();
			result.add(new MIDLinkDescriptor(source, destination,
					MIDElementTypes.MappingElements_4002,
					MappingElementsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Avoids element links to go out from binary mappings. 
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(
			Mapping source) {

		if (source instanceof BinaryMapping) {
			return new LinkedList<MIDLinkDescriptor>();
		}
		return getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002Gen(source);
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMapping_4003Gen(
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
		for (Iterator<?> links = container.getMappings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) linkObject;
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * Uses the same list for source and target of a binary mapping.
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMapping_4003(
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
		for (Iterator<?> links = container.getMappings().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMapping) {
				continue;
			}
			BinaryMapping link = (BinaryMapping) linkObject;
			if (BinaryMappingEditPart.VISUAL_ID != MIDVisualIDRegistry
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
					MIDElementTypes.BinaryMapping_4003,
					BinaryMappingEditPart.VISUAL_ID));
		}
		return result;
	}

}
