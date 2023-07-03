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
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

public class InstantiateTemplate extends AbstractExternalJavaAction {

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
      var templatePath = MIDDialogs.selectFiles("Instantiate Template", "Select GSN template file",
                                                "There are no GSN files in the workspace", Set.of(GSNPackage.eNAME));
      var templateSafetyCase = (SafetyCase) EcoreUtil.copy(FileUtils.readModelFile(templatePath, null, true));
      if (templateSafetyCase.getTemplates().isEmpty()) {
        throw new MMINTException(templatePath + " does not contain a template");
      }
      var template = templateSafetyCase.getTemplates().get(0);
      var builder = template.instantiate(safetyCase, ECollections.toEList(selection));
      // instantiation does not make changes to the safety case, the builder will commit those changes in the command
      // this is done because some features (e.g. querying) would not work properly in a command
      sDomain.getCommandStack().execute(new InstantiateTemplateCommand(sDomain, template, builder));
    }
    catch (MIDDialogCancellation e) {
      // template file selection cancelled
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Error instantiating template", e);
    }
  }

  private class InstantiateTemplateCommand extends RecordingCommand {
    Template template;
    GSNBuilder builder;

    public InstantiateTemplateCommand(TransactionalEditingDomain domain, Template template, GSNBuilder builder) {
      super(domain);
      this.template = template;
      this.builder = builder;
    }

    @Override
    protected void doExecute() {
      this.builder.commitChanges();
      try {
        this.template.validate();
        //TODO Delete links and delete template
        //TODO Repair framework should be refined
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "The template instantiation is not valid", e);
      }
    }
  }
}
