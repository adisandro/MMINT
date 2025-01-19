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
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNChangeImpact extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .allMatch(o -> o instanceof PLGSNArgumentElement e &&
                       e.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()).isEmpty());
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var modelObjs = arg0.stream()
      .map(DSemanticDecorator.class::cast)
      .map(DSemanticDecorator::getTarget)
      .map(PLGSNArgumentElement.class::cast)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(modelObjs.get(0));
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLGSNChangeImpactCommand(sDomain, modelObjs));
  }

  private class PLGSNChangeImpactCommand extends RecordingCommand {
    List<PLGSNArgumentElement> plModelObjs;

    public PLGSNChangeImpactCommand(TransactionalEditingDomain domain, List<PLGSNArgumentElement> plModelObjs) {
      super(domain);
      this.plModelObjs = plModelObjs;
    }

    @Override
    protected void doExecute() {
      try {
        for (var plModelObj : this.plModelObjs) {
          var startStep = GSNFactory.eINSTANCE.createImpactStep();
          //startStep.setImpacted(plModelObj);
          startStep.impact("change");
        }
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error running PL change impact", e);
      }
    }
  }
}
