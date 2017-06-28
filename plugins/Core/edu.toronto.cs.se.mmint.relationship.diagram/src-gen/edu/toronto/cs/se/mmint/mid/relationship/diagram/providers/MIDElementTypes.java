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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.providers;

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

import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDDiagramEditorPlugin;

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
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			MIDDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType ModelRel_1000 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelRel_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelEndpointReference_2001 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelEndpointReference_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType MappingReference_2002 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.MappingReference_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType MappingReference_2003 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.MappingReference_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelEndpointReference_2004 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelEndpointReference_2004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelElementReference_3001 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelElementReference_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelElementReference_3002 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelElementReference_3002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelElementReference_3003 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelElementReference_3003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ExtendibleElementReferenceSupertypeRef_4001 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ExtendibleElementReferenceSupertypeRef_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelElementEndpointReference_4002 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelElementEndpointReference_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType BinaryMappingReference_4003 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.BinaryMappingReference_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType BinaryMappingReference_4004 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.BinaryMappingReference_4004"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ModelElementEndpointReference_4005 = getElementType(
			"edu.toronto.cs.se.mmint.relationship.diagram.ModelElementEndpointReference_4005"); //$NON-NLS-1$

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

			elements.put(ModelRel_1000, RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelEndpointReference_2001, RelationshipPackage.eINSTANCE.getModelEndpointReference());

			elements.put(MappingReference_2002, RelationshipPackage.eINSTANCE.getMappingReference());

			elements.put(MappingReference_2003, RelationshipPackage.eINSTANCE.getMappingReference());

			elements.put(ModelEndpointReference_2004, RelationshipPackage.eINSTANCE.getModelEndpointReference());

			elements.put(ModelElementReference_3001, RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ModelElementReference_3002, RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ModelElementReference_3003, RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ExtendibleElementReferenceSupertypeRef_4001,
					RelationshipPackage.eINSTANCE.getExtendibleElementReference_SupertypeRef());

			elements.put(ModelElementEndpointReference_4002,
					RelationshipPackage.eINSTANCE.getModelElementEndpointReference());

			elements.put(BinaryMappingReference_4003, RelationshipPackage.eINSTANCE.getBinaryMappingReference());

			elements.put(BinaryMappingReference_4004, RelationshipPackage.eINSTANCE.getBinaryMappingReference());

			elements.put(ModelElementEndpointReference_4005,
					RelationshipPackage.eINSTANCE.getModelElementEndpointReference());
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
			KNOWN_ELEMENT_TYPES.add(ModelEndpointReference_2001);
			KNOWN_ELEMENT_TYPES.add(MappingReference_2002);
			KNOWN_ELEMENT_TYPES.add(MappingReference_2003);
			KNOWN_ELEMENT_TYPES.add(ModelEndpointReference_2004);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3001);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3002);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3003);
			KNOWN_ELEMENT_TYPES.add(ExtendibleElementReferenceSupertypeRef_4001);
			KNOWN_ELEMENT_TYPES.add(ModelElementEndpointReference_4002);
			KNOWN_ELEMENT_TYPES.add(BinaryMappingReference_4003);
			KNOWN_ELEMENT_TYPES.add(BinaryMappingReference_4004);
			KNOWN_ELEMENT_TYPES.add(ModelElementEndpointReference_4005);
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
		case ModelEndpointReferenceEditPart.VISUAL_ID:
			return ModelEndpointReference_2001;
		case MappingReferenceEditPart.VISUAL_ID:
			return MappingReference_2002;
		case MappingReference2EditPart.VISUAL_ID:
			return MappingReference_2003;
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return ModelEndpointReference_2004;
		case ModelElementReferenceEditPart.VISUAL_ID:
			return ModelElementReference_3001;
		case ModelElementReference2EditPart.VISUAL_ID:
			return ModelElementReference_3002;
		case ModelElementReference3EditPart.VISUAL_ID:
			return ModelElementReference_3003;
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return ExtendibleElementReferenceSupertypeRef_4001;
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return ModelElementEndpointReference_4002;
		case BinaryMappingReferenceEditPart.VISUAL_ID:
			return BinaryMappingReference_4003;
		case BinaryMappingReference2EditPart.VISUAL_ID:
			return BinaryMappingReference_4004;
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return ModelElementEndpointReference_4005;
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
			return edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
