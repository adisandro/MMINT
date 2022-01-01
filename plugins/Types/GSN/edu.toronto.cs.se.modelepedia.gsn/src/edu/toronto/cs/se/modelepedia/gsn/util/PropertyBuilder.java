/*******************************************************************************
 * Copyright (c) 2020, 2022 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.util;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.Property;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class PropertyBuilder extends GSNBuilder {

  public PropertyBuilder(SafetyCase gsnRootModelObj) {
    super(gsnRootModelObj);
  }

  public void addPropertyElement(PropertyDecompositionElement propertyElem, String reasonerName, Property property) {
    propertyElem.setReasonerName(reasonerName);
    propertyElem.setProperty(property);
  }

  public Property createProperty(String title, String formalMessage, String informalMessage)
                                throws MIDDialogCancellation {
    var property = this.factory.createProperty();
    var formal = MIDDialogs.getBigStringInput(title, formalMessage, null);
    var informal = MIDDialogs.getStringInput(title, informalMessage, null);
    property.setFormal(formal);
    property.setInformal(informal);

    return property;
  }

  public PropertyGoal createPropertyGoal(String id, String description, String reasonerName, Property property) {
    var goal = this.factory.createPropertyGoal();
    addGoal(goal, id, description);
    addPropertyElement(goal, reasonerName, property);

    return goal;
  }

  public PropertyDecompositionStrategy createPropertyStrategy(String id, String description, String reasonerName,
                                                              Property property) {
    var strategy = this.factory.createPropertyDecompositionStrategy();
    addStrategy(strategy, id, description);
    addPropertyElement(strategy, reasonerName, property);

    return strategy;
  }
}
