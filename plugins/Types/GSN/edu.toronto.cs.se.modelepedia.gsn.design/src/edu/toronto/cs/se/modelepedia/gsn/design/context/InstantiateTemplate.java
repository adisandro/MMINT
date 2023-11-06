/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
    if (!(modelObj instanceof ArgumentElement templateElem) || templateElem.getTemplates().isEmpty()) {
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
       *  Chain the instantiated template if an element was selected
       *  Select template from file if multiple templates are present?
       *  How is repair different from instantiate? (no instantiation and wrong instantiation are both invalid)
       *  Review prop decomposition with import+instantiate pipeline:
       *   1) instantiate would need gsn builder support for element change and removal
       *   2) who invokes validate now for import?
       */
    }
  }
}
