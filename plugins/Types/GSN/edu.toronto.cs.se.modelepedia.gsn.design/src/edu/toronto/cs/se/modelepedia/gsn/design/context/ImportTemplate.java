/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public class ImportTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var selection = arg0.stream().map(d -> ((DSemanticDecorator) d).getTarget()).collect(Collectors.toList());
    var modelObj = selection.get(0);
    var safetyCase = (modelObj instanceof SafetyCase sc) ? sc : (SafetyCase) modelObj.eContainer();
    var sSession = SessionManager.INSTANCE.getSession(modelObj);
    var sDomain = sSession.getTransactionalEditingDomain();
    try {
      var templatePath = MIDDialogs.selectFiles("Import Template", "Select GSN template file",
                                                "There are no GSN files in the workspace", Set.of(GSNPackage.eNAME));
      var templateSC = (SafetyCase) FileUtils.readModelFile(templatePath, null, true);
      if (templateSC.getTemplates().isEmpty()) {
          throw new MMINTException(templatePath + " does not contain a template");
      }
      templateSC = EcoreUtil.copy(templateSC);
      var template = templateSC.getTemplates().get(0);
      var builder = template.import_(safetyCase, ECollections.toEList(selection));
      // do not make changes to the safety case here, the builder will later commit those changes in the command
      // the split is done because some features that could be needed here (e.g. querying) do not work in a command
      sDomain.getCommandStack().execute(new ImportTemplateCommand(sDomain, builder));
    }
    catch (MIDDialogCancellation e) {
      // template file selection cancelled
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Error importing GSN template", e);
    }
  }

  private class ImportTemplateCommand extends RecordingCommand {
    GSNBuilder builder;

    public ImportTemplateCommand(TransactionalEditingDomain domain, GSNBuilder builder) {
      super(domain);
      this.builder = builder;
    }

    @Override
    protected void doExecute() {
      this.builder.commitChanges();
    }
  }
}
