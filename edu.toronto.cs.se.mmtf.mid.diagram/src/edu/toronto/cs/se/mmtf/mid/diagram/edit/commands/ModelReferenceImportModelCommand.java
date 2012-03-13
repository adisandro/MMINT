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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.ModelReferenceOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDElementChooserDialog;

public class ModelReferenceImportModelCommand extends ModelReferenceCreateCommand {

	private URI selectModelToImport() {

		URI modelUri = null;
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MIDDiagramEditor editor = (MIDDiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		View view = editor.getDiagramEditPart().getNotationView();

		MIDElementChooserDialog dialog = new MIDElementChooserDialog(shell, view);
		if (dialog.open() == Window.OK) {
			modelUri = dialog.getSelectedModelElementURI();
		}

		return modelUri;
	}

	public ModelReferenceImportModelCommand(CreateElementRequest req) {

		super(req);
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		URI modelUri = selectModelToImport();
		EObject root;
		try {
			if (modelUri == null) {
				throw new MMTFException("Cancel button pressed in chooser dialog");
			}
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(modelUri, true);
			root = resource.getContents().get(0);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No model imported", e);
			return CommandResult.newErrorCommandResult("No model imported");
		}

		ModelReference newElement = MidFactory.eINSTANCE.createModelReference();
		newElement.setUri(modelUri.toPlatformString(true));
		newElement.setName(modelUri.lastSegment());
		newElement.setRoot(root);
		newElement.setOrigin(ModelReferenceOrigin.IMPORTED);
		MultiModel owner = (MultiModel) getElementToEdit();
		owner.getElements().add(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

}
