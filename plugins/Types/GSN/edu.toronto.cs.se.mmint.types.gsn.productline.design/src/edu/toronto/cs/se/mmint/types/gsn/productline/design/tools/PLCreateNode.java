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

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLCreateNode extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var productLine = (ProductLine) arg0.iterator().next();
    var classType = (String) arg1.get("classType");
    var sSession = SessionManager.INSTANCE.getSession(productLine);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLCreateNodeCommand(sDomain, productLine, classType));
  }

  private class PLCreateNodeCommand extends RecordingCommand {
    private ProductLine productLine;
    private String classType;
    private String referenceType;

    public PLCreateNodeCommand(TransactionalEditingDomain domain, ProductLine productLine, String classType) {
      super(domain);
      this.productLine = productLine;
      this.classType = classType;
    }

    @Override
    protected void doExecute() {
      var safetyCase = this.productLine.getClasses().stream()
        .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
        .findFirst().get();
      var clazz = ProductLineFactory.eINSTANCE.createClass();
      clazz.setType((EClass) GSNPackage.eINSTANCE.getEClassifier(this.classType));
      this.productLine.getClasses().add(clazz);
      var reference = ProductLineFactory.eINSTANCE.createReference();
      var referenceType = switch (this.classType) {
        case "Goal" -> GSNPackage.eINSTANCE.getSafetyCase_Goals();
        case "Strategy" -> GSNPackage.eINSTANCE.getSafetyCase_Strategies();
        case "Solution" -> GSNPackage.eINSTANCE.getSafetyCase_Solutions();
        case "Context" -> GSNPackage.eINSTANCE.getSafetyCase_Contexts();
        case "Justification" -> GSNPackage.eINSTANCE.getSafetyCase_Justifications();
        case "Assumption" -> GSNPackage.eINSTANCE.getSafetyCase_Assumptions();
        default -> null;
      };
      reference.setType(referenceType);
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
