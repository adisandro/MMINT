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
package edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.commands.ForceDetectingCreateCommand;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.commands.InfraredCreateCommand;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.commands.LockOutCreateCommand;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.commands.PushPullCreateCommand;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.edit.commands.RockerCreateCommand;
import edu.toronto.cs.se.modelepedia.powerwindow.diagram.providers.PowerwindowElementTypes;

/**
 * @generated
 */
public class WindowItemSemanticEditPolicy extends
		PowerwindowBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public WindowItemSemanticEditPolicy() {
		super(PowerwindowElementTypes.Window_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PowerwindowElementTypes.PushPull_2001 == req.getElementType()) {
			return getGEFWrapper(new PushPullCreateCommand(req));
		}
		if (PowerwindowElementTypes.Rocker_2002 == req.getElementType()) {
			return getGEFWrapper(new RockerCreateCommand(req));
		}
		if (PowerwindowElementTypes.Infrared_2003 == req.getElementType()) {
			return getGEFWrapper(new InfraredCreateCommand(req));
		}
		if (PowerwindowElementTypes.LockOut_2004 == req.getElementType()) {
			return getGEFWrapper(new LockOutCreateCommand(req));
		}
		if (PowerwindowElementTypes.ForceDetecting_2005 == req.getElementType()) {
			return getGEFWrapper(new ForceDetectingCreateCommand(req));
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
