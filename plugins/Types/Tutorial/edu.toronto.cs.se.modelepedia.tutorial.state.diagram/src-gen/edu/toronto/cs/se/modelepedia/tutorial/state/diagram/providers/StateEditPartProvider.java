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
package edu.toronto.cs.se.modelepedia.tutorial.state.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.StateEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.edit.parts.StateEditPartFactory;
import edu.toronto.cs.se.modelepedia.tutorial.state.diagram.part.StateVisualIDRegistry;

/**
 * @generated
 */
public class StateEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public StateEditPartProvider() {
		super(new StateEditPartFactory(), StateVisualIDRegistry.TYPED_INSTANCE,
				StateEditPart.MODEL_ID);
	}

}
