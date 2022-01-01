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
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class FileExtensionsDialogFilter extends ViewerFilter {

  private Set<String> fileExtensions;

  public FileExtensionsDialogFilter(Set<String> fileExtensions) {
    super();
    this.fileExtensions = fileExtensions;
  }

  /**
   * {@inheritDoc} Filters file extensions.
   */
  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (element instanceof IResource && ((IResource) element).getName().startsWith(".")) {
      return false;
    }
    if (!(element instanceof IFile)) {
      return true;
    }
    return this.fileExtensions.contains(((IFile) element).getFileExtension());
  }

}
