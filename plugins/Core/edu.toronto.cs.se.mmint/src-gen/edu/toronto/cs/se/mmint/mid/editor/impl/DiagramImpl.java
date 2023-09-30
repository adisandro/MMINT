/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.sirius.viewpoint.DRepresentation;
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

        String diagramUri = null;
        if (createDiagramFile) { // model created programmatically
            if (SiriusUtils.isSirius(this)) { // Sirius
                var sAirdPath = MIDDialogs.selectSiriusRepresentationsFile(modelPath);
                DRepresentation sRepr;
                try {
                  sRepr = SiriusUtils.createRepresentation(modelPath, sAirdPath);
                }
                catch (Exception e) {
                  throw new MMINTException("Unable to load model " + modelPath, e);
                }
                diagramUri = MIDRegistry.getModelElementUri(sRepr);
                if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.
                                                             PREFERENCE_MENU_OPENMODELEDITORS_ENABLED))) {
                    FileUtils.openEclipseEditor(diagramUri, this.getId(), true);
                }
            }
            else { // GMF
                diagramUri = FileUtils.replaceFileExtensionInPath(modelPath, this.getFileExtensions().get(0));
                var modelFile = new StructuredSelection(
                    ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelPath)));
                var wizDialog = this.invokeInstanceWizard(modelFile);
                if (wizDialog == null) {
                    throw new MIDDialogCancellation();
                }
            }
        }
        else { // model created or imported through an Instance MID
            if (SiriusUtils.isSirius(this)) { // Sirius
                //TODO MMINT[SIRIUS] Delete does not work sometimes
                //TODO MMINT[SIRIUS] Open the modeling project if not open
                //TODO MMINT[SIRIUS] Create the representation file if it does not exist
                var isImported = false;
                String sAirdPath = null;
                try {
                    sAirdPath = MIDDialogs.selectSiriusRepresentationsFile(modelPath);
                }
                catch (MMINTException e) {
                    throw e;
                }
                finally {
                    // the currently open Eclipse editor is the key to create vs import
                    var page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    var pageEditor = page.getActiveEditor();
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
                    var sReprDesc = SiriusUtils.findRepresentationDescriptor(modelPath, this.getUri(), sAirdPath);
                    if (sReprDesc == null) { // no existing sirius diagram found
                        // fallback to other editor by failing
                        throw new MMINTException("Sirius representation not found");
                    }
                    diagramUri = MIDRegistry.getModelElementUri(sReprDesc.getRepresentation());
                }
                else { // create a new sirius representation
                    DRepresentation sRepr;
                    try {
                      sRepr = SiriusUtils.createRepresentation(modelPath, sAirdPath);
                    }
                    catch (Exception e) {
                      throw new MMINTException("Unable to load model " + modelPath, e);
                    }
                    diagramUri = MIDRegistry.getModelElementUri(sRepr);
                    FileUtils.openEclipseEditor(diagramUri, this.getId(), true);
                }
            }
            else { // GMF
                diagramUri = FileUtils.replaceFileExtensionInPath(modelPath, this.getFileExtensions().get(0));
                if (!FileUtils.isFileOrDirectory(diagramUri, true)) {
                    // fallback to other editor by failing
                    throw new MMINTException("GMF diagram not found");
                }
            }
        }

        var newDiagram = super.<Diagram>createThisEClass();
        super.addInstance(newDiagram, diagramUri, modelPath, instanceMID);

        return newDiagram;
    }

    /**
     * @generated NOT
     */
    @Override
    public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMINTException {

        MMINTException.mustBeType(this);

        var wizard = super.getInstanceWizard(initialSelection);
        EditorCreationWizardDialog wizDialog;
        if (this.getWizardDialogClass() == null) {
            if (initialSelection.getFirstElement() instanceof IFile) {
                // create the diagram directly and do not open the wizard
                var modelUri = ((IFile) initialSelection.getFirstElement()).getFullPath().toOSString();
                String diagramUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
                Diagram superDiagramType = this;
                while (superDiagramType.getSupertype() != null && superDiagramType.getSupertype() != MIDTypeHierarchy.getRootEditorType()) {
                    superDiagramType = (Diagram) superDiagramType.getSupertype();
                }
                var diagramKind = MIDTypeRegistry.getType(superDiagramType.getModelUri()).getName();
                var diagramPluginId = MIDTypeRegistry.getTypeBundle(superDiagramType.getUri()).getSymbolicName();
                try {
                    GMFUtils.createGMFDiagramAndFile(modelUri, diagramUri, diagramKind, diagramPluginId, true);
                    if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.
                                                                 PREFERENCE_MENU_OPENMODELEDITORS_ENABLED))) {
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
