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
package edu.toronto.cs.se.mmint.productline.design.tools;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.Reference;

public class EditPresenceCondition extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var plModelObj = (PLElement) arg0.iterator().next();
    var newPresenceCondition = (String) arg1.get("newPresenceCondition");
    var sSession = SessionManager.INSTANCE.getSession(plModelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new EditPresenceConditionCommand(sDomain, plModelObj, newPresenceCondition));
  }

  private class EditPresenceConditionCommand extends RecordingCommand {
    private PLElement plModelObj;
    private String newPresenceCondition;

    public EditPresenceConditionCommand(TransactionalEditingDomain domain, PLElement plModelObj,
                                        String newPresenceCondition) {
      super(domain);
      this.plModelObj = plModelObj;
      this.newPresenceCondition = newPresenceCondition;
    }

    @Override
    protected void doExecute() {
      var pl = this.plModelObj.getProductLine();
      var featuresConstraint = pl.getFeaturesConstraint();
      try {
        var plReasoner = pl.getReasoner();
        var presenceConditions = new HashSet<String>();
        presenceConditions.add(this.newPresenceCondition);
        //TODO MMINT[JAVA21] Convert to switch with pattern matching
        if (this.plModelObj instanceof Attribute plAttr) {
          presenceConditions.add(((Class) plAttr.eContainer()).getPresenceCondition());
        }
        else if (this.plModelObj instanceof Reference plRef) {
          presenceConditions.add(plRef.getSource().getPresenceCondition());
          presenceConditions.add(plRef.getTarget().getPresenceCondition());
        }
        if (!plReasoner.checkConsistency(featuresConstraint, presenceConditions)) {
          MMINTException.print(IStatus.WARNING, "The new presence condition is not satisfiable", null);
        }
      }
      catch (MMINTException e) {
        // skip check
      }

      this.plModelObj.setPresenceCondition(this.newPresenceCondition);
    }
  }
}
