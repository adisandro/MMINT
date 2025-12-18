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

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;

public class PLBuilder {
  protected ProductLine pl;
  protected PLFactory plF;

  public PLBuilder(ProductLine pl) {
    this.pl = pl;
    this.plF = PLFactory.eINSTANCE;
  }

  public @Nullable EReference getContainmentType(Class clazz) {
    return null;
  }
  protected @Nullable Class getContainerFromSrcTgt(Class clazz, Class src, Class tgt) {
    return null;
  }
  protected @Nullable EReference getSrcReferenceType(Class clazz) {
    return null;
  }
  protected @Nullable EReference getTgtReferenceType(Class clazz) {
    return null;
  }

  protected Class _createClass(EClass type) {
    return this.plF.createClass();
  }

  public Class createClass(EClass type) {
    var clazz = _createClass(type);
    clazz.setType(type);

    return clazz;
  }

  protected void create(Class clazz, EClass type, Map<EAttribute, String> attrValues, @Nullable Class container,
                        @Nullable String pc) {
    pc = (container == null) ?
      this.pl.getPresenceConditionOrDefault(pc) :
      this.pl.mergePresenceConditions(pc, container.getPresenceCondition());
    clazz.setPresenceCondition(pc);
    this.pl.getClasses().add(clazz);
    for (var attrType : type.getEAllAttributes()) {
      if (attrType.isDerived() || attrType.isTransient()) {
        continue;
      }
      clazz.addAttribute(attrType, attrValues.get(attrType)); // values default to null if not explicitly passed
    }
    if (container != null) {
      container.addReference(getContainmentType(clazz), clazz, pc);
    }
  }

  /**
   * Creates a PL class.
   *
   * @param type
   *          The class type.
   * @param attrValues
   *          The values to initialize the class attributes, null is assigned for the missing ones.
   * @param container
   *          The container of the class, can be null to create a dangling class.
   * @param pc
   *          The presence condition of the class, can be null to assign the presence condition of the container, or to
   *          fallback to the True literal with no container.
   * @return The PL class.
   */
  public Class create(EClass type, Map<EAttribute, String> attrValues, @Nullable Class container, @Nullable String pc) {
    var clazz = createClass(type);
    create(clazz, type, attrValues, container, pc);

    return clazz;
  }

  public Class create(EClass type, @Nullable Class container, @Nullable String pc) {
    return create(type, Map.of(), container, pc);
  }

  public Class create(EClass type, Map<EAttribute, String> attrValues, @Nullable Class container) {
    return create(type, attrValues, container, null);
  }

  public Class create(EClass type, @Nullable Class container) {
    return create(type, Map.of(), container, null);
  }

  public Class create(EClass type, Map<EAttribute, String> attrValues, @Nullable String pc) {
    return create(type, attrValues, null, pc);
  }

  public Class create(EClass type, @Nullable String pc) {
    return create(type, Map.of(), null, pc);
  }

  public Class create(EClass type, Map<EAttribute, String> attrValues) {
    return create(type, attrValues, null, null);
  }

  public Class create(EClass type) {
    return create(type, Map.of(), null, null);
  }

  public Class connect(EClass type, Class src, Class tgt, @Nullable String pc) {
    var clazz = createClass(type);
    var container = getContainerFromSrcTgt(clazz, src, tgt);
    var pcConn = this.pl.mergePresenceConditions(src.getPresenceCondition(), tgt.getPresenceCondition());
    pc = this.pl.mergePresenceConditions(pc, pcConn);
    create(clazz, type, Map.of(), container, pc);
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
