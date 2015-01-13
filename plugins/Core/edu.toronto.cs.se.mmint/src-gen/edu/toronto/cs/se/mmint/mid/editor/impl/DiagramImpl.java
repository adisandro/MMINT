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
package edu.toronto.cs.se.mmint.mid.editor.impl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

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
	public Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Diagram newDiagramType = EditorFactory.eINSTANCE.createDiagram();
		addSubtype(newDiagramType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName);

		return newDiagramType;
	}

	/**
	 * @generated NOT
	 */
	public Editor createInstance(String modelUri, MultiModel containerMultiModel) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		// check if diagram file already exists in model directory
		if (!MultiModelUtils.isFileOrDirectory(MultiModelUtils.replaceFileExtensionInUri(modelUri, getFileExtensions().get(0)), true)) {
			if (!Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_DIAGRAMS_CREATION_ENABLED))) {
				throw new MMINTException("Diagram creation not enabled by setting");
			}
			// try to build a new diagram through its wizard, inited with the existing model file
			IStructuredSelection modelFile = new StructuredSelection(
				ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(modelUri)
				)
			);
			EditorCreationWizardDialog wizDialog;
			wizDialog = invokeInstanceWizard(modelFile);
			if (wizDialog == null) {
				throw new MMINTException("Diagram creation canceled by user");
			}
		}
		Editor newEditor = EditorFactory.eINSTANCE.createDiagram();
		super.addInstance(newEditor, modelUri, containerMultiModel);

		return newEditor;
	}

	/**
	 * @generated NOT
	 */
	public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		IWorkbenchWizard wizard = super.getInstanceWizard(initialSelection);
		EditorCreationWizardDialog wizDialog;
		if (getWizardDialogClass() == null) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			if (initialSelection.getFirstElement() instanceof IFile) {
				String modelUri = ((IFile) initialSelection.getFirstElement()).getFullPath().toOSString();
				String diagramUri = MultiModelUtils.replaceFileExtensionInUri(modelUri, getFileExtensions().get(0));
				String diagramKind = MultiModelTypeRegistry.getType(getModelUri()).getName();
				String diagramPluginId = MultiModelTypeRegistry.getTypeBundle(getUri()).getSymbolicName();
				// create the diagram directly and do not open the wizard
				try {
					GMFDiagramUtils.createGMFDiagram(modelUri, diagramUri, diagramKind, diagramPluginId, true);
					GMFDiagramUtils.openGMFDiagram(diagramUri, getId(), true);
				}
				catch (Exception e) {
					throw new MMINTException("Error creating or opening the gmf diagram", e);
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
