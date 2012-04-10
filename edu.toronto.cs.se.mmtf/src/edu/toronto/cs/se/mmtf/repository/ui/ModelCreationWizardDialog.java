/**
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
package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * A wizard dialog to create a new model through MMTF.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelCreationWizardDialog extends WizardDialog {

	/** The uri of the created model. */
	private URI createdModelUri;

	/**
	 * {@inheritDoc}
	 * Remembers the uri of the created model.
	 */
	@Override
	protected void finishPressed() {

		IWizardPage page = getCurrentPage();
		while (!(page instanceof WizardNewFileCreationPage)) {
			page = page.getPreviousPage();
		}
		WizardNewFileCreationPage filePage = (WizardNewFileCreationPage) page;
		String modelPath = filePage.getContainerFullPath().toString() + IPath.SEPARATOR + filePage.getFileName();
		createdModelUri = URI.createPlatformResourceURI(modelPath, true);

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
	public ModelCreationWizardDialog(Shell parentShell, IWizard newWizard) {

		super(parentShell, newWizard);
	}

	/**
	 * Gets the uri of the created model.
	 * 
	 * @return The uri of the created model.
	 */
	public URI getCreatedModelUri() {

		return createdModelUri;
	}

}
