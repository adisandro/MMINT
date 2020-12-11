/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.design.PropertyBuilder;

public class PropertyDecomposition extends GoalDecomposition {

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(goal);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new PropertyDecompositionCommand(sDomain, goal));
  }

  private class PropertyDecompositionCommand extends GoalDecompositionCommand {

    public PropertyDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain, decomposed, new PropertyBuilder((SafetyCase) decomposed.eContainer()));
    }

    @Override
    protected Strategy decompose() throws Exception {
      /**TODO
       * P: Add support for specifying which language to use (reuse constraint code + validate existance of trait for language)
       * D: Turn overlap error into warning
       * D+P: Allow incorrect decomposition rather than preventing creation of all objects?
       * P: Add decomposition check
       */
      var builder = (PropertyBuilder) this.builder;
      // ask for input
      var title = "Property Decomposition";
      var message = "Insert the property";
      var property = MIDDialogs.getStringInput(title, message, null);
      var language = "Lean";
      message = "Insert the number of sub-properties";
      var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, message, null));
      // create stuff
      var id = this.decomposed.getId();
      var desc = this.decomposed.getDescription();
      var strategy1Id = "S1-" + id;
      var strategy1Desc = "Argument by " + language + " formalization";
      var strategy1 = builder.createBasicStrategy(strategy1Id, strategy1Desc);

      return strategy1;
    }
  }
}
