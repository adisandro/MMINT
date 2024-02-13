/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.ui.model.IWorkbenchAdapter;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

/**
 * A container for common functions of a Mid diagram.
 *
 * @author Alessio Di Sandro
 *
 */
public class MIDDialogs {

    //TODO MMINT[MISC] Remove double layer MIDDialogs + MIDTypeRegistry, and do filtering directly in content providers
	public final static String PROPERTY_LANGUAGE_SEPARATOR = ":";

	public static Object openTreeDialog(MIDTreeSelectionDialog dialog, String title, String message) throws MIDDialogCancellation {

		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.setAllowMultiple(false);
		if (dialog.open() == Window.CANCEL) {
			throw new MIDDialogCancellation();
		}
		var selection = dialog.getFirstResult();
		if (selection == null) { // dialog opened and nothing selected
			throw new MIDDialogCancellation();
		}

		return selection;
	}

	public static Object openTreeDialogWithDefault(MIDTreeSelectionDialog dialog, String title, String message)
	                     throws MIDDialogCancellation {
		var selection = dialog.getUniqueResult();
		if (selection == null) { // more than one choice possible, open the dialog
			selection = MIDDialogs.openTreeDialog(dialog, title, message);
		}
		return selection;
	}

	@SuppressWarnings("unchecked")
  public static <T> T openListDialog(String title, String message, Object input,
	                                   IStructuredContentProvider contentProvider, ILabelProvider labelProvider)
	                                  throws MIDDialogCancellation {
	  var results = contentProvider.getElements(input);
	  if (results.length == 1) {
	    return (T) results[0];
	  }
    var dialog = new ListDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
    dialog.setAddCancelButton(true);
    dialog.setTitle(title);
    dialog.setMessage(message);
    dialog.setContentProvider(contentProvider);
    dialog.setLabelProvider(labelProvider);
    dialog.setInput(input);
    if (dialog.open() == Window.CANCEL) {
      throw new MIDDialogCancellation();
    }

    return (T) dialog.getResult()[0];
	}

  @SuppressWarnings("unchecked")
  public static <T> List<T> openListMultipleDialog(String title, String message, T[] input,
                                                   ILabelProvider labelProvider) throws MIDDialogCancellation {
    var dialog = new ElementListSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                                                labelProvider);
    dialog.setTitle(title);
    dialog.setMessage(message);
    dialog.setMultipleSelection(true);
    dialog.setElements(input);
    if (dialog.open() == Window.CANCEL) {
      throw new MIDDialogCancellation();
    }

    return Arrays.asList((T[]) dialog.getResult());
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

		var dialog = MIDTypeRegistry.getModelTypeCreationDialog(typeMID);
		var title = "Create new light model type";
		var message = "Choose model supertype";

		return (Model) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
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

		var dialog = MIDTypeRegistry.getModelRelTypeCreationDialog(srcModelType, tgtModelType, typeMID);
		var title = "Create new light model relationship type";
		var message = "Choose model relationship supertype";

		return (ModelRel) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static MappingReference selectMappingTypeReferenceToExtend(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getMappingTypeReferenceCreationDialog(srcModelElemTypeRef, tgtModelElemTypeRef, modelRelType);
		var title = "Create new light mapping type";
		var message = "Choose mapping supertype";

		return (MappingReference) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static String selectWorkflowMIDToCreateOperatorType(MID typeMID) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getOperatorTypeCreationDialog(typeMID);
		var title = "Create new operator type from workflow";
		var message = "Choose Workflow MID";
		var workflowMIDFile = (IFile) MIDDialogs.openTreeDialog(dialog, title, message);

		return workflowMIDFile.getFullPath().toString();
	}

	public static @NonNull Operator selectOperatorTypeToOverride(@NonNull MID typeMID, @NonNull String workflowMIDPath,
	                                                             @NonNull String newOperatorName)
	                                                             throws MMINTException {

        NewOperatorTypeOverrideDialogContentProvider contentProvider;
        try {
            contentProvider = new NewOperatorTypeOverrideDialogContentProvider(workflowMIDPath, newOperatorName);
        }
        catch (Exception e) {
            throw new MMINTException("Error opening the Workflow MID", e);
        }
        var dialog = new MIDTreeSelectionDialog(new MIDDialogLabelProvider(), contentProvider,
                                                                   typeMID);
	    var title = "Create new operator type from workflow";
	    var message = "Other operators exist with the same name, you can select one of them to override";

	    return (Operator) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

  public static <T extends IReasoner> T selectReasoner(Set<T> reasoners, String traitDesc) throws MMINTException {
    if (reasoners.size() == 1) {
      return reasoners.iterator().next();
    }
    var title = "Choose reasoner";
    var message = "Select reasoner for " + traitDesc;
    var contentProvider = new ArrayContentProvider();
    var labelProvider = LabelProvider.createTextProvider(e -> ((IReasoner) e).getName());

    return openListDialog(title, message, reasoners, contentProvider, labelProvider);
  }

  public static <T extends IReasoner> T selectReasoner(Class<T> traitClass, String traitDesc,
                                                       @Nullable Object traitData) throws MMINTException {
    var reasoners = MMINT.getReasonersForTrait(traitClass, traitData);
    if (reasoners.isEmpty()) {
      throw new MMINTException("There are no reasoners installed that implement " + traitDesc);
    }

    return selectReasoner(reasoners, traitDesc);
	}

  public static String selectSiriusRepresentationsFile(String modelPath) throws MMINTException {
    // try a representations file next to the model first..
    var sAirdPath = FileUtils.replaceLastSegmentInPath(modelPath, SiriusUtils.DEFAULT_REPR_FILE);
    if (FileUtils.isFile(sAirdPath, true)) {
      return sAirdPath;
    }
    // ..or a representations file at the top level of the project
    Object dialogRoot;
    var project = FileUtils.getWorkspaceProject(modelPath);
    if (project == null) {
      dialogRoot = ResourcesPlugin.getWorkspace().getRoot();
      sAirdPath = SiriusUtils.DEFAULT_REPR_FILE;
    }
    else {
      dialogRoot = project;
      sAirdPath = project.getFullPath().toString() + IPath.SEPARATOR + SiriusUtils.DEFAULT_REPR_FILE;
    }
    if (!FileUtils.isFile(sAirdPath, true)) {
      throw new MMINTException("Representations file not found");
    }

    return sAirdPath;
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

        var dialog = MIDTypeRegistry.getMIDTreeTypeSelectionDialog(
            new MIDDialogLabelProvider(), new NewModelDialogContentProvider());
        dialog.setValidator(new NewModelDialogSelectionValidator());
		var title = "Create new model";
		var message = "Choose editor to create model";
		var editorType = (Editor) MIDDialogs.openTreeDialog(dialog, title, message);
		IStructuredSelection midContainer;
		String midContainerUri = FileUtils.replaceLastSegmentInPath(
		    instanceMID.eResource().getURI().toPlatformString(true), "");
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
		var wizDialog = editorType.invokeInstanceWizard(midContainer);
		if (wizDialog == null) {
			throw new MIDDialogCancellation();
		}

		return editorType.createInstance(wizDialog.getCreatedModelUri(), false, instanceMID);
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

		var dialog = MIDTypeRegistry.getModelImportDialog();
		var title = "Import model";
		var message = "Choose model to import";
		var modelFile = (IFile) MIDDialogs.openTreeDialog(dialog, title, message);

		return modelFile.getFullPath().toString();
	}

	public static ModelRel selectModelRelTypeToCreate(Model srcModel, Model tgtModel) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getModelRelCreationDialog(srcModel, tgtModel);
		var title = "Create new model relationship";
		var message = "Choose model relationship type";

		return (ModelRel) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static ModelEndpointReference selectModelTypeEndpointToCreate(ModelRel modelRel, List<String> modelTypeEndpointUris, String modelEndpointId) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getModelEndpointCreationDialog(modelRel, modelTypeEndpointUris);
		var title = "Create new model endpoint";
		var message = "Choose " + modelEndpointId + "model type endpoint role";

		return (ModelEndpointReference) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static Mapping selectMappingTypeToCreate(ModelRel modelRel, ModelElementReference srcModelElemRef, ModelElementReference tgtModelElemRef) throws MIDDialogCancellation {

        var modelRelType = modelRel.getMetatype();
        var dialog = new MIDTreeSelectionDialog(
            new MIDDialogLabelProvider(),
            new NewMappingDialogContentProvider(modelRelType, srcModelElemRef, tgtModelElemRef),
            modelRelType
        );
		var title = "Create new mapping";
		var message = "Choose mapping type";

		return (Mapping) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static ModelElementEndpointReference selectModelElementTypeEndpointToCreate(MappingReference mappingRef, List<String> modelElemTypeEndpointUris) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getModelElementEndpointCreationDialog(mappingRef, modelElemTypeEndpointUris);
		var title = "Create new model endpoint";
		var message = "Choose model type endpoint role";

		return (ModelElementEndpointReference) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static GenericElement selectGenericTypeToCreate(GenericEndpoint genericSuperTypeEndpoint, EList<OperatorInput> inputs) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getGenericTypeCreationDialog(genericSuperTypeEndpoint, inputs);
		var title = "Run generic operator";
		var message = "Choose type <" + genericSuperTypeEndpoint.getName() + "> of operator " +
			((Operator) genericSuperTypeEndpoint.eContainer()).getName();

		return (GenericElement) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static Model selectWorkflowModelTypeToCreate(MID workflowMID) throws MIDDialogCancellation, MMINTException {

		var dialog = MIDTypeRegistry.getWorkflowModelCreationDialog();
		var title = "Create new initial workflow model";
		var message = "Choose model type";

		return (Model) MIDDialogs.openTreeDialog(dialog, title, message);
	}

	public static ModelRel selectWorkflowModelRelTypeToCreate(Model srcModel, Model tgtModel) throws MIDDialogCancellation {

		var dialog = MIDTypeRegistry.getWorkflowModelRelCreationDialog(srcModel, tgtModel);
		var title = "Create new initial workflow model relationship";
		var message = "Choose model relationship type";

		return (ModelRel) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
	}

	public static boolean getBooleanInput(String dialogTitle, String dialogMessage) {

		var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

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
	public static String getStringInput(String dialogTitle, String dialogMessage, @Nullable String dialogInitial) throws MIDDialogCancellation {

		var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		var dialog = new InputDialog(shell, dialogTitle, dialogMessage, dialogInitial, null);

		if (dialog.open() == Window.CANCEL) {
			throw new MIDDialogCancellation();
		}

		return dialog.getValue();
	}

	//TODO MMINT[MISC] merge with getStringInput()
	public static String getBigStringInput(String dialogTitle, String dialogMessage, @Nullable String dialogInitial) throws MIDDialogCancellation {

		var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog = new InputDialog(shell, dialogTitle, dialogMessage, dialogInitial, null) {
			@Override
			protected int getInputTextStyle() {
				return SWT.MULTI | SWT.BORDER;
			}
			@Override
			protected Control createDialogArea(Composite parent) {
				var res = super.createDialogArea(parent);
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

  public static String[] getPropertyInput(String title, String message, String initial) throws Exception {
    var input = MIDDialogs.getBigStringInput(title, message, initial);
    if (input.isBlank()) {
      throw new MMINTException("Empty input");
    }
    input = input.strip();
    var property = new String[2];
    var separator = input.indexOf(MIDDialogs.PROPERTY_LANGUAGE_SEPARATOR);
    if (separator == -1) {
      throw new MMINTException("Missing separator '" + MIDDialogs.PROPERTY_LANGUAGE_SEPARATOR +
                               "' between language and property");
    }
    property[0] = input.substring(0, separator).strip();
    property[1] = input.substring(separator + 1).strip();

    return property;
  }

	public static String[] getConstraintInput(String dialogTitle, String dialogInitial) throws MIDDialogCancellation {

		var text = MIDDialogs.getBigStringInput(dialogTitle, "Insert new constraint in the format \"language: constraint\"", dialogInitial);
		var constraint = new String[2];
		var separatorIndex = text.indexOf(MIDDialogs.PROPERTY_LANGUAGE_SEPARATOR);
		if (separatorIndex == -1) {
			constraint[0] = "ocl";
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

	private static IItemLabelProvider getModelObjectItemLabelProvider(EObject modelObj) {
	  var description = List.of(modelObj.eClass().getEPackage(), IItemLabelProvider.class);
	  return (IItemLabelProvider) ComposedAdapterFactory.Descriptor.Registry.INSTANCE.getDescriptor(description)
      .createAdapterFactory()
      .adapt(modelObj, IItemLabelProvider.class);
	}

	public static <T> T selectModelObject(String title, String message, EList<T> modelObjects)
                                       throws MIDDialogCancellation {
    var labelProvider = LabelProvider.createTextImageProvider(
      o -> getModelObjectItemLabelProvider((EObject) o).getText(o),
      o -> ExtendedImageRegistry.INSTANCE.getImage(getModelObjectItemLabelProvider((EObject) o).getImage(o)));

    return MIDDialogs.openListDialog(title, message, modelObjects, new ArrayContentProvider(), labelProvider);
  }

  public static String selectFile(String title, String message, String emptyMessage, Set<String> fileExtensions)
                                 throws Exception {
    var files = new ArrayList<IFile>();
    IResourceVisitor visitor = (var resource) -> {
      var binFolders = Set.of("bin", "target");
      if (resource instanceof IFolder folder && binFolders.contains(folder.getName())) {
        return false;
      }
      if (resource instanceof IFile file && file.getFileExtension() != null &&
          fileExtensions.contains(file.getFileExtension())) {
        files.add(file);
      }
      return true;
    };
    ResourcesPlugin.getWorkspace().getRoot().accept(visitor);
    if (files.isEmpty()) {
      throw new MMINTException(emptyMessage);
    }
    var imageManager = new LocalResourceManager(JFaceResources.getResources());
    var labelProvider = LabelProvider.createTextImageProvider(
      f -> ((IFile) f).getFullPath().toString(),
      f -> imageManager.get(Adapters.adapt(f, IWorkbenchAdapter.class).getImageDescriptor(f)));
    var file = MIDDialogs.<IFile>openListDialog(title, message, files, new ArrayContentProvider(), labelProvider);
    imageManager.dispose(); // images are not automatically garbage collected

    return file.getFullPath().toString();
  }
}
