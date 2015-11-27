/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MIDDiagramUtils {

	public static @NonNull Map<MultiModel, List<IFile>> getMIDsInWorkspace() {

		Map<MultiModel, List<IFile>> mids = new HashMap<>();
		for (IEditorReference editorReference : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			String editorName = editorReference.getName();
			if (editorName.endsWith(MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME + GMFDiagramUtils.DIAGRAM_SUFFIX)) {
				MIDDiagramEditor midDiagram = (MIDDiagramEditor) editorReference.getEditor(true);
				MultiModel mid = (MultiModel) midDiagram.getDiagram().getElement();
				List<IFile> midFiles = new ArrayList<>();
				IFile diagramFile = (IFile) midDiagram.getEditorInput().getAdapter(IFile.class);
				if (diagramFile == null) {
					continue;
				}
				midFiles.add(diagramFile);
				try {
					midFiles.add(GMFDiagramUtils.getModelIFile(diagramFile));
				}
				catch (Exception e) {
					MMINTException.print(IStatus.WARNING, "Can't add model file of MID " + diagramFile.getName(), e);
				}
				mids.put(mid, midFiles);
			}
		}

		return mids;
	}

	public static List<IFile> getTransactionalCommandAffectedFiles() {

		List<IFile> files = new ArrayList<>();
		IFile diagramFile = GMFDiagramUtils.getActiveMIDDiagramIFile();
		if (diagramFile != null) {
			files.add(diagramFile);
			try {
				files.add(GMFDiagramUtils.getModelIFile(diagramFile));
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Can't add model file of diagram " + diagramFile.getName() + " for gmf transactional command", e);
			}
		}

		return files;
	}

}
