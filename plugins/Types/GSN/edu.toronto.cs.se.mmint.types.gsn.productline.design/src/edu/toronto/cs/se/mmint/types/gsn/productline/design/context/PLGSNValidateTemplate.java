/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.design.context;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNValidateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (!(modelObj instanceof PLGSNArgumentElement plTemplateElem) ||
        plTemplateElem.getReference(GSNPackage.eINSTANCE.getArgumentElement_Templates()).isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plTemplateElem = (PLGSNArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var plTemplates = plTemplateElem.getStreamOfReference(GSNPackage.eINSTANCE.getArgumentElement_Templates())
      .map(c -> (PLGSNTemplate) c)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(plTemplateElem);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new GSNPLValidateTemplateCommand(sDomain, plTemplates));
  }

  private class GSNPLValidateTemplateCommand extends RecordingCommand {
    List<PLGSNTemplate> plTemplates;

    public GSNPLValidateTemplateCommand(TransactionalEditingDomain domain, List<PLGSNTemplate> plTemplates) {
      super(domain);
      this.plTemplates = plTemplates;
    }

    @Override
    protected void doExecute() {
      var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
      var title = "Validate Template";
      for (var plTemplate : this.plTemplates) {
        var message = "The GSN template " +
                      String.join(",", plTemplate.getAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id())) + " is ";
        try {
          plTemplate.validate();
          MessageDialog.openInformation(shell, title, message + "instantiated correctly");
        }
        catch (Exception e) {
          MMINTException.print(IStatus.ERROR, message + "not instantiated correctly", e);
        }
      }
    }
  }
}
