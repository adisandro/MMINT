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
package edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part;

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
public class IStar_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return getIStar_1000SemanticChildren(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			return getActorActorIntentionsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> getIStar_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.IStar modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.IStar) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getDependums().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention childElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getActors().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.istar_mavo.Actor childElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Actor) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> getActorActorIntentionsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.istar_mavo.Actor modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Actor) containerView
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getIntentions().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention childElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
			if (visualID == edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.IStarEditPart.VISUAL_ID:
			return getIStar_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return getTask_2002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return getResource_2003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2004ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2005ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return getTask_3002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return getResource_3003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return getGoal_3004ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return getContribution_4003ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return getTask_2002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return getResource_2003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2004IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2005IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return getTask_3002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return getResource_3003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return getGoal_3004IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return getContribution_4003IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.TaskEditPart.VISUAL_ID:
			return getTask_2002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ResourceEditPart.VISUAL_ID:
			return getResource_2003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.GoalEditPart.VISUAL_ID:
			return getGoal_2004OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ActorEditPart.VISUAL_ID:
			return getActor_2005OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Task2EditPart.VISUAL_ID:
			return getTask_3002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Resource2EditPart.VISUAL_ID:
			return getResource_3003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.Goal2EditPart.VISUAL_ID:
			return getGoal_3004OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID:
			return getContribution_4003OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIStar_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_2001ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_2002ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_2003ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_2004ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getActor_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_3001ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_3002ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_3003ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_3004ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getMeansEnd_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDecomposition_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContribution_4003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependerLink_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependeeLink_4005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_2002IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_2003IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_2004IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getActor_2005IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Actor modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Actor) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_3001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_3002IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_3003IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_3004IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getMeansEnd_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDecomposition_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContribution_4003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependerLink_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependeeLink_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_2002OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_2003OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_2004OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getActor_2005OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Actor modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Actor) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getSoftGoal_3001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getTask_3002OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Task modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Task) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getResource_3003OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Resource modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Resource) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getGoal_3004OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Goal modelElement = (edu.toronto.cs.se.modelepedia.istar_mavo.Goal) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_MeansEnd_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Decomposition_4002(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Contribution_4003(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DependeeLink_4005(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getMeansEnd_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDecomposition_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContribution_4003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependerLink_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getDependeeLink_4005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_MeansEnd_4001(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention container) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd link = (edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst, link,
							edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001,
							edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Decomposition_4002(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention container) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition link = (edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Contribution_4003(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention container) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Contribution link = (edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_DependerLink_4004(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention container) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependerLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getDependum();
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint src = link.getDepender();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_DependeeLink_4005(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention container) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependeeLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint dst = link.getDependee();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getDependum();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_MeansEnd_4001(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd link = (edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, target,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Decomposition_4002(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting
							.getEObject() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition link = (edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, target,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Contribution_4003(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Contribution link = (edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, target,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_DependerLink_4004(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependerLink_Dependum()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint src = link.getDepender();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, target,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_DependeeLink_4005(
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage.eINSTANCE
					.getDependeeLink_Dependee()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getDependum();
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, target,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_MeansEnd_4001(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention source) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention) {
				container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd link = (edu.toronto.cs.se.modelepedia.istar_mavo.MeansEnd) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(
					new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst, link,
							edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.MeansEnd_4001,
							edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Decomposition_4002(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention source) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention) {
				container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition link = (edu.toronto.cs.se.modelepedia.istar_mavo.Decomposition) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Decomposition_4002,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Contribution_4003(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention source) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention) {
				container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Contribution link = (edu.toronto.cs.se.modelepedia.istar_mavo.Contribution) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getTgt();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.Contribution_4003,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_DependerLink_4004(
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint source) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention) {
				container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependerLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependerLink) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention dst = link.getDependum();
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint src = link.getDepender();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependerLink_4004,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_DependeeLink_4005(
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention source) {
		edu.toronto.cs.se.modelepedia.istar_mavo.Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.istar_mavo.Intention) {
				container = (edu.toronto.cs.se.modelepedia.istar_mavo.Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getDependeeLinks().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink link = (edu.toronto.cs.se.modelepedia.istar_mavo.DependeeLink) linkObject;
			if (edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint dst = link.getDependee();
			edu.toronto.cs.se.modelepedia.istar_mavo.Intention src = link.getDependum();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor(src, dst,
					link,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.providers.IStar_MAVOElementTypes.DependeeLink_4005,
					edu.toronto.cs.se.modelepedia.istar_mavo.diagram.edit.parts.DependeeLinkEditPart.VISUAL_ID));
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

		public List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return IStar_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return IStar_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return IStar_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.istar_mavo.diagram.part.IStar_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return IStar_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
