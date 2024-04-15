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

import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
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
    var plSupport = this.plFactory.createClass();
    this.productLine.getClasses().add(plSupport);
    plSupportable.addReference(GSNPackage.eINSTANCE.getSupportable_SupportedBy(), plSupport);
    plSupporter.addReference(GSNPackage.eINSTANCE.getSupporter_Supports(), plSupport);
  }

  public void addArgumentElement(GSNPLArgumentElement plArgument, String id, String description) {
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Id(), id);
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Description(), description);
    plArgument.addAttribute(GSNPackage.eINSTANCE.getArgumentElement_Valid(), Boolean.TRUE.toString());
  }

  public void addGoal(GSNPLArgumentElement plGoal, String id, String description) {
    addArgumentElement(plGoal, id, description);
    this.productLine.getClasses().add(plGoal);
  }

  public GSNPLArgumentElement createGoal(String id, String description) {
    var plGoal = this.gsnPLfactory.createGSNPLArgumentElement();
    plGoal.setType(GSNPackage.eINSTANCE.getGoal());
    addGoal(plGoal, id, description);

    return plGoal;
  }
}
