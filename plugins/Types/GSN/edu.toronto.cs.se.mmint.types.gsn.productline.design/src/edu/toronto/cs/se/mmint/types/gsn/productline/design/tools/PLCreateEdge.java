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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLCreateEdge extends AbstractExternalJavaAction {

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
    sDomain.getCommandStack().execute(new PLCreateEdgeCommand(sDomain, srcClass, tgtClass, classType));
  }

  private class PLCreateEdgeCommand extends RecordingCommand {
    private Class srcClass;
    private Class tgtClass;
    private String classType;

    public PLCreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain);
      this.srcClass = srcClass;
      this.tgtClass = tgtClass;
      this.classType = classType;
    }

    @Override
    protected void doExecute() {
      var productLine = this.srcClass.getProductLine();
      String pc = null;
      try {
        var reasoner = productLine.getReasoner();
        pc = productLine.getReasoner().simplify(
          reasoner.and(this.srcClass.getPresenceCondition(), this.tgtClass.getPresenceCondition()));
      }
      catch (MMINTException e) {
        // pc == null
      }
      var edgeClass = ProductLineFactory.eINSTANCE.createClass();
      edgeClass.setType((EClass) GSNPackage.eINSTANCE.getEClassifier(this.classType));
      edgeClass.setPresenceCondition(pc);
      productLine.getClasses().add(edgeClass);
      var srcReference = ProductLineFactory.eINSTANCE.createReference();
      var srcReferenceType = switch (this.classType) {
        case "SupportedBy" -> GSNPackage.eINSTANCE.getSupportable_SupportedBy();
        case "InContextOf" -> GSNPackage.eINSTANCE.getContextualizable_InContextOf();
        default -> null;
      };
      srcReference.setType(srcReferenceType);
      srcReference.setTarget(edgeClass);
      srcReference.setPresenceCondition(pc);
      this.srcClass.getReferences().add(srcReference);
      var tgtReference = ProductLineFactory.eINSTANCE.createReference();
      var tgtReferenceType = switch (this.classType) {
        case "SupportedBy" -> GSNPackage.eINSTANCE.getSupportedBy_Target();
        case "InContextOf" -> GSNPackage.eINSTANCE.getInContextOf_Context();
        default -> null;
      };
      tgtReference.setType(tgtReferenceType);
      tgtReference.setTarget(this.tgtClass);
      tgtReference.setPresenceCondition(pc);
      edgeClass.getReferences().add(tgtReference);
    }
  }
}
