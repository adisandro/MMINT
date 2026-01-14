/*******************************************************************************
 * Copyright (c) 2024, 2026 Alessio Di Sandro.
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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;
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
    var type = (String) arg1.get("type");
    var src = (Class) arg1.get("source");
    var tgt = (Class) arg1.get("target");
    var sSession = SessionManager.INSTANCE.getSession(src);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(getCommand(sDomain, src, tgt, type));
  }

  protected abstract Command getCommand(TransactionalEditingDomain domain, Class src, Class tgt, String type);

  protected abstract class CreateEdgeCommand extends RecordingCommand {
    protected ProductLine pl;
    protected Class src;
    protected Class tgt;
    protected EClass classType;
    protected @Nullable EReference relType;
    protected PLBuilder builder;

    public CreateEdgeCommand(TransactionalEditingDomain domain, Class src, Class tgt, String type) {
      super(domain);
      this.pl = src.getProductLine();
      this.src = src;
      this.tgt = tgt;
      var i = type.indexOf(".");
      if (i < 0) {
        this.classType = (EClass) this.pl.getMetamodel().getEClassifier(type);
        this.relType = null;
      }
      else {
        this.classType = (EClass) this.pl.getMetamodel().getEClassifier(type.substring(0, i));
        this.relType = (EReference) this.classType.getEStructuralFeature(type.substring(i+1));
      }
    }

    @Override
    protected void doExecute() {
      if (this.relType == null) {
        this.builder.connect(this.classType, this.src, this.tgt);
      }
      else {
        this.builder.connect(this.relType, this.src, this.tgt);
      }
    }
  }
}
