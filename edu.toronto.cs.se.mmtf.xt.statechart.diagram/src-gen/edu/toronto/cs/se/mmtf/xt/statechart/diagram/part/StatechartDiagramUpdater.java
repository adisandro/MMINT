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
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.part;

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

import edu.toronto.cs.se.mmtf.xt.statechart.State;
import edu.toronto.cs.se.mmtf.xt.statechart.StatechartPackage;
import edu.toronto.cs.se.mmtf.xt.statechart.SuperState;
import edu.toronto.cs.se.mmtf.xt.statechart.Transition;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.State2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState3EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateSuperStateCompartment2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateSuperStateCompartmentEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers.StatechartElementTypes;

/**
 * @generated
 */
public class StatechartDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<StatechartNodeDescriptor> getSemanticChildren(View view) {
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case SuperStateEditPart.VISUAL_ID:
			return getSuperState_1000SemanticChildren(view);
		case SuperStateSuperStateCompartmentEditPart.VISUAL_ID:
			return getSuperStateSuperStateCompartment_7001SemanticChildren(view);
		case SuperStateSuperStateCompartment2EditPart.VISUAL_ID:
			return getSuperStateSuperStateCompartment_7002SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartNodeDescriptor> getSuperState_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartNodeDescriptor> result = new LinkedList<StatechartNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StatechartVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SuperState2EditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartNodeDescriptor> getSuperStateSuperStateCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		SuperState modelElement = (SuperState) containerView.getElement();
		LinkedList<StatechartNodeDescriptor> result = new LinkedList<StatechartNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StatechartVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State2EditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SuperState3EditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartNodeDescriptor> getSuperStateSuperStateCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		SuperState modelElement = (SuperState) containerView.getElement();
		LinkedList<StatechartNodeDescriptor> result = new LinkedList<StatechartNodeDescriptor>();
		for (Iterator<?> it = modelElement.getStates().iterator(); it.hasNext();) {
			State childElement = (State) it.next();
			int visualID = StatechartVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == State2EditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == SuperState3EditPart.VISUAL_ID) {
				result.add(new StatechartNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getContainedLinks(View view) {
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case SuperStateEditPart.VISUAL_ID:
			return getSuperState_1000ContainedLinks(view);
		case SuperState2EditPart.VISUAL_ID:
			return getSuperState_2001ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002ContainedLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_3001ContainedLinks(view);
		case SuperState3EditPart.VISUAL_ID:
			return getSuperState_3002ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getIncomingLinks(View view) {
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case SuperState2EditPart.VISUAL_ID:
			return getSuperState_2001IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002IncomingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_3001IncomingLinks(view);
		case SuperState3EditPart.VISUAL_ID:
			return getSuperState_3002IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getOutgoingLinks(View view) {
		switch (StatechartVisualIDRegistry.getVisualID(view)) {
		case SuperState2EditPart.VISUAL_ID:
			return getSuperState_2001OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_2002OutgoingLinks(view);
		case State2EditPart.VISUAL_ID:
			return getState_3001OutgoingLinks(view);
		case SuperState3EditPart.VISUAL_ID:
			return getSuperState_3002OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_1000ContainedLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_2001ContainedLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_2002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_3002ContainedLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getTransition_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_2001IncomingLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_2002IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_3001IncomingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_3002IncomingLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getTransition_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_2001OutgoingLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_2002OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getState_3001OutgoingLinks(
			View view) {
		State modelElement = (State) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getSuperState_3002OutgoingLinks(
			View view) {
		SuperState modelElement = (SuperState) view.getElement();
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<StatechartLinkDescriptor> getTransition_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<StatechartLinkDescriptor> getContainedTypeModelFacetLinks_Transition_4001(
			SuperState container) {
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatechartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getEnd();
			State src = link.getStart();
			result.add(new StatechartLinkDescriptor(src, dst, link,
					StatechartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatechartLinkDescriptor> getIncomingTypeModelFacetLinks_Transition_4001(
			State target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != StatechartPackage.eINSTANCE
					.getTransition_End()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != StatechartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State src = link.getStart();
			result.add(new StatechartLinkDescriptor(src, target, link,
					StatechartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<StatechartLinkDescriptor> getOutgoingTypeModelFacetLinks_Transition_4001(
			State source) {
		SuperState container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof SuperState) {
				container = (SuperState) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<StatechartLinkDescriptor> result = new LinkedList<StatechartLinkDescriptor>();
		for (Iterator<?> links = container.getTransitions().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatechartVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			State dst = link.getEnd();
			State src = link.getStart();
			if (src != source) {
				continue;
			}
			result.add(new StatechartLinkDescriptor(src, dst, link,
					StatechartElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
