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

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;

public abstract class CreateNode extends AbstractExternalJavaAction {

  protected abstract Command getCommand(TransactionalEditingDomain domain, EObject container, String classType);

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

  protected abstract class CreateNodeCommand extends RecordingCommand {
    protected ProductLine productLine;
    protected EObject container;
    protected String classType;

    public CreateNodeCommand(TransactionalEditingDomain domain, EObject container, String classType) {
      super(domain);
      this.productLine = (container instanceof ProductLine pl) ? pl : ((PLElement) container).getProductLine();
      this.container = container;
      this.classType = classType;
    }

    protected abstract Class getContainer();

    protected abstract @Nullable EReference getContainmentType();

    @Override
    protected void doExecute() {
      var classType = (EClass) this.productLine.getMetamodel().getEClassifier(this.classType);
      var clazz = ProductLineFactory.eINSTANCE.createClass();
      clazz.setType(classType);
      this.productLine.getClasses().add(clazz);
      var reference = ProductLineFactory.eINSTANCE.createReference();
      reference.setType(getContainmentType());
      reference.setTarget(clazz);
      getContainer().getReferences().add(reference);
      for (var attrType : classType.getEAllAttributes()) {
        var attribute = ProductLineFactory.eINSTANCE.createAttribute();
        attribute.setType(attrType);
        clazz.getAttributes().add(attribute);
      }
    }
  }
}
