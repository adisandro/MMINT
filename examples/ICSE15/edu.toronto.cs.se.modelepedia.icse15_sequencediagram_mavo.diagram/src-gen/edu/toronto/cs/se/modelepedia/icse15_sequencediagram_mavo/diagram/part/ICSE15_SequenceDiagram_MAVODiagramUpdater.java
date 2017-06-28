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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part;

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
public class ICSE15_SequenceDiagram_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.VISUAL_ID:
			return getSequenceDiagram_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassClassOperationsCompartmentEditPart.VISUAL_ID:
			return getClassClassOperationsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> getSequenceDiagram_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getLifelines().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline childElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getClasses().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class childElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getMessages().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message childElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> getClassClassOperationsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getOperations().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation childElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.VISUAL_ID:
			return getSequenceDiagram_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID:
			return getLifeline_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID:
			return getMessage_2003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
			return getClassReference_4001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID:
			return getOperationReference_4002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID:
			return getSourceLifelineReference_4003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID:
			return getTargetLifelineReference_4004ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID:
			return getLifeline_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID:
			return getMessage_2003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
			return getClassReference_4001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID:
			return getOperationReference_4002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID:
			return getSourceLifelineReference_4003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID:
			return getTargetLifelineReference_4004IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID:
			return getLifeline_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return getClass_2002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID:
			return getMessage_2003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return getOperation_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
			return getClassReference_4001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID:
			return getOperationReference_4002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID:
			return getSourceLifelineReference_4003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID:
			return getTargetLifelineReference_4004OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getSequenceDiagram_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getLifeline_2001ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_ClassReference_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClass_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getMessage_2003ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_OperationReference_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_SourceLifelineReference_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_TargetLifelineReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperation_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClassReference_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperationReference_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getSourceLifelineReference_4003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getTargetLifelineReference_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getLifeline_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_SourceLifelineReference_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_TargetLifelineReference_4004(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClass_2002IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_ClassReference_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getMessage_2003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperation_3001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_OperationReference_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClassReference_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperationReference_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getSourceLifelineReference_4003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getTargetLifelineReference_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getLifeline_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_ClassReference_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClass_2002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getMessage_2003OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message modelElement = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_OperationReference_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_SourceLifelineReference_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_TargetLifelineReference_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperation_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getClassReference_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOperationReference_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getSourceLifelineReference_4003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getTargetLifelineReference_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_ClassReference_4001(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline container) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getClass_().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_OperationReference_4002(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getOperation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.OperationReference_4002,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_SourceLifelineReference_4003(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getSourceLifeline().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SourceLifelineReference_4003,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_TargetLifelineReference_4004(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTargetLifeline().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.TargetLifelineReference_4004,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_ClassReference_4001(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getClassReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_OperationReference_4002(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getOperationReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.OperationReference_4002,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_SourceLifelineReference_4003(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getSourceLifelineReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SourceLifelineReference_4003,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_TargetLifelineReference_4004(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getTargetLifelineReference_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, target, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.TargetLifelineReference_4004,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_ClassReference_4001(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline source) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) {
				container = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getClass_().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_OperationReference_4002(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message source) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) {
				container = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getOperation().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.OperationReference_4002,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_SourceLifelineReference_4003(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message source) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) {
				container = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getSourceLifeline().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SourceLifelineReference_4003,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_TargetLifelineReference_4004(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message source) {
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) {
				container = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTargetLifeline().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference link = (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference) linkObject;
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor(
							src, dst, link,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.TargetLifelineReference_4004,
							edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID));
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

		public List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return ICSE15_SequenceDiagram_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return ICSE15_SequenceDiagram_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return ICSE15_SequenceDiagram_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return ICSE15_SequenceDiagram_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
