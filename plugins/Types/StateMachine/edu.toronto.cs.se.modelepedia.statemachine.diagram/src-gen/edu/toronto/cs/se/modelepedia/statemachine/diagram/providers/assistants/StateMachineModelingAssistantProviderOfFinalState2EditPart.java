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
package edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalState2EditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.FinalStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialState2EditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.InitialStateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.State2EditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineModelingAssistantProvider;

/**
 * @generated
 */
public class StateMachineModelingAssistantProviderOfFinalState2EditPart extends
		StateMachineModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((FinalState2EditPart) sourceEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSource(FinalState2EditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(StateMachineElementTypes.Transition_4001);
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
				(FinalState2EditPart) sourceEditPart, targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnSourceAndTarget(
			FinalState2EditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof InitialStateEditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof StateEditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InitialState2EditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalState2EditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof State2EditPart) {
			types.add(StateMachineElementTypes.Transition_4001);
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
		return doGetTypesForTarget((FinalState2EditPart) sourceEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForTarget(FinalState2EditPart source,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == StateMachineElementTypes.Transition_4001) {
			types.add(StateMachineElementTypes.InitialState_2001);
			types.add(StateMachineElementTypes.FinalState_2002);
			types.add(StateMachineElementTypes.State_2003);
			types.add(StateMachineElementTypes.InitialState_3001);
			types.add(StateMachineElementTypes.FinalState_3002);
			types.add(StateMachineElementTypes.State_3003);
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
		return doGetRelTypesOnTarget((FinalState2EditPart) targetEditPart);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetRelTypesOnTarget(FinalState2EditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(StateMachineElementTypes.Transition_4001);
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
		return doGetTypesForSource((FinalState2EditPart) targetEditPart,
				relationshipType);
	}

	/**
	 * @generated
	 */
	public List<IElementType> doGetTypesForSource(FinalState2EditPart target,
			IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == StateMachineElementTypes.Transition_4001) {
			types.add(StateMachineElementTypes.InitialState_2001);
			types.add(StateMachineElementTypes.FinalState_2002);
			types.add(StateMachineElementTypes.State_2003);
			types.add(StateMachineElementTypes.InitialState_3001);
			types.add(StateMachineElementTypes.FinalState_3002);
			types.add(StateMachineElementTypes.State_3003);
		}
		return types;
	}

}
