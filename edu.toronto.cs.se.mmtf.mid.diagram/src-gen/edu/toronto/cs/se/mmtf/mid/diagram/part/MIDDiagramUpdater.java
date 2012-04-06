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

import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;

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
		case MultiModelEditPart.VISUAL_ID:
			return getMultiModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getMultiModel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MIDNodeDescriptor> result = new LinkedList<MIDNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElements().iterator(); it
				.hasNext();) {
			ModelReference childElement = (ModelReference) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == MappingReferenceEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelReferenceEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ModelReference2EditPart.VISUAL_ID) {
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
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2004ContainedLinks(view);
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2002ContainedLinks(view);
		case ModelReference2EditPart.VISUAL_ID:
			return getModelReference_2003ContainedLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2004IncomingLinks(view);
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2002IncomingLinks(view);
		case ModelReference2EditPart.VISUAL_ID:
			return getModelReference_2003IncomingLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_2004OutgoingLinks(view);
		case ModelReferenceEditPart.VISUAL_ID:
			return getModelReference_2002OutgoingLinks(view);
		case ModelReference2EditPart.VISUAL_ID:
			return getModelReference_2003OutgoingLinks(view);
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return getBinaryMappingReference_4004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMultiModel_1000ContainedLinks(
			View view) {
		MultiModel modelElement = (MultiModel) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2004ContainedLinks(
			View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004ContainedLinks(
			View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view
				.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2004IncomingLinks(
			View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MappingReference_Models_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2002IncomingLinks(
			View view) {
		ModelReference modelElement = (ModelReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MappingReference_Models_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2003IncomingLinks(
			View view) {
		ModelReference modelElement = (ModelReference) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MappingReference_Models_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004IncomingLinks(
			View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_MappingReference_Models_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_2004OutgoingLinks(
			View view) {
		MappingReference modelElement = (MappingReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2002OutgoingLinks(
			View view) {
		ModelReference modelElement = (ModelReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelReference_2003OutgoingLinks(
			View view) {
		ModelReference modelElement = (ModelReference) view.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getBinaryMappingReference_4004OutgoingLinks(
			View view) {
		BinaryMappingReference modelElement = (BinaryMappingReference) view
				.getElement();
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getContainedTypeModelFacetLinks_BinaryMappingReference_4004(
			MultiModel container) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelReference dst = link.getModel1();
			ModelReference src = link.getModel0();
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_MappingReference_Models_4003(
			ModelReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == MappingPackage.eINSTANCE
					.getMappingReference_Models()) {
				result.add(new MIDLinkDescriptor(setting.getEObject(), target,
						MIDElementTypes.MappingReferenceModels_4003,
						MappingReferenceModelsEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingTypeModelFacetLinks_BinaryMappingReference_4004(
			ModelReference target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != MappingPackage.eINSTANCE
					.getBinaryMappingReference_Model1()
					|| false == setting.getEObject() instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) setting
					.getEObject();
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelReference src = link.getModel0();
			result.add(new MIDLinkDescriptor(src, target, link,
					MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003Gen(
			MappingReference source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> destinations = source.getModels().iterator(); destinations
				.hasNext();) {
			ModelReference destination = (ModelReference) destinations.next();
			result.add(new MIDLinkDescriptor(source, destination,
					MIDElementTypes.MappingReferenceModels_4003,
					MappingReferenceModelsEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003(
			MappingReference source) {

		if (source instanceof BinaryMappingReference) {
			return new LinkedList<MIDLinkDescriptor>();
		}
		return getOutgoingFeatureModelFacetLinks_MappingReference_Models_4003Gen(source);
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getOutgoingTypeModelFacetLinks_BinaryMappingReference_4004(
			ModelReference source) {
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
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> links = container.getElements().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof BinaryMappingReference) {
				continue;
			}
			BinaryMappingReference link = (BinaryMappingReference) linkObject;
			if (BinaryMappingReferenceEditPart.VISUAL_ID != MIDVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			ModelReference dst = link.getModel1();
			ModelReference src = link.getModel0();
			if (src != source) {
				continue;
			}
			result.add(new MIDLinkDescriptor(src, dst, link,
					MIDElementTypes.BinaryMappingReference_4004,
					BinaryMappingReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

}
