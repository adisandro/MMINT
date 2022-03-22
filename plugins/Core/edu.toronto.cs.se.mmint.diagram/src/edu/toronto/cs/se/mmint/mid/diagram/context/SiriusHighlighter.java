/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.ContainerStyle;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.NodeStyle;
import org.eclipse.sirius.viewpoint.RGBValues;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusHighlighter {

  private static void highlight(DDiagramElement sDiagramElem, Set<String> modelObjUris, RGBValues color) {
    if (sDiagramElem instanceof DNodeContainer sContainerElem) {
      for (var sContainedElem : sContainerElem.getOwnedDiagramElements()) {
        highlight(sContainedElem, modelObjUris, color);
      }
    }
    if (!modelObjUris.contains(MIDRegistry.getModelElementUri(sDiagramElem.getTarget()))) {
      return;
    }
    var style = sDiagramElem.getStyle();
    if (style instanceof NodeStyle nodeStyle) {
      nodeStyle.setLabelColor(color);
    }
    else if (style instanceof ContainerStyle containerStyle) {
      containerStyle.setLabelColor(color);
    }
    else if (style instanceof EdgeStyle edgeStyle) {
      edgeStyle.setStrokeColor(color);
    }
  }

  public static void highlight(Model model, Set<String> modelObjUris, RGBValues color) {
    try {
      model.openInstance();
      var sAirdPath = MIDDialogs.selectSiriusRepresentationsFileToContainModelDiagram(model.getUri());
      var sSession = SessionManager.INSTANCE.getSession(FileUtils.createEMFUri(sAirdPath, true),
                                                        new NullProgressMonitor());
      var sSessionResource = sSession.getSessionResource();
      sSession.getTransactionalEditingDomain().getCommandStack().execute(
        new RecordingCommand(sSession.getTransactionalEditingDomain()) {
          @Override
          protected void doExecute() {
            for (var sView : sSession.getOwnedViews()) {
              for (var sRepr : sView.getOwnedRepresentationDescriptors()) {
                if (!model.getUri().equals(MIDRegistry.getModelUri(sRepr.getTarget()))) {
                  continue;
                }
                var sDiag = (DSemanticDiagram)
                  sSessionResource.getEObject(sRepr.getRepPath().getResourceURI().fragment());
                for (var sDiagElem : sDiag.getOwnedDiagramElements()) {
                  highlight(sDiagElem, modelObjUris, color);
                }
              }
            }
          }
        });
    }
    catch (MIDDialogCancellation e) {
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Highlighting failed", e);
    }
  }
}
