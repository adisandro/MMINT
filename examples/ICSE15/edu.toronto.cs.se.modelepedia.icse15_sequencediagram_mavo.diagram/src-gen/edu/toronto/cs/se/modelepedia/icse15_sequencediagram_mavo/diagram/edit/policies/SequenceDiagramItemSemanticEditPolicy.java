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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class SequenceDiagramItemSemanticEditPolicy
		extends
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.policies.ICSE15_SequenceDiagram_MAVOBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SequenceDiagramItemSemanticEditPolicy() {
		super(
				edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.SequenceDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Lifeline_2001 == req
				.getElementType()) {
			return getGEFWrapper(new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands.LifelineCreateCommand(
					req));
		}
		if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Class_2002 == req
				.getElementType()) {
			return getGEFWrapper(new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands.ClassCreateCommand(
					req));
		}
		if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Message_2003 == req
				.getElementType()) {
			return getGEFWrapper(new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands.MessageCreateCommand(
					req));
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
