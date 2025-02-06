/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.design.context.PLGSNChangeImpact.PLGSNChangeImpactCommand;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

public class PLGSNRepairChange extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .allMatch(o -> o instanceof PLGSNArgumentElement e &&
                       !e.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()).isEmpty() &&
                       e.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()).stream()
                         .anyMatch(s -> !s.getAttribute(GSNPackage.eINSTANCE.getImpactAnnotation_Type()).get(0)
                                          .equals(ImpactType.REUSE.toString())));
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plModelObjs = arg0.stream()
      .map(DSemanticDecorator.class::cast)
      .map(DSemanticDecorator::getTarget)
      .map(PLGSNArgumentElement.class::cast)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(plModelObjs.get(0));
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLGSNRepairChangeCommand(sDomain, plModelObjs));
    sDomain.getCommandStack().execute(new PLGSNChangeImpactCommand(sDomain, plModelObjs));
  }

  private class PLGSNRepairChangeCommand extends RecordingCommand {
    List<PLGSNArgumentElement> plModelObjs;

    public PLGSNRepairChangeCommand(TransactionalEditingDomain domain, List<PLGSNArgumentElement> plModelObjs) {
      super(domain);
      this.plModelObjs = plModelObjs;
    }

    @Override
    protected void doExecute() {
      try {
        for (var plModelObj : this.plModelObjs) {
          var templates = plModelObj.getReference(GSNPackage.eINSTANCE.getArgumentElement_Templates());
          if (templates.isEmpty()) {
            continue;
          }
          ((PLGSNTemplate) templates.get(0)).repair("RECHECK");
        }
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error repairing PL change", e);
      }
    }
  }
}
