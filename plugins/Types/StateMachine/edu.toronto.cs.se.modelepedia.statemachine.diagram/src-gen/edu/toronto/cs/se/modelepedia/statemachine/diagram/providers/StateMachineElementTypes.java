/*
 * Copyright Text ->
 * 
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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.providers;

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

import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateActionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.TransitionEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineDiagramEditorPlugin;

/**
 * @generated
 */
public class StateMachineElementTypes {

	/**
	 * @generated
	 */
	private StateMachineElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	 * @generated
	 */
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			StateMachineDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType StateMachine_1000 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.StateMachine_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_2001 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.State_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType InitialState_2002 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.InitialState_2002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FinalState_2003 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.FinalState_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType StateAction_3001 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.StateAction_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("edu.toronto.cs.se.modelepedia.statemachine.diagram.Transition_4001"); //$NON-NLS-1$

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
					StateMachinePackage.eINSTANCE.getStateMachine());

			elements.put(State_2001, StateMachinePackage.eINSTANCE.getState());

			elements.put(InitialState_2002,
					StateMachinePackage.eINSTANCE.getInitialState());

			elements.put(FinalState_2003,
					StateMachinePackage.eINSTANCE.getFinalState());

			elements.put(StateAction_3001,
					StateMachinePackage.eINSTANCE.getStateAction());

			elements.put(Transition_4001,
					StateMachinePackage.eINSTANCE.getTransition());
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
		case StateMachineEditPart.VISUAL_ID:
			return StateMachine_1000;
		case StateEditPart.VISUAL_ID:
			return State_2001;
		case InitialStateEditPart.VISUAL_ID:
			return InitialState_2002;
		case FinalStateEditPart.VISUAL_ID:
			return FinalState_2003;
		case StateActionEditPart.VISUAL_ID:
			return StateAction_3001;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
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
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes
					.isKnownElementType(elementType);
		}

		/**
		 * @generated
		 */
		@Override
		public IElementType getElementTypeForVisualId(int visualID) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes
					.getElementType(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public ENamedElement getDefiningNamedElement(
				IAdaptable elementTypeAdapter) {
			return edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
