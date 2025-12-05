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
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNInstantiateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (!(modelObj instanceof PLGSNArgumentElement plTemplateElem)) {
      return false;
    }
    var plTemplates = plTemplateElem.getReference(GSNPackage.eINSTANCE.getArgumentElement_Template());
    if (plTemplates.isEmpty() ||
        plTemplates.get(0).getStreamOfReference(GSNPackage.eINSTANCE.getTemplate_Elements())
          .flatMap(c -> c.getStreamOfAttribute(GSNPackage.eINSTANCE.getArgumentElement_Valid()))
          .allMatch(v -> Boolean.valueOf(v))) {
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
    sDomain.getCommandStack().execute(new GSNPLInstantiateTemplateCommand(sDomain, plTemplate));
  }

  private class GSNPLInstantiateTemplateCommand extends RecordingCommand {
    PLGSNTemplate plTemplate;

    public GSNPLInstantiateTemplateCommand(TransactionalEditingDomain domain, PLGSNTemplate plTemplate) {
      super(domain);
      this.plTemplate = plTemplate;
    }

    @Override
    protected void doExecute() {
      try {
        this.plTemplate.instantiate();
        this.plTemplate.validate();
      }
      catch (MIDDialogCancellation e) {}
      catch (Exception e) {
        var id = this.plTemplate.getListOfAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id()).get(0);
        MMINTException.print(IStatus.ERROR, "Error instantiating GSN template " + id, e);
      }
    }
  }
}
