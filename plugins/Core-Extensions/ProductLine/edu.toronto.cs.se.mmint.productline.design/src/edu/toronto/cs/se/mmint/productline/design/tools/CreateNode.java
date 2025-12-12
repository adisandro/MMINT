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
package edu.toronto.cs.se.mmint.productline.design.tools;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.util.PLBuilder;

public abstract class CreateNode extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var container = arg0.iterator().next();
    var classType = (String) arg1.get("classType");
    var sSession = SessionManager.INSTANCE.getSession(container);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(getCommand(sDomain, container, classType));
  }

  protected abstract CreateNodeCommand getCommand(TransactionalEditingDomain domain, EObject container,
                                                  String classType);

  protected class CreateNodeCommand extends RecordingCommand {
    protected ProductLine pl;
    protected @Nullable Class container;
    protected EClass type;
    protected PLBuilder builder;

    public CreateNodeCommand(TransactionalEditingDomain domain, EObject container, String classType) {
      super(domain);
      this.pl = (container instanceof ProductLine pl) ? pl : ((Class) container).getProductLine();
      this.container = (container instanceof ProductLine) ? null : (Class) container;
      this.type = (EClass) this.pl.getMetamodel().getEClassifier(classType);
    }

    @Override
    protected void doExecute() {
      this.builder.create(this.type, this.container);
    }
  }
}
