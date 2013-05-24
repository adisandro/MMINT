/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.ecore.ui;

import org.eclipse.emf.ecoretools.diagram.part.EcoreCreationWizardPage;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Shell;

import edu.toronto.cs.se.mmtf.repository.ui.ModelCreationWizardDialog;

public class EcoreModelCreationWizardDialog extends ModelCreationWizardDialog {

	@Override
	protected void storeCreatedModelUri(IWizardPage page) {

		//TODO MMTF: test if this works
		EcoreCreationWizardPage filePage = (EcoreCreationWizardPage) page;
		createdModelUri = filePage.getDomainModelURI().toPlatformString(true);
	}

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param parentShell
	 *            The parent shell.
	 * @param newWizard
	 *            The wizard.
	 */
	public EcoreModelCreationWizardDialog(Shell parentShell, IWizard newWizard) {

		super(parentShell, newWizard);
	}

}
