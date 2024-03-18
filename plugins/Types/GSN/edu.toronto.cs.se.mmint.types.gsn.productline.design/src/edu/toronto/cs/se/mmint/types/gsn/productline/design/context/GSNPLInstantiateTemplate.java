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
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.productline.PLUtils;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLTemplate;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNPLInstantiateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (!(modelObj instanceof GSNPLArgumentElement plTemplateElem)) {
      return false;
    }
    var plTemplates = PLUtils.getReference(plTemplateElem, GSNPackage.eINSTANCE.getArgumentElement_Templates());
    if (plTemplates.isEmpty() ||
        plTemplates.stream()
          .flatMap(t -> PLUtils.getStreamOfReferenceAsTarget(t, GSNPackage.eINSTANCE.getArgumentElement_Templates()))
          .flatMap(c -> PLUtils.getStreamOfAttribute(c, GSNPackage.eINSTANCE.getArgumentElement_Valid()))
          .allMatch(v -> Boolean.valueOf(v))) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plTemplateElem = (GSNPLArgumentElement) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var plTemplates = PLUtils.getStreamOfReference(plTemplateElem, GSNPackage.eINSTANCE.getArgumentElement_Templates())
      .map(c -> (GSNPLTemplate) c)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(plTemplateElem);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new GSNPLInstantiateTemplateCommand(sDomain, plTemplates));
  }

  private class GSNPLInstantiateTemplateCommand extends RecordingCommand {
    List<GSNPLTemplate> plTemplates;

    public GSNPLInstantiateTemplateCommand(TransactionalEditingDomain domain, List<GSNPLTemplate> plTemplates) {
      super(domain);
      this.plTemplates = plTemplates;
    }

    @Override
    protected void doExecute() {
      for (var plTemplate : this.plTemplates) {
        try {
          plTemplate.instantiate();
          plTemplate.validate();
        }
        catch (MIDDialogCancellation e) {}
        catch (Exception e) {
          var id = String.join(",", PLUtils.getAttribute(plTemplate, GSNPackage.eINSTANCE.getArgumentElement_Id()));
          MMINTException.print(IStatus.ERROR, "Error instantiating GSN template " + id, e);
        }
      }
    }
  }
}
