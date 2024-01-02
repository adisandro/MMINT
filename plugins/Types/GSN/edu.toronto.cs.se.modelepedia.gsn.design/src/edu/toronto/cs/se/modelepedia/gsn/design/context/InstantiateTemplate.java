/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
import java.util.List;
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
    var templates = templateElem.getTemplates();
    if (templates.isEmpty() || templates.stream().flatMap(t -> t.getElements().stream()).allMatch(e -> e.isValid())) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var templates = ((ArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget()).getTemplates();
    var sSession = SessionManager.INSTANCE.getSession(templates.get(0));
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new InstantiateTemplateCommand(sDomain, templates));
  }

  private class InstantiateTemplateCommand extends RecordingCommand {
    List<Template> templates;

    public InstantiateTemplateCommand(TransactionalEditingDomain domain, List<Template> templates) {
      super(domain);
      this.templates = templates;
    }

    @Override
    protected void doExecute() {
      for (var template : this.templates) {
        try {
          template.instantiate();
          template.validate();
        }
        catch (MIDDialogCancellation e) {}
        catch (Exception e) {
          MMINTException.print(IStatus.ERROR, "Error instantiating GSN template " + template.getId(), e);
        }
      }
      /**TODO MMINT[GSN]
       *  Delete links and delete template when deleting argument elements
       *  FilesJustification?
       *  Fix prop decomposition chain re-instantiation
       */
    }
  }
}
