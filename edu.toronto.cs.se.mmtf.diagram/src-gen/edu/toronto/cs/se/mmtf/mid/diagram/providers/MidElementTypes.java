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
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Parameter2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ParameterEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

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
	public static final IElementType MultiModel_1000 = getElementType("edu.toronto.cs.se.mmtf.diagram.MultiModel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Model_2001 = getElementType("edu.toronto.cs.se.mmtf.diagram.Model_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Model_2002 = getElementType("edu.toronto.cs.se.mmtf.diagram.Model_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2003 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelRel_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2004 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelRel_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Operator_2005 = getElementType("edu.toronto.cs.se.mmtf.diagram.Operator_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExtendibleElementSupertype_4001 = getElementType("edu.toronto.cs.se.mmtf.diagram.ExtendibleElementSupertype_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelRelModels_4002 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelRelModels_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BinaryModelRel_4003 = getElementType("edu.toronto.cs.se.mmtf.diagram.BinaryModelRel_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Parameter_4006 = getElementType("edu.toronto.cs.se.mmtf.diagram.Parameter_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_4007 = getElementType("edu.toronto.cs.se.mmtf.diagram.Parameter_4007"); //$NON-NLS-1$

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

			elements.put(MultiModel_1000, MidPackage.eINSTANCE.getMultiModel());

			elements.put(Model_2001, MidPackage.eINSTANCE.getModel());

			elements.put(Model_2002, MidPackage.eINSTANCE.getModel());

			elements.put(ModelRel_2003,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelRel_2004,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(Operator_2005, OperatorPackage.eINSTANCE.getOperator());

			elements.put(ExtendibleElementSupertype_4001,
					MidPackage.eINSTANCE.getExtendibleElement_Supertype());

			elements.put(ModelRelModels_4002,
					RelationshipPackage.eINSTANCE.getModelRel_Models());

			elements.put(BinaryModelRel_4003,
					RelationshipPackage.eINSTANCE.getBinaryModelRel());

			elements.put(Parameter_4006,
					OperatorPackage.eINSTANCE.getParameter());

			elements.put(Parameter_4007,
					OperatorPackage.eINSTANCE.getParameter());
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
			KNOWN_ELEMENT_TYPES.add(Model_2001);
			KNOWN_ELEMENT_TYPES.add(Model_2002);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2003);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2004);
			KNOWN_ELEMENT_TYPES.add(Operator_2005);
			KNOWN_ELEMENT_TYPES.add(ExtendibleElementSupertype_4001);
			KNOWN_ELEMENT_TYPES.add(ModelRelModels_4002);
			KNOWN_ELEMENT_TYPES.add(BinaryModelRel_4003);
			KNOWN_ELEMENT_TYPES.add(Parameter_4006);
			KNOWN_ELEMENT_TYPES.add(Parameter_4007);
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
		case ModelEditPart.VISUAL_ID:
			return Model_2001;
		case Model2EditPart.VISUAL_ID:
			return Model_2002;
		case ModelRelEditPart.VISUAL_ID:
			return ModelRel_2003;
		case ModelRel2EditPart.VISUAL_ID:
			return ModelRel_2004;
		case OperatorEditPart.VISUAL_ID:
			return Operator_2005;
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return ExtendibleElementSupertype_4001;
		case ModelRelModelsEditPart.VISUAL_ID:
			return ModelRelModels_4002;
		case BinaryModelRelEditPart.VISUAL_ID:
			return BinaryModelRel_4003;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_4006;
		case Parameter2EditPart.VISUAL_ID:
			return Parameter_4007;
		}
		return null;
	}

}
