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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers;

import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.providers.DefaultEditPartProvider;

/**
 * @generated
 */
public class NECSIS14_DatabaseSchemaEditPartProvider extends
		DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public NECSIS14_DatabaseSchemaEditPartProvider() {
		super(
				new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.NECSIS14_DatabaseSchemaEditPartFactory(),
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.part.NECSIS14_DatabaseSchemaVisualIDRegistry.TYPED_INSTANCE,
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.parts.DatabaseSchemaEditPart.MODEL_ID);
	}

}
