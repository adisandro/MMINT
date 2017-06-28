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
package edu.toronto.cs.se.mmint.mid.diagram.part;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.LogHelper;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultCreateShortcutHandler;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.part.DefaultElementChooserDialog;
import org.eclipse.swt.widgets.Shell;

import edu.toronto.cs.se.mmint.mid.diagram.edit.commands.MIDCreateShortcutDecorationsCommand;

/**
 * @generated
 */
public class CreateShortcutAction extends DefaultCreateShortcutHandler {
	/**
	 * @generated
	 */
	public CreateShortcutAction() {
		this(MIDDiagramEditorPlugin.getInstance().getLogHelper());
	}

	/**
	 * @generated
	 */
	public CreateShortcutAction(LogHelper logHelper) {
		super(logHelper, MIDDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
	}

	/**
	 * @generated
	 */
	@Override
	public DefaultElementChooserDialog createChooserDialog(Shell parentShell, View view) {
		return new MIDElementChooserDialog(parentShell, view);
	}

	/**
	 * @generated
	 */
	@Override
	public ICommand createShortcutDecorationCommand(
			View view, TransactionalEditingDomain editingDomain, List<CreateViewRequest.ViewDescriptor> descriptors) {
		return new MIDCreateShortcutDecorationsCommand(editingDomain, view, descriptors);
	}
}
