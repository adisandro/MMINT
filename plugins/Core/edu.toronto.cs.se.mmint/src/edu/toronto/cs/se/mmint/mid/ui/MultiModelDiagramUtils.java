/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * A container for common functions of a Mid diagram.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelDiagramUtils {

	public final static String CONSTRAINT_LANGUAGE_SEPARATOR = ":";

	protected static Object openDialog(MultiModelTreeSelectionDialog dialog, String title, String message) throws MultiModelDialogCancellation {

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);
		if (dialog.open() == Window.CANCEL) {
			throw new MultiModelDialogCancellation();
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) { // dialog opened and nothing selected
			throw new MultiModelDialogCancellation();
		}

		return selection;
	}

	protected static Object openSelectionDialog(MultiModelTreeSelectionDialog dialog, String title, String message) throws MultiModelDialogCancellation {

		return openDialog(dialog, title, message);
	}

	protected static Object openSelectionDialogWithDefault(MultiModelTreeSelectionDialog dialog, String title, String message) throws MultiModelDialogCancellation {

		Object selection = dialog.getOnlyResult();
		if (selection == null) { // more than one choice possible, open the dialog
			selection = openDialog(dialog, title, message);
		}

		return selection;
	}

	/**
	 * Shows a tree dialog to create a model choosing from the registered model
	 * types, and executes its wizard.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @return The editor for the created model.
	 * @throws MultiModelDialogCancellation, MMINTException
	 *             If the model creation was not completed for any reason.
	 */
	public static Editor selectModelTypeToCreate(MultiModel multiModel) throws MultiModelDialogCancellation, MMINTException {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelCreationDialog();
		Editor editorType = (Editor) openSelectionDialog(dialog, "Create new model", "Choose editor to create model");
		IStructuredSelection multiModelContainer;
		String multiModelContainerUri = MultiModelUtils.replaceLastSegmentInUri(multiModel.eResource().getURI().toPlatformString(true), "");
		try {
			multiModelContainer = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path(multiModelContainerUri)
				)
			);
		}
		catch (Exception e) {
			multiModelContainer = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getProject(multiModelContainerUri)
			);
		}
		EditorCreationWizardDialog wizDialog = editorType.invokeInstanceWizard(multiModelContainer);
		if (wizDialog == null) {
			throw new MultiModelDialogCancellation();
		}

		return editorType.createInstance(wizDialog.getCreatedModelUri(), multiModel);
	}

	/**
	 * Shows a dialog to choose one among existing models and imports it.
	 * 
	 * @param relOnly
	 *            True to allow the selection of relationship files only, false
	 *            to allow all registered model files.
	 * @return The uri of the imported model.
	 * @throws MultiModelDialogCancellation
	 *             If the model import was not completed for any reason.
	 */
	public static String selectModelToImport(boolean relOnly) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelImportDialog();
		String title = "Import model";
		String message = "Choose model to import";
		IFile modelFile = (IFile) openSelectionDialog(dialog, title, message);

		return modelFile.getFullPath().toString();
	}

	public static ModelEndpointReference selectModelTypeEndpointToCreate(ModelRel modelRel, List<String> modelTypeEndpointUris, String modelEndpointId) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelEndpointCreationDialog(modelRel, modelTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose " + modelEndpointId + "model type endpoint role";

		return (ModelEndpointReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static ModelRel selectModelRelTypeToCreate(Model srcModel, Model tgtModel) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelRelCreationDialog(srcModel, tgtModel);
		String title = "Create new model relationship";
		String message = "Choose model relationship type";

		return (ModelRel) openSelectionDialogWithDefault(dialog, title, message);
	}

	/**
	 * Shows a tree dialog to select a model type choosing from the registered
	 * model types.
	 * 
	 * @return The choosen model type.
	 * @throws MultiModelDialogCancellation
	 *             If the selection was not completed for any reason.
	 */
	public static Model selectModelTypeToExtend(MultiModel multiModel) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelTypeCreationDialog(multiModel);
		String title = "Create new light model type";
		String message = "Choose model supertype";

		return (Model) openSelectionDialogWithDefault(dialog, title, message);
	}

	/**
	 * Shows a tree dialog to select a model relationship type choosing from the
	 * registered model relationship types.
	 * 
	 * @return The choosen model relationship type.
	 * @throws MultiModelDialogCancellation
	 *             If the selection was not completed for any reason.
	 */
	public static ModelRel selectModelRelTypeToExtend(MultiModel multiModel, Model srcModelType, Model tgtModelType) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelRelTypeCreationDialog(srcModelType, tgtModelType, multiModel);
		String title = "Create new light model relationship type";
		String message = "Choose model relationship supertype";

		return (ModelRel) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static LinkReference selectLinkTypeReferenceToCreate(ModelRel modelRel, ModelElementReference srcModelElemRef, ModelElementReference tgtModelElemRef) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkReferenceCreationDialog(srcModelElemRef, tgtModelElemRef, modelRel);
		String title = "Create new link";
		String message = "Choose link type";

		return (LinkReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static LinkReference selectLinkTypeReferenceToExtend(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getLinkTypeReferenceCreationDialog(srcModelElemTypeRef, tgtModelElemTypeRef, modelRelType);
		String title = "Create new light link type";
		String message = "Choose link supertype";
	
		return (LinkReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static ModelElementEndpointReference selectModelElementTypeEndpointToCreate(LinkReference linkRef, List<String> modelElemTypeEndpointUris) throws MultiModelDialogCancellation {

		MultiModelTreeSelectionDialog dialog = MultiModelTypeRegistry.getModelElementEndpointCreationDialog(linkRef, modelElemTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose model type endpoint role";
	
		return (ModelElementEndpointReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static boolean getBooleanInput(String dialogTitle, String dialogMessage) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		return MessageDialog.openQuestion(shell, dialogTitle, dialogMessage);
	}

	/**
	 * Shows an input dialog to get text from the user.
	 * 
	 * @param dialogTitle
	 *            The dialog title.
	 * @param dialogMessage
	 *            The dialog message.
	 * @param dialogInitial TODO
	 * @return The text input from the user.
	 * @throws MultiModelDialogCancellation
	 *             If the text input was not completed for any reason.
	 */
	public static String getStringInput(String dialogTitle, String dialogMessage, String dialogInitial) throws MultiModelDialogCancellation {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog = new InputDialog(shell, dialogTitle, dialogMessage, dialogInitial, null);

		if (dialog.open() == Window.CANCEL) {
			throw new MultiModelDialogCancellation();
		}

		return dialog.getValue();
	}

	//TODO MMINT[MISC] merge with getStringInput()
	public static String getBigStringInput(String dialogTitle, String dialogMessage, String dialogInitial) throws MultiModelDialogCancellation {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog = new InputDialog(shell, dialogTitle, dialogMessage, dialogInitial, null) {
			@Override
			protected int getInputTextStyle() {
				return SWT.MULTI | SWT.BORDER;
			}
			@Override
			protected Control createDialogArea(Composite parent) {
				Control res = super.createDialogArea(parent);
				((GridData) this.getText().getLayoutData()).heightHint = 150;
				((GridData) this.getText().getLayoutData()).widthHint = 700;
				return res;
			}
		};

		if (dialog.open() == Window.CANCEL) {
			throw new MultiModelDialogCancellation();
		}

		return dialog.getValue();
	}

	public static String[] getConstraintInput(String dialogTitle, String dialogInitial) throws MultiModelDialogCancellation {

		String text = getBigStringInput(dialogTitle, "Insert new constraint in the format \"language: constraint\"", dialogInitial);
		String[] constraint = new String[2];
		int separatorIndex = text.indexOf(CONSTRAINT_LANGUAGE_SEPARATOR);
		if (separatorIndex == -1) {
			constraint[0] = "OCL";
			constraint[1] = text;
		}
		else {
			constraint[0] = text.substring(0, separatorIndex);
			constraint[1] = text.substring(separatorIndex + 1);
		}
		constraint[0] = constraint[0].trim();
		constraint[1] = constraint[1].trim();

		return constraint;
	}

}
