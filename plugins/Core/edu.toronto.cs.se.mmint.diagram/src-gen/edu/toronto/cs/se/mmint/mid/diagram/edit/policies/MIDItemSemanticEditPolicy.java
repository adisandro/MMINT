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
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.Model2CreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRel2CreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.ModelRelCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.OperatorCreateCommand;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MIDItemSemanticEditPolicy extends MIDBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MIDItemSemanticEditPolicy() {
		super(MIDElementTypes.MID_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MIDElementTypes.Model_2001 == req.getElementType()) {
			return getGEFWrapper(new ModelCreateCommand(req));
		}
		if (MIDElementTypes.Model_2002 == req.getElementType()) {
			return getGEFWrapper(new Model2CreateCommand(req));
		}
		if (MIDElementTypes.ModelRel_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelRelCreateCommand(req));
		}
		if (MIDElementTypes.ModelRel_2004 == req.getElementType()) {
			return getGEFWrapper(new ModelRel2CreateCommand(req));
		}
		if (MIDElementTypes.Operator_2005 == req.getElementType()) {
			return getGEFWrapper(new OperatorCreateCommand(req));
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
