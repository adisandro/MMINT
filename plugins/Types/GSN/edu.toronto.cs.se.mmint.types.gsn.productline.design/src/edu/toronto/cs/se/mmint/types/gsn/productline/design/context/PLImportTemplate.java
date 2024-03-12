/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.productline.design.context;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.operators.ToProductLine;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class PLImportTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.isEmpty()) {
      return false;
    }
    if (!(((DSemanticDecorator) arg0.iterator().next()).getTarget() instanceof ProductLine)) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var pl = (ProductLine) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(pl);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PLImportTemplateCommand(sDomain, pl));
  }

  private class PLImportTemplateCommand extends RecordingCommand {
    ProductLine pl;

    public PLImportTemplateCommand(TransactionalEditingDomain domain, ProductLine pl) {
      super(domain);
      this.pl = pl;
    }

    @Override
    protected void doExecute() {
      try {
        var templatePath = MIDDialogs.selectFile("Import Template", "Select GSN template file",
                                                  "There are no GSN files in the workspace", Set.of(GSNPackage.eNAME));
        var templateSC = (SafetyCase) FileUtils.readModelFile(templatePath, null, true);
        if (templateSC.getTemplates().isEmpty()) {
            throw new MMINTException(templatePath + " does not contain a template");
        }
        var template = (templateSC.getTemplates().size() > 1) ?
          MIDDialogs.selectModelObject("Import Template", "Select GSN template", templateSC.getTemplates()) :
          templateSC.getTemplates().get(0);
        var templateModel = MIDTypeRegistry.<Model>getType("http://se.cs.toronto.edu/modelepedia/GSN")
          .createInstance(templateSC, templatePath, null);
        var tpl = MIDTypeRegistry.<Operator>getType("edu.toronto.cs.se.mmint.productline.operators.ToProductLine");
        var properties = new Properties();
        properties.setProperty(ToProductLine.In.PROP_REASONERNAME, this.pl.getReasonerName());
        var tplOut = tpl.startInstance(tpl.checkAllowedInputs(ECollections.asEList(templateModel)), properties,
                                       ECollections.emptyEList(), Map.of(), null);
        var templatePL = (ProductLine) tplOut.getOutputsByName().get("productLine").getEMFInstanceRoot();
        var plSC = this.pl.getClasses().stream()
          .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
          .findFirst().get();
        var templatePLSC = templatePL.getClasses().stream()
          .filter(c -> c.getType() == GSNPackage.eINSTANCE.getSafetyCase())
          .findFirst().get();
        plSC.getReferences().addAll(templatePLSC.getReferences());
        templatePL.getClasses().remove(templatePLSC);
        this.pl.getClasses().addAll(templatePL.getClasses());
      }
      catch (MIDDialogCancellation e) {
        // template file selection cancelled
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Error importing GSN template", e);
      }
    }
  }
}
