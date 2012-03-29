package edu.toronto.cs.se.mmtf.repository.ui;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;


public class ModelCreationWizardDialog extends WizardDialog {

	private URI createdModelUri;

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

	public ModelCreationWizardDialog(Shell parentShell, IWizard newWizard) {

		super(parentShell, newWizard);
	}

	public URI getCreatedModelUri() {

		return createdModelUri;
	}

}
