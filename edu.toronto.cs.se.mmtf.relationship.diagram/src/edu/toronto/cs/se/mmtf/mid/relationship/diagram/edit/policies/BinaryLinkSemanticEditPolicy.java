/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementSupertypeCreateCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ExtendibleElementSupertypeReorientCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkAddModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.LinkChangeModelElementReferenceCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ExtendibleElementSupertypeEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkElementRefsEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

public class BinaryLinkSemanticEditPolicy extends BinaryLinkItemSemanticEditPolicy {

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MidElementTypes.ExtendibleElementSupertype_4001 == req
				.getElementType()) {
			return getGEFWrapper(new ExtendibleElementSupertypeCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (MidElementTypes.LinkElementRefs_4002 == req.getElementType()) {
			return getGEFWrapper(new LinkAddModelElementReferenceCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	@Override
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		switch (getVisualID(req)) {
			case ExtendibleElementSupertypeEditPart.VISUAL_ID:
				return getGEFWrapper(new ExtendibleElementSupertypeReorientCommand(req));
			case LinkElementRefsEditPart.VISUAL_ID:
				return getGEFWrapper(new LinkChangeModelElementReferenceCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
