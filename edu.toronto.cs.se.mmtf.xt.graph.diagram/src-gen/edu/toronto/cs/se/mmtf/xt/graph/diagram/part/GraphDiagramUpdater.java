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
package edu.toronto.cs.se.mmtf.xt.graph.diagram.part;

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

import edu.toronto.cs.se.mmtf.xt.graph.Edge;
import edu.toronto.cs.se.mmtf.xt.graph.Graph;
import edu.toronto.cs.se.mmtf.xt.graph.GraphPackage;
import edu.toronto.cs.se.mmtf.xt.graph.Node;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.GraphEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.providers.GraphElementTypes;

/**
 * @generated
 */
public class GraphDiagramUpdater {

	/**
	 * @generated
	 */
	public static List<GraphNodeDescriptor> getSemanticChildren(View view) {
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case GraphEditPart.VISUAL_ID:
			return getGraph_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphNodeDescriptor> getGraph_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Graph modelElement = (Graph) view.getElement();
		LinkedList<GraphNodeDescriptor> result = new LinkedList<GraphNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNodes().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = GraphVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == NodeEditPart.VISUAL_ID) {
				result.add(new GraphNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getContainedLinks(View view) {
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case GraphEditPart.VISUAL_ID:
			return getGraph_1000ContainedLinks(view);
		case NodeEditPart.VISUAL_ID:
			return getNode_2001ContainedLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_4001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getIncomingLinks(View view) {
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case NodeEditPart.VISUAL_ID:
			return getNode_2001IncomingLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_4001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getOutgoingLinks(View view) {
		switch (GraphVisualIDRegistry.getVisualID(view)) {
		case NodeEditPart.VISUAL_ID:
			return getNode_2001OutgoingLinks(view);
		case EdgeEditPart.VISUAL_ID:
			return getEdge_4001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getGraph_1000ContainedLinks(
			View view) {
		Graph modelElement = (Graph) view.getElement();
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Edge_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getNode_2001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getEdge_4001ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getNode_2001IncomingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Edge_4001(modelElement,
				crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getEdge_4001IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getNode_2001OutgoingLinks(View view) {
		Node modelElement = (Node) view.getElement();
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Edge_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<GraphLinkDescriptor> getEdge_4001OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<GraphLinkDescriptor> getContainedTypeModelFacetLinks_Edge_4001(
			Graph container) {
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		for (Iterator<?> links = container.getEdges().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeEditPart.VISUAL_ID != GraphVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getEnd();
			Node src = link.getStart();
			result.add(new GraphLinkDescriptor(src, dst, link,
					GraphElementTypes.Edge_4001, EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<GraphLinkDescriptor> getIncomingTypeModelFacetLinks_Edge_4001(
			Node target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != GraphPackage.eINSTANCE
					.getEdge_End()
					|| false == setting.getEObject() instanceof Edge) {
				continue;
			}
			Edge link = (Edge) setting.getEObject();
			if (EdgeEditPart.VISUAL_ID != GraphVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getStart();
			result.add(new GraphLinkDescriptor(src, target, link,
					GraphElementTypes.Edge_4001, EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<GraphLinkDescriptor> getOutgoingTypeModelFacetLinks_Edge_4001(
			Node source) {
		Graph container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Graph) {
				container = (Graph) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<GraphLinkDescriptor> result = new LinkedList<GraphLinkDescriptor>();
		for (Iterator<?> links = container.getEdges().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Edge) {
				continue;
			}
			Edge link = (Edge) linkObject;
			if (EdgeEditPart.VISUAL_ID != GraphVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getEnd();
			Node src = link.getStart();
			if (src != source) {
				continue;
			}
			result.add(new GraphLinkDescriptor(src, dst, link,
					GraphElementTypes.Edge_4001, EdgeEditPart.VISUAL_ID));
		}
		return result;
	}

}
