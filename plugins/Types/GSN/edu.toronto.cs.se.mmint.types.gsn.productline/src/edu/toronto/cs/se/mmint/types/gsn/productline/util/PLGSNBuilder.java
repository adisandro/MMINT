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
package edu.toronto.cs.se.mmint.types.gsn.productline.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.PLElementImpl;
import edu.toronto.cs.se.mmint.productline.util.PLBuilder;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNBuilder extends PLBuilder {
  protected GSNPackage gsn;
  protected PLGSNFactory gsnF;

  public PLGSNBuilder(ProductLine pl) {
    super(pl);
    this.gsn = GSNPackage.eINSTANCE;
    this.gsnF = PLGSNFactory.eINSTANCE;
  }

  @Override
  protected @Nullable EReference getContainmentType(Class clazz) {
    return switch (clazz) {
      case Class c when c.instanceOf(this.gsn.getGoal()) -> this.gsn.getSafetyCase_Goals();
      case Class c when c.instanceOf(this.gsn.getStrategy()) -> this.gsn.getSafetyCase_Strategies();
      case Class c when c.instanceOf(this.gsn.getSolution()) -> this.gsn.getSafetyCase_Solutions();
      case Class c when c.instanceOf(this.gsn.getContext()) -> this.gsn.getSafetyCase_Contexts();
      case Class c when c.instanceOf(this.gsn.getJustification()) -> this.gsn.getSafetyCase_Justifications();
      case Class c when c.instanceOf(this.gsn.getAssumption()) -> this.gsn.getSafetyCase_Assumptions();
      case Class c when c.instanceOf(this.gsn.getRelationshipDecorator()) -> this.gsn.getDecoratable_Decorators();
      default -> null;
    };
  }

  @Override
  protected Class createClass(EClass type) {
    return switch (type) {
      case EClass e when this.gsn.getRelationshipDecorator().isSuperTypeOf(e) ->
        this.gsnF.createPLGSNRelationshipDecorator();
      case EClass e when this.gsn.getArgumentElement().isSuperTypeOf(e) ->
        this.gsnF.createPLGSNArgumentElement();
      default -> super.createClass(type);
    };
  }

  @Override
  public Class create(EClass type, @Nullable Class container, @Nullable String pc) {
    var clazz = super.create(type, container, pc);
    clazz.setAttribute(this.gsn.getArgumentElement_Valid(), Boolean.TRUE.toString());

    return clazz;
  }

  public void addSupporter(PLGSNArgumentElement plSupportable, PLGSNArgumentElement plSupporter) {
    var pc = PLElementImpl.merge(this.pl, plSupportable.getPresenceCondition(),
                                 plSupporter.getPresenceCondition());
    var plSupportedBy = this.plF.createClass();
    plSupportedBy.setType(this.gsn.getSupportedBy());
    plSupportedBy.setPresenceCondition(pc);
    this.pl.getClasses().add(plSupportedBy);
    plSupportedBy.addReference(this.gsn.getSupportedBy_Source(), plSupportable, pc);
    plSupportedBy.addReference(this.gsn.getSupportedBy_Target(), plSupporter, pc);
  }
}
