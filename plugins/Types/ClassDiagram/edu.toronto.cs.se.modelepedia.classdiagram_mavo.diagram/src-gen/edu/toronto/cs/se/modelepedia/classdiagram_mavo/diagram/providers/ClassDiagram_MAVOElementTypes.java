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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers;

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
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType ClassDiagram_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.ClassDiagram_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Class_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Class_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Attribute_3001 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Attribute_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Operation_3002 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Operation_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Association_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Association_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType NestedInReference_4002 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.NestedInReference_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType SuperclassReference_4003 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.SuperclassReference_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Dependency_4004 = getElementType(
			"edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.Dependency_4004"); //$NON-NLS-1$

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

			elements.put(ClassDiagram_1000,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getClassDiagram());

			elements.put(Class_2001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getClass_());

			elements.put(Attribute_3001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getAttribute());

			elements.put(Operation_3002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getOperation());

			elements.put(Association_4001,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getAssociation());

			elements.put(NestedInReference_4002,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getNestedInReference());

			elements.put(SuperclassReference_4003,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE
							.getSuperclassReference());

			elements.put(Dependency_4004,
					edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage.eINSTANCE.getDependency());
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

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.providers.ClassDiagram_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
