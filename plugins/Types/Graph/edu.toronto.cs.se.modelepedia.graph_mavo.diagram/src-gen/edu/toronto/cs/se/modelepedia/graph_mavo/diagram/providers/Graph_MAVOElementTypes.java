/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class Graph_MAVOElementTypes {

	/**
	* @generated
	*/
	private Graph_MAVOElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Graph_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.graph_mavo.diagram.Graph_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Node_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.graph_mavo.diagram.Node_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Edge_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.graph_mavo.diagram.Edge_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Graph_1000, edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE.getGraph());

			elements.put(Node_2001, edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE.getNode());

			elements.put(Edge_4001, edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage.eINSTANCE.getEdge());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Graph_1000);
			KNOWN_ELEMENT_TYPES.add(Node_2001);
			KNOWN_ELEMENT_TYPES.add(Edge_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.VISUAL_ID:
			return Graph_1000;
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.NodeEditPart.VISUAL_ID:
			return Node_2001;
		case edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.EdgeEditPart.VISUAL_ID:
			return Edge_4001;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers.Graph_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
