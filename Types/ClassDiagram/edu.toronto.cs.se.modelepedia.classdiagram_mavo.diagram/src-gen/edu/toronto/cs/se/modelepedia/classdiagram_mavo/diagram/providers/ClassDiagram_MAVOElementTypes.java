/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers;

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

/**
 * @generated
 */
public class ClassDiagram_MAVOElementTypes {

	/**
	 * @generated
	 */
	private ClassDiagram_MAVOElementTypes() {
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
	public static final IElementType ClassDiagram_1000 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.ClassDiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2001 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Class_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Attribute_3001 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Attribute_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Operation_3002 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Operation_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4001 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Association_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType NestedInReference_4002 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.NestedInReference_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType SuperclassReference_4003 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.SuperclassReference_4003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Dependency_4004 = getElementType("edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Dependency_4004"); //$NON-NLS-1$

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
				return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
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

			elements.put(
					ClassDiagram_1000,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getClassDiagram());

			elements.put(
					Class_2001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getClass_());

			elements.put(
					Attribute_3001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getAttribute());

			elements.put(
					Operation_3002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getOperation());

			elements.put(
					Association_4001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getAssociation());

			elements.put(
					NestedInReference_4002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getNestedInReference());

			elements.put(
					SuperclassReference_4003,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getSuperclassReference());

			elements.put(
					Dependency_4004,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getDependency());
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
			KNOWN_ELEMENT_TYPES.add(ClassDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Class_2001);
			KNOWN_ELEMENT_TYPES.add(Attribute_3001);
			KNOWN_ELEMENT_TYPES.add(Operation_3002);
			KNOWN_ELEMENT_TYPES.add(Association_4001);
			KNOWN_ELEMENT_TYPES.add(NestedInReference_4002);
			KNOWN_ELEMENT_TYPES.add(SuperclassReference_4003);
			KNOWN_ELEMENT_TYPES.add(Dependency_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassDiagramEditPart.VISUAL_ID:
			return ClassDiagram_1000;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return Class_2001;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AttributeEditPart.VISUAL_ID:
			return Attribute_3001;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return Operation_3002;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.AssociationEditPart.VISUAL_ID:
			return Association_4001;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.NestedInReferenceEditPart.VISUAL_ID:
			return NestedInReference_4002;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.SuperclassReferenceEditPart.VISUAL_ID:
			return SuperclassReference_4003;
		case edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.edit.parts.DependencyEditPart.VISUAL_ID:
			return Dependency_4004;
		}
		return null;
	}

}
