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
package edu.toronto.cs.se.mmint.mid.diagram.providers;

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

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpoint3EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.OperatorEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

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
	public static final IElementType MID_1000 = getElementType("edu.toronto.cs.se.mmint.diagram.MID_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Model_2001 = getElementType("edu.toronto.cs.se.mmint.diagram.Model_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Model_2002 = getElementType("edu.toronto.cs.se.mmint.diagram.Model_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2003 = getElementType("edu.toronto.cs.se.mmint.diagram.ModelRel_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2004 = getElementType("edu.toronto.cs.se.mmint.diagram.ModelRel_2004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Operator_2005 = getElementType("edu.toronto.cs.se.mmint.diagram.Operator_2005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ExtendibleElementSupertype_4001 = getElementType(
		"edu.toronto.cs.se.mmint.diagram.ExtendibleElementSupertype_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelEndpoint_4002 = getElementType(
		"edu.toronto.cs.se.mmint.diagram.ModelEndpoint_4002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BinaryModelRel_4003 = getElementType(
		"edu.toronto.cs.se.mmint.diagram.BinaryModelRel_4003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelEndpoint_4004 = getElementType(
		"edu.toronto.cs.se.mmint.diagram.ModelEndpoint_4004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ModelEndpoint_4005 = getElementType(
		"edu.toronto.cs.se.mmint.diagram.ModelEndpoint_4005"); //$NON-NLS-1$

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

			elements.put(MID_1000, MIDPackage.eINSTANCE.getMID());

			elements.put(Model_2001, MIDPackage.eINSTANCE.getModel());

			elements.put(Model_2002, MIDPackage.eINSTANCE.getModel());

			elements.put(ModelRel_2003, RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelRel_2004, RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(Operator_2005, OperatorPackage.eINSTANCE.getOperator());

			elements.put(ExtendibleElementSupertype_4001, MIDPackage.eINSTANCE.getExtendibleElement_Supertype());

			elements.put(ModelEndpoint_4002, MIDPackage.eINSTANCE.getModelEndpoint());

			elements.put(BinaryModelRel_4003, RelationshipPackage.eINSTANCE.getBinaryModelRel());

			elements.put(ModelEndpoint_4004, MIDPackage.eINSTANCE.getModelEndpoint());

			elements.put(ModelEndpoint_4005, MIDPackage.eINSTANCE.getModelEndpoint());
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
			KNOWN_ELEMENT_TYPES.add(MID_1000);
			KNOWN_ELEMENT_TYPES.add(Model_2001);
			KNOWN_ELEMENT_TYPES.add(Model_2002);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2003);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2004);
			KNOWN_ELEMENT_TYPES.add(Operator_2005);
			KNOWN_ELEMENT_TYPES.add(ExtendibleElementSupertype_4001);
			KNOWN_ELEMENT_TYPES.add(ModelEndpoint_4002);
			KNOWN_ELEMENT_TYPES.add(BinaryModelRel_4003);
			KNOWN_ELEMENT_TYPES.add(ModelEndpoint_4004);
			KNOWN_ELEMENT_TYPES.add(ModelEndpoint_4005);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
			case MIDEditPart.VISUAL_ID:
				return MID_1000;
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
			case ModelEndpointEditPart.VISUAL_ID:
				return ModelEndpoint_4002;
			case BinaryModelRelEditPart.VISUAL_ID:
				return BinaryModelRel_4003;
			case ModelEndpoint2EditPart.VISUAL_ID:
				return ModelEndpoint_4004;
			case ModelEndpoint3EditPart.VISUAL_ID:
				return ModelEndpoint_4005;
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
			return edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes.getElement(elementTypeAdapter);
		}
	};

}
