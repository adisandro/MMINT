/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.papyrus.uml.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;

import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class UMLDiagramCreationWizardDialog extends EditorCreationWizardDialog {
	private final static String MODEL_FILEEXT = "uml";

	@Override
	protected void storeCreatedModelUri(IWizardPage page) {
		var filePage = (NewModelFilePage) page;
		this.createdModelUri = filePage.getContainerFullPath().toString() + IPath.SEPARATOR + filePage.getFileName();
		this.createdModelUri = FileUtils.replaceFileExtensionInPath(this.createdModelUri,
		                                                            UMLDiagramCreationWizardDialog.MODEL_FILEEXT);
	}

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param newWizard
	 *            The wizard.
	 */
	public UMLDiagramCreationWizardDialog(IWizard newWizard) {
		super(newWizard);
	}
}
