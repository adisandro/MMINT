/*******************************************************************************
 * Copyright (c) 2026, 2026 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.fta.productline.util;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.util.PLBuilder;
import edu.toronto.cs.se.mmint.types.fta.FTAPackage;
import edu.toronto.cs.se.mmint.types.fta.GateLogic;

public class PLFTABuilder extends PLBuilder {
  protected FTAPackage fta;

  public PLFTABuilder(ProductLine pl) {
    super(pl);
    this.fta = FTAPackage.eINSTANCE;
  }

  @Override
  public @Nullable EReference getContainmentType(Class clazz) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.fta.getEvent()) -> this.fta.getFaultTree_Events();
      case Class c when c.instanceOf(this.fta.getGate()) -> this.fta.getEvent_Gate();
      default -> super.getContainmentType(clazz);
    };
  }

  @Override
  public Class create(EClass type, Map<EAttribute, String> attrValues, @Nullable Class container, @Nullable String pc) {
    var clazz = super.create(type, attrValues, container, pc);
    if (!attrValues.containsKey(this.fta.getGate_Logic()) && clazz.instanceOf(this.fta.getGate())) {
      clazz.setAttribute(this.fta.getGate_Logic(), GateLogic.AND.toString());
    }

    return clazz;
  }
}
