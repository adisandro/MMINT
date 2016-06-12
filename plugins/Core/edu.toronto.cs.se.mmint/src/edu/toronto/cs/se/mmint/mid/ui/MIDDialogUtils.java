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
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
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
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
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
public class MIDDialogUtils {

	public final static String CONSTRAINT_LANGUAGE_SEPARATOR = ":";

	protected static Object openDialog(MIDTreeSelectionDialog dialog, String title, String message) throws MIDDialogCancellation {

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);
		if (dialog.open() == Window.CANCEL) {
			throw new MIDDialogCancellation();
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) { // dialog opened and nothing selected
			throw new MIDDialogCancellation();
		}

		return selection;
	}

	protected static Object openSelectionDialog(MIDTreeSelectionDialog dialog, String title, String message) throws MIDDialogCancellation {

		return openDialog(dialog, title, message);
	}

	protected static Object openSelectionDialogWithDefault(MIDTreeSelectionDialog dialog, String title, String message) throws MIDDialogCancellation {

		Object selection = dialog.getUniqueResult();
		if (selection == null) { // more than one choice possible, open the dialog
			selection = openDialog(dialog, title, message);
		}

		return selection;
	}

	/**
	 * Shows a tree dialog to select a model type choosing from the registered
	 * model types.
	 * 
	 * @return The choosen model type.
	 * @throws MIDDialogCancellation
	 *             If the selection was not completed for any reason.
	 */
	public static Model selectModelTypeToExtend(MID typeMID) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelTypeCreationDialog(typeMID);
		String title = "Create new light model type";
		String message = "Choose model supertype";

		return (Model) openSelectionDialogWithDefault(dialog, title, message);
	}

	/**
	 * Shows a tree dialog to select a model relationship type choosing from the
	 * registered model relationship types.
	 * 
	 * @return The choosen model relationship type.
	 * @throws MIDDialogCancellation
	 *             If the selection was not completed for any reason.
	 */
	public static ModelRel selectModelRelTypeToExtend(MID typeMID, Model srcModelType, Model tgtModelType) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelRelTypeCreationDialog(srcModelType, tgtModelType, typeMID);
		String title = "Create new light model relationship type";
		String message = "Choose model relationship supertype";

		return (ModelRel) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static MappingReference selectMappingTypeReferenceToExtend(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getMappingTypeReferenceCreationDialog(srcModelElemTypeRef, tgtModelElemTypeRef, modelRelType);
		String title = "Create new light link type";
		String message = "Choose link supertype";
	
		return (MappingReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static String selectWorkflowMIDToCreateOperatorType(MID typeMID) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getOperatorTypeCreationDialog(typeMID);
		String title = "Create new operator type from workflow";
		String message = "Choose Workflow MID";
		IFile workflowMIDFile = (IFile) openSelectionDialog(dialog, title, message);

		return workflowMIDFile.getFullPath().toString();
	}

	/**
	 * Shows a tree dialog to create a model choosing from the registered model
	 * types, and executes its wizard.
	 * 
	 * @param instanceMID
	 *            The Instance MID.
	 * @return The editor for the created model.
	 * @throws MIDDialogCancellation, MMINTException
	 *             If the model creation was not completed for any reason.
	 */
	public static Editor selectModelTypeToCreate(MID instanceMID) throws MIDDialogCancellation, MMINTException {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelCreationDialog();
		String title = "Create new model";
		String message = "Choose editor to create model";
		Editor editorType = (Editor) openSelectionDialog(dialog, title, message);
		IStructuredSelection midContainer;
		String midContainerUri = MIDUtils.replaceLastSegmentInUri(instanceMID.eResource().getURI().toPlatformString(true), "");
		try {
			midContainer = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path(midContainerUri)
				)
			);
		}
		catch (Exception e) {
			midContainer = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getProject(midContainerUri)
			);
		}
		EditorCreationWizardDialog wizDialog = editorType.invokeInstanceWizard(midContainer);
		if (wizDialog == null) {
			throw new MIDDialogCancellation();
		}

		return editorType.createInstance(wizDialog.getCreatedModelUri(), instanceMID);
	}

	/**
	 * Shows a dialog to choose one among existing models and imports it.
	 * 
	 * @param relOnly
	 *            True to allow the selection of relationship files only, false
	 *            to allow all registered model files.
	 * @return The uri of the imported model.
	 * @throws MIDDialogCancellation
	 *             If the model import was not completed for any reason.
	 */
	public static String selectModelToImport(boolean relOnly) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelImportDialog();
		String title = "Import model";
		String message = "Choose model to import";
		IFile modelFile = (IFile) openSelectionDialog(dialog, title, message);

		return modelFile.getFullPath().toString();
	}

	public static ModelRel selectModelRelTypeToCreate(Model srcModel, Model tgtModel) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelRelCreationDialog(srcModel, tgtModel);
		String title = "Create new model relationship";
		String message = "Choose model relationship type";

		return (ModelRel) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static ModelEndpointReference selectModelTypeEndpointToCreate(ModelRel modelRel, List<String> modelTypeEndpointUris, String modelEndpointId) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelEndpointCreationDialog(modelRel, modelTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose " + modelEndpointId + "model type endpoint role";

		return (ModelEndpointReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static MappingReference selectMappingTypeReferenceToCreate(ModelRel modelRel, ModelElementReference srcModelElemRef, ModelElementReference tgtModelElemRef) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getMappingReferenceCreationDialog(srcModelElemRef, tgtModelElemRef, modelRel);
		String title = "Create new link";
		String message = "Choose link type";

		return (MappingReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static ModelElementEndpointReference selectModelElementTypeEndpointToCreate(MappingReference mappingRef, List<String> modelElemTypeEndpointUris) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getModelElementEndpointCreationDialog(mappingRef, modelElemTypeEndpointUris);
		String title = "Create new model endpoint";
		String message = "Choose model type endpoint role";
	
		return (ModelElementEndpointReference) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static GenericElement selectGenericTypeToCreate(GenericEndpoint genericSuperTypeEndpoint, EList<OperatorInput> inputs) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getGenericTypeCreationDialog(genericSuperTypeEndpoint, inputs);
		String title = "Run generic operator";
		String message = "Choose generic type <" + genericSuperTypeEndpoint.getName() + ">";
	
		return (GenericElement) openSelectionDialogWithDefault(dialog, title, message);
	}

	public static Model selectWorkflowModelTypeToCreate(MID workflowMID) throws MIDDialogCancellation, MMINTException {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getWorkflowModelCreationDialog();
		String title = "Create new initial workflow model";
		String message = "Choose model type";

		return (Model) openSelectionDialog(dialog, title, message);
	}

	public static ModelRel selectWorkflowModelRelTypeToCreate(Model srcModel, Model tgtModel) throws MIDDialogCancellation {

		MIDTreeSelectionDialog dialog = MIDTypeRegistry.getWorkflowModelRelCreationDialog(srcModel, tgtModel);
		String title = "Create new initial workflow model relationship";
		String message = "Choose model relationship type";

		return (ModelRel) openSelectionDialogWithDefault(dialog, title, message);
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
	 * @throws MIDDialogCancellation
	 *             If the text input was not completed for any reason.
	 */
	public static String getStringInput(String dialogTitle, String dialogMessage, String dialogInitial) throws MIDDialogCancellation {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog = new InputDialog(shell, dialogTitle, dialogMessage, dialogInitial, null);

		if (dialog.open() == Window.CANCEL) {
			throw new MIDDialogCancellation();
		}

		return dialog.getValue();
	}

	//TODO MMINT[MISC] merge with getStringInput()
	public static String getBigStringInput(String dialogTitle, String dialogMessage, String dialogInitial) throws MIDDialogCancellation {

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
			throw new MIDDialogCancellation();
		}

		return dialog.getValue();
	}

	public static String[] getConstraintInput(String dialogTitle, String dialogInitial) throws MIDDialogCancellation {

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
