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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part;

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
public class StateMachine_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
			return getStateStateInternalActionsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> getStateMachine_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState childElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> getStateStateInternalActionsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.statemachine_mavo.State modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.State) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getInternalActions().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.statemachine_mavo.StateAction childElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.StateAction) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateActionEditPart.VISUAL_ID) {
				result.add(
						new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor(
								childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateActionEditPart.VISUAL_ID:
			return getStateAction_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateActionEditPart.VISUAL_ID:
			return getStateAction_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
				.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateActionEditPart.VISUAL_ID:
			return getStateAction_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getStateMachine_1000ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getState_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getInitialState_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getFinalState_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getStateAction_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getState_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.State modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.State) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getInitialState_2002IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.InitialState modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.InitialState) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getFinalState_2003IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.FinalState modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.FinalState) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getStateAction_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getState_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.State modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.State) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getInitialState_2002OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.InitialState modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.InitialState) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getFinalState_2003OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.FinalState modelElement = (edu.toronto.cs.se.modelepedia.statemachine_mavo.FinalState) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getStateAction_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine container) {
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition link = (edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) linkObject;
			if (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting
					.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
							.getTransition_Target()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition link = (edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor(
					src, target, link,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState source) {
		edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine) {
				container = (edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition link = (edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition) linkObject;
			if (edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor(
					src, dst, link,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID));
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

		public List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return StateMachine_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return StateMachine_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return StateMachine_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return StateMachine_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
