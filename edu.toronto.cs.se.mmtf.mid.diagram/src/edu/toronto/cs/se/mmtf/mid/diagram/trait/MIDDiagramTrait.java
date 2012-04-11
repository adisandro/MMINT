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
package edu.toronto.cs.se.mmtf.mid.diagram.trait;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDElementChooserDialog;
import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.ui.ModelCreationWizardDialog;

/**
 * A container for common functions of a mid diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDDiagramTrait {

	/**
	 * Shows a dialog to choose one among existing models conformant to the
	 * registered metamodels and imports it.
	 * 
	 * @return The uri of the imported model.
	 * @throws Exception
	 *             If the model import was not completed for any reason.
	 */
	public static URI selectModelToImport() throws MMTFException {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DiagramDocumentEditor editor = (DiagramDocumentEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		View view = editor.getDiagramEditPart().getNotationView();

		MIDElementChooserDialog dialog = new MIDElementChooserDialog(shell, view);
		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}

		return dialog.getSelectedModelElementURI();
	}

	/**
	 * Shows a tree dialog to create a model choosing from the registered
	 * metamodels and executes its wizard.
	 * 
	 * @return The uri of the created model.
	 * @throws Exception
	 *             If the model creation was not completed for any reason.
	 */
	public static URI createModel() throws Exception {

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

}
