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
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part;

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

/**
 * @generated
 */
public class NECSIS14_ClassDiagramDiagramUpdater {

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
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassClassAttributesCompartmentEditPart.VISUAL_ID:
			return getClassClassAttributesCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> getClassDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor>();
		for (Iterator<?> it = modelElement.getClasses().iterator(); it
				.hasNext();) {
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class childElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> getClassClassAttributesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor>();
		for (Iterator<?> it = modelElement.getAttributes().iterator(); it
				.hasNext();) {
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Attribute childElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Attribute) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getClassDiagram_1000ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getClass_2001ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Parent_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAttribute_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAssociation_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getClass_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Class_Parent_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAttribute_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAssociation_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getClass_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class modelElement = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Class_Parent_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAttribute_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getAssociation_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getContainedTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram container) {
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association link = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) linkObject;
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class dst = link
					.getTarget();
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class src = link
					.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association link = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class src = link
					.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor(
					src,
					target,
					link,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getIncomingFeatureModelFacetLinks_Class_Parent_4002(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage.eINSTANCE
					.getClass_Parent()) {
				result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor(
						setting.getEObject(),
						target,
						edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes.ClassParent_4002,
						edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassParentEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class source) {
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram) {
				container = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association link = (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association) linkObject;
			if (edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class dst = link
					.getTarget();
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class src = link
					.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor(
					src,
					dst,
					link,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getOutgoingFeatureModelFacetLinks_Class_Parent_4002(
			edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class source) {
		LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor>();
		edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class destination = source
				.getParent();
		if (destination == null) {
			return result;
		}
		result.add(new edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor(
				source,
				destination,
				edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.providers.NECSIS14_ClassDiagramElementTypes.ClassParent_4002,
				edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.edit.parts.ClassParentEditPart.VISUAL_ID));
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
		public List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramNodeDescriptor> getSemanticChildren(
				View view) {
			return NECSIS14_ClassDiagramDiagramUpdater
					.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getContainedLinks(
				View view) {
			return NECSIS14_ClassDiagramDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getIncomingLinks(
				View view) {
			return NECSIS14_ClassDiagramDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.diagram.part.NECSIS14_ClassDiagramLinkDescriptor> getOutgoingLinks(
				View view) {
			return NECSIS14_ClassDiagramDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
