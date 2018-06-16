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
package edu.toronto.cs.se.modelepedia.istar.diagram.part;

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

import edu.toronto.cs.se.modelepedia.istar.Actor;
import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.Decomposition;
import edu.toronto.cs.se.modelepedia.istar.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar.DependerLink;
import edu.toronto.cs.se.modelepedia.istar.Goal;
import edu.toronto.cs.se.modelepedia.istar.IStar;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.Intention;
import edu.toronto.cs.se.modelepedia.istar.MeansEnd;
import edu.toronto.cs.se.modelepedia.istar.Resource;
import edu.toronto.cs.se.modelepedia.istar.SoftGoal;
import edu.toronto.cs.se.modelepedia.istar.Task;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorActorIntentionsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ActorEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ContributionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DecompositionEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependeeLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.DependerLinkEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Goal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.GoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.IStarEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.MeansEndEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Resource2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoal2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.SoftGoalEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.Task2EditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.TaskEditPart;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;

/**
 * @generated
 */
public class IStarDiagramUpdater {

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
	public static List<IStarNodeDescriptor> getSemanticChildren(View view) {
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case IStarEditPart.VISUAL_ID:
			return getIStar_1000SemanticChildren(view);
		case ActorActorIntentionsCompartmentEditPart.VISUAL_ID:
			return getActorActorIntentionsCompartment_7001SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarNodeDescriptor> getIStar_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		IStar modelElement = (IStar) view.getElement();
		LinkedList<IStarNodeDescriptor> result = new LinkedList<IStarNodeDescriptor>();
		for (Iterator<?> it = modelElement.getDependums().iterator(); it
				.hasNext();) {
			Intention childElement = (Intention) it.next();
			int visualID = IStarVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SoftGoalEditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TaskEditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ResourceEditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GoalEditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getActors().iterator(); it.hasNext();) {
			Actor childElement = (Actor) it.next();
			int visualID = IStarVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ActorEditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarNodeDescriptor> getActorActorIntentionsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Actor modelElement = (Actor) containerView.getElement();
		LinkedList<IStarNodeDescriptor> result = new LinkedList<IStarNodeDescriptor>();
		for (Iterator<?> it = modelElement.getIntentions().iterator(); it
				.hasNext();) {
			Intention childElement = (Intention) it.next();
			int visualID = IStarVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == SoftGoal2EditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Task2EditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Resource2EditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Goal2EditPart.VISUAL_ID) {
				result.add(new IStarNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getContainedLinks(View view) {
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case IStarEditPart.VISUAL_ID:
			return getIStar_1000ContainedLinks(view);
		case SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001ContainedLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_2002ContainedLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2003ContainedLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2004ContainedLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2005ContainedLinks(view);
		case SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001ContainedLinks(view);
		case Task2EditPart.VISUAL_ID:
			return getTask_3002ContainedLinks(view);
		case Resource2EditPart.VISUAL_ID:
			return getResource_3003ContainedLinks(view);
		case Goal2EditPart.VISUAL_ID:
			return getGoal_3004ContainedLinks(view);
		case MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001ContainedLinks(view);
		case DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002ContainedLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003ContainedLinks(view);
		case DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004ContainedLinks(view);
		case DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getIncomingLinks(View view) {
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001IncomingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_2002IncomingLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2003IncomingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2004IncomingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2005IncomingLinks(view);
		case SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001IncomingLinks(view);
		case Task2EditPart.VISUAL_ID:
			return getTask_3002IncomingLinks(view);
		case Resource2EditPart.VISUAL_ID:
			return getResource_3003IncomingLinks(view);
		case Goal2EditPart.VISUAL_ID:
			return getGoal_3004IncomingLinks(view);
		case MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001IncomingLinks(view);
		case DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002IncomingLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003IncomingLinks(view);
		case DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004IncomingLinks(view);
		case DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getOutgoingLinks(View view) {
		switch (IStarVisualIDRegistry.getVisualID(view)) {
		case SoftGoalEditPart.VISUAL_ID:
			return getSoftGoal_2001OutgoingLinks(view);
		case TaskEditPart.VISUAL_ID:
			return getTask_2002OutgoingLinks(view);
		case ResourceEditPart.VISUAL_ID:
			return getResource_2003OutgoingLinks(view);
		case GoalEditPart.VISUAL_ID:
			return getGoal_2004OutgoingLinks(view);
		case ActorEditPart.VISUAL_ID:
			return getActor_2005OutgoingLinks(view);
		case SoftGoal2EditPart.VISUAL_ID:
			return getSoftGoal_3001OutgoingLinks(view);
		case Task2EditPart.VISUAL_ID:
			return getTask_3002OutgoingLinks(view);
		case Resource2EditPart.VISUAL_ID:
			return getResource_3003OutgoingLinks(view);
		case Goal2EditPart.VISUAL_ID:
			return getGoal_3004OutgoingLinks(view);
		case MeansEndEditPart.VISUAL_ID:
			return getMeansEnd_4001OutgoingLinks(view);
		case DecompositionEditPart.VISUAL_ID:
			return getDecomposition_4002OutgoingLinks(view);
		case ContributionEditPart.VISUAL_ID:
			return getContribution_4003OutgoingLinks(view);
		case DependerLinkEditPart.VISUAL_ID:
			return getDependerLink_4004OutgoingLinks(view);
		case DependeeLinkEditPart.VISUAL_ID:
			return getDependeeLink_4005OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getIStar_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_2001ContainedLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getTask_2002ContainedLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getResource_2003ContainedLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getGoal_2004ContainedLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getActor_2005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_3001ContainedLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getTask_3002ContainedLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getResource_3003ContainedLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getGoal_3004ContainedLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getMeansEnd_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDecomposition_4002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getContribution_4003ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependerLink_4004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependeeLink_4005ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_2001IncomingLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getTask_2002IncomingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getResource_2003IncomingLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getGoal_2004IncomingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getActor_2005IncomingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_3001IncomingLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getTask_3002IncomingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getResource_3003IncomingLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getGoal_3004IncomingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_MeansEnd_4001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Decomposition_4002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Contribution_4003(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependerLink_4004(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DependeeLink_4005(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getMeansEnd_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDecomposition_4002IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getContribution_4003IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependerLink_4004IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependeeLink_4005IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_2001OutgoingLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getTask_2002OutgoingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getResource_2003OutgoingLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getGoal_2004OutgoingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getActor_2005OutgoingLinks(View view) {
		Actor modelElement = (Actor) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_DependerLink_4004(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getSoftGoal_3001OutgoingLinks(
			View view) {
		SoftGoal modelElement = (SoftGoal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getTask_3002OutgoingLinks(View view) {
		Task modelElement = (Task) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getResource_3003OutgoingLinks(
			View view) {
		Resource modelElement = (Resource) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getGoal_3004OutgoingLinks(View view) {
		Goal modelElement = (Goal) view.getElement();
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
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
	public static List<IStarLinkDescriptor> getMeansEnd_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDecomposition_4002OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getContribution_4003OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependerLink_4004OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<IStarLinkDescriptor> getDependeeLink_4005OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getContainedTypeModelFacetLinks_MeansEnd_4001(
			Intention container) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MeansEnd) {
				continue;
			}
			MeansEnd link = (MeansEnd) linkObject;
			if (MeansEndEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.MeansEnd_4001, MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getContainedTypeModelFacetLinks_Decomposition_4002(
			Intention container) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Decomposition) {
				continue;
			}
			Decomposition link = (Decomposition) linkObject;
			if (DecompositionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.Decomposition_4002,
					DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getContainedTypeModelFacetLinks_Contribution_4003(
			Intention container) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) linkObject;
			if (ContributionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.Contribution_4003,
					ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getContainedTypeModelFacetLinks_DependerLink_4004(
			Intention container) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getDependerLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DependerLink) {
				continue;
			}
			DependerLink link = (DependerLink) linkObject;
			if (DependerLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getDependum();
			DependencyEndpoint src = link.getDepender();
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.DependerLink_4004,
					DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getContainedTypeModelFacetLinks_DependeeLink_4005(
			Intention container) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getDependeeLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DependeeLink) {
				continue;
			}
			DependeeLink link = (DependeeLink) linkObject;
			if (DependeeLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			DependencyEndpoint dst = link.getDependee();
			Intention src = link.getDependum();
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.DependeeLink_4005,
					DependeeLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getIncomingTypeModelFacetLinks_MeansEnd_4001(
			Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != IStarPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting.getEObject() instanceof MeansEnd) {
				continue;
			}
			MeansEnd link = (MeansEnd) setting.getEObject();
			if (MeansEndEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, target, link,
					IStarElementTypes.MeansEnd_4001, MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getIncomingTypeModelFacetLinks_Decomposition_4002(
			Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != IStarPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting.getEObject() instanceof Decomposition) {
				continue;
			}
			Decomposition link = (Decomposition) setting.getEObject();
			if (DecompositionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, target, link,
					IStarElementTypes.Decomposition_4002,
					DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getIncomingTypeModelFacetLinks_Contribution_4003(
			Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != IStarPackage.eINSTANCE
					.getIntentionLink_Tgt()
					|| false == setting.getEObject() instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) setting.getEObject();
			if (ContributionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention src = link.getSrc();
			result.add(new IStarLinkDescriptor(src, target, link,
					IStarElementTypes.Contribution_4003,
					ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getIncomingTypeModelFacetLinks_DependerLink_4004(
			Intention target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != IStarPackage.eINSTANCE
					.getDependerLink_Dependum()
					|| false == setting.getEObject() instanceof DependerLink) {
				continue;
			}
			DependerLink link = (DependerLink) setting.getEObject();
			if (DependerLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			DependencyEndpoint src = link.getDepender();
			result.add(new IStarLinkDescriptor(src, target, link,
					IStarElementTypes.DependerLink_4004,
					DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getIncomingTypeModelFacetLinks_DependeeLink_4005(
			DependencyEndpoint target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != IStarPackage.eINSTANCE
					.getDependeeLink_Dependee()
					|| false == setting.getEObject() instanceof DependeeLink) {
				continue;
			}
			DependeeLink link = (DependeeLink) setting.getEObject();
			if (DependeeLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention src = link.getDependum();
			result.add(new IStarLinkDescriptor(src, target, link,
					IStarElementTypes.DependeeLink_4005,
					DependeeLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getOutgoingTypeModelFacetLinks_MeansEnd_4001(
			Intention source) {
		Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Intention) {
				container = (Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof MeansEnd) {
				continue;
			}
			MeansEnd link = (MeansEnd) linkObject;
			if (MeansEndEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.MeansEnd_4001, MeansEndEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getOutgoingTypeModelFacetLinks_Decomposition_4002(
			Intention source) {
		Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Intention) {
				container = (Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Decomposition) {
				continue;
			}
			Decomposition link = (Decomposition) linkObject;
			if (DecompositionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.Decomposition_4002,
					DecompositionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getOutgoingTypeModelFacetLinks_Contribution_4003(
			Intention source) {
		Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Intention) {
				container = (Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getLinksAsSrc().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Contribution) {
				continue;
			}
			Contribution link = (Contribution) linkObject;
			if (ContributionEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getTgt();
			Intention src = link.getSrc();
			if (src != source) {
				continue;
			}
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.Contribution_4003,
					ContributionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getOutgoingTypeModelFacetLinks_DependerLink_4004(
			DependencyEndpoint source) {
		Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Intention) {
				container = (Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getDependerLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DependerLink) {
				continue;
			}
			DependerLink link = (DependerLink) linkObject;
			if (DependerLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Intention dst = link.getDependum();
			DependencyEndpoint src = link.getDepender();
			if (src != source) {
				continue;
			}
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.DependerLink_4004,
					DependerLinkEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<IStarLinkDescriptor> getOutgoingTypeModelFacetLinks_DependeeLink_4005(
			Intention source) {
		Intention container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Intention) {
				container = (Intention) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<IStarLinkDescriptor> result = new LinkedList<IStarLinkDescriptor>();
		for (Iterator<?> links = container.getDependeeLinks().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DependeeLink) {
				continue;
			}
			DependeeLink link = (DependeeLink) linkObject;
			if (DependeeLinkEditPart.VISUAL_ID != IStarVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			DependencyEndpoint dst = link.getDependee();
			Intention src = link.getDependum();
			if (src != source) {
				continue;
			}
			result.add(new IStarLinkDescriptor(src, dst, link,
					IStarElementTypes.DependeeLink_4005,
					DependeeLinkEditPart.VISUAL_ID));
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
		public List<IStarNodeDescriptor> getSemanticChildren(View view) {
			return IStarDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<IStarLinkDescriptor> getContainedLinks(View view) {
			return IStarDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<IStarLinkDescriptor> getIncomingLinks(View view) {
			return IStarDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<IStarLinkDescriptor> getOutgoingLinks(View view) {
			return IStarDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
