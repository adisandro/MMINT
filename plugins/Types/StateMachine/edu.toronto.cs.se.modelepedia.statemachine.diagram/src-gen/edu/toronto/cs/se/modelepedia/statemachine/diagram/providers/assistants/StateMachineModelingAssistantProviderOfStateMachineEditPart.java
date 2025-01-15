/*
 * Copyright Text ->
 * 
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineElementTypes;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.providers.StateMachineModelingAssistantProvider;

/**
 * @generated
 */
public class StateMachineModelingAssistantProviderOfStateMachineEditPart extends
		StateMachineModelingAssistantProvider {

	/**
	 * @generated
	 */
	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(StateMachineElementTypes.State_2001);
		types.add(StateMachineElementTypes.InitialState_2002);
		types.add(StateMachineElementTypes.FinalState_2003);
		return types;
	}

}
