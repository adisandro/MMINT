/*
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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.ui.ModelCreationWizardDialog;

public class ModelReferenceCreateModelCommand extends ModelReference2CreateCommand {

	private URI createModel() throws Exception {

		ElementTreeSelectionDialog dialog = MMTFRegistry.getRepositoryAsDialog();
		dialog.setTitle("Create new model");
		dialog.setMessage("Choose wizard to create model");
		dialog.setAllowMultiple(false);

		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) {
			throw new MMTFException("Dialog ok button pressed with no selection");
		}
		Editor editor = (Editor) selection;
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(editor.getWizardId());
		if (descriptor == null) {
			throw new MMTFException("Wizard " + editor.getEditorId() + " not found");
		}

		IWorkbenchWizard wizard = descriptor.createWizard();
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ModelCreationWizardDialog wizDialog = new ModelCreationWizardDialog(shell, wizard);
		wizDialog.setTitle(wizard.getWindowTitle());
		if (wizDialog.open() == Window.CANCEL) {
			throw new MMTFException("Wizard dialog cancel button pressed");
		}

		return wizDialog.getCreatedModelUri();
	}

	public ModelReferenceCreateModelCommand(CreateElementRequest req) {

		super(req);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			URI modelUri = createModel();
			MultiModel owner = (MultiModel) getElementToEdit();
			ModelReference newElement = MultiModelCommandsTrait.createModelReference(owner, modelUri);
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

			return CommandResult.newOKCommandResult(newElement);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}
	}

}
