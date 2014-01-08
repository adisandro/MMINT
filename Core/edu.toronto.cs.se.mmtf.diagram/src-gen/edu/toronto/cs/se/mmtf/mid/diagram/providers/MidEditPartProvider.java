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
package edu.toronto.cs.se.mmtf.mid.diagram.providers;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MidEditPartFactory;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry;

/**
 * @generated
 */
public class MidEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public MidEditPartProvider() {
		super(new MidEditPartFactory(), MidVisualIDRegistry.TYPED_INSTANCE,
				MultiModelEditPart.MODEL_ID);
	}
}
