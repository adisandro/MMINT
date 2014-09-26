/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelTreeSelectionDialog;

public class MIDDiagramUtils {

	/**
	 * Shows a dialog to choose one among existing models and imports it.
	 * 
	 * @param relOnly
	 *            True to allow the selection of relationship files only, false
	 *            to allow all registered model files.
	 * @return The uri of the imported model.
	 * @throws MultiModelDialogCancellation
	 *             If the model import was not completed for any reason.
	 */
	public static String selectModelToImport(boolean relOnly) throws MultiModelDialogCancellation {
	
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MultiModelTreeSelectionDialog dialog = new MultiModelTreeSelectionDialog(
			shell,
			new WorkbenchLabelProvider(),
			new BaseWorkbenchContentProvider(),
			ResourcesPlugin.getWorkspace().getRoot()
		);
		//dialog.addFilter(filter);
		dialog.setValidator(new ImportModelDialogSelectionValidator());
		dialog.setTitle("Import model");
		dialog.setMessage("Choose model to import");
		dialog.setAllowMultiple(false);

		if (dialog.open() == Window.CANCEL) {
			throw new MultiModelDialogCancellation();
		}
		Object selection = dialog.getFirstResult();
		if (selection == null) {
			throw new MultiModelDialogCancellation();
		}
	
//		return dialog.getSelectedModelElementURI().toPlatformString(true);
		return URI.createPlatformResourceURI(((IFile) dialog.getOnlyResult()).getFullPath().toString(), true).toPlatformString(true);
	}

}
