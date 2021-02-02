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
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.context;

import java.util.Set;
import java.util.stream.Collectors;

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
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class RelContextHighlightModelEndpointListener extends MIDContextMenuListener {
  private ModelEndpointReference modelEndpointRef;
  private RGBValues highlightColor;

  public RelContextHighlightModelEndpointListener(String menuLabel, ModelEndpointReference modelEndpointRef,
                                                  RGBValues highlightColor) {
    super(menuLabel);
    this.modelEndpointRef = modelEndpointRef;
    this.highlightColor = highlightColor;
  }

  private void highlight(DDiagramElement sDiagramElem, Set<String> modelElemUris) {
    if (sDiagramElem instanceof DNodeContainer) {
      for (var sContainedDiagramElem : ((DNodeContainer) sDiagramElem).getOwnedDiagramElements()) {
        highlight(sContainedDiagramElem, modelElemUris);
      }
    }
    if (!modelElemUris.contains(MIDRegistry.getModelElementUri(sDiagramElem.getTarget()))) {
      return;
    }
    var style = sDiagramElem.getStyle();
    if (style instanceof NodeStyle) {
      ((NodeStyle) style).setLabelColor(this.highlightColor);
    }
    else if (style instanceof ContainerStyle) {
      ((ContainerStyle) style).setLabelColor(this.highlightColor);
    }
    else if (style instanceof EdgeStyle) {
      ((EdgeStyle) style).setStrokeColor(this.highlightColor);
    }
  }

  @Override
  public void widgetSelected(SelectionEvent event) {
    try {
      var model = this.modelEndpointRef.getObject().getTarget();
      model.openInstance();
      var modelElemUris = this.modelEndpointRef.getModelElemRefs().stream()
        .map(mer -> MIDRegistry.getModelObjectUri(mer.getObject()))
        .collect(Collectors.toSet());
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
                  highlight(sDiagElem, modelElemUris);
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
