/**
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
package edu.toronto.cs.se.mmint.mid.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

/**
 * A wizard dialog to create a new editor.
 *
 * @author Alessio Di Sandro
 *
 */
public class EditorCreationWizardDialog extends WizardDialog {

	/** The uri of the created model. */
	protected String createdModelUri;

	protected void storeCreatedModelUri(IWizardPage page) {

		WizardNewFileCreationPage filePage = (WizardNewFileCreationPage) page;
		if (filePage.getNextPage() != null && filePage.getNextPage() instanceof WizardNewFileCreationPage) {
			WizardNewFileCreationPage nextPage = (WizardNewFileCreationPage) filePage.getNextPage();
			nextPage.setFileName(
				FileUtils.replaceFileNameInPath(
					nextPage.getFileName(),
					FileUtils.getFileNameFromPath(filePage.getFileName())
				)
			);
			filePage = nextPage;
		}
		this.createdModelUri = filePage.getContainerFullPath().toString() + IPath.SEPARATOR + filePage.getFileName();
	}

	/**
	 * {@inheritDoc}
	 * Remembers the uri of the created model.
	 */
	@Override
	protected void finishPressed() {

		IWizardPage page = this.getCurrentPage();
		while (page.getPreviousPage() != null) { // first page or last WizardNewFileCreationPage
			if (page instanceof WizardNewFileCreationPage) {
				break;
			}
			page = page.getPreviousPage();
		}
		this.storeCreatedModelUri(page);
		super.finishPressed();
	}

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param newWizard
	 *            The wizard.
	 */
	public EditorCreationWizardDialog(IWizard newWizard) {

		//TODO MMINT[EDITOR] Create interface, this as the base class is misleading, then maybe make finishPressed to be inherited too
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), newWizard);
	}

	/**
	 * Gets the uri of the created model.
	 *
	 * @return The uri of the created model.
	 */
	public String getCreatedModelUri() {

		return this.createdModelUri;
	}

}
