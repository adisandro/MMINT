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

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPart;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.edit.parts.StateMachineEditPartFactory;
import edu.toronto.cs.se.modelepedia.statemachine.diagram.part.StateMachineVisualIDRegistry;

/**
 * @generated
 */
public class StateMachineEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public StateMachineEditPartProvider() {
		super(new StateMachineEditPartFactory(),
				StateMachineVisualIDRegistry.TYPED_INSTANCE,
				StateMachineEditPart.MODEL_ID);
	}

}
