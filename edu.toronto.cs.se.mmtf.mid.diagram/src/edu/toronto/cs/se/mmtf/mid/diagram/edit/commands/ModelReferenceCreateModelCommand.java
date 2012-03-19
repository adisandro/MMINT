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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.repository.Editor;

public class ModelReferenceCreateModelCommand extends ModelReference2CreateCommand {

	private URI createModel() throws Exception {

		URI modelUri = null;
		ElementTreeSelectionDialog dialog = MMTFRegistry.getRepositoryAsDialog();
		dialog.setTitle("Create new model");
		dialog.setTitle("Choose model/editor to create");
		dialog.setAllowMultiple(false);
		//TODO rifare sia qui che nell'import, lanciare eccezioni da qui
		if (dialog.open() == Window.OK) {
			Object selection = dialog.getFirstResult();
			if (selection != null) {
				Editor editor = (Editor) selection;
				IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(editor.getWizardId());
				if (descriptor != null) {//TODO gestire la CoreException che viene lanciata qui eventualmente?
					IWorkbenchWizard wizard = descriptor.createWizard();
					wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
					Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
					WizardDialog wizDialog = new WizardDialog(shell, wizard);
					wizDialog.setTitle(wizard.getWindowTitle());
					if (wizDialog.open() == Window.OK) {
						//TODO check return
					}
				}
			}
		}
		//TODO find a way to get the uri of the generated model/diagrams

		return modelUri;
	}

	public ModelReferenceCreateModelCommand(CreateElementRequest req) {

		super(req);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		URI modelUri;
		EObject root;
		try {
			modelUri = createModel();
			if (modelUri == null) {
				throw new MMTFException("Dialog cancel button pressed");
			}
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model created", e);
			return CommandResult.newErrorCommandResult("No model created");
		}

		ModelReference newElement = MidFactory.eINSTANCE.createModelReference();
		newElement.setUri(modelUri.toPlatformString(true));
		newElement.setName(modelUri.lastSegment());
		newElement.setRoot(root);
		newElement.setOrigin(ModelReferenceOrigin.CREATED);
		MultiModel owner = (MultiModel) getElementToEdit();
		owner.getElements().add(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
