/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.design.tools;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class CreatePropertyGoal extends CreateDecompositionElement {

  @Override
  protected CreateDecompositionElementCommand createCommand(TransactionalEditingDomain domain,
                                                            SafetyCase gsnRootModelObj) {
    return new CreatePropertyGoalCommand(domain, gsnRootModelObj);
  }

  private class CreatePropertyGoalCommand extends CreateDecompositionElementCommand {

    public CreatePropertyGoalCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
      super(domain, new GSNTemplatesBuilder(gsnRootModelObj));
    }

    @Override
    protected void create() throws Exception {
      var builder = (GSNTemplatesBuilder) this.builder;
      var property = builder.createProperty("Create Property Goal", "Insert the property",
                                            "Insert a description for the custom property");
      builder.createPropertyGoal("", property.getInformal(), property);
    }
  }
}
