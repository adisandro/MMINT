/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.edit.parts.MIDEditPart;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;

public class MIDDiagramUtils {

	public static @NonNull Map<MID, List<IFile>> getInstanceMIDsInWorkspace() {

		Map<MID, List<IFile>> mids = new HashMap<>();
		for (IEditorReference editorReference : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			String editorName = editorReference.getName();
			if (editorName.endsWith(MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME + GMFUtils.DIAGRAM_SUFFIX)) {
				MIDDiagramEditor midDiagram = (MIDDiagramEditor) editorReference.getEditor(true);
				MID mid = (MID) midDiagram.getDiagram().getElement();
				if (!mid.isInstancesLevel()) {
					continue;
				}
				List<IFile> midFiles = new ArrayList<>();
				IFile diagramFile = (IFile) midDiagram.getEditorInput().getAdapter(IFile.class);
				if (diagramFile == null) {
					continue;
				}
				midFiles.add(diagramFile);
				try {
					midFiles.add(GMFUtils.getModelFileFromDiagramFile(diagramFile));
				}
				catch (Exception e) {
					MMINTException.print(IStatus.WARNING, "Can't add model file of MID " + diagramFile.getName(), e);
				}
				mids.put(mid, midFiles);
			}
		}

		return mids;
	}

	public static List<IFile> getActiveInstanceMIDFiles() {

		List<IFile> files = new ArrayList<>();
		IFile instanceMIDFile = MMINT.getActiveInstanceMIDFile();
		if (instanceMIDFile != null) {
			files.add(instanceMIDFile);
			try {
				files.add(GMFUtils.getModelFileFromDiagramFile(instanceMIDFile));
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Can't add model file of diagram " + instanceMIDFile.getName() + " for gmf transactional command", e);
			}
		}

		return files;
	}

	public static Node createModelShortcut(Model model, View gmfDiagramRoot) throws Exception {

		return GMFUtils.createGMFNodeShortcut(model, gmfDiagramRoot, MIDDiagramEditorPlugin.ID, MIDEditPart.MODEL_ID);
	}

}
