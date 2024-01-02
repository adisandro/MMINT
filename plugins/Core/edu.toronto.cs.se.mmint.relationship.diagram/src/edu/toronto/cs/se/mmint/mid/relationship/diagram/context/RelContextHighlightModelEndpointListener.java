/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusHighlighter;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusHighlighter.Color;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class RelContextHighlightModelEndpointListener extends MIDContextMenuListener {
  private ModelEndpointReference modelEndpointRef;
  private Color color;

  public RelContextHighlightModelEndpointListener(String menuLabel, ModelEndpointReference modelEndpointRef,
                                                  Color color) {
    super(menuLabel);
    this.modelEndpointRef = modelEndpointRef;
    this.color = color;
  }

  @Override
  public void widgetSelected(SelectionEvent event) {
    var model = this.modelEndpointRef.getObject().getTarget();
    var modelObjUris = this.modelEndpointRef.getModelElemRefs().stream()
      .map(mer -> MIDRegistry.getModelObjectUri(mer.getObject()))
      .collect(Collectors.toSet());
    try {
      SiriusHighlighter.highlight(model, modelObjUris, this.color);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Model endpoint highlighting failed", e);
    }
  }
}
