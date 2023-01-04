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
package edu.toronto.cs.se.modelepedia.gsn.design.tools;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.modelepedia.gsn.util.PropertyBuilder;

public class CreatePropertyDecompositionStrategy extends CreateDecompositionElement {

  @Override
  protected CreateDecompositionElementCommand createCommand(TransactionalEditingDomain domain,
                                                            SafetyCase gsnRootModelObj) {
    return new CreatePropertyStrategyCommand(domain, gsnRootModelObj);
  }

  private class CreatePropertyStrategyCommand extends CreateDecompositionElementCommand {

    public CreatePropertyStrategyCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
      super(domain, new PropertyBuilder(gsnRootModelObj));
    }

    @Override
    protected void create() throws Exception {
      var builder = (PropertyBuilder) this.builder;
      var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition", null);
      var reasonerName = reasoner.getName();
      var property = builder.createProperty("Create Property Decomposition Strategy",
                                            "Insert the property", "Insert a description for the custom property");
      builder.createPropertyStrategy("", "'" + property.getInformal() + "'", reasonerName, property);
    }
  }
}
