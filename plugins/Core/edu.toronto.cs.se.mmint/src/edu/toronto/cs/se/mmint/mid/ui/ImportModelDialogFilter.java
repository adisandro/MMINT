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
package edu.toronto.cs.se.mmint.mid.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;

public class ImportModelDialogFilter extends ViewerFilter {

	/**
	 * {@inheritDoc} Filters file extensions that are not registered with a
	 * model type.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		if (!(element instanceof IFile)) {
			return true;
		}

		return MultiModelTypeRegistry.getModelTypeFileExtensions().contains(((IFile) element).getFileExtension());
	}

}
