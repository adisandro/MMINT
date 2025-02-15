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
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Template;

public class InstantiateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (!(modelObj instanceof ArgumentElement templateElem)) {
      return false;
    }
    var template = templateElem.getTemplate();
    if (template == null || template.getElements().stream().allMatch(e -> e.isValid())) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var template = ((ArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget()).getTemplate();
    var sSession = SessionManager.INSTANCE.getSession(template);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new InstantiateTemplateCommand(sDomain, template));
  }

  private class InstantiateTemplateCommand extends RecordingCommand {
    Template template;

    public InstantiateTemplateCommand(TransactionalEditingDomain domain, Template template) {
      super(domain);
      this.template = template;
    }

    @Override
    protected void doExecute() {
      try {
        this.template.instantiate();
        this.template.validate();
      }
      catch (MIDDialogCancellation e) {}
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error instantiating GSN template " + this.template.getId(), e);
      }
      /**TODO MMINT[GSN]
       *  Delete links and delete template when deleting argument elements
       *  FilesJustification?
       *  Fix prop decomposition chain re-instantiation
       */
    }
  }
}
