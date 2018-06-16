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
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class Graph_MAVOEditPartProvider extends DefaultEditPartProvider {

	/**
	* @generated
	*/
	public Graph_MAVOEditPartProvider() {
		super(new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.Graph_MAVOEditPartFactory(),
				edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOVisualIDRegistry.TYPED_INSTANCE,
				edu.toronto.cs.se.modelepedia.graph_mavo.diagram.edit.parts.GraphEditPart.MODEL_ID);
	}

}
