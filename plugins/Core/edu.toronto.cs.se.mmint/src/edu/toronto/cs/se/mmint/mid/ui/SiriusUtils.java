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
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.DeleteRepresentationCommand;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;

import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusUtils {

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
        EObject modelRootObj = null;
        for (Resource resource : sSession.getSemanticResources()) {
            if (resource.getURI().toPlatformString(true).equals(modelPath)) {
                modelRootObj = resource.getContents().get(0);
                break;
            }
        }
        if (modelRootObj == null) {
            //TODO MMINT[SIRIUS] Is it ever the case that the model resource is not automatically in the session?
        }
        // create a new sirius representation within an emf transaction
        Collection<RepresentationDescription> sDescs = DialectManager.INSTANCE
            .getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false), modelRootObj);
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
        Set<DRepresentationDescriptor> sReprDescs = new HashSet<>(); // TODO MMINT[JAVA9] Set.of()
        sReprDescs.add(sReprDesc);
        DeleteRepresentationCommand sCmd = new DeleteRepresentationCommand(sSession, sReprDescs);
        sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
    }

}
