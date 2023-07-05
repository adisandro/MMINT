/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.gsn.templates.design.tools;

import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class CreateFilesContext extends CreateTemplateElement {

  @Override
  protected CreateTemplateElementCommand createCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
    return new CreateFilesContextCommand(domain, safetyCase);
  }

  private class CreateFilesContextCommand extends CreateTemplateElementCommand {

    public CreateFilesContextCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain, new GSNTemplatesBuilder(safetyCase));
    }

    @Override
    protected void create() throws Exception {
      var builder = (GSNTemplatesBuilder) this.builder;
      var dialog = new MIDTreeSelectionDialog(new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider(),
                                              ResourcesPlugin.getWorkspace().getRoot());
      var resource = (IResource) MIDDialogs.openTreeDialog(dialog, "Create Files Context",
                                                           "Select a file or directory");
      var path = resource.getFullPath().toString();
      builder.createFilesContext("", path, List.of(FileUtils.prependWorkspacePath(path)));
    }
  }
}
