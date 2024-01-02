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
 */
package edu.toronto.cs.se.mmint.mid.diagram.menu;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class MMINTOpenTypeMIDMenu extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		String typeMIDPath = MMINT.TYPEMID_FILENAME + GMFUtils.DIAGRAM_SUFFIX;
		if (!FileUtils.isFileInState(typeMIDPath)) {
			createTypeMIDDiagram();
		}
		try {
			FileUtils.openEclipseEditorInState(typeMIDPath, MIDDiagramEditor.ID);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Error opening Type MID diagram", e);
		}

		return null;
	}

	public static void createTypeMIDDiagram() {

		String typeMIDPath = FileUtils.prependStatePath(MMINT.TYPEMID_FILENAME);
		String typeMIDDiagramPath = typeMIDPath + GMFUtils.DIAGRAM_SUFFIX;
		try {
			GMFUtils.createGMFDiagramAndFile(typeMIDPath, typeMIDDiagramPath, MIDEditPart.MODEL_ID, MIDDiagramEditorPlugin.ID, false);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Error creating Type MID diagram", e);
		}
	}

}
