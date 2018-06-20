/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.ecore.ui;

import org.eclipse.jface.wizard.IWizard;

import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;

public class EcoreDiagramCreationWizardDialog extends EditorCreationWizardDialog {

//	@Override
//	protected void storeCreatedModelUri(IWizardPage page) {
//
//		EcoreCreationWizardPage filePage = (EcoreCreationWizardPage) page;
//		createdModelUri = filePage.getDomainModelURI().toPlatformString(true);
//	}

	/**
	 * Constructor: initialises the superclass.
	 *
	 * @param parentShell
	 *            The parent shell.
	 * @param newWizard
	 *            The wizard.
	 */
	public EcoreDiagramCreationWizardDialog(IWizard newWizard) {

		super(newWizard);
	}

}
