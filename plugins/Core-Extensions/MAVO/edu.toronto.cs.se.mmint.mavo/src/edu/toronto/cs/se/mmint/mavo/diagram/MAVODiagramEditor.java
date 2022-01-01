/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.diagram;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

import edu.toronto.cs.se.mmint.mavo.diagram.outline.MAVODiagramOutlinePage;

public class MAVODiagramEditor extends DiagramDocumentEditor {

	private MAVODiagramOutlinePage outlinePage;

	public MAVODiagramEditor(boolean hasFlyoutPalette) {

		super(hasFlyoutPalette);
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class type) {

		if (type == IContentOutlinePage.class) {
			outlinePage = new MAVODiagramOutlinePage(getDiagram());
			return outlinePage;
		}

		return super.getAdapter(type);
	}

	public MAVODiagramOutlinePage getOutlinePage() {

		return outlinePage;
	}

}
