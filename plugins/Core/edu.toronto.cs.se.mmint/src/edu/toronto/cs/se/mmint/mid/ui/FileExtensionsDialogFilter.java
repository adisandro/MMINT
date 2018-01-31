/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class FileExtensionsDialogFilter extends ViewerFilter {

    private List<String> fileExtensions;

    public FileExtensionsDialogFilter(List<String> fileExtensions) {

        super();
        this.fileExtensions = fileExtensions;
    }

    /**
	 * {@inheritDoc} Filters file extensions.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

	    if (element instanceof IFolder) {
	        if (((IFolder) element).getName().startsWith(".")) {
	            return false;
	        }
	        else {
	            return true;
	        }
	    }
	    if (!(element instanceof IFile)) {
	        return true;
	    }

		return this.fileExtensions.contains(((IFile) element).getFileExtension());
	}

}
