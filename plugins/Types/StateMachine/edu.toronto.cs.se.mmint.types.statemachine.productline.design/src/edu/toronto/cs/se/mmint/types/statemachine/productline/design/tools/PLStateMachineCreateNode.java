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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.design.tools.CreateNode;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class PLStateMachineCreateNode extends CreateNode {

  @Override
  protected Command getCommand(TransactionalEditingDomain domain, EObject container, String classType) {
    return new PLCreateNodeCommand(domain, container, classType);
  }

  protected class PLCreateNodeCommand extends CreateNodeCommand {

    public PLCreateNodeCommand(TransactionalEditingDomain domain, EObject container, String classType) {
      super(domain, container, classType);
    }

    @Override
    protected Class getContainer() {
      return switch (this.classType) {
        case EClass e when StateMachinePackage.eINSTANCE.getStateAction().isSuperTypeOf(e) -> (Class) this.container;
        default -> this.productLine.getRoot(StateMachinePackage.eINSTANCE.getStateMachine());
      };
    }

    @Override
    protected @Nullable EReference getContainmentType() {
      return switch (this.classType) {
        case EClass e when StateMachinePackage.eINSTANCE.getAbstractState().isSuperTypeOf(e) ->
          StateMachinePackage.eINSTANCE.getStateMachine_States();
        case EClass e when StateMachinePackage.eINSTANCE.getStateAction().isSuperTypeOf(e) ->
          StateMachinePackage.eINSTANCE.getState_InternalActions();
        default -> null;
      };
    }
  }
}
