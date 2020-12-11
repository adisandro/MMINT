/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design;

import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;

public class PropertyBuilder extends GSNBuilder {

  public PropertyBuilder(SafetyCase gsnRootModelObj) {
    super(gsnRootModelObj);
  }

  public void addPropertyElement(PropertyDecompositionElement propertyElem, String language, String property) {
    propertyElem.setLanguage(language);
    propertyElem.setProperty(property);
  }

  public PropertyGoal createPropertyGoal(String id, String description, String language, String property) {
    var goal = this.factory.createPropertyGoal();
    addGoal(goal, id, description);
    addPropertyElement(goal, language, property);

    return goal;
  }

  public PropertyDecompositionStrategy createPropertyStrategy(String id, String description, String language,
                                                              String property) {
    var strategy = this.factory.createPropertyDecompositionStrategy();
    addStrategy(strategy, id, description);
    addPropertyElement(strategy, language, property);

    return strategy;
  }

  public void parsePropertyString(String propertyString) throws Exception {

  }
}
