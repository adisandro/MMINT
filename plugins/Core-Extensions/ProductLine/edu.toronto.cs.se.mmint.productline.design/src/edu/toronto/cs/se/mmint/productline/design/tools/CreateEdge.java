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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public abstract class CreateEdge extends AbstractExternalJavaAction {

  protected abstract Command getCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass,
                                        String classType);

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var srcClass = (Class) arg1.get("source");
    var tgtClass = (Class) arg1.get("target");
    var classType = (String) arg1.get("classType");
    var sSession = SessionManager.INSTANCE.getSession(srcClass);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(getCommand(sDomain, srcClass, tgtClass, classType));
  }

  protected abstract class CreateEdgeCommand extends RecordingCommand {
    protected ProductLine productLine;
    protected Class srcClass;
    protected Class tgtClass;
    protected String classType;

    public CreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain);
      this.productLine = srcClass.getProductLine();
      this.srcClass = srcClass;
      this.tgtClass = tgtClass;
      this.classType = classType;
    }

    protected abstract @Nullable EReference getSrcReferenceType();

    protected abstract @Nullable EReference getTgtReferenceType();

    @Override
    protected void doExecute() {
      String pc = null;
      try {
        var reasoner = this.productLine.getReasoner();
        pc = this.productLine.getReasoner().simplify(
          reasoner.and(this.srcClass.getPresenceCondition(), this.tgtClass.getPresenceCondition()));
      }
      catch (MMINTException e) {
        // pc == null
      }
      var edgeClass = PLFactory.eINSTANCE.createClass();
      edgeClass.setType((EClass) this.productLine.getMetamodel().getEClassifier(this.classType));
      edgeClass.setPresenceCondition(pc);
      this.productLine.getClasses().add(edgeClass);
      var srcReference = PLFactory.eINSTANCE.createReference();
      srcReference.setType(getSrcReferenceType());
      srcReference.setTarget(edgeClass);
      srcReference.setPresenceCondition(pc);
      this.srcClass.getReferences().add(srcReference);
      var tgtReference = PLFactory.eINSTANCE.createReference();
      tgtReference.setType(getTgtReferenceType());
      tgtReference.setTarget(this.tgtClass);
      tgtReference.setPresenceCondition(pc);
      edgeClass.getReferences().add(tgtReference);
    }
  }
}
