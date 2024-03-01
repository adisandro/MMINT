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
package edu.toronto.cs.se.mmint.types.gsn.productline.design.tools;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLCreateGoal extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var productLine = (ProductLine) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(productLine);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLCreateGoalCommand(sDomain, productLine));
  }

  private class PLCreateGoalCommand extends RecordingCommand {
    private ProductLine productLine;

    public PLCreateGoalCommand(TransactionalEditingDomain domain, ProductLine productLine) {
      super(domain);
      this.productLine = productLine;
    }

    @Override
    protected void doExecute() {
      var safetyCase = this.productLine.getClasses().stream()
        .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
        .findFirst().get();
      var clazz = ProductLineFactory.eINSTANCE.createClass();
      clazz.setType(GSNPackage.eINSTANCE.getGoal());
      this.productLine.getClasses().add(clazz);
      var reference = ProductLineFactory.eINSTANCE.createReference();
      reference.setType(GSNPackage.eINSTANCE.getSafetyCase_Goals());
      reference.setTarget(clazz);
      safetyCase.getReferences().add(reference);
      for (var attrType : GSNPackage.eINSTANCE.getGoal().getEAllAttributes()) {
        var attribute = ProductLineFactory.eINSTANCE.createAttribute();
        attribute.setType(attrType);
        clazz.getAttributes().add(attribute);
      }
    }
  }
}
