/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Template;

public class ValidateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (!(modelObj instanceof ArgumentElement templateElem) || templateElem.getTemplate() == null) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var template = ((ArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget()).getTemplate();
    var sSession = SessionManager.INSTANCE.getSession(template);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new ValidateTemplateCommand(sDomain, template));
  }

  private class ValidateTemplateCommand extends RecordingCommand {
    Template template;

    public ValidateTemplateCommand(TransactionalEditingDomain domain, Template template) {
      super(domain);
      this.template = template;
    }

    @Override
    protected void doExecute() {
      var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
      var title = "Validate Template";
      var message = "The GSN template " + this.template.getId() + " is ";
      try {
        this.template.validate();
        MessageDialog.openInformation(shell, title, message + "instantiated correctly");
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, message + "not instantiated correctly", e);
      }
    }
  }
}
