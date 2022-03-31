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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.ContainerStyle;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.NodeStyle;
import org.eclipse.sirius.viewpoint.RGBValues;
import org.eclipse.ui.IEditorPart;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusHighlighter {

  public enum Color {
    BLACK   (RGBValues.create(0, 0, 0)),
    GRAY    (RGBValues.create(128, 128, 128)),
    SILVER  (RGBValues.create(192, 192, 192)),
    WHITE   (RGBValues.create(255, 255, 255)),
    MAROON  (RGBValues.create(128, 0, 0)),
    RED     (RGBValues.create(255, 0, 0)),
    OLIVE   (RGBValues.create(128, 128, 0)),
    YELLOW  (RGBValues.create(255, 255, 0)),
    GREEN   (RGBValues.create(0, 128, 0)),
    LIME    (RGBValues.create(0, 255, 0)),
    TEAL    (RGBValues.create(0, 128, 128)),
    AQUA    (RGBValues.create(0, 255, 255)),
    NAVY    (RGBValues.create(0, 0, 128)),
    BLUE    (RGBValues.create(0, 0, 255)),
    PURPLE  (RGBValues.create(128, 0, 128)),
    FUCHSIA (RGBValues.create(255, 0, 255));
    public final RGBValues rgb;
    Color(RGBValues rgb) {
      this.rgb = rgb;
    }
  }

  private static void highlight(DDiagramElement sDiagramElem, Set<String> modelObjUris, Color color) {
    if (sDiagramElem instanceof DDiagramElementContainer sContainerElem) {
      for (var sContainedElem : sContainerElem.getElements()) {
        highlight(sContainedElem, modelObjUris, color);
      }
    }
    if (!modelObjUris.contains(MIDRegistry.getModelElementUri(sDiagramElem.getTarget()))) {
      return;
    }
    var style = sDiagramElem.getStyle();
    if (style instanceof NodeStyle nodeStyle) {
      nodeStyle.setLabelColor(color.rgb);
    }
    else if (style instanceof ContainerStyle containerStyle) {
      containerStyle.setLabelColor(color.rgb);
    }
    else if (style instanceof EdgeStyle edgeStyle) {
      edgeStyle.setStrokeColor(color.rgb);
    }
  }

  public static IEditorPart highlight(Model model, Set<String> modelObjUris, Color color) throws Exception {
    var editorPart = model.openInstance();
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

    return editorPart;
  }
}
