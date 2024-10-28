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

import edu.toronto.cs.se.mmint.productline.Class;
import edu.toronto.cs.se.mmint.productline.PLFactory;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.impl.PLElementImpl;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNArgumentElement;
import edu.toronto.cs.se.mmint.types.gsn.productline.PLGSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;

public class PLGSNBuilder {
  protected ProductLine productLine;
  protected PLFactory plFactory;
  protected PLGSNFactory gsnPLfactory;
  protected GSNPackage gsnTypes;
  protected Class plSafetyCase;

  public PLGSNBuilder(ProductLine productLine) {
    this.productLine = productLine;
    this.plFactory = PLFactory.eINSTANCE;
    this.gsnPLfactory = PLGSNFactory.eINSTANCE;
    this.gsnTypes = GSNPackage.eINSTANCE;
    this.plSafetyCase = this.productLine.getRoot(this.gsnTypes.getSafetyCase());
  }

  public void addSupporter(PLGSNArgumentElement plSupportable, PLGSNArgumentElement plSupporter) {
    var pc = PLElementImpl.merge(this.productLine, plSupportable.getPresenceCondition(),
                                 plSupporter.getPresenceCondition());
    var plSupportedBy = this.plFactory.createClass();
    plSupportedBy.setType(this.gsnTypes.getSupportedBy());
    plSupportedBy.setPresenceCondition(pc);
    this.productLine.getClasses().add(plSupportedBy);
    plSupportedBy.addReference(this.gsnTypes.getSupportedBy_Source(), plSupportable, pc);
    plSupportedBy.addReference(this.gsnTypes.getSupportedBy_Target(), plSupporter, pc);
  }

  public void addArgumentElement(PLGSNArgumentElement plArgument, String id, String description) {
    plArgument.addAttribute(this.gsnTypes.getArgumentElement_Id(), id);
    plArgument.addAttribute(this.gsnTypes.getArgumentElement_Description(), description);
    plArgument.addAttribute(this.gsnTypes.getArgumentElement_Valid(), Boolean.TRUE.toString());
  }

  public void addGoal(PLGSNArgumentElement plGoal, String id, String description) {
    this.productLine.getClasses().add(plGoal);
    this.plSafetyCase.addReference(this.gsnTypes.getSafetyCase_Goals(), plGoal);
    addArgumentElement(plGoal, id, description);
  }

  public PLGSNArgumentElement createGoal(String id, String description, @Nullable String presenceCondition) {
    var plGoal = this.gsnPLfactory.createGSNPLArgumentElement();
    plGoal.setType(this.gsnTypes.getGoal());
    plGoal.setPresenceCondition(presenceCondition);
    addGoal(plGoal, id, description);

    return plGoal;
  }
}
