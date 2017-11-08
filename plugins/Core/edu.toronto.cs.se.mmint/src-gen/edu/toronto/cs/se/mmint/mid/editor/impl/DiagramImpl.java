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

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
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
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
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

        //TODO MMINT[EDITOR] Add parameter to distinguish when the diagram file should be created instaad of guessing (like Model.createInstance)
        String editorUri = null;
        if (this.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) { // Sirius
            //TODO MMINT[SIRIUS] Open the modeling project if not open
            //TODO MMINT[SIRIUS] Create the representation file if it does not exist
            //TODO MMINT[SIRIUS] Optimize the choice of a default representation file (from model up? root?)
            //TODO MMINT[SIRIUS] e.g. filter repr files that have the model as semantic resource
            //TODO MMINT[SIRIUS] Test: a) how to add viewpoints to the project b) how to import/create into an empty repr.aird
            //TODO MMINT[SIRIUS] Remove the diagram representation when deleting the model
            String sFileUri = null;
            boolean isImported = false;
            try {
                sFileUri = MIDDialogs.selectSiriusRepresentationsFileToContainModelDiagram(modelUri);
            }
            catch (MIDDialogCancellation e) {
                throw e;
            }
            finally {
                // we can be here after creating or importing a model, the currently open Eclipse editor is the key
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                IEditorPart pageEditor = page.getActiveEditor();
                if (!pageEditor.getEditorInput().getName().endsWith(GMFUtils.DIAGRAM_SUFFIX)) { // the model was created
                    // close the tree editor that was used to create the model
                    page.closeEditor(pageEditor, false);
                    if (sFileUri == null) { // cancellation
                        // delete the created file and refresh
                        FileUtils.deleteFile(modelUri, true);
                        try {
                            WorkspaceSynchronizer.getFile(instanceMID.eResource()).getParent()
                                .refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
                        }
                        catch (CoreException e) {
                            // don't refresh
                        }
                    }
                }
                else { // the model was imported
                    isImported = true;
                    // either continue or exit with the exception if canceled
                }
            }
            String modelExt = FileUtils.getFileExtensionFromPath(modelUri);
            Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sFileUri, true),
                                                                  new NullProgressMonitor());
            if (isImported) { // find existing sirius diagram
                DAnalysis sRoot = (DAnalysis) sSession.getSessionResource().getContents().get(0);
viewpoints:
                for (DView sView : sRoot.getOwnedViews()) {
                    if (!sView.getViewpoint().getModelFileExtension().equals(modelExt)) {
                        continue;
                    }
                    for (DRepresentationDescriptor sReprDesc : sView.getOwnedRepresentationDescriptors()) {
                        if (!sReprDesc.getDescription().getName().equals(this.getUri()) ||
                            !MIDRegistry.getModelElementUri(sReprDesc.getTarget()).startsWith(modelUri)
                        ) {
                            continue;
                        }
                        editorUri = MIDRegistry.getModelElementUri(sReprDesc.getRepresentation());
                        break viewpoints;
                    }
                }
                if (editorUri == null) { // no existing sirius diagram found
                    // fallback to other editor by failing
                    throw new MMINTException("Sirius diagram not found");
                }
            }
            else { // create a new sirius diagram
                // get the model root from the sirius session
                EObject modelRootObj = null;
                for (Resource resource : sSession.getSemanticResources()) {
                    if (resource.getURI().toPlatformString(true).equals(modelUri)) {
                        modelRootObj = resource.getContents().get(0);
                        break;
                    }
                }
                // create a new sirius representation within an emf transaction
                Collection<RepresentationDescription> sDescs = DialectManager.INSTANCE
                    .getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false), modelRootObj);
                CreateRepresentationCommand sCmd = new CreateRepresentationCommand(
                    sSession, sDescs.iterator().next(), modelRootObj, FileUtils.getFileNameFromPath(modelUri),
                    new NullProgressMonitor());
                sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
                editorUri = MIDRegistry.getModelElementUri(sCmd.getCreatedRepresentation());
            }
        }
        else { // GMF
            editorUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
            if (!FileUtils.isFileOrDirectory(editorUri, true)) { // create a new diagram file
                //TODO MMINT[EDITOR] Use new signature to prevent doing this in certain cases (e.g. fallback from failed sirius diagram)
                IStructuredSelection modelFile = new StructuredSelection(
                    ResourcesPlugin.getWorkspace().getRoot().getFile(
                        new Path(modelUri)
                    )
                );
                EditorCreationWizardDialog wizDialog = this.invokeInstanceWizard(modelFile);
                if (wizDialog == null) {
                    throw new MIDDialogCancellation();
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
            if (initialSelection.getFirstElement() instanceof IFile) {
                // create the diagram directly and do not open the wizard
                String modelUri = ((IFile) initialSelection.getFirstElement()).getFullPath().toOSString();
                String diagramUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
                Diagram superDiagramType = this;
                while (superDiagramType.getSupertype() != null && superDiagramType.getSupertype() != MIDTypeHierarchy.getRootEditorType()) {
                    superDiagramType = (Diagram) superDiagramType.getSupertype();
                }
                String diagramKind = MIDTypeRegistry.getType(superDiagramType.getModelUri()).getName();
                String diagramPluginId = MIDTypeRegistry.getTypeBundle(superDiagramType.getUri()).getSymbolicName();
                try {
                    GMFUtils.createGMFDiagramAndFile(modelUri, diagramUri, diagramKind, diagramPluginId, true);
                    if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED))) {
                        FileUtils.openEclipseEditor(diagramUri, this.getId(), true);
                    }
                }
                catch (Exception e) {
                    throw new MMINTException("Error creating or opening the gmf diagram", e);
                }
                return new EditorCreationWizardDialog(wizard);
            }
            else {
                wizDialog = new EditorCreationWizardDialog(wizard);
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
