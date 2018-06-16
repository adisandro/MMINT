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
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.DeleteRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusUtils {

    public final static String DEFAULT_REPRESENTATIONS_FILE = "representations" + MMINT.MODEL_FILEEXTENSION_SEPARATOR +
                                                              SiriusUtil.SESSION_RESOURCE_EXTENSION;

    public static @Nullable DRepresentationDescriptor findRepresentationDescriptor(@NonNull String modelPath,
                                                                                   @NonNull String diagramTypeUri,
                                                                                   @NonNull String sAirdPath) {

        Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                              new NullProgressMonitor());
        String modelExt = FileUtils.getFileExtensionFromPath(modelPath);
        DAnalysis sRoot = (DAnalysis) sSession.getSessionResource().getContents().get(0);
        for (DView sView : sRoot.getOwnedViews()) {
            if (!sView.getViewpoint().getModelFileExtension().equals(modelExt)) {
                continue;
            }
            for (DRepresentationDescriptor sReprDesc : sView.getOwnedRepresentationDescriptors()) {
                if (sReprDesc.getDescription().getName().equals(diagramTypeUri) &&
                    MIDRegistry.getModelUri(sReprDesc.getTarget()).equals(modelPath)
                ) {
                    return sReprDesc;
                }
            }
        }

        return null;
    }

    /**
     * Creates a new Sirius representation.
     *
     * @param modelPath
     *            The path of the model for which we are creating the representation.
     * @param sAirdPath
     *            The path of the Sirius representations file that contains the model resource.
     * @return The created Sirius representation.
     */
    public static @NonNull DRepresentation createRepresentation(@NonNull String modelPath, @NonNull String sAirdPath) {

        // get the model root from the sirius session
        Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                              new NullProgressMonitor());
        URI modelUri = FileUtils.createEMFUri(modelPath, true);
        EObject modelRootObj = null;
        Resource modelResource = sSession.getTransactionalEditingDomain().getResourceSet().getResource(modelUri, false);
        if (modelResource == null) { // add the model resource to the session
            AddSemanticResourceCommand sCmd = new AddSemanticResourceCommand(sSession, modelUri,
                                                                             new NullProgressMonitor());
            sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
            modelResource = sSession.getTransactionalEditingDomain().getResourceSet().getResource(modelUri, false);
        }
        modelRootObj = modelResource.getContents().get(0);

        // create a new sirius representation within an emf transaction
        Collection<RepresentationDescription> sDescs = DialectManager.INSTANCE
            .getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false), modelRootObj);
        if (sDescs.isEmpty()) { // add the viewpoint to the session
            String modelExt = FileUtils.getFileExtensionFromPath(modelPath);
            List<Viewpoint> sViewpoints = ViewpointRegistry.getInstance().getViewpoints().stream()
                .filter(sViewpoint -> sViewpoint.getModelFileExtension().equals(modelExt))
                .collect(Collectors.toList());
            final EObject modelRootObj2 = modelRootObj;
            sSession.getTransactionalEditingDomain().getCommandStack().execute(
                new RecordingCommand(sSession.getTransactionalEditingDomain()) {
                    @Override
                    protected void doExecute() {
                        SiriusResourceHelper.createViews(
                           sSession, sViewpoints, sSession.getTransactionalEditingDomain().getResourceSet(),
                           modelRootObj2);
                    }
                }
            );
            sDescs = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(
                sSession.getSelectedViewpoints(false), modelRootObj);
        }
        CreateRepresentationCommand sCmd = new CreateRepresentationCommand(
            sSession, sDescs.iterator().next(), modelRootObj, FileUtils.getFileNameFromPath(modelPath),
            new NullProgressMonitor());
        sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);

        return sCmd.getCreatedRepresentation();
    }

    public static void openRepresentation(@NonNull String sReprUri) throws Exception {

        String sAirdPath = MIDRegistry.getModelUri(sReprUri);
        Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                              new NullProgressMonitor());
        DRepresentation sRepr = (DRepresentation) FileUtils.readModelObject(sReprUri, sSession.getSessionResource());
        DialectUIManager.INSTANCE.openEditor(sSession, sRepr, new NullProgressMonitor());
    }

    public static void deleteRepresentation(@NonNull Diagram diagram) {

        String sReprUri = diagram.getUri();
        String sAirdPath = MIDRegistry.getModelUri(sReprUri);
        Session sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                              new NullProgressMonitor());
        DRepresentationDescriptor sReprDesc = SiriusUtils
            .findRepresentationDescriptor(diagram.getModelUri(), diagram.getMetatypeUri(), sAirdPath);
        if (sReprDesc == null) {
            return;
        }
        DeleteRepresentationCommand sCmd = new DeleteRepresentationCommand(sSession, Set.of(sReprDesc));
        sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
    }

}
