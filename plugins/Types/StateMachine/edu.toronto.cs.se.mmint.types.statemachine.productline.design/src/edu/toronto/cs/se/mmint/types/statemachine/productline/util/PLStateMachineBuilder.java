/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.statemachine.productline.util;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.util.PLBuilder;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class PLStateMachineBuilder extends PLBuilder {
  protected StateMachinePackage sm;

  public PLStateMachineBuilder(ProductLine pl) {
    super(pl);
    this.sm = StateMachinePackage.eINSTANCE;
  }

  @Override
  public @Nullable EReference getContainmentType(Class clazz) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.sm.getAbstractState()) -> this.sm.getStateMachine_States();
      case Class c when c.instanceOf(this.sm.getStateAction()) -> this.sm.getState_InternalActions();
      case Class c when c.instanceOf(this.sm.getTransition()) -> this.sm.getStateMachine_Transitions();
      default -> super.getContainmentType(clazz);
    };
  }

  @Override
  protected @Nullable Class getContainerFromSrcTgt(Class clazz, Class src, Class tgt) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.sm.getTransition()) -> this.pl.getRoot();
      default -> super.getContainerFromSrcTgt(clazz, src, tgt);
    };
  }

  @Override
  protected @Nullable EReference getSrcReferenceType(Class clazz) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.sm.getTransition()) -> this.sm.getTransition_Source();
      default -> super.getSrcReferenceType(clazz);
    };
  }

  @Override
  protected @Nullable EReference getTgtReferenceType(Class clazz) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.sm.getTransition()) -> this.sm.getTransition_Target();
      default -> super.getTgtReferenceType(clazz);
    };
  }
}
