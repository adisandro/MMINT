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
package edu.toronto.cs.se.mmtf.xt.statechart.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.mmtf.xt.statechart.StatechartPackage;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.State2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState2EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperState3EditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.SuperStateEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartDiagramEditorPlugin;

/**
 * @generated
 */
public class StatechartElementTypes {

	/**
	 * @generated
	 */
	private StatechartElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType SuperState_1000 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.SuperState_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SuperState_2001 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.SuperState_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_2002 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.State_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_3001 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.State_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType SuperState_3002 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.SuperState_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("edu.toronto.cs.se.mmtf.xt.statechart.diagram.Transition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return StatechartDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
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

			elements.put(SuperState_1000,
					StatechartPackage.eINSTANCE.getSuperState());

			elements.put(SuperState_2001,
					StatechartPackage.eINSTANCE.getSuperState());

			elements.put(State_2002, StatechartPackage.eINSTANCE.getState());

			elements.put(State_3001, StatechartPackage.eINSTANCE.getState());

			elements.put(SuperState_3002,
					StatechartPackage.eINSTANCE.getSuperState());

			elements.put(Transition_4001,
					StatechartPackage.eINSTANCE.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(SuperState_1000);
			KNOWN_ELEMENT_TYPES.add(SuperState_2001);
			KNOWN_ELEMENT_TYPES.add(State_2002);
			KNOWN_ELEMENT_TYPES.add(State_3001);
			KNOWN_ELEMENT_TYPES.add(SuperState_3002);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case SuperStateEditPart.VISUAL_ID:
			return SuperState_1000;
		case SuperState2EditPart.VISUAL_ID:
			return SuperState_2001;
		case StateEditPart.VISUAL_ID:
			return State_2002;
		case State2EditPart.VISUAL_ID:
			return State_3001;
		case SuperState3EditPart.VISUAL_ID:
			return SuperState_3002;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		}
		return null;
	}

}
