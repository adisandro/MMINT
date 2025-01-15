/*******************************************************************************
 * Copyright (c) 2012, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusUtils {

  public final static String DEFAULT_REPR_FILE = "representations" + MMINT.MODEL_FILEEXTENSION_SEPARATOR +
                                                 SiriusUtil.SESSION_RESOURCE_EXTENSION;

  public static @Nullable DRepresentationDescriptor findRepresentationDescriptor(String modelPath,
                                                                                 String diagramTypeUri,
                                                                                 String sAirdPath) {
    var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                      new NullProgressMonitor());
    var modelExt = FileUtils.getFileExtensionFromPath(modelPath);
    var sRoot = (DAnalysis) sSession.getSessionResource().getContents().get(0);
    for (var sView : sRoot.getOwnedViews()) {
      if (!sView.getViewpoint().getModelFileExtension().equals(modelExt)) {
        continue;
      }
      for (var sReprDesc : sView.getOwnedRepresentationDescriptors()) {
        if (MIDRegistry.getModelUri(sReprDesc.getTarget()).equals(modelPath) ) {
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
    var sDescs = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false),
                                                                                rootModelObj);
    if (sDescs.isEmpty()) { // add the viewpoint to the session
      var modelExt = FileUtils.getFileExtensionFromPath(modelPath);
      var sViewpoints = ViewpointRegistry.getInstance().getViewpoints().stream()
        .filter(sViewpoint -> sViewpoint.getModelFileExtension().equals(modelExt))
        .collect(Collectors.toList());
      final var modelRootObj2 = rootModelObj;
      sSession.getTransactionalEditingDomain().getCommandStack().execute(
        new RecordingCommand(sSession.getTransactionalEditingDomain()) {
          @Override
          protected void doExecute() {
            SiriusResourceHelper.createViews(sSession, sViewpoints,
                                             sSession.getTransactionalEditingDomain().getResourceSet(), modelRootObj2);
          }
        }
      );
      sDescs = DialectManager.INSTANCE.getAvailableRepresentationDescriptions(sSession.getSelectedViewpoints(false),
                                                                              rootModelObj);
    }
    var sCmd2 = new CreateRepresentationCommand(sSession, sDescs.iterator().next(), rootModelObj,
                                                FileUtils.getFileNameFromPath(modelPath), new NullProgressMonitor());
    sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd2);

    return sCmd2.getCreatedRepresentation();
  }

  public static IEditorPart openRepresentation(String sReprUri) throws Exception {
    var sAirdPath = MIDRegistry.getModelUri(sReprUri);
    var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                      new NullProgressMonitor());
    var sRepr = (DRepresentation) FileUtils.readModelObject(sReprUri, sSession.getSessionResource());

    return DialectUIManager.INSTANCE.openEditor(sSession, sRepr, new NullProgressMonitor());
  }

  public static void closeRepresentations(@Nullable IWorkbenchWindow window, Set<IEditorPart> editorParts) {
    if (window == null) {
      window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    }
    var shell = window.getShell();
    editorParts.forEach(h -> DialectUIManager.INSTANCE.closeEditor(h, false));
    // closing the sirius editor is not done yet on return
    // wait in a ui loop like in org.eclipse.jface.window.Window#runEventLoop
    while (editorParts.contains(window.getActivePage().getActivePart())) {
      if (!shell.getDisplay().readAndDispatch()) {
        shell.getDisplay().sleep();
      }
    }
  }

  public static void deleteRepresentation(Diagram diagram) {
    var sReprUri = diagram.getUri();
    var sAirdPath = MIDRegistry.getModelUri(sReprUri);
    var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                      new NullProgressMonitor());
    var sReprDesc = findRepresentationDescriptor(diagram.getModelUri(), diagram.getMetatypeUri(), sAirdPath);
    if (sReprDesc == null) {
      return;
    }
    var sCmd = new DeleteRepresentationCommand(sSession, Set.of(sReprDesc));
    sSession.getTransactionalEditingDomain().getCommandStack().execute(sCmd);
  }

  public static boolean isSirius(Editor editor) {
    return editor instanceof Diagram diagram &&
           diagram.getFileExtensions().get(0).equals(SiriusUtil.SESSION_RESOURCE_EXTENSION);
  }

  public static boolean hasSiriusDiagram(Model model) {
    return model.getEditors().stream().anyMatch(e -> isSirius(e));
  }
}
