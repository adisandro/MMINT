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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;

public class ModelReferenceCreateModelCommand extends ModelReference2CreateCommand {

	private URI createModel() {

		URI modelUri = null;
		//TODO show dialog to ask which model should be created (populated from repository)
			//TODO get all metamodels, all wizards for each metamodel
		//TODO get selected wizardID, launch wizard
		//TODO find a way to get the uri of the generated model/diagrams

		return modelUri;
	}

	public ModelReferenceCreateModelCommand(CreateElementRequest req) {

		super(req);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		IWizardDescriptor descriptor = PlatformUI
				.getWorkbench()
				.getNewWizardRegistry()
				.findWizard(
						"edu.toronto.cs.se.mmtf.xt.statechart.diagram.part.StatechartCreationWizardID");
		try {
			if (descriptor != null) {
				IWorkbenchWizard wizard = descriptor.createWizard();
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.setTitle(wizard.getWindowTitle());
				dialog.open();
				// check return
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

		ModelReference newElement = MidFactory.eINSTANCE.createModelReference();
		newElement.setOrigin(ModelReferenceOrigin.CREATED);

		MultiModel owner = (MultiModel) getElementToEdit();
		owner.getElements().add(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

}
