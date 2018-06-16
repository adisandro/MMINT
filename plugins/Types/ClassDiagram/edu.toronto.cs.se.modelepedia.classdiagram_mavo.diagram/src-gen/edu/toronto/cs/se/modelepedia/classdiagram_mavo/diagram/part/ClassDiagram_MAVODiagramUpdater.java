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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part;

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
public class ClassDiagram_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
			return getClassClassOwnedAttributesCompartment_7001SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
			return getClassClassOwnedOperationsCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> getClassDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getClasses().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class childElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> getClassClassOwnedAttributesCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute childElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> getClassClassOwnedOperationsCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation childElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return getClassDiagram_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return getNestedInReference_4002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return getSuperclassReference_4003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return getNestedInReference_4002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return getSuperclassReference_4003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return getAttribute_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return getAssociation_4001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return getNestedInReference_4002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return getSuperclassReference_4003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return getDependency_4004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getClassDiagram_1000ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getClass_2001ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_NestedInReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_SuperclassReference_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAttribute_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOperation_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAssociation_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getNestedInReference_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getSuperclassReference_4003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getDependency_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getClass_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Association_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_NestedInReference_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_SuperclassReference_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAttribute_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOperation_3002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAssociation_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getNestedInReference_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getSuperclassReference_4003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getDependency_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getClass_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_NestedInReference_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_SuperclassReference_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAttribute_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOperation_3002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getAssociation_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getNestedInReference_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getSuperclassReference_4003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getDependency_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram container) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_NestedInReference_4002(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class container) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getNestedIn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_SuperclassReference_4003(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class container) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getSuperclass().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4004(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram container) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependencies().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getDepender();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getDependee();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getAssociation_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, target, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_NestedInReference_4002(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getNestedInReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, target, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_SuperclassReference_4003(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getSuperclassReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, target, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4004(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getDependency_Depender()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getDependee();
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, target, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4001(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class source) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) {
				container = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getAssociations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Association_4001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_NestedInReference_4002(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class source) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) {
				container = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getNestedIn().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.NestedInReference_4002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_SuperclassReference_4003(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class source) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) {
				container = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getSuperclass().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.SuperclassReference_4003,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4004(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class source) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) {
				container = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependencies().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency link = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency) linkObject;
			if (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dst = link.getDepender();
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class src = link.getDependee();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes.Dependency_4004,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID));
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

		public List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return ClassDiagram_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return ClassDiagram_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return ClassDiagram_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return ClassDiagram_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
