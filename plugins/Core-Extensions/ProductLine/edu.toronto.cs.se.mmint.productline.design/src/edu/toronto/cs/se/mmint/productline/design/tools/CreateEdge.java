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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.PLElementImpl;

public abstract class CreateEdge extends AbstractExternalJavaAction {

  protected abstract Command getCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass,
                                        String classType);

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var classType = (String) arg1.get("classType");
    var srcClass = (Class) arg1.get("source");
    var tgtClass = (Class) arg1.get("target");
    var sSession = SessionManager.INSTANCE.getSession(srcClass);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(getCommand(sDomain, srcClass, tgtClass, classType));
  }

  protected abstract class CreateEdgeCommand extends RecordingCommand {
    public record RefSpec(Class owner, EReference type, Class target) {};
    protected ProductLine productLine;
    protected Class srcClass;
    protected Class tgtClass;
    protected String classType;
    protected EPackage types;

    public CreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain);
      this.productLine = srcClass.getProductLine();
      this.srcClass = srcClass;
      this.tgtClass = tgtClass;
      this.classType = classType;
    }

    protected abstract @Nullable RefSpec getContainerSpec(Class edgeClass);

    protected abstract @Nullable RefSpec getSrcSpec(Class edgeClass);

    protected abstract @Nullable RefSpec getTgtSpec(Class edgeClass);

    private void createReference(RefSpec refSpec, String pc) {
      var reference = PLFactory.eINSTANCE.createReference();
      reference.setType(refSpec.type());
      reference.setTarget(refSpec.target());
      reference.setPresenceCondition(pc);
      refSpec.owner().getReferences().add(reference);
    }

    @Override
    protected void doExecute() {
      var pc = PLElementImpl.merge(this.productLine, this.srcClass.getPresenceCondition(),
                                   this.tgtClass.getPresenceCondition());
      var edgeClass = PLFactory.eINSTANCE.createClass();
      edgeClass.setType((EClass) this.productLine.getMetamodel().getEClassifier(this.classType));
      edgeClass.setPresenceCondition(pc);
      this.productLine.getClasses().add(edgeClass);
      var containerSpec = getContainerSpec(edgeClass);
      if (containerSpec != null) {
        createReference(containerSpec, pc);
      }
      var srcSpec = getSrcSpec(edgeClass);
      if (srcSpec != null) {
        createReference(srcSpec, pc);
      }
      var tgtSpec = getTgtSpec(edgeClass);
      if (tgtSpec != null) {
        createReference(tgtSpec, pc);
      }
    }
  }
}
