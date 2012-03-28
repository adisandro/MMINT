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

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.xt.graph.Graph;
import edu.toronto.cs.se.mmtf.xt.graph.GraphPackage;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.EdgeNameEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.GraphEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.NodeNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class GraphVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "edu.toronto.cs.se.mmtf.xt.graph.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (GraphEditPart.MODEL_ID.equals(view.getType())) {
				return GraphEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				GraphDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (GraphPackage.eINSTANCE.getGraph().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Graph) domainElement)) {
			return GraphEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry
				.getModelID(containerView);
		if (!GraphEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (GraphEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GraphEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case GraphEditPart.VISUAL_ID:
			if (GraphPackage.eINSTANCE.getNode().isSuperTypeOf(
					domainElement.eClass())) {
				return NodeEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry
				.getModelID(containerView);
		if (!GraphEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (GraphEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = GraphEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case GraphEditPart.VISUAL_ID:
			if (NodeEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case NodeEditPart.VISUAL_ID:
			if (NodeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EdgeEditPart.VISUAL_ID:
			if (EdgeNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (GraphPackage.eINSTANCE.getEdge().isSuperTypeOf(
				domainElement.eClass())) {
			return EdgeEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Graph element) {
		return true;
	}

}
