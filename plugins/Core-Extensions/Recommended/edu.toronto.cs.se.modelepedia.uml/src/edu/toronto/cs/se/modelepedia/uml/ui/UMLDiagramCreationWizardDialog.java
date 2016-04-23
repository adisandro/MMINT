/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.uml.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.NewModelFilePage;
import org.eclipse.swt.widgets.Shell;

import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;

public class UMLDiagramCreationWizardDialog extends EditorCreationWizardDialog {

	private final static String UML_FILE_EXTENSION = "uml";

	@Override
	protected void storeCreatedModelUri(IWizardPage page) {

		NewModelFilePage filePage = (NewModelFilePage) page;
		createdModelUri = filePage.getContainerFullPath().toString() + IPath.SEPARATOR + filePage.getFileName();
		createdModelUri = MIDUtils.replaceFileExtensionInUri(createdModelUri, UML_FILE_EXTENSION);
	}

	/**
	 * Constructor: initialises the superclass.
	 * 
	 * @param parentShell
	 *            The parent shell.
	 * @param newWizard
	 *            The wizard.
	 */
	public UMLDiagramCreationWizardDialog(Shell parentShell, IWizard newWizard) {

		super(parentShell, newWizard);
	}

}
