/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.powerwindow.PowerwindowPackage;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.ForceDetectingEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.InfraredEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.LockOutEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.PushPullEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.RockerEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.parts.WindowEditPart;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.part.PowerwindowDiagramEditorPlugin;

/**
 * @generated
 */
public class PowerwindowElementTypes {

	/**
	 * @generated
	 */
	private PowerwindowElementTypes() {
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
	public static final IElementType Window_1000 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.Window_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType PushPull_2001 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.PushPull_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Rocker_2002 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.Rocker_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Infrared_2003 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.Infrared_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LockOut_2004 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.LockOut_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ForceDetecting_2005 = getElementType("edu.toronto.cs.se.modelepedia.powerwindow.diagram.ForceDetecting_2005"); //$NON-NLS-1$

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
				return PowerwindowDiagramEditorPlugin.getInstance()
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

			elements.put(Window_1000, PowerwindowPackage.eINSTANCE.getWindow());

			elements.put(PushPull_2001,
					PowerwindowPackage.eINSTANCE.getPushPull());

			elements.put(Rocker_2002, PowerwindowPackage.eINSTANCE.getRocker());

			elements.put(Infrared_2003,
					PowerwindowPackage.eINSTANCE.getInfrared());

			elements.put(LockOut_2004,
					PowerwindowPackage.eINSTANCE.getLockOut());

			elements.put(ForceDetecting_2005,
					PowerwindowPackage.eINSTANCE.getForceDetecting());
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
			KNOWN_ELEMENT_TYPES.add(Window_1000);
			KNOWN_ELEMENT_TYPES.add(PushPull_2001);
			KNOWN_ELEMENT_TYPES.add(Rocker_2002);
			KNOWN_ELEMENT_TYPES.add(Infrared_2003);
			KNOWN_ELEMENT_TYPES.add(LockOut_2004);
			KNOWN_ELEMENT_TYPES.add(ForceDetecting_2005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case WindowEditPart.VISUAL_ID:
			return Window_1000;
		case PushPullEditPart.VISUAL_ID:
			return PushPull_2001;
		case RockerEditPart.VISUAL_ID:
			return Rocker_2002;
		case InfraredEditPart.VISUAL_ID:
			return Infrared_2003;
		case LockOutEditPart.VISUAL_ID:
			return LockOut_2004;
		case ForceDetectingEditPart.VISUAL_ID:
			return ForceDetecting_2005;
		}
		return null;
	}

}
