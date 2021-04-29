/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLineFactory;

public class CreateAttribute extends AbstractExternalJavaAction {

  private EAttribute[] getAttributes(Class clazz) {
    return clazz.getType().getEAllAttributes().stream()
    .filter(a -> !a.isDerived())
    .toArray(EAttribute[]::new);
  }

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    var clazz = (Class) arg0.iterator().next();
    return getAttributes(clazz).length != 0;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var clazz = (Class) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(clazz);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateAttributeCommand(sDomain, clazz));
  }

  private class CreateAttributeCommand extends RecordingCommand {
    private Class clazz;

    public CreateAttributeCommand(TransactionalEditingDomain domain, Class clazz) {
      super(domain);
      this.clazz = clazz;
    }

    @Override
    protected void doExecute() {
      try {
        var labelProvider = LabelProvider.createTextProvider(c -> ((EAttribute) c).getName());
        var contentProvider = new ArrayContentProvider();
        var type = MIDDialogs.<EAttribute>openListDialog("Create Attribute", "Select Attribute",
                                                         getAttributes(this.clazz), contentProvider, labelProvider);
        var attribute = ProductLineFactory.eINSTANCE.createAttribute();
        attribute.setType(type);
        this.clazz.getAttributes().add(attribute);
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
    }
  }
}
