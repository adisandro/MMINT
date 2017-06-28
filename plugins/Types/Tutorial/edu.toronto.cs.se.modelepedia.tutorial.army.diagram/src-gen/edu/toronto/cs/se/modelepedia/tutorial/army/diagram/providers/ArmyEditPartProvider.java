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
package edu.toronto.cs.se.modelepedia.tutorial.army.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

import edu.toronto.cs.se.modelepedia.tutorial.army.diagram.edit.parts.ArmyEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.army.diagram.edit.parts.ArmyEditPartFactory;
import edu.toronto.cs.se.modelepedia.tutorial.army.diagram.part.ArmyVisualIDRegistry;

/**
 * @generated
 */
public class ArmyEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public ArmyEditPartProvider() {
		super(new ArmyEditPartFactory(), ArmyVisualIDRegistry.TYPED_INSTANCE,
				ArmyEditPart.MODEL_ID);
	}

}
