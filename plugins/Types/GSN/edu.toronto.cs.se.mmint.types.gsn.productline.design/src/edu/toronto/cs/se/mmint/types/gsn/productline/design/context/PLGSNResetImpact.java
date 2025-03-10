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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.util.ChangeStep;

public class PLGSNResetImpact extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return
      !arg0.isEmpty() &&
      arg0.stream()
        .map(DSemanticDecorator.class::cast)
        .map(DSemanticDecorator::getTarget)
        .anyMatch(o -> o instanceof PLGSNArgumentElement e &&
                       !e.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()).isEmpty());
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plMmodelObj = arg0.stream()
      .map(DSemanticDecorator.class::cast)
      .map(DSemanticDecorator::getTarget)
      .filter(o -> o instanceof PLGSNArgumentElement)
      .map(PLGSNArgumentElement.class::cast)
      .findFirst().get();
    var productLine = plMmodelObj.getProductLine();
    var sSession = SessionManager.INSTANCE.getSession(productLine);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLGSNResetImpactCommand(sDomain, productLine));
  }

  private class PLGSNResetImpactCommand extends RecordingCommand {
    ProductLine productLine;

    public PLGSNResetImpactCommand(TransactionalEditingDomain domain, ProductLine productLine) {
      super(domain);
      this.productLine = productLine;
    }

    @Override
    protected void doExecute() {
      List.copyOf(this.productLine.getClasses()).stream()
        .filter(c -> c instanceof PLGSNArgumentElement)
        .forEach(e -> e.getReference(GSNPackage.eINSTANCE.getArgumentElement_Status()).forEach(Class::delete));
      ChangeStep.getProperties().clear();
    }
  }
}
