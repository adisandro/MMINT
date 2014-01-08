/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.Model2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelEndpointEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRelEditPart;
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
	public static final IElementType MultiModel_1000 = getElementType("edu.toronto.cs.se.mmtf.diagram.MultiModel_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Model_2011 = getElementType("edu.toronto.cs.se.mmtf.diagram.Model_2011"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Model_2012 = getElementType("edu.toronto.cs.se.mmtf.diagram.Model_2012"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2013 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelRel_2013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelRel_2014 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelRel_2014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Operator_2015 = getElementType("edu.toronto.cs.se.mmtf.diagram.Operator_2015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ExtendibleElementSupertype_4013 = getElementType("edu.toronto.cs.se.mmtf.diagram.ExtendibleElementSupertype_4013"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ModelEndpoint_4014 = getElementType("edu.toronto.cs.se.mmtf.diagram.ModelEndpoint_4014"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BinaryModelRel_4015 = getElementType("edu.toronto.cs.se.mmtf.diagram.BinaryModelRel_4015"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_4016 = getElementType("edu.toronto.cs.se.mmtf.diagram.Parameter_4016"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Parameter_4017 = getElementType("edu.toronto.cs.se.mmtf.diagram.Parameter_4017"); //$NON-NLS-1$

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

			elements.put(MultiModel_1000, MidPackage.eINSTANCE.getMultiModel());

			elements.put(Model_2011, MidPackage.eINSTANCE.getModel());

			elements.put(Model_2012, MidPackage.eINSTANCE.getModel());

			elements.put(ModelRel_2013,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(ModelRel_2014,
					RelationshipPackage.eINSTANCE.getModelRel());

			elements.put(Operator_2015, OperatorPackage.eINSTANCE.getOperator());

			elements.put(ExtendibleElementSupertype_4013,
					MidPackage.eINSTANCE.getExtendibleElement_Supertype());

			elements.put(ModelEndpoint_4014,
					MidPackage.eINSTANCE.getModelEndpoint());

			elements.put(BinaryModelRel_4015,
					RelationshipPackage.eINSTANCE.getBinaryModelRel());

			elements.put(Parameter_4016,
					OperatorPackage.eINSTANCE.getParameter());

			elements.put(Parameter_4017,
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
			KNOWN_ELEMENT_TYPES.add(Model_2011);
			KNOWN_ELEMENT_TYPES.add(Model_2012);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2013);
			KNOWN_ELEMENT_TYPES.add(ModelRel_2014);
			KNOWN_ELEMENT_TYPES.add(Operator_2015);
			KNOWN_ELEMENT_TYPES.add(ExtendibleElementSupertype_4013);
			KNOWN_ELEMENT_TYPES.add(ModelEndpoint_4014);
			KNOWN_ELEMENT_TYPES.add(BinaryModelRel_4015);
			KNOWN_ELEMENT_TYPES.add(Parameter_4016);
			KNOWN_ELEMENT_TYPES.add(Parameter_4017);
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
			return Model_2011;
		case Model2EditPart.VISUAL_ID:
			return Model_2012;
		case ModelRelEditPart.VISUAL_ID:
			return ModelRel_2013;
		case ModelRel2EditPart.VISUAL_ID:
			return ModelRel_2014;
		case OperatorEditPart.VISUAL_ID:
			return Operator_2015;
		case ExtendibleElementSupertypeEditPart.VISUAL_ID:
			return ExtendibleElementSupertype_4013;
		case ModelEndpointEditPart.VISUAL_ID:
			return ModelEndpoint_4014;
		case BinaryModelRelEditPart.VISUAL_ID:
			return BinaryModelRel_4015;
		case ParameterEditPart.VISUAL_ID:
			return Parameter_4016;
		case Parameter2EditPart.VISUAL_ID:
			return Parameter_4017;
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
			return edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
