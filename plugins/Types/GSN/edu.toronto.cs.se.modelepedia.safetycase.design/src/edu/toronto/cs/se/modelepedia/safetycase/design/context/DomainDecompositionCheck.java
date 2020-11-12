/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.modelepedia.safetycase.DomainDecompositionStrategy;

public class DomainDecompositionCheck extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (modelObj instanceof DomainDecompositionStrategy) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var strategy = (DomainDecompositionStrategy) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    var title = "Domain Decomposition Check";
    try {
      strategy.validate();
      MessageDialog.openInformation(shell, title, "The domain decomposition is correct");
    }
    catch (MMINTException e) {
      MessageDialog.openError(shell, title, "The domain decomposition is incorrect:\n" + e.getMessage());
    }
  }

}
