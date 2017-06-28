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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers;

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
public class ICSE15_SequenceDiagram_MAVOElementTypes {

	/**
	* @generated
	*/
	private ICSE15_SequenceDiagram_MAVOElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVODiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType SequenceDiagram_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.SequenceDiagram_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Lifeline_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.Lifeline_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Class_2002 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.Class_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Message_2003 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.Message_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Operation_3001 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.Operation_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType ClassReference_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.ClassReference_4001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType OperationReference_4002 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.OperationReference_4002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType SourceLifelineReference_4003 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.SourceLifelineReference_4003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType TargetLifelineReference_4004 = getElementType(
			"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.TargetLifelineReference_4004"); //$NON-NLS-1$

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

			elements.put(SequenceDiagram_1000,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getSequenceDiagram());

			elements.put(Lifeline_2001,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getLifeline());

			elements.put(Class_2002,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getClass_());

			elements.put(Message_2003,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getMessage());

			elements.put(Operation_3001,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getOperation());

			elements.put(ClassReference_4001,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getClassReference());

			elements.put(OperationReference_4002,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getOperationReference());

			elements.put(SourceLifelineReference_4003,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getSourceLifelineReference());

			elements.put(TargetLifelineReference_4004,
					edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage.eINSTANCE
							.getTargetLifelineReference());
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
			KNOWN_ELEMENT_TYPES.add(SequenceDiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Lifeline_2001);
			KNOWN_ELEMENT_TYPES.add(Class_2002);
			KNOWN_ELEMENT_TYPES.add(Message_2003);
			KNOWN_ELEMENT_TYPES.add(Operation_3001);
			KNOWN_ELEMENT_TYPES.add(ClassReference_4001);
			KNOWN_ELEMENT_TYPES.add(OperationReference_4002);
			KNOWN_ELEMENT_TYPES.add(SourceLifelineReference_4003);
			KNOWN_ELEMENT_TYPES.add(TargetLifelineReference_4004);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SequenceDiagramEditPart.VISUAL_ID:
			return SequenceDiagram_1000;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.LifelineEditPart.VISUAL_ID:
			return Lifeline_2001;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassEditPart.VISUAL_ID:
			return Class_2002;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.MessageEditPart.VISUAL_ID:
			return Message_2003;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
			return Operation_3001;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
			return ClassReference_4001;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID:
			return OperationReference_4002;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.SourceLifelineReferenceEditPart.VISUAL_ID:
			return SourceLifelineReference_4003;
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.TargetLifelineReferenceEditPart.VISUAL_ID:
			return TargetLifelineReference_4004;
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
			return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
