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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.util.PLBuilder;

public abstract class CreateEdge extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var classType = (String) arg1.get("classType");
    var src = (Class) arg1.get("source");
    var tgt = (Class) arg1.get("target");
    var sSession = SessionManager.INSTANCE.getSession(src);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(getCommand(sDomain, src, tgt, classType));
  }

  protected abstract Command getCommand(TransactionalEditingDomain domain, Class src, Class tgt, String classType);

  protected abstract class CreateEdgeCommand extends RecordingCommand {
    protected ProductLine pl;
    protected Class src;
    protected Class tgt;
    protected EClass type;
    protected PLBuilder builder;

    public CreateEdgeCommand(TransactionalEditingDomain domain, Class src, Class tgt, String classType) {
      super(domain);
      this.pl = src.getProductLine();
      this.src = src;
      this.tgt = tgt;
      this.type = (EClass) this.pl.getMetamodel().getEClassifier(classType);
    }

    @Override
    protected void doExecute() {
      this.builder.connect(this.type, this.src, this.tgt);
    }
  }
}
