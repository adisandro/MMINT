/*
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
package edu.toronto.cs.se.mmtf.mid.diagram.trait;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.wizards.IWizardDescriptor;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidElementChooserDialog;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelFactoryUtils;
import edu.toronto.cs.se.mmtf.repository.ui.ModelCreationWizardDialog;

/**
 * A container for common functions of a Mid diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MidDiagramTrait {

	/**
	 * Shows a dialog to choose one among existing models and imports it.
	 * 
	 * @param relOnly
	 *            True to allow the selection of relationship files only, false
	 *            to allow all registered model files.
	 * @return The uri of the imported model.
	 * @throws Exception
	 *             If the model import was not completed for any reason.
	 */
	public static URI selectModelToImport(boolean relOnly) throws Exception {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		DiagramDocumentEditor editor = (DiagramDocumentEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		View view = (View) editor.getDiagramEditPart().getModel();

		MidElementChooserDialog dialog = new MidElementChooserDialog(shell, view, relOnly);
		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}

		return dialog.getSelectedModelElementURI();
	}

	/**
	 * Shows a tree dialog to create a model choosing from the registered model
	 * types and executes its wizard.
	 * 
	 * @return The editor for the created model.
	 * @throws Exception
	 *             If the model creation was not completed for any reason.
	 */
	public static Editor selectModelTypeToCreate() throws Exception {

		ElementTreeSelectionDialog dialog = MMTFRegistry.getModelCreationDialog();
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
		Editor editorType = (Editor) selection;
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(editorType.getWizardId());
		if (descriptor == null) {
			throw new MMTFException("Wizard " + editorType.getId() + " not found");
		}

		IWorkbenchWizard wizard = descriptor.createWizard();
		wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ModelCreationWizardDialog wizDialog = new ModelCreationWizardDialog(shell, wizard);
		wizDialog.setTitle(wizard.getWindowTitle());
		if (wizDialog.open() == Window.CANCEL) {
			throw new MMTFException("Wizard dialog cancel button pressed");
		}
		Editor editor = MultiModelFactoryUtils.createEditor(editorType, wizDialog.getCreatedModelUri());

		return editor;
	}

	public static ModelRel selectModelRelTypeToCreate(Model source, Model target) throws Exception {

		ElementTreeSelectionDialog dialog = MMTFRegistry.getModelRelCreationDialog(source, target);
		String title = "Create new model relationship";
		String message = "Choose model relationship type";

		return (ModelRel) selectModelType(dialog, title, message);
	}

	private static Model selectModelType(ElementTreeSelectionDialog dialog, String title, String message) throws MMTFException {

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);

		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) {
			throw new MMTFException("Dialog ok button pressed with no selection");
		}
		Model modelType = (Model) selection;

		return modelType;
	}

	/**
	 * Shows a tree dialog to select a model type choosing from the registered
	 * model types.
	 * 
	 * @return The choosen model type.
	 * @throws MMTFException
	 *             If the selection was not completed for any reason.
	 */
	public static Model selectModelTypeToExtend() throws MMTFException {

		ElementTreeSelectionDialog dialog = MMTFRegistry.getModelTypeCreationDialog();
		String title = "Create new light model type";
		String message = "Choose model supertype";

		return selectModelType(dialog, title, message);
	}

	/**
	 * Shows a tree dialog to select a model relationship type choosing from the
	 * registered model relationship types.
	 * 
	 * @return The choosen model relationship type.
	 * @throws MMTFException
	 *             If the selection was not completed for any reason.
	 */
	public static ModelRel selectModelRelTypeToExtend(String srcModelTypeUri, String tgtModelTypeUri) throws MMTFException {

		ElementTreeSelectionDialog dialog = MMTFRegistry.getModelRelTypeCreationDialog(srcModelTypeUri, tgtModelTypeUri);
		String title = "Create new light model relationship type";
		String message = "Choose model relationship supertype";

		return (ModelRel) selectModelType(dialog, title, message);
	}

	/**
	 * Shows an input dialog to get text from the user.
	 * 
	 * @param dialogTitle
	 *            The dialog title.
	 * @param dialogMessage
	 *            The dialog message.
	 * @return The text input from the user.
	 * @throws MMTFException
	 *             If the text input was not completed for any reason.
	 */
	public static String getStringInput(String dialogTitle, String dialogMessage) throws MMTFException {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog = new InputDialog(shell, dialogTitle, dialogMessage, null, null);

		if (dialog.open() == Window.CANCEL) {
			throw new MMTFException("Dialog cancel button pressed");
		}
		String text = dialog.getValue();
		if (text == null) {
			text = "";
		}

		return text;
	}

}
