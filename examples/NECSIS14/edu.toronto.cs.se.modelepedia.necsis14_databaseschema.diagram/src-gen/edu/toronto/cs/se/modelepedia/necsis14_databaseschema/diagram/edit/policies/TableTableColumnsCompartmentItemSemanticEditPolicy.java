/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class TableTableColumnsCompartmentItemSemanticEditPolicy
		extends
		edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.policies.NECSIS14_DatabaseSchemaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TableTableColumnsCompartmentItemSemanticEditPolicy() {
		super(
				edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Table_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.providers.NECSIS14_DatabaseSchemaElementTypes.Column_3001 == req
				.getElementType()) {
			return getGEFWrapper(new edu.toronto.cs.se.modelepedia.necsis14_databaseschema.diagram.edit.commands.ColumnCreateCommand(
					req));
		}
		return super.getCreateCommand(req);
	}

}
