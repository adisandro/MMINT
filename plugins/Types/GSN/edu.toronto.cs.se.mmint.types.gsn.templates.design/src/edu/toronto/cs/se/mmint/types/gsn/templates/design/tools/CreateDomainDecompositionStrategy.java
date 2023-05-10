/*******************************************************************************
 * Copyright (c) 2020, 2023 Alessio Di Sandro.
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

import java.util.Set;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class CreateDomainDecompositionStrategy extends CreateDecompositionElement {

  @Override
  protected CreateDecompositionElementCommand createCommand(TransactionalEditingDomain domain,
                                                            SafetyCase gsnRootModelObj) {
    return new CreateDomainStrategyCommand(domain, gsnRootModelObj);
  }

  private class CreateDomainStrategyCommand extends CreateDecompositionElementCommand {

    public CreateDomainStrategyCommand(TransactionalEditingDomain domain, SafetyCase gsnRootModelObj) {
      super(domain, new GSNTemplatesBuilder(gsnRootModelObj));
    }

    @Override
    protected void create() throws Exception {
      var builder = (GSNTemplatesBuilder) this.builder;
      var domain = builder.createDomain("Create Domain Decomposition Strategy", "Insert the domain",
                                        Set.of(GSNTemplatesPackage.INT_DOMAIN, GSNTemplatesPackage.REAL_DOMAIN,
                                               GSNTemplatesPackage.ENUM_DOMAIN));
      builder.createDomainStrategy("", "", domain);
    }
  }
}
