/*
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class StateMachine_MAVOModelingAssistantProviderOfStateMachineEditPart extends
		edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.State_2001);
		types.add(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.InitialState_2002);
		types.add(
				edu.toronto.cs.se.modelepedia.statemachine_mavo.diagram.providers.StateMachine_MAVOElementTypes.FinalState_2003);
		return types;
	}

}
