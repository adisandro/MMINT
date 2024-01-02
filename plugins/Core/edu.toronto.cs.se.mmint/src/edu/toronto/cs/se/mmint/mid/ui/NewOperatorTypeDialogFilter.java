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
package edu.toronto.cs.se.mmint.mid.ui;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class NewOperatorTypeDialogFilter extends FileExtensionsDialogFilter {

  public NewOperatorTypeDialogFilter(Set<String> fileExtensions) {
    super(fileExtensions);
  }

  /**
   * {@inheritDoc} Filters Workflow MID files.
   */
  @Override
  public boolean select(Viewer viewer, Object parentElement, Object element) {
    if (!super.select(viewer, parentElement, element)) {
      return false;
    }
    if (!(element instanceof IFile)) {
      return true;
    }
    try {
      MID mid = (MID) FileUtils.readModelFile(((IFile) element).getFullPath().toString(), null, true);
      return mid.isWorkflowsLevel();
    }
    catch (Exception e) {
      return false;
    }
  }

}
