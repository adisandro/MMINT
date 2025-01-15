/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class CreateTemplate extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return arg0.stream()
      .map(e -> ((DSemanticDecorator) e).getTarget())
      .filter(e -> e instanceof ArgumentElement)
      .count() > 0;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var templateElems = arg0.stream()
      .map(e -> ((DSemanticDecorator) e).getTarget())
      .filter(e -> e instanceof ArgumentElement)
      .map(e -> (ArgumentElement) e)
      .collect(Collectors.toList());
    var sSession = SessionManager.INSTANCE.getSession(templateElems.get(0));
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new CreateTemplateCommand(sDomain, templateElems));
  }

  private class CreateTemplateCommand extends RecordingCommand {
    List<ArgumentElement> templateElems;

    public CreateTemplateCommand(TransactionalEditingDomain domain, List<ArgumentElement> templateElems) {
      super(domain);
      this.templateElems = templateElems;
    }

    @Override
    protected void doExecute() {
      try {
        var id = MIDDialogs.getStringInput("Group as Template", "Insert template name", null);
        var template = GSNFactory.eINSTANCE.createTemplate();
        template.setId(id);
        template.getElements().addAll(this.templateElems);
        ((SafetyCase) this.templateElems.get(0).eContainer()).getTemplates().add(template);
      }
      catch (MIDDialogCancellation e) {
      }
    }
  }
}
