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
package edu.toronto.cs.se.modelepedia.tutorial.state.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.tutorial.state.StatePackage;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.CityEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.RegionEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.part.StateDiagramEditorPlugin;

/**
 * @generated
 */
public class StateElementTypes {

	/**
	 * @generated
	 */
	private StateElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			StateDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType State_1000 = getElementType("edu.toronto.cs.se.modelepedia.tutorial.state.diagram.State_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Region_2001 = getElementType("edu.toronto.cs.se.modelepedia.tutorial.state.diagram.Region_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType City_3001 = getElementType("edu.toronto.cs.se.modelepedia.tutorial.state.diagram.City_3001"); //$NON-NLS-1$

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

			elements.put(State_1000, StatePackage.eINSTANCE.getState());

			elements.put(Region_2001, StatePackage.eINSTANCE.getRegion());

			elements.put(City_3001, StatePackage.eINSTANCE.getCity());
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
			KNOWN_ELEMENT_TYPES.add(State_1000);
			KNOWN_ELEMENT_TYPES.add(Region_2001);
			KNOWN_ELEMENT_TYPES.add(City_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case StateEditPart.VISUAL_ID:
			return State_1000;
		case RegionEditPart.VISUAL_ID:
			return Region_2001;
		case CityEditPart.VISUAL_ID:
			return City_3001;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(
			elementTypeImages) {

		/**
		 * @generated
		 */
		@Override
		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.tutorial.state.diagram.providers.StateElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.tutorial.state.diagram.providers.StateElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.tutorial.state.diagram.providers.StateElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
