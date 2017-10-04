/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
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
    @Override
    public Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMINTException {

        MMINTException.mustBeType(this);

        Diagram newDiagramType = super.createThisEClass();
        this.addSubtype(newDiagramType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName);

        return newDiagramType;
    }

    /**
     * @generated NOT
     */
    @Override
    public Editor createInstance(String modelUri, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);

        String editorUri = modelUri;
        if (this.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) { // Sirius
            //TODO[SIRIUS] Create the representation file if it does not exist
            //TODO[SIRIUS] Optimize the choice of a default representation file (from model up? root?)
            //TODO[SIRIUS] e.g. filter repr files that have the model as semantic resource
            String siriusFileUri = MIDDialogs.selectModelDiagramToImport(modelUri);
            String modelExt = FileUtils.getFileExtensionFromPath(modelUri);
            Session siriusSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(siriusFileUri, true),
                                                                       new NullProgressMonitor());
            //TODO[SIRIUS] Add new diagram to the representation if it does not exist
            DAnalysis siriusRoot = (DAnalysis) siriusSession.getSessionResource().getContents().get(0);
viewpoints:
            for (DView siriusView : siriusRoot.getOwnedViews()) {
                if (!siriusView.getViewpoint().getModelFileExtension().equals(modelExt)) {
                    continue;
                }
                for (DRepresentationDescriptor siriusRepr : siriusView.getOwnedRepresentationDescriptors()) {
                    if (!siriusRepr.getDescription().getName().equals(this.getUri()) ||
                        !MIDRegistry.getModelElementUri(siriusRepr.getTarget()).startsWith(modelUri)
                    ) {
                        continue;
                    }
                    editorUri = MIDRegistry.getModelElementUri(siriusRepr.getRepresentation());
                    break viewpoints;
                }
            }
        }
        else { // GMF
            editorUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
            // check if diagram file already exists in model directory
            if (!FileUtils.isFileOrDirectory(editorUri, true)) {
                // try to build a new diagram through its wizard, inited with the existing model file
                IStructuredSelection modelFile = new StructuredSelection(
                    ResourcesPlugin.getWorkspace().getRoot().getFile(
                        new Path(modelUri)
                    )
                );
                EditorCreationWizardDialog wizDialog = this.invokeInstanceWizard(modelFile);
                if (wizDialog == null) {
                    throw new MMINTException("Diagram creation canceled by user");
                }
            }
        }
        Diagram newDiagram = super.createThisEClass();
        super.addInstance(newDiagram, editorUri, modelUri, instanceMID);

        return newDiagram;
    }

    /**
     * @generated NOT
     */
    @Override
    public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMINTException {

        MMINTException.mustBeType(this);

        IWorkbenchWizard wizard = super.getInstanceWizard(initialSelection);
        EditorCreationWizardDialog wizDialog;
        if (this.getWizardDialogClass() == null) {
            Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
            if (initialSelection.getFirstElement() instanceof IFile) {
                String modelUri = ((IFile) initialSelection.getFirstElement()).getFullPath().toOSString();
                String diagramUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
                Diagram superDiagramType = this;
                while (superDiagramType.getSupertype() != null && superDiagramType.getSupertype() != MIDTypeHierarchy.getRootEditorType()) {
                    superDiagramType = (Diagram) superDiagramType.getSupertype();
                }
                String diagramKind = MIDTypeRegistry.getType(superDiagramType.getModelUri()).getName();
                String diagramPluginId = MIDTypeRegistry.getTypeBundle(superDiagramType.getUri()).getSymbolicName();
                // create the diagram directly and do not open the wizard
                try {
                    GMFUtils.createGMFDiagramAndFile(modelUri, diagramUri, diagramKind, diagramPluginId, true);
                    if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED))) {
                        FileUtils.openEclipseEditor(diagramUri, this.getId(), true);
                    }
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
