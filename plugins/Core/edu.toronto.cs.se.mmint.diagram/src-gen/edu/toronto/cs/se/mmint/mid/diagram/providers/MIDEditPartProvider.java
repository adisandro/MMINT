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
package edu.toronto.cs.se.mmint.mid.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPartFactory;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class MIDEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public MIDEditPartProvider() {
		super(new MIDEditPartFactory(), MIDVisualIDRegistry.TYPED_INSTANCE, MIDEditPart.MODEL_ID);
	}

}
