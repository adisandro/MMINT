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

import edu.toronto.cs.se.mmtf.mid.mapping.Mapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElement;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingElementsEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelContainerModelContainerCompartmentEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelElementEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<MIDNodeDescriptor> getSemanticChildren(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case MappingReferenceEditPart.VISUAL_ID:
			return getMappingReference_1000SemanticChildren(view);
		case ModelContainerModelContainerCompartmentEditPart.VISUAL_ID:
			return getModelContainerModelContainerCompartment_7002SemanticChildren(view);
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
		{
			ModelContainer childElement = modelElement.getContainer();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelContainerEditPart.VISUAL_ID) {
				result.add(new MIDNodeDescriptor(childElement, visualID));
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
	public static List<MIDNodeDescriptor> getModelContainerModelContainerCompartment_7002SemanticChildren(
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
			ModelElement childElement = (ModelElement) it.next();
			int visualID = MIDVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ModelElementEditPart.VISUAL_ID) {
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
			return getModelContainer_2003ContainedLinks(view);
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004ContainedLinks(view);
		case ModelElementEditPart.VISUAL_ID:
			return getModelElement_3002ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getIncomingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelContainerEditPart.VISUAL_ID:
			return getModelContainer_2003IncomingLinks(view);
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004IncomingLinks(view);
		case ModelElementEditPart.VISUAL_ID:
			return getModelElement_3002IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getOutgoingLinks(View view) {
		switch (MIDVisualIDRegistry.getVisualID(view)) {
		case ModelContainerEditPart.VISUAL_ID:
			return getModelContainer_2003OutgoingLinks(view);
		case MappingEditPart.VISUAL_ID:
			return getMapping_2004OutgoingLinks(view);
		case ModelElementEditPart.VISUAL_ID:
			return getModelElement_3002OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getMappingReference_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2003ContainedLinks(
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
	public static List<MIDLinkDescriptor> getModelElement_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2003IncomingLinks(
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
	public static List<MIDLinkDescriptor> getModelElement_3002IncomingLinks(
			View view) {
		ModelElement modelElement = (ModelElement) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Mapping_Elements_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<MIDLinkDescriptor> getModelContainer_2003OutgoingLinks(
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
	public static List<MIDLinkDescriptor> getModelElement_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<MIDLinkDescriptor> getIncomingFeatureModelFacetLinks_Mapping_Elements_4002(
			ModelElement target,
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
	private static Collection<MIDLinkDescriptor> getOutgoingFeatureModelFacetLinks_Mapping_Elements_4002(
			Mapping source) {
		LinkedList<MIDLinkDescriptor> result = new LinkedList<MIDLinkDescriptor>();
		for (Iterator<?> destinations = source.getElements().iterator(); destinations
				.hasNext();) {
			ModelElement destination = (ModelElement) destinations.next();
			result.add(new MIDLinkDescriptor(source, destination,
					MIDElementTypes.MappingElements_4002,
					MappingElementsEditPart.VISUAL_ID));
		}
		return result;
	}

}
