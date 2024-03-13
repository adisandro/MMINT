/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogLabelProvider;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

public class CreateClass extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var productLine = (ProductLine) arg0.iterator().next();
    var sSession = SessionManager.INSTANCE.getSession(productLine);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateClassCommand(sDomain, productLine));
  }

  private class CreateClassCommand extends RecordingCommand {
    private ProductLine productLine;

    public CreateClassCommand(TransactionalEditingDomain domain, ProductLine productLine) {
      super(domain);
      this.productLine = productLine;
    }

    @Override
    protected void doExecute() {
      try {
        if (this.productLine.getMetamodel() == null) {
          var modelTypes = MIDTypeRegistry.getModelTypes().stream()
            .filter(m -> !(m instanceof ModelRel))
            .toArray(Model[]::new);
          var modelType = MIDDialogs.<Model>openListDialog("Init Product Line", "Select Product model type", modelTypes,
                                                           new ArrayContentProvider(), new MIDDialogLabelProvider());
          this.productLine.setMetamodel(modelType.getEMFTypeRoot());
        }
        if (this.productLine.getReasonerName() == null) {
          var plReasoner = MIDDialogs.selectReasoner(IPLFeaturesTrait.class, "Product Line features", null);
          this.productLine.setReasonerName(plReasoner.getName());
        }
        var labelProvider = LabelProvider.createTextProvider(c -> ((EClass) c).getName());
        var classes = this.productLine.getMetamodel().getEClassifiers().stream()
          .filter(c -> c instanceof EClass)
          .map(c -> (EClass) c)
          .filter(c -> !c.isAbstract() && !c.isInterface())
          .toArray(EClass[]::new);
        var type = MIDDialogs.<EClass>openListDialog("Create Class", "Select Class", classes,
                                                     new ArrayContentProvider(), labelProvider);
        var clazz = PLFactory.eINSTANCE.createClass();
        clazz.setType(type);
        this.productLine.getClasses().add(clazz);
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.ERROR, "Error initializing product line", e);
      }
    }
  }
}
