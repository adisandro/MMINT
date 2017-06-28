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
package edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

import edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.edit.parts.EconomyEditPart;
import edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.edit.parts.EconomyEditPartFactory;
import edu.toronto.cs.se.modelepedia.tutorial.economy.diagram.part.EconomyVisualIDRegistry;

/**
 * @generated
 */
public class EconomyEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public EconomyEditPartProvider() {
		super(new EconomyEditPartFactory(),
				EconomyVisualIDRegistry.TYPED_INSTANCE,
				EconomyEditPart.MODEL_ID);
	}

}
