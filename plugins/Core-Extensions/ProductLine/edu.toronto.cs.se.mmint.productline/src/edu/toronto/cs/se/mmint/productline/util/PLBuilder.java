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

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public abstract class PLBuilder {
  protected ProductLine pl;
  protected PLFactory plF;

  public PLBuilder(ProductLine pl) {
    this.pl = pl;
    this.plF = PLFactory.eINSTANCE;
    //TODO we should also convert all operators to use it, e.g. ToProductLine
  }

  protected abstract @Nullable EReference getContainmentType(Class clazz);
  protected abstract @Nullable Class getContainerFromSrcTgt(Class clazz, Class src, Class tgt);
  protected abstract @Nullable EReference getSrcReferenceType(Class clazz);
  protected abstract @Nullable EReference getTgtReferenceType(Class clazz);

  protected Class createClass(EClass type) {
    return this.plF.createClass();
  }

  protected void create(Class clazz, EClass type, Class container, @Nullable String pc) {
    pc = this.pl.mergePresenceConditions(pc, container.getPresenceCondition());
    clazz.setType(type);
    clazz.setPresenceCondition(pc);
    this.pl.getClasses().add(clazz);
    container.addReference(getContainmentType(clazz), clazz, pc);
    for (var attrType : type.getEAllAttributes()) {
      if (attrType.isDerived() || attrType.isTransient()) {
        continue;
      }
      clazz.addAttribute(attrType, null);
    }
  }

  public Class create(EClass type, Class container, @Nullable String pc) {
    var clazz = createClass(type);
    create(clazz, type, container, pc);

    return clazz;
  }

  public Class create(EClass type, Class container) {
    return create(type, container, null);
  }

  public Class connect(EClass type, Class src, Class tgt, @Nullable String pc) {
    var clazz = createClass(type);
    var container = getContainerFromSrcTgt(clazz, src, tgt);
    var pcEdge = this.pl.mergePresenceConditions(src.getPresenceCondition(), tgt.getPresenceCondition());
    pc = this.pl.mergePresenceConditions(pc, pcEdge);
    create(clazz, type, container, pc);
    var srcRef = getSrcReferenceType(clazz);
    if (srcRef != null) {
      clazz.addReference(srcRef, src, clazz.getPresenceCondition());
    }
    var tgtRef = getTgtReferenceType(clazz);
    if (tgtRef != null) {
      clazz.addReference(tgtRef, tgt, clazz.getPresenceCondition());
    }

    return clazz;
  }

  public Class connect(EClass type, Class src, Class tgt) {
    return connect(type, src, tgt, null);
  }
}
