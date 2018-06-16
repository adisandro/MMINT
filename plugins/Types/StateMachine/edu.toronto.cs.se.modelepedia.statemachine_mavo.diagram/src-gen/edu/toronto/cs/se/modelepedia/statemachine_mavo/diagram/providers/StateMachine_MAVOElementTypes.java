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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers;

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
public class StateMachine_MAVOElementTypes {

	/**
	* @generated
	*/
	private StateMachine_MAVOElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.part.StateMachine_MAVODiagramEditorPlugin
					.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType StateMachine_1000 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.StateMachine_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType State_2001 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.State_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType InitialState_2002 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.InitialState_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType FinalState_2003 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.FinalState_2003"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType StateAction_3001 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.StateAction_3001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Transition_4001 = getElementType(
			"edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.Transition_4001"); //$NON-NLS-1$

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

			elements.put(StateMachine_1000,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
							.getStateMachine());

			elements.put(State_2001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE.getState());

			elements.put(InitialState_2002,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
							.getInitialState());

			elements.put(FinalState_2003,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE.getFinalState());

			elements.put(StateAction_3001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE
							.getStateAction());

			elements.put(Transition_4001,
					edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage.eINSTANCE.getTransition());
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
			KNOWN_ELEMENT_TYPES.add(StateMachine_1000);
			KNOWN_ELEMENT_TYPES.add(State_2001);
			KNOWN_ELEMENT_TYPES.add(InitialState_2002);
			KNOWN_ELEMENT_TYPES.add(FinalState_2003);
			KNOWN_ELEMENT_TYPES.add(StateAction_3001);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateMachineEditPart.VISUAL_ID:
			return StateMachine_1000;
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart.VISUAL_ID:
			return State_2001;
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart.VISUAL_ID:
			return InitialState_2002;
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart.VISUAL_ID:
			return FinalState_2003;
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateActionEditPart.VISUAL_ID:
			return StateAction_3001;
		case edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.TransitionEditPart.VISUAL_ID:
			return Transition_4001;
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
			return edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
					.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
