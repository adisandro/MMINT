/*
 * Copyright Text ->
 * 
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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.part;

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

import edu.toronto.cs.se.modelepedia.statemachine.AbstractState;
import edu.toronto.cs.se.modelepedia.statemachine.FinalState;
import edu.toronto.cs.se.modelepedia.statemachine.InitialState;
import edu.toronto.cs.se.modelepedia.statemachine.State;
import edu.toronto.cs.se.modelepedia.statemachine.StateAction;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachine;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;
import edu.toronto.cs.se.modelepedia.statemachine.Transition;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateStateInternalActionsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;

/**
 * @generated
 */
public class StateMachineDiagramUpdater {

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
	public static List<StateMachineNodeDescriptor> getSemanticChildren(View view) {
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000SemanticChildren(view);
		case StateStateInternalActionsCompartmentEditPart.VISUAL_ID:
			return getStateStateInternalActionsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineNodeDescriptor> getStateMachine_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		StateMachine modelElement = (StateMachine) view.getElement();
		LinkedList<StateMachineNodeDescriptor> result = new LinkedList<StateMachineNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			AbstractState childElement = (AbstractState) it.next();
			int visualID = StateMachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StateMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == InitialStateEditPart.VISUAL_ID) {
				result.add(new StateMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new StateMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineNodeDescriptor> getStateStateInternalActionsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		State modelElement = (State) containerView.getElement();
		LinkedList<StateMachineNodeDescriptor> result = new LinkedList<StateMachineNodeDescriptor>();
		for (Iterator<?> it = modelElement.getInternalActions().iterator(); it
				.hasNext();) {
			StateAction childElement = (StateAction) it.next();
			int visualID = StateMachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateActionEditPart.VISUAL_ID) {
				result.add(new StateMachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getContainedLinks(View view) {
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2001ContainedLinks(view);
		case InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002ContainedLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003ContainedLinks(view);
		case StateActionEditPart.VISUAL_ID:
			return getStateAction_3001ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getIncomingLinks(View view) {
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001IncomingLinks(view);
		case InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002IncomingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003IncomingLinks(view);
		case StateActionEditPart.VISUAL_ID:
			return getStateAction_3001IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getOutgoingLinks(View view) {
		switch (StateMachineVisualIDRegistry.getVisualID(view)) {
		case StateEditPart.VISUAL_ID:
			return getState_2001OutgoingLinks(view);
		case InitialStateEditPart.VISUAL_ID:
			return getInitialState_2002OutgoingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_2003OutgoingLinks(view);
		case StateActionEditPart.VISUAL_ID:
			return getStateAction_3001OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getStateMachine_1000ContainedLinks(
			View view) {
		StateMachine modelElement = (StateMachine) view.getElement();
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getState_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getInitialState_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getFinalState_2003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getStateAction_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getState_2001IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getInitialState_2002IncomingLinks(
			View view) {
		InitialState modelElement = (InitialState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getFinalState_2003IncomingLinks(
			View view) {
		FinalState modelElement = (FinalState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getStateAction_3001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getState_2001OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getInitialState_2002OutgoingLinks(
			View view) {
		InitialState modelElement = (InitialState) view.getElement();
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getFinalState_2003OutgoingLinks(
			View view) {
		FinalState modelElement = (FinalState) view.getElement();
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getStateAction_3001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StateMachineLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<StateMachineLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			StateMachine container) {
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StateMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractState dst = link.getTarget();
			AbstractState src = link.getSource();
			result.add(new StateMachineLinkDescriptor(src, dst, link,
					StateMachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StateMachineLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			AbstractState target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != StateMachinePackage.eINSTANCE
					.getTransition_Target()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != StateMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractState src = link.getSource();
			result.add(new StateMachineLinkDescriptor(src, target, link,
					StateMachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StateMachineLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			AbstractState source) {
		StateMachine container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof StateMachine) {
				container = (StateMachine) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<StateMachineLinkDescriptor> result = new LinkedList<StateMachineLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StateMachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			AbstractState dst = link.getTarget();
			AbstractState src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new StateMachineLinkDescriptor(src, dst, link,
					StateMachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
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
		public List<StateMachineNodeDescriptor> getSemanticChildren(View view) {
			return StateMachineDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateMachineLinkDescriptor> getContainedLinks(View view) {
			return StateMachineDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateMachineLinkDescriptor> getIncomingLinks(View view) {
			return StateMachineDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<StateMachineLinkDescriptor> getOutgoingLinks(View view) {
			return StateMachineDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
