/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class MIDDiagramUtils {

	public static @NonNull Map<MID, List<IFile>> getInstanceMIDsInWorkspace() {

		Map<MID, List<IFile>> mids = new HashMap<>();
		for (IEditorReference editorReference : PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences()) {
			var editorName = editorReference.getName();
			if (editorName.endsWith(MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME + GMFUtils.DIAGRAM_SUFFIX)) {
				var midDiagram = (MIDDiagramEditor) editorReference.getEditor(true);
				var mid = (MID) midDiagram.getDiagram().getElement();
				if (!mid.isInstancesLevel()) {
					continue;
				}
				List<IFile> midFiles = new ArrayList<>();
				var diagramFile = midDiagram.getEditorInput().getAdapter(IFile.class);
				if (diagramFile == null) {
					continue;
				}
				midFiles.add(diagramFile);
				try {
					midFiles.add(GMFUtils.getModelFileFromDiagramFile(diagramFile));
				}
				catch (Exception e) {
					MMINTException.print(IStatus.INFO, "Can't add model file of MID " + diagramFile.getName(), e);
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
				MMINTException.print(IStatus.INFO, "Can't add model file of diagram " + instanceMIDFile.getName() + " for gmf transactional command", e);
			}
		}

		return files;
	}

	public static Model getInstanceMIDModelFromModelEditor(EObject modelObj) throws MMINTException {
    var modelPath = MIDRegistry.getModelUri(modelObj);
    for (var instanceMID : getInstanceMIDsInWorkspace().keySet()) {
      var model = instanceMID.<Model>getExtendibleElement(modelPath);
      if (model != null) {
        return model;
      }
    }
    throw new MMINTException("The MID editor containing this model must be among the open tabs");
	}

}
