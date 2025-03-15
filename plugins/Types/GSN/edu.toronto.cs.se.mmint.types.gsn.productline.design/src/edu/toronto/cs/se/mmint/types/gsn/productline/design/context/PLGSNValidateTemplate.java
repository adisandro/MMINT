/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
        plTemplateElem.getReference(GSNPackage.eINSTANCE.getArgumentElement_Template()).isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plTemplateElem = (PLGSNArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var plTemplate = (PLGSNTemplate) plTemplateElem.getReference(GSNPackage.eINSTANCE.getArgumentElement_Template())
                                                   .get(0);
    var sSession = SessionManager.INSTANCE.getSession(plTemplateElem);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new GSNPLValidateTemplateCommand(sDomain, plTemplate));
  }

  private class GSNPLValidateTemplateCommand extends RecordingCommand {
    PLGSNTemplate plTemplate;

    public GSNPLValidateTemplateCommand(TransactionalEditingDomain domain, PLGSNTemplate plTemplate) {
      super(domain);
      this.plTemplate = plTemplate;
    }

    @Override
    protected void doExecute() {
      var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
      var title = "Validate Template";
      var message = "The GSN template " +
                    this.plTemplate.getAttribute(GSNPackage.eINSTANCE.getTemplate_Id()).get(0) + " is ";
      try {
        this.plTemplate.validate();
        MessageDialog.openInformation(shell, title, message + "instantiated correctly");
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, message + "not instantiated correctly", e);
      }
    }
  }
}
