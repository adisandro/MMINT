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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
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

        String editorUri = null;
        if (this.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION)) { // Sirius
            //TODO MMINT[SIRIUS] Create the representation file if it does not exist
            //TODO MMINT[SIRIUS] Optimize the choice of a default representation file (from model up? root?)
            //TODO MMINT[SIRIUS] e.g. filter repr files that have the model as semantic resource
            //TODO MMINT[SIRIUS] Test: a) how to add viewpoints to the project b) how to import/create into an empty repr.aird
            String sFileUri = MIDDialogs.selectModelDiagramToImport(modelUri);
            String modelExt = FileUtils.getFileExtensionFromPath(modelUri);
            Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sFileUri, true),
                                                                       new NullProgressMonitor());
            DAnalysis sRoot = (DAnalysis) sSession.getSessionResource().getContents().get(0);
viewpoints:
            for (DView sView : sRoot.getOwnedViews()) {
                if (!sView.getViewpoint().getModelFileExtension().equals(modelExt)) {
                    continue;
                }
                for (DRepresentationDescriptor sRepr : sView.getOwnedRepresentationDescriptors()) {
                    if (!sRepr.getDescription().getName().equals(this.getUri()) ||
                        !MIDRegistry.getModelElementUri(sRepr.getTarget()).startsWith(modelUri)
                    ) {
                        continue;
                    }
                    // import existing sirius diagram
                    editorUri = MIDRegistry.getModelElementUri(sRepr.getRepresentation());
                    break viewpoints;
                }
                if (editorUri == null) { // create a new sirius diagram
                    // close the tree editor that was used to create the model
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    page.closeEditor(page.getActiveEditor(), false);
                    EObject modelRootObj = null;
                    for (Resource resource : sSession.getSemanticResources()) {
                        if (resource.getURI().toPlatformString(true).equals(modelUri)) {
                            modelRootObj = resource.getContents().get(0);
                            break;
                        }
                    }
                    Collection<RepresentationDescription> sDescs = DialectManager.INSTANCE
                        .getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false), modelRootObj);
                    DRepresentation sRepr = DialectManager.INSTANCE.createRepresentation(
                        FileUtils.getFileNameFromPath(modelUri), modelRootObj, sDescs.iterator().next(), sSession,
                        new NullProgressMonitor());
                    editorUri = MIDRegistry.getModelElementUri(sRepr);
                    break;
                }
            }
        }
        else { // GMF
            editorUri = FileUtils.replaceFileExtensionInPath(modelUri, this.getFileExtensions().get(0));
            if (!FileUtils.isFileOrDirectory(editorUri, true)) { // create a new diagram file
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
