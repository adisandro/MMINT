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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.BinaryLinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementReferenceSupertypeRefEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementEndpointReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReference3EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReference2EditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelEndpointReferenceEditPart;
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
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			MidDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

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
	public static final IElementType ModelEndpointReference_2007 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelEndpointReference_2007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LinkReference_2008 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.LinkReference_2008"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType LinkReference_2009 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.LinkReference_2009"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelEndpointReference_2010 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelEndpointReference_2010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelElementReference_3005 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementReference_3005"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelElementReference_3006 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementReference_3006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelElementReference_3007 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementReference_3007"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtendibleElementReferenceSupertypeRef_4010 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ExtendibleElementReferenceSupertypeRef_4010"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelElementEndpointReference_4011 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementEndpointReference_4011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BinaryLinkReference_4012 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.BinaryLinkReference_4012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BinaryLinkReference_4013 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.BinaryLinkReference_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelElementEndpointReference_4014 = getElementType("edu.toronto.cs.se.mmtf.relationship.diagram.ModelElementEndpointReference_4014"); //$NON-NLS-1$

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

			elements.put(ModelRel_1000,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelEndpointReference_2007,
					RelationshipPackage.eINSTANCE.getModelEndpointReference());

			elements.put(LinkReference_2008,
					RelationshipPackage.eINSTANCE.getLinkReference());

			elements.put(LinkReference_2009,
					RelationshipPackage.eINSTANCE.getLinkReference());

			elements.put(ModelEndpointReference_2010,
					RelationshipPackage.eINSTANCE.getModelEndpointReference());

			elements.put(ModelElementReference_3005,
					RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ModelElementReference_3006,
					RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ModelElementReference_3007,
					RelationshipPackage.eINSTANCE.getModelElementReference());

			elements.put(ExtendibleElementReferenceSupertypeRef_4010,
					RelationshipPackage.eINSTANCE
							.getExtendibleElementReference_SupertypeRef());

			elements.put(ModelElementEndpointReference_4011,
					RelationshipPackage.eINSTANCE
							.getModelElementEndpointReference());

			elements.put(BinaryLinkReference_4012,
					RelationshipPackage.eINSTANCE.getBinaryLinkReference());

			elements.put(BinaryLinkReference_4013,
					RelationshipPackage.eINSTANCE.getBinaryLinkReference());

			elements.put(ModelElementEndpointReference_4014,
					RelationshipPackage.eINSTANCE
							.getModelElementEndpointReference());
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
			KNOWN_ELEMENT_TYPES.add(ModelEndpointReference_2007);
			KNOWN_ELEMENT_TYPES.add(LinkReference_2008);
			KNOWN_ELEMENT_TYPES.add(LinkReference_2009);
			KNOWN_ELEMENT_TYPES.add(ModelEndpointReference_2010);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3005);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3006);
			KNOWN_ELEMENT_TYPES.add(ModelElementReference_3007);
			KNOWN_ELEMENT_TYPES
					.add(ExtendibleElementReferenceSupertypeRef_4010);
			KNOWN_ELEMENT_TYPES.add(ModelElementEndpointReference_4011);
			KNOWN_ELEMENT_TYPES.add(BinaryLinkReference_4012);
			KNOWN_ELEMENT_TYPES.add(BinaryLinkReference_4013);
			KNOWN_ELEMENT_TYPES.add(ModelElementEndpointReference_4014);
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
			return ModelEndpointReference_2007;
		case LinkReferenceEditPart.VISUAL_ID:
			return LinkReference_2008;
		case LinkReference2EditPart.VISUAL_ID:
			return LinkReference_2009;
		case ModelEndpointReference2EditPart.VISUAL_ID:
			return ModelEndpointReference_2010;
		case ModelElementReferenceEditPart.VISUAL_ID:
			return ModelElementReference_3005;
		case ModelElementReference2EditPart.VISUAL_ID:
			return ModelElementReference_3006;
		case ModelElementReference3EditPart.VISUAL_ID:
			return ModelElementReference_3007;
		case ExtendibleElementReferenceSupertypeRefEditPart.VISUAL_ID:
			return ExtendibleElementReferenceSupertypeRef_4010;
		case ModelElementEndpointReferenceEditPart.VISUAL_ID:
			return ModelElementEndpointReference_4011;
		case BinaryLinkReferenceEditPart.VISUAL_ID:
			return BinaryLinkReference_4012;
		case BinaryLinkReference2EditPart.VISUAL_ID:
			return BinaryLinkReference_4013;
		case ModelElementEndpointReference2EditPart.VISUAL_ID:
			return ModelElementEndpointReference_4014;
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
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
