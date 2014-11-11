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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class StateMachine_MAVOModelingAssistantProviderOfInitialState2EditPart
		extends
		edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget(
				(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) sourceEditPart,
				targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart source,
			IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialStateEditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalStateEditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.StateEditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.FinalState2EditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.State2EditPart) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget(
				(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_2001);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_2002);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2003);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_3001);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_3002);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_3003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource(
				(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(
			edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.edit.parts.InitialState2EditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.Transition_4001) {
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_2001);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_2002);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2003);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_3001);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_3002);
			types.add(edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_3003);
		}
		return types;
	}

}
