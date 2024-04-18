/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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

import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.PLElementImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class GSNPLBuilder {
  protected ProductLine productLine;
  protected PLFactory plFactory;
  protected GSNPLFactory gsnPLfactory;

  public GSNPLBuilder(ProductLine productLine) {
    this.productLine = productLine;
    this.plFactory = PLFactory.eINSTANCE;
    this.gsnPLfactory = GSNPLFactory.eINSTANCE;
  }

  public void addSupporter(GSNPLArgumentElement plSupportable, GSNPLArgumentElement plSupporter) {
    var pc = PLElementImpl.merge(this.productLine, plSupportable.getPresenceCondition(),
                                 plSupporter.getPresenceCondition());
    var plSupportedBy = this.plFactory.createClass();
    plSupportedBy.setType(GSNPackage.eINSTANCE.getSupportedBy());
    plSupportedBy.setPresenceCondition(pc);
    this.productLine.getClasses().add(plSupportedBy);
    plSupportedBy.addReference(GSNPackage.eINSTANCE.getSupportedBy_Source(), plSupportable, pc);
    plSupportedBy.addReference(GSNPackage.eINSTANCE.getSupportedBy_Target(), plSupporter, pc);
  }

  public void addArgumentElement(GSNPLArgumentElement plArgument, String id, String description) {
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id(), id);
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Description(), description);
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Valid(), Boolean.TRUE.toString());
  }

  public void addGoal(GSNPLArgumentElement plGoal, String id, String description) {
    this.productLine.getClasses().add(plGoal);
    addArgumentElement(plGoal, id, description);
  }

  public GSNPLArgumentElement createGoal(String id, String description, @Nullable String presenceCondition) {
    var plGoal = this.gsnPLfactory.createGSNPLArgumentElement();
    plGoal.setType(GSNPackage.eINSTANCE.getGoal());
    plGoal.setPresenceCondition(presenceCondition);
    addGoal(plGoal, id, description);

    return plGoal;
  }
}
