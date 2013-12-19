/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.editor.impl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmtf.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends EditorImpl implements Diagram {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.DIAGRAM;
	}

	/**
	 * @generated NOT
	 */
	public Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Diagram newDiagramType = EditorFactory.eINSTANCE.createDiagram();
		addSubtype(newDiagramType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName);

		return newDiagramType;
	}

	/**
	 * @generated NOT
	 */
	public Editor createInstance(String modelUri, MultiModel containerMultiModel) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		// check if editor file already exists in model directory
		if (MultiModelUtils.isFileOrDirectory(MultiModelUtils.replaceFileExtensionInUri(modelUri, getFileExtensions().get(0)), true) != null) {
			if (!(boolean) MMTF.getSetting(MMTFConstants.SETTING_MENU_DIAGRAMS_CREATION_ENABLED)) {
				throw new MMTFException("Diagram creation not enabled by setting");
			}
			// try to build a new diagram through its wizard, inited with the existing model file
			IStructuredSelection modelFile = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(modelUri)
				)
			);
			EditorCreationWizardDialog wizDialog;
			wizDialog = super.invokeInstanceWizard(modelFile);
			if (wizDialog == null) {
				throw new MMTFException("Diagram creation canceled by user");
			}
		}
		Editor newEditor = EditorFactory.eINSTANCE.createDiagram();
		super.addInstance(newEditor, modelUri, containerMultiModel);

		return newEditor;
	}

	/**
	 * @generated NOT
	 */
	public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		IWorkbenchWizard wizard = super.getInstanceWizard(initialSelection);
		EditorCreationWizardDialog wizDialog;
		if (getWizardDialogClass() == null) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			if (initialSelection.getFirstElement() instanceof IFile) {
				String modelUri = MultiModelUtils.prependWorkspaceToUri(
					((IFile) initialSelection.getFirstElement()).getFullPath().toOSString()
				);
				String diagramUri = MultiModelUtils.replaceFileExtensionInUri(modelUri, getFileExtensions().get(0));
				String diagramKind = MultiModelTypeRegistry.getType(getModelUri()).getName();
				String diagramPluginId = MultiModelTypeRegistry.getTypeBundle(getUri()).getSymbolicName();
				// create the diagram directly and do not open the wizard
				try {
					GMFDiagramUtils.createGMFDiagram(modelUri, diagramUri, diagramKind, diagramPluginId);
					GMFDiagramUtils.openGMFDiagram(diagramUri, getId());
				}
				catch (Exception e) {
					throw new MMTFException("Error creating or opening the gmf diagram", e);
				}
				return new EditorCreationWizardDialog(shell, wizard);
			}
			else {
				wizDialog = new EditorCreationWizardDialog(shell, wizard);
			}
		}
		else {
			wizDialog = super.createCustomInstanceWizard(wizard);
		}
		wizDialog.setTitle(wizard.getWindowTitle());
		if (wizDialog.open() == Window.CANCEL) {
			return null;
		}

		return wizDialog;
	}

} //DiagramImpl
