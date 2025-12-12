/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.statemachine.productline.design.tools;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import edu.toronto.cs.se.mmint.productline.design.tools.CreateNode;
import edu.toronto.cs.se.mmint.types.statemachine.productline.util.PLStateMachineBuilder;

public class PLStateMachineCreateNode extends CreateNode {
  @Override
  protected CreateNodeCommand getCommand(TransactionalEditingDomain domain, EObject container, String classType) {
    return new CreateNodeCommand(domain, container, classType) {
      {
        this.builder = new PLStateMachineBuilder(this.pl);
      }
    };
  }
}
