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
package edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.edit.commands.ForeignKeyCreateCommand;
import edu.toronto.cs.se.modelepedia.relationaldatabase.diagram.providers.RelationalDatabaseElementTypes;

/**
 * @generated
 */
public class TableTableForeignKeysCompartmentItemSemanticEditPolicy extends
		RelationalDatabaseBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public TableTableForeignKeysCompartmentItemSemanticEditPolicy() {
		super(RelationalDatabaseElementTypes.Table_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (RelationalDatabaseElementTypes.ForeignKey_3002 == req
				.getElementType()) {
			return getGEFWrapper(new ForeignKeyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
