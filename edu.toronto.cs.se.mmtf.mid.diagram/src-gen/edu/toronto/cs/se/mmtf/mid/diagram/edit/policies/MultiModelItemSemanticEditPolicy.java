/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReference2CreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceCreateCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceCreateModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceImportModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class MultiModelItemSemanticEditPolicy extends
		MIDBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public MultiModelItemSemanticEditPolicy() {
		super(MIDElementTypes.MultiModel_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommandGen(CreateElementRequest req) {
		if (MIDElementTypes.MappingReference_2001 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceCreateCommand(req));
		}
		if (MIDElementTypes.ModelReference_2002 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceCreateCommand(req));
		}
		if (MIDElementTypes.ModelReference_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelReference2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (MIDElementTypes.MappingReference_2001 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceCreateCommand(req));
		}
		if (MIDElementTypes.ModelReference_2002 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceImportModelCommand(req));
		}
		if (MIDElementTypes.ModelReference_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceCreateModelCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
