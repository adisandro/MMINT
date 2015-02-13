/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

public class LinkReferenceSuperSemanticEditPolicy extends LinkReference2ItemSemanticEditPolicy {

	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {

		return null;
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		return null;
	}

	@Override
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		return UnexecutableCommand.INSTANCE;
	}

}
