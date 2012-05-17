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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers;

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

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidDiagramEditorPlugin;

/**
 * @generated
 */
public class MidElementTypes {

	/**
	 * @generated
	 */
	private MidElementTypes() {
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
	public static final IElementType ModelRel_1000 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelRel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelReference_2001 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelReference_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Link_2002 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.Link_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelElementReference_3001 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementReference_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExtendibleElementSupertype_4001 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ExtendibleElementSupertype_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType LinkElementRefs_4002 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.LinkElementRefs_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BinaryLink_4003 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.BinaryLink_4003"); //$NON-NLS-1$

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
				return MidDiagramEditorPlugin.getInstance()
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

			elements.put(ModelRel_1000,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelReference_2001,
					RelationshipPackage.eINSTANCE.getModelReference());

			elements.put(Link_2002, RelationshipPackage.eINSTANCE.getLink());

			elements.put(ModelElementReference_3001,
					RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ExtendibleElementSupertype_4001,
					MidPackage.eINSTANCE.getExtendibleElement_Supertype());

			elements.put(LinkElementRefs_4002,
					RelationshipPackage.eINSTANCE.getLink_ElementRefs());

			elements.put(BinaryLink_4003,
					RelationshipPackage.eINSTANCE.getBinaryLink());
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
			KNOWN_ELEMENT_TYPES.add(ModelRel_1000);
			KNOWN_ELEMENT_TYPES.add(ModelReference_2001);
			KNOWN_ELEMENT_TYPES.add(Link_2002);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3001);
			KNOWN_ELEMENT_TYPES.add(ExtendibleElementSupertype_4001);
			KNOWN_ELEMENT_TYPES.add(LinkElementRefs_4002);
			KNOWN_ELEMENT_TYPES.add(BinaryLink_4003);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ModelRelEditPart.VISUAL_ID:
			return ModelRel_1000;
		case ModelReferenceEditPart.VISUAL_ID:
			return ModelReference_2001;
		case LinkEditPart.VISUAL_ID:
			return Link_2002;
		case ModelElementReferenceEditPart.VISUAL_ID:
			return ModelElementReference_3001;
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return ExtendibleElementSupertype_4001;
		case LinkElementRefsEditPart.VISUAL_ID:
			return LinkElementRefs_4002;
		case BinaryLinkEditPart.VISUAL_ID:
			return BinaryLink_4003;
		}
		return null;
	}

}
