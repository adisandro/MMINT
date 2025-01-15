/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class CreatePropertyDecompositionStrategy extends CreateTemplateElement {

  @Override
  protected CreateTemplateElementCommand createCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
    return new CreatePropertyStrategyCommand(domain, safetyCase);
  }

  private class CreatePropertyStrategyCommand extends CreateTemplateElementCommand {

    public CreatePropertyStrategyCommand(TransactionalEditingDomain domain, SafetyCase safetyCase) {
      super(domain, new GSNTemplatesBuilder(safetyCase));
    }

    @Override
    protected void create() throws Exception {
      var builder = (GSNTemplatesBuilder) this.builder;
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition", null);
      var reasonerName = reasoner.getName();
      var property = builder.createProperty("Create Property Decomposition Strategy",
                                            "Insert the property", "Insert a description for the custom property");
      builder.createPropertyStrategy("", "'" + property.getInformal() + "'", reasonerName, property);
    }
  }
}
