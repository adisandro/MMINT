/*
* Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.MappingReference2CreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.MappingReferenceCreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelEndpointReference2CreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelEndpointReferenceCreateCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class ModelRelItemSemanticEditPolicy extends MIDBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ModelRelItemSemanticEditPolicy() {
		super(MIDElementTypes.ModelRel_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MIDElementTypes.ModelEndpointReference_2001 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointReferenceCreateCommand(req));
		}
		if (MIDElementTypes.MappingReference_2002 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceCreateCommand(req));
		}
		if (MIDElementTypes.MappingReference_2003 == req.getElementType()) {
			return getGEFWrapper(new MappingReference2CreateCommand(req));
		}
		if (MIDElementTypes.ModelEndpointReference_2004 == req.getElementType()) {
			return getGEFWrapper(new ModelEndpointReference2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
