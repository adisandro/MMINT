/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class NewOperatorTypeDialogFilter extends ViewerFilter {

	/**
	 * {@inheritDoc} Filters Workflow MID files.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (!(element instanceof IFile)) {
			return true;
		}
		IFile file = (IFile) element;
		if (!file.getFileExtension().equals(MIDPackage.eNAME)) {
			return false;
		}
		try {
			MID mid = (MID) FileUtils.readModelFile(file.getFullPath().toString(), true);
			return mid.isWorkflowsLevel();
		}
		catch (Exception e) {
			return false;
		}
	}

}
