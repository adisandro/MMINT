/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class PropertyDecompositionRepair extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (modelObj instanceof PropertyGoal propGoal && !propGoal.isValid()) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var invalidGoal = (PropertyGoal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(invalidGoal);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PropertyDecompositionRepairCommand(sDomain, invalidGoal));
  }

  private class PropertyDecompositionRepairCommand extends RecordingCommand {
    private PropertyGoal invalidGoal;

    public PropertyDecompositionRepairCommand(TransactionalEditingDomain domain, PropertyGoal invalidGoal) {
      super(domain);
      this.invalidGoal = invalidGoal;
    }

    @Override
    protected void doExecute() {
      var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
      try {
        var strategy = (PropertyDecompositionStrategy) DecompositionUtils.moveOneStrategyUp(this.invalidGoal);
        var reasonerName = strategy.getReasonerName();
        var reasoner = MMINT.getReasoner(reasonerName);
        var hint = this.invalidGoal.getHint();
        if (hint == null || hint.isBlank()) {
          // ask for new template
          var relatedModelOpt = DecompositionUtils.getRelatedModel(this.invalidGoal);
        }
        else {
          // replace formal property with hint
          this.invalidGoal.getProperty().setFormal(hint);
          this.invalidGoal.setHint(null);
        }
        var proofLinks = strategy.getInContextOf().stream()
          .filter(c -> c.getContext().getDescription().contains(reasonerName))
          .collect(Collectors.toSet());
        var proofs = proofLinks.stream()
          .map(c -> c.getContext())
          .collect(Collectors.toSet());
        strategy.getInContextOf().removeAll(proofLinks);
        ((SafetyCase) strategy.eContainer()).getJustifications().removeAll(proofs);
        var title = "Property Decomposition Repair";
        strategy.validate();
        this.invalidGoal.setValid(true);
        MessageDialog.openInformation(shell, title, "The property decomposition has been repaired and is now valid");
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "The property decomposition is still invalid", e);
      }
    }
  }
}
