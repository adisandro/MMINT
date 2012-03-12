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
package edu.toronto.cs.se.mmtf.mid.diagram.providers;

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
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDDiagramEditorPlugin;

/**
 * @generated
 */
public class MIDElementTypes {

	/**
	 * @generated
	 */
	private MIDElementTypes() {
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
	public static final IElementType MultiModel_1000 = getElementType("edu.toronto.cs.se.mmtf.mid.diagram.MultiModel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MappingReference_2001 = getElementType("edu.toronto.cs.se.mmtf.mid.diagram.MappingReference_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelReference_2002 = getElementType("edu.toronto.cs.se.mmtf.mid.diagram.ModelReference_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType MappingReferenceModels_4001 = getElementType("edu.toronto.cs.se.mmtf.mid.diagram.MappingReferenceModels_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BinaryMappingReference_4002 = getElementType("edu.toronto.cs.se.mmtf.mid.diagram.BinaryMappingReference_4002"); //$NON-NLS-1$

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
				return MIDDiagramEditorPlugin.getInstance()
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

			elements.put(MultiModel_1000, MidPackage.eINSTANCE.getMultiModel());

			elements.put(MappingReference_2001,
					MidPackage.eINSTANCE.getMappingReference());

			elements.put(ModelReference_2002,
					MidPackage.eINSTANCE.getModelReference());

			elements.put(MappingReferenceModels_4001,
					MidPackage.eINSTANCE.getMappingReference_Models());

			elements.put(BinaryMappingReference_4002,
					MidPackage.eINSTANCE.getBinaryMappingReference());
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
			KNOWN_ELEMENT_TYPES.add(MultiModel_1000);
			KNOWN_ELEMENT_TYPES.add(MappingReference_2001);
			KNOWN_ELEMENT_TYPES.add(ModelReference_2002);
			KNOWN_ELEMENT_TYPES.add(MappingReferenceModels_4001);
			KNOWN_ELEMENT_TYPES.add(BinaryMappingReference_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case MultiModelEditPart.VISUAL_ID:
			return MultiModel_1000;
		case MappingReferenceEditPart.VISUAL_ID:
			return MappingReference_2001;
		case ModelReferenceEditPart.VISUAL_ID:
			return ModelReference_2002;
		case MappingReferenceModelsEditPart.VISUAL_ID:
			return MappingReferenceModels_4001;
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return BinaryMappingReference_4002;
		}
		return null;
	}

}
