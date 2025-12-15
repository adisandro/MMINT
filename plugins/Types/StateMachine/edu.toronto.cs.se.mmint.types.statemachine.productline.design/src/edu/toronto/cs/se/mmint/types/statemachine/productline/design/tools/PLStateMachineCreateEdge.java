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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.design.tools.CreateEdge;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class PLStateMachineCreateEdge extends CreateEdge {

  @Override
  protected Command getCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
    return new PLCreateEdgeCommand(domain, srcClass, tgtClass, classType);
  }

  protected class PLCreateEdgeCommand extends CreateEdgeCommand {
    private StateMachinePackage sm;

    public PLCreateEdgeCommand(TransactionalEditingDomain domain, Class srcClass, Class tgtClass, String classType) {
      super(domain, srcClass, tgtClass, classType);
      this.sm = StateMachinePackage.eINSTANCE;
    }

    @Override
    protected @Nullable RefSpec getContainerSpec(Class edgeClass) {
      return switch (this.type) {
        case EClass e when this.sm.getTransition().isSuperTypeOf(e) ->
          new RefSpec(this.pl.getRoot(), this.sm.getStateMachine_Transitions(),
                      edgeClass);
        default -> null;
      };
    }

    @Override
    protected @Nullable RefSpec getSrcSpec(Class edgeClass) {
      return switch (this.type) {
        case EClass e when this.sm.getTransition().isSuperTypeOf(e) ->
          new RefSpec(edgeClass, this.sm.getTransition_Source(), this.srcClass);
        default -> null;
      };
    }

    @Override
    protected @Nullable RefSpec getTgtSpec(Class edgeClass) {
      return switch (this.type) {
        case EClass e when this.sm.getTransition().isSuperTypeOf(e) ->
          new RefSpec(edgeClass, this.sm.getTransition_Target(), this.tgtClass);
        default -> null;
      };
    }
  }
}
