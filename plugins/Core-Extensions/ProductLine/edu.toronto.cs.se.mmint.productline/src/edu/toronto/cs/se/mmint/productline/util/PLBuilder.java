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
package edu.toronto.cs.se.mmint.productline.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public abstract class PLBuilder {
  protected ProductLine pl;
  protected PLFactory plF;

  public PLBuilder(ProductLine pl) {
    this.pl = pl;
    this.plF = PLFactory.eINSTANCE;
  }

  protected abstract @Nullable EReference getContainmentType(Class clazz);

  protected Class createClass(EClass type) {
    return this.plF.createClass();
  }

  public Class create(EClass type, @Nullable Class container, @Nullable String pc) {
    if (container == null) {
      container = this.pl.getRoot();
    }
    if (pc == null) {
      try {
        pc = this.pl.getReasoner().getTrueLiteral();
      }
      catch (MMINTException e) {
        // leave null, will default to true when a reasoner is assigned
      }
    }
    var clazz = createClass(type);
    clazz.setType(type);
    clazz.setPresenceCondition(pc);
    this.pl.getClasses().add(clazz);
    container.addReference(getContainmentType(clazz), clazz);
    for (var attrType : type.getEAllAttributes()) {
      clazz.addAttribute(attrType, null);
    }

    return clazz;
  }

  public Class create(EClass type, @Nullable Class container) {
    return create(type, container, null);
  }

  public Class create(EClass type) {
    return create(type, null, null);
  }
}
