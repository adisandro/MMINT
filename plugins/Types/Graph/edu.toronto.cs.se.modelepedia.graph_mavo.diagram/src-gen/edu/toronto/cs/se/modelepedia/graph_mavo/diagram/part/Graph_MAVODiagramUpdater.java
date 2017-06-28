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
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

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
public class Graph_MAVODiagramUpdater {

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor> getSemanticChildren(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
			return getGraph_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor> getGraph_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph modelElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			edu.toronto.cs.se.modelepedia.graph_mavo.Node childElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Node) it
					.next();
			int visualID = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getNodeVisualID(view, childElement);
			if (visualID == edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID) {
				result.add(new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor(
						childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getContainedLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
			return getGraph_1000ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return getNode_2001ContainedLinks(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return getEdge_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getIncomingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return getNode_2001IncomingLinks(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return getEdge_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getOutgoingLinks(
			View view) {
		switch (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.getVisualID(view)) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return getNode_2001OutgoingLinks(view);
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return getEdge_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getGraph_1000ContainedLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph modelElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Edge_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getNode_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getEdge_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getNode_2001IncomingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.graph_mavo.Node modelElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Node) view
				.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_4001(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getEdge_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getNode_2001OutgoingLinks(
			View view) {
		edu.toronto.cs.se.modelepedia.graph_mavo.Node modelElement = (edu.toronto.cs.se.modelepedia.graph_mavo.Node) view
				.getElement();
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getEdge_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getContainedTypeModelFacetLinks_Edge_4001(
			edu.toronto.cs.se.modelepedia.graph_mavo.Graph container) {
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Edge) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Edge link = (edu.toronto.cs.se.modelepedia.graph_mavo.Edge) linkObject;
			if (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Node dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.graph_mavo.Node src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor(src, dst,
					link, edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Edge_4001,
					edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getIncomingTypeModelFacetLinks_Edge_4001(
			edu.toronto.cs.se.modelepedia.graph_mavo.Node target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE
					.getEdge_Target()
					|| false == setting.getEObject() instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Edge) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Edge link = (edu.toronto.cs.se.modelepedia.graph_mavo.Edge) setting
					.getEObject();
			if (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Node src = link.getSource();
			result.add(new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor(src, target,
					link, edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Edge_4001,
					edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	* @generated
	*/
	private static Collection<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getOutgoingTypeModelFacetLinks_Edge_4001(
			edu.toronto.cs.se.modelepedia.graph_mavo.Node source) {
		edu.toronto.cs.se.modelepedia.graph_mavo.Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Graph) {
				container = (edu.toronto.cs.se.modelepedia.graph_mavo.Graph) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> result = new LinkedList<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor>();
		for (Iterator<?> links = container.getEdges().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof edu.toronto.cs.se.modelepedia.graph_mavo.Edge) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Edge link = (edu.toronto.cs.se.modelepedia.graph_mavo.Edge) linkObject;
			if (edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID != edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			edu.toronto.cs.se.modelepedia.graph_mavo.Node dst = link.getTarget();
			edu.toronto.cs.se.modelepedia.graph_mavo.Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor(src, dst,
					link, edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes.Edge_4001,
					edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID));
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

		public List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVONodeDescriptor> getSemanticChildren(
				View view) {
			return Graph_MAVODiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getContainedLinks(
				View view) {
			return Graph_MAVODiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getIncomingLinks(
				View view) {
			return Graph_MAVODiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		@Override

		public List<edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOLinkDescriptor> getOutgoingLinks(
				View view) {
			return Graph_MAVODiagramUpdater.getOutgoingLinks(view);
		}
	};

}
