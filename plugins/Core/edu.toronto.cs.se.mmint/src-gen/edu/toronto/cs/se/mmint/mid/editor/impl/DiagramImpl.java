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
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
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
import edu.toronto.cs.se.mmint.mid.ui.SiriusUtils;
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
     * Creates and adds a diagram instance of this diagram type to an Instance MID.
     *
     * @param modelPath
     *            The path of the model to be represented in the new diagram.
     * @param createDiagramFile
     *            True if the diagram file is going to be created, false if it exists already.
     * @param instanceMID
     *            An Instance MID.
     * @return The created diagram.
     * @throws MMINTException
     *             If this is a diagram instance, or if the diagram couldn't be created.
     * @generated NOT
     */
    @Override
    public Editor createInstance(String modelPath, boolean createDiagramFile, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);

        String editorUri = null;
        if (createDiagramFile) { // model created programmatically
            if (this.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) { // Sirius
                String sAirdPath = MIDDialogs.selectSiriusRepresentationsFileToContainModelDiagram(modelPath);
                editorUri = MIDRegistry.getModelElementUri(SiriusUtils.createRepresentation(modelPath, sAirdPath));
            }
            else { // GMF
                editorUri = FileUtils.replaceFileExtensionInPath(modelPath, this.getFileExtensions().get(0));
                IStructuredSelection modelFile = new StructuredSelection(
                    ResourcesPlugin.getWorkspace().getRoot().getFile(
                        new Path(modelPath)
                    )
                );
                EditorCreationWizardDialog wizDialog = this.invokeInstanceWizard(modelFile);
                if (wizDialog == null) {
                    throw new MIDDialogCancellation();
                }
            }
        }
        else { // model created or imported through an Instance MID
            if (this.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) { // Sirius
                //TODO MMINT[SIRIUS] Open the modeling project if not open
                //TODO MMINT[SIRIUS] Create the representation file if it does not exist
                //TODO MMINT[SIRIUS] Optimize the choice of a default representation file (from model up? root?)
                //TODO MMINT[SIRIUS] e.g. filter repr files that have the model as semantic resource
                //TODO MMINT[SIRIUS] Test: a) how to add viewpoints to the project b) how to import/create into an empty repr.aird
                String sAirdPath = null;
                boolean isImported = false;
                try {
                    sAirdPath = MIDDialogs.selectSiriusRepresentationsFileToContainModelDiagram(modelPath);
                }
                catch (MIDDialogCancellation e) {
                    throw e;
                }
                finally {
                    // the currently open Eclipse editor is the key to create vs import
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    IEditorPart pageEditor = page.getActiveEditor();
                    if (pageEditor.getEditorInput().getName().endsWith(GMFUtils.DIAGRAM_SUFFIX)) { // imported model
                        isImported = true;
                        // either continue or exit with the exception if canceled
                    }
                    else { // created model
                        page.closeEditor(pageEditor, false); // close the tree editor that was used to create the model
                        if (sAirdPath == null) { // dialog cancellation, delete the created file and refresh
                            FileUtils.deleteFile(modelPath, true);
                            try {
                                WorkspaceSynchronizer.getFile(instanceMID.eResource()).getParent()
                                    .refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
                            }
                            catch (CoreException e) {
                                // don't refresh
                            }
                        }
                    }
                }
                if (isImported) { // find existing sirius representation
                    DRepresentationDescriptor sReprDesc = SiriusUtils
                        .findRepresentationDescriptor(modelPath, this.getUri(), sAirdPath);
                    if (sReprDesc == null) { // no existing sirius diagram found
                        // fallback to other editor by failing
                        throw new MMINTException("Sirius representation not found");
                    }
                    editorUri = MIDRegistry.getModelElementUri(sReprDesc.getRepresentation());
                }
                else { // create a new sirius representation
                    editorUri = MIDRegistry.getModelElementUri(SiriusUtils.createRepresentation(modelPath, sAirdPath));
                }
            }
            else { // GMF
                editorUri = FileUtils.replaceFileExtensionInPath(modelPath, this.getFileExtensions().get(0));
                if (!FileUtils.isFileOrDirectory(editorUri, true)) {
                    // fallback to other editor by failing
                    throw new MMINTException("GMF diagram not found");
                }
            }
        }

        Diagram newDiagram = super.createThisEClass();
        super.addInstance(newDiagram, editorUri, modelPath, instanceMID);

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
