/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.DeleteRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusUtils {

    public final static String DEFAULT_REPRESENTATIONS_FILE = "representations" + MMINT.MODEL_FILEEXTENSION_SEPARATOR +
                                                              SiriusUtil.SESSION_RESOURCE_EXTENSION;

    public static @Nullable DRepresentationDescriptor findRepresentationDescriptor(String modelPath,
                                                                                   String diagramTypeUri,
                                                                                   String sAirdPath) {

        var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                          new NullProgressMonitor());
        String modelExt = FileUtils.getFileExtensionFromPath(modelPath);
        var sRoot = (DAnalysis) sSession.getSessionResource().getContents().get(0);
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
     *          The path of the model for which to create the representation.
     * @param sAirdPath
     *          The path of the Sirius representations file that will contain the new representation.
     * @return The created Sirius representation.
     * @throws Exception
     *           If the model can't be loaded.
     */
    public static DRepresentation createRepresentation(String modelPath, String sAirdPath) throws Exception {

        // get the model root from the sirius session
        var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                          new NullProgressMonitor());
        var modelUri = FileUtils.createEMFUri(modelPath, true);
        var sCmd = new AddSemanticResourceCommand(sSession, modelUri, new NullProgressMonitor());
        sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
        var rootModelObj = FileUtils.readModelFile(modelPath, sSession.getTransactionalEditingDomain().getResourceSet(),
                                                   true);
        // create a new sirius representation within an emf transaction
        var sDescs = DialectManager.INSTANCE
            .getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false), rootModelObj);
        if (sDescs.isEmpty()) { // add the viewpoint to the session
            String modelExt = FileUtils.getFileExtensionFromPath(modelPath);
            var sViewpoints = ViewpointRegistry.getInstance().getViewpoints().stream()
                .filter(sViewpoint -> sViewpoint.getModelFileExtension().equals(modelExt))
                .collect(Collectors.toList());
            final var modelRootObj2 = rootModelObj;
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
                sSession.getSelectedViewpoints(false), rootModelObj);
        }
        var sCmd2 = new CreateRepresentationCommand(sSession, sDescs.iterator().next(), rootModelObj,
                                                   FileUtils.getFileNameFromPath(modelPath), new NullProgressMonitor());
        sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd2);

        return sCmd2.getCreatedRepresentation();
    }

    public static void openRepresentation(@NonNull String sReprUri) throws Exception {

        String sAirdPath = MIDRegistry.getModelUri(sReprUri);
        var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                              new NullProgressMonitor());
        var sRepr = (DRepresentation) FileUtils.readModelObject(sReprUri, sSession.getSessionResource());
        DialectUIManager.INSTANCE.openEditor(sSession, sRepr, new NullProgressMonitor());
    }

    public static void deleteRepresentation(@NonNull Diagram diagram) {

        var sReprUri = diagram.getUri();
        String sAirdPath = MIDRegistry.getModelUri(sReprUri);
        var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
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
