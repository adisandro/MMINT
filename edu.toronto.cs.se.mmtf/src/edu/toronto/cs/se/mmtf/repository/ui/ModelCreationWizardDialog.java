/**
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
package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
//import org.eclipse.emf.ecoretools.diagram.part.EcoreCreationWizardPage;

/**
 * A wizard dialog to create a new model.
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
		while (page.getPreviousPage() != null && !(page instanceof WizardNewFileCreationPage)) {
			page = page.getPreviousPage();
		}

		//TODO MMTF: restore ecoretools support
//		if (page instanceof EcoreCreationWizardPage) {
//			EcoreCreationWizardPage filePage = (EcoreCreationWizardPage) page;
//			createdModelUri = filePage.getDomainModelURI();
//		}
//		else {
			WizardNewFileCreationPage filePage = (WizardNewFileCreationPage) page;
			String modelPath = filePage.getContainerFullPath().toString() + IPath.SEPARATOR + filePage.getFileName();
			createdModelUri = URI.createPlatformResourceURI(modelPath, true);
//		}

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
